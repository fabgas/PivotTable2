package org.myg.pivottable.swing.layer.renderer;

import java.awt.Component;

import javax.swing.JLabel;

import org.myg.pivottable.swing.PivotTable;
import org.myg.pivottable.swing.cells.ICell;
import org.myg.pivottable.swing.style.BasicStyle;
import org.myg.pivottable.swing.style.IStyle;

import tests.MyCellObject;
/**
 * Renderer for a column or a row (not a valuable cell)
 * @author GASTINEAU
 *
 */
public class CellRenderer extends DefaultCellRenderer  {

	@Override
	public Component getTableCellRendererComponent(PivotTable pivotTable,Object value, ICell column, ICell row,Boolean isSelected) {
		this.setOpaque(true);
		if (value==null) {
			this.setText(null);
		}
		this.setText((String)value);
		
		setBackground(pivotTable, value, column, row, isSelected);
		setBorder(pivotTable, value, column, row, isSelected);
		setIcon(pivotTable, value, column, row);
		setFont(pivotTable, value, column, row);
		setHorizontalAlignment(JLabel.CENTER);
		
		return this;
	}

	@Override
	public IStyle getDefaultStyle() {
		return new BasicStyle();
	}

	@Override
	public IStyle getStyle(ICell cell) {
		if (cell!=null) {
			return cell.getCellStyle();
		}
		return null;
	}

	
}
