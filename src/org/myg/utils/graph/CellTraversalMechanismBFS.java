package org.myg.utils.graph;

import java.util.ArrayDeque;
import java.util.Deque;

import org.myg.pivottable.swing.cells.ICell;

import tests.MyCellObject;

/**
 * Parcours en largeur d'abord, les noeuds voisins avant les fils
 * Implementation d'une FIFO 
 *   First in first out
 * @author GASTINEAU
 *
 */
public class CellTraversalMechanismBFS extends DefaultCellTraversalMechanism {
	Deque<ICell> stack = new ArrayDeque<ICell>();

	@Override
	public ICell addIntoStack(ICell iCell) {
		stack.addLast(iCell);
		return iCell;
	}

	@Override
	public ICell getFromStack() {
		return stack.pollFirst();
		
	}


	@Override
	public Boolean isStackEmpty() {
			return stack.isEmpty();
	}
	
}
