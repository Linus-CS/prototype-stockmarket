package de.linus.prototypeStock.render.scene;

import de.linus.prototypeStock.render.group.mainscreen.instruments.MarketContent;

/**
 * Scene providing a overview of
 * all shares that you can buy.
 * 
 * @author linus
 *
 */
public class MarketScene extends Scene{
	public MarketScene() {
		this.addGroup(new MarketContent());
	}	
}
