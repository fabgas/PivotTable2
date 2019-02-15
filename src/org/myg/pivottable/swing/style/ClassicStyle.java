package org.myg.pivottable.swing.style;

import java.awt.Color;

public class ClassicStyle extends DefaultStyle {
	private Color backgroundColor;
	private Color foregroundColor;
	private Boolean bold;
	private Boolean underlined;
	private Boolean italic;
	private Integer fontSize;
	public Color getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public Color getForegroundColor() {
		return foregroundColor;
	}
	public void setForegroundColor(Color foregroundColor) {
		this.foregroundColor = foregroundColor;
	}
	
	public void setBold(Boolean bold) {
		this.bold = bold;
	}
	
	public void setUnderlined(Boolean underlined) {
		this.underlined = underlined;
	}
	
	public void setItalic(Boolean italic) {
		this.italic = italic;
	}
	public Integer getFontSize() {
		return fontSize;
	}
	public void setFontSize(Integer fontSize) {
		this.fontSize = fontSize;
	}
	@Override
	public Boolean isBold() {
		return bold;
	}
	@Override
	public Boolean isUnderlined() {
		return underlined;
	}
	@Override
	public Boolean isItalic() {
		return italic;
	}
	
	
}
