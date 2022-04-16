package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRecord {

	public static void main(String[] args) {
		
		String sql="delete from student where sid=105";
		
		Connection con=null;
		Statement st=null;
		try {
			 con=JDBCUtil.getMySQLConnection();
			 st=con.createStatement();
	        int x1 = st.executeUpdate(sql);
		if(x1==1)
			System.out.println("Record deleted successfully");
		else
			System.out.println("Record not deleted");
		
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
		