package org.myg.utils.graph;

import org.myg.pivottable.swing.cells.ICell;

public class FilterOnGraphCellAt implements IFilterOnGraph {
	// position should have been shift according to screen position
	private Integer xPosition;
	private Integer yPosition;
	
	public FilterOnGraphCellAt(Integer xPosition, Integer yPosition) {
		super();
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}

	@Override
	public Boolean isSelectionnable(ICell iCell) {
		Integer currentWidth	=	((DefaultCellInformation)iCell.getInformation()).getCurrentWidth();
		Integer currentHeight	=	((DefaultCellInformation)iCell.getInformation()).getCurrentHeight();
		Boolean widthIn 	= ((xPosition>currentWidth) && (xPosition<(currentWidth+iCell.getWidth()))); 
		Boolean heightIn	= ((yPosition>currentHeight) && (yPosition<(currentHeight+iCell.getHeight())));	
		return widthIn && heightIn;
	}

	

}
