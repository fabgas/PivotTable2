package org.myg.pivottable.swing.cells;

import java.util.List;

import org.myg.pivottable.swing.style.IStyle;
import org.myg.utils.graph.ICellInformation;
/**
 * Cell interface (equivalent to Tablecolumn) 
 * @author GASTINEAU
 *
 */
public interface ICell {
	
	// identifier of the cell
	public String getIdentifier();
	public void setIdentifier(String identifier);
	// size information
	public Integer getMinimumWidth();
	public Integer getMaximumWidth();
	public Integer getWidth();
	public Integer getPreferredWidth();
	public Integer getMinimumHeight();
	public Integer getMaximumHeight();
	public Integer getHeight();
	public Integer getPreferredHeight();
	public void setMinimumWidth(Integer minimumWidth);
	public void setMaximumWidth(Integer maximumWidth);
	public void setPreferredWidth(Integer preferredWidth);
	public void setWidth(Integer width);
	public void setMinimumHeight(Integer minimumHeight);
	public void setMaximumHeight(Integer maximumHeight);
	public void setPreferredHeight(Integer preferredHeight);
	public void setHeight(Integer height);
	// child information
	public List<ICell> getChilds();
	public void setChilds(List<ICell> childs);
	// cell value
	public Object getCellObject();
	public void setCellObject(Object cellObject);
	// space option : set if the row or the column take all the space
	public Boolean isAllSpace();
	public void setAllSpace(Boolean isAllSpace);
	// manage the cells style (does it has to be here ? or in a model ?)
	public IStyle getCellStyle();
	public IStyle getDataCellStyle();
	public IStyle setCellStyle(IStyle style);
	public IStyle setDataCellStyle(IStyle dateStyle);
	// the cell renderer's for the header and the data
	public ICellRenderer getHeaderCellRenderer();
	public ICellRenderer getDataCellRenderer();
	public void setHeaderCellRenderer(ICellRenderer renderer);
	public void setDataCellRenderer(ICellRenderer renderer);
	// for the visiting mechanism
	public ICellInformation getInformation();
	public void setInformation(ICellInformation information);
}
