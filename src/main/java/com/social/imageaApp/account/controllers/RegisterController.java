package com.social.imageaApp.account.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.social.imageApp.model.RegisterUser;
import com.social.imageApp.model.UploadMedia;
import com.social.imageApp.service.UserServiceImpl;
import com.social.imageaApp.dao.ImageDao;
import com.social.imageaApp.dao.UserDao;




@Controller
public class RegisterController {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ImageDao imageDao;
	@GetMapping("/Login")
	public ModelAndView login()
	{
	ModelAndView mv=new ModelAndView();
	mv.setViewName("Login");
	return mv;
	}
	
	@RequestMapping("/registration")
	public ModelAndView register()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("register",new RegisterUser());
		mv.setViewName("Register");
		return mv;
	}
	@PostMapping("/registration")
	public ModelAndView addUser(@ModelAttribute("register") RegisterUser registeruser)
	{
		ModelAndView mv=new ModelAndView();
		
		userDao.save(registeruser);
		System.out.println("Registration Successful");
		mv.addObject("uploadmedia",new com.social.imageApp.model.UploadMedia());
		mv.setViewName("UploadMedia1");
	 return new ModelAndView("redirect:/");
	}
	
	
	@PostMapping("/loginentry")
	public ModelAndView loginuath(ModelMap model,@RequestParam("uname")String uname,@RequestParam("psw")String psw,HttpServletRequest request)
	
	{
	System.out.println(uname+"User name");
			ModelAndView mav=new ModelAndView();
			System.out.println("Userlogin"+uname);
	
			RegisterUser user=userDao.findByUnameAndPsw(uname, psw);
			request.getSession().setAttribute("username", uname);
					System.out.println(user+"USerservice");
		if(user!=null)
		{
			request.getSession().setAttribute("username", uname);
			mav.addObject("uploadmedia",new com.social.imageApp.model.UploadMedia());
			mav.addObject("username",uname);
			mav.setViewName("UploadMedia1");
			return mav;
		}else
		{
			mav.addObject("register",new RegisterUser());
			mav.setViewName("Register");
			return mav;
	}
	}
	    
	

	    @GetMapping({"/"})
	    public ModelAndView welcome(Model model) {
	    	ModelAndView m=new ModelAndView();
	        m.setViewName("Login");
	        return m;
	    }

			    @GetMapping({"/UploadMultiMedia"})
			    public ModelAndView UploadMultiMedia(Model model, HttpSession session) {
			    	session.getAttribute("username");
			    	ModelAndView m=new ModelAndView();
			        m.setViewName("UploadMultiMedia");
			        return m;
			    }
	    


	
}
