package tests.view;

import javax.swing.JSplitPane;
import javax.swing.tree.DefaultMutableTreeNode;

import org.myg.pivottable.swing.PivotTable;

import tests.CreateGraphCell;
import tests.view.treeview.InitNodes;
import tests.view.treeview.TreeView;

public class MainView extends JSplitPane {

	public MainView() {
		super();
		buildUI();
	}


	private void buildUI() {
		 DefaultMutableTreeNode rootNode = rootNode = new DefaultMutableTreeNode("Root Node");
		 InitNodes.buildColumnGroup(CreateGraphCell.getGraph(), rootNode) ;
		 InitNodes.buildRowsGroup(CreateGraphCell.getGraphRows(), rootNode) ;
		  
		TreeView treeView = new TreeView(rootNode);
		this.setLeftComponent(treeView);
		PivotTable pivot = new PivotTable("pivot");
		this.setRightComponent(pivot);
	}
	

}
