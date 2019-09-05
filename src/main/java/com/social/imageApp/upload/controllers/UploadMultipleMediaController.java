package com.social.imageApp.upload.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.social.imageApp.model.UploadMedia;
import com.social.imageaApp.dao.ImageDao;

@Controller
public class UploadMultipleMediaController {
	
	
	@Autowired
	private ImageDao imageDao;
	
	@GetMapping("/multipleupload")
	public ModelAndView multipleUpload()
	{
		ModelAndView mav=new ModelAndView();
		mav.addObject("uploadmedia",new UploadMedia());
		mav.setViewName("UploadMultiMedia");
		return mav;
	}
	@PostMapping("/multipleupload")
	public ModelAndView multipleFileUpload(ModelMap model,@RequestParam("file") MultipartFile[] file,@RequestParam("tags") List<String>tags,@RequestParam("title") List<String>title,@RequestParam("description")List<String>description,HttpSession session)throws IOException
	{

		ModelAndView mav=new ModelAndView();
		int i=0;
		 if (file != null && file.length >0) {
	            for (MultipartFile aFile : file){
	            	UploadMedia up=new UploadMedia();
	            	System.out.println(file.length +" Multipart lenght");
	            	up.setPic(aFile.getBytes());
	            	byte a[]=aFile.getBytes();
	            	byte img[]=Base64.encodeBase64(a);
	            	String base64enc=new String(img,"UTF-8");
	            	up.setEncimg(base64enc);
	            	up.setUsername((String)session.getAttribute("username"));
	            	up.setTags(tags.get(i)); 
	            	up.setDescription(description.get(i));
	            	up.setTitle(title.get(i));
	            	i++;
	            	imageDao.save(up);	            	
	            }
	            
	            
			
	            }
		return new ModelAndView("redirect:/mymediapic",model);
	}

}
