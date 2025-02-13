package com.jdbcpreparedstatex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Students {
	public void insertData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc204", "root", "root");
		PreparedStatement ps = c.prepareStatement("insert into students(id, name, std, marks) values(?,?,?,?)");
		ps.setInt(1, 105);
		ps.setString(2, "sai");
		ps.setInt(3, 11);
		ps.setInt(4, 90);
		ps.executeUpdate();
		System.out.println("Data is inserted..");
		c.close();
	}
	
	public void updateData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc204","root","root");
		PreparedStatement ps = c.prepareStatement("update students set marks = ?, name = ? where id = ?");
		ps.setInt(3, 102);
		ps.setInt(1, 87);
		ps.setString(2, "sangram");
		ps.executeUpdate();
		System.out.println("Data is updated...");
		c.close();
	}
	
	public void deleteData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc204","root","root");
		PreparedStatement ps = c.prepareStatement("delete from students where id = ?");
		ps.setInt(1, 103);
		ps.executeUpdate();
		System.out.println("data is deleted...");
		c.close();
	}
	
	public void getAllData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc204","root","root");
		PreparedStatement ps = c.prepareStatement("select * from students");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getInt(3)+" | "+rs.getInt(4));
		}
		c.close();
	}
	
}
