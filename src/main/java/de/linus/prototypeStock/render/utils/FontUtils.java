package de.linus.prototypeStock.render.utils;

import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

/**
 * Containing general info about fonts 
 * that are used in the project.
 * 
 * @author Linus
 *
 */
public class FontUtils {

	private static String mainFontName = "Montserrat";
	private static int mainFontType = Font.PLAIN;
	private static Font mainFont = null;
	
	/**
	 * Returns the main font with given size.
	 * 
	 * @param size
	 * @return
	 */
	public static Font getMainFontWithSize(int size) {
		return new Font(mainFontName, mainFontType, size);
	}

	/**
	 * Returns the main font with size 10.
	 * 
	 * @return
	 */
	public static Font getMainFont() {
		if (mainFont == null)
			return (mainFont = getMainFontWithSize(10));
		return mainFont;
	}

	/**
	 * Returns the display width of a 
	 * given String with Font.
	 * 
	 * @param text
	 * @param font
	 * @return
	 */
	public static int getStringWidth(String text, Font font) {
		FontRenderContext frc = new FontRenderContext(new AffineTransform(), true, true);
		return (int) (font.getStringBounds(text, frc).getWidth());
	}
}
