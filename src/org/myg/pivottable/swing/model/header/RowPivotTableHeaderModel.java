package org.myg.pivottable.swing.model.header;

import java.util.Iterator;
import java.util.List;

import org.myg.pivottable.swing.cells.ICell;
import org.myg.utils.NumberUtils;
import org.myg.utils.graph.ActionOnGraphCalculLocalWidth;
import org.myg.utils.graph.ActionOnGraphCalculSizeHeight;
import org.myg.utils.graph.CellTraversalMechanismDFS;
import org.myg.utils.graph.DefaultCellInformation;
import org.myg.utils.graph.FilterOnGraphLeaf;
import org.myg.utils.graph.GraphTraversal;
import org.myg.utils.graph.ICellTraversalMechanism;


public class RowPivotTableHeaderModel extends DefaultPivotTableHeaderModel {
	/**
	 * Calculate the height of the row  header
	 */
	@Override
	protected void calculateTotalHeight() {
		
		List<ICell> listeCells = getCells();
		totalCellsHeight=	new Integer(0);
		totalCellsMaximumHeight	=	new Integer(0);
		totalCellsMaximumHeight	=	new Integer(0);
		totalCellsPreferredHeight	=	new Integer(0);
		for (Iterator iterator = listeCells.iterator(); iterator.hasNext();) {
			ICell iCell = (ICell) iterator.next();
			totalCellsHeight = NumberUtils.addInteger(totalCellsHeight, iCell.getHeight());
			totalCellsMaximumHeight = NumberUtils.addInteger(totalCellsMaximumHeight, iCell.getMaximumHeight());
			totalCellsMinimumHeight = NumberUtils.addInteger(totalCellsMinimumHeight, iCell.getMinimumHeight());
			totalCellsPreferredHeight = NumberUtils.addInteger(totalCellsPreferredHeight, iCell.getPreferredHeight());
		}
	}

	/**
	 * Calculate the width of the column header 
	 * Takes only the first row, sum each cell width
	 */
	@Override
	protected void calculateTotalWidth() {
		List<ICell> listeCells = getCells();
		ICellTraversalMechanism mechanism = new CellTraversalMechanismDFS();
	

		
		// recherche de la hauteur maximum 
		mechanism.addAction(new ActionOnGraphCalculLocalWidth());
		mechanism.addFilter(new FilterOnGraphLeaf());
		GraphTraversal traversal = new GraphTraversal(mechanism);
		List<ICell> leafsCell = traversal.traverseGraph(listeCells);
		Integer width	=	new Integer(0);
		Integer preferredWidth	=	new Integer(0);
		Integer minimumWidth	=	new Integer(0);
		Integer maximumWidth	=	new Integer(0);
		for (Iterator iterator = leafsCell.iterator(); iterator.hasNext();) {
			ICell iCell = (ICell) iterator.next();
			DefaultCellInformation information	=	(DefaultCellInformation)iCell.getInformation();
			Integer cellWidth	=	NumberUtils.addInteger(information.getCurrentWidth(), iCell.getWidth());
			if (width.compareTo(cellWidth)<1) {
				width	=	cellWidth;
				preferredWidth	=	NumberUtils.addInteger(information.getCurrentPreferredWidth(), iCell.getPreferredWidth());
				minimumWidth	=	NumberUtils.addInteger(information.getCurrentMinimumWidth(), iCell.getMinimumWidth());
				maximumWidth	=	NumberUtils.addInteger(information.getCurrentMaximumWidth(), iCell.getMaximumWidth());
			}
		}
		totalCellsWidth	= width;
		totalCellsMaximumWidth	=	maximumWidth;
		totalCellsMinimumWidth	=	minimumWidth;
		totalCellsPreferredWidth=	preferredWidth;
		// needs to initialise the x position of the first layer of cell
		Integer y=0;
		for (Iterator iterator = listeCells.iterator(); iterator.hasNext();) {
					ICell iCell = (ICell) iterator.next();
					DefaultCellInformation information	=	(DefaultCellInformation)iCell.getInformation();
					information.setCurrentHeight(y);
					y=y+iCell.getHeight();
		}
		// on elance un calcul 
		traversal.traverseGraph(listeCells);
	}
	
	/**
	 * Calculation of each cells size. For the row header, the height depends on the 
	 * height of each child of the cell.
	 * When needed to be used :
	 *    - when a cell it s add to the model
	 *    - when the size of a cell change
	 *    - when a cell it s removed from the model
	 */
	@Override
	protected void calculateCellSize() {
		List<ICell> listeCells = getCells();
		// mechanism creation for the graph 
		ICellTraversalMechanism mechanism = new CellTraversalMechanismDFS();
		mechanism.addAction(new ActionOnGraphCalculSizeHeight());
		GraphTraversal traversal = new GraphTraversal(mechanism);
		traversal.traverseGraph(listeCells);
		
	}
	/**
	 * Look for the cell in the x,y position.
	 */
	@Override
	public ICell getCellsAtX(int xPosition, int yPosition) {
		List<ICell> cells = getCells();
		return getCellsAtX(cells,xPosition, yPosition,false);
	}
	@Override
	public ICell getCellsAtX(int xPosition, int yPosition,boolean onlyHeader) {
		List<ICell> cells = getCells();
		return getCellsAtX(cells,xPosition, yPosition,onlyHeader);
	}
	private ICell getCellsAtX(List<ICell> cells,int xPosition, int yPosition,boolean onlyHeader) {
		if (cells==null) return null;
		ICell cellData	=	null;
		Integer yStart=0;
		for (Iterator iterator = cells.iterator(); iterator.hasNext();) {
			ICell iCell = (ICell) iterator.next();
			Integer height = iCell.getHeight();
			Integer width = iCell.getWidth();
			if (iCell.getChilds()==null || iCell.getChilds().isEmpty()) {
				DefaultCellInformation information	=	(DefaultCellInformation)iCell.getInformation();
				Integer currentWidth	=	information.getCurrentWidth();
				width	=	getWidth()-currentWidth;
			}
			if (yPosition>yStart && yPosition<(yStart+height)) {
				// yes !
				cellData	=	iCell;
				if (xPosition<width) {
					//found
					return iCell;
				}
				else {
					// modifiy x, y
					yPosition = yPosition-yStart;
					xPosition = xPosition-width;
					if (iCell.getChilds()!=null && !iCell.getChilds().isEmpty()) {
						return getCellsAtX(iCell.getChilds(),xPosition, yPosition,onlyHeader);
					}
					else {
						if (onlyHeader) {
							return null;
						}
						else {
							return cellData;
						}
					}
				}
			}
			yStart	=	yStart+height;
		}
		return cellData;
	}
}
