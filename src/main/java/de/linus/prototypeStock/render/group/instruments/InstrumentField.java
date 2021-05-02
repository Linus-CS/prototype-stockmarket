package de.linus.prototypeStock.render.group.instruments;

import de.linus.prototypeStock.render.group.components.special.InputField;
import de.linus.prototypeStock.render.group.components.special.Search;

/**
 * InputField created for the MarketContent area.
 * 
 * @author Linus
 *
 */
public class InstrumentField extends InputField implements Search{

	public InstrumentField(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		setSearch(this);
		setDisplayMagnifier(true);
		setBackText("Instrument");
	}
	
	@Override
	public void onSearch(String text) {
		System.out.println("Search!");
	}
}
