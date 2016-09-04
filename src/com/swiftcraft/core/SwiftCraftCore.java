package com.swiftcraft.core;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class SwiftCraftCore extends JavaPlugin {
	private static Logger log = Bukkit.getLogger();
	private CommandHandler ch;
	Object[] ranksConfig;

	@Override
	public void onEnable() {
		initHandlers();

		log.info("SwiftCraftCore loaded!");
	}

	@Override
	public void onDisable() {
		log.info("SwiftCraftCore disabled!");
	}

	public void initHandlers() {
		new FileHandler(this);
		FileHandler.doInit();
		ch = new CommandHandler(this);
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return ch.onCommand(sender, command, label, args);
	}

}