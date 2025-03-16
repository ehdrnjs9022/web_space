package com.kh.mfw.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mfw.member.model.dto.MemberDTO;
import com.kh.mfw.member.model.service.MemberService;

@WebServlet("/modifyPw")
public class ModifyPwController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyPwController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String pw = request.getParameter("memberPw");
		String changePwd = request.getParameter("changePwd");
		
		
		int result = new MemberService().modifyPw(pw,changePwd);
		
		String path = request.getContextPath();
		
		if(result > 0) {
			
			request.getSession().setAttribute("message", "비밀번호가 성공적으로 변경되었습니다.");
		} else if (pw != null && changePwd != null) {
			request.getSession().setAttribute("message", "비밀번호 변경에 실패하셨습니다.");
		}
		
		response.sendRedirect(result > 0 ? path  : path + "/mfw");
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
