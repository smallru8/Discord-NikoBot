package com.github.smallru8.NikoBot.commands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.github.smallru8.NikoBot.embedsender.Pink;

import net.dv8tion.jda.core.entities.Message;

public class Info {

	public static void info(Message cmd) {
		
		String show = "";
		try {
			FileReader fr = new FileReader("cfg/info");
			BufferedReader br = new BufferedReader(fr);
			String tmp = "";
			while((tmp = br.readLine())!=null) {
				
				tmp+='\n';
				show+=tmp;
				
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Pink.output(cmd.getChannel(),":information_source: Info:",show);
		
	}

}
