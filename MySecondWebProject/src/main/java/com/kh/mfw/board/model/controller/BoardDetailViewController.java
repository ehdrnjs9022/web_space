package com.kh.mfw.board.model.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mfw.board.model.dto.BoardDTO;
import com.kh.mfw.board.model.service.BoardService;

@WebServlet("/board")
public class BoardDetailViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardDetailViewController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// GET 방식
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		HttpSession session = request.getSession();
		
		if(boardNo < 1) {
				session.setAttribute("message","이 장난꾸러기야");
				response.sendRedirect(request.getContextPath());
				return;
		}
		BoardDTO board =new BoardService().findByBoardNo(boardNo);
		if(board != null) {
			request.setAttribute("board", board);
			request.getRequestDispatcher("/WEB-INF/views/board/detail.jsp")
			.forward(request, response);
			
			
		} else {
			session.setAttribute("message", "존재하지 않는 게시글입니다.");
			response.sendRedirect(request.getContextPath());
		}
	
		request.setAttribute("board", board);
		
		request.getRequestDispatcher("/WEB-INF/views/board/detail.jsp")
		.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
