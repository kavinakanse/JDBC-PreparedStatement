package com.jdbcpreparedstatex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Phone {
	public void insertData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc204","root","root");
		PreparedStatement ps = c.prepareStatement("insert into phone(phn_id, model_name, price, colour) values(?,?,?,?)");
		ps.setInt(1, 5);
		ps.setString(2, "iphone");
		ps.setInt(3, 100000);
		ps.setString(4, "white");
		ps.executeUpdate();
		System.out.println("data is inserted...");
		c.close();
	}
	
	public void updateData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc204","root","root");
		PreparedStatement ps = c.prepareStatement("update phone set model_name = ? where phn_id= ?");
		ps.setInt(2, 5);
		ps.setString(1, "Iphone 15");
		ps.executeUpdate();
		System.out.println("data is updated");
		c.close();
	}
	
	public void deleteData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc204","root","root");
		PreparedStatement ps = c.prepareStatement("delete from phone where phn_id =?");
		ps.setInt(1, 4);
		ps.executeUpdate();
		System.out.println("Data is deleted...");
		c.close();
	}
	
	public void getAllData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc204","root","root");
		PreparedStatement ps = c.prepareStatement("select * from phone");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getInt(3)+" | "+rs.getString(4));
		}
		c.close();
	}
}
