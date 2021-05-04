package de.linus.prototypeStock.render.group.instruments;

import java.awt.Color;
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
	private Color color = new Color(195, 195, 195);
	private String name;
	private double value;
	
	public Instrument(String name, double value, int x, int y , int width, int height) {
		this.name = name;
		this.value = value;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		
		/* Background of instrument-box. */
		this.addComponent(new Component(this.x, this.y, this.width, this.height) {	
			@Override
			public void render(Graphics g) {
				g.setColor(color);
				g.fillRect(x, y, width, height);
			}
		});
		
		/* Renders the instrument name */
		this.addComponent(new Component(this.x + this.height/20, this.y + this.height - this.height/20, this.width, this.height) {
			@Override
			public void render(Graphics g) {
				g.setColor(Color.WHITE);
				g.drawString(name, x, y);
			}
		});
		
		/* Renders the instrument value */
		this.addComponent(new Component(this.x + this.height/20, this.y + this.height - this.height/5, this.width, this.height) {
			@Override
			public void render(Graphics g) {
				g.setColor(Color.WHITE);
				g.drawString("Value: " + value, x, y);
			}
		});
		
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
}
