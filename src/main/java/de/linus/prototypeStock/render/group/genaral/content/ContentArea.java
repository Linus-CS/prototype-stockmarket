package de.linus.prototypeStock.render.group.genaral.content;

import de.linus.prototypeStock.render.Window;
import de.linus.prototypeStock.render.group.components.ComponentGroup;

/**
 * The 6/7th of the screen for the content.
 * 
 * @author linus
 *
 */
public class ContentArea extends ComponentGroup {
	protected int x = 0;
	protected int y = Window.HEIGHT / 7;

	protected int width = Window.WIDTH;
	protected int height = Window.HEIGHT - Window.HEIGHT / 7;
	
	
	
}
