package com.company.dataanalysis.model.dao;

import java.io.File;

import com.company.dataanalysis.connection.FinancialsFilePath;

public class FinancialsFileToDelete {
	
	public void deleteFile() {
		String directoryPath = new FinancialsFilePath().fileDirectory();
		File directory = new File(directoryPath);
		for(File file : directory.listFiles()) {
			file.delete();
		}
	}
	
}
