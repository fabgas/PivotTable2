package org.myg.utils.graph;

import org.myg.pivottable.swing.cells.ICell;
import org.myg.utils.NumberUtils;

public class ActionOnGraphCalculLocalWidth implements IActionOnGraph {

	@Override
	public ICell actOnCell(ICell iCell) {

		return iCell;
	}

	@Override
	public void actOnCellChild(ICell child,ICell father, ICell prevCell) {
		DefaultCellInformation  childInf	=	(DefaultCellInformation)child.getInformation();
		DefaultCellInformation  fatherInf	=	(DefaultCellInformation)father.getInformation();
		Integer totalWidth	=	NumberUtils.addInteger(fatherInf.getCurrentWidth(),father.getWidth());
		Integer totalPreferredWidth	=	NumberUtils.addInteger(fatherInf.getCurrentPreferredWidth(),father.getPreferredWidth());
		Integer totalMinimumWidth	=	NumberUtils.addInteger(fatherInf.getCurrentMinimumWidth(),father.getMinimumWidth());
		Integer totalMaximumWidth	=	NumberUtils.addInteger(fatherInf.getCurrentMaximumWidth(),father.getMaximumWidth());

		childInf.setCurrentWidth(totalWidth);
		childInf.setCurrentPreferredWidth(totalPreferredWidth);
		childInf.setCurrentMaximumWidth(totalMaximumWidth);
		childInf.setCurrentMinimumWidth(totalMinimumWidth);

		// calculate width position in the header coordinate
		if (prevCell!=null) {
			DefaultCellInformation  prevInf	=	(DefaultCellInformation)prevCell.getInformation();
			childInf.setCurrentHeight(NumberUtils.addInteger(prevInf.getCurrentHeight(), prevCell.getHeight()));
		}
		else {
			childInf.setCurrentHeight(fatherInf.getCurrentHeight());
		}
	}



}
