package com.vaahanmitra.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class IdGen {
	private static Connection con=null;
	public String getId(String message)
	{
		
			int id=0;
			String query="SELECT id_no FROM vmids where id_name='" + message + "'";
			String query1="update vmids set id_no=? where id_name=?";
			try {
				con=DBConnection.getConnection();
				Statement st=con.createStatement();
				synchronized (this) {
					ResultSet rs = st.executeQuery(query);
					if (rs.next()) {
						id = rs.getInt(1);
					}
					PreparedStatement pst=con.prepareStatement(query1);
					id=id+1;
				//	System.out.println(id);
					Statement sst=con.createStatement();
				//	System.out.println("update vmids set id_no='"+id+"' where id_name='"+message+"'");
					int kk=sst.executeUpdate("update vmids set id_no='"+id+"' where id_name='"+message+"'");
				//	System.out.println("Mahesh"+kk);
					/*pst.setInt(1, id);
					pst.setString(2, message);
					pst.executeUpdate();*/
				}
			} catch (Exception  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return String.valueOf(id);
		}
	
	public int getNewIds(String message)
	{
		
			int id=0;
			String query="SELECT id_no FROM vmids where id_name='" + message + "'";
			try {
				con=DBConnection.getConnection();
				Statement st=con.createStatement();
				synchronized (this) {
					ResultSet rs = st.executeQuery(query);
					if (rs.next()) {
						id = rs.getInt(1);
					}
				}
			} catch (Exception  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return id;
		}
	public boolean updateNewId(String message,int newcarid)
	{
		int id=0;
		boolean b=false;
			String query1="update vmids set id_no=? where id_name=?";
			try {
				con=DBConnection.getConnection();
					PreparedStatement pst=con.prepareStatement(query1);
					id=newcarid;
					Statement sst=con.createStatement();
					int kk=sst.executeUpdate("update vmids set id_no='"+id+"' where id_name='"+message+"'");
					if(kk>0)
					{
						b=true;
					}
			} catch (Exception  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return b;
		}
}
