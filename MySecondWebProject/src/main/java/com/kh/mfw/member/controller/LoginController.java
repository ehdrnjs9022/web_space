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

@WebServlet("/sign-in")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
   
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 절차
		// 1) GET / POST => 요청 전송방식이 POST라면 인코딩 작업
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청값이 있나? 없나? => 있다면 값을 뽑아서 가공
		// request.getParameter("input요소의 name속성값");
		// -> 100% 무조건 input요소의 name속성값을 적는것은 아님
		
		// memberId / memberPw
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		// System.out.printf("입력한 아이디 값 : %s \n입력한 비밀번호값 :  %s" , userId,userPw );
		
		// 3) 값이 두 개 이상일 경우 어딘가에 담기
		
		MemberDTO member = new MemberDTO();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		// 서비스에 넘겨주려면 메모리에 올라가 있어야하기때문에 객체 생성 -> 여기서 넘겨줌
		MemberDTO loginMember =new MemberService().login(member);
		// case 1. 아이디와 비밀번호값이 일치했다면
		//         필드값에 회원정보가 답겨있는 MemberDTO객체의 주소 값
		
		// case 2. 유효성검증에 통과하지 못했거나, 아이디 또는 비밀번호가 일치하지 않았다면
		//         null 값
		
		// System.out.println(loginMember);
		
		// 4) 응답화면 만들기
		
		//request.setAttribute("loginMember", loginMember);
		
		/*
		 * 로그인에 성공했다면,
		 * 로그인 한 회원의 정보를 
		 * 로그아웃 요청이 들어오거나, 브라우저르 종료하기 전까지는
		 * 계속 사용할 수 있어야 하기 때문에,
		 * Session이라는 저장소에 값을 담아둘 것
		 */
		
		// Session의 자료형 : HttpSession
		HttpSession session = request.getSession();
		session.setAttribute("loginMember",loginMember);
		
		//request.getRequestDispatcher("index.jsp").forward(request, response);
		
		// http://localhost/mfw
		// sendRedirect : Client에게 재 요청할 URL을 알려주어서
		// Client가 다시 요청을 보내게 만드는 방법
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	
	}

}
