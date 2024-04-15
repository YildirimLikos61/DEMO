package pds.utility;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	
	private static Workbook book;
	private static Sheet sheet;
	
	
	
	private static void openExcel(String path) 
	{
		
		try 
		{
		  FileInputStream fis=new FileInputStream(path);
		  book= new XSSFWorkbook(fis);
		}catch(Exception a) 
		{
			a.printStackTrace();
		}
	}
	
	
	
	private static void loadSheet(String sheetName) 
	{
		sheet = book.getSheet(sheetName);
	}
	
	

	private static int getRowCount()
	{
		
		return sheet.getPhysicalNumberOfRows();
	}
	
	
	public static int getColumnCount(int row) 
	{
		return sheet.getRow(row).getLastCellNum();
	}
	
	
	public static String getcelldata(int row,int col) 
	{
		return sheet.getRow(row).getCell(col).toString();
	}
	
	
	public static List<Map<String,String>> ExcelIntoMap(String path,String sheetname)
	{
		openExcel(path);
		loadSheet(sheetname);
		
		List<Map<String,String>> listmap=new ArrayList<>();
		
		for(int row=1; row<getRowCount(); row++) 
		{
			Map<String,String> map=new LinkedHashMap<>();
			
			for(int col=0; col<getColumnCount(row); col++) 
			{
				String key=getcelldata(0,col);
				String value=getcelldata(row,col);
				map.put(key, value);
			}
			
		  listmap.add(map);
		  
		}
		
		
		return listmap;
	}
	
	

	
	
	
	
	
	
	
}
