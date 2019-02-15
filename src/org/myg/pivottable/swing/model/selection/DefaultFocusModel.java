package org.myg.pivottable.swing.model.selection;

import org.myg.pivottable.swing.cells.ICell;
/**
 * Basic implémentation of the focus
 * @author doc
 *
 */
public class DefaultFocusModel implements IFocusModel {
	private ICell rowWithFocus 		= null;
	private ICell columnWithFocus	=	null;
	@Override
	public void setRowFocus(ICell cell) {
		rowWithFocus	=	cell;
	}

	@Override
	public void setColumnFocus(ICell cell) {
		columnWithFocus	=	cell;
	}

	@Override
	public ICell getRowFocus() {
		return rowWithFocus;
	}

	@Override
	public ICell getColumnFocus() {
		return columnWithFocus;
	}

}
