package org.myg.utils.graph;

import org.myg.pivottable.swing.cells.ICell;

import tests.MyCellObject;

public class ActionOnGraphPrintHeight implements IActionOnGraph {

	@Override
	public ICell actOnCell(ICell iCell) {
		String object = (String)iCell.getCellObject();
		System.out.println(object+" height = "+iCell.getHeight());
		return iCell;
	}

	@Override
	public void actOnCellChild(ICell child,ICell father, ICell neighbour) {
	}

	

}
