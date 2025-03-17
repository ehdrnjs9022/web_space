package com.kh.mfw.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mfw.board.model.dto.BoardDTO;

public class BoardDAO {

	
	public void insertBoard(SqlSession sqlSession, BoardDTO board) {
		sqlSession.insert("boardMapper.insertBoard", board);
		
		
	}
	
	public List<BoardDTO> selectBoards(SqlSession sqlSession, RowBounds rowBounds ){
		
		return sqlSession.selectList("boardMapper.selectBoards", null, rowBounds);
		
	
	}

	public int selectBoardCount(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.selectBoardCount");
	}
	
	public int increaseCount(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.increaseCount", boardNo);
		
	}

	public BoardDTO findByBoardNo(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.findByBoardNo", boardNo);
		
	}













}
