package com.social.imageApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.social.imageApp.model.RegisterUser;
import com.social.imageaApp.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional
	public RegisterUser findByUnameAndPsw(String uname, String psw) {
	
		return userDao.findByUnameAndPsw(uname, psw);
	}

	@Override
	public RegisterUser findByUname(String uname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegisterUser addUser(RegisterUser user) {
		return userDao.save(user);
	}

	
	}


