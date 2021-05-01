package de.linus.prototypeStock.render.group.components;

import java.awt.event.MouseEvent;

/**
 * Interface to extend component
 * with mouse events.
 * 
 * @author linus
 *
 */
public interface MouseInput {
	/**
	 * Is called when a click was
	 * executed on the screen.
	 * 
	 * @param mouseEvent
	 */
	public void mouseClicked(MouseEvent e);
	
	/**
	 * Is called when the mouse
	 * is moved.
	 * 
	 * @param mouseEvent
	 */
	public void mouseMoved(MouseEvent e);
}
