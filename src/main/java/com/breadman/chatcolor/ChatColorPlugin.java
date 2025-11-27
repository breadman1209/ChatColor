package com.breadman.chatcolor;


import org.bukkit.plugin.java.JavaPlugin;


public class ChatColorPlugin extends JavaPlugin {


private static ChatColorPlugin instance;


@Override
public void onEnable() {
instance = this;
saveDefaultConfig();


getCommand("chatcolor").setExecutor(new ColorCommand(this));
getServer().getPluginManager().registerEvents(new ChatListener(this), this);


getLogger().info("ChatColor enabled.");
}


@Override
public void onDisable() {
getLogger().info("ChatColor disabled.");
}


public static ChatColorPlugin getInstance() {
return instance;
}
}
