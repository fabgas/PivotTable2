package org.myg.utils.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.myg.pivottable.swing.cells.CellList;
import org.myg.pivottable.swing.cells.ICell;

/**
 * Algorithme qui permet de parcourir un graph et d'y appliquer une certaine action.
 * via la class ICellTraversalMechanism.
 * Cette dernière fourni à la fois le mode de parcours (DSF ou BSF) et l'action à appliquer
 * 
 * @author GASTINEAU
 *
 */
public class GraphTraversal {

	
	private ICellTraversalMechanism mechanism;
	// liste of all cells
	private ArrayList<ICell> cells = new ArrayList<ICell>();
	
	public GraphTraversal(ICellTraversalMechanism mechanism) {
		super();
		this.mechanism = mechanism;
	}
	
	public List<ICell> traverseGraph(List<ICell> liste) {
		List<ICell> cellToReturn = new CellList();
		// iterate on the first layer of the cells
		// to add them to the stack
		for (ICell iCell : liste) {
			mechanism.addIntoStack(iCell);
		}
		
		ICell currCell = null;
		while (!mechanism.isStackEmpty()) {
			currCell 	=	mechanism.getFromStack();
			mechanism.markCell(currCell);
			mechanism.actOnCell(currCell);
			if (mechanism.isSelectionnable(currCell)) {
				cellToReturn.add(currCell);
			}
			cells.add(currCell); // stock them
			if (currCell.getChilds()!=null) {
				List<ICell> childs 	=	currCell.getChilds();
				ICell prevCell	=	null;
				for (Iterator iterator = childs.iterator(); iterator.hasNext();) {
					ICell iCell = (ICell) iterator.next();
					if (!mechanism.isCellMark(iCell)) {
						mechanism.addIntoStack(iCell);
					}
					mechanism.actOnCellChild(iCell,currCell,prevCell);
					prevCell	=	iCell;
				}
			}
			
		}
		
		// unmark all the cells previously mark.
		for (Iterator iterator = cells.iterator(); iterator.hasNext();) {
			ICell iCell = (ICell) iterator.next();
			mechanism.unmarkCell(iCell);
		}
		return cellToReturn;
	}
	
}
