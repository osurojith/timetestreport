package com.Excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Database.DBFunctions;
import com.itextpdf.text.DocumentException;

public class WriteData {
 public void writeToExcel(String [][][] data,String databases[]) throws Exception{
	
	int count=1;
	int rowcount=1;
	DBFunctions dbf=new DBFunctions();
	//Create blank workbook
     XSSFWorkbook workbook = new XSSFWorkbook(); 
     //Create a blank sheet
     XSSFSheet spreadsheet = workbook.createSheet( 
     " Employee Info ");
     //Create row object
     XSSFRow row;
     //This data needs to be written (Object[])
     Map < String, Object[] > empinfo = 
     new TreeMap < String, Object[] >();
     empinfo.put( "1", new Object[] {"Time", "Plan","Home Page", "Login Page", "Dashbord", "Product Page" });
     //8,9
 
     for(int y=0;y<rowcount;y++) {
    	 count++;
    	rowcount=dbf.getCount(databases[y])/3;
    	 for(int x=0;x<10;x++){
    				
    	    empinfo.put(Integer.toString(count) , new Object[] {data[x][y][0], data[x][y][1],data[x][y][2], data[x][y][3], data[x][y][4],data[x][y][5]  });
    	    count++;
    	    /* System.out.println( data[x][y][0]);
  			 System.out.println( data[x][y][1]);
  			 System.out.println( data[x][y][2]);
  			 System.out.println( data[x][y][3]);
  			 System.out.println( data[x][y][4]);
  			 System.out.println( data[x][y][5]);
  			 */
    	 }
    	
    	 empinfo.put(Integer.toString(count) , new Object[] {"", "","", "", "","" });
    	
     }
     int rowid = 0;
     for(int i=1;i<23;i++){
    	 Object [] objectArr = empinfo.get(Integer.toString(i));
    	 
    	 row = spreadsheet.createRow(rowid++);
    	 int cellid = 0;
    	 for (Object obj : objectArr)
         {
    		 Cell cell = row.createCell(cellid++);
             cell.setCellValue((String)obj);
    		 	System.out.println(obj);
         }
     }
     for (int i=0; i<10; i++){
    	 spreadsheet.autoSizeColumn(i);
    	}
     FileOutputStream out = new FileOutputStream( 
     new File("timereport.xlsx"));
     workbook.write(out);
     out.close();
    
     System.out.println( 
     "Writesheet.xlsx written successfully" );
     Excel2PDF.converttopdf();
 }

}
