package de.linus.prototypeStock.render.group.settingsscreen;

import java.awt.Graphics;
import java.awt.Image;

import de.linus.prototypeStock.render.Screen;
import de.linus.prototypeStock.render.group.components.special.Button;
import de.linus.prototypeStock.render.resources.Images;
import de.linus.prototypeStock.render.scene.SceneManager;

/**
 * Button in settings returning to the last scene on click.
 * 
 * @author Linus
 *
 */
public class BackButton extends Button{

	private Image back = Images.BACK;
	
	public BackButton(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(back, x, y, width, height, null);
	}
	
	@Override
	public void onClick() {
		SceneManager manager = Screen.getInstance().getSceneManager();
		manager.setScene(manager.getLastScene());
	}

	@Override
	public void onEnter() {
	}

	@Override
	public void onExit() {
	}

}
