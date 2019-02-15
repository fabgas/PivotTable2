package org.myg.pivottable.swing.cells;

import java.util.ArrayList;


public class CellList extends ArrayList<ICell> {
	/**
	 * Add a new Cell specifying the parent and the neighbour of the cell
	 * @param cell
	 * @param neighbour
	 * @param parent
	 */
	public void addCell(ICell cell, ICell neighbour, ICell parent) {
		// if no parent and neighbour => root 
		if (neighbour== null && parent==null) {
			add(cell); // add the cell to the current collection at the end of the list
			return;
		}
	}
	/**
	 * Return the depth of the tree (0 if it is a child)
	 */
	public Integer getDepth() {
		return null;
	}
	
	/**
	 * Return all the leaf cell of this container
	 * @return
	 */
	public CellList getLeafCells() {
		return null;
	}
	
	/**
	 * remove the cell from the cell tree
	 *Needs ro override because could be in a child
	 */
	public void remove(ICell cellToRemove) {
		
	}
	
	/**
	 * Return the cell by his ID
	 * @param id
	 * @return
	 */
	public ICell getCell(String id) {
		return null;
	}
	/**
	 * Return the parent of a Cell
	 * @param cell
	 * @return
	 */
	public ICell getParent(ICell cell) {
		return null;
	}
	
}
