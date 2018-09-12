package com.github.smallru8.NikoBot.core;

import java.io.IOException;

import javax.security.auth.login.LoginException;

import com.github.smallru8.NikoBot.plugins.PluginsManager;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
//1809v1
public class BotCore extends ListenerAdapter{

	public static String botName = "";
	public static JDA botAPI;
	public static boolean osType = false;//windows = true;Linux = false;
	
	public static void main(String[] args) throws IOException {
		
		if(CfgChecker.cfgCheck()) {
			JDABuilder jda = new JDABuilder(AccountType.BOT);
			jda.setToken(CfgReader.token());
			jda.setAutoReconnect(true);
			jda.addEventListener(new SmallListener());
			CfgReader.status(jda);
			botName = CfgReader.botName();
			
			try {
				botAPI = jda.buildAsync();
				botAPI.getPresence().setGame(Game.playing(CfgReader.game()));
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			PluginsManager.loadPlugins();
			PluginsManager.setUpPlugins();
		}else {
			System.out.println("Please check Cfg.");
			System.exit(0);
		}
	}
	
}
