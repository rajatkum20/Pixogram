package com.social.imageaApp.dao;





import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.social.imageApp.model.RegisterUser;


import antlr.collections.List;
@Repository
public interface UserDao extends JpaRepository<RegisterUser, Long>{

	@Query(value = "select r.following_id from relation r where r.user_id=:id",nativeQuery = true)
	public Set findUsers(Long id);
	public RegisterUser findByUnameAndPsw(String uname,String psw);
	public RegisterUser findByUname(String username);
	public List findAllById(Long id);
	
	
}