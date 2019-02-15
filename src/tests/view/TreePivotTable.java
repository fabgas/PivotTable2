package tests.view;

import java.awt.HeadlessException;

import javax.swing.JFrame;



public class TreePivotTable extends JFrame{

	public TreePivotTable() throws HeadlessException {
	
		
		
		MainView mainView = new MainView();
        this.setContentPane(mainView);
      
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TreePivotTable uii = new TreePivotTable();
		
	}

}
