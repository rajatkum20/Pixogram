package com.social.imageApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Followers {
	@Id
	private Long user_id; 
	private Long follower_user_id;

		public Followers() {

	}

	
	public Long getUser_id() {
			return user_id;
		}


		public void setUser_id(Long user_id) {
			this.user_id = user_id;
		}


		public Long getFollower_user_id() {
			return follower_user_id;
		}


		public void setFollower_user_id(Long follower_user_id) {
			this.follower_user_id = follower_user_id;
		}


	public Followers(Long user_id, Long follower_user_id) {
		this.user_id = user_id;
		this.follower_user_id = follower_user_id;
	}

	
	
}