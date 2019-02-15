package tests;

import java.util.List;

import org.myg.pivottable.swing.cells.ICell;
import org.myg.utils.graph.ActionOnGraphCalculSizeHeight;
import org.myg.utils.graph.ActionOnGraphCalculSizeWidth;
import org.myg.utils.graph.ActionOnGraphPrintHeight;
import org.myg.utils.graph.ActionOnGraphPrintWidth;
import org.myg.utils.graph.CellTraversalMechanismDFS;
import org.myg.utils.graph.GraphTraversal;
import org.myg.utils.graph.ICellTraversalMechanism;

public class GraphsManipulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// construction d'un graph
		
		calculateWidth();
		calculateHeight();
	}

	private static void calculateWidth() {
		List<ICell> graph = CreateGraphCell.getGraph();
		// creation du mechanism
		ICellTraversalMechanism mechanism = new CellTraversalMechanismDFS();
		mechanism.addAction(new ActionOnGraphCalculSizeWidth());
		mechanism.addAction(new ActionOnGraphPrintWidth());
		GraphTraversal traversal = new GraphTraversal(mechanism);
		List<ICell> cells = traversal.traverseGraph(graph);
		
	}
	private static void calculateHeight() {
		List<ICell> graph = CreateGraphCell.getGraph();
		// creation du mechanism
		ICellTraversalMechanism mechanism = new CellTraversalMechanismDFS();
		mechanism.addAction(new ActionOnGraphCalculSizeHeight());
		mechanism.addAction(new ActionOnGraphPrintHeight());
		GraphTraversal traversal = new GraphTraversal(mechanism);
		List<ICell> cells = traversal.traverseGraph(graph);
		
	}
}
