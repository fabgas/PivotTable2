package org.myg.pivottable.swing.layer.data;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.myg.pivottable.swing.cells.ICell;
import org.myg.pivottable.swing.layer.BasicPivotTableUI;
import org.myg.utils.graph.DefaultCellInformation;

public class DefaultBasicPivotTableDataUI extends BasicPivotTableUI {


	public DefaultBasicPivotTableDataUI(JComponent header) {
		super(header);

	}

	/**
	 * Paint the cells .
	 */
	@Override
	public void paint(Graphics g, JComponent c) {
		// header : get the model!
		// go over the cells and  print them.
		Integer maximumHeightForColumns	=	getHeader().getHeaderColumnModel().getHeight();
		Integer maximumWidthForColumns	=	getHeader().getHeaderRowModel().getWidth();

		paintCells(getHeader().getHeaderColumnModel().getLeafCells(),getHeader().getHeaderRowModel().getLeafCells(),g,getHeader(),maximumWidthForColumns,maximumHeightForColumns);
		super.paint(g, c);
	}


	/**
	 * Recursive methods : paint the main cells and then paint the childs
	 */
	private void paintCells(List<ICell> columnsCells,List<ICell> rowCells,Graphics g, JComponent c,Integer maximumWidth , Integer maximumHeight) {
		if (columnsCells !=null && rowCells!=null) {
			int xPos	=	getHeader().getHeaderRowModel().getWidth();
			int yPos	=	getHeader().getHeaderColumnModel().getHeight();
			paintCells(xPos, yPos, columnsCells,rowCells, g, c,maximumWidth,maximumHeight);
			paintColumnAllSpace(xPos, yPos, columnsCells,rowCells, g, c,maximumWidth,maximumHeight);
			paintRowAllSpace(xPos, yPos, columnsCells,rowCells, g, c,maximumWidth,maximumHeight);
		}
	}

	/**
	 * paints the column with AllSpace tag = true
	 * @param x
	 * @param y
	 * @param columnCells
	 * @param rowCells
	 * @param g
	 * @param c
	 * @param maximumWidth
	 * @param maximumHeight
	 */
	private void paintColumnAllSpace(int x, int y,List<ICell> columnCells,List<ICell> rowCells,Graphics g, JComponent c,Integer maximumWidth, Integer maximumHeight) {
		int currX	=	x;
		for (Iterator iterator = columnCells.iterator(); iterator.hasNext();) {
			ICell column = (ICell) iterator.next();
			Integer width	=	column.getWidth();
			if (column.isAllSpace()) {
				Integer height	=	getHeader().getPivotTable().getRowHeaderModel().getHeight();
				
				Rectangle rec = new Rectangle(currX, y, width, height);
				// paint the current cell
				paintCell(g, rec, column,null);
			}
			currX	=	currX+column.getWidth();
		}
	}
	
	/**
	 * Affiche les lignes ayant l'option "AllSpace" � true.
	 * Attention on affiche pas de cellules l� ou il y a des colonnes � true.
	 * @param x
	 * @param y
	 * @param columnCells
	 * @param rowCells
	 * @param g
	 * @param c
	 * @param maximumWidth
	 * @param maximumHeight
	 */
	private void paintRowAllSpace(int x, int y,List<ICell> columnCells,List<ICell> rowCells,Graphics g, JComponent c,Integer maximumWidth, Integer maximumHeight) {
		// on parcours toutes les lignes
		
		int currY	=	y;
		for (Iterator iterator = rowCells.iterator(); iterator.hasNext();) {
			ICell row = (ICell) iterator.next();
			Integer height 	=	row .getHeight();
			int currX	=	x;
			if (row.isAllSpace()) {
				// V�rifie qu'il n'y a pas de colonnes avec AllSpace 
				List<ICell> isAllSpaceCells = getHeader().getHeaderColumnModel().getAllSpaceCells();
				if (isAllSpaceCells==null || isAllSpaceCells.isEmpty()) {
					Integer width	=	getHeader().getPivotTable().getColumnHeaderModel().getWidth();
					Rectangle rec = new Rectangle(currX,currY,width,height);
					// paint the current cell
					paintCell(g,rec,null,row);
				}
				else {
					// il faut couper la ligne par les colonnes ayant AllSpace � true
					Iterator<ICell> iteAllSpace	=	isAllSpaceCells.iterator();
					while (iteAllSpace.hasNext()) {
						ICell cellAllSpace	=	iteAllSpace.next();
						DefaultCellInformation infoAllSpace	=	(DefaultCellInformation)cellAllSpace.getInformation();
						Integer w	=	getHeader().getHeaderRowModel().getWidth()+infoAllSpace.getCurrentWidth()-x;
						Rectangle rec = new Rectangle( currX, currY, w, height);
						paintCell(g,rec,null,row);
						currX = currX+w+cellAllSpace.getWidth();
					}
					// from last Icell to width
					
					Integer width	=	getHeader().getHeaderRowModel().getWidth()+getHeader().getHeaderColumnModel().getWidth();
					Integer w	=	width-currX;
					if (w>2) { // on affiche pas si pas de cellules ensuite
						Rectangle rec = new Rectangle( currX, currY, w, height);
						paintCell(g,rec,null,row);
					}
				}
			}
			currY	=	currY+height;
		}
	}
	private void paintCells(int x, int y,List<ICell> columnCells,List<ICell> rowCells,Graphics g, JComponent c,Integer maximumWidth, Integer maximumHeight) {
		int currX	=	x;
		int currY	=	y;
		// on parcours les colonnes. Pour chaque colonne on affiche toutes les lignes .
		// attention au cas des AllSpace.
		for (Iterator iterator = columnCells.iterator(); iterator.hasNext();) {
			ICell column = (ICell) iterator.next();
			Integer width	=	column.getWidth();
			currY	=	y;
			if (!column.isAllSpace()) {
				for (Iterator iterator2 = rowCells.iterator(); iterator2.hasNext();) {
					ICell row = (ICell) iterator2.next();
					if (!row.isAllSpace()) {
						Rectangle rec = new Rectangle(currX, currY, width, row.getHeight());
						// paint the current cell
						paintCell(g, rec, column,row);
					}
					// paint the child
					currY	=	currY+row.getHeight();
				}
			}
			currX	=	currX+column.getWidth();
		}
	}
	/**
	 * Return the renderer for the cell
	 */
	@Override
	protected Component getHeaderCellRenderer(ICell column,ICell row) {
		if (column == null && row==null) {
			JPanel panel = new JPanel();
			panel.setPreferredSize(new Dimension(300,60));
			panel.setBackground(new Color(0,255,0));
			return panel;
		}
		return getHeader().prepareRenderer(column,row);
	}



}
