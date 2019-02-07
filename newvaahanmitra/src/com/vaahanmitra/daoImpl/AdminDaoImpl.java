package com.vaahanmitra.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.owtelse.codec.Base64;
import com.vaahanmitra.dao.AdminDao;
import com.vaahanmitra.dbutil.DBConnection;
import com.vaahanmitra.model.DealerAuthentication;
import com.vaahanmitra.model.DriverBean;

public class AdminDaoImpl implements AdminDao {

	private int noOfRecords = 0;
	Connection conn = DBConnection.getConnection();
	/*@Override
	public ArrayList<DriverBean> getDriverDetails(String fdate, String tdate, int offset,int noOfRecords) {
		ArrayList<DriverBean> al = new ArrayList<DriverBean>();
		PreparedStatement preparedStatement = null;
		try {
			String query = null;
			conn = DBConnection.getConnection();
			if (fdate == "" && tdate == "") {
				query = "SELECT SQL_CALC_FOUND_ROWS * from add_driver limit " + offset + ", " + noOfRecords ;
			} else if (fdate != null && tdate == "") {
				query = "SELECT SQL_CALC_FOUND_ROWS * from add_driver WHERE REGISTERED_DATE='" + fdate + "' limit " + offset + ", " + noOfRecords;
			} else if (fdate != null && tdate != null) {
				query = "SELECT SQL_CALC_FOUND_ROWS * from end_user_details WHERE (REGISTERED_DATE BETWEEN '"+ fdate + "' AND '" + tdate + "') limit " + offset + ", " + noOfRecords;
			}
			preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				DriverBean bean = new DriverBean();
				bean.setFIRST_NAME(rs.getString("FIRST_NAME"));
				bean.setLAST_NAME(rs.getString("LAST_NAME"));
				bean.setEMAIL(rs.getString("EMAIL"));
				bean.setMOBILE_NO(rs.getString("MOBILE_NO"));
				bean.setDOB(rs.getString("DOB"));
				bean.setADDRESS(rs.getString("ADDRESS"));
				bean.setSTREET(rs.getString("STREET"));
				bean.setCITY(rs.getString("CITY"));
				bean.setSTATE(rs.getString("STATE"));
				bean.setDISTRICT(rs.getString("DISTRICT"));
				bean.setMANDAL(rs.getString("MANDAL"));
				bean.setREGISTERED_STATE(rs.getString("REGISTERED_STATE"));
				bean.setLICENSE_NO(rs.getString("LICENSE_NO"));
				bean.setLICENSE_TYPE(rs.getString("LICENSE_TYPE"));
				bean.setEXPIRY_DATE(rs.getString("EXPIRY_DATE"));
				bean.setDRIVING_EXP(rs.getString("DRIVING_EXP"));
				bean.setPERMIT_TYPE(rs.getString("PERMIT_TYPE"));
				bean.setWITHIN_RANGE(rs.getString("WITHIN_RANGE"));
				bean.setADHAR_NO(rs.getString("ADHAR_NO"));
				bean.setPAN_NO(rs.getString("PAN_NO"));
				bean.setDRIVER_ID(rs.getString("DRIVER_ID"));
				bean.setJOB_TYPE(rs.getString("JOB_TYPE"));
				bean.setDRIVER_AVAILABILITY(rs.getString("STATUS"));
				bean.setREGISTERED_DATE(rs.getString("REGISTERED_DATE"));
				al.add(bean);
			}
			rs = preparedStatement.executeQuery("SELECT FOUND_ROWS()");
			if (rs.next())
				this.noOfRecords = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return al;
	}*/
	@Override
	public ArrayList<DriverBean> getDriverDetails(String fdate, String tdate) {
		ArrayList<DriverBean> al = new ArrayList<DriverBean>();
		PreparedStatement preparedStatement = null;
		try {
			String query = null;
			conn = DBConnection.getConnection();
			if (fdate == "" && tdate == "") {
				query = "SELECT * from add_driver";
			} else if (fdate != null && tdate == "") {
				query = "SELECT * from add_driver WHERE REGISTERED_DATE='"+fdate+"'";
			} else if (fdate != null && tdate != null) {
				query = "SELECT * from add_driver WHERE (REGISTERED_DATE BETWEEN '"+fdate+"' AND '"+tdate+"')";
			}
			preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				DriverBean bean = new DriverBean();
				bean.setFIRST_NAME(rs.getString("FIRST_NAME"));
				bean.setLAST_NAME(rs.getString("LAST_NAME"));
				bean.setEMAIL(rs.getString("EMAIL"));
				bean.setMOBILE_NO(rs.getString("MOBILE_NO"));
				bean.setDOB(rs.getString("DOB"));
				bean.setADDRESS(rs.getString("ADDRESS"));
				bean.setSTREET(rs.getString("STREET"));
				bean.setCITY(rs.getString("CITY"));
				bean.setSTATE(rs.getString("STATE"));
				bean.setDISTRICT(rs.getString("DISTRICT"));
				bean.setMANDAL(rs.getString("MANDAL"));
				bean.setREGISTERED_STATE(rs.getString("REGISTERED_STATE"));
				bean.setLICENSE_NO(rs.getString("LICENSE_NO"));
				bean.setLICENSE_TYPE(rs.getString("LICENSE_TYPE"));
				bean.setEXPIRY_DATE(rs.getString("EXPIRY_DATE"));
				bean.setDRIVING_EXP(rs.getString("DRIVING_EXP"));
				bean.setPERMIT_TYPE(rs.getString("PERMIT_TYPE"));
				bean.setWITHIN_RANGE(rs.getString("WITHIN_RANGE"));
				bean.setADHAR_NO(rs.getString("ADHAR_NO"));
				bean.setPAN_NO(rs.getString("PAN_NO"));
				bean.setDRIVER_ID(rs.getString("DRIVER_ID"));
				bean.setJOB_TYPE(rs.getString("JOB_TYPE"));
				bean.setDRIVER_AVAILABILITY(rs.getString("STATUS"));
				bean.setREGISTERED_DATE(rs.getString("REGISTERED_DATE"));
				al.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return al;
	}
	@Override
	public int getNoOfRecords() {
		return noOfRecords;
	}
	@Override
	public String activeIncative(String driverId,String status,String drEmail) {
		conn = DBConnection.getConnection();
		String message = "";
		int j = 0,k=0;
		try {
			String sql1 = null;
			String sql2 = null;
			if (status.equals("ACTIVE")) {
				sql1 = "UPDATE USER_LOGIN SET STATUS='INACTIVE' WHERE EMAIL_ID ='"+drEmail+"'";
				sql2 = "UPDATE add_driver SET STATUS='INACTIVE' WHERE DRIVER_ID ='"+driverId+"'";
			} else {
				sql1 = "UPDATE USER_LOGIN SET STATUS='ACTIVE' WHERE EMAIL_ID ='"+drEmail+"'";
				sql2 = "UPDATE add_driver SET STATUS='ACTIVE' WHERE DRIVER_ID ='"+driverId+"'";
			}
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			j = pstmt1.executeUpdate();
			k = pstmt2.executeUpdate();
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
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<DealerAuthentication> getDealerDocumets(String emailId) {
		ArrayList<DealerAuthentication> al = new ArrayList<DealerAuthentication>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select * from dealer_authentication where DEALER_NAME='"+emailId+"'";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				DealerAuthentication da = new DealerAuthentication();
				da.setDEALER_NAME(rs.getString("DEALER_NAME"));
				da.setBRAND_NAME(rs.getString("BRAND_NAME"));
				da.setDOCUMENT_NAME(rs.getString("DOCUMENT_NAME"));
				da.setDEALER_AUTHENTICATION(rs.getString("DEALER_AUTHENTICATION"));
				java.sql.Blob blob1 = rs.getBlob("FILE");
				byte[] photo1 = blob1.getBytes(1, (int) blob1.length());
				String photo10 = Base64.encode(photo1);
				da.setFILE(photo10);
				al.add(da);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return al;
	}
	@Override
	public String dealerFeedback(String acceptance, String dEmail) {
		String message="";
		PreparedStatement pst=null;
		String query = null;
		try{
			if(acceptance.equals("Yes")){
				query = "update dealer_authentication set DEALER_AUTHENTICATION='"+acceptance+"',STATUS='A' where DEALER_NAME='"+dEmail+"'";
			}else{
				query = "update dealer_authentication set DEALER_AUTHENTICATION='"+acceptance+"',STATUS='P' where DEALER_NAME='"+dEmail+"'";
			}
			conn=DBConnection.getConnection();
			pst=conn.prepareStatement(query);
			int i=pst.executeUpdate();
			if(i>0){
				message = "success";
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				pst.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return message;
	}
}
