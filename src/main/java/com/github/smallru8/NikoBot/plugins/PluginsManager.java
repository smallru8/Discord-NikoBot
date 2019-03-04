package com.github.smallru8.NikoBot.plugins;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Vector;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class PluginsManager {

	public static Vector<String> jarUrl = new Vector<String>();
	
	public static Vector<PluginsInterface> pluginsClass = new Vector<PluginsInterface>();
	
	public static void loadPlugins() {
		
		jarUrl.clear();
		File pluginsList = new File("plugins/");
		String[] fileLs = pluginsList.list();
		for(int i = 0;i<fileLs.length;i++) {///取得jar數量(過濾其他檔案)
			if(fileLs[i].indexOf(".jar") != -1) {
				
				jarUrl.addElement("file:plugins/" + fileLs[i]);
				//System.out.println("file:plugins/" + fileLs[i]);
			}
		}
		
		System.out.println("There are " + jarUrl.size() + " plugins.");
		
	}
	
	public static void setUpPlugins() {
		
		pluginsClass.clear();
		for(int i=0;i<jarUrl.size();i++) {
			try {
				
				URL url = new URL(jarUrl.elementAt(i));
				@SuppressWarnings("resource")
				URLClassLoader tmpClassLoader = new URLClassLoader(new URL[] { url }, Thread.currentThread().getContextClassLoader()); 

				InputStream is = tmpClassLoader.findResource("Niko.yml").openStream();

				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				String firstLoad = "";
				firstLoad = br.readLine();
				is.close();
				br.close();
				//System.out.println(firstLoad);
				Class<?> tmpClass = tmpClassLoader.loadClass(firstLoad);///第一個切入點
				//Class<?> tmpClass = tmpClassLoader.loadClass("smallPlugins.FirstAction");///第一個切入點
				PluginsInterface tmpInterface = (PluginsInterface) tmpClass.newInstance();///創建plugins class
				pluginsClass.addElement(tmpInterface);
				tmpInterface.onEnable();
				
			} catch (MalformedURLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("" + jarUrl.size() + " plugins are loaded.");
		
	}
	
	/*public static void cmdrecived(MessageReceivedEvent event) {
		
		for(int i=0;i<jarUrl.size();i++) {
			pluginsClass.elementAt(i).onEventOccur(event);///發送事件給所有class
		}
		
	}*/
	
}
