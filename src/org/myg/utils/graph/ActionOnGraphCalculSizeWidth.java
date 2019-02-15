package org.myg.utils.graph;

import java.util.Iterator;
import java.util.List;

import org.myg.pivottable.swing.cells.ICell;
import org.myg.utils.NumberUtils;

public class ActionOnGraphCalculSizeWidth implements IActionOnGraph {
	
	
	public ActionOnGraphCalculSizeWidth() {
		super();

	}

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
			Integer width = null;
			Integer preferredWidth	=	null;
			Integer minimumWidth	= 	null;
			Integer maximumWidth	= 	null;
			for (Iterator iterator = cells.iterator(); iterator.hasNext();) {
				ICell iCell2 = (ICell) iterator.next();
				 width = NumberUtils.addInteger(iCell2.getWidth(), width);
				 preferredWidth = NumberUtils.addInteger(iCell2.getPreferredWidth(), preferredWidth);
				 minimumWidth	=	NumberUtils.addInteger(iCell.getMinimumWidth(), minimumWidth);
				 maximumWidth	=	NumberUtils.addInteger(iCell.getMaximumWidth(), maximumWidth);
				 
			}
			iCell.setWidth(width);
			iCell.setPreferredWidth(preferredWidth);
			iCell.setMaximumWidth(maximumWidth);
			iCell.setMinimumWidth(minimumWidth);
			
		}
		// do not set the height here, should be modifiy only during the drawing process
		return iCell;
	}

	@Override
	public void actOnCellChild(ICell child,ICell father, ICell neighbour) {
		DefaultCellInformation  childInf	=	(DefaultCellInformation)child.getInformation();
		DefaultCellInformation  fatherInf	=	(DefaultCellInformation)father.getInformation();
		Integer totalHeight			=	NumberUtils.addInteger(fatherInf.getCurrentHeight(),father.getHeight());
		Integer totalPreferredHeight=	NumberUtils.addInteger(fatherInf.getCurrentPreferredHeight(),father.getPreferredHeight());
		Integer totalMaximumHeight	=	NumberUtils.addInteger(fatherInf.getCurrentMaximumHeight(),father.getMaximumHeight());
		Integer totalMinimumHeight	=	NumberUtils.addInteger(fatherInf.getCurrentMinimumHeight(),father.getMinimumHeight());
		
		childInf.setCurrentHeight(totalHeight);
		childInf.setCurrentPreferredHeight(totalPreferredHeight);
		childInf.setCurrentMinimumHeight(totalMinimumHeight);
		childInf.setCurrentMaximumHeight(totalMaximumHeight);
	}

	

}
