package com.social.imageaApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.social.imageApp.model.UploadMedia;
@Repository
public interface ImageDao extends JpaRepository<UploadMedia,Long>{

	public List<UploadMedia> findByUsername(String username);

}
