package com.github.smallru8.NikoBot.reply;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import net.dv8tion.jda.core.entities.Message;

public class Reply {

	public static void reply(Message m) throws IOException{
		
		File folder = new File("reply/cmd");
		String[] files = folder.list();///儲存檔名
		String contentRaw = m.getContentRaw();
		String targetFolder = null;
		
		for(int i=0;i<files.length;i++) {
			boolean cnd = true;
			FileReader fr = new FileReader("reply/cmd/" + files[i] );//讀入關鍵字
			BufferedReader br = new BufferedReader(fr);
			String targetFolderTmp = br.readLine();
			String[] cond = br.readLine().split(" ");
			fr.close();
			br.close();
			for(int j = 0;j < cond.length;j++) {
				if(contentRaw.indexOf(cond[j]) != -1) {//全滿足才執行
					continue;
				}else {
					cnd = false;
					break;
				}
			}
			if(cnd) {
				targetFolder = targetFolderTmp;
			}
		}
		if(targetFolder!=null) {
			File folderTxt = new File("reply/" + targetFolder);
			String[] txt = folderTxt.list();
			int flag = (int)(Math.random()*txt.length);///回答範本數量
			
			FileReader fr = new FileReader("reply/" + targetFolder + "/" + txt[flag]);
			BufferedReader br = new BufferedReader(fr);
			String txtOutput = br.readLine();
			br.close();
			m.getChannel().sendMessage(txtOutput).queue();
		}
		
	}
	
}
