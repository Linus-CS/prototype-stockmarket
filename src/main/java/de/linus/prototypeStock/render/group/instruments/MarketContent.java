package de.linus.prototypeStock.render.group.instruments;

import de.linus.prototypeStock.render.group.genaral.content.ContentArea;

/**
 * 6/7th of the screen displaying 
 * instruments and search bar.
 * 
 * @author linus
 *
 */
public class MarketContent extends ContentArea {
	public MarketContent() {
		this.addComponent(new InstrumentField(this.x + this.width / 80 , y + this.height/ 50, this.width/5, this.height/20));
		this.addComponentGroup(new Cluster(this.y + this.height / 10, this.width - this.width / 50, this.height - this.height / 10));
	}
}
