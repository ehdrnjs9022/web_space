package home.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import home.dto.UserDTO;

public class UserDAO {
	
	
	static {
		try {
			Class.forName("oracle:jdbc:driver:OracleDriver");
		}catch (Exception e) {
			
		}
		
	}
	
	
	public List<UserDTO> findall(){
		
		List<UserDTO> list = new ArrayList<UserDTO>();
		
		try {
		Connection conn = DriverManager.getConnection("jdbd:oracle:thin@112.221.156,34:12345,KH25_JDK,KH1234");
		PreparedStatement pstmt = conn.prepareStatement(
				"""
				SELECT 
					USER_NO, 
					USER_ID, 
					USER_NAME, 
					USER_PW, 
					USER_ENROLLDATE 
				FROM USER_TB
				ORDER BY 
					USER_ENROLLDATE DESC
				"""
				
				);
			
		ResultSet rset = pstmt.executeQuery();
		
		while(rset.next()){
			UserDTO user = new UserDTO();
				rset.getInt("UserNO");
				rset.getString("UserId");
				rset.getString("UserName");
				rset.getString("Userpw");
				rset.getDate("ENROLLDATE");
			
				list.add(user);
		}
		
			
		}catch (Exception e) {

		}
	
		return list;
		
	}
}
