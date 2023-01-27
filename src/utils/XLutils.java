package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import graphql.org.antlr.v4.runtime.tree.ParseTree;

public class XLutils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static Workbook wb;
	public static Sheet ws;
	public static Row row;
	public static Cell cell;
	public static CellStyle style;

	public static int getRowCount(String xlfile, String xlsheet) throws IOException {

		FileInputStream fi = new FileInputStream(xlfile);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet(xlsheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}

	public static short getColumnCount(String xlfile, String xlsheet, int rownum) throws IOException {
		FileInputStream fi = new FileInputStream(xlfile);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet(xlsheet);
		XSSFRow row = ws.getRow(rownum);
		short colcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return colcount;
	}

	public static String getStringCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		FileInputStream fi = new FileInputStream(xlfile);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet(xlsheet);
		XSSFRow row = ws.getRow(rownum);
		String data;
		try {
			XSSFCell cell = row.getCell(colnum);
			if (cell.getCellType() == CellType.STRING) {
				data = cell.getStringCellValue();
			} else {
				data = String.valueOf(cell.getNumericCellValue());
			}
			System.out.println(data);
		} catch (Exception e) {
			data = "";
			System.out.println(e);
		}
		wb.close();
		fi.close();
		return data;
	}

	public static double getNumericCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		FileInputStream fi = new FileInputStream(xlfile);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet(xlsheet);
		XSSFRow row = ws.getRow(rownum);
		double data;
		try {
			XSSFCell cell = row.getCell(colnum);
			data = cell.getNumericCellValue();
		} catch (Exception e) {
			data = 0.0;
			System.out.println("No Data Found!");
		}
		wb.close();
		fi.close();
		return data;
	}

	public static boolean getBooleanCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		FileInputStream fi = new FileInputStream(xlfile);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet(xlsheet);
		XSSFRow row = ws.getRow(rownum);
		boolean data;
		try {
			XSSFCell cell = row.getCell(colnum);
			data = cell.getBooleanCellValue();
		} catch (Exception e) {
			data = false;
		}
		wb.close();
		fi.close();
		return data;
	}

	public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data)
			throws IOException {
		FileInputStream fi = new FileInputStream(xlfile);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet(xlsheet);
		XSSFRow row = ws.getRow(rownum);
		XSSFCell cell = row.createCell(colnum);
		cell.setCellValue(data);
		FileOutputStream fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

	public static void fillGreenColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		FileInputStream fi = new FileInputStream(xlfile);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet(xlsheet);
		XSSFRow row = ws.getRow(rownum);
		Object cell = row.getCell(colnum);

		XSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		((XSSFCell) cell).setCellStyle(style);

		OutputStream fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

	public static void fillRedColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		FileInputStream fi = new FileInputStream(xlfile);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet(xlsheet);
		XSSFRow row = ws.getRow(rownum);
		XSSFCell cell = row.getCell(colnum);

		XSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);

		FileOutputStream fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

}
