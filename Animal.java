package com.jdbcpreparedstatex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Animal {

	public void insertData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc204","root","root");
		PreparedStatement ps = c.prepareStatement("insert into animal(id, name, colour) values(?,?,?)");
		ps.setInt(1, 5);
		ps.setString(2, "lion");
		ps.setString(3, "yellow");
		ps.executeUpdate();
		System.out.println("Data is inserted...");
		c.close();
		
	}

	public void updateData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc204", "root", "root");
		PreparedStatement ps = c.prepareStatement("Update animal set colour = ? where id = ?");
		ps.setInt(2, 3);
		ps.setString(1, "black");
		ps.executeUpdate();
		System.out.println("Data is updated...");
		c.close();
		
	}

	public void deleteData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc204","root","root");
		PreparedStatement ps = c.prepareStatement("delete from animal where id = ?");
		ps.setInt(1, 2);
		ps.executeUpdate();
		System.out.println("Data is deleted....");
		c.close();
	}

	public void getAllData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc204","root","root");
		PreparedStatement ps = c.prepareStatement("select * from animal");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3));
		}
		c.close();
	}

}
