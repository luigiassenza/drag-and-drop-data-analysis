package com.company.dataanalysis.connection;

import java.io.File;
import java.util.ArrayList;

public class FinancialsFilePath {
		
		private String directory = "C:\\Users\\User\\Desktop\\analysis\\";
		
		public String filePath() {
			String filePath;
			ArrayList<String> fileName = new ArrayList<String>();
			File[] file = new File(directory).listFiles();
			for(File f : file) {
				fileName.add(f.getName());
			}
			filePath = directory + fileName.get(0);
			return filePath;
		}
		
		public String fileDirectory() {
			return directory;
		}
		
}
