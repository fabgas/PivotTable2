package org.myg.pivottable.swing.style;

import java.awt.Color;

public class InboundStyle extends DefaultStyle {

	public Color getBackgroundColor() {
		return new Color(240,240,235);
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
		return 36;
	}
	public void setFontSize(Integer fontSize) {
		
	}
	@Override
	public Boolean isBold() {
		return false;
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
