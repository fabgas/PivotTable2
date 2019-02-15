package org.myg.utils.graph;

import org.myg.pivottable.swing.cells.ICell;

import tests.MyCellObject;

public class ActionOnGraphModifyLibelle implements IActionOnGraph {

	@Override
	public ICell actOnCell(ICell iCell) {
		String object = (String)iCell.getCellObject();
		object= object+" ----";
		return iCell;
	}

	@Override
	public void actOnCellChild(ICell child,ICell father, ICell neighbour) {
		
		
	}

	

}
