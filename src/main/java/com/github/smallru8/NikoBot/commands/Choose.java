package com.github.smallru8.NikoBot.commands;

import java.util.Random;

import com.github.smallru8.NikoBot.embedsender.Pink;

import net.dv8tion.jda.core.entities.Message;

public class Choose {

	public static void choose(Message m) {
		
		String[] msg = m.getContentRaw().split(" ");
	    int len = msg.length-1;
	    Random ran = new Random();
	    int rand = ran.nextInt(len)+1;//1~len
	    Pink.output(m.getChannel(),":thinking:",msg[rand]);

	}
	
}
