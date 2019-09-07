package com.social.imageaApp.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.social.imageApp.model.Comments;
import com.social.imageApp.model.UploadMedia;

public interface CommentsDao extends JpaRepository<Comments, Long> {

	public Iterable<Comments> findAllByuploadmedia(UploadMedia upload);
	@Query(value = "select r.comment_id from comments r where r.image_id=:id",nativeQuery = true)
	public Set<Long> findbyImageid(Long id);
	
	@Query(value="delete r.comment_id from comments r where r.comment_id=:id",nativeQuery = true)
	public void deleteComm(Long id);
}
