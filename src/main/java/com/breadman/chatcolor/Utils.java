package com.breadman.chatcolor;


public class Utils {


public static String translate(String msg) {
if (msg == null) return "";


return org.bukkit.ChatColor.translateAlternateColorCodes('&', msg)
.replaceAll("(?i)&#([0-9A-F]{6})", "§x§$1")
.replaceAll("(?i)#([0-9A-F]{6})", "§x§$1");
}
}
