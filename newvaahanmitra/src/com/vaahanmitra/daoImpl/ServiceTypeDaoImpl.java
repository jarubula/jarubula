package com.vaahanmitra.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.vaahanmitra.dao.ServiceTypeDao;
import com.vaahanmitra.dbutil.DBConnection;
import com.vaahanmitra.dbutil.IdGen;
import com.vaahanmitra.model.ServiceType;
import com.vaahanmitra.utilities.ServiceCenterId;

public class ServiceTypeDaoImpl implements ServiceTypeDao {

	private Connection conn = DBConnection.getConnection();
	private int noOfRecords = 0;
	public String addServicetype(ServiceType serviceType, String emailId) {
		PreparedStatement preparedStatement = null, pstmt = null;
		String message = null;
		String query1 = null,query2 = null;
		try {
			conn = DBConnection.getConnection();
			String id1 = new IdGen().getId("SERVICECENTER_ID");
			ServiceCenterId sci = new ServiceCenterId();
			String scId = sci.serviceCenterId(id1);
			query1 = "insert into service_type values (?,?,?,?,?,?,?,?)";
			query2 = "insert into update_service_price values(?,?,?,?,?,?,?)";
			preparedStatement = conn.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
			pstmt = conn.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, serviceType.getSEQ_SERVICE_ID());
			preparedStatement.setString(2, serviceType.getSERVICE_ID());
			preparedStatement.setString(3, serviceType.getSERVICE_TYPE());
			preparedStatement.setString(4, serviceType.getSERVICE_DESCRIPTION());
			preparedStatement.setString(5, emailId);
			preparedStatement.setString(6, serviceType.getVEHICLE_TYPE());
			preparedStatement.setString(7, serviceType.getVEHICLE_BRAND());
			preparedStatement.setString(8, scId);
			
			pstmt.setInt(1, serviceType.getSEQ_SERVICE_ID());
			pstmt.setString(2, serviceType.getSERVICE_ID());
			pstmt.setString(3, serviceType.getSERVICE_TYPE());
			pstmt.setString(4, "0");
			pstmt.setString(5, "0");
			pstmt.setString(6, "0");
			pstmt.setString(7, scId);
			
			int i = preparedStatement.executeUpdate();
			int j = pstmt.executeUpdate();

			if (i > 0 && j > 0) {
				message = "ServiceType added successfully...";
			} else {
				message = "ServiceType not added! please try again";
				conn.rollback();
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

	public ArrayList<ServiceType> viewAllServices(int offset, int noOfRecords, String email) {
		ArrayList<ServiceType> ast = new ArrayList<ServiceType>();
		ResultSet rs = null;
		Statement stmt = null;
		String sqlQuery = "SELECT SQL_CALC_FOUND_ROWS service_type.*,update_service_price.* from service_type left join update_service_price on service_type.SERVICE_CENTER_ID=update_service_price.SERVICE_CENTER_ID where EMAIL_ID='"
				+ email + "' limit " + offset + ", " + noOfRecords;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlQuery);
			while (rs.next()) {
				ServiceType serviceType1 = new ServiceType();
				serviceType1.setSEQ_SERVICE_ID(rs.getInt("SEQ_SERVICE_ID"));
				serviceType1.setSERVICE_ID(rs.getString("SERVICE_ID"));
				serviceType1.setSERVICE_TYPE(rs.getString("SERVICE_TYPE"));
				serviceType1.setSERVICE_DESCRIPTION(rs.getString("SERVICE_DESCRIPTION"));
				serviceType1.setPRICE(rs.getString("PRICE"));
				serviceType1.setDISCOUNT(rs.getString("DISCOUNT"));
				serviceType1.setFINAL_PRICE(rs.getString("FINAL_PRICE"));
				serviceType1.setSERVICE_CENTER_ID(rs.getString("SERVICE_CENTER_ID"));
				ast.add(serviceType1);
			}
			rs.close();

			rs = stmt.executeQuery("SELECT FOUND_ROWS()");
			if (rs.next())
				this.noOfRecords = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ast;

	}

	public int getNoOfRecords() {
		return noOfRecords;
	}

	@Override
	public Set<ServiceType> getServiceId(String email) {
		Set<ServiceType> serviceId = new HashSet<ServiceType>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT SERVICE_ID FROM service_type where EMAIL_ID='" + email + "' group by SERVICE_ID";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				ServiceType serviceType = new ServiceType();
				serviceType.setSERVICE_ID(rs.getString("SERVICE_ID"));
				serviceId.add(serviceType);
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
		return serviceId;
	}

	@Override
	public ArrayList<ServiceType> getServices(String email, String serviceId) {
		ArrayList<ServiceType> al = new ArrayList<ServiceType>();
		Statement stmt = null;
		String query = null;
		conn = DBConnection.getConnection();
		try {
			if (serviceId.equals("All")) {
				query = "SELECT service_type.*,update_service_price.* from service_type left join update_service_price on service_type.SERVICE_CENTER_ID=update_service_price.SERVICE_CENTER_ID where EMAIL_ID='"
						+ email + "'";
			} else {
				query = "SELECT service_type.*,update_service_price.* from service_type left join update_service_price on service_type.SERVICE_CENTER_ID=update_service_price.SERVICE_CENTER_ID where EMAIL_ID='"
						+ email + "' and service_type.SERVICE_ID='" + serviceId + "'";
			}
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				ServiceType serviceType = new ServiceType();
				serviceType.setSERVICE_ID(rs.getString("SERVICE_ID"));
				serviceType.setSERVICE_TYPE(rs.getString("SERVICE_TYPE"));
				serviceType.setVEHICLE_TYPE(rs.getString("VEHICLE_TYPE"));
				serviceType.setVEHICLE_BRAND(rs.getString("VEHICLE_BRAND"));
				serviceType.setPRICE(rs.getString("PRICE"));
				serviceType.setFINAL_PRICE(rs.getString("FINAL_PRICE"));
				serviceType.setDISCOUNT(rs.getString("DISCOUNT"));
				serviceType.setSERVICE_DESCRIPTION(rs.getString("SERVICE_DESCRIPTION"));
				al.add(serviceType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return al;
	}

	@Override
	public String verifyServiceId(String serviceId, String emailId,String vehicleType) {
		String existServiceId = null,message = "no";
		try {
			String query = "select SERVICE_ID from service_type where EMAIL_ID='" + emailId + "'";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				existServiceId = rs.getString("SERVICE_ID");
//				dbVehicleType = rs.getString("VEHICLE_TYPE");
			}
			if (serviceId.equals(existServiceId)) {
				message = "Service ID aleredy avilable with you. Please enter different Service ID";
			}else{
				message = "no";
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
}