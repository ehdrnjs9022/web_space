package com.kh.mfw.member.model.dto;

import java.sql.Date;

public class MemberDTO {

	private String memberId;
	private String memberPw;
	private String memberName;
	private String email;
	private Date endollDate;
	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberDTO(String memberId, String memberPw, String memberName, String email, Date endollDate) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.email = email;
		this.endollDate = endollDate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
	@Override
	public String toString() {
		return "MemberDTO [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName + ", email="
				+ email + ", endollDate=" + endollDate + "]";
	}


	


	
	
	
	
	
	
	

}