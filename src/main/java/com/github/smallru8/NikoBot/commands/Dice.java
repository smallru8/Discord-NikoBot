package com.github.smallru8.NikoBot.commands;

import java.util.Random;

import com.github.smallru8.NikoBot.embedsender.Pink;

import net.dv8tion.jda.core.entities.Message;

public class Dice {

	public static void dice(Message m) {

		Random ran = new Random();
		String emo = "";
		int roll = ran.nextInt(6)+1;
		switch(roll) {
		    case 1:
		    	emo = ":one:";
		    	break;
		    case 2:
		    	emo = ":two:";
		    	break;
		    case 3:
		    	emo = ":three:";
		    	break;
		    case 4:
		    	emo = ":four:";
		    	break;
		    case 5:
		    	emo = ":five:";
		    	break;
		    case 6:
		    	emo = ":six:";
		    	break;
		}
		Pink.output(m.getChannel(),":game_die:",emo);

	}
	
}
