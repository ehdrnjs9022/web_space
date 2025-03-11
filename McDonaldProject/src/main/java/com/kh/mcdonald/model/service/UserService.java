package com.kh.mcdonald.model.service;

import java.util.List;

import com.kh.mcdonald.model.dao.UserDAO;
import com.kh.mcdonald.model.dto.UserDTO;

public class UserService {
	
	private UserDAO userDao = new UserDAO();
	
	
	public List<UserDTO> findAll(){
		return userDao.findall();
		
	}
	
	
}
