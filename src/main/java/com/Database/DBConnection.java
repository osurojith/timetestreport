package com.Database;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection conn() throws ClassNotFoundException, SQLException{
		 // JDBC driver name and database URL
		    String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		    String DB_URL = "jdbc:mysql://localhost/performancedb";

		   //  Database credentials
		    String USER = "root";
		    String PASS = "";
		   
		  
		   Connection conn = null;
		  
		  
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      return conn;
	}
}
