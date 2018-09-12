package com.github.smallru8.NikoBot.reply;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import net.dv8tion.jda.core.entities.Message;

public class TagAns {
	
	public static void ans(Message msg) throws IOException {
		
		FileReader fr = new FileReader("cfg/randomanswer");
		BufferedReader answer = new BufferedReader(fr);
		String tmp = "";
		Vector<String> v = new Vector<String>();
		while((tmp = answer.readLine())!=null) {
			v.addElement(new String(tmp));
		}
		answer.close();
		int flag = (int)(Math.random()*v.size());
		msg.getChannel().sendMessage(v.elementAt(flag)).queue();
	}
	
}
