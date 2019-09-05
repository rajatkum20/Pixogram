package com.social.imageApp.service;

import com.social.imageApp.model.RegisterUser;

public interface UserService {

	public RegisterUser findByUnameAndPsw(String uname, String psw);
	public RegisterUser findByUname(String uname);
	public RegisterUser addUser(RegisterUser user);

}
