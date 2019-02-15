package org.myg.pivottable.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JRootPane;
import javax.swing.border.Border;

import org.myg.pivottable.swing.cells.ICell;
import org.myg.pivottable.swing.layer.data.DefaultPivotTableData;
import org.myg.pivottable.swing.layer.focus.DefaultPivotTableFocus;
import org.myg.pivottable.swing.layer.header.DefaultPivotTableHeader;
import org.myg.pivottable.swing.layer.selection.DefaultPivotTableSelection;
import org.myg.pivottable.swing.model.header.ColumnPivotTableHeaderModel;
import org.myg.pivottable.swing.model.header.IPivotTableHeaderModel;
import org.myg.pivottable.swing.model.header.RowPivotTableHeaderModel;
import org.myg.pivottable.swing.model.selection.DefaultFocusModel;
import org.myg.pivottable.swing.model.selection.DefaultMonoSelectionModel;
import org.myg.pivottable.swing.model.selection.IFocusModel;
import org.myg.pivottable.swing.model.selection.ISelectionModel;
import org.myg.utils.NumberUtils;

import tests.CreateGraphCell;
/**
 * The <code> PivotTable <code/> is used to display a  two-dimensional tables
 * of cells.
 * @author GASTINEAU
 *
 */
public class PivotTable extends JRootPane implements ComponentListener {

	/** root container **/
	JLayeredPane layered = null; 
	private String name = null;
	private IPivotTableHeaderModel columnHeaderModel;
	private IPivotTableHeaderModel rowHeaderModel;
	private IFocusModel focusModel;
	private ISelectionModel selectionModel;
	public PivotTable(String name) {
		super();
		buildUI();
		addComponentListener(this);
		this.name = name;
		createModels();
		
	
	}
	public void createModels() {
		ColumnPivotTableHeaderModel model	 =	new ColumnPivotTableHeaderModel();
		model.addCell(CreateGraphCell.getGraph());
		setColumnHeaderModel(model);
		RowPivotTableHeaderModel rowModel	=	new RowPivotTableHeaderModel();
		rowModel.addCell(CreateGraphCell.getGraphRows());
		setRowHeaderModel(rowModel);
		setFocusModel(new DefaultFocusModel());
		setSelectionModel(new DefaultMonoSelectionModel());	
	}
	
	
	
	public IPivotTableHeaderModel getColumnHeaderModel() {
		return columnHeaderModel;
	}

	public void setColumnHeaderModel(IPivotTableHeaderModel modelColumnHeader) {
		this.columnHeaderModel = modelColumnHeader;
	}

	public IPivotTableHeaderModel getRowHeaderModel() {
		return rowHeaderModel;
	}

	public void setRowHeaderModel(IPivotTableHeaderModel modelRowHeader) {
		this.rowHeaderModel = modelRowHeader;
	}
	public IFocusModel getFocusModel() {
		return focusModel;
	}
	public void setFocusModel(IFocusModel focusModel) {
		this.focusModel = focusModel;
	}
	
	
	public ISelectionModel getSelectionModel() {
		return selectionModel;
	}
	public void setSelectionModel(ISelectionModel selectionModel) {
		this.selectionModel = selectionModel;
	}
	public void buildUI() {
		/** Fix the layout **/
		setLayout(new BorderLayout());
		layered = new JLayeredPane();
		layered.setLayout(new BorderLayout()); // regarder le bouquin filthy rich client
		GridBagConstraints gbc	=	new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridx=1;
		
		layered.setBackground(Color.WHITE);	
		DefaultPivotTableSelection selection	=	new DefaultPivotTableSelection(this);
		layered.add(selection,48);

		DefaultPivotTableFocus focus	=	new DefaultPivotTableFocus(this);
		layered.add(focus,49);

		// Add the header panel 
		DefaultPivotTableHeader header = new DefaultPivotTableHeader(this);
		layered.add(header,50);
		// Add the data layer
		DefaultPivotTableData data	=	new DefaultPivotTableData(this);

		layered.add(data,51);
	
		add(layered);

	}

	public Color getCellBackgroundColor(Object value,ICell column, ICell row) {
//		if (getCellColorCustomizer()!=null) {
//			return getCellColorCustomizer().getCellBackgroundColor(value,column, row);
//		}
		return null;
	}

	public Border getCellBorder(Object value,ICell column, ICell row) {
//		if (getCellBorderCustomizer()!=null) {
//			return getCellBorderCustomizer().getBorder(value,column, row);
//		}
		return null;
	}
	public Font getCellFont(Object value,ICell column, ICell row) {
//		if (getCellFontCustomizer()!=null) {
//			return getCellFontCustomizer().getCellFont(value, column, row);
//		}
		return null;
	}
	public ImageIcon getCellIcon(Object value,ICell column, ICell row) {
//		if (getIconCellCustomizer()!=null) {
//			return getIconCellCustomizer().getCellIcon(value,column, row);
//		}
		return null;
	}
	@Override
	public void componentResized(ComponentEvent e) {
	
		Integer screenWidth		=	getWidth();
		Integer screenHeight	=	getHeight();
		Integer tableWidth		=	getColumnHeaderModel().getPreferredWidth()+getRowHeaderModel().getPreferredWidth();
		Integer tableHeight		=	getColumnHeaderModel().getPreferredHeight()+getRowHeaderModel().getPreferredHeight();
		Double widthFactor		=	NumberUtils.divDouble(screenWidth, tableWidth)	;
		Double heightFactor		=	NumberUtils.divDouble(screenHeight, tableHeight);
		// resize
		getColumnHeaderModel().resizeCells(widthFactor, heightFactor);
		getRowHeaderModel().resizeCells(widthFactor, heightFactor);
	
		revalidate();
	
	}
	@Override
	public void componentMoved(ComponentEvent e) {
		
		
	}
	@Override
	public void componentShown(ComponentEvent e) {
	
		
	}
	@Override
	public void componentHidden(ComponentEvent e) {
	
	}
	
	public ICell getColumnAt(Integer x, Integer y ,boolean onlyHeader) {
		Integer xPosition	=	x-getRowHeaderModel().getWidth();
		return getColumnHeaderModel().getCellsAtX(xPosition, y,onlyHeader);
	}
	
	public ICell getRowAt(Integer x,Integer y,boolean onlyHeader) {
		Integer yPosition	=	y-getColumnHeaderModel().getHeight();
		return getRowHeaderModel().getCellsAtX(x,yPosition,onlyHeader);
	}
	
	public Color getBackgroundColorForFocus() {
		return null;
	}
	
	public Color getBackgroundColorBorderForFocus() {
		return null;
	}
	public Color getBackgroundColorForSelection() {
		return null;
	}
	public Color getBackgroundColorBorderForSelection() {
		return null;
	}
	
	public Object getValueAt(ICell column,ICell row) {
		if (row!=null && column==null) {
			return row.getCellObject();
		}
		else
			if (row==null && column!=null) {
				column.getCellObject();
			}	
			else if (row!=null && column!=null) {
				return "TO BE DONE";
			}
			return null;	
	}
	
	
	public Boolean isSelected(ICell column,ICell row) {
		ICell selectedRow 	= getSelectionModel().getSelectedRow();
		ICell selectedColumn	=	getSelectionModel().getSelectedRow();
		if (column!=null && row==null) {
			return (selectedRow == null && column.equals(selectedColumn));
			
		}
		else
			if (row!=null && column==null) {
				return (selectedColumn == null && row.equals(selectedRow));
				
			}	
			else 
				if (row!=null && column!=null) {
					return (row.equals(selectedRow) && column.equals(selectedColumn));
				}
				else {
					return (selectedColumn==null && selectedRow==null);
				}
	}
}
