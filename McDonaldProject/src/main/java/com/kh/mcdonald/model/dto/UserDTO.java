package com.kh.mcdonald.model.dto;

import java.sql.Date;

/**
 * 이 클래스의 목적은?
 * 
 *  1. DMBS에 존재하는 TB_USER테이블의 컬럼의 값을 옮겨 담아 View까지 이동할 목적의 객체
 *  
 *  2. View에서 사용자가 입력한 값을 필드에 담아 DAO까지 이이동할 목적의 객체
 */
public class UserDTO {
	
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private Date enrollDate;
	public UserDTO() {
		super();
	}
	public UserDTO(int userNo, String userId, String userPw, String userName, Date enrollDate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.enrollDate = enrollDate;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	@Override
	public String toString() {
		return "UserDTO [userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", userName=" + userName
				+ ", enrollDate=" + enrollDate + "]";
	}
	
	
	
}
