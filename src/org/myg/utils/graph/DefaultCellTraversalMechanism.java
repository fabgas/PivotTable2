package org.myg.utils.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.myg.pivottable.swing.cells.ICell;

public class DefaultCellTraversalMechanism implements ICellTraversalMechanism {
	
	private List<IActionOnGraph> actions	 = new ArrayList<IActionOnGraph>();	
	private List<IFilterOnGraph> filters	 = new ArrayList<IFilterOnGraph>();	
	@Override
	public ICell addIntoStack(ICell iCell) {
		return null;
	}

	@Override
	public ICell getFromStack() {
	
		return null;
	}

	@Override
	public Boolean isStackEmpty() {
		
		return true;
	}

	@Override
	public ICell markCell(ICell iCell) {
		
		iCell.getInformation().setVisit(true);
		return iCell;
	}

	@Override
	public Boolean isCellMark(ICell iCell) {
	
		return iCell.getInformation().isVisit();
	}

	@Override
	public ICell unmarkCell(ICell iCell) {
		iCell.getInformation().setVisit(false);
		return iCell;
		
	}

	@Override
	public void addAction(IActionOnGraph action) {
		actions.add(action);
	}

	@Override
	public void addFilter(IFilterOnGraph filter) {
		filters.add(filter);
	}

	@Override
	public ICell actOnCell(ICell iCell) {
		for (Iterator iterator = actions.iterator(); iterator.hasNext();) {
			IActionOnGraph action = (IActionOnGraph) iterator.next();
			action.actOnCell(iCell);
		}
		return iCell;
	}
	
	@Override
	public void actOnCellChild(ICell child,ICell father, ICell neighbour) {
		for (Iterator iterator = actions.iterator(); iterator.hasNext();) {
			IActionOnGraph action = (IActionOnGraph) iterator.next();
			action.actOnCellChild(child,father, neighbour);
		}
		
	}

	public Boolean isSelectionnable(ICell iCell) {
		Boolean isSelectionnable = true;
		for (Iterator iterator = filters.iterator(); iterator.hasNext();) {
			IFilterOnGraph filter = (IFilterOnGraph) iterator.next();
			Boolean temp 	=	filter.isSelectionnable(iCell);
			if (!temp) {
				return temp;
			}
		}
		return isSelectionnable;
	}
}
