package com.sobis.carparking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="file")
public class File extends Base {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7045204107026998952L;
	
	@OneToOne()
	@JoinColumn(name="fk_parent")	
	private Base parent;
	
	@Column(name="fileName")
	private String fileName;
	
	@Column( name = "fileData" )
	@Lob
	//private byte[] fileimage;
	private MultipartFile file;
	
	public File(){
		
	}
	
	public Base getParent() {
		return parent;
	}

	public void setParent(Base parent) {
		this.parent = parent;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	

	
}
