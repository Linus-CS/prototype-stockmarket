package de.linus.prototypeStock.render.group.settingsscreen;

import java.awt.Color;

import de.linus.prototypeStock.render.group.components.special.InputField;

/**
 * InputField containing the api key for polygon.
 * 
 * @author Linus
 *
 */
public class KeyField extends InputField {

	public KeyField(int x, int y, int width, int height) {
		super(x - width/2, y, width, height);
		setBackText("Key");
		setBackColor(new Color(137, 137, 137));
		setCourserColor(new Color(52, 52, 52));
		setBackTextColor(new Color(88, 88, 88));
		setTextColor(Color.black);
	}

}
