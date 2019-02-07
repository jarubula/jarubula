package com.vaahanmitra.daoImpl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.owtelse.codec.Base64;
import com.vaahanmitra.dao.BusinessOwnerRegisterDao;
import com.vaahanmitra.dbutil.DBConnection;
import com.vaahanmitra.exception.BusinessOwnerException;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.UserLogin;
import com.vaahanmitra.service.SendMail;
import com.vaahanmitra.utilities.SQLDate;

public class BusinessOwnerRegisterDaoImpl implements BusinessOwnerRegisterDao {

	private Connection conn = DBConnection.getConnection();
	private int noOfRecords=0;
	public String addBusinessOwner(BusinessOwnerRegister bregistration, UserLogin login) {

		String message = null;
		try {
			String query = "insert into business_owner_register values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			String query1 = "insert into user_login values (?,?,?,?,?,?)";

			PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			PreparedStatement preparedStatement1 = conn.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setInt(1, bregistration.getSEQUENTIAL_NO());
			preparedStatement.setString(2, bregistration.getUSER_TYPE());
			preparedStatement.setString(3, bregistration.getBUSINESS_NAME());
			preparedStatement.setString(4, bregistration.getPANCARD_NO());
			preparedStatement.setString(5, bregistration.getCITY());
			preparedStatement.setInt(6, bregistration.getPINCODE_NO());
			preparedStatement.setString(7, bregistration.getADDRESS());
			preparedStatement.setString(8, bregistration.getB_CITY());
			preparedStatement.setString(9, bregistration.getSTATE());
			preparedStatement.setString(10, bregistration.getDISTRICT());
			preparedStatement.setString(11, bregistration.getOFFICE_PHONE_NO());
			preparedStatement.setInt(12, bregistration.getOFFICE_PINCODE_NO());
			preparedStatement.setString(13, bregistration.getNAME());
			preparedStatement.setString(14, bregistration.getMOBILE_NO());
			preparedStatement.setString(15, bregistration.getEMAIL_ID());
			preparedStatement.setString(16, bregistration.getSTATUS());
			preparedStatement.setString(17, "NO");
			preparedStatement.setString(18, new SQLDate().getSysDate());
			preparedStatement.setString(19, bregistration.getVEHICLE_TYPE());
			preparedStatement.setString(20, "NULL");
			preparedStatement.setString(21, bregistration.getLOCATION());
			preparedStatement.setString(22, bregistration.getGSTNO());

			preparedStatement1.setInt(1, login.getSEQUENCE_NO());
			preparedStatement1.setString(2, login.getEMAIL_ID());
			preparedStatement1.setString(3, login.getPASSWORD());
			preparedStatement1.setString(4, login.getUSER_TYPE());
			preparedStatement1.setString(5, String.valueOf(bregistration.getSEQUENTIAL_NO()));
			preparedStatement1.setString(6, login.getSTATUS());

			preparedStatement.addBatch();
			preparedStatement1.addBatch();

			int i = preparedStatement.executeUpdate();
			int j = preparedStatement1.executeUpdate();
			if (i > 0 && j > 0) {
				message = "Registration Successfull! Please Verfiy your Email";
			} else {
				message = "Registration not completed! Please try again.";
				conn.rollback();
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return message;
	}

	public String getBusinessEmail(String email) {
		String existEmail = null,status=null,message= "no";
		try {
			String query = "select * from user_login where EMAIL_ID='"+email+"'";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				existEmail = rs.getString("EMAIL_ID");
				status = rs.getString("STATUS");
			} 
			System.out.println(query);
			if (email.equals(existEmail) && status.equals("ACTIVE")) {
				message = "EMAIL ID Already Registered with US!  Please Login...";
			} else if(email.equals(existEmail)  && status.equals("INACTIVE")){
				message = "EMAIL ID Already Registered with US! Please verify your Email for Login";
				String url = "http://vaahanmitra.com/VerifyIORegister?eid="+email+"&ut=BO";
				String textMsg = "Thank you for registering... Please <a href='"+url+"'> verify your EMAIL ID</a>";
				SendMail.send(email, textMsg);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}
	public ArrayList<BusinessOwnerRegister> getOwnerDetails(BusinessOwnerRegister bo,int offset,int noOfRecords)throws BusinessOwnerException
	{
		ArrayList<BusinessOwnerRegister> al=new ArrayList<BusinessOwnerRegister>();
		String query="SELECT  SQL_CALC_FOUND_ROWS * from business_owner_register where USER_TYPE='"+bo.getUSER_TYPE()+"'";
		if(!bo.getSTATE().equals("NA"))
		{
			query+=" and state = '"+bo.getSTATE()+"'";
		}
		if(!bo.getCITY().equals("NA"))
		{
			query+=" and city = '"+bo.getCITY()+"'";
		}
		if(!bo.getMOBILE_NO().equals("NA"))
		{
			query+=" and MOBILE_NO = '"+bo.getMOBILE_NO()+"'";
		}
		if(!bo.getEMAIL_ID().equals("NA"))
		{
			query+=" and EMAIL_ID = '"+bo.getEMAIL_ID()+"'";
		}
		if(!bo.getVEHICLE_TYPE().equals("NA"))
		{
			if(bo.getVEHICLE_TYPE().equals("ALL"))
			{
			}
			else
			if(bo.getVEHICLE_TYPE().equals("4,"))
			{
				query+=" and VEHICLE_TYPE = '"+bo.getVEHICLE_TYPE()+"'";
			}
			else
			if(bo.getVEHICLE_TYPE().equals("2,"))
			{
				query+=" and VEHICLE_TYPE = '"+bo.getVEHICLE_TYPE()+"'";
			}
		}
		if(bo.getBUSINESS_NAME()!=null)
		{
			if(!bo.getB_CITY().equals("SELECT CITY"))
			{
				if(bo.getBUSINESS_NAME()!=null)
				{
					if(!bo.getBUSINESS_NAME().equals("SELECT BUSINESS NAME"))
					{
						query+=" and B_CITY='"+bo.getB_CITY()+"' and BUSINESS_NAME='"+bo.getBUSINESS_NAME()+"'";
					}
					else
					{
						query+=" and B_CITY='"+bo.getB_CITY()+"'";
					}
				}
				else
				{
					query+=" and B_CITY='"+bo.getB_CITY()+"'";
				}
			}
			
		}
		if(bo.getSTATUS()==null)
		{
			query+=" limit " + offset + ", " + noOfRecords;
		}else
		{
			query+=" order by '"+bo.getSTATUS()+"' limit " + offset + ", " + noOfRecords;
		}
		System.out.println(query);
		al=getQueriedOwnerDetails(query);
		return al;
	}
	public ArrayList<BusinessOwnerRegister> getInactiveOwnerDetails(BusinessOwnerRegister bo,int offset,int noOfRecords)throws BusinessOwnerException
	{
		ArrayList<BusinessOwnerRegister> al=new ArrayList<BusinessOwnerRegister>();
		String query="SELECT SQL_CALC_FOUND_ROWS * from business_owner_register where USER_TYPE='"+bo.getUSER_TYPE()+"' and status = 'INACTIVE'";
		
		if(bo.getBUSINESS_NAME()!=null)
		{
			if(!bo.getB_CITY().equals("SELECT CITY"))
			{
				if(bo.getBUSINESS_NAME()!=null)
				{
					if(!bo.getBUSINESS_NAME().equals("SELECT BUSINESS NAME"))
					{
						query+=" and B_CITY='"+bo.getB_CITY()+"' and BUSINESS_NAME='"+bo.getBUSINESS_NAME()+"' limit " + offset + ", " + noOfRecords;
					}
					else
					{
						query+=" and B_CITY='"+bo.getB_CITY()+"' limit " + offset + ", " + noOfRecords;
					}
				}
				else
				{
					query+=" and B_CITY='"+bo.getB_CITY()+"' limit " + offset + ", " + noOfRecords;
				}
			}
			else
			{
				query+=" limit " + offset + ", " + noOfRecords;
			}
		}
		else
		{
			query+=" limit " + offset + ", " + noOfRecords;
		}
		
		
		System.out.println(query);
		al=getQueriedOwnerDetails(query);
		return al;
	}
	public ArrayList<BusinessOwnerRegister> getQueriedOwnerDetails(String query)
	{
		ArrayList<BusinessOwnerRegister> al=new ArrayList<BusinessOwnerRegister>();
		Statement st=null;
		ResultSet rs=null;
		try
		{
			conn=DBConnection.getConnection();
			st=conn.createStatement();
			rs=st.executeQuery(query);
			while(rs.next())
			{
				BusinessOwnerRegister bo=new BusinessOwnerRegister();
				bo.setSEQUENTIAL_NO(rs.getInt("SEQUENTIAL_NO"));
				bo.setUSER_TYPE(rs.getString("USER_TYPE"));
				bo.setBUSINESS_NAME(rs.getString("BUSINESS_NAME"));
				bo.setPANCARD_NO(rs.getString("PANCARD_NO"));
				bo.setCITY(rs.getString("CITY"));
				bo.setPINCODE_NO(rs.getInt("PINCODE_NO"));
				bo.setADDRESS(rs.getString("ADDRESS"));
				bo.setB_CITY(rs.getString("B_CITY"));
				bo.setSTATE(rs.getString("STATE"));
				bo.setDISTRICT(rs.getString("DISTRICT"));
				bo.setOFFICE_PHONE_NO(rs.getString("OFFICE_PHONE_NO"));
				bo.setOFFICE_PINCODE_NO(rs.getInt("OFFICE_PINCODE_NO"));
				bo.setNAME(rs.getString("NAME"));
				bo.setMOBILE_NO(rs.getString("MOBILE_NO"));
				bo.setEMAIL_ID(rs.getString("EMAIL_ID"));
				bo.setSTATUS(rs.getString("STATUS"));
				bo.setVERIFIED(rs.getString("VERIFIED"));
				al.add(bo);
			}
			
			rs.close();
			rs = st.executeQuery("SELECT FOUND_ROWS()");
			if(rs.next())
				this.noOfRecords = rs.getInt(1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
	      {
             try {
				   st.close();
				   conn.close();
			} catch (Exception e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      }
		return al;
	}
	public boolean businessOwnerActina(BusinessOwnerRegister bo) throws BusinessOwnerException
	{
		boolean b=false;
		String status=null;
		PreparedStatement st=null;
		int i=0;
		String query=null;
		try
		{
			if(bo.getSTATUS().equals("VERIFIED"))
			{
					status="YES";
				query="UPDATE `business_owner_register` SET `VERIFIED`='"+status+"' WHERE `SEQUENTIAL_NO`='"+bo.getSEQUENTIAL_NO()+"'";
			}
			else
			{
				if(bo.getSTATUS().equals("ACTIVATE"))
				{
					status="ACTIVE";
				}
				else
				{
					status="INACTIVE";
				}
				query="UPDATE `business_owner_register` SET `STATUS`='"+status+"' WHERE `SEQUENTIAL_NO`='"+bo.getSEQUENTIAL_NO()+"'";
			}
			conn=DBConnection.getConnection();
			st=conn.prepareStatement(query);
			i=st.executeUpdate();
			if(i>0)
			{
				b=true;
			}
		}
		catch(Exception  e)
		{
			e.printStackTrace();
		}
		return b;
	}
	@Override
	public BusinessOwnerRegister getAddressDetails(String emailId) {
		
		String query = "select * from business_owner_register where EMAIL_ID='" + emailId + "'";
		BusinessOwnerRegister al = getDealers(query);
		System.out.println(query);
		return al;
	}
	
	public ArrayList<String> getBusinessOwnerLocations(String usertype)throws BusinessOwnerException
	{
		ArrayList<String> al=new ArrayList<String>();
		try {
			String query = "select B_CITY from business_owner_register where USER_TYPE = '"+usertype+"' group by B_CITY";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				al.add(rs.getString(1));
			}	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
	public ArrayList<String> getBusinessOwnerBusinessNames(String bcity,String usertype)throws BusinessOwnerException
	{
		ArrayList<String> al=new ArrayList<String>();
		String query =null;
		try {
			if(bcity.equals("ALL"))
			{
				query = "select BUSINESS_NAME from business_owner_register where USER_TYPE='"+usertype+"'";
			}
			else
			{
				query = "select BUSINESS_NAME from business_owner_register where B_CITY='"+bcity+"' and USER_TYPE='"+usertype+"'";
			}
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				al.add(rs.getString(1));
			}	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
	public ArrayList<BusinessOwnerRegister> searchBusinessOwner(BusinessOwnerRegister bo,int offset,int noOfRecords)throws BusinessOwnerException
	{
		ArrayList<BusinessOwnerRegister> al=new ArrayList<BusinessOwnerRegister>();
		String query = "select SQL_CALC_FOUND_ROWS * from business_owner_register where USER_TYPE='"+bo.getUSER_TYPE()+"' ";
		if(bo.getB_CITY()!=null)
		{
			query+=" and B_CITY ='"+bo.getB_CITY()+"' ";
		}
		if(bo.getVEHICLE_TYPE()!=null)
		{
			query+=" and VEHICLE_TYPE like '%"+bo.getVEHICLE_TYPE()+"%' ";
		}
		if(bo.getBUSINESS_NAME()!=null)
		{
			query+=" and BUSINESS_NAME ='"+bo.getBUSINESS_NAME()+"' ";
		}
		query+=" limit " + offset + ", " + noOfRecords;
		System.out.println(query);
		al=getQueriedOwnerDetails(query);
		return al;
	}
	public int getNoOfRecords() throws BusinessOwnerException
	{
		return noOfRecords;
	}
	public BusinessOwnerRegister getDetails(String email) 
	{
		Connection conn= null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		BusinessOwnerRegister owner = new BusinessOwnerRegister();
		try {
			String sql = "Select * from business_owner_register where EMAIL_ID='" + email + "'";
			conn = DBConnection.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				owner.setSEQUENTIAL_NO(Integer.parseInt(rs.getString("SEQUENTIAL_NO")));
				owner.setUSER_TYPE(rs.getString("USER_TYPE"));
				owner.setBUSINESS_NAME(rs.getString("BUSINESS_NAME"));
				owner.setPANCARD_NO(rs.getString("PANCARD_NO"));
				owner.setPINCODE_NO(Integer.parseInt(rs.getString("PINCODE_NO")));
				owner.setADDRESS(rs.getString("ADDRESS"));
				owner.setB_CITY(rs.getString("B_CITY"));
				owner.setSTATE(rs.getString("STATE"));
				owner.setDISTRICT(rs.getString("DISTRICT"));
				owner.setOFFICE_PHONE_NO(rs.getString("OFFICE_PHONE_NO"));
				owner.setOFFICE_PINCODE_NO(Integer.parseInt(rs.getString("OFFICE_PINCODE_NO")));
				owner.setNAME(rs.getString("NAME"));
				owner.setMOBILE_NO(rs.getString("MOBILE_NO"));
				owner.setEMAIL_ID(rs.getString("EMAIL_ID"));
				owner.setCITY(rs.getString("CITY"));
				
				java.sql.Blob blob = rs.getBlob("PHOTO");
				byte[] photo = blob.getBytes(1, (int) blob.length());
				String photo1 = Base64.encode(photo);
				owner.setPHOTO(photo1);
			}
		} catch (Exception e) {
		}finally{
			try{
				rs.close();
				conn.close();
			}catch(Exception e){
			}
		}
		return owner;
	}
	
	public BusinessOwnerRegister getBODetails(String boid) 
	{
		
		Connection conn= null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		BusinessOwnerRegister owner = new BusinessOwnerRegister();
		try {
			String sql = "Select * from business_owner_register where SEQUENTIAL_NO='" + boid + "'";
			conn = DBConnection.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				owner.setBUSINESS_NAME(rs.getString("BUSINESS_NAME"));
				owner.setPANCARD_NO(rs.getString("PANCARD_NO"));
				owner.setPINCODE_NO(Integer.parseInt(rs.getString("PINCODE_NO")));
				owner.setADDRESS(rs.getString("ADDRESS"));
				owner.setB_CITY(rs.getString("B_CITY"));
				owner.setSTATE(rs.getString("STATE"));
				owner.setDISTRICT(rs.getString("DISTRICT"));
				owner.setOFFICE_PHONE_NO(rs.getString("OFFICE_PHONE_NO"));
				owner.setOFFICE_PINCODE_NO(Integer.parseInt(rs.getString("OFFICE_PINCODE_NO")));
				owner.setNAME(rs.getString("NAME"));
				owner.setMOBILE_NO(rs.getString("MOBILE_NO"));
				owner.setEMAIL_ID(rs.getString("EMAIL_ID"));
				owner.setCITY(rs.getString("CITY"));
				owner.setGSTNO(rs.getString("GST_NO"));
				owner.setVEHICLE_TYPE(rs.getString("VEHICLE_TYPE"));
				java.sql.Blob blob = rs.getBlob("PHOTO");
				if(blob!=null){
				byte[] photo = blob.getBytes(1, (int) blob.length());
				String photo1 = Base64.encode(photo);
				owner.setPHOTO(photo1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return owner;
	}
	
	public String updateProfile(BusinessOwnerRegister bregistration, String user_name) {
		String message = "";
		try {
			String sql = "UPDATE business_owner_register SET BUSINESS_NAME=?, CITY=?, PINCODE_NO = ?, ADDRESS = ?, B_CITY = ?, STATE = ?, DISTRICT=?, OFFICE_PHONE_NO=?, OFFICE_PINCODE_NO=?, NAME=?, MOBILE_NO=?,PANCARD_NO=?, LOCATION=? WHERE EMAIL_ID ='"
					+ user_name + "'";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, bregistration.getBUSINESS_NAME());
			preparedStatement.setString(2, bregistration.getCITY());
			preparedStatement.setInt(3, bregistration.getPINCODE_NO());
			preparedStatement.setString(4, bregistration.getADDRESS());
			preparedStatement.setString(5, bregistration.getB_CITY());
			preparedStatement.setString(6, bregistration.getSTATE());
			preparedStatement.setString(7, bregistration.getDISTRICT());
			preparedStatement.setString(8, bregistration.getOFFICE_PHONE_NO());
			preparedStatement.setInt(9, bregistration.getOFFICE_PINCODE_NO());
			preparedStatement.setString(10, bregistration.getNAME());
			preparedStatement.setString(11, bregistration.getMOBILE_NO());
			preparedStatement.setString(12, bregistration.getPANCARD_NO());
			preparedStatement.setString(13, bregistration.getLOCATION());
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				message = "success";
			} else {
				message = "failure";
			}
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
	
	public String updateProfile(String user_name, BusinessOwnerRegister registration, InputStream is) {

		String message= null;
		Connection conn= null;
		try {
			String sql = "UPDATE business_owner_register SET  BUSINESS_NAME=?, CITY=?, PINCODE_NO=?, ADDRESS=?, B_CITY=?, STATE=?, DISTRICT=?, OFFICE_PHONE_NO=?, OFFICE_PINCODE_NO=?, NAME=?, MOBILE_NO=?, PHOTO=?,PANCARD_NO=? WHERE EMAIL_ID ='"+user_name+ "'";
			conn = DBConnection.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, registration.getBUSINESS_NAME());
			preparedStatement.setString(2, registration.getCITY());
			preparedStatement.setInt(3, registration.getPINCODE_NO());
			preparedStatement.setString(4, registration.getADDRESS());
			preparedStatement.setString(5, registration.getB_CITY());
			preparedStatement.setString(6, registration.getSTATE());
			preparedStatement.setString(7, registration.getDISTRICT());
			preparedStatement.setString(8, registration.getOFFICE_PHONE_NO());
			preparedStatement.setInt(9, registration.getOFFICE_PINCODE_NO());
			preparedStatement.setString(10, registration.getNAME());
			preparedStatement.setString(11, registration.getMOBILE_NO());
			preparedStatement.setBinaryStream(12, is);
			preparedStatement.setString(13, registration.getPANCARD_NO());
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				message = "success";
			} else {
				message = "failure";
			}
			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}
	
	public String getUserType(String user_name) {
		Connection conn= null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String vehicle = null;
		try {
			String sql = "Select VEHICLE_TYPE from business_owner_register where EMAIL_ID='" + user_name + "'";
			conn = DBConnection.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				vehicle = rs.getString("VEHICLE_TYPE");
				System.out.println(vehicle);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return vehicle;
	}
	public String updateProfile(BusinessOwnerRegister reg, InputStream is)
	{
		String message= null;
		Connection conn= null;
		try {
			String sql = "UPDATE business_owner_register SET  BUSINESS_NAME=?, CITY=?, PINCODE_NO=?, ADDRESS=?, B_CITY=?, STATE=?, DISTRICT=?, OFFICE_PHONE_NO=?, OFFICE_PINCODE_NO=?, NAME=?, MOBILE_NO=?, PHOTO=?, EMAIL_ID =?, PANCARD_NO=?,GST_NO=?,LOCATION=? WHERE SEQUENTIAL_NO='"+reg.getSEQUENTIAL_NO()+"'";
			conn = DBConnection.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, reg.getBUSINESS_NAME());
			preparedStatement.setString(2, reg.getCITY());
			preparedStatement.setInt(3, reg.getPINCODE_NO());
			preparedStatement.setString(4, reg.getADDRESS());
			preparedStatement.setString(5, reg.getB_CITY());
			preparedStatement.setString(6, reg.getSTATE());
			preparedStatement.setString(7, reg.getDISTRICT());
			preparedStatement.setString(8, reg.getOFFICE_PHONE_NO());
			preparedStatement.setInt(9, reg.getOFFICE_PINCODE_NO());
			preparedStatement.setString(10, reg.getNAME());
			preparedStatement.setString(11, reg.getMOBILE_NO());
			preparedStatement.setBinaryStream(12, is);
			preparedStatement.setString(13, reg.getEMAIL_ID());
			preparedStatement.setString(14, reg.getPANCARD_NO());
			preparedStatement.setString(15, reg.getGSTNO());
			preparedStatement.setString(16, reg.getLOCATION());
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				message = "success";
			} else {
				message = "failure";
			}
			preparedStatement.close();
			conn.close();
		} catch (Exception e) {
			message=e.getMessage();
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public String updateStatus(String email, String userType) {
		String message = null;
		Connection conn = null;
		try {
			String sql = "UPDATE business_owner_register SET status=?, VERIFIED=? WHERE EMAIL_ID ='" + email + "'";
			String query = "UPDATE user_login SET status=? WHERE EMAIL_ID ='" + email + "'";
			conn = DBConnection.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			PreparedStatement pstmt = conn.prepareStatement(query);

			preparedStatement.setString(1, "ACTIVE");
			preparedStatement.setString(2, "YES");
			pstmt.setString(1, "ACTIVE");
			int i = preparedStatement.executeUpdate();
			int j = pstmt.executeUpdate();
			if (i > 0 && j > 0) {
				message = "Your Email Id Verified! Please Login";
			} else {
				message = "Your Email Id Not Verified!";
			}
			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}
	public ArrayList<BusinessOwnerRegister> getAdSearchOwnerDetails(BusinessOwnerRegister bo,int offset,int noOfRecords)throws BusinessOwnerException
	{
		ArrayList<BusinessOwnerRegister> al=new ArrayList<BusinessOwnerRegister>();
		String query="SELECT  SQL_CALC_FOUND_ROWS * from business_owner_register where USER_TYPE='"+bo.getUSER_TYPE()+"'";
		
		System.out.println(query);
		al=getQueriedOwnerDetails(query);
		return al;
	}

	@Override
	public ArrayList<BusinessOwnerRegister> getOwnerDetails(BusinessOwnerRegister bo, String user_name, int offset,int noOfRecords) {
		ArrayList<BusinessOwnerRegister> al=new ArrayList<BusinessOwnerRegister>();
		String query="SELECT SQL_CALC_FOUND_ROWS business_owner_register.*,employee_reg_services.B_EMAIL_ID from business_owner_register left join employee_reg_services on business_owner_register.EMAIL_ID=employee_reg_services.B_EMAIL_ID where employee_reg_services.EMP_EMAIL_ID='"+user_name+"' and business_owner_register.user_type='"+bo.getUSER_TYPE()+"'";
		
		if(!bo.getSTATE().equals("NA"))
		{
			query+=" and state = '"+bo.getSTATE()+"'";
		}
		if(!bo.getDISTRICT().equals("NA"))
		{
			query+=" and district = '"+bo.getDISTRICT()+"'";
		}
		if(!bo.getMOBILE_NO().equals("NA"))
		{
			query+=" and MOBILE_NO = '"+bo.getMOBILE_NO()+"'";
		}
		if(!bo.getEMAIL_ID().equals("NA"))
		{
			query+=" and EMAIL_ID = '"+bo.getEMAIL_ID()+"'";
		}
		if(!bo.getVEHICLE_TYPE().equals("NA"))
		{
			if(bo.getVEHICLE_TYPE().equals("ALL"))
			{
			}
			else
			if(bo.getVEHICLE_TYPE().equals("4,"))
			{
				query+=" and VEHICLE_TYPE = '"+bo.getVEHICLE_TYPE()+"'";
			}
			else
			if(bo.getVEHICLE_TYPE().equals("2,"))
			{
				query+=" and VEHICLE_TYPE = '"+bo.getVEHICLE_TYPE()+"'";
			}
		}
		/*if(bo.getBUSINESS_NAME()!=null)
		{
			if(!bo.getB_CITY().equals("SELECT CITY"))
			{
				if(bo.getBUSINESS_NAME()!=null)
				{
					if(!bo.getBUSINESS_NAME().equals("SELECT BUSINESS NAME"))
					{
						query+=" and B_CITY='"+bo.getB_CITY()+"' and BUSINESS_NAME='"+bo.getBUSINESS_NAME()+"'";
					}
					else
					{
						query+=" and B_CITY='"+bo.getB_CITY()+"'";
					}
				}
				else
				{
					query+=" and B_CITY='"+bo.getB_CITY()+"'";
				}
			}
			
		}
		if(bo.getSTATUS()==null)
		{
			query+=" limit " + offset + ", " + noOfRecords;
		}*/else
		{
			query+=" order by '"+bo.getSTATUS()+"' limit " + offset + ", " + noOfRecords;
		}
		System.out.println(query);
		al=getQueriedOwnerDetails(query);
		return al;
	}

	@Override
	public String setStatus(String emailId, String status, String user_name) {
		conn = DBConnection.getConnection();
		String message = "";
		int j = 0;
		try {
			String sql = null,query=null;
			if (status.equals("ACTIVE")) {
				sql = "UPDATE business_owner_register SET STATUS='INACTIVE' WHERE EMAIL_ID ='"+emailId+"'";
				query = "UPDATE user_login SET STATUS='INACTIVE' WHERE EMAIL_ID ='"+emailId+"'";
			} else {
				sql = "UPDATE business_owner_register SET STATUS='ACTIVE' WHERE EMAIL_ID ='"+emailId+"'";
				query = "UPDATE user_login SET STATUS='ACTIVE' WHERE EMAIL_ID ='"+emailId+"'";
			}
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			PreparedStatement psmt = conn.prepareStatement(query);
			j = preparedStatement.executeUpdate();
			int k = psmt.executeUpdate();
			if (j > 0 && k>0) {
				message = "success";
			} else {
				message = "failure";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public String searchAuthentication(String email,String v_type) {
		String status = null;
		try {
			String qurey="SELECT * FROM dealer_authentication WHERE DEALER_NAME like BINARY '" + email + "' and VEHICLE_TYPE='"+v_type+"'";
			PreparedStatement preparedStatement = conn.prepareStatement(qurey);
		
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				status = rs.getString("DEALER_AUTHENTICATION");
			} else {
				status = "";
			}
			conn.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
		return status;
	}

	@Override
	public ArrayList<BusinessOwnerRegister> getCity() {
		ArrayList<BusinessOwnerRegister> al=new ArrayList<BusinessOwnerRegister>();
		try {
			String query = "select B_CITY from business_owner_register group by B_CITY";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				BusinessOwnerRegister bor = new BusinessOwnerRegister();
				bor.setB_CITY(rs.getString("B_CITY"));
				al.add(bor);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public ArrayList<BusinessOwnerRegister> getDealers(String brand, String city,String v_type) {
		String query = "SELECT business_owner_register.*,dealer_authentication.* from business_owner_register left join dealer_authentication on business_owner_register.EMAIL_ID=dealer_authentication.DEALER_NAME where B_CITY='"+city+"' and USER_TYPE='UD' and BRAND_NAME='"+brand+"' and DEALER_AUTHENTICATION='Yes' and dealer_authentication.VEHICLE_TYPE like '%"+v_type+"%' ";
		ArrayList<BusinessOwnerRegister> al = getQueriedOwnerDetails(query);
		
		return al;
	}
	public BusinessOwnerRegister getDealers(String query) {
		BusinessOwnerRegister registration = new BusinessOwnerRegister();
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = conn.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				registration.setBUSINESS_NAME(rs.getString("BUSINESS_NAME"));
				registration.setPANCARD_NO(rs.getString("PANCARD_NO"));
				registration.setCITY(rs.getString("CITY"));
				registration.setPINCODE_NO(Integer.parseInt(rs.getString("PINCODE_NO")));
				registration.setADDRESS(rs.getString("ADDRESS"));
				registration.setLOCATION(rs.getString("LOCATION"));
				registration.setB_CITY(rs.getString("B_CITY"));
				registration.setSTATE(rs.getString("STATE"));
				registration.setDISTRICT(rs.getString("DISTRICT"));
				registration.setOFFICE_PHONE_NO(rs.getString("OFFICE_PHONE_NO"));
				registration.setOFFICE_PINCODE_NO(Integer.parseInt(rs.getString("OFFICE_PINCODE_NO")));
				registration.setNAME(rs.getString("NAME"));
				registration.setMOBILE_NO(rs.getString("MOBILE_NO"));
				registration.setEMAIL_ID(rs.getString("EMAIL_ID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return registration;
	}

	@Override
	public ArrayList<String> getOnRoadPriceofCar(String car_id, String dealer_id) {
		Connection conn= null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String onroadprice = null;
		ArrayList<String> list=new ArrayList<String>();
		try {
			String sql = "select PRICE from vehicle_price_table where NEW_VEHICLE_ID='"+car_id+"' and USER_ID='"+dealer_id+"'";
			
			conn = DBConnection.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				onroadprice = rs.getString("PRICE");
				list.add(onroadprice);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public ArrayList<BusinessOwnerRegister> getSparepartsDealers(String brand, String city, String v_type) {
		// TODO Auto-generated method stub
		String query = "select * from business_owner_register br inner join spareparts_details sp on br.EMAIL_ID = sp.USER_NAME where br.STATUS = 'ACTIVE' and sp.SP_STATUS = 'ACTIVE' and br.VERIFIED = 'Yes' and br.B_CITY = '"+city+"' and sp.VEHICLE_BRAND = '"+brand+"' and sp.VEHICLE_TYPE like '%"+v_type+"%' group by br.EMAIL_ID";
		
		ArrayList<BusinessOwnerRegister> al = getQueriedOwnerDetails(query);
		return al;
	}
	
	@Override
	public ArrayList<BusinessOwnerRegister> getServiceCenterDealers(String brand, String city, String v_type) {
		// TODO Auto-generated method stub
		String query = "select * from business_owner_register br inner join selected_vehicle_type_details svt on br.EMAIL_ID = svt.REFERENCE_ID where br.STATUS = 'ACTIVE' and br.VERIFIED = 'YES' and br.B_CITY = '"+city+"' and svt.BRAND = '"+brand+"' and svt.SELECTED_VEHICLE_TYPE like '%"+v_type+"%' group by br.EMAIL_ID";
		
		ArrayList<BusinessOwnerRegister> al = getQueriedOwnerDetails(query);
		return al;
	}
	
}
