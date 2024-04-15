package pds.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



public class DBUtility {

	
	public static Connection conn;
	
	public static Statement st;
	
	public static ResultSet rs;
	
	
	public static void getConnection () 
	{
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILE_PATH);
		
		try 
		{
		String dbUserName=ConfigsReader.getProperty("dbUserName");
		String dbUrl=ConfigsReader.getProperty("dbUrl");
		String dbPassword=ConfigsReader.getProperty("dbPassword");
		
		conn=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public static List<Map<String,String>> storeDataFromDB(String sqlQuery)
	{
		List<Map<String,String>> list=new ArrayList<>();
		
		try 
		{
		   st=conn.createStatement();
		
		   rs=st.executeQuery(sqlQuery);
		
		   ResultSetMetaData rsMeta=rs.getMetaData();
		
		   int columnCount=rsMeta.getColumnCount();
		
		   Map<String,String> map;
		
		while(rs.next()) 
		{
			map=new LinkedHashMap<>();
			
			for(int i=1; i<=columnCount; i++) 
			{
				map.put(rsMeta.getColumnName(i), rs.getString(i));
			}
			
			list.add(map);
		}
		
		}catch(Exception a) 
		{
			a.printStackTrace();
		}
		
		return list;
		
		
		
	}
	
	
	
	
	
	public static void closeConnection() 
	{
		try 
		{
		
		if(conn!=null) 
		{
			conn.close();
		}
		
		if(st!=null) 
		{
			st.close();
		}
		
		if(rs!=null) 
		{
			rs.close();
		}
		
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
}
