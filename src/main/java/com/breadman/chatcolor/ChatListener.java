package com.breadman.chatcolor;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class ChatListener implements Listener {


private final ChatColorPlugin plugin;


public ChatListener(ChatColorPlugin plugin) {
this.plugin = plugin;
}


@EventHandler
public void onChat(AsyncPlayerChatEvent e) {
Player p = e.getPlayer();
FileConfiguration cfg = plugin.getConfig();


String prefix = cfg.getString("players." + p.getUniqueId() + ".color");


if (prefix != null) {
ChatListener.java
String newName = Utils.translate(prefix + p.getName());
e.setFormat(e.getFormat().replace("%s", newName));
}


e.setMessage(Utils.translate(e.getMessage()));
}
}
