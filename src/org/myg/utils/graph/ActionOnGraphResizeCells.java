package org.myg.utils.graph;

import org.myg.pivottable.swing.cells.ICell;

public class ActionOnGraphResizeCells implements IActionOnGraph {
	private Double widhtFactor	=	new Double(1);
	private Double heightFactor	=	new Double(1);
	
	
	
	public ActionOnGraphResizeCells(Double widhtFactor, Double heightFactor) {
		super();
		this.widhtFactor = widhtFactor;
		this.heightFactor = heightFactor;
	}

	@Override
	public ICell actOnCell(ICell iCell) {
		// uniquement sur les  cellules avec fils.
		
		Integer width	=	iCell.getPreferredWidth();
		width			=	new Double(width*widhtFactor).intValue();
		Integer height	=	iCell.getPreferredHeight();
		height			=	new Double(height*heightFactor).intValue();
		if (iCell.getMinimumWidth()<width) {
			iCell.setWidth(width);
		}
		else {
			iCell.setWidth(iCell.getMinimumWidth());
		}
		if (iCell.getMinimumHeight()<height) {
			iCell.setHeight(height);
		}
		else {
			iCell.setHeight(iCell.getMinimumHeight());
		}
		return iCell;
	}

	@Override
	public void actOnCellChild(ICell child,ICell father, ICell neighbour) {
		
	}

	

}
