package org.myg.utils;

import javax.swing.ImageIcon;

public class IconeLoading {
	
	// chemin vers les images
	private String path="/images/";
	
	public IconeLoading(String path) {
		super();
		this.path = path;
	}

	public ImageIcon getImage(String name) {
		return createImageIcon(path+name, "No description");
	}
	
	protected  ImageIcon createImageIcon(String path,
			String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}
