package com.jdbcpreparedstatex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bike {

	public void insertData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc204","root","root");
		PreparedStatement ps = c.prepareStatement("insert into bike(b_id, name, cost, colour) values(?,?,?,?)");
		ps.setInt(1, 5);
		ps.setString(2, "honda");
		ps.setInt(3, 100000);
		ps.setString(4, "black");
		ps.executeUpdate();
		System.out.println("Data is inserted...");
		c.close();
	}

	public void updateData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc204","root","root");
		PreparedStatement ps = c.prepareStatement("update bike set colour = ? where b_id=?");
		ps.setInt(2, 3);
		ps.setString(1, "white");
		ps.executeUpdate();
		System.out.println("data is updated...");
		c.close();
		
	}

	public void deleteData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc204","root","root");
		PreparedStatement ps = c.prepareStatement("delete from bike where b_id = ?");
		ps.setInt(1,4);
		ps.executeUpdate();
		System.out.println("data is deleted...");
		c.close();
		
	}

	public void getAllData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc204", "root","root");
		PreparedStatement ps = c.prepareStatement("select * from bike");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+ rs.getInt(3)+" | "+rs.getString(4));
		}
		c.close();
	} 
}
