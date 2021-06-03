package de.linus.prototypeStock.render.group.settingsscreen;

import java.awt.Color;

import de.linus.prototypeStock.render.Window;
import de.linus.prototypeStock.render.group.components.ComponentGroup;
import de.linus.prototypeStock.render.group.components.special.Label;

/**
 * Component group for the settings-scene.
 * 
 * @author Linus
 *
 */
public class Settings extends ComponentGroup {

	public Settings() {
		Label header = new Label("Settings", Window.WIDTH / 2, Window.HEIGHT / 8, Window.HEIGHT / 10);
		header.setColor(new Color(52, 52, 52));
		this.addComponent(header);
		this.addComponent(new KeyField(Window.WIDTH / 2, Window.HEIGHT / 3, Window.HEIGHT / 3, Window.HEIGHT / 20));
		this.addComponent(new BackButton((Window.HEIGHT/18)/2, (Window.HEIGHT/20)/2, Window.HEIGHT/18, Window.HEIGHT/20));
		this.addComponent(new SaveButton(Window.WIDTH/2, 4 * Window.HEIGHT/5, Window.HEIGHT/8, Window.HEIGHT/15));
	}
}
