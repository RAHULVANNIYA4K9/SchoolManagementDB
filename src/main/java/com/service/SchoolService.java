package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SchoolService {
	
	 static String url="jdbc:postgresql://localhost:5432/school";
	 static String user="postgres";
	 static String pwd="123";
	 static Connection con;
	 static Scanner sc=new Scanner(System.in);
	static {
		
		try {
			Class.forName("org.postgresql.Driver");
			 con=DriverManager.getConnection(url,user,pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int save() {
		
		System.out.println("Enter the Id");
		int Id=sc.nextInt();
		System.out.println("Enter the name");
		String name=sc.next();
		System.out.println("Enter the Age");
		int age=sc.nextInt();
		System.out.println("Enter the Email");
		String email=sc.next();
		System.out.println("Enter the Course");
		String course=sc.next();
		
		int no=0;
		String sql="Insert into student values(?,?,?,?,?)";
		try {
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setInt(1, Id );
			pstm.setString(2, name);
			pstm.setInt(3, age);
			pstm.setString(4, email);
			pstm.setString(5, course);
			
			no=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return no;	
	}
	
	public int Update() {
		System.out.println("Enter the name");
		String name=sc.next();
		System.out.println("Enter the Age");
		int age=sc.nextInt();
		
		
		int n=0;
		String sql="UPDATE student set age=? where name=?";
		try {
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setString(2, name);
			pstm.setInt(1, age);
			n=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;		
	}
	
	public int delete() {
		String sql="DELETE  from student where name=? ";
		int no=0;
		
		System.out.println("Enter the name");
		String name=sc.next();
		try {
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setString(1, name);
			no=pstm.executeUpdate();
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		return no;
	}
	public boolean fetch() {
		String sql="SELECT * from student";
		try {
			Statement stm=con.createStatement();
			
				ResultSet rs=stm.executeQuery(sql);
				while(rs.next()) {
					int Id=rs.getInt(1);
					String name=rs.getString(2);
					int age=rs.getInt(3);
					String email=rs.getString(4);
					String course=rs.getString(5);
					
					System.out.println(Id +" "+name+" "+age+" "+email+" "+course);
					System.out.println("============================================");
				}
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
}
