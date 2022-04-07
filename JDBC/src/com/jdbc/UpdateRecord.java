package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateRecord {

	public static void main(String[] args) {
		
		String sql="update college set id=999 where id=103";
		Connection con=null;
		Statement st=null;
		try {
			 con=JDBCUtil.getMySQLConnection();
			 st=con.createStatement();
	        int x1 = st.executeUpdate(sql);
		if(x1==1)
			System.out.println("Record upddated successfully");
		else
			System.out.println("Record not updated");
		
		}
		catch(SQLException e) {
			System.out.println("Exception occures while creating sql statement");
			e.printStackTrace();
		}
		finally {
		JDBCUtil.closeResource(con, st);
		}
	}
	}
		