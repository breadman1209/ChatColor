package com.breadman.chatcolor;
NAMES.put("blue", "&9");
NAMES.put("green", "&a");
NAMES.put("aqua", "&b");
NAMES.put("red", "&c");
NAMES.put("light_purple", "&d");
NAMES.put("yellow", "&e");
NAMES.put("white", "&f");
}


public ColorCommand(ChatColorPlugin plugin) {
this.plugin = plugin;
}


@Override
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
if (!(sender instanceof Player)) {
sender.sendMessage(ChatColor.RED + "Players only.");
return true;
}


Player p = (Player) sender;


if (args.length == 0) {
p.sendMessage(ChatColor.YELLOW + "Usage: /chatcolor <color|list|reset>");
return true;
}


String sub = args[0].toLowerCase(Locale.ROOT);


if (sub.equals("list")) {
List<String> allowed = new ArrayList<>();
for (String name : NAMES.keySet()) {
if (p.hasPermission("chatcolor.color." + name) ||
p.hasPermission("chatcolor.color.*") ||
p.hasPermission("chatcolor.bypass")) {
allowed.add(name);
}
}
p.sendMessage(ChatColor.YELLOW + "Available: " + String.join(", ", allowed));
return true;
}


if (sub.equals("reset")) {
plugin.getConfig().set("players." + p.getUniqueId() + ".color", null);
plugin.saveConfig();
p.sendMessage(ChatColor.GREEN + "Your chat color has been reset.");
return true;
}


if (NAMES.containsKey(sub)) {
if (!p.hasPermission("chatcolor.color." + sub) &&
!p.hasPermission("chatcolor.color.*") &&
!p.hasPermission("chatcolor.bypass")) {
p.sendMessage(ChatColor.RED + "You can't use this color.");
return true;
}


plugin.getConfig().set("players." + p.getUniqueId() + ".color", NAMES.get(sub));
plugin.saveConfig();
p.sendMessage(ChatColor.GREEN + "Set your chat color to: " + Utils.translate(NAMES.get(sub) + sub));
return true;
}


if (sub.startsWith("&") || sub.startsWith("#") || sub.startsWith("&#")) {
if (!p.hasPermission("chatcolor.use")) {
p.sendMessage(ChatColor.RED + "No permission.");
return true;
}


plugin.getConfig().set("players." + p.getUniqueId() + ".color", sub);
plugin.saveConfig();
p.sendMessage(ChatColor.GREEN + "Set your chat color.");
return true;
}


p.sendMessage(ChatColor.RED + "Unknown color.");
return true;
}
}
