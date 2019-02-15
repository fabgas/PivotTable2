package org.myg.pivottable.swing.layer.renderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

import org.myg.pivottable.swing.PivotTable;
import org.myg.pivottable.swing.cells.ICell;
import org.myg.pivottable.swing.cells.ICellRenderer;
import org.myg.pivottable.swing.style.IStyle;

public abstract class DefaultCellRenderer extends JLabel implements ICellRenderer {

	public DefaultCellRenderer() {
		super();
	}

	@Override
	public Component getTableCellRendererComponent(PivotTable table,
			Object value, ICell column, ICell row, Boolean isSelected) {
	
		return null;
	}



	/**
	 * Set the background color of this label. 
	 * 				First  : check if it is override
	 * 				Second : check if column have a style
	 * 				Third  : at least get the row style
	 * @param pivotTable
	 * @param value
	 * @param column
	 * @param row
	 * @param isSelected
	 */
	protected void setBackground(PivotTable pivotTable, Object value, ICell column,
			ICell row, Boolean isSelected) {
				if (!isSelected ) {
					Color colorTable = pivotTable.getCellBackgroundColor(value,column, row);
					if (colorTable!=null) {
						this.setBackground(colorTable);
					}
					else {
						IStyle style = getStyle(column,row);
						if (style!=null) {
							this.setBackground(style.getBackgroundColor());
						}
						else {
							this.setBackground(getDefaultStyle().getBackgroundColor());
							}
					}	
				}
				else
					if (isSelected) {
						this.setBackground(Color.RED);
					}
			}

	/**
	 * Set the border of  a cell
	 * @param pivotTable
	 * @param value
	 * @param column
	 * @param row
	 * @param isSelected
	 */
	protected void setBorder(PivotTable pivotTable, Object value, ICell column,
			ICell row, Boolean isSelected) {
				if (!isSelected) {
					Border lBorder = pivotTable.getCellBorder(value,column, row);
					if (lBorder == null) {
						lBorder = BorderFactory.createEtchedBorder();  
					}
					this.setBorder(lBorder);
				}
			}

	/**
	 * Set an icon for a cell
	 * @param pivotTable
	 * @param value
	 * @param column
	 * @param row
	 */
	protected void setIcon(PivotTable pivotTable, Object value, ICell column, ICell row) {
			setIcon(pivotTable.getCellIcon(value ,column, row));
	}
	
	protected void setFont(PivotTable pivotTable, Object value, ICell column, ICell row) {
			Font font = pivotTable.getCellFont(value, column, row);
			if (font ==null) {
				IStyle style = getStyle(column, row);
					if (style==null) {
						style = getDefaultStyle();
					
					}
					font = style.getFont(this.getFont());
			}
			this.setFont(font);
	}
	/**
	 * Return the style for the cell
	 * @param column
	 * @param row
	 * @return
	 */
	protected IStyle getStyle( ICell column,ICell row) {
		
		IStyle styleColumn = getStyle(column);
		
		IStyle styleRow = getStyle(row);
		if (column != null && row != null) {
			if (column.getDataCellStyle()!=null) {
				return column.getDataCellStyle();
			}
			else 
				if (row.getDataCellStyle()!=null) {
					return row.getDataCellStyle();
				}
		}
		if (styleColumn!=null) {
			return styleColumn;
		}
		else 
			if (styleRow!=null) {
				return styleRow;
			}
		return null;
	}
	
	public abstract IStyle getDefaultStyle() ;
	@Override
	public IStyle getStyle(ICell cell) {
		if (cell!=null) {
			return cell.getCellStyle();
		}
		return null;
	}
}