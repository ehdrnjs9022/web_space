package com.kh.mfw.board.model.dto;

import java.sql.Date;

public class BoardDTO {
	private int boardNo;
	private String boardCategory;
	private String boardWriter;
	private String boardTitle;
	private String boardContent;
	private int count;
	private Date createDate;
	
	public BoardDTO() {
		super();
	}
	public BoardDTO(int boardNo, String boardCategory, String boardWriter, String boardTitle, String boardContent,
			int count, Date createDate) {
		super();
		this.boardNo = boardNo;
		this.boardCategory = boardCategory;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.count = count;
		this.createDate = createDate;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardCategory() {
		return boardCategory;
	}
	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "BoardDTO [boardNo=" + boardNo + ", boardCategory=" + boardCategory + ", boardWriter=" + boardWriter
				+ ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", count=" + count + ", createDate="
				+ createDate + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
