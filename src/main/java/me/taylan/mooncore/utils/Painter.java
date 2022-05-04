package me.taylan.mooncore.utils;

import net.md_5.bungee.api.ChatColor;

public class Painter {
	public static String paint(String s) {

		return ChatColor.translateAlternateColorCodes('&', s);
	}
}
