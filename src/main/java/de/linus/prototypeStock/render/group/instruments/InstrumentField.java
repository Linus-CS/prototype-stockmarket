package de.linus.prototypeStock.render.group.instruments;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import de.linus.prototypeStock.render.group.InputField;

public class InstrumentField extends InputField{

	public InstrumentField(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void onKeyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		//Draws the magnifier.
		g.setColor(Color.BLACK);
		g.drawOval(x + width - width/15, y + height/4, height/3, height/3);
		g.drawLine(x + width - width/15, y + height/2, x + width - width/11, y + 2 * (height/3) + height/25);
		
		super.render(g);	
	}
}
