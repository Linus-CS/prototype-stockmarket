package de.linus.prototypeStock.render.group.mainscreen.instruments;

import java.util.ArrayList;
import java.util.List;

import de.linus.prototypeStock.render.group.components.ComponentGroup;

/**
 * Cluster of all instruments that 
 * should be displayed at the moment.
 * 
 * @author linus
 *
 */
public class Cluster extends ComponentGroup {

	private int y;

	private int width;
	
	private List<Instrument> instruments = new ArrayList<>();

	public Cluster(int y, int width) {
		this.y = y;
		this.width = width;
		
		/* Instruments */
		int offSet = width/80;
		int instrumentX = offSet;
		int instrumentY = this.y + offSet;
		
		int instrumentWidth = 350;
		int instrumentHeight = 180;
		
		for(int i = 0; i < 20; i++) {
			instruments.add(new Instrument("Test", 20d,instrumentX, instrumentY, instrumentWidth, instrumentHeight));
			instrumentX += instrumentWidth + offSet;
			if(instrumentX + instrumentWidth >= this.width) {
				instrumentX = offSet;
				instrumentY += instrumentHeight  + offSet;
			}
		}
		
		for(Instrument instrument : this.instruments) {
			this.addComponentGroup(instrument);
		}
	}
}
