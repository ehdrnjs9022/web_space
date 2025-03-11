package home.dto;

import java.sql.Date;

public class UserDTO {
	
	private int userNo;	
	private String userId;
	private String userName;
	private String userPw;
	private Date enrollDate;
	
	public UserDTO() {
		super();
	}
	public UserDTO(int userNo, String userId, String userName, String userPw, Date enrollDate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userName = userName;
		this.userPw = userPw;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	
	
	@Override
	public String toString() {
		return "UserDTO [userNo=" + userNo + ", userId=" + userId + ", userName=" + userName + ", userPw=" + userPw
				+ ", enrollDate=" + enrollDate + "]";
	}
	
}
