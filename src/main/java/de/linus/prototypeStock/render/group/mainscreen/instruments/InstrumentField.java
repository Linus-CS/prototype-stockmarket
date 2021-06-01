package de.linus.prototypeStock.render.group.mainscreen.instruments;

import java.awt.Color;

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
		setCourserColor(new Color(52, 52, 52));
		setBackTextColor(new Color(88, 88, 88));
		setTextColor(Color.black);
		setBackColor(new Color(137, 137, 137));
	}
	
	@Override
	public void onSearch(String text) {

	}
}
