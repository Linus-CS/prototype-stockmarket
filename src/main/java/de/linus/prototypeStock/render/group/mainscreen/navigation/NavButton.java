package de.linus.prototypeStock.render.group.mainscreen.navigation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

import de.linus.prototypeStock.render.group.components.special.Button;
import de.linus.prototypeStock.render.resources.Images;

/**
 * Customized button that can be used in the navigation.
 * 
 * @author linus
 *
 */
public class NavButton extends Button {

	private String text;
	private final Font font;
	private final Color background = Color.BLACK;
	private Image shadow = Images.SHADOW;
	private boolean drawShadow;

	public NavButton(String text, int y, int height) {
		super(0, y - height/2 - height/10, 0, height);
		this.text = text;

		/* Set font and set width to display width. */
		font = new Font("Montserrat", Font.PLAIN, this.height/2);
		FontRenderContext frc = new FontRenderContext(new AffineTransform(), true, true);
		this.width = (int) (font.getStringBounds(text, frc).getWidth());
		this.width += this.width / 5;
	}

	@Override
	public void render(Graphics g) {
		if (drawShadow)
			g.drawImage(shadow, x - width / 16, y - height / 8, width + width / 8, height + height / 4, null);

		g.setColor(new Color(37, 37, 37));
		g.fillRect(x, y, width, height);
		g.setColor(new Color(24, 24, 24));
		g.drawRect(x, y, width, height);

		g.setFont(font);
		g.setColor(background);
		g.drawString(text, x + this.width / 15, y + this.height - this.height / 3);
	}

	@Override
	public void onClick() {

	}

	@Override
	public void onEnter() {
		drawShadow = true;
	}

	@Override
	public void onExit() {
		drawShadow = false;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getWidth() {
		return this.width;
	}
}
