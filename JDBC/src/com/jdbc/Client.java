package com.jdbc;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("please enter id");
		int id = sc.nextInt();
		System.out.println("enter name");
		String name = sc.next();
		System.out.println("enter dob");
		String dob = sc.next();
		System.out.println("enter city");
		String city = sc.next();
		System.out.println("enter gender");
		String gender = sc.next();
		System.out.println("enter phno");
		long phno = sc.nextLong();
		Student stu=new Student();
		stu.setId(id);
		stu.setName(name);
		stu.setDob(dob);
		stu.setCity(city);
		stu.setGender(gender);
		stu.setPhno(phno);
		CURDOperation co=new CURDOperation();
		co.insertStudent(stu);
		co.updateStudent(stu);
		co.deleteStudentById(id);
		sc.close();
	}

}
