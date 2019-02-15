package org.myg.pivottable.swing.layer.focus;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import org.myg.pivottable.swing.PivotTable;
import org.myg.pivottable.swing.cells.ICell;
import org.myg.pivottable.swing.layer.PivotTableLayer;
import org.myg.pivottable.swing.model.selection.IFocusModel;

public class DefaultPivotTableFocus extends PivotTableLayer implements MouseInputListener {

	public DefaultPivotTableFocus(PivotTable pivotTable) {
		super(pivotTable);
		setUI(new DefaultBasicPivotTableFocusUI(this));
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public IFocusModel getFocusModel() {
		return getPivotTable().getFocusModel();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
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
			// no more focus
		getFocusModel().setRowFocus(null);
		getFocusModel().setColumnFocus(null);
		getPivotTable().repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
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
