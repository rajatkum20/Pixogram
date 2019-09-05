package com.social.imageaApp.account.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;

public class LogoutController {

	 @RequestMapping("/logout")
	 public String logout(HttpSession session)
	 {
		 session.invalidate();
		 System.out.println(session.getAttribute("username")+"Logout");
		return "/";
				
	 }
}
