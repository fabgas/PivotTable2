package tests;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;

import org.myg.pivottable.swing.PivotTable;



public class PivotTableUnLayer extends JFrame{

	public PivotTableUnLayer() throws HeadlessException {
	
		JScrollPane scrollPane = new JScrollPane();
		MigLayout layout = new MigLayout("wrap 1");
		
		
		PivotTable pivot = new PivotTable("pivot");
		PivotTable pivot2 = new PivotTable("pivot2" );
//		panel.add(pivot2,"wrap");
		scrollPane.getViewport().add(pivot);
		//Create and set up the content pane.
		pivot.setOpaque(true); //content panes must be opaque
		pivot2.setOpaque(true); //content panes must be opaque
        this.setContentPane(scrollPane);
      
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PivotTableUnLayer uii = new PivotTableUnLayer();
		
	}

}
