package de.linus.prototypeStock.render.group.components.special;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import de.linus.prototypeStock.render.group.components.Component;
import de.linus.prototypeStock.render.utils.FontUtils;

/**
 * Component that is supposed to display text.
 * 
 * @author Linus
 *
 */
public class Label extends Component {

	private String text;
	private Font font;
	private Color color;

	public Label(String text, int x, int y, int size) {
		super(x, y, text.length() * size, size);
		this.font = FontUtils.getMainFontWithSize(size);
		this.x = x - FontUtils.getStringWidth(text, font) / 2;
		this.text = text;
		this.color = Color.BLACK;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.setFont(font);
		g.drawString(text, x, y);
	}

	public void setFont(Font font) {
		this.font = font;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Font getFont() {
		return font;
	}
}
