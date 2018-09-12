package com.github.smallru8.NikoBot.plugins;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public interface PluginsInterface {

	public void onEventOccur(MessageReceivedEvent event);///send event to plugins
	
	public void onEnable();
	
	public void onDisable();
	
	public String pluginsName();
	
}
