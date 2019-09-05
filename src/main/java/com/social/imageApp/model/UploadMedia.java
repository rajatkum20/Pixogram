package com.social.imageApp.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Lob;

import javax.persistence.Table;

@Entity

public class UploadMedia {
	@Id
	@Column(name = "uid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
public UploadMedia() {
		
	}
	public UploadMedia(Long id, String title, String description, String tags, String username, boolean isblocked,
			String encimg, byte[] pic) {
		
		this.id = id;
		this.title = title;
		Description = description;
		this.tags = tags;
		this.username = username;
		this.isblocked = isblocked;
		this.encimg = encimg;
		this.pic = pic;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column
	private String title;


	@Column
	private String Description;
	@Column
	private String tags;

	@Column
	private String username;

	@Column
	private boolean isblocked=false;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

		public boolean isIsblocked() {
		return isblocked;
	}

	public void setIsblocked(boolean isblocked) {
		this.isblocked = isblocked;
	}

	
	

	public String getEncimg() {

		return encimg;
	}

	public void setEncimg(String encimg) {
		this.encimg = encimg;
	}

	@Column(length = 10000000)
	private String encimg;

	
	
	@Lob
	@Column
	private byte[] pic;

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

}
