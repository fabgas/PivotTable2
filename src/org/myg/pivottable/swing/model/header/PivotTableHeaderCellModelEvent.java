package org.myg.pivottable.swing.model.header;

import org.myg.pivottable.swing.cells.ICell;

public class PivotTableHeaderCellModelEvent {
	private ICell cell;
	IPivotTableHeaderModel source;

	public ICell getCell() {
		return cell;
	}

	public void setCell(ICell cell) {
		this.cell = cell;
	}


	public PivotTableHeaderCellModelEvent(ICell cell,
			IPivotTableHeaderModel source) {
		super();
		this.cell = cell;
		this.source = source;
	}
	
}
