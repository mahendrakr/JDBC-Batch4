package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Exception occured while loading the class");
			e.printStackTrace();
		}

	}

	public static Connection getMySQLConnection() {
		Connection con=null;
		String url="jdbc:mysql://localhost:3306/mydb";
		String userName="root";
		String pswd="myhandsomepapa@0930";
		try {
		con = DriverManager.getConnection(url,userName,pswd);
		} catch(SQLException e) {
			System.out.println("Exception occurs while getting sql connection");
			e.printStackTrace();
	}
		return con;
	


}

	public static void closeResource(Connection con, Statement st) {
		try {
			if(con!=null)
			con.close();
			if(st!=null)
			st.close();
		} catch (SQLException e) {
			System.out.println("Exception occurs while closing the resources");
			e.printStackTrace();
		}
		
	}
}
