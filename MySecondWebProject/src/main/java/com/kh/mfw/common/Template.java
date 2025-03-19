package com.kh.mfw.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {

	
	/*
	 * JDBC Util
	 * 
	 * public static Connection getConnection(){
	 * 
	 *  Connection conn = null;
	 * 	try{
	 * 		conn = DriverManager.getConnection();
	 * }catch(SQLException e) 
	 * }
	 */
	
	// MyBatis FrameWork Version
	
	/*
	 * Connection 역할하는 SqlSession
	 */
	
	
	public static SqlSession getSqlSession() {
		
		SqlSession sqlSession = null;
		
		try {
			InputStream stream = Resources.getResourceAsStream("/mybatis-config.xml");
		
			// 1단계 : SqlSessionFactoryBuilder 객체생성
			// 		  그냥 생성자 호출하면됨
			// 2단계 : SqlSessionFactory 객체 생성
			//        build(입력스트림) 스트림으로부터 환경설정파일의 값을 읽어오면서 SqlSessionFactory객체 생성
			// 3단계 : SqlSession 객체 생성
			
		sqlSession	
			= new SqlSessionFactoryBuilder().build(stream).openSession();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSession;
	
	
	}
	
	
	
	
}
