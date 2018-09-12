package com.github.smallru8.NikoBot.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;

public class CfgReader {

	public static String token() throws IOException {
		FileReader fr;
		String token = "";
		try {
			fr = new FileReader("cfg/token");
			BufferedReader br = new BufferedReader(fr);
			token = br.readLine();
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return token;
	}
	
	public static void status(JDABuilder jda) throws IOException {
		
		FileReader fr;
		String[] status = null;
		try {
			fr = new FileReader("cfg/status");
			BufferedReader br = new BufferedReader(fr);
			br.readLine();
			status = br.readLine().split("=");
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		switch(status[1]) {
			case "DO_NOT_DISTURB":
		    	jda.setStatus(OnlineStatus.DO_NOT_DISTURB);
		    	break;
		    case "IDLE":
		    	jda.setStatus(OnlineStatus.IDLE);
		    	break;    	    
		    case "INVISIBLE":
		    	jda.setStatus(OnlineStatus.INVISIBLE);
		    	break;
		    case "OFFLINE":
		    	jda.setStatus(OnlineStatus.OFFLINE);
		    	break;
		    case "ONLINE":
		    	jda.setStatus(OnlineStatus.ONLINE);
		    	break;
		    case "UNKNOWN":
		    	jda.setStatus(OnlineStatus.UNKNOWN);
		    	break;
		}
	}
	
	public static String game() throws IOException {
		
		FileReader fr;
		String game = "";
		try {
			fr = new FileReader("cfg/game");
			BufferedReader br = new BufferedReader(fr);
			game = br.readLine();
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return game;
		
	}
	
	public static String botName() throws IOException {
		
		FileReader fr;
		String name = "";
		try {
			fr = new FileReader("cfg/botName");
			BufferedReader br = new BufferedReader(fr);
			name = br.readLine();
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
		
	}
	
}
