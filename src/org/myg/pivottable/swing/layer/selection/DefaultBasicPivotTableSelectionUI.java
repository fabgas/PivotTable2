package org.myg.pivottable.swing.layer.selection;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.CellRendererPane;
import javax.swing.JComponent;
import javax.swing.JPanel;

import org.myg.pivottable.swing.cells.ICell;
import org.myg.pivottable.swing.layer.BasicPivotTableUI;
import org.myg.utils.graph.DefaultCellInformation;

public class DefaultBasicPivotTableSelectionUI extends BasicPivotTableUI {

	CellRendererPane rendererPane	=	new CellRendererPane();
	public DefaultBasicPivotTableSelectionUI(JComponent header) {
		super(header);

	}

	/**
	 * Paint the cells .
	 */
	@Override
	public void paint(Graphics g, JComponent c) {
		//paint vertical lines
		ICell columnSelected	=	getHeader().getPivotTable().getSelectionModel().getSelectedColumn();
		ICell rowWithFocus	=	getHeader().getPivotTable().getSelectionModel().getSelectedRow();
		if (columnSelected!=null && rowWithFocus!=null ) {
			Integer width	=	getHeader().getHeaderRowModel().getWidth();
			Integer height	=	getHeader().getHeaderColumnModel().getHeight();
			paintSelectedDataCell(g,  columnSelected, rowWithFocus,width,height);
		}
		else
		if (columnSelected!=null && rowWithFocus==null) {
			Integer height	=	getHeader().getHeaderColumnModel().getHeight()+getHeader().getHeaderRowModel().getHeight();
			Integer width	=	getHeader().getHeaderRowModel().getWidth();
			paintVerticalLine(g, width,height);
		}
		else 
			if (columnSelected==null && rowWithFocus!=null) {
				Integer height	=	getHeader().getHeaderColumnModel().getHeight();
				Integer width	=	getHeader().getHeaderRowModel().getWidth()+getHeader().getHeaderColumnModel().getWidth();
				paintHorizontalLine(g, width,height);
			}
	}
	
	private void paintSelectedDataCell(Graphics g,ICell column,ICell row,Integer width,Integer height)  {
		DefaultCellInformation infoRow = (DefaultCellInformation)row.getInformation();
		DefaultCellInformation infoColumn = (DefaultCellInformation)column.getInformation();
		AlphaComposite ac =
				AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.3f);
		((Graphics2D)g).setComposite(ac);
		if (!row.isAllSpace() && !column.isAllSpace()) {
			Rectangle rec = new Rectangle(infoColumn.getCurrentWidth()+width,
									  infoRow.getCurrentHeight()+height,
									  column.getWidth(),
									  row.getHeight());
			// paint the current cell
			paintCell(g, rec, column,row);
		}
		else
			if (column.isAllSpace()) {
				Rectangle rec = new Rectangle(infoColumn.getCurrentWidth()+width,
						  height,
						  column.getWidth(),
						  getHeader().getHeaderRowModel().getHeight());
				paintCell(g, rec, column,row);
			}
			else
				if (row.isAllSpace()) {
					Rectangle rec = new Rectangle( width,
								infoRow.getCurrentHeight()+height,
								getHeader().getHeaderColumnModel().getWidth(),
							  row.getHeight());
					paintCell(g, rec, column,row);
				}
	}
	private void paintVerticalLine(Graphics g, Integer width,Integer height) {
		ICell columnSelected	=	getHeader().getPivotTable().getSelectionModel().getSelectedColumn();
		
		if (columnSelected!=null ) {
			DefaultCellInformation info	=	(DefaultCellInformation)columnSelected.getInformation();
			AlphaComposite ac =
					AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.3f);
			((Graphics2D)g).setComposite(ac);
			Integer x	=	width+info.getCurrentWidth();
			Integer y	=	info.getCurrentHeight();
			Integer w	=	columnSelected.getWidth();
			Integer h	=	height-info.getCurrentHeight();
			((Graphics2D)g).setColor(getBackgroundColorForSelection());
			((Graphics2D)g).fillRect(x, y, w, h);
			 ac =AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.6f);
			((Graphics2D)g).setComposite(ac);
			((Graphics2D)g).setColor(getBackgroundColorBorderForSelection());
			((Graphics2D)g).drawRect(x+1, y+1, w-2, h-2);
			
		}
	}
	private void paintHorizontalLine(Graphics g, Integer width,Integer height) {
		ICell rowWithFocus	=	getHeader().getPivotTable().getSelectionModel().getSelectedRow();
		if (rowWithFocus!=null) {
			Component component = getHeaderCellRenderer(rowWithFocus,null); 
			DefaultCellInformation info	=	(DefaultCellInformation)rowWithFocus.getInformation();
			AlphaComposite ac =
					AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.3f);
			((Graphics2D)g).setComposite(ac);
			Integer x	=	info.getCurrentWidth();
			Integer y	=	height+info.getCurrentHeight();
			Integer w	=	width-info.getCurrentWidth();
			Integer h	=	rowWithFocus.getHeight();
			((Graphics2D)g).setColor(getBackgroundColorForSelection());
			((Graphics2D)g).fillRoundRect(x, y, w, h,5,5);
			 ac =AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.6f);
			((Graphics2D)g).setComposite(ac);
			((Graphics2D)g).setColor(getBackgroundColorBorderForSelection());
			((Graphics2D)g).drawRoundRect(x+1, y+1, w-2, h-2,5,5);
		}
	}
	protected Component getHeaderCellRenderer(ICell column,ICell row) {
		JPanel panel = new JPanel();
		panel.setBackground(getBackgroundColorForSelection());
		panel.setBorder(BorderFactory.createEtchedBorder());
		return panel;
	}
	public Color getBackgroundColorForSelection() {
		Color colorBkg	=	getHeader().getPivotTable().getBackgroundColorForSelection();
		if (colorBkg==null) {
			colorBkg	=	Color.BLUE;
		}
		return colorBkg;
	}
	
	public Color getBackgroundColorBorderForSelection() {
		Color colorBkg	=	getHeader().getPivotTable().getBackgroundColorBorderForSelection();
		if (colorBkg==null) {
			colorBkg	=	Color.BLACK;
		}
		return colorBkg;
	}
	
}
