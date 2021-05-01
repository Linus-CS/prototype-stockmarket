package de.linus.prototypeStock.render.group.components;

import java.awt.Graphics;

/**
 * Default component blueprint.
 * 
 * @author linus
 *
 */
public interface IComponent {
	public void update();
	public void render(Graphics g);	
}
