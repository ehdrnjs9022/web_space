package com.kh.main.screen.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.main.screen.model.dto.UserDTO;
import com.kh.main.screen.model.service.UserService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		UserDTO user = new UserDTO();
		user.setUserId(userId);
		user.setUserPw(userPw);
		
		UserDTO log = new UserService().login(user);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
