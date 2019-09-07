package com.social.imageaApp.mymedia.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.social.imageApp.model.Comments;
import com.social.imageApp.model.RegisterUser;
import com.social.imageApp.model.UploadMedia;
import com.social.imageaApp.dao.ImageDao;
import com.social.imageaApp.dao.UserDao;;

@Controller
public class MyMediaController {

	
	
	@Autowired
	private ImageDao imageDao;
	@Autowired
	private UserDao userDao;
	

	@RequestMapping("mymediapic")/*pg are filtered based on multiple filters */
    public ModelAndView getfilterpg(HttpSession session) 
    {
		
                    ModelAndView mav = new ModelAndView();
                    String username=(String)session.getAttribute("username");
                    System.out.println("username is "+username);
                    List<UploadMedia> data=imageDao.findByUsername(username);
		 		 
                   // List<RegisterUser> databyusername=(List<RegisterUser>) userDao.findByUname(username);
                    mav.addObject("username",username);
                    mav.addObject("data", data);
                    mav.addObject("commentsDatamedia",new Comments());
                
                    mav.setViewName("MyMedia");
                    return mav;                        
    }
	@GetMapping("/uploadmedianew")
	  public ModelAndView upload1()
	  {
		 ModelAndView mav = new ModelAndView();
		 mav.addObject("uploadmedia",new com.social.imageApp.model.UploadMedia());
		 mav.setViewName("UploadMedia1");
		 return mav;
	  }
}
