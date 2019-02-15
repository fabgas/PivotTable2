package org.myg.utils;

import javax.swing.ImageIcon;

public class IconeUtils {
	private static IconeLoading iconLoading = new IconeLoading("/images/");
	
	public static ImageIcon getImageForTable() {
		return iconLoading.getImage("layout.png");
	}
	public static ImageIcon getImageForColumnsTable() {
		return iconLoading.getImage("layout_vertical.png");
	}
	public static ImageIcon getImageForRowsTable() {
		return iconLoading.getImage("layout_horizontal.png");
	}
	public static ImageIcon getImageForGroupCells() {
		return iconLoading.getImage("group.png");
	}
	
}
