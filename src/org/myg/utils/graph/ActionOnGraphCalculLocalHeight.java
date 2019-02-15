package org.myg.utils.graph;

import org.myg.pivottable.swing.cells.ICell;
import org.myg.utils.NumberUtils;

public class ActionOnGraphCalculLocalHeight implements IActionOnGraph {
	private Integer maximumHeight	=	 null;
	
	public ActionOnGraphCalculLocalHeight(Integer maximumHeight) {
		super();
		this.maximumHeight = maximumHeight;
	}

	@Override
	public ICell actOnCell(ICell iCell) {
		// uniquement sur les  cellules avec fils.
		return iCell;
	}

	@Override
	public void actOnCellChild(ICell child,ICell father, ICell prevCell) {
		DefaultCellInformation  childInf	=	(DefaultCellInformation)child.getInformation();
		DefaultCellInformation  fatherInf	=	(DefaultCellInformation)father.getInformation();
		
		// calculate height in the header coordinates
		Integer totalHeight			=	NumberUtils.addInteger(fatherInf.getCurrentHeight(),father.getHeight());
		Integer totalPreferredHeight=	NumberUtils.addInteger(fatherInf.getCurrentPreferredHeight(),father.getPreferredHeight());
		Integer totalMaximumHeight	=	NumberUtils.addInteger(fatherInf.getCurrentMaximumHeight(),father.getMaximumHeight());
		Integer totalMinimumHeight	=	NumberUtils.addInteger(fatherInf.getCurrentMinimumHeight(),father.getMinimumHeight());
		Integer modifyHeight	=	child.getHeight();
		Integer modifyWidth		=	child.getWidth();
		if (maximumHeight!=null && (child.getChilds()==null || child.getChilds().isEmpty())) {
			DefaultCellInformation information	=	(DefaultCellInformation)child.getInformation();
			Integer currentHeight	=	information.getCurrentHeight();
			modifyHeight	=	maximumHeight-currentHeight;
		}
		childInf.setModifyHeight(modifyHeight); // stock the effective size (change due to different cells size, or childs , or...)
		childInf.setModifyWidth(modifyWidth);
		childInf.setCurrentHeight(totalHeight);
		childInf.setCurrentPreferredHeight(totalPreferredHeight);
		childInf.setCurrentMinimumHeight(totalMinimumHeight);
		childInf.setCurrentMaximumHeight(totalMaximumHeight);
		// calculate width position in the header coordinate
		if (prevCell!=null) {
			DefaultCellInformation  prevInf	=	(DefaultCellInformation)prevCell.getInformation();
			childInf.setCurrentWidth(NumberUtils.addInteger(prevInf.getCurrentWidth(), prevCell.getWidth()));
		}
		else {
			childInf.setCurrentWidth(fatherInf.getCurrentWidth());
		}
		
	}

	

}
