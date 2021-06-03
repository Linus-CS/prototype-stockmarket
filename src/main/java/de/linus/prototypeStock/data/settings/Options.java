package de.linus.prototypeStock.data.settings;

import java.lang.reflect.Field;

import de.linus.prototypeStock.io.Files;

public class Options {
	@Save
	public static String key = Files.readKey();
	
	public static void save() {
		for(Field f : Options.class.getDeclaredFields()) {
			if(f.isAnnotationPresent(Save.class)) {
				try {
					Files.writeOption(f.getName(), (String) f.get(null));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
