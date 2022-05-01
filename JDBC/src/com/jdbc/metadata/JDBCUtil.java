package com.jdbc.metadata;

import java.mysql.info.MySQLInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	public static void main(String[] args) {
		try {
			Class.forName(MySQLInfo.getMysqlDetail("mysql.driver.name"));
		} catch (ClassNotFoundException e) {
			System.out.println("Exception occured while loading the class");
			e.printStackTrace();
		}

	}

	public static Connection getMySQLConnection() {
		Connection con=null;
		String url=MySQLInfo.getMysqlDetail("mysql.url");
		String userName=MySQLInfo.getMysqlDetail("mysql.user");
		String pswd=MySQLInfo.getMysqlDetail("mysql.password");
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
