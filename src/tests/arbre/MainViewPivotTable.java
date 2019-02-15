package tests.arbre;

import java.awt.HeadlessException;

import javax.swing.JFrame;

import tests.PivotTableUnLayer;

public class MainViewPivotTable  extends JFrame{

	public MainViewPivotTable() throws HeadlessException {
		super();
		SplitPane pane = new SplitPane();
		this.setContentPane(pane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	MainViewPivotTable pivot = new MainViewPivotTable();
		
	}
	
	
}
