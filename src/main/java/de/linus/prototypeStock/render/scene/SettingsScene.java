package de.linus.prototypeStock.render.scene;

import de.linus.prototypeStock.render.group.settingsscreen.Settings;

/**
 * Scene providing all settings.
 * 
 * @author Linus
 *
 */
public class SettingsScene extends Scene{
	public SettingsScene() {
		this.addGroup(new Settings());
	}
}
