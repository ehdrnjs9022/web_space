package com.kh.mcdonald.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mcdonald.model.dto.Hamburger;

@WebServlet("/sc")
public class SettingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SettingController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("잘오나");
		
		// Servlet에서 응답데이터가 있는데?
		// JSP에게 보내줘야함! --> request에 담아서
						// 	  Servlet 내장 객체 / Scope 객체
		
		// Application / Session / Request                / Page 
		// -> 값을 담는 역할(저장소)
		/*
		 * 1. ServletContext (Application Scope)
		 * 하나의 애플리케이션 당, 딱 한개 존재하는 객체
		 * 이 영역에 데이터를 담으면 애플리케이션 전역에서 사용가능
		 * 
		 * 2. HttpSession (Session Scope)
		 * 하나의 브라우저 당, 한 개 존재하는 객체(브라우저 탭 상에서는 공유)
		 * 이 영역에 데이터를 담으면 JSP/Servlet단 에서 사용 가능
		 * 값이 한 번 담기면, 브라우저가 닫히거나, 세션을 비우거나(로그아웃), 
		 * 서버를 중지하기 전까지는 계속해서 사용가능
		 * 
		 * 3. HttpServletRequest (Request Scope)
		 * 요청 시 매 번 생성되는 객체
		 * 이 영역에 데이터를 담으면 해당 request 객체를 포워딩
		 * 받는 읍답 JS에서만 사용가능(1회용)
		 *
		 * 4. pageContext (page Scope)
		 * JSP페이지 내에서만 사용가능
		 * 
		 * => 위 객체들은 값을 담을때는 .setAttribute("키","밸류")
		 * 						 .getAttribute("키")
		 * 						 .removeAttribute("키")	
		 */
		
		// requestScope 값 담기
		// 객체지향 개념에서 제일 중요한 것은 주체
		
		  request.setAttribute("brand", "KFC");
		  request.setAttribute("bestSeller", new Hamburger("징거버거", 6200, "KFC"));
		
		
	   // 응답 뷰 위임 -> 포워딩
		  request.getRequestDispatcher("/WEB-INF/views/print.jsp").forward(request, response);
		
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
