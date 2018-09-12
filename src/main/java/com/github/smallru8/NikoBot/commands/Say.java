package com.github.smallru8.NikoBot.commands;

import net.dv8tion.jda.core.entities.Message;

public class Say {

	public static void say(Message cmd) {
		
		String[] sayStr = cmd.getContentRaw().split(" ");
		String outputStr = "";
		for(int i=1;i<sayStr.length;i++) {
			outputStr+=sayStr[i];
		}
		cmd.getChannel().sendMessage(outputStr).queue();
	}
	
}
