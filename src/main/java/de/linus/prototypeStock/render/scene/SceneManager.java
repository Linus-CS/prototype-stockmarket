package de.linus.prototypeStock.render.scene;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import de.linus.prototypeStock.render.group.mainscreen.navigation.Navigation;

/**
 * Containing all scenes, to manage.
 * Providing multiple scenes with
 * the same componentGroup (e.g. Navigation).
 * 
 * @author linus
 *
 */
public class SceneManager {
	public Scene activeScene = null;
	
	/* General componentGroups */
	private final Navigation naviagtion = new Navigation();
	
	/* Scenes (Content Area) */
	public final MarketScene marketScene = new MarketScene();
	
	/* Settings */
	public final SettingsScene settingsScene = new SettingsScene();
	
	public SceneManager() {
		marketScene.addGroup(naviagtion);
		setScene(marketScene);
	}

	
	/**
	 * Updates every group in the scene.
	 */
	public void update() {
		activeScene.update();
	}
	
	/**
	 * Renders every group on the Screen.
	 * 
	 * @param g
	 */
	public void renderGroups(Graphics g) {
		activeScene.renderGroups(g);
	}
	
	/**
	 * Fires when a click on the screen happens.
	 * 
	 * @param e
	 */
	public void mouseClicked(MouseEvent e) {
		activeScene.mouseClicked(e);
	}
	
	/**
	 * Fires when the mouse is moved.
	 * 
	 * @param e
	 */
	public void mouseMoved(MouseEvent e) {
		activeScene.mouseMoved(e);
	}
	
	/**
	 * Fires when a key is typed.
	 * 
	 * @param e
	 */
	public void keyTyped(KeyEvent e) {
		activeScene.keyTyped(e);
	}
	
	/**
	 * Sets a new scene.
	 * 
	 * @param scene
	 */
	public void setScene(Scene scene) {
		this.activeScene = scene;
	}
	
	/**
	 * Returns current scene.
	 * 
	 * @return
	 */
	public Scene getScene() {
		return activeScene;
	}
}
