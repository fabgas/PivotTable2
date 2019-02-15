package org.myg.pivottable.swing.model.header;

import java.util.Iterator;
import java.util.List;

import org.myg.pivottable.swing.cells.ICell;
import org.myg.utils.NumberUtils;
import org.myg.utils.graph.ActionOnGraphCalculLocalHeight;
import org.myg.utils.graph.ActionOnGraphCalculSizeWidth;
import org.myg.utils.graph.CellTraversalMechanismDFS;
import org.myg.utils.graph.DefaultCellInformation;
import org.myg.utils.graph.FilterOnGraphLeaf;
import org.myg.utils.graph.GraphTraversal;
import org.myg.utils.graph.ICellTraversalMechanism;


public class ColumnPivotTableHeaderModel extends DefaultPivotTableHeaderModel {

	/**
	 * For the column header, the height is the sum of all layers height
	 * Pre requisite : each cell has his cell size calculated
	 */
	@Override
	protected void calculateTotalHeight() {
		calculateTotalHeight(null);
	}
	protected void calculateTotalHeight(Integer lMaximumHeight) {
		List<ICell> listeCells = getCells();

		ICellTraversalMechanism mechanism = new CellTraversalMechanismDFS();
		// recherche de la hauteur maximum 
		mechanism.addAction(new ActionOnGraphCalculLocalHeight(lMaximumHeight));
		mechanism.addFilter(new FilterOnGraphLeaf());
		GraphTraversal traversal = new GraphTraversal(mechanism);
		List<ICell> leafsCell = traversal.traverseGraph(listeCells);
		if (lMaximumHeight==null) {
			Integer height	=	new Integer(0);
			Integer preferredHeight	=	new Integer(0);
			Integer minimumHeight	=	new Integer(0);
			Integer maximumHeight	=	new Integer(0);
			for (Iterator iterator = leafsCell.iterator(); iterator.hasNext();) {
				ICell iCell = (ICell) iterator.next();
				DefaultCellInformation information	=	(DefaultCellInformation)iCell.getInformation();
				Integer cellHeight			=	NumberUtils.addInteger(information.getCurrentHeight(), iCell.getHeight());
				Integer cellPreferredHeight	=	NumberUtils.addInteger(information.getCurrentPreferredHeight(), iCell.getPreferredHeight());
				Integer cellMinimumHeight	=	NumberUtils.addInteger(information.getCurrentMinimumHeight(), iCell.getMinimumHeight());
				Integer cellMaximumHeight	=	NumberUtils.addInteger(information.getCurrentMaximumHeight(), iCell.getMaximumHeight());
				if (height.compareTo(cellHeight)<1) {
					height			=	cellHeight;
					preferredHeight	=	cellPreferredHeight;
					minimumHeight	=	cellMinimumHeight;
					maximumHeight	=	cellMaximumHeight;
				}
			}

			totalCellsHeight			= height;
			totalCellsPreferredHeight	=	preferredHeight;
			totalCellsMinimumHeight		=	minimumHeight;
			totalCellsMaximumHeight		= 	maximumHeight;
			Integer x=0;
			// needs to initialise the x position of the first layer of cell
			for (Iterator iterator = listeCells.iterator(); iterator.hasNext();) {
				ICell iCell = (ICell) iterator.next();
				DefaultCellInformation information	=	(DefaultCellInformation)iCell.getInformation();
				information.setCurrentWidth(x);
				x=x+iCell.getWidth();
			}
			calculateTotalHeight(height);	
		}
	}

	/**
	 * For the column header, the width is the sum of all the cells width
	 * of the first layer
	 * Prerequisite : each cell has his cell size calculated
	 */
	@Override
	protected void calculateTotalWidth() {
		List<ICell> listeCells = getCells();
		totalCellsWidth	=	new Integer(0);
		totalCellsMaximumWidth	=	new Integer(0);
		totalCellsMaximumWidth	=	new Integer(0);
		totalCellsPreferredWidth	=	new Integer(0);
		for (Iterator iterator = listeCells.iterator(); iterator.hasNext();) {
			ICell iCell = (ICell) iterator.next();
			totalCellsWidth = NumberUtils.addInteger(totalCellsWidth, iCell.getWidth());
			totalCellsMaximumWidth = NumberUtils.addInteger(totalCellsMaximumWidth, iCell.getMaximumWidth());
			totalCellsMinimumWidth = NumberUtils.addInteger(totalCellsMinimumWidth, iCell.getMinimumWidth());
			totalCellsPreferredWidth	= NumberUtils.addInteger(totalCellsPreferredWidth, iCell.getPreferredWidth());
		}
	}

	/**
	 * Calculation of each cells size. For the column header, the width depends on the 
	 * width of each child of the cell.
	 */
	@Override
	protected void calculateCellSize() {

		List<ICell> listeCells = getCells();
		// calculation of the width of the cells.
		// width depends on the childs.
		ICellTraversalMechanism mechanism = new CellTraversalMechanismDFS();
		mechanism.addAction(new ActionOnGraphCalculSizeWidth());

		GraphTraversal traversal = new GraphTraversal(mechanism);
		traversal.traverseGraph(listeCells);
		// Height its fixed ! Don't touch it, only during the drawing process
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
	/** 
	 * Return the column selected at the x,y point.
	 * Two strategy :
	 *    do not take into account the y position if y> columnHeader height, just the x position
	 *    the cursor should be in the column header
	 * @param cells
	 * @param xPosition
	 * @param yPosition
	 * @return
	 */
	private ICell getCellsAtX(List<ICell> cells,int xPosition, int yPosition, boolean onlyHeader) {
		if (cells==null) return null;
		ICell cellData	=	null; // to manage data cells
		Integer xStart=0;
		for (Iterator iterator = cells.iterator(); iterator.hasNext();) {

			ICell iCell = (ICell) iterator.next();
			Integer width = iCell.getWidth();
			Integer height = iCell.getHeight();
			if (iCell.getChilds()==null || iCell.getChilds().isEmpty()) {
				DefaultCellInformation information	=	(DefaultCellInformation)iCell.getInformation();
				Integer currentHeight	=	information.getCurrentHeight();
				height	=	getHeight()-currentHeight;
			}
			if (xPosition>xStart && xPosition<(xStart+width)) {
				// yes !
				cellData	=	iCell;
				if (yPosition<height) {
					//found
					return iCell;
				}
				else {
					// modifiy x, y
					xPosition = xPosition-xStart;
					yPosition = yPosition-height;
					if (iCell.getChilds()!=null && !iCell.getChilds().isEmpty()) {
						return getCellsAtX(iCell.getChilds(),xPosition, yPosition,onlyHeader);
					}
					else {
						if (onlyHeader) 
						{
							return null;
						}
						else {
							return cellData;
						}
					}
				}
			}
			xStart	=	xStart+width;
		}
		return null;
	}



}
