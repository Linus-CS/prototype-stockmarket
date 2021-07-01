package de.linus.prototypeStock.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import de.linus.prototypeStock.data.settings.Options;

public class FileSystem {

	/* All files that are uses in the project */
	@JsonFile
	private final File OPTIONS = Options.FILE;

	private Map<String, JSONObject> jsons = new HashMap<>();

	public FileSystem() {
		readFiles();
	}

	private void readFiles() {
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

				// TODO: Read other files.

				if (f.isAnnotationPresent(JsonFile.class))
					readingJsonFile(f.getName(), file);
			}
		}
	}

	private void readingJsonFile(String fName, File file) {
		jsons.put(fName, checkJson(file));
	}

	private JSONObject checkJson(File file) {
		String json = null;
		try {
			json = readFileAsString(file);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		if(json.isBlank())
			return new JSONObject();
		
		return new JSONObject(json);
	}

	public void writeFiles() {
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
				
				//TODO: Write other files.

				if (f.isAnnotationPresent(JsonFile.class))
					writeJsonFile(f.getName(), file);
			}
		}
	}

	private void writeJsonFile(String fName, File file) {
		writingFileFromString(file, jsons.get(fName).toString());
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
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			outputStream.write(content.getBytes());
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeOption(String entry, Object content) {
		JSONObject optionsJson = jsons.get("OPTIONS");
		optionsJson.put(entry, content);
	}

	public String readOption(String entry) {
		JSONObject optionsJson = jsons.get("OPTIONS");
		if(!optionsJson.has(entry))
			optionsJson.put(entry, "");
		return optionsJson.getString(entry);
	}

	public <T> T readOption(String entry, Class<T> type) {
		JSONObject optionsJson = jsons.get("OPTIONS");
		if(!optionsJson.has(entry))
			optionsJson.put(entry, new Object());
		return type.cast(optionsJson.get(entry));
	}
}
