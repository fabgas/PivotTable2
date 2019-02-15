package org.myg.pivottable.swing.layer.header;

import java.awt.Color;
import java.awt.Component;

import org.myg.pivottable.swing.PivotTable;
import org.myg.pivottable.swing.cells.ICell;
import org.myg.pivottable.swing.layer.PivotTableLayer;

public class DefaultPivotTableHeader extends PivotTableLayer {

	public DefaultPivotTableHeader(PivotTable pivotTable) {
		super(pivotTable);
		setUI(new DefaultBasicPivotTableHeaderUI(this));
		setBackground(Color.black);
		setOpaque(false);
	}
	@Override

	public Component prepareRenderer(ICell column, ICell row) {
		Boolean isSelected	=	 getPivotTable().isSelected(column, row);
		if (column!=null && row==null) {
			Object cellObject = (Object) column.getCellObject();
			return column.getHeaderCellRenderer().getTableCellRendererComponent(this.getPivotTable(),cellObject, column, row,isSelected);
		}
		else
			if (column==null && row!=null) {
				Object cellObject = (Object) row.getCellObject();	
				return row.getHeaderCellRenderer().getTableCellRendererComponent(this.getPivotTable(),cellObject, column, row,isSelected);
			}
			else
				if (column!=null && row!=null) {
					return row.getHeaderCellRenderer().getTableCellRendererComponent(this.getPivotTable(),"DATA", column, row,isSelected);
				}	
		return null;
	}
}
