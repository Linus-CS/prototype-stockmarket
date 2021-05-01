package de.linus.prototypeStock.render.group.navigation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

import de.linus.prototypeStock.render.group.Button;

/**
 * Customized button that can be used in the navigation.
 * 
 * @author linus
 *
 */
public class NavButton extends Button {

	private String text;
	private final Font font;
	private boolean underline;

	public NavButton(String text, int y, int height) {
		super(0, y - (int) (1 / 3f * height), 0, height);
		this.text = text;

		//Set font and set width to display width.
		font = new Font("Arial", Font.BOLD, this.height  - (int) (1 / 3f * height));
		FontRenderContext frc = new FontRenderContext(new AffineTransform(), true, true);
		this.width = (int) (font.getStringBounds(text, frc).getWidth());
	}

	@Override
	public void render(Graphics g) {
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString(text, x, y + this.height);
		if (underline)
			g.fillRect(x, y + this.height + this.height / 10, this.width, this.height/10);
	}


	@Override
	public void onClick() {
		
	}

	@Override
	public void onEnter() {
		underline = true;
	}

	@Override
	public void onExit() {
		underline = false;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getWidth() {
		return this.width;
	}
}
