package com.vaahanmitra.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.vaahanmitra.dao.RegistrationDao;
import com.vaahanmitra.dbutil.DBConnection;
import com.vaahanmitra.model.Registration;

public class RegistrationDaoImpl implements RegistrationDao {

	private Connection conn = DBConnection.getConnection();
	public String addUser(Registration registration) {
		String message=null;
		
		try {
			String query = "insert into registration values (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, registration.getSERIAL_NO());
			preparedStatement.setString(2, registration.getFIRST_NAME());
			preparedStatement.setString(3, registration.getLAST_NAME());
			preparedStatement.setString(4, registration.getGENDER());
			preparedStatement.setString(5, registration.getEMAIL());
			preparedStatement.setString(6, registration.getPHONE_NO());
			preparedStatement.setString(7, registration.getPANCARD_NO());
			preparedStatement.setString(8, registration.getADDRESS());
			preparedStatement.setString(9, registration.getCITY());
			preparedStatement.setString(10, registration.getSTATE());
			preparedStatement.setString(11, registration.getDISTRICT());
			preparedStatement.setString(12, registration.getPASSWORD());
			
			int i = preparedStatement.executeUpdate();
			System.out.println(i);
			if(i>0)
			{
				message=registration.getFIRST_NAME();
			}
			else
			{
				message="data not inserted please try again";
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				
				conn.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	return message;
	}
	public boolean retriveEmail(String email) {
		String existEmail="";
		boolean success=false;
		try {
			String query = "select * from registration where EMAIL='"+email+"'";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				existEmail = rs.getString(5);
			}
			if(email.equals(existEmail))
			{
				success = true;
			}else
			{
				success = false;
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				
				conn.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return success;
	}
	public Registration getAddressDetails(String emailId) {
		
		Registration registration = new Registration();
		try {
			String query = "select * from registration where EMAIL='"+emailId+"'";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				registration.setFIRST_NAME(rs.getString("FIRST_NAME"));
				registration.setEMAIL(rs.getString("EMAIL"));
				registration.setPHONE_NO(rs.getString("PHONE_NO"));
				registration.setADDRESS(rs.getString("ADDRESS"));
				registration.setCITY(rs.getString("CITY"));
				registration.setSTATE(rs.getString("STATE"));
				registration.setDISTRICT(rs.getString("DISTRICT"));
			}	
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			try{
				
				conn.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return registration;
	}
}
