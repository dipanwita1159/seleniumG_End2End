package com.mohs10.ActionDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	Workbook wb;

//constructor for reading excel path
	public ExcelUtils(String excelpath) throws Throwable {
		FileInputStream fi = new FileInputStream(excelpath);
		wb = WorkbookFactory.create(fi);
	}

//method for counting no of rows
	public int rowCount(String sheetName) {
		return wb.getSheet(sheetName).getLastRowNum();
	}

//method for reading cell data
	@SuppressWarnings("deprecation")
	public String getCellData(String sheetName, int row, int column) {
		String data = "";
		if (wb.getSheet(sheetName).getRow(row).getCell(column).getCellTypeEnum() == CellType.NUMERIC) {
			int celldata = (int) wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
			// convert integer into string type
			data = String.valueOf(celldata);
		} else 
		{
			data = wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		}
		return data;
	}

//method for setcelldata
	public void setCellData(String sheetName, int row, int column, String status, String writeexcel) throws Throwable {
		// get sheet from wb
		Sheet ws = wb.getSheet(sheetName);
		// getrow from sheet
		Row rowNum = ws.getRow(row);
		// create cell
		Cell cell = rowNum.createCell(column);
		// write status
		cell.setCellValue(status);
		if (status.equalsIgnoreCase("Pass")) {
			CellStyle style = wb.createCellStyle();
			Font font = wb.createFont();
			font.setColor(IndexedColors.GREEN.getIndex());
			font.setBold(true);
		//	font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			style.setFont(font);
			rowNum.getCell(column).setCellStyle(style);

		} else if (status.equalsIgnoreCase("Fail")) {
			CellStyle style = wb.createCellStyle();
			Font font = wb.createFont();
			font.setColor(IndexedColors.RED.getIndex());
			font.setBold(true);
			//font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			style.setFont(font);
			rowNum.getCell(column).setCellStyle(style);
		} else if (status.equalsIgnoreCase("Blocked")) {
			CellStyle style = wb.createCellStyle();
			Font font = wb.createFont();
			font.setColor(IndexedColors.BLUE.getIndex());
			font.setBold(true);
			//font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			style.setFont(font);
			rowNum.getCell(column).setCellStyle(style);
		}
		FileOutputStream fo = new FileOutputStream(writeexcel);
		wb.write(fo);
	}

	public static void main(String[] args) throws Throwable {
		ExcelUtils xl = new ExcelUtils("C:\\Users\\91703\\Downloads\\Book.xlsx");
		int rc = xl.rowCount("EmpData");
		System.out.println(rc);
		for (int i = 1; i <= rc; i++) {
			String fname = xl.getCellData("EmpData", i, 0);
			String mname = xl.getCellData("EmpData", i, 1);
			String lname = xl.getCellData("EmpData", i, 2);
			String eid = xl.getCellData("EmpData", i, 3);
			System.out.println(fname + "     " + mname + "     " + lname + "     " + eid);
			xl.setCellData("EmpData", i, 4, "Pass", "C:\\Users\\91703\\Downloads\\Book.xlsx");
			xl.setCellData("EmpData", i, 4, "Fail", "C:\\Users\\91703\\Downloads\\Book.xlsx");
			xl.setCellData("EmpData", i, 4, "Blocked", "C:\\Users\\91703\\Downloads\\Book.xlsx");
		}

	}

}