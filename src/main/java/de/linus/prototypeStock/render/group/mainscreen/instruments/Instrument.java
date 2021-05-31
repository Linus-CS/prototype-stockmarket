package de.linus.prototypeStock.render.group.mainscreen.instruments;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import de.linus.prototypeStock.render.group.components.Component;
import de.linus.prototypeStock.render.group.components.ComponentGroup;

/**
 * Display of a single instrument
 * with some basic info.
 * 
 * @author linus
 *
 */
public class Instrument extends ComponentGroup{
	
	private int x, y, width, height;
	private Color background = new Color(88, 88, 88);
	private Color textColor = Color.BLACK;
	private final Font font;
	private String name;
	private double price;
	
	public Instrument(String name, double value, int x, int y , int width, int height) {
		this.name = name;
		this.price = value;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		font = new Font("Arial", Font.BOLD, (int) (1 / 10f * height));
		
		/* Background of instrument-box. */
		this.addComponent(new Component(this.x, this.y, this.width, this.height) {	
			@Override
			public void render(Graphics g) {
				g.setColor(background);
				g.fillRect(x, y, width, height);
			}
		});
		
		/* Renders the instrument name */
		this.addComponent(new Component(this.x + this.height/20, this.y + this.height - this.height/20, this.width, this.height) {
			@Override
			public void render(Graphics g) {
				g.setFont(font);
				g.setColor(textColor);
				g.drawString(name, x, y);
			}
		});
		
		/* Renders the instrument value */
		this.addComponent(new Component(this.x + this.height/20, this.y + this.height - this.height/5, this.width, this.height) {
			@Override
			public void render(Graphics g) {
				g.setColor(textColor);
				g.drawString("Price: " + value + "$", x, y);
			}
		});
		
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setBackground(Color color) {
		this.background = color;
	}
}
