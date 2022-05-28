package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] getExcelData (String fileName) throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+fileName+".xlsx");
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		int rowcount = ws.getLastRowNum();
		int lastCellNum = ws.getRow(0).getLastCellNum();
		System.out	.println(rowcount);
		System.out.println(lastCellNum);
		
		String [][] data = new String[rowcount][lastCellNum];
		
		for (int i = 1; i <=rowcount; i++) {
			for (int j = 0; j < lastCellNum; j++) {
				String cellValue = ws.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j]= cellValue;
				System.out.println(cellValue);
			}		
		}
		
		/*
		 * XSSFRow row = ws.getRow(1);
		 * XSSFCell cell = row.getCell(0); 
		 * String cellValue= cell.getStringCellValue(); 
		 * System.out.println(cellValue);
		 * getLastRowNum
		 * getPhysicalNumberOfRows
		 */
		
		wb.close();
		return data;
		
	}

}

