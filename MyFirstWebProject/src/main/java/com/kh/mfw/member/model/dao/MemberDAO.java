package com.kh.mfw.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.mfw.member.model.dto.MemberDTO;

public class MemberDAO {

	static {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private Object PreparedStatement;
	
	public MemberDTO login(MemberDTO member) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
	
		String sql = """
					SELECT 
							  MEMBER_ID
							, MEMBER_PW
							, MEMBER_NAME
							, EMAIL
							, ENDOLLDATE
						FROM 
							  KH_MEMBER
						WHERE 
							 MEMBER_ID = ?
						AND 
							 MEMBER_PW = ?
				""";
		
		MemberDTO loginMember = null; 
		
		try {
		conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@112.221.156.34:12345"
				,"KH25_JDK","KH1234"
				);
		
		pstmt =	conn.prepareStatement(sql);
		
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberPw());
		
		rset = pstmt.executeQuery();
		
		if(rset.next()) {	
			loginMember = new MemberDTO(
					rset.getString("MEMBER_ID"),
					rset.getString("MEMBER_PW"),
					rset.getString("MEMBER_NAME"),
					rset.getString("EMAIL"),
					rset.getDate("ENDOLLDATE")
					);
		}
		
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		} try {
			if(rset != null) rset.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		
		}
		return loginMember;
	}

	public int checkId(String memberId) {
		
		// COUNT, MEMBER_ID 머쓰냐에 따라 RESULTSET(조회된행)값이달라짐
		
		String sql = """
						SELECT 
								COUNT(*) 
						FROM 
							KH_MEMBER 
						WHERE 
							MEMBER_ID = ? 
				
				""";
	
	
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rset = null;
	
		
		int result=0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@112.221.156.34:12345"
												,"KH25_JDK","KH1234");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			/*
			 * case 1 : count(*) 그룹함수 사용했을 때
			 * 			무조건 ResultSet이 1행이 존재함
			 * 			컬럼값이 0 / 1 인것으로 조회결과 판별
			 *		rset.next();
					return rset.getInt("COUNT(()");
			 */
			
			/*
			 * case 2 : MEMBER_ID 컬럼을 조회한 경우
			 * 		  reset.getString("MEMBER_ID)
			 * 
			 */
			rset.next();
			result = rset.getInt("COUNT(*)");
		
		
		}catch (SQLException e) {
			e.printStackTrace();
		} finally{
			
		} try {
			if(rset!= null) rset.close();
			if(pstmt!= null) pstmt.close();
			if(conn!= null) conn.close();
		}catch (Exception e) {

		}
	
		return result;
	
	}

	public void signUp(MemberDTO member) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = """
						INSERT 
						 INTO  
						 		KH_MEMBER 
						 VALUES 
							( ? , ? , ? , ? , DEFAULT )
				""";
		
		try {
		
		conn = DriverManager.getConnection("jdbc:oracle:thin:@112.221.156.34:12345"
				,"KH25_JDK","KH1234");
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberPw());
		pstmt.setString(3, member.getMemberName());
		pstmt.setString(4, member.getEmail());
		
		pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally {
			
		}try {
			if(pstmt !=null) pstmt.close();
			if(conn !=null)  conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		
		}
		
	}
	
	public int modify(MemberDTO member) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = """
					    UPDATE KH_MEMBER SET  
					    MEMBER_NAME = ? , EMAIL = ? 
					   	WHERE MEMBER_ID = ? 
					    
				""";
		
		int result =0;
		try {
			
			conn =	DriverManager.getConnection("jdbc:oracle:thin:@112.221.156.34:12345"
					,"KH25_JDK","KH1234");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberName());	
			pstmt.setString(2, member.getEmail());	
			pstmt.setString(3, member.getMemberId());	
				
			pstmt.executeUpdate();	
				
				
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}try {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int modifyPw(String pw, String changePwd) {
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		String sql = """
					UPDATE KH_MEMBER SET 
					MEMBER_PW = ?
					WHERE 
					MEMBER_PW = ? 
				""";
		int result = 0;
		try {
				conn=DriverManager.getConnection("jdbc:oracle:thin:@112.221.156.34:12345:xe",
												"KH25_JDK","KH_1234");
			
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, changePwd);
				pstmt.setString(2, pw);
				
				pstmt.executeUpdate();
				
		}catch (SQLException e) {
			e.printStackTrace();
		
		
		} finally {
		
		} try {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
		

}

