package com.github.smallru8.NikoBot.recorder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.dv8tion.jda.core.entities.Message;

public class Dialogue {

	public static void record(Message msg){
		String server = msg.getGuild().getName();
		String channel = msg.getChannel().getName();
		String message = msg.getContentRaw();
		String usrid = msg.getAuthor().getName();
		Date dt = new Date();
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
		String da = sdf.format(dt);
		try
	    {
		    FileWriter record=new FileWriter("records/" + server + "/" + channel + ".log",true);
	        record.write("[" + da + "]" + usrid + " : " + message + "\n");
	        record.close();

	    }catch(FileNotFoundException e){///找不到檔案就新建
	    	File dir_file = new File("records/" + server + "/attachments");
	        dir_file.mkdirs();
	        e.printStackTrace();
	    }catch(IOException e){
	        e.printStackTrace();
	    }
	}
	
}
