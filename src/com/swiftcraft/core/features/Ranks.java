package com.swiftcraft.core.features;

import org.bukkit.command.CommandSender;

import com.swiftcraft.core.FileHandler;

public class Ranks {
	private static String FILENAME = "ranks.yml";
	private Object[] fileContent;

	public Ranks() {
		fileContent = FileHandler.getContentOfFile(FILENAME);
	}

	public void showRanksToSender(CommandSender sender) {
		for (Object rankContentLine : fileContent) {
			sender.sendMessage((String) rankContentLine);
		}
	}
}