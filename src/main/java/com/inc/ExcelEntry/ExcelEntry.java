package com.inc.ExcelEntry;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelEntry {
	public static String enterNewBatchDetailsToExcel(ArrayList<String> batchDetails) {

		System.out.println("Inside EntryToExcel enterBatchDetails()");

		//Create workbook in .xlsx format
		 final File file = new File("C:\\Users\\mathi\\Desktop\\Incubator\\BatchesEntry.xlsx");
			final XSSFWorkbook workbook;
		try {
			
			if (file.exists() == false) {
			  System.out.println("Creating a new workbook '" + file + "'");
			  workbook = new XSSFWorkbook();
			} else {
			  System.out.println("Appending to existing workbook '" + file + "'");
			  final InputStream is = new FileInputStream(file);
			  try {
			    workbook = new XSSFWorkbook(is);
			  } finally {
			    is.close();
			  }
			}
			
			//Create sheet in .xlsx format
			 XSSFSheet sh = workbook.getSheet("IncubationBatches");
			    // Check if the workbook is empty or not
			    if (workbook.getNumberOfSheets() != 0) {
			        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			           if (workbook.getSheetName(i).equals("IncubationBatches")) {
			        	   System.out.println("Sheet Already Exists");
			        	   sh = workbook.getSheet("IncubationBatches");
			            } else sh = workbook.createSheet("IncubationBatches");
			        }
			    }
			    else {
			        // Create new sheet to the workbook if empty
			    	System.out.println("Creating new Sheet IncubationBatches");
			    	sh = workbook.createSheet("IncubationBatches");
			    }

				//We want to make it bold with a foreground color.
				XSSFFont headerFont = workbook.createFont();
				headerFont.setBold(true);
				headerFont.setFontHeightInPoints((short)12);
				headerFont.setColor(IndexedColors.BLACK.index);
				//Create a CellStyle with the font
				CellStyle headerStyle = workbook.createCellStyle();
				headerStyle.setFont(headerFont);
				headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
			
	        //Create top row with column headings
			String[] columnHeadings = {
					"Batch ID",
					"Batch Name",
					
					"Type of Eggs",
					"Type of Loader",
					"Selected Row",
					"No of Eggs",
					
					"Start Date",
					"Candling Date",
					"Change To Hatcher Date",
					"End Date",
					};
			
			//Create the header row
			Row headerRow = sh.createRow(0);
			
		    //Iterate over the column headings to create columns
			for(int i=0;i<columnHeadings.length;i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(columnHeadings[i]);
				cell.setCellStyle(headerStyle);
			}
			
			//Auto size columns
			for(int i=0;i<columnHeadings.length;i++) {
				sh.autoSizeColumn(i);
			}
			
			//Freeze Header Row
			sh.createFreezePane(0, 0);

		    int rownum =sh.getLastRowNum();
			System.out.println("last rownum="+rownum);
			
			Row row = sh.createRow(rownum+1);
			System.out.println("row created at "+row.getRowNum());
		    
			for(int i=0;i<batchDetails.size();i++) {
			row.createCell(i).setCellValue(batchDetails.get(i));
			}
			//rownum = sh.getLastRowNum()+1;

			//Write the output to file
			FileOutputStream fileOut = new FileOutputStream("C:\\\\Users\\\\mathi\\\\Desktop\\\\Incubator\\\\BatchesEntry.xlsx");
			workbook.write(fileOut);
			fileOut.close();
			workbook.close();

			System.out.println("EntryToExcel Completed");
			 System.out.println();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
