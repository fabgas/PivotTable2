package org.myg.utils.graph;

import org.myg.pivottable.swing.cells.ICell;

public class FilterOnGraphLeaf implements IFilterOnGraph {

	@Override
	public Boolean isSelectionnable(ICell iCell) {
		
		return (iCell.getChilds()==null || iCell.getChilds().isEmpty());
	}

	

}
