package com.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectRecord {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try{
			con = JDBCUtil.getMySQLConnection();
			String sql="select * from student";
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt(1) + "," + rs.getString(2) +"," + rs.getString(3) +","+ rs.getString(4)+ "," + rs.getString(5)+ "," + rs.getInt(6));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			JDBCUtil.closeResource(con, st);
		}
	}
}
