package de.linus.prototypeStock;

import de.linus.prototypeStock.data.api.PolygonApi;
import de.linus.prototypeStock.render.Window;
import de.linus.prototypeStock.render.scene.SceneManager;

/**
 * Main singelton class providing access to all instances.
 * 
 * @author Linus
 *
 */
public class PrototypeStockmarket {
	
	private static PrototypeStockmarket instance = null;
	
	private final SceneManager sceneManager; 
	private final Window window;
	private final PolygonApi polygonApi;
	
	private PrototypeStockmarket() {
		instance = this;
		sceneManager =  new SceneManager();
		window = new Window();
		polygonApi = new PolygonApi();
	}
	
	/**
	 * Returns sceneManager containing all scenes.
	 * 
	 * @return
	 */
	public SceneManager getSceneManager() {
		return sceneManager;
	}
	
	/**
	 * Returns window with rendering functionality.
	 * 
	 * @return
	 */
	public Window getWindow() {
		return window;
	}
	
	/**
	 * Returns polygonApi instance accessing market data.
	 * 
	 * @return
	 */
	public PolygonApi getPolygonApi() {
		return polygonApi;
	}
	
	/**
	 * Returns instance of this class.
	 * 
	 * @return
	 */
	public static PrototypeStockmarket getInstance() {
		if(instance == null)
			new PrototypeStockmarket();
		return instance;
	}
}
