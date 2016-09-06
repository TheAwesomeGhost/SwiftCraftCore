package com.swiftcraft.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.swiftcraft.core.file.FileHandler;

import net.md_5.bungee.api.ChatColor;

public class Ranks implements CommandExecutor{
	private static String FILENAME = "ranks.yml";
	private Object[] fileContent;

	public Ranks() {
		fileContent = FileHandler.getContentOfFile(FILENAME);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		for (Object rankContentLine : fileContent) {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', (String) rankContentLine));
		}
		return true;
	}
}