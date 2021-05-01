package de.linus.prototypeStock.render.group.components;

import java.awt.event.KeyEvent;

/**
 * Interface to extend component
 * with keyboard events.
 *
 * @author linus
 *
 */
public interface KeyInput {
	
	/**
	 * Is called when a key press
	 * is followed by a key release.
	 * 
	 * @param keyEvent
	 */
	public void keyTyped(KeyEvent e);
}
