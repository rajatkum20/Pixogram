package com.social.imageaApp.account.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.social.imageApp.model.Comments;
import com.social.imageApp.model.RegisterUser;
import com.social.imageApp.model.UploadMedia;
import com.social.imageaApp.dao.CommentsDao;
import com.social.imageaApp.dao.ImageDao;
import com.social.imageaApp.dao.UserDao;

@Controller
public class CommentController {
	
	@Autowired
	private ImageDao imageDao;
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private CommentsDao commentsDao;
	
	
	Long photoid=(long) 0;
	Set<Long> userid=new HashSet<Long>();
	@RequestMapping("/profile/{visiteduser}")
	public ModelAndView profile(HttpSession session,@PathVariable("visiteduser") String name)
	{
		ModelAndView mav=new ModelAndView();
		   List<UploadMedia> data=imageDao.findByUsername(name);
		 mav.addObject("user",name);
		 mav.addObject("data", data);
		 mav.setViewName("profile");
		 return mav;
	}

	@RequestMapping("getcomments/{id}")
	public ModelAndView showphoto(HttpSession session,@PathVariable("id") long id)
    {
		ModelAndView mav=new ModelAndView();
		Optional<UploadMedia> photo=imageDao.findById(id);
		photoid=id;
   	 	mav.addObject("photo",photo.get());
   	 				  
   	 Set<Long> getcommentid=commentsDao.findbyImageid(id);
		List<Comments> listcomments=commentsDao.findAllById(getcommentid);
		List<UploadMedia> upusername=imageDao.findAllById(userid);
		mav.addObject("upusername",upusername);
		mav.addObject("comments",listcomments);
   	 	mav.addObject("commentsData",new Comments());
		mav.setViewName("profile_photo");
    	return mav;
    }
	

	 @RequestMapping("/comments") 
	 public ModelAndView comments() {
		 ModelAndView mav=new ModelAndView();
		 mav.addObject("commentsData",new Comments());
		 mav.setViewName("profile_photo"); 
		 return mav; }
	 
	@PostMapping("/comments")
	public ModelAndView DoComments(@ModelAttribute("commentsData")Comments comments1,HttpSession session) {
		ModelAndView mav=new ModelAndView();
		String username=(String)session.getAttribute("username");
		RegisterUser loggedInUser=userDao.findByUname(username); 
		Optional<UploadMedia> uploadmedia=imageDao.findById(comments1.getUploadmedia().getId());
	    Long loggedin=loggedInUser.getId();
	  		String usern=uploadmedia.get().getUsername();
	  	
		loggedInUser.getComments().add(comments1);
		Comments comm=new Comments();
		comments1.setUsername(username);
		comments1.setRegisterUser(loggedInUser);
		comments1.setUploadmedia(uploadmedia.get());
		commentsDao.save(comments1);
		
		return new ModelAndView("redirect:/getcomments/"+photoid);
	}
	@GetMapping("/deletecomm/{id}")
	public ModelAndView unblock(@PathVariable("id")Long id,HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
        String username=(String)session.getAttribute("username"); //getting username of looged in user
        RegisterUser loggedInUser=userDao.findByUname(username); //geetings details using username
        Long loggedin=loggedInUser.getId();		//gettingIdofLoggedUSer
        commentsDao.deleteById(id);
        return new ModelAndView("redirect:/getcomments/"+photoid);
	}
}
