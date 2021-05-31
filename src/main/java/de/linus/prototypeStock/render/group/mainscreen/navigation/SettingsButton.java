package de.linus.prototypeStock.render.group.mainscreen.navigation;

import java.awt.Graphics;
import java.awt.Image;

import de.linus.prototypeStock.render.Screen;
import de.linus.prototypeStock.render.group.components.special.Button;
import de.linus.prototypeStock.render.resources.Images;
import de.linus.prototypeStock.render.scene.SceneManager;

public class SettingsButton extends Button {

	private Image settingsImage = Images.SETTINGS;
	
	public SettingsButton(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(settingsImage, x, y, width, height, null);
	}
	
	@Override
	public void onClick() {
		SceneManager manager = Screen.getInstance().getSceneManager();
		manager.setScene(manager.settingsScene);
	}

	@Override
	public void onEnter() {
	}

	@Override
	public void onExit() {
	}
	
}
