package com.vaahanmitra.dbutil;

import java.sql.*;

public class DBConnection {

	
private static Connection con=null;

public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//  con=DriverManager.getConnection("jdbc:mysql://localhost/vaahanmitra","root","root");
			con=DriverManager.getConnection("jdbc:mysql://vaahanmitra.cmrhzvst1vkt.us-east-1.rds.amazonaws.com/vaahanmitra?SSL=false","vaahanmitra","vaahanmitraKSL");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
		}
}

