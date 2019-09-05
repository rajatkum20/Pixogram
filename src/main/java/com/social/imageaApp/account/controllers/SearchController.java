package com.social.imageaApp.account.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.social.imageApp.model.RegisterUser;
@Controller
public class SearchController {
	@RequestMapping("/Search")
	public ModelAndView register()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("register",new RegisterUser());
		mv.setViewName("Search");
		return mv;
	}

}
