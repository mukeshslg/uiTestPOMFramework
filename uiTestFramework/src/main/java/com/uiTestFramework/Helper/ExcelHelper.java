package com.uiTestFramework.Helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	private static Logger log = LoggerHelper.getLogger(ExcelHelper.class);
	public Object[][] getExcelData(String ExcelLocation,String sheetName) {
		try {
			Object testdata[][]=null;
			FileInputStream file=new FileInputStream(new File(ExcelLocation));
			XSSFWorkbook workbook=new XSSFWorkbook(file);
			XSSFSheet sheet= workbook.getSheet(sheetName);
			XSSFRow rows;
			XSSFCell cells;
			int totalRow=sheet.getLastRowNum();
			int totalCell=sheet.getRow(0).getLastCellNum();
			testdata=new Object[totalRow+1][totalCell];
			Iterator<Row> rowIterator=sheet.iterator();
			int irow=0;
			while (rowIterator.hasNext()) {
				irow++;
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator=row.cellIterator();
				int icell=0;
				while (cellIterator.hasNext()) {
					icell++;
					Cell cell = cellIterator.next();
					switch (cell.getCellTypeEnum()) {
					case STRING:
						testdata[irow-1][icell-1]=cell.getStringCellValue();
						System.out.println(cell.getDateCellValue());
						break;
					case NUMERIC:
						testdata[irow-1][icell-1]=cell.getNumericCellValue();
						break;	
					case BOOLEAN:
						testdata[irow-1][icell-1]=cell.getBooleanCellValue();
						break;	
					case FORMULA:
						testdata[irow-1][icell-1]=cell.getCellFormula();
						break;		
					default:log.info("NO MATCH  ENUM TYPE FOUND");
						break;
					}
				}
			}
			return testdata;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		ExcelHelper eh=new ExcelHelper();
		System.out.println(System.getProperty("user.dir")+"\\resources\\TestData.xlsx");
		Object[][] obdata=eh.getExcelData(System.getProperty("user.dir")+"\\resources\\TestData.xlsx", "TestData");
		
	}

}
