package org.myg.utils.graph;

import org.myg.pivottable.swing.cells.ICell;

public interface IActionOnGraph {
	public ICell actOnCell(ICell iCell);
	public void actOnCellChild(ICell child,ICell father, ICell neighbour);

}
