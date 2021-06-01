package de.linus.prototypeStock.render.utils;

import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

public class FontUtils {

	private static String mainFontName = "Montserrat";
	private static int mainFontType = Font.PLAIN;
	private static Font mainFont = null;
	
	public static Font getMainFontWithSize(int size) {
		return new Font(mainFontName, mainFontType, size);
	}

	public static Font getMainFont() {
		if (mainFont == null)
			return (mainFont = getMainFontWithSize(10));
		return mainFont;
	}

	public static int getStringWidth(String text, Font font) {
		FontRenderContext frc = new FontRenderContext(new AffineTransform(), true, true);
		return (int) (font.getStringBounds(text, frc).getWidth());
	}
}
