package com.github.smallru8.NikoBot.commands;

import java.io.IOException;

import com.github.smallru8.NikoBot.core.BotCore;
import com.github.smallru8.NikoBot.core.Flag;
import com.github.smallru8.NikoBot.embedsender.Pink;
import com.github.smallru8.NikoBot.permission.PermissionCore;
import com.github.smallru8.NikoBot.plugins.PluginsManager;

import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Message;

public class SysCMD {

	public static void shutdown(Message cmd) throws IOException, InterruptedException {
		
		if(PermissionCore.userId(cmd)) {
			Pink.output(cmd.getChannel(),":octagonal_sign: おやすみなさい! System shutdown!","");
			for(int i=0;i<PluginsManager.pluginsClass.size();i++) {
				PluginsManager.pluginsClass.elementAt(i).onDisable();
			}
			Thread.sleep(1000);
			System.exit(0);
		}
	}
	
	public static void reboot(Message cmd) throws IOException, InterruptedException {
		if(PermissionCore.userId(cmd)) {
			Pink.output(cmd.getChannel(),":arrows_counterclockwise: リロード! System reboot!","");
			for(int i=0;i<PluginsManager.pluginsClass.size();i++) {
				PluginsManager.pluginsClass.elementAt(i).onDisable();
			}
			if(!BotCore.osType)
				Runtime.getRuntime().exec("sh ./restart.sh");//linux
			else
				Runtime.getRuntime().exec("./restart.bat");//windows
			Thread.sleep(1000);
			System.exit(0);
		}
	}
	
	public static void sleep(Message cmd) throws IOException {
		if(PermissionCore.userId(cmd)) {
			BotCore.botAPI.getPresence().setStatus(OnlineStatus.IDLE);
			Flag.answerFlag = false;
			Flag.CMDFlag = false;
			Pink.output(cmd.getChannel(),":red_circle: Sleep mode.","");
		}
	}
	
	public static void wake(Message cmd) throws IOException {
		if(PermissionCore.userId(cmd)) {
			BotCore.botAPI.getPresence().setStatus(OnlineStatus.ONLINE);
			Flag.answerFlag = true;
			Flag.CMDFlag = true;
			Pink.output(cmd.getChannel(),":large_blue_circle: Normal mode.","");
		}
	}
	
	public static void setGame(Message cmd) {
		if(PermissionCore.userId(cmd)) {
			String[] cmdstr = cmd.getContentRaw().split(" ");
			if(cmdstr.length >=2)
				BotCore.botAPI.getPresence().setGame(Game.playing(cmdstr[1]));
			else
				cmd.getChannel().sendMessage("Usage:/setgame <Game>");
		}
	}
	
}
