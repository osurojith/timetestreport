package com.Main;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.Database.DBFunctions;
import com.Excel.WriteData;


public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		DBFunctions dbf=new DBFunctions();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String datenow=dateFormat.format(date)+" "+"00:00:00";
	String [] databases=new String[]{"World_Plan_Pg_Load_Time","Malaysia_Plan_Pg_Load_Time","Philippines_Plan_Pg_Load_Time","Sri_Lanka_Plan_Pg_Load_Time","Turkey_Plan_Pg_Load_Time","India_Plan_Pg_Load_Time","Rwanda_Plan_Pg_Load_Time","Singapore_Plan_Pg_Load_Time","QN_Europe_Plan_Pg_Load_Time","My_Network_Plan_Pg_Load_Time"};
	
		
    String [][] data=new String[6][100];
    //9,8
    for(int x=0;x<=0;x++){
    	for(int y=0;y<=0;y++){
    		 data[x][0]=Integer.toString(y+7);
    		 data[x][1]=databases[x];
 			 data[x][2]=Double.toString(dbf.getPgLoadTime(databases[x], datenow ,"loginpage",Integer.toString(y+7)));
   			 data[x][3]=Double.toString(dbf.getPgLoadTime(databases[x], datenow ,"dashboardpage",Integer.toString(y+7)));
   			 data[x][4]=Double.toString(dbf.getPgLoadTime(databases[x], datenow ,"productpage",Integer.toString(y+7)));
   			 data[x][5]=Double.toString(dbf.getPgLoadTime(databases[x], datenow ,"homepage",Integer.toString(y+7)));
    	}
    }
   
	WriteData wd=new WriteData();
wd.writeToExcel(data);
	}

}
