package com.jdbc.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import com.jdbc.JDBCUtil;

public class DatabaseInfo {

	public static void main(String[] args) throws SQLException {
    Connection connection = JDBCUtil.getMySQLConnection();
    DatabaseMetaData md = connection.getMetaData();
    System.out.println("Url "+md.getURL());
    System.out.println(md.getDriverName());
    System.out.println(md.getDriverVersion());
    
    
	}

}
