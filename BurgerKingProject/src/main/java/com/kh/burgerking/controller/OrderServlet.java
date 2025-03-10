package com.kh.burgerking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; // 버전관리 없어도그만
	
    public OrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("/bk/order doGet요청이 들어옴!");
		// 사용자가 입력한 수량 x500 을 해야됨
		
		// 데이터를 받아 가공해가지고 Service로 넘겨주는 역할 >>>>>DB
		// 다시 응답받은 데이터를 View로 받는다
		/*
		 * VIEW에서 GET방식으로 요청 시 doGet()가 호출됨!!!
		 * 
		 * 두 개의 매개변수가 존재함
		 * 
		 * 첫 번째 매개변수 HttpServletRequest => 요청 시 전달된 내용들이 담김
		 * => 요청 전송방식(GET), 사용자의 IP주소, 어떤 URL을 통해서 왔는지, 사용자가 입력한 값 등등
		 * 
		 * 두 번째매개변수 HttpServletResponse => 요청 처리 후 응답할 때 사용 
		 * 
		 */
		
		/*String queryString = request.getQueryString();
		System.out.println(queryString); */
		
		// 파라미터에서 값을 뽑는다
		// requestURL = num=1 (K=num,V=1) 
		
		// 요청 처리 역할
		// 경우1) input 빈칸 시 기본값이 "" 빈칸이기떄문에 Integer로 파싱변환하면 예외생김
		int num =Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		
		// 경우2)
		String productName = request.getParameter("prduct-name");
		System.out.println(productName);
		/*
		 * 자주보는 문제상황
		 * 
		 * 404 : 파일이나 요청을 받아주는 서블릿을 찾지 못했을 때 발생
		 * 		 => 오타일 확률이 높음
		 * 
		 * 500 : 자바 소스코드상의 오류(예외발생)
		 */
		
		// 잘 다녀옴 -> Insert 했다고 침
		/*
		 * 요청처리(Service의 메서드를 호출 해서 DB와의 상호작용까지 끝난 상태)
		 */
		
		int totalPrice = num * 500;
		
		/*
		 * XXX(사용자가 입력한 제품명)의 총 가격은 XXX(총 결제해야하는 금액)원 입니다.
		 */
		
		// 1단계 ) 응답데이터 형식 지정 -> 문서형태의 HTML / 인코딩방식 UTF-8
		response.setContentType("text/html; charset=UTF-8");
		
		// 2단계 ) 출력 스트림 생성
		PrintWriter writer = response.getWriter();
		
		// 3단계 ) 스트림을 통해 HTML 출력
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title> GET방식 응답 </title>");
		writer.println("</head>");
		
		writer.println("<script>");
		writer.println("<alert('축하해')>");
		writer.println("</script>");
		
		writer.printf("%s의 총 가격은 %d원 입니다.", productName, totalPrice);
		
		writer.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/bk/order doPost메소드 호출됨!");
	}

}
