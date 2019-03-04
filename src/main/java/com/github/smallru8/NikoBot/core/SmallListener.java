package com.github.smallru8.NikoBot.core;

import com.github.smallru8.NikoBot.commands.CommandManager;
import com.github.smallru8.NikoBot.plugins.PluginsManager;
import com.github.smallru8.NikoBot.recorder.Attachments;
import com.github.smallru8.NikoBot.recorder.Dialogue;
import com.github.smallru8.NikoBot.reply.ReplyManager;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class SmallListener extends ListenerAdapter{

	public void onMessageReceived(MessageReceivedEvent event){
		try {
			
			Message msg = event.getMessage();
			String usrname = msg.getAuthor().getId();
			
			System.out.println("[" + usrname + "]" + msg.getContentRaw());//Display on console
			
			Dialogue.record(msg);
			
			if(!msg.getAttachments().isEmpty()){
				Attachments.attachmentReceived(msg.getAttachments().get(0), msg);
			}
			
			if(!msg.getAuthor().isBot()) {//Don't receive cmd from other bots
			    CommandManager.cmdrecived(msg);
			    ReplyManager.RMrecived(msg);
			    
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
}
