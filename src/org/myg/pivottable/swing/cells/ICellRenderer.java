package org.myg.pivottable.swing.cells;

import java.awt.Component;

import org.myg.pivottable.swing.PivotTable;
import org.myg.pivottable.swing.style.IStyle;

public interface ICellRenderer {
	public Component getTableCellRendererComponent(PivotTable table,Object value,
			ICell column, ICell row,Boolean isSelected) ;
	public IStyle getStyle(ICell cell);
}
