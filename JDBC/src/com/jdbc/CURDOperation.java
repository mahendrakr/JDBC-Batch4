package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CURDOperation {
	public void insertStudent(Student stu) {
		
		Connection con=null;
		PreparedStatement ps=null;
		try {
			 con=JDBCUtil.getMySQLConnection();
			 String sql="insert into student values(?,?,?,?,?,?)";
			 ps=con.prepareStatement(sql);
			 ps.setInt(1, stu.getId());
			 ps.setString(2, stu.getName());
			 ps.setString(3, stu.getDob());
			 ps.setString(4, stu.getCity());
			 ps.setString(5, stu.getGender());
			 ps.setLong(6, stu.getPhno());
	        int x1 = ps.executeUpdate();
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
		JDBCUtil.closeResource(con, ps);
		}
	}
	public void updateStudent(Student stu) {
		Connection con=null;
		Statement st=null;
		try{
			 con=JDBCUtil.getMySQLConnection();
			 String sql="update student set sid=103 where sid=101";
			 st=con.createStatement();
			 int x2 = st.executeUpdate(sql);
				if(x2==1)
					System.out.println("Record updated successfully");
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
	
	
	public void deleteStudentById(int id) {
		String sql="delete from student where sid=101";
		Connection con=null;
		Statement st=null;
		try {
			 con=JDBCUtil.getMySQLConnection();
			 st=con.createStatement();
	        int x3 = st.executeUpdate(sql);
		if(x3==1)
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
	public List<Student> fetchStudents() {
		return null;
	}
}
