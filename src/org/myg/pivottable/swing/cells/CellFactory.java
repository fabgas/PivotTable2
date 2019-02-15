package org.myg.pivottable.swing.cells;

import org.myg.pivottable.swing.layer.renderer.CellRenderer;
import org.myg.pivottable.swing.layer.renderer.DataCellRenderer;
import org.myg.pivottable.swing.style.BasicStyle;
import org.myg.pivottable.swing.style.BasicValueStyle;
import org.myg.pivottable.swing.style.IStyle;

/**
 * Factory for building new cell
 * @author GASTINEAU
 *
 */
public class CellFactory {
	
	private Integer minimumWidth;
	private Integer maximumWidth;
	private Integer preferredWidth;
	private Integer preferredHeight;
	private Integer minimumHeight;
	private Integer maximumHeight;
	private ICellRenderer dataCellRenderer;
	private ICellRenderer headerCellRenderer;
	private IStyle headerStyle = new BasicStyle();
	private IStyle cellStyle = new BasicValueStyle();
	
	/**
	 * Create a new Instance of a Cell for a Header with some 
	 * information
	 * @param id
	 * @return
	 */
	public  ICell createHeaderCell(String id) {
		ICell cell =  new DefaultHeaderCell();
		cell.setIdentifier(id);
		cell.setHeaderCellRenderer( new CellRenderer());
		cell.setCellStyle(headerStyle);
		cell.setDataCellStyle(cellStyle);
		cell.setDataCellRenderer(new DataCellRenderer());
		return cell;
	}
	public Integer getMinimumWidth() {
		return minimumWidth;
	}
	public void setMinimumWidth(Integer minimumWidth) {
		this.minimumWidth = minimumWidth;
	}
	public Integer getMaximumWidth() {
		return maximumWidth;
	}
	public void setMaximumWidth(Integer maximumWidth) {
		this.maximumWidth = maximumWidth;
	}
	public Integer getPreferredWidth() {
		return preferredWidth;
	}
	public void setPreferredWidth(Integer preferredWidth) {
		this.preferredWidth = preferredWidth;
	}
	public Integer getPreferredHeight() {
		return preferredHeight;
	}
	public void setPreferredHeight(Integer preferredHeight) {
		this.preferredHeight = preferredHeight;
	}
	public Integer getMinimumHeight() {
		return minimumHeight;
	}
	public void setMinimumHeight(Integer minimumHeight) {
		this.minimumHeight = minimumHeight;
	}
	public Integer getMaximumHeight() {
		return maximumHeight;
	}
	public void setMaximumHeight(Integer maximumHeight) {
		this.maximumHeight = maximumHeight;
	}
	public ICellRenderer getDataCellRenderer() {
		return dataCellRenderer;
	}
	public void setDataCellRenderer(ICellRenderer dataCellRenderer) {
		this.dataCellRenderer = dataCellRenderer;
	}
	public ICellRenderer getHeaderCellRenderer() {
		return headerCellRenderer;
	}
	public void setHeaderCellRenderer(ICellRenderer headerCellRenderer) {
		this.headerCellRenderer = headerCellRenderer;
	}
	public IStyle getHeaderStyle() {
		return headerStyle;
	}
	public void setHeaderStyle(IStyle headerStyle) {
		this.headerStyle = headerStyle;
	}
	public IStyle getCellStyle() {
		return cellStyle;
	}
	public void setCellStyle(IStyle cellStyle) {
		this.cellStyle = cellStyle;
	}
	

}
