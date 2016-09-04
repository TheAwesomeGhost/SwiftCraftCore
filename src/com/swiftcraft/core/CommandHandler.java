package com.swiftcraft.core;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import features.Ranks;

public class CommandHandler {

	Plugin p;
	Ranks r;

	public CommandHandler(Plugin plugin) {
		p = plugin;
		r = new Ranks();
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.toString().equalsIgnoreCase("ranks")) {
			r.showRanksToSender(sender);
			return true;
		}
		return false;
	}
}