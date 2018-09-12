package com.github.smallru8.NikoBot.commands;

import java.io.IOException;

import com.github.smallru8.NikoBot.core.Flag;
import com.github.smallru8.NikoBot.embedsender.Pink;
import com.github.smallru8.NikoBot.plugins.PluginsManager;

import net.dv8tion.jda.core.entities.Message;

public class CommandManager {

	public static void cmdrecived(Message cmd) throws IOException, InterruptedException {
		if(cmd.getContentRaw().startsWith("/")) {
			String[] cmdLs = cmd.getContentRaw().split(" ");
			switch(cmdLs[0]) {
			
				case "/help":
			    	if(Flag.CMDFlag)
			    		Help.help(cmd);
			    	break;
			    case "/ping":
			    	if(Flag.CMDFlag)
			    		Pong.pong(cmd);
			    	break;
			    case "/choose":
			    	if(Flag.CMDFlag)
			    		Choose.choose(cmd);
			        break;
			    case "/dice":
			    	if(Flag.CMDFlag)
			    		Dice.dice(cmd);
			    	break;
			    case "/shutdown":
			    	SysCMD.shutdown(cmd);
			    	break;
			    case "/reboot":
			    	SysCMD.reboot(cmd);
			    	break;
			    case "/info":
			    	if(Flag.CMDFlag)
			    		Info.info(cmd);
			    	break;
			    case "/sleep":
			    	SysCMD.sleep(cmd);
			    	break;
			    case "/wake":
			    	SysCMD.wake(cmd);
			    	break;
			    case "/say":
			    	if(Flag.CMDFlag) 
			    		Say.say(cmd);
			    	break;
			    case "/reload":
			    	PluginsManager.loadPlugins();
			    	Pink.output(cmd.getChannel(),":mag: Searching plugins form file...","");
			    	PluginsManager.setUpPlugins();
			    	Pink.output(cmd.getChannel(),":small_red_triangle_down: Plugins are loaded.","");
			    	break;
			    case "/setgame":
			    	SysCMD.setGame(cmd);
			    	break;
			}
		}
	}
	
}
