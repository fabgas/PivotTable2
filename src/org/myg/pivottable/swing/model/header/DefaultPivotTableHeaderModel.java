package org.myg.pivottable.swing.model.header;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.myg.pivottable.swing.cells.CellList;
import org.myg.pivottable.swing.cells.ICell;
import org.myg.utils.graph.ActionOnGraphResizeCells;
import org.myg.utils.graph.CellTraversalMechanismDFS;
import org.myg.utils.graph.FilterOnGraphLeaf;
import org.myg.utils.graph.GraphTraversal;
import org.myg.utils.graph.ICellTraversalMechanism;

public class DefaultPivotTableHeaderModel implements IPivotTableHeaderModel {
	

	/**
	 * List of the Header's cell
	 */
	private CellList headerCells = new CellList();
	/** 
	 * Width of this header
	 */
	protected Integer totalCellsWidth=-1;
	/**
	 * Height of the header
	 */
	protected Integer totalCellsHeight=-1;
	/**
	 * Height of the header
	 */
	protected Integer totalCellsMinimumHeight=-1;
	/** 
	 * Width of this header
	 */
	protected Integer totalCellsMinimumWidth=-1;
	/**
	 * Height of the header
	 */
	protected Integer totalCellsPreferredHeight=-1;
	/** 
	 * Width of this header
	 */
	protected Integer totalCellsPreferredWidth=-1;
	/**
	 * Height of the header
	 */
	protected Integer totalCellsMaximumHeight=-1;
	/** 
	 * Width of this header
	 */
	protected Integer totalCellsMaximumWidth=-1;
	

	/**
	 * Add a cell to the root node
	 */
	@Override
	public ICell addCell(ICell newCell) {
		addCell(newCell, null, null);
		return newCell;
	}


	@Override
	public List<ICell> addCell(List<ICell> cells) {
		for (Iterator iterator = cells.iterator(); iterator.hasNext();) {
			ICell iCell = (ICell) iterator.next();
			addCell(iCell);
		}
		return cells;
	}


	/**
	 * Add a new cell to the model. You can specify a parent and / or a neighbor
	 * If no parent and neighbor are specifies, the node is add to the root
	 */
	@Override
	public ICell addCell(ICell newCell, ICell neighbour, ICell parent) {
	
		if (newCell == null) {
		    throw new IllegalArgumentException("Object is null");
		}
		headerCells.addCell(newCell, neighbour, parent);
		// create a new Event
		PivotTableHeaderCellModelEvent event = new PivotTableHeaderCellModelEvent(newCell, this);
		fireCellAdded(event);
		return newCell;
	}

	
	@Override
	public void removeCell(ICell cellToBeRemoved) {
		headerCells.remove(cellToBeRemoved);
	}

	@Override
	public void moveCell(ICell cellTopBeMoved, ICell neighbour, ICell parent) {
		
	}

	@Override
	public List<ICell> getCells() {
		return headerCells;
	}

	@Override
	public ICell getCell(String id) {
			
		return null;
	}

	
	@Override
	public List<ICell> getLeafCells() {
	
		ICellTraversalMechanism mechanism = new CellTraversalMechanismDFS();
		mechanism.addFilter(new FilterOnGraphLeaf());
		GraphTraversal traversal = new GraphTraversal(mechanism);
		List<ICell> leafs = traversal.traverseGraph(getCells());
		// be careful the last are the first ...
		Collections.reverse(leafs);
		return leafs;
	}



	@Override
	public void resizeCells(Double widthFactor, Double heightFactor) {
		ICellTraversalMechanism mechanism = new CellTraversalMechanismDFS();
		mechanism.addAction(new ActionOnGraphResizeCells(widthFactor, heightFactor));
		GraphTraversal traversal = new GraphTraversal(mechanism);
		traversal.traverseGraph(getCells());
		invalidateSizes();
	}


	@Override
	public Integer getWidth() {
		if (totalCellsWidth==-1 || totalCellsHeight==-1) {
			calculateSize();
		}
		
		return totalCellsWidth;
	}
	@Override
	public Integer getPreferredWidth() {
		if (totalCellsPreferredWidth==-1 || totalCellsPreferredHeight==-1) {
			calculatePreferredSize();
		}
		
		return totalCellsPreferredWidth;
	}
	@Override
	public Integer getMaximumWidth() {
		if (totalCellsPreferredWidth==-1 || totalCellsPreferredHeight==-1) {
			calculatePreferredSize();
		}
		
		return totalCellsMaximumWidth;
	}
	@Override
	public Integer getMinimumWidth() {
		if (totalCellsPreferredWidth==-1 || totalCellsPreferredHeight==-1) {
			calculatePreferredSize();
		}
		
		return totalCellsMinimumWidth;
	}
	@Override
	public Integer getHeight() {
		if (totalCellsWidth==-1 || totalCellsHeight==-1) {
			calculateSize();
			
		}
		return totalCellsHeight;
	}
	@Override
	public Integer getPreferredHeight() {
		if (totalCellsWidth==-1 || totalCellsHeight==-1) {
			calculateSize();
			
		}
		return totalCellsPreferredHeight;
	}
	@Override
	public Integer getMaximumHeight() {
		if (totalCellsWidth==-1 || totalCellsHeight==-1) {
			calculateSize();
			
		}
		return totalCellsMaximumHeight;
	}
	@Override
	public Integer getMinimumHeight() {
		if (totalCellsWidth==-1 || totalCellsHeight==-1) {
			calculateSize();
			
		}
		return totalCellsMinimumHeight;
	}
	protected void calculateSize() {
		// calculate each cell size (depends if it is a rowHeader or a ColumnHeader)
		// should be override.
		//put size to zero.
		totalCellsHeight=0;
		totalCellsMaximumHeight=0;
		totalCellsMaximumWidth=0;
		totalCellsMinimumHeight=0;
		totalCellsMinimumWidth=0;
		totalCellsPreferredHeight=0;
		totalCellsPreferredWidth=0;
		totalCellsWidth=0;
		calculateCellSize();
		// calculate the total height of this header
		calculateTotalHeight();
		// calculate the total width of this header
		calculateTotalWidth();
	}
	
	/**
	 *  calculate the total preferred size
	 */
	protected void calculatePreferredSize() {
		calculateSize();
	}
	protected void calculateTotalHeight() {
		// should be override
	    throw new UnsupportedOperationException("M�thod calculateTotalHeight non implemented");
	}
	
	protected void calculateTotalWidth() {
		// should be override
	    throw new UnsupportedOperationException("M�thod calculateTotalWidth non implemented");
	}
	
	protected void calculateCellSize() {
		// should be override
		    throw new UnsupportedOperationException("M�thod CalculateCellSize non implemented");
	}
	/**
	 * Force to recalculate the size of the table and each cells size
	 */
	protected void invalidateSizes() {
		totalCellsHeight=-1;
		totalCellsWidth=-1;
	}
	
	protected void fireCellAdded(PivotTableHeaderCellModelEvent event) {
		// when a cell is added to the model, the size should be reclaculated
		invalidateSizes();
		
	}


	@Override
	public ICell getCellsAtX(int xPosition, int yPosition) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ICell getCellsAtX(int xPosition, int yPosition, boolean onlyHeader){
		return null;
	}
	@Override
	public List<ICell> getAllSpaceCells() {
		List<ICell> leafsCell	= getLeafCells();
		if (leafsCell!=null) {
			List<ICell> allSpaceList = new CellList();
			for (Iterator iterator = leafsCell.iterator(); iterator.hasNext();) {
				ICell iCell = (ICell) iterator.next();
				if (iCell.isAllSpace()) {
					allSpaceList.add(iCell);
				}
			}
			return allSpaceList;
		}
		return new CellList();
	}

	
	
}
