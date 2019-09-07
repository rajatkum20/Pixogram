package com.social.imageaApp.account.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.social.imageApp.model.RegisterUser;
import com.social.imageaApp.dao.UserDao;

@Controller
public class AccountUpdateController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/AccountUpdate")
	public ModelAndView UpdateDetails()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("update",new RegisterUser());
		mv.setViewName("AccountUpdate");
		return mv;
	}
	@PostMapping("/AccountUpdate")
	public ModelAndView register(@ModelAttribute("update")RegisterUser update,HttpSession session)
	{
		RegisterUser u=new RegisterUser();
		
		u=userDao.findByUname((String)session.getAttribute("username"));
		u.setUname(update.getUname());
		u.setEmail(update.getEmail());
		u.setPsw(update.getPsw());
		userDao.save(u);
		return new ModelAndView("redirect:/uploadmedianew");
		
	}
}
