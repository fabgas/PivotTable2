package org.myg.pivottable.swing.layer.focus;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import java.util.List;

import javax.swing.CellRendererPane;
import javax.swing.JComponent;
import javax.swing.JPanel;

import org.myg.pivottable.swing.cells.ICell;
import org.myg.pivottable.swing.layer.BasicPivotTableUI;
import org.myg.utils.graph.DefaultCellInformation;

public class DefaultBasicPivotTableFocusUI extends BasicPivotTableUI {

	CellRendererPane rendererPane	=	new CellRendererPane();
	public DefaultBasicPivotTableFocusUI(JComponent header) {
		super(header);

	}

	/**
	 * Paint the cells .
	 */
	@Override
	public void paint(Graphics g, JComponent c) {
		//paint vertical lines
		Integer height	=	getHeader().getHeaderColumnModel().getHeight()+getHeader().getHeaderRowModel().getHeight();
		Integer width	=	getHeader().getHeaderRowModel().getWidth();
		paintVerticalLine(g, c,width,height);
		height	=	getHeader().getHeaderColumnModel().getHeight();
		width	=	getHeader().getHeaderRowModel().getWidth()+getHeader().getHeaderColumnModel().getWidth();
		paintHorizontalLine(g, c,width,height);
	}

	private void paintVerticalLine(Graphics g, JComponent c,Integer width,Integer height) {
		ICell columnWithFocus	=	getHeader().getPivotTable().getFocusModel().getColumnFocus();
		Component component = getHeaderCellRenderer(columnWithFocus,null); 
		if (columnWithFocus!=null) {
			DefaultCellInformation info	=	(DefaultCellInformation)columnWithFocus.getInformation();
			
			AlphaComposite ac =
					AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.05f);
			((Graphics2D)g).setComposite(ac);
			Integer x	=	width+info.getCurrentWidth();
			Integer y	=	info.getCurrentHeight();
			Integer w	=	columnWithFocus.getWidth();
			Integer h	=	height-info.getCurrentHeight();
			((Graphics2D)g).setColor(Color.BLUE.brighter());
			((Graphics2D)g).fillRect(x, y, w, h);
			 ac =AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.6f);
			((Graphics2D)g).setComposite(ac);
			((Graphics2D)g).setColor(Color.BLACK);
			((Graphics2D)g).drawRect(x+1, y+1, w-2, h-2);
			
		}
	}
	private void paintHorizontalLine(Graphics g, JComponent c,Integer width,Integer height) {
		ICell rowWithFocus	=	getHeader().getPivotTable().getFocusModel().getRowFocus();

		if (rowWithFocus!=null) {
			Component component = getHeaderCellRenderer(rowWithFocus,null); 
			DefaultCellInformation info	=	(DefaultCellInformation)rowWithFocus.getInformation();
			List<ICell> isAllSpaceCells = getHeader().getHeaderColumnModel().getAllSpaceCells();
			
			Integer x = info.getCurrentWidth();
			Integer y	=	height+info.getCurrentHeight();
			Integer h	=	rowWithFocus.getHeight();

			// from last Icell to width
			Integer w	=	width-x;
			if (w>2) { // on affiche pas si pas de cellules ensuite
				paintHorizontalLine(g, x, y, w, h);
			}
			
		}
	}

	private void paintHorizontalLine(Graphics g, Integer x, Integer y,Integer w, Integer h) {
		AlphaComposite ac =
				AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.05f);
		((Graphics2D)g).setComposite(ac); // start of the cell
		
		((Graphics2D)g).setColor(Color.BLUE.brighter());
		((Graphics2D)g).fillRect(x, y, w, h);
		 ac =AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.6f);
		((Graphics2D)g).setComposite(ac);
		((Graphics2D)g).setColor(Color.BLACK);
		((Graphics2D)g).drawRect(x+1, y+1, w-2, h-2);
	}
	protected Component getHeaderCellRenderer(ICell column,ICell row) {

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0,0,255));

		return panel;

	}

}
