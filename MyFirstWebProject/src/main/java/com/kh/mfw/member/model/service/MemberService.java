package com.kh.mfw.member.model.service;

import com.kh.mfw.member.model.dao.MemberDAO;
import com.kh.mfw.member.model.dto.MemberDTO;

public class MemberService {

	public MemberDTO login(MemberDTO member) {
		
		/*
		 * - 서비스단에서 유효성 검사하기
		 * 
		 * 로그인이라 함은 
		 * DB에 가서 SELET절에다가 사용자가 입력한
		 * 아이디값과 비밀번화값을 조건절에 사용해서
		 * 조회를 하는 절차를 의미 
		 * ID가 틀리거나 PW 틀려서 로그인 실패할 수 있는 가능성이 있음
		 * 
		 *	member.getMemberId().length() > 10  
		 *	member.getMemberId().equals("")
		 *	(Pw도 마찬가지)
		 *  DB에 갈필요가 없음!!!!!!! ( 원래는 유효성 검사 클래스로 빼야함)
		 *  
		 *  받아온 값이 애초에 쓸수 없는 값이면 DAO로 보낼필요가없음음
		 *  
		 */
		
			MemberDTO loginMember = new MemberDAO().login(member);	
				return loginMember;
	}


	public int signUp(MemberDTO member) {

		int result = new MemberDAO().checkId(member.getMemberId());
								// 아이디중복검사 memberId 다넘길필요없으니 memberId값만넘김 
		
		if(result > 0) {
			return result;
		}
		
	new MemberDAO().signUp(member);
	
	return result;
	
	
	}

	


}
