package com.java.locale;

import java.util.ResourceBundle;

public class ResourceBundleDemo {

	public static void main(String[] args) {
    ResourceBundle bundle = ResourceBundle.getBundle("message");
    System.out.println(bundle.getString("greetings"));
    ResourceBundle db = ResourceBundle.getBundle("mysql");
    System.out.println(db.getString("mysql.driver.name"));
    System.out.println(db.getString("mysql.url"));
    System.out.println(db.getString("mysql.user"));
    System.out.println(db.getString("mysql.password"));
	}

}
