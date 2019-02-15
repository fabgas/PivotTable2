package org.myg.utils.graph;

import org.myg.pivottable.swing.cells.ICell;

import tests.MyCellObject;

public class ActionOnGraphPrintWidth implements IActionOnGraph {

	@Override
	public ICell actOnCell(ICell iCell) {
		String object = (String)iCell.getCellObject();
		System.out.println(object+" width = "+iCell.getWidth());
		DefaultCellInformation inf	=	(DefaultCellInformation)iCell.getInformation();
		System.out.println("currentWidth = "+inf.getCurrentWidth());
		return iCell;
	}

	@Override
	public void actOnCellChild(ICell child,ICell father, ICell neighbour) {
	}

	

}
