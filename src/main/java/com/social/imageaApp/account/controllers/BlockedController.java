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

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	final Set<String>userBlockedList=new HashSet<String>();
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
          userDao.save(loggedInUser);
          Set<Long> blockedIdList=userDao.findBlockUsers(loggedin);
          
          Iterator i= blockedIdList.iterator();
         	while(i.hasNext())  
         		{  
         		ll=userDao.findById(((BigInteger)i.next()).longValue());        
         		userBlockedList.add(ll.get().getUname());
         		}
		mav.addObject("blocklist", userBlockedList);
		return new ModelAndView("redirect:/block");
	}
	

	}

