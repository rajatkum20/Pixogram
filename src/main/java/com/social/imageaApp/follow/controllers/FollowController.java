package com.social.imageaApp.follow.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.social.imageApp.model.Followers;
import com.social.imageApp.model.RegisterUser;
import java.math.BigInteger;
import com.social.imageaApp.dao.UserDao;

@Controller
public class FollowController {
	@Autowired
	private UserDao userDao;

	Set<Long> useridList=new HashSet<Long>();
	Optional<RegisterUser> ll ;
	List<RegisterUser> followers=new ArrayList<RegisterUser>();
	final List<String>userNamelist=new ArrayList<String>();
	@ModelAttribute
	@RequestMapping("Follow")
    public ModelAndView follow(HttpSession session) 
    {
		
                    ModelAndView mav = new ModelAndView();
                    String username=(String)session.getAttribute("username");
                    RegisterUser loggedInUser=userDao.findByUname(username);
                	Long loggedin=loggedInUser.getId();
                	useridList= userDao.findFollowingUsers(loggedin);
                    List<RegisterUser> data=userDao.findAll();
                    Set<Long>userBlockList=userDao.findBlockUsers(loggedin);
                    List<RegisterUser> blockedUsers=userDao.findAllById(userBlockList);
                   	Iterator<RegisterUser> iter=data.iterator();
                                      	       
                   	List<Long> list1=new ArrayList<Long>();
                   	List<Long> list2=new ArrayList<Long>();
                   	for(int i=0;i<data.size();i++)
                   	{
                   	list1.add(data.get(i).getId());
                   	}
                	for(int i=0;i<blockedUsers.size();i++)
                   	{
                   	list2.add(blockedUsers.get(i).getId());
                   	}
                	list1.removeAll(list2);
                	list1.remove(loggedin);
                	List<RegisterUser> userwithblock=userDao.findAllById(list1);
              
                    
		
                    mav.addObject("username",username);
                    	followers=userDao.findAllById(useridList);
                        mav.addObject("data", userwithblock);
                
                    mav.setViewName("Follow");
                    return mav;                        
    }
	@ModelAttribute
	@RequestMapping("/followers/{id}")
	public ModelAndView followw(HttpSession session,@PathVariable("id") Long id,ModelMap map) 
    {

	           		ModelAndView mav = new ModelAndView();
                    String username=(String)session.getAttribute("username"); //getting username of looged in user
                    RegisterUser loggedInUser=userDao.findByUname(username); //geetings details using username
                    Long loggedin=loggedInUser.getId();		//gettingIdofLoggedUSer
                    Optional<RegisterUser> user=userDao.findById(id); //
                    loggedInUser.getFollowing().add(user.get());
                    userDao.save(loggedInUser);
                   	useridList= userDao.findFollowingUsers(loggedin);
                   	
                   	followers=userDao.findAllById(useridList);
                                  	
     
              	 Iterator<Long> iter = null; 
              	 iter=useridList.iterator();
              	 mav.addObject("data",followers);
              	 mav.setViewName("Followers");
				return mav;
    

    }
	@RequestMapping("/followers")
	
	public ModelAndView openFollowers(HttpServletRequest request, HttpServletResponse res) {
		System.out.println("Followers");
		ModelAndView mav = new ModelAndView();
		HttpSession mySession = request.getSession();
		String username = (String) mySession.getAttribute("username");		
		mav.addObject("username", username);
		mav.addObject("data",followers);
		mav.setViewName("Followers");
		return mav;
	}
	
	@RequestMapping("/unfollow/{id}")
	public ModelAndView unfollow(HttpSession session,@PathVariable("id") Long id)
	{
		ModelAndView mav = new ModelAndView();
        String username=(String)session.getAttribute("username"); //getting username of looged in user
        RegisterUser loggedInUser=userDao.findByUname(username); //geetings details using username
        Long loggedin=loggedInUser.getId();		//gettingIdofLoggedUSer
        Optional<RegisterUser> user=userDao.findById(id);
        loggedInUser.getFollowing().remove(user.get());
        userDao.save(loggedInUser);
      return new ModelAndView("redirect:/Follow");
	
	}
}


