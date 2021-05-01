package de.linus.prototypeStock.render.scene;

import de.linus.prototypeStock.render.group.genaral.navigation.Navigation;

/**
 * Containing all scenes, to manage.
 * Providing multiple scenes with
 * the same componentGroup (e.g. Navigation).
 * 
 * @author linus
 *
 */
public class SceneManager {
	
	/* General componentGroups */
	private final Navigation naviagtion = new Navigation();
	
	/* Scenes */
	public final MarketScene marketScene = new MarketScene();
	
	public SceneManager() {
		marketScene.addGroup(naviagtion);
	}

	/**
	 * Scene that is supposed
	 * to be displayed after start up.
	 * 
	 * @return
	 */
	public Scene getStart() {
		return marketScene;
	}
}
