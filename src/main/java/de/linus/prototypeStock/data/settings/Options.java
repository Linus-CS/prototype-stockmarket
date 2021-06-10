package de.linus.prototypeStock.data.settings;

import java.lang.reflect.Field;

import de.linus.prototypeStock.PrototypeStockmarket;
import de.linus.prototypeStock.io.FileSystem;

public class Options {

	private PrototypeStockmarket protypeStock = PrototypeStockmarket.getInstance();
	private FileSystem fileSystem = protypeStock.getFileSystem();

	@Save
	public String key = fileSystem.readOption("key");

	public void save() {
		for (Field f : Options.class.getDeclaredFields()) {
			if (f.isAnnotationPresent(Save.class)) {
				try {
					fileSystem.writeOption(f.getName(), (String) f.get(null));

				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		fileSystem.writingJsonFiles();
	}
}
