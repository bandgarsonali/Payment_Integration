package com.payments.utils;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ExcelDataProvider {

	static XSSFRow row;
	static Cell cell;
	static XSSFSheet sheet;
	static String reqValue;
	static Object[][] excelData;

	static Map<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
	static Map<Integer, ArrayList<String>> mapper = new HashMap<Integer, ArrayList<String>>();
	static Logger libLog = Logger.getLogger("LibLog");
	static DataFormatter formator=new DataFormatter();

	public static Map<Integer, ArrayList<String>> getColumnValueByName(String filePath, 
			String SheetName, String ColumnName) throws IOException {
		XSSFWorkbook wBook = new XSSFWorkbook(new FileInputStream(filePath));
		libLog.info("File Path system get is " + filePath);
		sheet = wBook.getSheet(SheetName);
		libLog.info("System get Sheet Name as " + SheetName);
		Row row = sheet.getRow(0);
		int col_num = 0;

		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(ColumnName))
				col_num = i;
			libLog.info("Column value readed :" + ColumnName);
		}

		Iterator<Row> rowite = sheet.rowIterator();
		rowite.next();
		while (rowite.hasNext()) {
			row = rowite.next();
			reqValue = row.getCell(col_num).toString();
			if (!mapper.containsKey(col_num)) {
				mapper.put(col_num, new ArrayList<String>());
			}
			libLog.info("Data from Excel readed as " + reqValue);
			mapper.get(col_num).add(reqValue);
		}
		return mapper;
	}
	
	public static Object[][] getExcelData(String fileName, String sheetName) throws IOException {
		 Object[][] data = null;
	        try {
	 
	            FileInputStream fis = new FileInputStream(fileName);
	            try (XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
					XSSFSheet sheet = workbook.getSheet(sheetName);
					XSSFRow row = sheet.getRow(0);
					int noOfRows = sheet.getPhysicalNumberOfRows();
					int noOfCols = row.getLastCellNum();
					Cell cell;
					data = new String[noOfRows - 1][noOfCols];
 
					for (int i = 1; i < noOfRows; i++) {
					    for (int j = 0; j < noOfCols; j++) {
					        row = sheet.getRow(i);
					        cell = row.getCell(j);
					        data[i - 1][j] = formator.formatCellValue(cell);;
					    }
					}
				}
	        } catch (Exception e) {
	            System.out.println("The exception is: " + e.getMessage());
	        }
	        return data;
    }
	
	public static void captureScreenshot(WebDriver driver) {
		try {
			File  sourcefile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
			String timestamp = Long.toString(System.currentTimeMillis()); 
			FileUtils.copyFile(sourcefile, new File("./screenshots/screenshot" + timestamp + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
