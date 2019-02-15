package org.myg.pivottable.swing.model.selection;

import org.myg.pivottable.swing.cells.ICell;
/**
 * Describe the model to manage focus on the pivot table
 * @author doc
 *
 */
public interface IFocusModel {

	/**
	 * Set the row with the focus
	 * @param cell
	 */
	public void setRowFocus(ICell cell);
	
	/**
	 * Set the column with the focus
	 * @param cell
	 */
	public void setColumnFocus(ICell cell);
	
	/**
	 * Return the cell with the focus
	 * @return
	 */
	public ICell getRowFocus();
	
	/**
	 * Return the column with the focus
	 * @return
	 */
	public ICell getColumnFocus();
	
}
