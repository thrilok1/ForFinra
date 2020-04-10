package com.trilok;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Writer implements Runnable {
	File sourceFile;
	File destinationFile;

	public Writer(File source, File destination) {
		this.sourceFile = source;
		this.destinationFile = destination;
	}

	@Override
	public void run() {
		String content;
		content = readFromFile(sourceFile.getAbsolutePath());
		writeToFile(destinationFile, content);
	}

	private static void writeToFile(File file, String content) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(content);
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static String readFromFile(String filename) {
		StringBuffer content = new StringBuffer();
		try {
			String text;
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			while ((text = reader.readLine()) != null) {
				content.append(text);
				content.append("\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(content.toString().toLowerCase());
		return content.toString();
	}
}
