package de.linus.prototypeStock.render.group.components.special;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import de.linus.prototypeStock.render.group.components.Component;
import de.linus.prototypeStock.render.group.components.MouseInput;

/**
 * Component that acts on mouse click or hover.
 * 
 * @author linus
 *
 */
public abstract class Button extends Component implements MouseInput{
	
	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);
		setMouseInput(this);
	}

	/**
	 * Called when the component is clicked.
	 */
	public abstract void onClick();
	
	/**
	 * Called when the mouse
	 * enters the components area.
	 */
	public abstract void onEnter();
	
	/**
	 * Called when the mouse
	 * exits the components area.
	 */
	public abstract void onExit();
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getX() < this.x)
			return;
		if (e.getX() > this.x + this.width)
			return;
		if (e.getY() < this.y)
			return;
		if (e.getY() > this.y + this.height)
			return;

		this.onClick();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (e.getX() < this.x) {
			onExit();
			return;
		}
		if (e.getX() > this.x + this.width){
			onExit();
			return;
		}
		if (e.getY() < this.y){
			onExit();
			return;
		}
		if (e.getY() > this.y + this.height){
			onExit();
			return;
		}

		this.onEnter();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, y, width, height);
	}
}
