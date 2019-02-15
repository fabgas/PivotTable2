package org.myg.utils.graph;

public class DefaultCellInformation implements ICellInformation {
	
	private Boolean visit = false;
	@Override
	public Boolean isVisit() {
		return visit;
	}

	@Override
	public void setVisit(Boolean visit) {
		this.visit	=	visit;
		
	}
	private Integer currentHeight=0;
	private Integer modifyHeight=0;
	private Integer currentWidth=0;
	private Integer modifyWidth=0;
	private Integer currentPreferredHeight=0;
	private Integer currentPreferredWidth=0;
	private Integer currentMinimumuHeight=0;
	private Integer currentMinimumWidth=0;
	private Integer currentMaximumuHeight=0;
	private Integer currentMaximumWidth=0;
	
	public Integer getCurrentHeight() {
		return currentHeight;
	}
	
	public void setCurrentHeight(Integer height) {
		currentHeight	=	height;
	}

	public Integer getCurrentWidth() {
		return currentWidth;
	}

	public void setCurrentWidth(Integer currentWidth) {
		this.currentWidth = currentWidth;
	}

	public Integer getCurrentPreferredHeight() {
		return currentPreferredHeight;
	}

	public void setCurrentPreferredHeight(Integer currentPreferredHeight) {
		this.currentPreferredHeight = currentPreferredHeight;
	}

	public Integer getCurrentPreferredWidth() {
		return currentPreferredWidth;
	}

	public void setCurrentPreferredWidth(Integer currentPreferredWidth) {
		this.currentPreferredWidth = currentPreferredWidth;
	}

	public Integer getCurrentMinimumHeight() {
		return currentMinimumuHeight;
	}

	public void setCurrentMinimumHeight(Integer currentMinimumuHeight) {
		this.currentMinimumuHeight = currentMinimumuHeight;
	}

	public Integer getCurrentMinimumWidth() {
		return currentMinimumWidth;
	}

	public void setCurrentMinimumWidth(Integer currentMinimumWidth) {
		this.currentMinimumWidth = currentMinimumWidth;
	}

	public Integer getCurrentMaximumHeight() {
		return currentMaximumuHeight;
	}

	public void setCurrentMaximumHeight(Integer currentMaximumuHeight) {
		this.currentMaximumuHeight = currentMaximumuHeight;
	}

	public Integer getCurrentMaximumWidth() {
		return currentMaximumWidth;
	}

	public void setCurrentMaximumWidth(Integer currentMaximumWidth) {
		this.currentMaximumWidth = currentMaximumWidth;
	}

	public Integer getModifyHeight() {
		return modifyHeight;
	}

	public void setModifyHeight(Integer modifyHeight) {
		this.modifyHeight = modifyHeight;
	}

	public Integer getModifyWidth() {
		return modifyWidth;
	}

	public void setModifyWidth(Integer modifyWidth) {
		this.modifyWidth = modifyWidth;
	}
	
}
