package com.kh.mfw.member.model.dto;

import java.sql.Date;

public class MemberDTO {

	private String mebmerId;
	private String mebmerPw;
	private String mebmerName;
	private String email;
	private Date endollDate;
	public String getMebmerId() {
		return mebmerId;
	}
	public void setMebmerId(String mebmerId) {
		this.mebmerId = mebmerId;
	}
	public String getMebmerPw() {
		return mebmerPw;
	}
	public void setMebmerPw(String mebmerPw) {
		this.mebmerPw = mebmerPw;
	}
	public String getMebmerName() {
		return mebmerName;
	}
	public void setMebmerName(String mebmerName) {
		this.mebmerName = mebmerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getEndollDate() {
		return endollDate;
	}
	public void setEndollDate(Date endollDate) {
		this.endollDate = endollDate;
	}
	public MemberDTO(String mebmerId, String mebmerPw, String mebmerName, String email, Date endollDate) {
		super();
		this.mebmerId = mebmerId;
		this.mebmerPw = mebmerPw;
		this.mebmerName = mebmerName;
		this.email = email;
		this.endollDate = endollDate;
	}
	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MemberDTO [mebmerId=" + mebmerId + ", mebmerPw=" + mebmerPw + ", mebmerName=" + mebmerName + ", email="
				+ email + ", endollDate=" + endollDate + "]";
	}
	















}