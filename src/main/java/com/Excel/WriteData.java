package com.Excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {
 public void writeToExcel(String [][] data) throws IOException{
	
	int count=2;
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
     for(int x=0;x<=0;x++) {
    	 for(int y=0;y<=0;y++){  		
    	    empinfo.put(Integer.toString(count) , new Object[] {data[x][0], data[x][1],data[x][2], data[x][3], data[x][4],data[x][5]  });
    	    count++;
    	 }
     }
    
     //Iterate over data and write to sheet
     Set < String > keyid = empinfo.keySet();
     int rowid = 0;
     for (String key : keyid)
     {
        row = spreadsheet.createRow(rowid++);
        Object [] objectArr = empinfo.get(key);
        int cellid = 0;
        for (Object obj : objectArr)
        {
         Cell cell = row.createCell(cellid++);
           cell.setCellValue((String)obj);
        }
     }
     //Write the workbook in file system
     FileOutputStream out = new FileOutputStream( 
     new File("timereport.xlsx"));
     workbook.write(out);
     out.close();
     System.out.println( 
     "Writesheet.xlsx written successfully" );
 }

}
