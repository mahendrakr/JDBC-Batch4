package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetDemo {
	public static void main(String[] args) {
		Connection con=null;
		String sql="select * from student";
		String sql1="select sid,sname,dob,city,gender,phone_no from student";
		PreparedStatement ps=null;
		try {
			con = JDBCUtil.getMySQLConnection();
			ps = con.prepareStatement(sql1, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs = ps.executeQuery();
			rs.first();
			System.out.println("1st row"+ " " + rs.getInt(1) + "," + rs.getString(2) +"," + rs.getString(3) +","+ rs.getString(4)+ "," + rs.getString(5)+ "," + rs.getInt(6));
			rs.last();
			System.out.println("last row"+ " " + rs.getInt(1) + "," + rs.getString(2) +"," + rs.getString(3) +","+ rs.getString(4)+ "," + rs.getString(5)+ "," + rs.getInt(6));
			// move the cursor to the point before first row :
			rs.beforeFirst();
			rs.next();
			System.out.println("next row"+ " " + rs.getInt(1) + "," + rs.getString(2) +"," + rs.getString(3) +","+ rs.getString(4)+ "," + rs.getString(5)+ "," + rs.getInt(6));
//			move the cursor to point third row :
			rs.absolute(3);
			System.out.println("3rd row"+ " " + rs.getInt(1) + "," + rs.getString(2) +"," + rs.getString(3) +","+ rs.getString(4)+ "," + rs.getString(5)+ "," + rs.getInt(6));
//			moving the cursor to point previous row of 3rd row :
			rs.relative(-1);
			System.out.println("last row"+ " " + rs.getInt(1) + "," + rs.getString(2) +"," + rs.getString(3) +","+ rs.getString(4)+ "," + rs.getString(5)+ "," + rs.getInt(6));
			rs.relative(2);
			System.out.println("last row"+ " " + rs.getInt(1) + "," + rs.getString(2) +"," + rs.getString(3) +","+ rs.getString(4)+ "," + rs.getString(5)+ "," + rs.getInt(6));
//			moving the cursor to point to insert a row to table :
//			rs.last();
//			rs.moveToInsertRow();
//			rs.updateInt(1, 106);
//			rs.updateString(2, "xyz");
//			rs.updateString(3, "01-01-1990");
//			rs.updateString(4, "stm");
//			rs.updateString(5, "male");
//			rs.updateInt(6, 106025);
//			rs.insertRow();
//			move the cursor to point fourth row :
			rs.absolute(4);
			System.out.println("4th row"+ " " + rs.getInt(1) + "," + rs.getString(2) +"," + rs.getString(3) +","+ rs.getString(4)+ "," + rs.getString(5)+ "," + rs.getInt(6));
			rs.updateInt(1, 999);
			rs.updateRow();
			System.out.println("updated 4th row"+ " " + rs.getInt(1) + "," + rs.getString(2) +"," + rs.getString(3) +","+ rs.getString(4)+ "," + rs.getString(5)+ "," + rs.getInt(6));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			JDBCUtil.closeResource(con, ps);
		}
	}
}
