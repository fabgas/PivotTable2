package org.myg.pivottable.swing.layer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.CellRendererPane;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.plaf.ComponentUI;

import org.myg.pivottable.swing.cells.ICell;

public class BasicPivotTableUI extends PivotTableUI {
	
	// header reference 
	PivotTableLayer header 		= null;
	CellRendererPane rendererPane	=	new CellRendererPane();
	public BasicPivotTableUI(JComponent header) {
		super();
		this.header =(PivotTableLayer) header;
	}
	public void paint(Graphics g, JComponent c) {
		 // why are they doing a renderPane.removeAll in the TableHeader class ?
	 }
	/**
	 * Share method to paint one cell of the header or a value cell.
	 * Derivative class calls this methods from paint method
	 * @param g
	 * @param cellRect
	 * @param columnIndex
	 */
	protected void paintCell(Graphics g, Rectangle cellRect, ICell column, ICell row) {
	        Component component = getHeaderCellRenderer(column,row); 
	      
	        rendererPane.paintComponent(g, component, header, cellRect.x, cellRect.y,
	                            cellRect.width, cellRect.height, true);
	 }

	  
	/**
	 * Return the renderer for the cell
	 */

	protected Component getHeaderCellRenderer(ICell column,ICell row) {
		if (column == null && row==null) {
			JPanel panel = new JPanel();
			panel.setPreferredSize(new Dimension(300,60));
			panel.setBackground(new Color(0,255,0));
			return panel;
		}
		return getHeader().prepareRenderer(column,row);
	}
	
	  /**
	   * Create the UI component.Itself
	   * @param h
	   * @return
	   */
	 public static ComponentUI createUI(JComponent h) {
	        return new BasicPivotTableUI(h);
	}
	
	@Override
	public void installUI(JComponent c) {
		// do the link between pivotTableHeader and this class
		setHeader((PivotTableLayer)c);
		// initialize the pane
		rendererPane = new CellRendererPane();
	    header.add(rendererPane);
	    // initialize the default colors from Look and feel
	    installDefaults();
        installListeners();
        installKeyboardActions();
	}


    public void uninstallUI(JComponent c) {
        uninstallDefaults();
        uninstallListeners();
        uninstallKeyboardActions();

        header.remove(rendererPane);
        rendererPane = null;
        header = null;
    }

    
	public PivotTableLayer getHeader() {
		return header;
	}

	public void setHeader(PivotTableLayer header) {
		this.header = header;
	}
    /**
     * Initialize PivotTableHeader properties, e.g. font, foreground, and background.
     * The font, foreground, and background properties are only set if their
     * current value is either null or a UIResource, other properties are set
     * if the current value is null.
     * We used the JTable one 
     *
     * @see #installUI
     */
    protected void installDefaults() {
        LookAndFeel.installColorsAndFont(header, "TableHeader.background",
                                         "TableHeader.foreground", "TableHeader.font");
        LookAndFeel.installProperty(header, "opaque", Boolean.TRUE);
    }
   
    /**
     * Initialize the listeners for the pivot table
     */
    protected void installListeners() {
    	

           
    }
    
    
    protected void installKeyboardActions() {
    }
    protected void uninstallDefaults() {}

    protected void uninstallListeners() {

    }
    protected void uninstallKeyboardActions() {
      
    }
 

}
