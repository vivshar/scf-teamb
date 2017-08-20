package com.vivshar.DAO;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DAOImpl {

	public Connection create_connection() {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		Connection connection = null;
		ResultSet rs= null;

		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/project", "postgres",
					"yashu");
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		/*
		try {
			String url = "jdbc:postgresql://ec2-50-17-217-166.compute-1.amazonaws.com:5432/ddq7urlrfunt2g?user=vkpofcuxsisuio&password=02a43c5a4c1e333a2f24847cb75629d6ce8a0e05276a6ae98c246bd0af103009&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
	        Properties props = new Properties();
	        props.setProperty("user", "vkpofcuxsisuio");
	        props.setProperty("password", "02a43c5a4c1e333a2f24847cb75629d6ce8a0e05276a6ae98c246bd0af103009");
	        props.setProperty("ssl", "true");
	        connection = DriverManager.getConnection(url, props);
	        
	        if (connection != null) {
				Statement s = connection.createStatement();
				rs = s.executeQuery("select * from emp");
				rs.next();
				rs.next();
				return rs.getInt(1); 	
			}                
	    } catch (SQLException e) {
	        System.out.println("Connection Failed! Check output console");
	        e.printStackTrace();
	        return -2;
	    }		
		finally {
			try {
				connection.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/	
	}
	
	public void create_proposal(int buyer_id, String description, String buyer_status, int d_terms_id, int p_terms_id) {
		
		System.out.println("create proposal called");
		
		PreparedStatement statement = null;
		Connection connection = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/teamb?currentSchema=public", "postgres",
					"teamb");
			
			String sql = "INSERT into \"Proposals\" (";
			sql += "buyer_id, description, buyer_status, d_terms_id, p_terms_id";
			sql += ") VALUES (";
			sql += "?, ?, ?, ?, ?";
			sql += ")";
			
			statement = connection.prepareStatement(sql);
			statement.setInt(1, buyer_id);
			statement.setString(2, description);
			statement.setString(3, buyer_status);
			statement.setInt(4, d_terms_id);
			statement.setInt(5, p_terms_id);
			int a = statement.executeUpdate();
			System.out.println("a=" + a);
			
		} catch (SQLException e) {
			// handle errors for JDBC
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// handle errors for Class.forName
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
	}
	
	public void enter_proposal_product(int proposal_id, int product_id, int quantity) {
		
		PreparedStatement statement = null;
		Connection connection = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/teamb", "postgres",
					"teamb");
			
			String sql = "INSERT into \"Products\" (";
			sql += "product_id, proposal_id, quantity";
			sql += ") VALUES (";
			sql += "?, ?, ?";
			sql += ")";
			
			statement = connection.prepareStatement(sql);
			statement.setInt(1, product_id);
			statement.setInt(2, proposal_id);
			statement.setInt(3, quantity);		
			statement.executeUpdate();
		} catch (SQLException e) {
			// handle errors for JDBC
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// handle errors for Class.forName
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
	}
	
}
