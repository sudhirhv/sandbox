package com.sobis.carparking.service;

import com.sobis.carparking.model.File;

public interface FileService {

	public void addFile(File blob);
	
	public File getFile(String fileId);
	
	public void removeFile(File blob);
	
}
