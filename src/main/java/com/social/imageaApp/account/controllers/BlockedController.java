package com.social.imageaApp.account.controllers;

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

//	HashMap<Long,List<String>> blocklist = new HashMap<Long, List<String>>();
//	
//	@RequestMapping("block/{username}") /* Gets the id of respective photo */
//	public ModelAndView block(HttpSession session, @PathVariable("username")String username) {
//		ModelAndView mav = new ModelAndView();
//	
//		;
//		//List<RegisterUser> b =(List<RegisterUser>) userDao.findAllById(id);
//		RegisterUser user=userDao.findByUname(username);
//		RegisterUser currentUser=userDao.findByUname((String) session.getAttribute("username"));
//		user.setIsBlocked(1);
//		List<String> blockedUser=user.getUname();
//		Long Id=currentUser.getId();
//		blocklist.put(Id,blockedUser);
//		userDao.save(user);
//		System.out.println("ID for current Session"+Id);
//		System.out.println("Blocked is Working");
//		mav.addObject("blocklist", blocklist);
//		mav.setViewName("Blocked");
//		/*
//		 * String ownerUser=(String)session.getAttribute("ownerUser"); Owner
//		 * owner=homeservice.getOwnerByUser(ownerUser); int ownerid=owner.getU_id();
//		 * List<Booking> ownerList= bookserv.showOwnerBookingList(ownerid);
//		 */
////		mav.setViewName("Blocked");
//	//	return new ModelAndView("redirect:/Blocked");
//		return mav;
//	}
//	@RequestMapping("/block") /* Gets the id of respective photo */
//	public ModelAndView block(HttpSession session) {
//		ModelAndView mav = new ModelAndView();
//	//	List<RegisterUser> b = userDao.findAll();
//		 System.out.println("Fetching Keys and corresponding [Multiple] Values n");
//	        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
//	            String key = entry.getKey();
//	            List<String> values = entry.getValue();
//	            System.out.println("Key = " + key);
//	            System.out.println("Values = " + values + "n");
//	        }
//		mav.addObject("blocklist", blocklist);
//		mav.setViewName("Blocked");
//		
//		return mav;
//	}
HashMap<Long,List<String>> blocklist = new HashMap<Long, List<String>>();
	
	@RequestMapping("block/{username}") /* Gets the id of respective photo */
	public ModelAndView block(HttpSession session, @PathVariable("username")String username) {
		ModelAndView mav = new ModelAndView();
	
		List<String> l=new ArrayList<>();
		//List<RegisterUser> b =(List<RegisterUser>) userDao.findAllById(id);
		RegisterUser user=userDao.findByUname(username);
		RegisterUser currentUser=userDao.findByUname((String)session.getAttribute("username"));
		
		 
		user.setIsBlocked(1);
		String blockedUser=user.getUname();
		l.add(blockedUser);
		Long Id=currentUser.getId();
		blocklist.put(Id,l);
		userDao.save(user);
		System.out.println("ID for current Session"+Id);
		System.out.println("Blocked is Working");
		mav.addObject("blocklist", blocklist);
//		mav.setViewName("Blocked");
		/*
		 * String ownerUser=(String)session.getAttribute("ownerUser"); Owner
		 * owner=homeservice.getOwnerByUser(ownerUser); int ownerid=owner.getU_id();
		 * List<Booking> ownerList= bookserv.showOwnerBookingList(ownerid);
		 */
//		mav.setViewName("Blocked");
		return new ModelAndView("redirect:/block");
		//return mav;
	}
	@RequestMapping("/block") /* Gets the id of respective photo */
	public ModelAndView block(HttpSession session) {
		ModelAndView mav = new ModelAndView();
	//	List<RegisterUser> b = userDao.findAll();
		 Map<String ,List<String>> map=new HashMap<>();
		 System.out.println("Fetching Keys and corresponding [Multiple] Values n");
	        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
	            String key = entry.getKey();
	            List<String> values = entry.getValue();
	            System.out.println("Key = " + key);
	            System.out.println("Values = " + values + "n");
	        }
		mav.addObject("blocklist", blocklist);
		mav.setViewName("Blocked");
		
		return mav;
	}


}
