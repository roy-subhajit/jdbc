package com.training.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		try {
			//connectAndInsertDataInDB();
			//connectAndQueryOracleDB();
			connectAndQueryUsingPreparedStatement();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void connectAndInsertDataInDB() throws SQLException, ClassNotFoundException {
		Connection connection = null;
        try {
        	// Step 2: Loading and registering drivers
            // Optional from JDBC version 4.0
			Class.forName("oracle.jdbc.OracleDriver");
			
			// Step 3: Establishing a connection
			//"jdbc:oracle:thin:@host:port:sid"
			//"jdbc:oracle:thin:@host:port/service"
	        connection = DriverManager.getConnection(
	            "jdbc:oracle:thin:@localhost:1521/XEPDB1",
	            "jpa_crud", "jpa_crud");
	        
	        // Step 4: Creating statement
	        Statement statement = connection.createStatement();
	 
	        // Step 5: Executing the query and storing the result
	        String sql = "insert into student(first_name, last_name, email) values ('Harry', 'Osborne', 'roy@email.com')";
	        int rowCount = statement.executeUpdate(sql);
	 
	        // Step 6: Processing the results
	        System.out.println("Affected row count >>> " + rowCount);
	        
		} finally {
			// Step 7: Closing the connection
			if(connection != null) {
				connection.close();
			}
		}     
	}
	
	public static void connectAndQueryOracleDB() throws SQLException, ClassNotFoundException {
		Connection connection = null;
        try {
        	// Step 2: Loading and registering drivers
            // Optional from JDBC version 4.0
			Class.forName("oracle.jdbc.OracleDriver");
			
			// Step 3: Establishing a connection
	        connection = DriverManager.getConnection(
	            "jdbc:oracle:thin:@localhost:1521/XEPDB1",
	            "jpa_crud", "jpa_crud");
	        
	        // Step 4: Creating statement
	        Statement statement = connection.createStatement();
	 
	        // Step 5: Executing the query and storing the result
	        ResultSet rs = statement.executeQuery("select * from student");
	 
	        // Step 6: Processing the results
	        while (rs.next()) {
	        	System.out.print(rs.getInt("id")+ " ");
	            System.out.print(rs.getString("first_name")+ " ");
	            System.out.print(rs.getString("last_name")+ " ");
	            System.out.print(rs.getString("last_name")+ " ");
	            
	            System.out.println();
	        }
	        
		} finally {
			// Step 7: Closing the connection
			if(connection != null) {
				connection.close();
			}
		}     
	}
	
	public static void connectAndQueryUsingPreparedStatement() throws SQLException, ClassNotFoundException {
		Connection connection = null;
        try {
        	// Step 2: Loading and registering drivers
            // Optional from JDBC version 4.0
			Class.forName("oracle.jdbc.OracleDriver");
			
			// Step 3: Establishing a connection
	        connection = DriverManager.getConnection(
	            "jdbc:oracle:thin:@localhost:1521/XEPDB1",
	            "jpa_crud", "jpa_crud");
	        
	        // Step 4: Creating prepared statement
	        PreparedStatement preparedStatement = connection.prepareStatement("select * from student where id = ?");
	        preparedStatement.setInt(1, 1);
	 
	        // Step 5: Executing the query and storing the result
	        ResultSet rs = preparedStatement.executeQuery();
	 
	        // Step 6: Processing the results
	        while (rs.next()) {
	        	System.out.print(rs.getInt("id")+ " ");
	            System.out.print(rs.getString("first_name")+ " ");
	            System.out.print(rs.getString("last_name")+ " ");
	            System.out.print(rs.getString("last_name")+ " ");
	            
	            System.out.println();
	        }
	        
		} finally {
			// Step 7: Closing the connection
			if(connection != null) {
				connection.close();
			}
		}     
	}
}
