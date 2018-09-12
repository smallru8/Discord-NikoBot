package com.github.smallru8.NikoBot.core;

import java.net.URL;

public class ResourceReader {

	public ResourceReader() {
		
	}
	
	public URL getResources(String path) {
		URL url = this.getClass().getResource(path);
		return url;
	}
	
}
