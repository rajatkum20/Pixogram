package com.social.imageApp.upload.controllers;



import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.social.imageApp.model.UploadMedia;
import com.social.imageApp.model.UserList;
import com.social.imageaApp.dao.ImageDao;
import com.social.imageaApp.dao.UserDao;

@Controller
public class UploadMediaController {
	
	UploadMedia upmedia=new UploadMedia();

	@Autowired
	private ImageDao imageDao;
	
	
	
	@PostMapping("/upload")
	public ModelAndView FileUpoad(ModelMap model, @RequestParam("file") MultipartFile file,@ModelAttribute("uploadmedia") UploadMedia uploaddetails, HttpSession session) throws IOException
	{
		UploadMedia up=new UploadMedia();
		up.setPic(file.getBytes());
		up.setTitle(uploaddetails.getTitle());
		up.setDescription(uploaddetails.getDescription());
		up.setTags(uploaddetails.getTags());
		byte a[]=file.getBytes();
		byte img[]=Base64.encodeBase64(a);
		System.out.println(img+"mnnnnnnnnnnnnnnnnnnnnnnnnnnnn image");
		String base64enc=new String(img,"UTF-8");
		up.setEncimg(base64enc);
		up.setUsername((String)session.getAttribute("username"));
		imageDao.save(up);
		return new ModelAndView("redirect:/mymediapic", model);

	}
	
	
}
