package de.linus.prototypeStock.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class FileSystem {

	/* All files that are uses in the project */
	@JsonFile
	private final File OPTIONS = new File("options.json");

	private Map<String, JSONObject> jsons = new HashMap<>();

	public FileSystem() {
		checkFiles();
		readingJsonFiles();
	}

	private void checkFiles() {
		for (Field f : FileSystem.class.getDeclaredFields()) {
			if (f.getType().equals(File.class)) {
				File file = null;
				try {
					file = (File) f.get(this);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}

				if (file != null) {
					try {
						file.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private void readingJsonFiles() {
		for (Field f : FileSystem.class.getDeclaredFields()) {
			if (f.isAnnotationPresent(JsonFile.class) && f.getType().equals(File.class)) {
				String json = null;
				try {
					json = readFileAsString((File) f.get(this));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				jsons.put(f.getName(), new JSONObject(json));
			}
		}
	}

	public void writingJsonFiles() {
		for (Field f : FileSystem.class.getDeclaredFields()) {
			if (f.isAnnotationPresent(JsonFile.class) && f.getType().equals(File.class)) {
				try {
					writingFileFromString((File) f.get(this), jsons.get(f.getName()).toString());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private String readFileAsString(File file) {
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		String content = "";
		String line = "";
		try {
			while ((line = br.readLine()) != null) {
				content += line + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	private void writingFileFromString(File file, String content) {
		FileWriter fw = null;

		try {
			fw = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		BufferedWriter bw = new BufferedWriter(fw);
		try {
			bw.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeOption(String entry, Object content) {
		JSONObject optionsJson = jsons.get("OPTIONS");
		optionsJson.append(entry, content);
	}

	public String readOption(String entry) {
		JSONObject optionsJson = jsons.get("OPTIONS");
		return optionsJson.getString(entry);
	}

	public <T> T readOption(String entry, Class<T> type) {
		JSONObject optionsJson = jsons.get("OPTIONS");
		return type.cast(optionsJson.get(entry));
	}
}
