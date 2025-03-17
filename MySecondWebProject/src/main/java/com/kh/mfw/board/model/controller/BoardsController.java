package com.kh.mfw.board.model.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mfw.board.model.service.BoardService;

@WebServlet("/boards")
public class BoardsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardsController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		int page = Integer.parseInt(request.getParameter("page"));
		
		Map<String,Object> map =new BoardService().selectBoards(page);
		
		request.setAttribute("map", map);
		request.getRequestDispatcher("/WEB-INF/views/board/boards.jsp")
		.forward(request, response);
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
