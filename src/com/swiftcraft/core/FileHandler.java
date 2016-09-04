package com.swiftcraft.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class FileHandler {
	static Plugin p;
	private static Logger log = Bukkit.getLogger();

	private static FileHandler fileHandler;

	public static FileHandler getInstance() {
		return fileHandler;
	}

	public FileHandler(Plugin plugin) {
		p = plugin;
		if (fileHandler == null) {
			fileHandler = this;
		}

	}

	public static void doInit() {
		createRanksFileIfNotExists();
		createDataFolderIfNotExists();
	}

	public static Object[] getContentOfFile(String filename) {

		String line;
		ArrayList<String> lines = new ArrayList<String>();
		InputStream fis;
		File file = new File(p.getDataFolder(), filename);
		try {
			fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
			BufferedReader br = new BufferedReader(isr);

			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lines.toArray();
	}

	private static void createRanksFileIfNotExists() {
		File rankFile = new File(p.getDataFolder(), "ranks.yml");
		try {
			if (!rankFile.exists()) {
				rankFile.createNewFile();
				log.info("ranks.yml not found, creating!");
			} else {
				log.info("ranks.yml found, loading!");
			}
		} catch (Exception e) {
			log.info("failed to create ranks.yml");
		}
	}

	private static void createDataFolderIfNotExists() {
		if (!p.getDataFolder().exists()) {
			p.getDataFolder().mkdirs();
		}

	}
}
