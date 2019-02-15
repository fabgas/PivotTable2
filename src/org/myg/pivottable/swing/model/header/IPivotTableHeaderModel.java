package org.myg.pivottable.swing.model.header;

import java.util.List;

import org.myg.pivottable.swing.cells.ICell;
/**
 * Cells model for a header. It could be a RowHeader or a Column Header
 * Both defines a PivotTableHeader
 * @author GASTINEAU
 *
 */
public interface IPivotTableHeaderModel {
	// Model modification by adding, removing cells
	/**
	 * Add a cell to the root of the tree
	 * @param newCell
	 * @return
	 */
	public ICell addCell(ICell newCell);
	
	
	public List<ICell> addCell(List<ICell> cells);
	
	/**
	 * add a cell to this model
	 * @param newCell
	 * @return
	 */
	public ICell addCell(ICell newCell,ICell neighbour, ICell parent);
	/**
	 * remove a cell from this model
	 * @param cellToBeRemoved
	 */
	public void  removeCell(ICell cellToBeRemoved);
	
	/**
	 * move cell from its current position to another position
	 * @param cellTopBeMoved
	 * @param neighbour
	 * @param parent
	 */
	public void  moveCell(ICell cellTopBeMoved, ICell neighbour, ICell parent);
	
	// ask to the model some information

	/**
	 * Return the cells
	 * @return
	 */
	public List<ICell> getCells();
	/**
	 * Return the leaf cells
	 * @return
	 */
	public List<ICell> getLeafCells();
	/**
	 * Return the cell corresponding to the id
	 * @param id
	 * @return
	 */
	public ICell getCell(String id);
	
	/**
	 * Return the cell at the (x,y) position
	 * @param xPosition
	 * @param yPosition
	 * @return
	 */
	public ICell getCellsAtX(int xPosition,int yPosition);
	/**
	 * On ajoute un boolean pour indiquer si lors de la recherche
	 * on doit consid�rer l'ensemble de la colonne(ou ligne) ou uniquement
	 * la prtie incluse dans le header 
	 * @param xPosition
	 * @param yPosition
	 * @param onlyHeader
	 * @return
	 */
	public ICell getCellsAtX(int xPosition,int yPosition,boolean onlyHeader);
	/**
	 * Resize all the cells inside the model
	 * @param widthFactor
	 * @param heightFactor
	 */
	public void resizeCells(Double widthFactor,Double heightFactor);
	/**
	 * Return the total width if this header
	 * @return
	 */
	public Integer getWidth();
	
	/**
	 * return the total height of this header;
	 * @return
	 */
	public Integer getHeight();
	/**
	 * Return the total width if this header
	 * @return
	 */
	public Integer getPreferredWidth();
	
	/**
	 * return the total height of this header;
	 * @return
	 */
	public Integer getPreferredHeight();
	/**
	 * Return the total width if this header
	 * @return
	 */
	public Integer getMaximumWidth();
	
	/**
	 * return the total height of this header;
	 * @return
	 */
	public Integer getMaximumHeight();
	/**
	 * Return the total width if this header
	 * @return
	 */
	public Integer getMinimumWidth();
	
	/**
	 * return the total height of this header;
	 * @return
	 */
	public Integer getMinimumHeight();
	
	// missed somme selection model stuff and also listeners
	public List<ICell> getAllSpaceCells() ;
}
