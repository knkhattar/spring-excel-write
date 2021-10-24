package com.example.testingweb;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelHelperBase64 {

	public String getExcel() throws IOException {
		
		
		String base64String = "";
		Workbook workbook = new XSSFWorkbook();

		try {
			Sheet sheet = workbook.createSheet("documents");
			sheet.setColumnWidth(0, 6000);
			sheet.setColumnWidth(1, 4000);

			Row header = sheet.createRow(0);
			
			Cell headerCell = header.createCell(0);
			headerCell.setCellValue("Region");

			headerCell = header.createCell(1);
			headerCell.setCellValue("Status");

			CellStyle style = workbook.createCellStyle();
			style.setWrapText(true);

			Row row = sheet.createRow(1);
			Cell cell = row.createCell(0);
			cell.setCellValue("US");
			cell.setCellStyle(style);

			cell = row.createCell(1);
			cell.setCellValue("Quote");
			cell.setCellStyle(style);

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			workbook.write(outputStream);
			base64String = Base64.getEncoder().encodeToString(outputStream.toByteArray());
			System.out.println("base64String::"+base64String);
		} finally {
			if (workbook != null) {

				workbook.close();

			}
		}
		return base64String;
	}
	
}