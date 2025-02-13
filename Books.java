package com.jdbcpreparedstatex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Books {

	public void insertData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc204", "root", "root");
		PreparedStatement ps = c.prepareStatement("insert into books(id, name, cost) values(?,?,?)");
		ps.setInt(1, 5);
		ps.setString(2, "harry potter ");
		ps.setInt(3, 3000);
		ps.executeUpdate();
		System.out.println("Data is inserted...");
		c.close();
	}

	public void updateData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc204", "root","root");
		PreparedStatement ps = c.prepareStatement("update books set cost=? where id = ?");
		ps.setInt(2, 2);
		ps.setInt(1, 2156);
		ps.executeUpdate();
		System.out.println("Data is updated...");
		c.close();
		
	}

	public void deleteData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc204","root","root");
		PreparedStatement ps = c.prepareStatement("delete from books where id = ?");
		ps.setInt(1, 3);
		ps.executeUpdate();
		System.out.println("data is deleted...");
		c.close();
		
	}

	public void getAllData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc204", "root", "root");
		PreparedStatement ps = c.prepareStatement("select * from books");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getInt(3));
		}
		c.close();
		
	}
	
}
