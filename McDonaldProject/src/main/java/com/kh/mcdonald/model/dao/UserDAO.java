package com.kh.mcdonald.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.mcdonald.model.dto.UserDTO;

public class UserDAO {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<UserDTO> findall(){
		List<UserDTO> list = new ArrayList<UserDTO>();
		
		
		try(
			Connection conn 
				= DriverManager.getConnection
				("jdbc:oracle:thin:@112.221.156.34:12345"
				,"KH25_JDK","KH1234")){
		PreparedStatement pstmt = conn.prepareStatement(
				"""
				 SELECT 
						USER_NO,
						USER_ID,
						USER_PW, 
						USER_NAME,
						ENROLL_DATE 
				FROM 
						TB_USER 
				ORDER BY 
					ENROLL_DATE DESC 
				"""
				);
				
		ResultSet rset = pstmt.executeQuery();
		
			while(rset.next()) {
				list.add(new UserDTO(
						rset.getInt("USER_NO"),
						rset.getString("USER_ID"),
						rset.getString("USER_PW"),
						rset.getString("USER_NAME"),
						rset.getDate("ENROLL_DATE")
						
						));
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}




}
