package org.myg.pivottable.swing.layer.data;

import java.awt.Component;

import org.myg.pivottable.swing.PivotTable;
import org.myg.pivottable.swing.cells.ICell;
import org.myg.pivottable.swing.layer.PivotTableLayer;

import tests.MyCellObject;

public class DefaultPivotTableData extends PivotTableLayer {

	public DefaultPivotTableData(PivotTable pivotTable) {
		super(pivotTable);
		setUI(new DefaultBasicPivotTableDataUI(this));
		
	}

	public Component prepareRenderer(ICell column, ICell row) {
		if (column!=null && row==null) {
			String object = (String)column.getCellObject();
		return column.getDataCellRenderer().getTableCellRendererComponent(this.getPivotTable(),"DATA", column, row,false);
		}
		else
			if (column==null && row!=null) {
				String object = (String)row.getCellObject();
				return row.getDataCellRenderer().getTableCellRendererComponent(this.getPivotTable(),"DATA", column, row,false);
			}
			else
				if (column!=null && row!=null) {
					return row.getDataCellRenderer().getTableCellRendererComponent(this.getPivotTable(),"DATA", column, row,false);
				}	
		return null;
	}
}
