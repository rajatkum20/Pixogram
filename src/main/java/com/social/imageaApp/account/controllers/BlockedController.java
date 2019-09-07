package com.social.imageaApp.account.controllers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.social.imageApp.model.RegisterUser;
import com.social.imageApp.model.UploadMedia;
import com.social.imageaApp.dao.ImageDao;
import com.social.imageaApp.dao.UserDao;

@Controller
public class BlockedController {
	@Autowired
	private UserDao userDao;
	
	Optional<RegisterUser> ll ;
	
	 Set<Long> BlockedList=new HashSet<Long>();
	final Set<String>userBlockedList=new HashSet<String>();
	
	@ModelAttribute
	@RequestMapping("block/{username1}") 
	public ModelAndView block(HttpSession session, @PathVariable("username1")String username1) {
		ModelAndView mav = new ModelAndView();
		  String username=(String)session.getAttribute("username"); //getting username of looged in user
          RegisterUser loggedInUser=userDao.findByUname(username); //geetings details using username
          Long loggedin=loggedInUser.getId();		//gettingIdofLoggedUSer
          RegisterUser user_id=userDao.findByUname(username1);
          Long id=user_id.getId();
          Optional<RegisterUser> user=userDao.findById(id); //
          
          loggedInUser.getBlocked().add(user.get());
          if(loggedInUser.getFollowing().contains(user.get()))
          {        		
          loggedInUser.getFollowing().remove(user.get());
          }
          userDao.save(loggedInUser);
          BlockedList= userDao.findBlockUsers(loggedin);         
          
          List<RegisterUser>usersBlocked=userDao.findAllById(BlockedList);
          mav.addObject("blocklist", usersBlocked);
          return new ModelAndView("redirect:/block");
	}
	
	@ModelAttribute
	@GetMapping("/block")
	public ModelAndView blockedUser(HttpServletRequest request,HttpServletResponse res,HttpSession session)
	{
		ModelAndView mav=new ModelAndView();
		String username=(String)session.getAttribute("username");
		RegisterUser loggedInUser=userDao.findByUname(username); 
		  Long loggedin=loggedInUser.getId();
		  BlockedList= userDao.findBlockUsers(loggedin);
		  List<RegisterUser>usersBlocked=userDao.findAllById(BlockedList);
		  
		mav.addObject("username",username);
		mav.addObject("blocklist",usersBlocked);
		mav.setViewName("Blocked");
		return mav;
	}
	@GetMapping("/unblock/{id}")
	public ModelAndView unblock(@PathVariable("id")Long id,HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
        String username=(String)session.getAttribute("username"); //getting username of looged in user
        RegisterUser loggedInUser=userDao.findByUname(username); //geetings details using username
        Long loggedin=loggedInUser.getId();		//gettingIdofLoggedUSer
        Optional<RegisterUser> user=userDao.findById(id);
        loggedInUser.getBlocked().remove(user.get());
      
        userDao.save(loggedInUser);
		return new ModelAndView("redirect:/block");
		
	}
	}

