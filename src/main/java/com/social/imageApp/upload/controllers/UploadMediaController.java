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

import com.social.imageApp.model.MultipleImage;
import com.social.imageApp.model.RegisterUser;
import com.social.imageApp.model.UploadMedia;
import com.social.imageApp.model.UserList;
import com.social.imageaApp.dao.ImageDao;
import com.social.imageaApp.dao.UserDao;

@Controller
public class UploadMediaController {
	
	UploadMedia upmedia=new UploadMedia();

	@Autowired
	private ImageDao imageDao;
	@Autowired
	private UserDao userDao;
	
	
	@PostMapping("/upload")
	public ModelAndView FileUpoad(ModelMap model, @RequestParam("file") MultipartFile file,@ModelAttribute("uploadmedia") UploadMedia uploaddetails, HttpSession session) throws IOException
	{
		UploadMedia up=new UploadMedia();
		System.out.println(uploaddetails.getDescription()+"Dis of image");
		System.out.println(uploaddetails.getTags()+"Tags of image");
		System.out.println(file.getBytes()+"navvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvmmmmmmmmmmmmmmmmmm");
		ModelAndView mv=new ModelAndView();
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
	@GetMapping("/multipleupload")
	public ModelAndView multipleUpload()
	{
		ModelAndView mav=new ModelAndView();
		mav.addObject("uploadmedia",new MultipleImage());
		mav.setViewName("UploadMultiMedia");
		return mav;
	}
	@PostMapping("/multipleupload")
	public ModelAndView multipleFileUpload(ModelMap model,@RequestParam("file") MultipartFile[] file,@ModelAttribute("uploadmedia") UserList uploaddetails,HttpSession session)throws IOException
	{
		List<MultipleImage> userList=uploaddetails.getListUsers();
		ModelAndView mav=new ModelAndView();
		int i=file.length;
		 if (file != null && i >0) {
	            for (MultipartFile aFile : file){
	            	UploadMedia up=new UploadMedia();
	            	System.out.println(file.length +" Multipart lenght");
	            	up.setPic(aFile.getBytes());
	            	byte a[]=aFile.getBytes();
	            	byte img[]=Base64.encodeBase64(a);
	            	String base64enc=new String(img,"UTF-8");
	            	up.setEncimg(base64enc);
	            	up.setUsername((String)session.getAttribute("username"));
	            	 imageDao.save(up);
	            	
	            }
	            System.out.println("USerLis size "+ uploaddetails.getListUsers().size());
	          for(MultipleImage user:userList)
	          {
	        	  UploadMedia ups=new UploadMedia();
	        	  ups.setTitle(user.getTitle());
	        	  ups.setDescription(user.getDescription());
	        	  ups.setTags(((MultipleImage) user).getDescription());
	        	  imageDao.save(ups);
	          }
            	
	            }
		return new ModelAndView("redirect:/mymediapic",model);
	}
	
}
