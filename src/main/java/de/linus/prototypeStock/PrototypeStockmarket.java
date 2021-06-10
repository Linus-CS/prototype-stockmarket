package de.linus.prototypeStock;

import de.linus.prototypeStock.data.api.PolygonApi;
import de.linus.prototypeStock.data.settings.Options;
import de.linus.prototypeStock.io.FileSystem;
import de.linus.prototypeStock.render.Window;

/**
 * Main singelton class providing access to all instances.
 * 
 * @author Linus
 *
 */
public class PrototypeStockmarket {
	
	private static PrototypeStockmarket instance = null;
	
	private final FileSystem fileSystem;
	private final Options options;
	private final Window window;
	private final PolygonApi polygonApi;
	
	private PrototypeStockmarket() {
		instance = this;
		
		fileSystem = new FileSystem();
		options = new Options();
		window = new Window();
		polygonApi = new PolygonApi();
	}
	
	/**
	 * Returns filesystem to retrieve permanent data.
	 * 
	 * @return
	 */
	public FileSystem getFileSystem() {
		return fileSystem;
	}
	
	/**
	 * Returns options.
	 * 
	 * @return
	 */
	public Options getOptions() {
		return options;
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
