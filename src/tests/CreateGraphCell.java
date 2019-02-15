package tests;

import java.util.List;

import org.myg.pivottable.swing.cells.CellFactory;
import org.myg.pivottable.swing.cells.CellList;
import org.myg.pivottable.swing.cells.DefaultCell;
import org.myg.pivottable.swing.cells.ICell;

public class CreateGraphCell {
	static CellFactory factory = new CellFactory();
	/*
	 *      ---------------------------------------------------
	 *      |          A           |        B        |    C   |
	 *      -----------------------------------------|        |
	 *      |   A1       |     A2  |    B1  |   B2   |        |
	 *      -------------|         |        |        |        |
	 *      |  A11 | A12 |         |        |        |        |
	 *      --------------------------------------------------- 
	 * 
	 */
	public static List<ICell> getGraph() {
		List<ICell> cellToReturn = new CellList();
		
		ICell cellA 	= getCell("A");
	  	ICell cellB 	= getCell("B");
		ICell cellC 	= getCell("C");
		ICell cellA1 	= getCell("A1");
		ICell cellA2 	= getCell("A2");
		ICell cellA11 = getCell("A11");
		ICell cellA12 = getCell("A12");
		cellA12.setAllSpace(true);
		ICell cellB1 	= getCell("B1");
		ICell cellB2 	= getCell("B2");
//		cellB1.setAllSpace(true);
		
//		addChild(cellA1, cellA11);
//		addChild(cellA1, cellA12);
	
		addChild(cellA, cellA1);
		addChild(cellA, cellA2);
		addChild(cellA, cellA11);
		addChild(cellA, cellA12);
		if (false) {
			ICell cellA13 = getCell("A13");
			ICell cellA14 = getCell("A14");
			ICell cellA15 = getCell("A15");
			ICell cellA16 = getCell("A16");
			addChild(cellA1, cellA13);
			addChild(cellA1, cellA14);
			addChild(cellA1, cellA15);
			addChild(cellA1, cellA16);
		}
		addChild(cellB, cellB1);
		addChild(cellB, cellB2);
		cellToReturn.add(cellA);
		cellToReturn.add(cellB);
		cellToReturn.add(cellC);
//		cellC.setAllSpace(true);
		cellC.setPreferredWidth(50);
//		cellA11.setPreferredWidth(100);
		return cellToReturn;
	}
	/*
	 *      ---------------------------------------------------
	 *      |          A           |       			     A11  |
	 *      |                      |__________________________| 
	 *      |                      |                     A13   |
	 *      --------------------------------------------------|
	 *      |   A1       |     A2  |    B1  |   B2   |        |
	 *      -------------|         |        |        |        |
	 *      |  A11 | A12 |         |        |        |        |
	 *      --------------------------------------------------- 
	 * 
	 */
	public static List<ICell> getGraphRows() {
		List<ICell> cellToReturn = new CellList();
		
		ICell cellA 	= getCell("RA");
		ICell cellC 	= getCell("RC");
		ICell cellA1 	= getCell("A1");
		ICell cellA2 	= getCell("A2");
		ICell cellA11 = getCell("A11");
		ICell cellA12 = getCell("A12");
		ICell cellA13 = getCell("A13");
		ICell cellA14 = getCell("A14");
		cellA14.setAllSpace(true);
		addChild(cellA1, cellA11);
		addChild(cellA1, cellA12);
		addChild(cellA1, cellA13);
		addChild(cellA1, cellA14);
		
		addChild(cellA, cellA1);
		addChild(cellA, cellA2);
		cellToReturn.add(cellA);
		cellToReturn.add(cellC);
		cellC.setAllSpace(true);
		cellC.setPreferredWidth(50);
		cellA11.setPreferredWidth(100);
		return cellToReturn;
	}
	public static ICell getCell(String libelle) {
		ICell cell = factory.createHeaderCell(libelle);
		
		cell.setPreferredWidth(50);
		cell.setMinimumWidth(50);
		cell.setMaximumWidth(80);
		cell.setWidth(50);
		cell.setPreferredHeight(30);
		cell.setMinimumHeight(20);
		cell.setMaximumHeight(50);
		cell.setHeight(30);
		MyCellObject obj = new MyCellObject(libelle);
		cell.setCellObject(libelle);
		return cell;
	}
	
	public static void addChild(ICell cellFather,ICell cellChild) {
		 cellFather.getChilds().add(cellChild);
	}
}
