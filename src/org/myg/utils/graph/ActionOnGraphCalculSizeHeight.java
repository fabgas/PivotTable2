package org.myg.utils.graph;

import java.util.Iterator;
import java.util.List;

import org.myg.pivottable.swing.cells.ICell;
import org.myg.utils.NumberUtils;

public class ActionOnGraphCalculSizeHeight implements IActionOnGraph {

	@Override
	public ICell actOnCell(ICell iCell) {
		// uniquement sur les  cellules avec fils.
		
		if (iCell.getChilds()!=null && !iCell.getChilds().isEmpty()) {
			//récupération des fils.
			ICellTraversalMechanism mechanism = new CellTraversalMechanismDFS();
			mechanism.addFilter(new FilterOnGraphLeaf());
			GraphTraversal traversal = new GraphTraversal(mechanism);
			
			List<ICell> cells = traversal.traverseGraph(iCell.getChilds());
			// Calcul de la largeur = Somme des largeurs des fils.
			Integer height 			= 	null;
			Integer preferredHeight	=	null;
			Integer minimumHeight	= 	null;
			Integer maximumHeight	= 	null;
			for (Iterator iterator = cells.iterator(); iterator.hasNext();) {
				ICell iCell2 = (ICell) iterator.next();
				height = NumberUtils.addInteger(iCell2.getHeight(), height);
				preferredHeight = NumberUtils.addInteger(iCell2.getPreferredHeight(), preferredHeight);
				minimumHeight	= NumberUtils.addInteger(iCell2.getMinimumHeight(), minimumHeight);
				maximumHeight	= NumberUtils.addInteger(iCell2.getMaximumHeight(), maximumHeight);

			}
			iCell.setHeight(height);
			iCell.setMinimumHeight(minimumHeight);
			iCell.setPreferredHeight(preferredHeight);
			iCell.setMaximumHeight(maximumHeight);
		}
	
		return iCell;
	}

	@Override
	public void actOnCellChild(ICell child,ICell father, ICell neighbour) {
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
	}

	

}
