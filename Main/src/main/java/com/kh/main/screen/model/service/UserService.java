package com.kh.main.screen.model.service;

import com.kh.main.screen.model.dao.UserDAO;
import com.kh.main.screen.model.dto.UserDTO;

public class UserService {
	
	
	
	public UserDTO login(UserDTO log) {
		
	UserDTO userLogin = new UserDAO().login(log);
	
		return userLogin;
	
	}
	
	
	
	
	
}
