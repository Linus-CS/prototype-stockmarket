package de.linus.prototypeStock.render.group.navigation;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import de.linus.prototypeStock.render.Window;
import de.linus.prototypeStock.render.group.components.Component;
import de.linus.prototypeStock.render.group.components.ComponentGroup;
import de.linus.prototypeStock.render.resources.Images;

/**
 * ComponentGroup with all navigation components displayed at the top of the
 * screen.
 * 
 * @author linus
 *
 */
public class Navigation extends ComponentGroup {

	private List<NavButton> navButtons = new ArrayList<>();
	private int width = Window.WIDTH;
	private int height = Window.HEIGHT / 9;
	private final Color background = new Color(50, 50, 50);

	/**
	 * Adding main navigation elements.
	 */
	private void addNavElements() {
		navButtons.add(new NavButton("Market", this.height/2, this.height / 2));
		navButtons.add(new NavButton("Portfolio", this.height/2, this.height / 2));
	}

	public Navigation() {
		/* Height is 1/7 of the screen (canvas). Width is full width. */

		/* Background (dark blue) */
		this.addComponent(new Component(0, 0, this.width, this.height) {
			@Override
			public void render(Graphics g) {
				g.setColor(background);
				g.fillRect(x, y, width, height);
			}
		});
		
		/* Logo */
		this.addComponent(new Component(this.height/6, this.height/6, 2 * this.height/3, 2 * this.height/3) {
			@Override
			public void render(Graphics g) {
				g.drawImage(Images.LOGO, x, y, width, height, null);
			}
		});

		addNavElements();
		addNavButtons();
	}

	/**
	 * Places the buttons on their accurate positions.
	 */
	private void addNavButtons() {
		int i = this.height + this.height/5;
		for (NavButton navButton : navButtons) {
			navButton.setX(i);
			i += this.width/200 + navButton.getWidth();
			this.addComponent(navButton);
		}
	}
}
