package java.mysql.info;

import java.util.ResourceBundle;

public class MySQLInfo {
	public static String getMysqlDetail(String key) {
		ResourceBundle db = ResourceBundle.getBundle("mysql");
		return db.getString(key);
		
	}

}
