package org.myg.pivottable.swing.style;

import java.awt.Color;

public class BasicStyle extends DefaultStyle {

	public Color getBackgroundColor() {
		return new Color(212, 212, 212);
	}
	public void setBackgroundColor(Color backgroundColor) {
		
	}
	public Color getForegroundColor() {
		return Color.BLACK;
	}
	public void setForegroundColor(Color foregroundColor) {
		
	}
	
	public void setBold(Boolean bold) {
		
	}
	
	public void setUnderlined(Boolean underlined) {
		
	}
	
	public void setItalic(Boolean italic) {
	
	}
	public Integer getFontSize() {
		return 12;
	}
	public void setFontSize(Integer fontSize) {
		
	}
	@Override
	public Boolean isBold() {
		return true;
	}
	@Override
	public Boolean isUnderlined() {
		return false;
	}
	@Override
	public Boolean isItalic() {
		return true;
	}
	
	
}
