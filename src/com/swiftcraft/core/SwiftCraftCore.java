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
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class SwiftCraftCore extends JavaPlugin {
	private static Logger log = Bukkit.getLogger();
	Object[] ranksConfig;

	@Override
	public void onEnable() {
		createConfig();
		log.info("SwiftCraftCore loaded!");
	}

	@Override
	public void onDisable() {
		log.info("SwiftCraftCore disabled!");
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (label.toString().equalsIgnoreCase("testing")) {
			sender.sendMessage("fuck off");
			return true;
		}
		if (label.toString().equalsIgnoreCase("ranks")) {
			for (Object rankContentLine : ranksConfig) {
				sender.sendMessage((String) rankContentLine);
			}
			return true;
		}

		return false;
	}

	private void createConfig() {
		try {

			// ======= STANDARD FOLDER =======
			if (!getDataFolder().exists()) {
				getDataFolder().mkdirs();
			}

			// ======== RANKS FILE =======
			File rankFile = new File(getDataFolder(), "ranks.yml");
			if (!rankFile.exists()) {
				rankFile.createNewFile();
				getLogger().info("ranks.yml not found, creating!");
			} else {
				getLogger().info("ranks.yml found, loading!");
			}

			String line;
			ArrayList<String> lines = new ArrayList<String>();
			InputStream fis = new FileInputStream(rankFile);
			InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
			BufferedReader br = new BufferedReader(isr);

			while ((line = br.readLine()) != null) {
				lines.add(line);
			}

			setRankFileContent(lines.toArray());

			// ====== END =======
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	private void setRankFileContent(Object[] content) {
		ranksConfig = (Object[]) content;
	}

}