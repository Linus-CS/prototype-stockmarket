package de.linus.prototypeStock.render.resources;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Class holding all image instances
 * that can be loaded pre-init.
 * 
 * @author linus
 *
 */
public class Images {
	public static final Image LOGO = loadImage("stock_market_logo.png");
	public static final Image ICON = loadImage("icon.png");
	public static final Image SHADOW = loadImage("shadow.png");
	public static final Image SETTINGS = loadImage("gear.png");
	public static final Image BACK = loadImage("back.png");
	
	/**
	 * Loads images from inside the jar.
	 * 
	 * @param path
	 * @return
	 */
	private static Image loadImage(String path) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(Images.class.getClassLoader().getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}
