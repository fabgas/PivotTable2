package org.myg.pivottable.swing.cells;

import java.util.List;

import org.myg.pivottable.swing.style.IStyle;
import org.myg.utils.graph.DefaultCellInformation;
import org.myg.utils.graph.ICellInformation;

public class DefaultCell implements ICell {
	private String identifier;
	private Integer minimumWidth;
	private Integer maximumWidth;
	private Integer preferredWidth;
	private Integer width;
	private Integer minimumHeight;
	private Integer maximumHeight;
	private Integer preferredHeight;
	private Integer height;
	private Object  cellObject;
	private List<ICell> childs = new CellList();
	private Boolean allSpace = Boolean.FALSE;
	private IStyle cellStyle;
	private IStyle dataCellStyle;
	private ICellRenderer headerCellRenderer;
	private ICellRenderer dataCellRenderer;
	private DefaultCellInformation information;

	@Override
	public String getIdentifier() {
		return identifier;
	}

	@Override
	public void setIdentifier(String identifier) {
		this.identifier	= identifier;
	}

	@Override
	public Integer getMinimumWidth() {
		return minimumWidth;
	}

	@Override
	public Integer getMaximumWidth() {
		return maximumWidth;
	}

	@Override
	public Integer getWidth() {
		return width;
	}

	@Override
	public Integer getMinimumHeight() {
		return minimumHeight;
	}

	@Override
	public Integer getMaximumHeight() {
		return maximumHeight;
	}

	@Override
	public Integer getHeight() {
		return height;
	}

	@Override
	public void setMinimumWidth(Integer minimumWidth) {
		this.minimumWidth	=	minimumWidth;
	}

	@Override
	public void setMaximumWidth(Integer maximumWidth) {
		this.maximumWidth	=	maximumWidth;
	}

	@Override
	public void setWidth(Integer width) {
		this.width	=	width;
	}

	@Override
	public void setMinimumHeight(Integer minimumHeight) {
		this.minimumHeight	=	minimumHeight;
	}

	@Override
	public void setMaximumHeight(Integer maximumHeight) {
		this.maximumHeight	=	maximumHeight;	
	}

	@Override
	public void setHeight(Integer height) {
		this.height	=	height;
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

	@Override
	public List<ICell> getChilds() {
		return childs;
	}

	@Override
	public void setChilds(List<ICell> childs) {
		this.childs	= childs;
	}

	@Override
	public Object getCellObject() {
		return cellObject;
	}

	@Override
	public void setCellObject(Object cellObject) {
		this.cellObject	=	cellObject;
	}

	@Override
	public Boolean isAllSpace() {
		return allSpace;
	}

	@Override
	public void setAllSpace(Boolean allSpace) {
		this.allSpace	=	allSpace;
	}

	@Override
	public IStyle getCellStyle() {
		return cellStyle;
	}

	@Override
	public IStyle getDataCellStyle() {
		return dataCellStyle;
	}

	@Override
	public IStyle setCellStyle(IStyle style) {
		this.cellStyle	=	style;
		return style;
	}

	@Override
	public IStyle setDataCellStyle(IStyle dataStyle) {
		this.dataCellStyle	=	dataStyle;
		return dataCellStyle;
	}
	@Override
	public ICellRenderer getHeaderCellRenderer() {
		return headerCellRenderer;
	}
	@Override
	public void setHeaderCellRenderer(ICellRenderer headerCellRenderer) {
		this.headerCellRenderer = headerCellRenderer;
	}
	@Override
	public ICellRenderer getDataCellRenderer() {
		return dataCellRenderer;
	}
	@Override
	public void setDataCellRenderer(ICellRenderer dataCellRenderer) {
		this.dataCellRenderer = dataCellRenderer;
	}
	

	public Boolean getAllSpace() {
		return allSpace;
	}

	@Override
	public ICellInformation getInformation() {
		if (information==null) {
			information	=	new DefaultCellInformation();
		}
		return information;
	}

	@Override
	public void setInformation(ICellInformation information) {
		this.information	=	this.information;
	}

	@Override
	public boolean equals(Object obj) {
		ICell cell	=	(ICell)obj;
		if (obj==null) return false;
		return cell.getIdentifier().equals(this.getIdentifier());
	}

	
	
	
}
