package com.example.testingweb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {

	public void writeExcel() throws IOException {
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

			File currDir = new File(".");
			String path = currDir.getAbsolutePath();
			String fileLocation = path.substring(0, path.length() - 1) + "documents.xlsx";

			FileOutputStream outputStream = new FileOutputStream(fileLocation);
			workbook.write(outputStream);
		} finally {
			if (workbook != null) {

				workbook.close();

			}
		}
	}

}