package com.jdbc.metadata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import com.jdbc.JDBCUtil;

public class ResultSetInfo {

	public static void main(String[] args) throws SQLException {
		Connection con = JDBCUtil.getMySQLConnection();
		Statement st = con.createStatement();
		String sql="select * from student";
		ResultSet rs = st.executeQuery(sql);
		ResultSetMetaData md = rs.getMetaData();
		System.out.println("Column count " + md.getColumnCount());
		System.out.println("Column details");
		for(int i=1;i<md.getColumnCount();i++) {
			
			String cName = md.getColumnName(i);
			String cType = md.getColumnTypeName(i);
			System.out.println(cName + "- " +cType );
			
			
		}
		System.out.println("*******************");
		System.out.println(md.getTableName(1));
		System.out.println("****RowSET****");
		JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
		rowSet.setUrl("jdbc:mysql://localhost:3306/mydb");
		rowSet.setUsername("root");
		rowSet.setPassword("myhandsomepapa@0930");
		rowSet.setCommand("select * from student");
		rowSet.execute();
		while(rowSet.next()) {
			System.out.println(rowSet.getInt(1) + " "+ rowSet.getString(2) + " "+ rowSet.getDate(3)+" "+rowSet.getString(4));
		}
		
		
    
	}

}
