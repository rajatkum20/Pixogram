package com.social.imageApp.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RegisterUser1")
public  class RegisterUser  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "uname")
	private String uname;
	
	private String psw;
	
	private int isBlocked=0;
	
	
	@OneToMany(mappedBy = "registerUser",cascade = CascadeType.PERSIST)
	private Set<Comments> comments;
	
	@OneToMany(mappedBy= "registerUser" ,cascade=CascadeType.PERSIST)
	private Set<UploadMedia> uploadmedia;
	
	 @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(name = "relation",
	                joinColumns = @JoinColumn(name = "user_id"),
	                inverseJoinColumns = @JoinColumn(name = "following_id"))
	    private Set<RegisterUser> following;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="block",
	joinColumns = @JoinColumn(name="user_id"),
	inverseJoinColumns = @JoinColumn(name="blocked_id"))
	private Set<RegisterUser> blocked;
	
	
	 

	
	public Set<Comments> getComments() {
		return comments;
	}

	public void setComments(Set<Comments> comments) {
		this.comments = comments;
	}

	public Set<UploadMedia> getUploadmedia() {
		return uploadmedia;
	}

	public void setUploadmedia(Set<UploadMedia> uploadmedia) {
		this.uploadmedia = uploadmedia;
	}

	public Set<RegisterUser> getBlocked() {
		return blocked;
	}

	public void setBlocked(Set<RegisterUser> blocked) {
		this.blocked = blocked;
	}

	public int getIsBlocked() {
		return isBlocked;
	}

	public Set<RegisterUser> getFollowing() {
		return following;
	}

	public void setFollowing(Set<RegisterUser> following) {
		this.following = following;
	}

	public void setIsBlocked(int isBlocked) {
		this.isBlocked = isBlocked;
	}

	private String email;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
