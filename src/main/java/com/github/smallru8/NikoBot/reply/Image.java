package com.github.smallru8.NikoBot.reply;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import net.dv8tion.jda.core.entities.Message;

public class Image {

	public static void img(Message m) throws IOException {
		
		File folder = new File("img/cmd");
		String[] files = folder.list();///儲存檔名
		String contentRaw = m.getContentRaw();
		String targetFolder = null;
		
		for(int i=0;i<files.length;i++) {
			boolean cnd = true;
			FileReader fr = new FileReader("img/cmd/" + files[i]);//讀入關鍵字
			//System.out.print(files[i]);
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
			File folderPic = new File("img/" + targetFolder);
			String[] picture = folderPic.list();
			int flag = (int)(Math.random()*picture.length);///有幾張圖
			File pic = new File("img/" + targetFolder + "/" + picture[flag]);
			m.getChannel().sendFile(pic).queue();
		}
		
	}
	
}
