package org.myg.pivottable.swing.style;

import java.awt.Color;
import java.awt.Font;

public class DefaultStyle implements IStyle {

	@Override
	public Color getBackgroundColor() {
	
		return null;
	}

	@Override
	public Color getForegroundColor() {
		
		return null;
	}

	@Override
	public Integer getFontSize() {
	
		return null;
	}

	@Override
	public Boolean isBold() {
		
		return null;
	}

	@Override
	public Boolean isUnderlined() {
		
		return null;
	}

	@Override
	public Boolean isItalic() {
		return null;
	}

	@Override
	public void setBackgroundColor(Color background) {
		
	}

	@Override
	public void setForegroundColor(Color foreground) {
	
	}

	@Override
	public void setFontSize(Integer fontSize) {
		
	}

	@Override
	public void setBold(Boolean bold) {
			
	}

	@Override
	public void setUnderlined(Boolean underlined) {
	}

	@Override
	public void setItalic(Boolean italic) {
		}

	@Override
	public Font getFont(Font font) {
		// build a font 
		int fontType = font.PLAIN;
		if (isBold() && isItalic()) {
			fontType =  Font.ITALIC | Font.BOLD;
		}
		else 
			if (isBold()) {
				fontType =   Font.BOLD;
			}
			else
				if(isItalic()) {
					fontType =  Font.ITALIC;
				}
		Font newFont = new Font(font.getFontName(), fontType, getFontSize());
		return newFont;
	}

}
