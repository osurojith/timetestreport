package com.Excel;

import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;

public class Excel2PDF {  
        public static void converttopdf() throws Exception{
        	//Load the workbook

        	Workbook workbook = new Workbook("timereport.xlsx");


        	//Access the first worksheet

        	Worksheet worksheet = workbook.getWorksheets().get(0);


        	//AutoFit rows

        	worksheet.autoFitRows();


        	//Save the workbook into pdf

        	workbook.save("output.pdf");  
        }
}