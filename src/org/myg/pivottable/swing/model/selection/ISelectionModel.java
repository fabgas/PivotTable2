package org.myg.pivottable.swing.model.selection;

import org.myg.pivottable.swing.cells.ICell;
/**
 * Describe the model to manage focus on the pivot table
 * @author doc
 *
 */
public interface ISelectionModel {

	/**
	 * Set the row with the focus
	 * @param cell
	 */
	public void setSelectedRow(ICell cell);
	
	/**
	 * Set the column with the focus
	 * @param cell
	 */
	public void setSelectedColumn(ICell cell);
	
	/**
	 * Return the cell with the focus
	 * @return
	 */
	public ICell getSelectedRow();
	
	/**
	 * Return the column with the focus
	 * @return
	 */
	public ICell getSelectedColumn();
	
}
