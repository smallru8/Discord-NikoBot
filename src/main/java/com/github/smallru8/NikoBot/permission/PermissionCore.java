package com.github.smallru8.NikoBot.permission;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.github.smallru8.NikoBot.embedsender.Pink;

import net.dv8tion.jda.core.entities.Message;

public class PermissionCore {

	public static boolean userId(Message msg) {
		
		String usrId = msg.getAuthor().getId();
		try {
			FileReader frUidLs = new FileReader("cfg/admin");
			BufferedReader br = new BufferedReader(frUidLs);
			String tmp = null;
			while((tmp = br.readLine())!=null) {
				if(usrId.equals(tmp)) {
					br.close();
					return true;
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Pink.output(msg.getChannel(),":no_entry_sign:", "你不是我的主人，尼奏開!!! You don't have permission to do this!");
		return false;
	}
	
}
