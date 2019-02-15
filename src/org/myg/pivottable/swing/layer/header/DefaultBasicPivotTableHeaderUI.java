package org.myg.pivottable.swing.layer.header;

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

public class DefaultBasicPivotTableHeaderUI extends BasicPivotTableUI {

	public DefaultBasicPivotTableHeaderUI(JComponent header) {
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
		paintCellsColumns(getHeader().getHeaderColumnModel().getCells(),g,getHeader(),maximumHeightForColumns);
		Integer maximumWidthForColumns	=	getHeader().getHeaderRowModel().getWidth();
		paintCellsRows(getHeader().getHeaderRowModel().getCells(),g,getHeader(),maximumWidthForColumns);
		super.paint(g, c);
	}

	/**
	 * Recursive methods : paint the main cells and then paint the childs
	 */
	private void paintCellsColumns(List<ICell> cells,Graphics g, JComponent c, Integer height ) {
		if (cells!=null) {
			int xPos	=	getHeader().getHeaderRowModel().getWidth();
			int yPos	=	0;
			paintCellsColumn(xPos, yPos, cells, g, c,height);
		}
	}
	/**
	 * Recursive methods : paint the main cells and then paint the childs
	 */
	private void paintCellsRows(List<ICell> cells,Graphics g, JComponent c,Integer maximumWidth ) {
		if (cells!=null) {
			int xPos	=	0;
			int yPos	=	getHeader().getHeaderColumnModel().getHeight();
			paintCellsRow(xPos, yPos, cells, g, c,maximumWidth);
		}
	}

	private void paintCellsColumn(int x, int y,List<ICell> cells,Graphics g, JComponent c,Integer maximumHeight) {
		int currX	=	x;
		int currY	=	y;
		for (Iterator iterator = cells.iterator(); iterator.hasNext();) {
			ICell iCell = (ICell) iterator.next();
			// calculate Cell Height
			Integer height	=	iCell.getHeight();
			if (iCell.getChilds()==null || iCell.getChilds().isEmpty()) {
				DefaultCellInformation information	=	(DefaultCellInformation)iCell.getInformation();
				Integer currentHeight	=	information.getCurrentHeight();
				height	=	maximumHeight-currentHeight;
			}
			
			Rectangle rec = new Rectangle(currX, currY, iCell.getWidth(), height);
			// paint the current cell
			paintCell(g, rec, iCell,null);
			// paint the child
			paintCellsColumn(currX,currY+height,iCell.getChilds(),g,  c,maximumHeight);
			currX	=	currX+iCell.getWidth();
		}	
	}
	private void paintCellsRow(int x, int y,List<ICell> cells,Graphics g, JComponent c,Integer maximumWidth) {
		int currX	=	x;
		int currY	=	y;
		for (Iterator iterator = cells.iterator(); iterator.hasNext();) {
			ICell iCell = (ICell) iterator.next();
			Integer width	=	iCell.getWidth();
			if (iCell.getChilds()==null || iCell.getChilds().isEmpty()) {
				DefaultCellInformation information	=	(DefaultCellInformation)iCell.getInformation();
				Integer currentWidth	=	information.getCurrentWidth();
				width	=	maximumWidth-currentWidth;
			}
			
			Rectangle rec = new Rectangle(currX, currY, width, iCell.getHeight());
			// paint the current cell
			paintCell(g, rec, null,iCell);
			
			// paint the child
			paintCellsRow(currX+width,currY,iCell.getChilds(),g,  c,maximumWidth);
			currY	=	currY+iCell.getHeight();
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
