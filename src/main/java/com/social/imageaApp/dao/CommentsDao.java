package com.social.imageaApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.imageApp.model.Comments;
import com.social.imageApp.model.UploadMedia;

public interface CommentsDao extends JpaRepository<Comments, Long> {

	public Iterable<Comments> findAllByuploadmedia(UploadMedia upload);
	
}
