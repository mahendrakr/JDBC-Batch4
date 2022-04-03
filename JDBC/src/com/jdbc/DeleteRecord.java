package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRecord {

	public static void main(String[] args) {
		Connection connection =null;
		Statement createStatement=null;
		try {
//Step1: Load the driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
//Step2:Establish the connection
		final String url="jdbc:mysql://localhost:3306/mydb";
		 connection = DriverManager.getConnection(url,"root","myhandsomepapa@0930");
//Step3:Prepare the sql statement
		String sql="delete from college where id=105";
//Step4:Create JDBC statement
		 createStatement = connection.createStatement();
//Step5:Submit the sql statement to Database using jdbc statement		
		int x1 = createStatement.executeUpdate(sql);
//Step6:Process the result
		if(x1==1)
			System.out.println("Record deleted successfully");
		else
			System.out.println("Record not deleted");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Exception occurs while loading the driver");
			e.printStackTrace();
		}
		catch(SQLException e) {
			System.out.println("Exception occures while creating sql statement");
			e.printStackTrace();
		}
		finally {
//Step7:Close all the resources
		
		try {
			if(connection!=null)
			connection.close();
			if(createStatement!=null)
			createStatement.close();
		} catch (SQLException e) {
			System.out.println("Exception occurs while closing the resources");
			e.printStackTrace();
		}
		}
		
		

	}

}
