package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.examples.CreateCell;




public class ExcelFileUtil {
	XSSFWorkbook wb;
	//constructor for reading excel path
	public ExcelFileUtil(String ExcelFile )throws Throwable
	{
		FileInputStream fi=new
				FileInputStream(ExcelFile);
		wb=new XSSFWorkbook(fi);
	}
	//method for counting number of rows in sheet
	public int rowcount(String sheetname)
	{
		return 
				wb.getSheet(sheetname).getLastRowNum();

	}
	//method of reading cell data
	public String getcelldata(String sheetname,int row,int column)

	{
		String data="";

		if (wb.getSheet(sheetname).getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC)

		{

			int celldata=(int)wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();


			data=String.valueOf(celldata);

		}

		else 

		{

			data=wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();

		}
		return data;

	}

	//method for setcelldata
	public void setcelldata(String sheetname,int row, int column,String status,String writeexcel)throws  Throwable
	{

		//get sheet from wb
		XSSFSheet ws=wb.getSheet(sheetname);
		//get row from sheet
		XSSFRow rowNum =ws.getRow(row);
		//create cell
		XSSFCell cell=rowNum.createCell(column);
		cell.setCellValue(status);
		if (status.equalsIgnoreCase("pass")) 
		{

			XSSFCellStyle style=wb.createCellStyle();

			XSSFFont font=wb.createFont();

			font.setColor(IndexedColors.GREEN.getIndex());

			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);

			style.setFont(font);

			rowNum.getCell(column).setCellStyle(style);

		}

		else if (status.equalsIgnoreCase("fail")) 

		{

			XSSFCellStyle style=wb.createCellStyle();

			XSSFFont font=wb.createFont();
			font.setColor(IndexedColors.RED.getIndex());

			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);

			style.setFont(font);
			rowNum.getCell(column).setCellStyle(style);

		}

		else  if (status.equalsIgnoreCase("blocked")) 

		{

			XSSFCellStyle style=wb.createCellStyle();

			XSSFFont font=wb.createFont();
			font.setColor(IndexedColors.BLUE.getIndex());

			font.setBold(true);

			font.setBold(true);
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			style.setFont(font);
			rowNum.getCell(column).setCellStyle(style);
		}
		FileOutputStream fo = new FileOutputStream(writeexcel);
		wb.write(fo);



	}

}





