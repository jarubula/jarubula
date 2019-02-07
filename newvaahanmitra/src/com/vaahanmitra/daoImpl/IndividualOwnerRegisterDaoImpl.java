package com.vaahanmitra.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import com.vaahanmitra.dao.IndividualOwnerRegisterDao;
import com.vaahanmitra.dbutil.DBConnection;
import com.vaahanmitra.exception.IndividualOwnerException;
import com.vaahanmitra.model.IndividualOwnerRegister;
import com.vaahanmitra.model.UserInterestedVehicles;
import com.vaahanmitra.model.UserLogin;
import com.vaahanmitra.service.SendMail;
import com.vaahanmitra.utilities.SQLDate;

public class IndividualOwnerRegisterDaoImpl implements IndividualOwnerRegisterDao{
		
	private Connection conn = DBConnection.getConnection();
	private int noOfRecords=0;
	public String addOwner(IndividualOwnerRegister registration, UserLogin login) {
		String message = null;
		try {
			String query = "insert into individual_owner_rigister values (?,?,?,?,?,?,?,?,?,?,?,?)";
			String query1 = "insert into user_login values (?,?,?,?,?,?)";

			PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			PreparedStatement preparedStatement1 = conn.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setInt(1, registration.getSEQUENTIAL_NO());
			preparedStatement.setString(2, registration.getUSER_TYPE());
			preparedStatement.setString(3, registration.getPANCARD_NO());
			preparedStatement.setString(4, registration.getCITY());
			preparedStatement.setString(5, registration.getPINCODE_NO());
			preparedStatement.setString(6, registration.getVEHICAL_TYPE());
			preparedStatement.setString(7, registration.getNAME());
			preparedStatement.setString(8, registration.getMOBILE_NO());
			preparedStatement.setString(9, registration.getEMAIL_ID());
			preparedStatement.setString(10, registration.getSTATUS());
			preparedStatement.setString(11, "NO");
			preparedStatement.setString(12, new SQLDate().getSysDate());

			preparedStatement1.setInt(1, login.getSEQUENCE_NO());
			preparedStatement1.setString(2, login.getEMAIL_ID());
			preparedStatement1.setString(3, login.getPASSWORD());
			preparedStatement1.setString(4, login.getUSER_TYPE());
			preparedStatement1.setString(5, String.valueOf(registration.getSEQUENTIAL_NO()));
			preparedStatement1.setString(6, login.getSTATUS());
			// preparedStatement1.setString(7, "NO");

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
		}finally {
			try {
				
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return message;
	}
	
	public String getEmail(String email) {
		String existEmail = null, status = null, message = "no";
		try {
			String query = "select * from user_login where EMAIL_ID='" + email + "'";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				existEmail = rs.getString("EMAIL_ID");
				status = rs.getString("STATUS");
			}
			System.out.println(query);
			if (email.equals(existEmail) && status.equals("ACTIVE")) {
				message = "EMAIL ID Already Registered with US!  Please Login...";
			} else if (email.equals(existEmail) && status.equals("INACTIVE")) {
				message = "EMAIL ID Already Registered with US! Please verify your Email for Login";
				String url = "http://vaahanmitra.com/VerifyIORegister?eid=" + email + "&ut=BO";
				String textMsg = "Thank you for registering... Please <a href='" + url + "'> verify your EMAIL ID</a>";
				SendMail.send(email, textMsg);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return message;
	}
	
	public ArrayList<IndividualOwnerRegister> getOwnerDetails(IndividualOwnerRegister io,int offset,int noOfRecords)throws IndividualOwnerException
	{
		ArrayList<IndividualOwnerRegister> al=new ArrayList<IndividualOwnerRegister>();
		String query="SELECT  SQL_CALC_FOUND_ROWS * from individual_owner_rigister limit " + offset + ", " + noOfRecords;
		System.out.println(query);
		al=getQueriedOwnerDetails(query);
		return al;
	}
	private ArrayList<IndividualOwnerRegister> getQueriedOwnerDetails(String query)
	{
		ArrayList<IndividualOwnerRegister> al=new ArrayList<IndividualOwnerRegister>();
		Statement st=null;
		ResultSet rs=null;
		try
		{
			conn=DBConnection.getConnection();
			st=conn.createStatement();
			rs=st.executeQuery(query);
			while(rs.next())
			{
				IndividualOwnerRegister bo=new IndividualOwnerRegister();
				bo.setSEQUENTIAL_NO(rs.getInt("SEQUENTIAL_NO"));
				bo.setUSER_TYPE(rs.getString("USER_TYPE"));
				bo.setPANCARD_NO(rs.getString("PANCARD_NO"));
				bo.setVEHICAL_TYPE(rs.getString("VEHICAL_TYPE"));
				bo.setCITY(rs.getString("CITY"));
				bo.setPINCODE_NO(rs.getString("PINCODE_NO"));
				bo.setNAME(rs.getString("NAME"));
				bo.setMOBILE_NO(rs.getString("MOBILE_NO"));
				bo.setEMAIL_ID(rs.getString("EMAIL_ID"));
				bo.setSTATUS(rs.getString("STATUS"));
				bo.setVERIFIED(rs.getString("VERIFIED"));
				bo.setREGISTRATION_DATE(rs.getString("REGISTRATION_DATE"));
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
	public int getNoOfRecords() throws IndividualOwnerException
	{
		return noOfRecords;
	}
	public ArrayList<IndividualOwnerRegister> getInactiveOwnerDetails(IndividualOwnerRegister io,int offset,int noOfRecords)throws IndividualOwnerException
	{
		ArrayList<IndividualOwnerRegister> al=new ArrayList<IndividualOwnerRegister>();
		String query="SELECT  SQL_CALC_FOUND_ROWS * from individual_owner_rigister limit " + offset + ", " + noOfRecords;
//		System.out.println(query);
		al=getQueriedOwnerDetails(query);
		return al;
	}
	@Override
	public boolean individualOwnerActina(IndividualOwnerRegister io) throws IndividualOwnerException 
	{
		String status=io.getSTATUS(),query=null,query1=null;
		boolean b=false,flag=false;
		PreparedStatement st=null,st1=null;
		int i=0,j=0;
		try
		{if(status.equals("VERIFIED"))
		{
			status="YES";
			query="UPDATE `individual_owner_rigister` SET `VERIFIED`='"+status+"' WHERE `SEQUENTIAL_NO`='"+io.getSEQUENTIAL_NO()+"'";
			flag=true;
		}
		else
		{
			if(status.equals("ACTIVATE"))
			{
				status="ACTIVE";
			}
			else
			{
				status="INACTIVE";
			}
			query="UPDATE `individual_owner_rigister` SET `STATUS`='"+status+"' WHERE `SEQUENTIAL_NO`='"+io.getSEQUENTIAL_NO()+"'";
			query1="UPDATE `user_login` SET `STATUS`='"+status+"' WHERE `SEQUENCE_NO`='"+io.getSEQUENTIAL_NO()+"'";
		}
			conn=DBConnection.getConnection();
			st=conn.prepareStatement(query);
			st1=conn.prepareStatement(query1);
			if(flag)
			{
				i=st.executeUpdate();
				if(i>0)
				{
					b=true;
				}
			}
			else
			{
			i=st.executeUpdate();
			j=st1.executeUpdate();
			if(i>0 && j>0)
			{
				b=true;
			}
			}
		}
		catch(Exception  e)
		{
			e.printStackTrace();
		}finally {
			try {
				
				st.close();
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return b;
	}
	public IndividualOwnerRegister getOwnerDetails(String seqid)throws IndividualOwnerException
	{
		IndividualOwnerRegister bo=new IndividualOwnerRegister();
		String query="SELECT * FROM individual_owner_rigister WHERE `SEQUENTIAL_NO`='"+seqid+"'";
		Statement st=null;
		ResultSet rs=null;
		try
		{
			conn=DBConnection.getConnection();
			st=conn.createStatement();
			rs=st.executeQuery(query);
			if(rs.next())
			{
				bo.setSEQUENTIAL_NO(rs.getInt("SEQUENTIAL_NO"));
				bo.setUSER_TYPE(rs.getString("USER_TYPE"));
				bo.setPANCARD_NO(rs.getString("PANCARD_NO"));
				bo.setVEHICAL_TYPE(rs.getString("VEHICAL_TYPE"));
				bo.setCITY(rs.getString("CITY"));
				bo.setPINCODE_NO(rs.getString("PINCODE_NO"));
				bo.setNAME(rs.getString("NAME"));
				bo.setMOBILE_NO(rs.getString("MOBILE_NO"));
				bo.setEMAIL_ID(rs.getString("EMAIL_ID"));
				bo.setSTATUS(rs.getString("STATUS"));
				bo.setVERIFIED(rs.getString("VERIFIED"));
				bo.setREGISTRATION_DATE(rs.getString("REGISTRATION_DATE"));
			}
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
		return bo;
	}
	@Override
	public IndividualOwnerRegister getDeatils(String email) {

//		System.out.println(email);
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		IndividualOwnerRegister owner = new IndividualOwnerRegister();
		try {
			String sql = "Select * from individual_owner_rigister where EMAIL_ID='" + email + "'";
			conn = DBConnection.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				owner.setNAME(rs.getString("NAME"));
				owner.setCITY(rs.getString("CITY"));
				owner.setEMAIL_ID(rs.getString("EMAIL_ID"));
				owner.setMOBILE_NO(rs.getString("MOBILE_NO"));
				owner.setPANCARD_NO(rs.getString("PANCARD_NO"));
				owner.setPINCODE_NO(rs.getString("PINCODE_NO"));
				owner.setSEQUENTIAL_NO(Integer.parseInt(rs.getString("SEQUENTIAL_NO")));
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
		return owner;
	}
	
	public String updateProfile(String user_name,IndividualOwnerRegister registration) {

		String message = null;
		Connection conn = null;
		try {
			String sql = "UPDATE individual_owner_rigister SET NAME=?,PANCARD_NO=?, CITY=?, PINCODE_NO = ?, MOBILE_NO=? WHERE EMAIL_ID ='"
					+ user_name + "'";
			conn = DBConnection.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, registration.getNAME());
			preparedStatement.setString(2, registration.getPANCARD_NO());
			preparedStatement.setString(3, registration.getCITY());
			preparedStatement.setString(4, registration.getPINCODE_NO());
			preparedStatement.setString(5, registration.getMOBILE_NO());
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
		}finally {
			try {
				
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return message;
	}
	public ArrayList<String> getIndividualOwnerLocations() throws IndividualOwnerException
	{
		ArrayList<String> al=new ArrayList<String>();
		String query="SELECT CITY FROM individual_owner_rigister group by CITY";
		Statement st=null;
		ResultSet rs=null;
		try
		{
			conn=DBConnection.getConnection();
			st=conn.createStatement();
			rs=st.executeQuery(query);
			while(rs.next())
			{
				al.add(rs.getString("CITY"));
			}
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
	public ArrayList<IndividualOwnerRegister> searchIndividualOwner(IndividualOwnerRegister bo,int offset,int noOfRecords)throws IndividualOwnerException
	{
		ArrayList<IndividualOwnerRegister> al=new ArrayList<IndividualOwnerRegister>();
		String query = "select SQL_CALC_FOUND_ROWS * from individual_owner_rigister where USER_TYPE='IO'";
		if(!bo.getSTATUS().equals("NA"))
		{
		}
		if(!bo.getCITY().equals("NA"))
		{
			if(bo.getCITY().equals("Hyderabad-Deccan"))
			{
				bo.setCITY("Hyderabad");
			}
			query+=" and CITY ='"+bo.getCITY()+"' ";
		}
		if(!bo.getVEHICAL_TYPE().equals("NA"))
		{
			query+=" and VEHICAL_TYPE like '%"+bo.getVEHICAL_TYPE()+"%' ";
		}
		if(!bo.getMOBILE_NO().equals("NA"))
		{
			query+=" and MOBILE_NO = '%"+bo.getMOBILE_NO()+"%' ";
		}
		/*if(bo.getCITY()!=null)
		{
			query+=" and CITY ='"+bo.getCITY()+"' ";
		}
		if(bo.getVEHICAL_TYPE()!=null)
		{
			query+=" and VEHICAL_TYPE like '%"+bo.getVEHICAL_TYPE()+"%' ";
		}*/
		
		query+=" limit " + offset + ", " + noOfRecords;
//		System.out.println(query);
		al=getQueriedOwnerDetails(query);
		return al;
	}
	@Override
	public String updateStatus(String email, String userType) {
		String message = null;
		Connection conn = null;
		Statement st=null;
		ResultSet rs=null;
		String usertype=null,table=null;;
		try {
			conn = DBConnection.getConnection();

			st=conn.createStatement();
//			System.out.println("select USER_TYPE from user_login where EMAIL_ID ='" + email + "'");
			rs=st.executeQuery("select USER_TYPE from user_login where EMAIL_ID ='" + email + "'");
			if(rs.next())
			{
				usertype=rs.getString(1);
			
			if(usertype.equals("SC") || usertype.equals("SP") ||usertype.equals("UD"))
			{
				table="business_owner_register";
			}
			else
				if(usertype.equals("IO"))
				{
					table="individual_owner_rigister";
				}	
			String sql = "UPDATE "+table+" SET status=?, VERIFIED=? WHERE EMAIL_ID ='" + email + "'";
			String query = "UPDATE user_login SET status=? WHERE EMAIL_ID ='" + email + "'";
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
			}
			else
			{
				message="Invalid Email ID....";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}
	public String checkEmailStatus(String email,String carId,String mobileNo,String name) {
		String existEmail = null, status = null, message = "no";
		try {
			String query = "select * from user_login where EMAIL_ID='" + email + "'";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				existEmail = rs.getString("EMAIL_ID");
				status = rs.getString("STATUS");
			}
			if (email.equals(existEmail) && status.equals("ACTIVE")) {
				message = "EMAIL ID Already Registered with US!  Please Login...";
			} else if (email.equals(existEmail) && status.equals("INACTIVE")) {
				message = "EMAIL ID Already Registered with US! Please verify your Email for Login";
				String url = "http://vaahanmitra.com/VerifyEmailController?cid=" + carId + "&eid=" + email + "&mno="+ mobileNo + "&nm="+name+"";
				String textMsg = "Thank you for Registring with Vaahanmitra! Please " + " <a href='" + url
						+ "'> verify your EMAIL ID</a>";
				SendMail.send(email, textMsg);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return message;
	}
	public String getEmailStatus(String email,String bikeId,String mobileNo,String name) {
		String existEmail = null, status = null, message = "no";
		try {
			String query = "select * from user_login where EMAIL_ID='" + email + "'";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				existEmail = rs.getString("EMAIL_ID");
				status = rs.getString("STATUS");
			}
			if (email.equals(existEmail) && status.equals("ACTIVE")) {
				message = "EMAIL ID Already Registered with US!  Please Login...";
			} else if (email.equals(existEmail) && status.equals("INACTIVE")) {
				message = "EMAIL ID Already Registered with US! Please verify your Email for Login";
				String url = "http://vaahanmitra.com/VerifyEmail?bid=" + bikeId + "&eid=" + email + "&mno="+ mobileNo + "&nm="+name+"";
				String textMsg = "Thank you for Registring... Please " + " <a href='" + url
						+ "'> verify your EMAIL ID</a>";
				SendMail.send(email, textMsg);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return message;
	}
	@Override
	public String checkDEmailStatus(String email, String demail, String carId, String mobileNo, String name) {
		String existEmail = null, status = null, message = "no";
		try {
			String query = "select * from user_login where EMAIL_ID='" + email + "'";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				existEmail = rs.getString("EMAIL_ID");
				status = rs.getString("STATUS");
			}
			if (email.equals(existEmail) && status.equals("ACTIVE")) {
				message = "EMAIL ID Already Registered with US!  Please Login...</a>";
			} else if (email.equals(existEmail) && status.equals("INACTIVE")) {
				message = "EMAIL ID Already Registered with US! Please verify your Email for Login";
				String url = "http://vaahanmitra.com/VerifyDCEmail?cid=" + carId + "&eid=" + email + "&mno="+ mobileNo + "&nm="+name+"&de="+demail+"";
				String textMsg = "Thank you for Registered with US! Please " + " <a href='" + url
						+ "'> verify your EMAIL ID</a>";
				SendMail.send(email, textMsg);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return message;
	}
	public String checkDBEmailStatus(String email, String demail, String bikeId, String mobileNo, String name) {
		String existEmail = null, status = null, message = "no";
		try {
			String query = "select * from user_login where EMAIL_ID='" + email + "'";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				existEmail = rs.getString("EMAIL_ID");
				status = rs.getString("STATUS");
			}
			if (email.equals(existEmail) && status.equals("ACTIVE")) {
				message = "EMAIL ID Already Registered with US!  Please Login...</a>";
			} else if (email.equals(existEmail) && status.equals("INACTIVE")) {
				message = "EMAIL ID Already Registered with US! Please verify your Email for Login";
				String url = "http://vaahanmitra.com/VerifyDBEmail?bid=" + bikeId + "&eid=" + email + "&mno="+ mobileNo + "&nm="+name+"&de="+demail+"";
				String textMsg = "Thank you for Registered with US! Please " + " <a href='" + url
						+ "'> verify your EMAIL ID</a>";
				SendMail.send(email, textMsg);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return message;
	}

	@Override
	public ArrayList<IndividualOwnerRegister> getOwnerDetails(IndividualOwnerRegister io, String user_name, int offset,
			int noOfRecords) {
		ArrayList<IndividualOwnerRegister> al=new ArrayList<IndividualOwnerRegister>();
		String query = "SELECT SQL_CALC_FOUND_ROWS individual_owner_rigister.*,employee_reg_services.B_EMAIL_ID from individual_owner_rigister left join employee_reg_services on individual_owner_rigister.EMAIL_ID=employee_reg_services.B_EMAIL_ID where employee_reg_services.EMP_EMAIL_ID='"+user_name+"' and individual_owner_rigister.user_type='"+io.getUSER_TYPE()+"'";
		if(!io.getCITY().equals("NA"))
		{
			if(io.getCITY().equals("Hyderabad-Deccan"))
			{
				io.setCITY("Hyderabad");
			}
			query+=" and CITY ='"+io.getCITY()+"' ";
		}
		if(!io.getMOBILE_NO().equals("NA"))
		{
			query+=" and MOBILE_NO = '"+io.getMOBILE_NO()+"' ";
		}
		if(!io.getEMAIL_ID().equals("NA"))
		{
			query+=" and EMAIL_ID = '"+io.getEMAIL_ID()+"' ";
		}
		if(!io.getVEHICAL_TYPE().equals("NA"))
		{
			if(io.getVEHICAL_TYPE().equals("ALL"))
			{
			}
			else
			if(io.getVEHICAL_TYPE().equals("4,"))
			{
				query+=" and VEHICAL_TYPE = '"+io.getVEHICAL_TYPE()+"'";
			}
			else
			if(io.getVEHICAL_TYPE().equals("2,"))
			{
				query+=" and VEHICAL_TYPE = '"+io.getVEHICAL_TYPE()+"'";
			}
		}
		query+=" limit " + offset + ", " + noOfRecords;
//		System.out.println(query);
		al=getQueriedOwnerDetails(query);
		return al;
	}

	@Override
	public ArrayList<String> getIOCities(String email) {
		ArrayList<String> al=new ArrayList<String>();
		String query = "SELECT CITY from individual_owner_rigister.*,employee_reg_services.B_EMAIL_ID from individual_owner_rigister left join employee_reg_services on individual_owner_rigister.EMAIL_ID=employee_reg_services.B_EMAIL_ID where employee_reg_services.EMP_EMAIL_ID='"+email+"' and group by CITY";
//		String query="SELECT CITY FROM individual_owner_rigister group by CITY";
		/*select  individual_owner_rigister.CITY from employee_reg_services left join individual_owner_rigister on employee_reg_services.B_EMAIL_ID= individual_owner_rigister.EMAIL_ID where individual_owner_rigister.EMAIL_ID='harismca8113@gmail.com'; */
		Statement st=null;
		ResultSet rs=null;
		try
		{
			conn=DBConnection.getConnection();
			st=conn.createStatement();
			rs=st.executeQuery(query);
			while(rs.next())
			{
				al.add(rs.getString("CITY"));
			}
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

	@Override
	public String setStatus(String emailId, String status, String user_name) {
		conn = DBConnection.getConnection();
		String message = "";
		int j = 0;
		try {
			String sql = null,query=null;
			if (status.equals("ACTIVE")) {
				sql = "UPDATE individual_owner_rigister SET STATUS='INACTIVE' WHERE EMAIL_ID ='"+emailId+"'";
				query = "UPDATE user_login SET STATUS='INACTIVE' WHERE EMAIL_ID ='"+emailId+"'";
			} else {
				sql = "UPDATE individual_owner_rigister SET STATUS='ACTIVE' WHERE EMAIL_ID ='"+emailId+"'";
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
		}finally {
			try {
				
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return message;
	}

	@Override
	public String updateProfile(IndividualOwnerRegister registration) {
		String message = null;
		Connection conn = null;
		try {
			String sql = "UPDATE individual_owner_rigister SET NAME=?,PANCARD_NO=?, CITY=?, PINCODE_NO = ?, MOBILE_NO=?, EMAIL_ID=?, VEHICAL_TYPE=? WHERE SEQUENTIAL_NO ='"+registration.getSEQUENTIAL_NO()+"'";
			conn = DBConnection.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, registration.getNAME());
			preparedStatement.setString(2, registration.getPANCARD_NO());
			preparedStatement.setString(3, registration.getCITY());
			preparedStatement.setString(4, registration.getPINCODE_NO());
			preparedStatement.setString(5, registration.getMOBILE_NO());
			preparedStatement.setString(6, registration.getEMAIL_ID());
			preparedStatement.setString(7, registration.getVEHICAL_TYPE());
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				message = "success";
			} else {
				message = "failure";
			}
			preparedStatement.close();
//			System.out.println(sql);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}
	
	
	public String addIndividualOwnerFromSearch(IndividualOwnerRegister registration)
	{
		String message=null;
		try {
			String query = "insert into individual_owner_rigister values (?,?,?,?,?,?,?,?,?,?,?,?)";
			String query1 = "insert into user_login values (?,?,?,?,?,?)";

			PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			PreparedStatement preparedStatement1 = conn.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setInt(1, registration.getSEQUENTIAL_NO());
			preparedStatement.setString(2, "IO");
			preparedStatement.setString(3, "NA");
			preparedStatement.setString(4, registration.getCITY());
			preparedStatement.setString(5, "NA");
			preparedStatement.setString(6, registration.getVEHICAL_TYPE());
			preparedStatement.setString(7, registration.getNAME());
			preparedStatement.setString(8, registration.getMOBILE_NO());
			preparedStatement.setString(9, registration.getEMAIL_ID());
			preparedStatement.setString(10, "INACTIVE");
			preparedStatement.setString(11, "NO");
			preparedStatement.setString(12, new SQLDate().getSysDate());

			preparedStatement1.setInt(1, registration.getSEQUENTIAL_NO());
			preparedStatement1.setString(2, registration.getEMAIL_ID());
			preparedStatement1.setString(3, registration.getSTATUS());
			preparedStatement1.setString(4, "IO");
			preparedStatement1.setString(5, String.valueOf(registration.getSEQUENTIAL_NO()));
			preparedStatement1.setString(6, "INACTIVE");

			int i = preparedStatement.executeUpdate();
			int j = preparedStatement1.executeUpdate();
			if (i > 0 && j > 0) {
				message = "true";
				String url = "http://vaahanmitra.com/VerifyIORegister?eid="+registration.getEMAIL_ID()+"&ut=IO";
				String textMsg = "Thank you for Registering with Vaahanmitra.com.  Please <a href='"+url+"'> Verify your EMAIL ID</a>";
				new SendMail().send(registration.getEMAIL_ID(), textMsg);
			} else {
				message = "Registration not completed! Please try again.";
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return message;
	}
	@Override
	public boolean sendMailToDealers(String checkedVehicles, IndividualOwnerRegister iowner) {
		boolean b=false;
		Statement st=null;
		ResultSet rs=null;
		Set<String> names = new HashSet<>();
		String message="The Customer is Having interest in your Authorised Vehicles.";
		message+="Name : "+iowner.getNAME()+"<br>";
		message+="Email : "+iowner.getEMAIL_ID()+"<br>";
		message+="Mobile No. :"+iowner.getMOBILE_NO();
		String carSequenceNo="",query=null;
		try
		{
			st=conn.createStatement();
			System.out.println("Checked Vehicles :: "+checkedVehicles);
			StringTokenizer stok=new StringTokenizer(checkedVehicles, ",");
			while(stok.hasMoreTokens())
			{
				names.add(stok.nextToken());
			}
			List<String> al=new ArrayList<String>(names);
			//select dealer_assigned_brands.email from add_car inner join dealer_assigned_brands on add_car.car_model = dealer_assigned_brands.model where add_car.SEQUENCE_NO in ('18','19','20','21');
	       for(int i=0;i<al.size();i++)
	        {
	    	   if(i+1==al.size())
	    	   {
					carSequenceNo+="'"+al.get(i)+"'";
	    	   }
	    	   else
	    	   {
					carSequenceNo+="'"+al.get(i)+"',";
	    	   }   
			}
//	       System.out.println("car seq No . "+carSequenceNo);
	       String[] emailids=new String[5];
	       if(iowner.getVEHICAL_TYPE().equals("4,"))
	       {
	    	   query="select dealer_assigned_brands.email from add_car inner join dealer_assigned_brands on add_car.car_model = dealer_assigned_brands.model where add_car.SEQUENCE_NO in ("+carSequenceNo+")";
	       }
	       else
	       {
	    	   query="select dealer_assigned_brands.email from add_bike inner join dealer_assigned_brands on add_bike.bike_model = dealer_assigned_brands.model where add_bike.SEQUENCE_NO in ("+carSequenceNo+")";
	       }
	       System.out.println("Query :: "+query);
	       rs=st.executeQuery(query);
	       int i=0;
	       if(rs.next())
	       {
	    	   do
	    	   {
	    	   System.out.println(rs.getString(1));
	    	   emailids[i]=rs.getString(1);
	    	   i++;
	    	   }while(rs.next());
	    	   new SendMail().sendMailToMuliple(emailids, message);
	    	   //b=true;
	       }
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return b;
	}
	
	public boolean insertUserInterestedVehicles(UserInterestedVehicles uv)
	{
		boolean b=false;
		PreparedStatement pst=null;
		String query="INSERT INTO `user_interested_vehicles_table` (`SEQ_NO`, `USER_EMAIL_ID`, `VEHICLES_SEQ_ID`, `VEHICLE_TYPE`, sysdate(), `PREFERRED_CITY`) VALUES (?, ?, ?, ?, ?, ?)";
		try
		{
			pst=conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, uv.getSEQ_NO());
			pst.setString(2, uv.getUSER_EMAIL_ID());
			pst.setString(3, uv.getVEHICLES_SEQ_ID());
			pst.setString(4, uv.getVEHICLE_TYPE());
			pst.setString(5, uv.getPREFERRED_CITY());
			
			int i=pst.executeUpdate();
			if(i>0)
			{
				b=true;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return b;
	}
}
