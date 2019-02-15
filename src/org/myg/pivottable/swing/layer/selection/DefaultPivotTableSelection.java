package org.myg.pivottable.swing.layer.selection;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import org.myg.pivottable.swing.PivotTable;
import org.myg.pivottable.swing.cells.ICell;
import org.myg.pivottable.swing.layer.PivotTableLayer;
import org.myg.pivottable.swing.model.selection.IFocusModel;
import org.myg.pivottable.swing.model.selection.ISelectionModel;

public class DefaultPivotTableSelection extends PivotTableLayer implements MouseInputListener {
	private Boolean selectedData	=	false;
	public DefaultPivotTableSelection(PivotTable pivotTable) {
		super(pivotTable);
		setUI(new DefaultBasicPivotTableSelectionUI(this));
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public Boolean getSelectedData() {
		return selectedData;
	}

	public void setSelectedData(Boolean selectedData) {
		this.selectedData = selectedData;
	}

	public ISelectionModel getSelectionModel() {
		return getPivotTable().getSelectionModel();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// if mouse is cliked => new Selected elements
		// could be column OR row OR both if policy is ok with that.
		ICell columnCellSelected	=	getPivotTable().getColumnAt(e.getX(), e.getY(),false);
		getSelectionModel().setSelectedColumn(columnCellSelected);
		ICell rowCellSelected		=	getPivotTable().getRowAt(e.getX(), e.getY(),false);
		getSelectionModel().setSelectedRow(rowCellSelected);
		// needs to repaint
		getPivotTable().repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		getFocusModel().setColumnFocus(null);
		getFocusModel().setRowFocus(null);
		getPivotTable().repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	public IFocusModel getFocusModel() {
		return getPivotTable().getFocusModel();
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// get the column with focus 
		ICell columnCellWithFocus	=	getPivotTable().getColumnAt(e.getX(), e.getY(),false);
		// get the row with the focus
		ICell rowCellWithFocus		=	getPivotTable().getRowAt(e.getX(), e.getY(),false);
	
		// if column take all space, row got no focus.
		boolean isColumnAllSpace 	= columnCellWithFocus!=null?columnCellWithFocus.isAllSpace():false;
		
		if (!isColumnAllSpace) {
			getFocusModel().setRowFocus(rowCellWithFocus);
		}
		else {
			getFocusModel().setRowFocus(null);
		}
		// if row take all space, column got no focus
		boolean isRowAllSpace		= rowCellWithFocus!=null?rowCellWithFocus.isAllSpace():false;
				
		if (!isRowAllSpace) {
			getFocusModel().setColumnFocus(columnCellWithFocus);
		}
		else {
			getFocusModel().setColumnFocus(null);
		}
		// needs to repaint
		getPivotTable().repaint();
		
	}

	

	
}
