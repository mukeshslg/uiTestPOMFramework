package com.uiTestFramework.Helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
	XSSFWorkbook workbook;
	public  XSSFSheet getSheet(String ExcelLocation,String sheetName) throws IOException {
		    FileInputStream file = new FileInputStream(new File(ExcelLocation));
		    workbook=new XSSFWorkbook(file);
			XSSFSheet sheet= workbook.getSheet(sheetName);
			return sheet;
	}
	public Object[][] getExcelData(String ExcelLocation,String sheetName) {
		try {
			Object testdata[][]=null;
			XSSFSheet sheet=getSheet(ExcelLocation,sheetName);
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
						//System.out.println(cell.getDateCellValue());
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
	/**
	 * update excel with test case status require: testId
	 * @param excelPath
	 * @param sheetName
	 * @param testId
	 * @param testCaseStatus
	 * @throws IOException
	 */
	public void updateResult(String excelPath,String sheetName,int testId,String testCaseStatus) throws IOException {
		XSSFSheet sheet=getSheet(excelPath,sheetName);
		int totalRow=sheet.getLastRowNum()+1;
		for (int i = 1; i < totalRow; i++) {
			XSSFRow row= sheet.getRow(i);
			XSSFCell cell=row.getCell(0);
			int c=(int) cell.getNumericCellValue();
			if (c==testId) {
				row.createCell(3).setCellValue(testCaseStatus);
				FileOutputStream fout=new FileOutputStream(new File(excelPath));
				workbook.write(fout);
				fout.close();
				break;
			}
			
			
		}
	}
	
	
	public static void main(String[] args) {
		ExcelHelper eh=new ExcelHelper();
		String xlpath=System.getProperty("user.dir")+"\\resources\\TestData.xlsx";
		System.out.println(System.getProperty("user.dir")+"\\resources\\TestData.xlsx");
		Object[][] obdata=eh.getExcelData(System.getProperty("user.dir")+"\\resources\\TestData.xlsx", "TestData");
		int k=3;
		for (int i = 0; i < obdata.length; i++) {//row length
			for (int j = 0; j < obdata[i].length; j++) {//column length
				System.out.print(obdata[i][j]+" ");
				if(j==k) {
					System.out.println("");
					//k=k+3;
				}
					
			}
			
		}
		try {
			eh.updateResult(xlpath, "TestData", 555, "PASSED");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
