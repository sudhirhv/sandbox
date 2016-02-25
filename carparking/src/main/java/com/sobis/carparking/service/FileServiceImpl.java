package com.sobis.carparking.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sobis.carparking.dao.FileDao;
import com.sobis.carparking.model.File;

@Service
@EnableTransactionManagement // we need to mention this for using @transactions
public class FileServiceImpl implements FileService {

	@Autowired
	private FileDao fileDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)	
	public void addFile(File blob) {
		Date createdDate = new Date();
		blob.setCreatedOn(createdDate);
		blob.setModifiedOn(createdDate);
		fileDao.addFile(blob);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public File getFile(String fileId) {
		return fileDao.getFile(fileId);
	}

	@Override
	public void removeFile(File blob) {
		// TODO Auto-generated method stub

	}

}
