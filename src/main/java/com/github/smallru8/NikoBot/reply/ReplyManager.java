package com.github.smallru8.NikoBot.reply;

import java.io.IOException;

import com.github.smallru8.NikoBot.core.BotCore;
import com.github.smallru8.NikoBot.core.Flag;

import net.dv8tion.jda.core.entities.Message;

public class ReplyManager {

	public static void RMrecived(Message m) throws IOException {
		
		if(Flag.answerFlag) {
	
			Image.img(m);
			Reply.reply(m);
			
			if(m.getMentionedUsers() != null) {
				String botname = "";
				try {
					botname = m.getMentionedUsers().get(0).getName();
				}catch (IndexOutOfBoundsException e) {
					
				}
				if(botname.startsWith(BotCore.botName)){
					TagAns.ans(m);
				}
			}
		}
		
	}
	
}
