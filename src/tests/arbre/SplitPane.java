package tests.arbre;

import javax.swing.JSplitPane;

import org.myg.pivottable.swing.PivotTable;

public class SplitPane extends JSplitPane {
	
	
	public SplitPane() {
		super();
		buildUI();
	}

	private void buildUI() {
		// instanciation du treeView
		TreeView tree = new TreeView();
		// instanciation du pivotTable
		PivotTable pivot = new PivotTable("rr");
		pivot.setOpaque(true);
		this.setLeftComponent(tree);
		this.setRightComponent(pivot);
	}
}
