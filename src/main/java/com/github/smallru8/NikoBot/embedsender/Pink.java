package com.github.smallru8.NikoBot.embedsender;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageChannel;

public class Pink {

public static void output(MessageChannel ch,String emo,String str) {
		
		EmbedBuilder embed = new EmbedBuilder();
		embed.setColor(Color.pink);
	    embed.setTitle(emo);
	    embed.setDescription(str);
	    ch.sendMessage(embed.build()).queue();
	    
	}
	
}
