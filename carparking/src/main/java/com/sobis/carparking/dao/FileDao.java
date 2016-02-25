package com.sobis.carparking.dao;

import com.sobis.carparking.model.File;

public interface FileDao {
	
	public void addFile(File blob);
	
	public File getFile(String fileId);
	
	public void removeFile(File blob);
	
	
}
