package tests.view.treeview;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

import org.myg.pivottable.swing.cells.ICell;
import org.myg.utils.IconeUtils;

import tests.CreateGraphCell;
import tests.MyCellObject;

public class TreeView extends JTree {
	

	public TreeView(DefaultMutableTreeNode rootNode) {

		
		super(rootNode);
		 this.setCellRenderer(new MyRenderer());
		 this.setRootVisible(false);
		
	}
	protected Boolean isNodeColumn(DefaultMutableTreeNode node) {
		if (node.isRoot()) return false;
		UIObject nodeObject = (UIObject) node.getUserObject();
		return ( TreeViewCst.COLUMNUI.equals(nodeObject.getName()));
	}
	protected Boolean isNodeRow(DefaultMutableTreeNode node) {
		if (node.isRoot()) return false;
		UIObject nodeObject = (UIObject) node.getUserObject();
		return ( TreeViewCst.ROWUI.equals(nodeObject.getName()));
	}
	class MyRenderer extends DefaultTreeCellRenderer {
	    Icon tableIcon 		= 	IconeUtils.getImageForTable();
	    Icon columnIcon 	=	IconeUtils.getImageForColumnsTable();
	    Icon rowIcon		= 	IconeUtils.getImageForRowsTable();
	    Icon groupIcon		=	IconeUtils.getImageForGroupCells();
	    public MyRenderer() {
	    	
	    }

	    public Component getTreeCellRendererComponent(
	                        JTree tree,
	                        Object value,
	                        boolean sel,
	                        boolean expanded,
	                        boolean leaf,
	                        int row,
	                        boolean hasFocus) {
	    	DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
	    	if (!node.isRoot()) {
	    		UIObject nodeObject = (UIObject) node.getUserObject();
	    		String libelle = (String)nodeObject.getData(TreeViewCst.LIBELLE);
	    		super.getTreeCellRendererComponent(
	                         tree, libelle, sel,
	                        expanded, leaf, row,
	                        hasFocus);
	    	}
	    	else {
	    		 super.getTreeCellRendererComponent(
	                        tree, value, sel,
	                        expanded, leaf, row,
	                        hasFocus);
	    	}
	        	
	        if (isNodeColumn(node) ) {
	            setIcon(columnIcon);
	            setToolTipText("This book is in the Tutorial series.");
	            
	        }
	        else 
	        if (isNodeRow(node) ) {
	            setIcon(rowIcon);
	            setToolTipText("This book is in the Tutorial series.");
	            
	        } 
	        else {
	        	 setIcon(groupIcon);
	            setToolTipText(null); //no tool tip
	        } 

	        return this;
	    }

	   
	}
}
