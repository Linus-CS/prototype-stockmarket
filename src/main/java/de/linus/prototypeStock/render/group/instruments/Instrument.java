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
	
	public Instrument(int x, int y , int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		
		//Background of instrument-box.
		this.addComponent(new Component(this.x, this.y, this.width, this.height) {
			
			@Override
			public void render(Graphics g) {
				g.setColor(color);
				g.fillRect(x, y, width, height);
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
