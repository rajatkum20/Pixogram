package com.social.imageApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GeneratorType;

@Entity
public class Comments {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long comment_id;
	
	@ManyToOne()
	@JoinColumn(name="userdata_id")
	private RegisterUser registerUser;
	
	@ManyToOne()
	@JoinColumn(name="image_id")
	private UploadMedia uploadmedia;
	
	private String comment;
	

    public int compareTo(Comments comment2){
        return (int)(comment2.getComment_id()- this.comment_id);
    }


	public Long getComment_id() {
		return comment_id;
	}


	public void setComment_id(Long comment_id) {
		this.comment_id = comment_id;
	}


	public RegisterUser getRegisterUser() {
		return registerUser;
	}


	public void setRegisterUser(RegisterUser registerUser) {
		this.registerUser = registerUser;
	}


	public UploadMedia getUploadmedia() {
		return uploadmedia;
	}


	public void setUploadmedia(UploadMedia uploadmedia) {
		this.uploadmedia = uploadmedia;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
