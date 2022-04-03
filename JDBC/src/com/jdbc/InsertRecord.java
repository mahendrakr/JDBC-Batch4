package com.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecord {


	public static void main(String[] args) {
		
		String sql="insert into college values(105,'TIT','Jhansi')";
		Connection con=null;
		Statement st=null;
		try {
			 con=JDBCUtil.getMySQLConnection();
			 st=con.createStatement();
	        int x1 = st.executeUpdate(sql);
		if(x1==1)
			System.out.println("Record inserted successfully");
		else
			System.out.println("Record not inserted");
		
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
		
		
		

	

	


