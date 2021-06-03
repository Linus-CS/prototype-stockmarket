package de.linus.prototypeStock.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Files {
	
	public static String readKey(){
		FileReader fr = null;
		try {
			fr = new FileReader(new File("polygon.key"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void writeKey(String key){
		FileWriter fw = null;
		try {
			fw = new FileWriter(new File("polygon.key"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter bw = new BufferedWriter(fw);
		try {
			bw.write(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeOption(String entry, String content) {
		//TODO: some code reading the entry out of the file
		if(entry.equalsIgnoreCase("key")) {
			writeKey(content);
			return;
		}
	}
	
	public static <T> void writeOption(String entry, Class<T> content) {
		//TODO: some code reading the entry out of the file
	}
	
	
	public static String readOption(String entry) {
		//TODO: some code reading the entry out of the file
		return "";
	}
	
	public static <T> T readOption(String entry, Class<T> type) {
		//TODO: some code reading the entry out of the file
		return type.cast(type);
	}
}
