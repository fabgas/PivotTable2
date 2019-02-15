package org.myg.pivottable.swing.model.selection;

import org.myg.pivottable.swing.cells.ICell;
/**
 * Basic implémentation of the focus
 * @author doc
 *
 */
public class DefaultMonoSelectionModel implements ISelectionModel {
	private ICell selectedRow 		= null;
	private ICell selectedColumn	=	null;
	@Override
	public void setSelectedRow(ICell cell) {
		selectedRow	=	cell;
	}

	@Override
	public void setSelectedColumn(ICell cell) {
		selectedColumn	=	cell;
	}

	@Override
	public ICell getSelectedRow() {
		return selectedRow;
	}

	@Override
	public ICell getSelectedColumn() {
		return selectedColumn;
	}

}
