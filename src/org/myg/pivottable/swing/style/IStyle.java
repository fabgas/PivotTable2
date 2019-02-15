package org.myg.pivottable.swing.style;

import java.awt.Color;
import java.awt.Font;

public interface IStyle {
	
	public Color getBackgroundColor();
	public Color getForegroundColor();
	public Integer getFontSize();
	public Boolean isBold();
	public Boolean isUnderlined();
	public Boolean isItalic();
	public void setBackgroundColor(Color background);
	public void setForegroundColor(Color foreground);
	public void setFontSize(Integer fontSize);
	public void setBold(Boolean bold);
	public void setUnderlined(Boolean underlined);
	public void setItalic(Boolean italic);
	public Font getFont(Font font);
}
