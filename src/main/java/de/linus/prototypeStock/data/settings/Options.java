package de.linus.prototypeStock.data.settings;

import java.io.File;
import java.lang.reflect.Field;

import de.linus.prototypeStock.PrototypeStockmarket;
import de.linus.prototypeStock.io.FileSystem;

public class Options {

	private PrototypeStockmarket protypeStock = PrototypeStockmarket.getInstance();
	private FileSystem fileSystem = protypeStock.getFileSystem();
	
	public static final File FILE = new File("options.json");

	@Save
	public String key = fileSystem.readOption("key");

	public void save() {
		for (Field f : Options.class.getDeclaredFields()) {
			if (f.isAnnotationPresent(Save.class)) {
				try {
					fileSystem.writeOption(f.getName(), (String) f.get(this));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		fileSystem.writeFiles();
	}
}
