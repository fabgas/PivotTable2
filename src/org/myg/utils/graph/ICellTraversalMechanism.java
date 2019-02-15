package org.myg.utils.graph;

import org.myg.pivottable.swing.cells.ICell;

public interface ICellTraversalMechanism {

	/**
	 * Add a cell into the stack
	 * @param iCell
	 * @return
	 */
	public ICell addIntoStack(ICell iCell);
	
	/**
	 * Get From stack
	 * @return
	 */
	public ICell getFromStack();
	/**
	 * Telles if the stack is empty or not
	 * @return
	 */
	public Boolean isStackEmpty();
	/**
	 * Mark the cell
	 */
	public ICell markCell(ICell iCell);
	
	/**
	 * Tells if the cell have been marked.
	 * @return
	 */
	public Boolean isCellMark(ICell iCell);
	/**
	 * Unmark the cell
	 * @param cell
	 * @return
	 */
	public ICell unmarkCell(ICell cell);
	/**
	 * Acts on the cell and make something
	 */
	public void addAction(IActionOnGraph action);
	public ICell actOnCell(ICell iCell);
	public void  actOnCellChild(ICell cell,ICell father, ICell neighbour);
	
	/**
	 * Tells if the cell is selectionnable
	 * @param iCell
	 * @return
	 */
	public void addFilter(IFilterOnGraph filter);
	public Boolean isSelectionnable(ICell iCell);

}
