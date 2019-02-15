package org.myg.utils.graph;

import java.util.ArrayDeque;
import java.util.Deque;

import org.myg.pivottable.swing.cells.ICell;

/**
 * Parcours en profondeur d'abord. Va au plus loin dans le noeud parcouru.
 * Implementation d'une LIFO 
 *   Last in first out
 *   
 * @author GASTINEAU
 *
 */
public class CellTraversalMechanismDFS extends DefaultCellTraversalMechanism {
	Deque<ICell> stack = new ArrayDeque<ICell>();

	@Override
	public ICell addIntoStack(ICell iCell) {
		stack.addFirst(iCell);
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
