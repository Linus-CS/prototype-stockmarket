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
	public static final Image icon = loadImage("stock_market_icon.jpeg");
	public static final Image logo = loadImage("stock_market_logo.png");
	public static final Image search = loadImage("search.png");
	
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
