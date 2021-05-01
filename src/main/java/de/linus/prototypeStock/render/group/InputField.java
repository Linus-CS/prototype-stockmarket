package de.linus.prototypeStock.render.group;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import de.linus.prototypeStock.render.group.components.Component;
import de.linus.prototypeStock.render.group.components.KeyInput;
import de.linus.prototypeStock.render.group.components.MouseInput;

/**
 * Component that acts on key input.
 * 
 * @author linus
 *
 */
public abstract class InputField extends Component implements KeyInput, MouseInput {

	protected boolean selected;
	private int courserSpeed = 8;
	private int courserCounter = 0;
	private boolean displayCourser;

	public InputField(int x, int y, int width, int height) {
		super(x, y, width, height);
		setKeyInput(this);
		setMouseInput(this);
	}

	/**
	 * Called when a key is typed while field is selected.
	 */
	public abstract void onKeyTyped(KeyEvent e);

	@Override
	public void mouseMoved(MouseEvent e) {
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getX() < this.x) {
			selected = false;
			return;
		}
		if (e.getX() > this.x + this.width) {
			selected = false;
			return;
		}
		if (e.getY() < this.y) {
			selected = false;
			return;
		}
		if (e.getY() > this.y + this.height) {
			selected = false;
			return;
		}

		selected = true;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (selected)
			this.onKeyTyped(e);
	}
	
	@Override
	public void update() {
		if(selected)
			updateCursorCounter();
		else
			displayCourser = false;
	}
	
	/**
	 * Updates the courserCounter and sets booleans
	 * to true if courser is supposed to be displayed.
	 */
	private void updateCursorCounter() {
		if(courserCounter >= courserSpeed)
			displayCourser = false;
		else
			displayCourser = true;
		
		if(courserCounter == 2 * courserSpeed) 
			courserCounter = 0;
		else
			courserCounter++;
	}

	/**
	 * Set the speed of the courser
	 * smaller number faster blink (default: 8	).
	 * 
	 * @param courserSpeed
	 */
	public void setCourserSpeed(int courserSpeed) {
		this.courserSpeed = courserSpeed;
	}
	
	@Override
	public void render(Graphics g) {
		if(displayCourser) {
			g.setColor(Color.GRAY);
			g.fillRect((int) (x + ((1/100d) * width)), (int) (y + (1/15d) * height), (int) ((1/100d) * width), height - (int) ((2/15d) * height));
		}
	}	
}
