package tests;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class TestLayered extends JPanel {
    private JLayeredPane layeredPane;
	public TestLayered() {
		super();
		layeredPane = new JLayeredPane();
	        layeredPane.setPreferredSize(new Dimension(300, 310));
	        layeredPane.setBorder(BorderFactory.createTitledBorder(
	                                    "Move the Mouse to Move Duke"));
	     

	        //Add several labels to the layered pane.
	        layeredPane.setLayout(new GridLayout(2,3));
	}

	
	
}
