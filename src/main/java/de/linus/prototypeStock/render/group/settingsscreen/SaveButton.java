package de.linus.prototypeStock.render.group.settingsscreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import de.linus.prototypeStock.PrototypeStockmarket;
import de.linus.prototypeStock.render.group.components.special.Button;
import de.linus.prototypeStock.render.utils.FontUtils;

/**
 * Button that saves all settings on click.
 * 
 * @author Linus
 *
 */
public class SaveButton extends Button {

	private int stringWidth;
	private Font font;
	private final String text = "Save";
	private Color color;
	private Color textColor;

	/**
	 * Initializes general settings and values.
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public SaveButton(int x, int y, int width, int height) {
		super(x - width / 2, y, width, height);
		this.font = FontUtils.getMainFontWithSize(width / 3);
		this.stringWidth = FontUtils.getStringWidth(text, font);
		this.color = new Color(52, 52, 52);
		this.textColor = new Color(88, 88, 88);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		super.render(g);
		g.setColor(textColor);
		g.setFont(font);
		g.drawString(text, this.x + this.width / 2 - stringWidth / 2, this.y + this.height - this.height / 5);
	}

	@Override
	public void onClick() {
		PrototypeStockmarket.getInstance().getOptions().key = ((Settings) parent).keyFromField();
		PrototypeStockmarket.getInstance().getOptions().save();
		System.out.println("success");
	}

	@Override
	public void onEnter() {
	}

	@Override
	public void onExit() {
	}

}
