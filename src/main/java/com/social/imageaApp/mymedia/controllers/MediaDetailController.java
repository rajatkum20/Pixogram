package com.social.imageaApp.mymedia.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.social.imageApp.model.UploadMedia;
import com.social.imageaApp.dao.ImageDao;


@Controller
public class MediaDetailController {
	
	@Autowired
	private ImageDao imageDao;
	
	@RequestMapping("showphoto/{id}")/*Gets the id of respective photo*/
	public ModelAndView showphoto(HttpSession session,@PathVariable("id") long id)
    {
		ModelAndView mav=new ModelAndView();
		Optional<UploadMedia> photo=imageDao.findById(id);
		
   	 	mav.addObject("photo",photo.get());
		
		mav.setViewName("Media");
    	return mav;
    }

}
