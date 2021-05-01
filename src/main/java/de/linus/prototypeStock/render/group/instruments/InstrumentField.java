package de.linus.prototypeStock.render.group.instruments;

import de.linus.prototypeStock.render.group.InputField;

public class InstrumentField extends InputField{

	public InstrumentField(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		setDisplayMagnifier(true);
		setBackText("Instrument");
	}
}
