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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
	 @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(name = "relation",
	                joinColumns = @JoinColumn(name = "user_id"),
	                inverseJoinColumns = @JoinColumn(name = "following_id"))
	    private Set<RegisterUser> following;


	/*
	 * public List<RegisterUser> getFollowing() { return following; }
	 * 
	 * public void setFollowing(List<RegisterUser> following) { this.following =
	 * following; }
	 */
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
