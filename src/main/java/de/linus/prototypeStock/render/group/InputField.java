package de.linus.prototypeStock.render.group;

import java.awt.Color;
import java.awt.Font;
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

	/**
	 * True or false rather if field is currently selected or not.
	 */
	protected boolean selected;
	
	private String text = new String();
	private Color textColor = Color.BLACK;
	private String backText = new String();
	private Color backTextColor = Color.GRAY;
	
	/* Courser render values */
	private boolean displayCourser;
	private int courserSpeed = 8;
	private int courserCounter = 0;
	
	/* Settings */
	private boolean displayMagnifier = false;
	private Font font;
	private Color backColor = Color.WHITE;
	private Color courserColor = Color.GRAY;
	private Color magnifierColor = Color.BLACK;

	public InputField(int x, int y, int width, int height) {
		super(x, y, width, height);
		setKeyInput(this);
		setMouseInput(this);
		font =  new Font("Arial", Font.PLAIN, height - height/9);
	}

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

	/**
	 * Override onKeyTyped instead of this method.
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		if (selected) 
			this.onKeyTyped(e);
		
	}
	
	/**
	 * Called when a key is typed while field is selected.
	 */
	public void onKeyTyped(KeyEvent e) {
		StringBuilder builder = new StringBuilder();
		builder.append(text);
		if(font.canDisplay(e.getKeyChar()))
			builder.append(e.getKeyChar());
		this.text = builder.toString();
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
	
	/**
	 * Sets rather a magnifier is supposed
	 * to be displayed on the field or not.
	 * 
	 * @param displayMagnifier
	 */
	public void setDisplayMagnifier(boolean displayMagnifier) {
		this.displayMagnifier = displayMagnifier;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getBackText() {
		return backText;
	}

	public void setBackText(String backText) {
		this.backText = backText;
	}

	public void setTextColor(Color textColor) {
		this.textColor = textColor;
	}

	public void setBackTextColor(Color backTextColor) {
		this.backTextColor = backTextColor;
	}

	public void setBackColor(Color backColor) {
		this.backColor = backColor;
	}

	public void setCourserColor(Color courserColor) {
		this.courserColor = courserColor;
	}

	public void setMagnifierColor(Color magnifierColor) {
		this.magnifierColor = magnifierColor;
	}

	@Override
	public void render(Graphics g) {
		/* Draws the background */
		g.setColor(backColor);
		g.fillRect(x, y, width, height);
		
		g.setFont(font);
		
		/* Draws the text*/
		g.setColor(textColor);
		g.drawString(text, (int) (x + ((1/100d) * width)), (int) (y + (14/15d) * height));
		
		/* Draws the background text if not selected */
		if(!selected) {
			g.setColor(backTextColor);
			g.drawString(backText, (int) (x + ((1/100d) * width)), (int) (y + (14/15d) * height));
		}
		
		/* Draws the courser */
		if(displayCourser) {
			int courserX = (int) (x + ((1/100d) * width)) + g.getFontMetrics().stringWidth(text);
			g.setColor(courserColor);
			g.fillRect(courserX, (int) (y + (1/15d) * height), (int) ((1/100d) * width), height - (int) ((2/15d) * height));
		}
		
		/* Draws the magnifier */
		if(displayMagnifier) {
			g.setColor(magnifierColor);
			g.drawOval(x + width - width/15, y + height/4, height/3, height/3);
			g.drawLine(x + width - width/15, y + height/2, x + width - width/11, y + 2 * (height/3) + height/25);
		}
	}	
}
