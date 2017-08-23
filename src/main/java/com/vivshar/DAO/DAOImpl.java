package com.vivshar.DAO;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import com.vivshar.POJO.Table.FeaturesTable;
import com.vivshar.POJO.Table.ProductsTable;
import com.vivshar.POJO.Table.ProposalsTable;

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
	
	public Integer create_proposal(ProposalsTable pt) {
		
		System.out.println("create proposal called");
		Integer i;
		PreparedStatement statement = null;
		Connection connection = null;
		
		try {
			/*Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/cm?currentSchema=public", "postgres",
					"1");
			*/
			
			
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://ec2-107-20-226-93.compute-1.amazonaws.com:5432/d3gt88jfl1r6i7?user=lqmwbjsssdqgqd&password=b05b46f323cb29b4b459ae7d33febec7b16b6e303364a74623ca627c47213afd&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
	        Properties props = new Properties();
	        props.setProperty("user", "lqmwbjsssdqgqd");
	        props.setProperty("password", "b05b46f323cb29b4b459ae7d33febec7b16b6e303364a74623ca627c47213afd");
	        props.setProperty("ssl", "true");
	        connection = DriverManager.getConnection(url, props);
			
			
			
			String sql = "INSERT into \"Proposals\" (";
			sql += "buyer_id, description, buyer_status, d_terms_id, p_terms_id";
			sql += ") VALUES (";
			sql += "?, ?, ?, ?, ?";
			sql += ") RETURNING proposal_id";
			
			statement = connection.prepareStatement(sql);
			statement.setInt(1, pt.getBuyerId());
			statement.setString(2, pt.getDescription());
			statement.setString(3, Character.toString(pt.getBuyerStatus()));
			statement.setInt(4, pt.getdTermsId());
			statement.setInt(5, pt.getpTermsId());
			ResultSet rs = statement.executeQuery();
			rs.next();
			i = new Integer(rs.getInt(1)); 
			System.out.println("In proposal dao proposal id is ............................."+i);
			rs.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			i = new Integer(-1); 
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return i;
		
	}
	
	public Integer enter_proposal_product(ProductsTable pt) {
		
		PreparedStatement statement = null;
		Connection connection = null;
		Integer i;
		
		try {
			/*Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/cm?currentSchema=public", "postgres",
					"1");
			System.out.println("Inserting product");*/
			
			
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://ec2-107-20-226-93.compute-1.amazonaws.com:5432/d3gt88jfl1r6i7?user=lqmwbjsssdqgqd&password=b05b46f323cb29b4b459ae7d33febec7b16b6e303364a74623ca627c47213afd&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
	        Properties props = new Properties();
	        props.setProperty("user", "lqmwbjsssdqgqd");
	        props.setProperty("password", "b05b46f323cb29b4b459ae7d33febec7b16b6e303364a74623ca627c47213afd");
	        props.setProperty("ssl", "true");
	        connection = DriverManager.getConnection(url, props);
			
			
			String sql = "INSERT into \"Products\" (";
			sql += "product_id, proposal_id, quantity";
			sql += ") VALUES (";
			sql += "?, ?, ?";
			sql += ") RETURNING id";
			
			statement = connection.prepareStatement(sql);
			statement.setInt(1, pt.getProductId());
			statement.setInt(2, pt.getProposalId());
			statement.setInt(3, pt.getQuantity());		
			ResultSet rs = statement.executeQuery();
			rs.next();
			i = new Integer(rs.getInt(1)); 
			System.out.println("In product dao product id is ............................."+i);
			System.out.println("In product dao proposal id is ............................."+pt.getProposalId());
			
			rs.close();
		} catch (SQLException | ClassNotFoundException e) {
			i = new Integer(-1); 			
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		
		return i;
	}
	
public Integer enter_product_features(FeaturesTable ft) {
		
		PreparedStatement statement = null;
		Connection connection = null;
		Integer i;
		
		try {
			/*Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/cm?currentSchema=public", "postgres",
					"1");*/
			
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://ec2-107-20-226-93.compute-1.amazonaws.com:5432/d3gt88jfl1r6i7?user=lqmwbjsssdqgqd&password=b05b46f323cb29b4b459ae7d33febec7b16b6e303364a74623ca627c47213afd&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
	        Properties props = new Properties();
	        props.setProperty("user", "lqmwbjsssdqgqd");
	        props.setProperty("password", "b05b46f323cb29b4b459ae7d33febec7b16b6e303364a74623ca627c47213afd");
	        props.setProperty("ssl", "true");
	        connection = DriverManager.getConnection(url, props);
			
			String sql = "INSERT into \"Features\" (";
			sql += "product_id, specification, priority_order";
			sql += ") VALUES (";
			sql += "?, ?, ?";
			sql += ") RETURNING feature_id";
			
			statement = connection.prepareStatement(sql);
			statement.setInt(1, ft.getProductsId());
			statement.setString(2, ft.getSpecification());
			statement.setString(3, Character.toString(ft.getPriorityOrder()));		
			ResultSet rs = statement.executeQuery();
			rs.next();
			i = new Integer(rs.getInt(1));
			System.out.println("In features dao feature id is ............................."+i);
			System.out.println("In features dao product id is ............................."+ft.getProductsId());
			rs.close();
		} catch (SQLException | ClassNotFoundException e) {
			i = new Integer(-1); 			
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		
		return i;
	}

public List<ProposalsTable> view_proposals(int id) {
	// TODO Auto-generated method stub
	return null;
}
	
}
