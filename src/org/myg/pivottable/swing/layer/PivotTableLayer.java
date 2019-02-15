package org.myg.pivottable.swing.layer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComponent;

import org.myg.pivottable.swing.PivotTable;
import org.myg.pivottable.swing.cells.ICell;
import org.myg.pivottable.swing.model.header.IPivotTableHeaderModel;

public class PivotTableLayer extends JComponent {
	private PivotTable pivotTable = null;


	public PivotTableLayer(PivotTable pivotTable) {
		super();
		this.pivotTable = pivotTable;
		this.setBackground(Color.BLACK);
		setOpaque(false); // important sinon les layers inférieurs sont non visibles !
		//Calculation of the initial bound
		setBounds(0,0,10000,1000); // important sinon les layers inférieurs sont non visibles
		
	}
	public IPivotTableHeaderModel getHeaderRowModel() {
		return pivotTable.getRowHeaderModel();
	}

	public IPivotTableHeaderModel getHeaderColumnModel() {
		return pivotTable.getColumnHeaderModel();
	}
	public Component prepareRenderer(ICell column, ICell row) {
	return null;

	}

	public PivotTable getPivotTable() {
		return pivotTable;
	}

	public void setPivotTable(PivotTable pivotTable) {
		this.pivotTable = pivotTable;
	}
	@Override
	public Dimension getPreferredSize() {
		Integer totalWidth	=	getHeaderColumnModel().getPreferredWidth()+getHeaderRowModel().getPreferredWidth();
		Integer totalHeight =   getHeaderColumnModel().getPreferredHeight()+getHeaderRowModel().getPreferredHeight();
		return new Dimension(totalWidth,totalHeight);
	}
	@Override
	public Dimension getMaximumSize() {
		Integer totalWidth	=	getHeaderColumnModel().getMaximumWidth()+getHeaderRowModel().getMaximumWidth();
		Integer totalHeight =   getHeaderColumnModel().getMaximumHeight()+getHeaderRowModel().getMaximumHeight();
		return new Dimension(totalWidth,totalHeight);
	}
	@Override
	public Dimension getMinimumSize() {
		Integer totalWidth	=	getHeaderColumnModel().getMinimumWidth()+getHeaderRowModel().getMinimumWidth();
		Integer totalHeight =   getHeaderColumnModel().getMinimumHeight()+getHeaderRowModel().getMinimumHeight();
		return new Dimension(totalWidth,totalHeight);
	}
	
	
}
