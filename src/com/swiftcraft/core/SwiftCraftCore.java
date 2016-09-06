package com.swiftcraft.core;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.swiftcraft.core.commands.Ranks;
import com.swiftcraft.core.file.FileHandler;

public class SwiftCraftCore extends JavaPlugin {
	private static Logger log = Bukkit.getLogger();

	@Override
	public void onEnable() {
		instance = this;
		initHandlers();
		addCommands();
		log.info("SwiftCraftCore loaded!");
	}

	@Override
	public void onDisable() {
		log.info("SwiftCraftCore disabled!");
	}

	public void initHandlers() {
		FileHandler.doInit();
	}
	
	public void addCommands(){
		getCommand("ranks").setExecutor(new Ranks());
	}
	
	private static SwiftCraftCore instance;
	public static SwiftCraftCore getInstance(){
		return instance;
	}
}