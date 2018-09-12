package com.github.smallru8.NikoBot.recorder;

import java.io.File;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.Message.Attachment;

public class Attachments {

	public static void attachmentReceived(Attachment attachment,Message msg) throws MalformedURLException {
		String server = msg.getGuild().getName();
		String filename = attachment.getFileName();

		Date dt = new Date();
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String da = sdf.format(dt);
		
		if(!msg.getAuthor().isBot()) {
		    File dir = new File("records/" + server + "/attachments/" + da + filename);
		    attachment.download(dir);	
		}
	}
	
}
