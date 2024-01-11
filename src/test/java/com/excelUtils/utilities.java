package com.excelUtils;
//importing packages
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utilities {
	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileOutputStream fo;
	public static CellStyle style; 
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);			//opening an inputStream to read the excel file
		wb=new XSSFWorkbook(fi);				//creating instance for workbook
		ws=wb.getSheet(xlsheet);				//getting sheet from workbook
		row=ws.getRow(rownum);					//getting row at specified index
		if(row==null) {							//checking row is null
			row=ws.createRow(rownum);			//creating a row if row is null
		}
		cell=row.createCell(colnum);			//creating a cell in the row mentioned
		cell.setCellValue(data);				//setting the cell value
		fo=new FileOutputStream(xlfile);		//opening an outputStream to write to excel file
		wb.write(fo);							//writing to excel
		wb.close();								//closing the workbook
		fi.close();								//closing the inputStream
		fo.close();								//closing the outputStream
				
	}
	
	public static void fillSkyBlueColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);			//opening an inputStream to read the excel file
		wb=new XSSFWorkbook(fi);				//creating instance for workbook
		ws=wb.getSheet(xlsheet);				//getting sheet from workbook
		row=ws.getRow(rownum);					//getting row at specified index
		cell=row.getCell(colnum);				//getting cell in the row
		
		style=wb.createCellStyle();				//creating cell style
		
		style.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());	//setting colour to the cell
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  			//filling it with solid_foreground pattern
		
		cell.setCellStyle(style);				//setting the cell value
		fo=new FileOutputStream(xlfile);		//opening an outputStream to write to excel file
		wb.write(fo);							//writing to excel
		wb.close();								//closing the workbook
		fi.close();								//closing the inputStream
		fo.close();								//closing the outputStream
	}
	
	public static void fillOrangeColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);			//opening an inputStream to read the excel file
		wb=new XSSFWorkbook(fi);				//creating instance for workbook
		ws=wb.getSheet(xlsheet);				//getting sheet from workbook
		row=ws.getRow(rownum);					//getting row at specified index
		cell=row.getCell(colnum);				//getting cell in the row
		
		style=wb.createCellStyle();				//creating cell style
		
		style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());	//setting colour to the cell
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  		//filling it with solid_foreground pattern
		
		cell.setCellStyle(style);				//setting the cell value
		fo=new FileOutputStream(xlfile);		//opening an outputStream to write to excel file
		wb.write(fo);							//writing to excel
		wb.close();								//closing the workbook
		fi.close();								//closing the inputStream
		fo.close();								//closing the outputStream
	}
	
}

