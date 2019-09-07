package com.social.imageaApp.mymedia.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.social.imageApp.model.Comments;
import com.social.imageApp.model.RegisterUser;
import com.social.imageApp.model.UploadMedia;
import com.social.imageaApp.dao.CommentsDao;
import com.social.imageaApp.dao.ImageDao;
import com.social.imageaApp.dao.UserDao;


@Controller
public class MediaDetailController {
	
	@Autowired
	private ImageDao imageDao;
	
	@Autowired
	private CommentsDao commentsDao;
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/commentsmedia") 
	 public ModelAndView comments() {
		 ModelAndView mav=new ModelAndView();
		 mav.addObject("commentsDatamedia",new Comments());
		 mav.setViewName("Media");
		 return mav; }
	 
	@PostMapping("/commentsmedia")
	public ModelAndView DoComments(@ModelAttribute("commentsDatamedia")Comments comments1,HttpSession session) {
		ModelAndView mav=new ModelAndView();
		String username=(String)session.getAttribute("username");
		System.out.println("username is "+username);
		RegisterUser loggedInUser=userDao.findByUname(username); //geetings details using username
		Optional<UploadMedia> uploadmedia=imageDao.findById(comments1.getUploadmedia().getId());
	
       Long loggedin=loggedInUser.getId();
		Optional<RegisterUser> user=userDao.findById(loggedin);
		Long id=uploadmedia.get().getId();
		loggedInUser.getComments().add(comments1);
		comments1.setUsername(username);
		comments1.setRegisterUser(loggedInUser);
		comments1.setUploadmedia(uploadmedia.get());
		commentsDao.save(comments1);
		return new ModelAndView("redirect:/showphoto/"+id);
	}
	@RequestMapping("showphoto/{id}")/*Gets the id of respective photo*/
	public ModelAndView showphoto(HttpSession session,@PathVariable("id") long id)
    {
		ModelAndView mav=new ModelAndView();
		mav.addObject("commentsDatamedia",new Comments());
		Optional<UploadMedia> photo=imageDao.findById(id);
		
		
		Set<Long> getcommentid=commentsDao.findbyImageid(id);
		List<Comments> listcomments=commentsDao.findAllById(getcommentid);
		for(int i=0;i<listcomments.size();i++)
	
		
		mav.addObject("comments",listcomments);
   	 	mav.addObject("photo",photo.get());
   	 	mav.setViewName("Media");
    	return mav;
    }

}
