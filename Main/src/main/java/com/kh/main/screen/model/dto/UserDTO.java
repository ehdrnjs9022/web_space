package com.kh.main.screen.model.dto;

public class UserDTO {

	private String UserId;
	private String UserName;
	private String UserPw;
	public UserDTO() {
	
	}
	public UserDTO(String userId, String userName, String userPw) {
		super();
		UserId = userId;
		UserName = userName;
		UserPw = userPw;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserPw() {
		return UserPw;
	}
	public void setUserPw(String userPw) {
		UserPw = userPw;
	}
	@Override
	public String toString() {
		return "UserDTO [UserId=" + UserId + ", UserName=" + UserName + ", UserPw=" + UserPw + "]";
	}
	
	
	
	
	
}
