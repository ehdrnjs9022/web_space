package home.service;

import java.util.List;

import home.dao.UserDAO;
import home.dto.UserDTO;

public class UserService {
	
	UserDAO userDao = new UserDAO();
	
	public List<UserDTO> findall(){
		return userDao.findall();
	}
	
}
