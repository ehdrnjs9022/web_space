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
		
		pstmt.setString(1, member.getMebmerId());
		pstmt.setString(2, member.getMebmerPw());
		
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
}
