package com.github.smallru8.NikoBot.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class CfgChecker {
	
	public static boolean cfgCheck() throws IOException {
		
		String osName = System.getProperties().getProperty("os.name");
		System.out.println(osName);
		if(osName.indexOf("Windows") != -1||osName.indexOf("windows") != -1) {
			BotCore.osType = true;
		}
		
		boolean flag = true;
		if(!BotCore.osType) {
			File restart = new File("restart.sh");
			if(!restart.exists()) {
				FileWriter restart_ = new FileWriter("restart.sh");
				restart_.write("sleep 10" + "\r\n");
				restart_.write("nohup java -Dfile.encoding=UTF8 -jar NikoBot.jar");
				restart_.flush();
				restart_.close();
			}
		}else {
			File restart = new File("restart.bat");
			if(!restart.exists()) {
				FileWriter restart_ = new FileWriter("restart.bat");
				restart_.write("sleep 10" + "\r\n");
				restart_.write("java -Dfile.encoding=UTF8 -jar NikoBot.jar");
				restart_.flush();
				restart_.close();
			}
		}
		File cfg = new File("cfg");
		if(!cfg.exists()) {
	        cfg.mkdirs();
	        FileWriter admin = new FileWriter("cfg/admin");
	        admin.write("000066123420740364\r\n" + "000059081259843584");
	        admin.flush();
	        admin.close();
	        FileWriter name_ = new FileWriter("cfg/name");
			name_.write("YourAppName");
			name_.flush();
			name_.close();
			FileWriter game_ = new FileWriter("cfg/game");
			game_.write("NIKOBOT");
			game_.flush();
			game_.close();
			FileWriter help_ = new FileWriter("cfg/help");
			help_.write("/help");
			help_.flush();
			help_.close();
			FileWriter info = new FileWriter("cfg/info");
			info.write("/info");
			info.flush();
			info.close();
			FileWriter randomanswer = new FileWriter("cfg/randomanswer");
			randomanswer.write("(つд⊂)\r\n" + 
					"ヽ(#`Д´)ﾉ\r\n" + 
					"(((ﾟДﾟ;)))\r\n" + 
					"Σ(ﾟдﾟ)\r\n" + 
					"(๑´ㅂ`๑)\r\n" + 
					"(,,・ω・,,)\r\n" + 
					"(ﾟ∀。)/\r\n" + 
					"(*´∀`)~♥\r\n" + 
					"(／‵Д′)／~ ╧╧\r\n" + 
					"(･ω´･ )\r\n" + 
					"(ㆆᴗㆆ)\r\n" + 
					"_(:3 」∠ )_\r\n" + 
					"ヽ(=^･ω･^=)丿\r\n" + 
					"(́提◞౪◟供‵)\r\n" + 
					"m(◉人*)m");
			randomanswer.flush();
			randomanswer.close();
			FileWriter status_ = new FileWriter("cfg/status");
			status_.write("[DO_NOT_DISTURB,IDLE,INVISIBLE,OFFLINE,ONLINE,UNKNOWN]\r\n" + "status=ONLINE");
			status_.flush();
			status_.close();
			FileWriter token_ = new FileWriter("cfg/token");
			token_.write("NIKOBOTc3NTA0MjcyNDAwMzg0.ABCD-w.EXAMPLE8djM25kSMALLRU8qC28U");
			token_.flush();
			token_.close();
			flag = false;
		}
		File records = new File("records");
		if(!records.exists()) {
			records.mkdirs();
		}
		File plugins = new File("plugins");
		if(!plugins.exists()) {
			plugins.mkdirs();
		}
		File reply = new File("reply");
		if(!reply.exists()) {
			reply.mkdirs();
			File cmd = new File("reply/cmd");
			cmd.mkdirs();
			File ken = new File("reply/ken");
			ken.mkdirs();
			FileWriter kenyml = new FileWriter("reply/cmd/ken.yml");
			kenyml.write("ken\r\n" + "8787 ken");
			kenyml.flush();
			kenyml.close();
			FileWriter kensay = new FileWriter("reply/ken/AnyNameYouLike.txt");
			kensay.write("Hello ken.\n");
			kensay.flush();
			kensay.close();
			FileWriter kensay2 = new FileWriter("reply/ken/AnyNameYouLike2.txt");
			kensay2.write("How are you, ken.\n");
			kensay2.flush();
			kensay2.close();
		}
		File img = new File("img");
		if(!img.exists()) {
			img.mkdirs();
			File cmd = new File("img/cmd");
			cmd.mkdirs();
			File small = new File("img/small");
			small.mkdirs();
			FileWriter smallyml = new FileWriter("img/cmd/small.yml");
			smallyml.write("small\r\n" + "Hello bot");
			smallyml.flush();
			smallyml.close();
			ResourceReader rr = new ResourceReader();
			InputStream is = rr.getClass().getResource("/resources/test.gif").openStream();
			byte[] data = new byte[1024*1024];
			is.read(data);
			File gif = new File("img/small/test.gif");
			FileOutputStream os = new FileOutputStream(gif); 
			os.write(data);
			os.flush();
			os.close();
			is.close();
		}
		
		return flag;
	}
	
}
