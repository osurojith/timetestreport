package com.Database;




import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBFunctions {
	public double getPgLoadTime(String tableName,String date,String pgName,String time) throws ClassNotFoundException, SQLException {
		 Statement stmt = null;
		 Connection conn=DBConnection.conn();
		double loadtime=0;
		stmt =  conn.createStatement();
	      String sql;
	      sql = "SELECT * FROM `"+tableName+"` WHERE daystamp='"+date+"' and timestamp='"+time+"'";
	      System.out.println(sql);
	      ResultSet rs = stmt.executeQuery(sql);

	      
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         double pageTime  = rs.getDouble(pgName);
	         loadtime=loadtime+pageTime;
	         //Display values
	         System.out.println("pageLoadTime: " + pageTime);
	       
	      }
	     
	      //STEP 6: Clean-up environment
	      rs.close();	      
	      conn.close();
	      loadtime=loadtime/3;
	      double val=Math.round(loadtime*100);
	      return val/100;
	}

	
}
