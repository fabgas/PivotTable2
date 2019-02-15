package tests.view.treeview;

import java.util.Iterator;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import org.myg.pivottable.swing.cells.ICell;

import tests.MyCellObject;

public class InitNodes {

	
		public static  DefaultMutableTreeNode buildNodes(List<ICell> cells,DefaultMutableTreeNode parent) {
			// création des noeuds de premier niveau
			for (Iterator iterator = cells.iterator(); iterator.hasNext();) {
				ICell iCell = (ICell) iterator.next();
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(iCell);
				parent.add(node);
				if (iCell.getChilds()!=null && !iCell.getChilds().isEmpty()) {
					buildNodes(iCell.getChilds(), node);
				}
			}
			return parent;
		}
		public static void buildColumnGroup(List<ICell> cells,DefaultMutableTreeNode parent) {
			
			// Création d'un noeud fictif.
			UIObject ui = new UIObject(TreeViewCst.GROUPCOLUMNUI);
			ui.setData(TreeViewCst.LIBELLE, "Colonnes");
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(ui);
			parent.add(node);
			// ajout des colonnes
			buildColumnGroupRecursive(cells, node);
		}
		public static DefaultMutableTreeNode buildColumnGroupRecursive(List<ICell> cells,DefaultMutableTreeNode parent) {
			
				
			for (Iterator iterator = cells.iterator(); iterator.hasNext();) {
				ICell iCell = (ICell) iterator.next();
				UIObject uiObject 	=	toUIObject(iCell, TreeViewCst.COLUMNUI);
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(uiObject);
				parent.add(node);
				if (iCell.getChilds()!=null && !iCell.getChilds().isEmpty()) {
					buildColumnGroupRecursive(iCell.getChilds(), node);
				}
			}
			return parent;
		}
		public static void buildRowsGroup(List<ICell> cells,DefaultMutableTreeNode parent) {
	
			// Création d'un noeud fictif.
			UIObject ui = new UIObject(TreeViewCst.GROUPROWUI);
			ui.setData(TreeViewCst.LIBELLE, "Lignes");
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(ui);
			parent.add(node);
			// ajout des colonnes
			buildRowGroupRecursive(cells, node);
		}
		public static DefaultMutableTreeNode buildRowGroupRecursive(List<ICell> cells,DefaultMutableTreeNode parent) {
			
				
			for (Iterator iterator = cells.iterator(); iterator.hasNext();) {
				ICell iCell = (ICell) iterator.next();
				UIObject uiObject 	=	toUIObject(iCell, TreeViewCst.ROWUI);
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(uiObject);
				parent.add(node);
				if (iCell.getChilds()!=null && !iCell.getChilds().isEmpty()) {
					buildRowGroupRecursive(iCell.getChilds(), node);
				}
			}
			return parent;
		}
		private static UIObject toUIObject(ICell cell,String name) {
			UIObject object = new UIObject(name);
			String libelle = ((String)cell.getCellObject());
			object.setData(TreeViewCst.LIBELLE, libelle);
			return object;
		}
}
