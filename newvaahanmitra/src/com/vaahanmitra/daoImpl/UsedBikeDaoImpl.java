package com.vaahanmitra.daoImpl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.owtelse.codec.Base64;
import com.vaahanmitra.dao.UsedBikeDao;
import com.vaahanmitra.dbutil.DBConnection;
import com.vaahanmitra.dbutil.IdGen;
import com.vaahanmitra.model.AddBike;
import com.vaahanmitra.model.UsedBike;
import com.vaahanmitra.model.UsedCar;
import com.vaahanmitra.service.BikeIdGenerator;
import com.vaahanmitra.service.CarIdGenerator;
import com.vaahanmitra.utilities.SQLDate;

public class UsedBikeDaoImpl implements UsedBikeDao {

	private Connection conn = null;
	InputStream photo1 = null, photo2 = null, photo3 = null, photo4 = null, photo5 = null, photo6 = null, photo7 = null,
			photo8 = null, photo9 = null, photo10 = null, photo11 = null, photo12 = null;

	private int noOfRecords = 0;
	
	public String addUsedBike(UsedBike usedBike, InputStream is, ArrayList<InputStream> al, String user_name) {
		String message = null;
		try {
			conn = DBConnection.getConnection();
			BikeIdGenerator bikeId = new BikeIdGenerator();
			String id = new IdGen().getId("USED_BIKE_ID");
			String bid = bikeId.generateBikeId(usedBike.getSTATE(), id);
			String query = "insert into used_bike values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CURDATE(),CURDATE())";

			String query2 = "insert into bike_photos values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			PreparedStatement pstmt = conn.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);

			for (int i = 0; i < al.size(); i++) {
				if (i == 0) {
					photo1 = al.get(i);
				} else if (i == 1) {
					photo2 = al.get(i);
				} else if (i == 2) {
					photo3 = al.get(i);
				} else if (i == 3) {
					photo4 = al.get(i);
				} else if (i == 4) {
					photo5 = al.get(i);
				} else if (i == 5) {
					photo6 = al.get(i);
				} else if (i == 6) {
					photo7 = al.get(i);
				} else if (i == 7) {
					photo8 = al.get(i);
				} else if (i == 8) {
					photo9 = al.get(i);
				} else if (i == 9) {
					photo10 = al.get(i);
				} else if (i == 10) {
					photo11 = al.get(i);
				} else if (i == 11) {
					photo12 = al.get(i);
				}
			}
			pstmt.setInt(1, usedBike.getSEQUENCE_NO());
			pstmt.setString(2, usedBike.getBIKE_NUMBER());
			pstmt.setBinaryStream(3, photo1);
			pstmt.setBinaryStream(4, photo2);
			pstmt.setBinaryStream(5, photo3);
			pstmt.setBinaryStream(6, photo4);
			pstmt.setBinaryStream(7, photo5);
			pstmt.setBinaryStream(8, photo6);
			pstmt.setBinaryStream(9, photo7);
			pstmt.setBinaryStream(10, photo8);
			pstmt.setBinaryStream(11, photo9);
			pstmt.setBinaryStream(12, photo10);
			pstmt.setBinaryStream(13, photo11);
			pstmt.setBinaryStream(14, photo12);

			int i2 = pstmt.executeUpdate();

			preparedStatement.setInt(1, usedBike.getSEQUENCE_NO());
			preparedStatement.setString(2, usedBike.getBIKE_NUMBER());
			preparedStatement.setString(3, user_name);
			preparedStatement.setString(4, usedBike.getBIKE_BRAND());
			preparedStatement.setString(5, usedBike.getBIKE_MODEL());
			preparedStatement.setString(6, usedBike.getCURRENT_MILEAGE());
			preparedStatement.setString(7, usedBike.getSTARTING_SYSTEM());
			preparedStatement.setString(8, usedBike.getFUELTANK_CAPACITY());
			preparedStatement.setString(9, usedBike.getCOLOR());
			preparedStatement.setString(10, usedBike.getINSURANCE_COMPANY_NAME());
			preparedStatement.setString(11, usedBike.getHYPOTHECATION());
			preparedStatement.setString(12, usedBike.getREGISTERED_YEAR());
			preparedStatement.setString(13, usedBike.getREGISTERED_STATE());
			preparedStatement.setString(14, usedBike.getREGISTERED_CITY());
			preparedStatement.setString(15, usedBike.getBIKE_OWNER_NAME());
			preparedStatement.setString(16, usedBike.getUSED_BY());
			preparedStatement.setInt(17, usedBike.getNO_OF_OWNERS());
			preparedStatement.setString(18, usedBike.getEMAIL_ID());
			preparedStatement.setString(19, usedBike.getMOBILE_NO());
			preparedStatement.setString(20, usedBike.getADDRESS());
			preparedStatement.setString(21, usedBike.getCITY());
			preparedStatement.setString(22, usedBike.getSTATE());
			preparedStatement.setString(23, usedBike.getDISTRICT());
			preparedStatement.setString(24, usedBike.getOFFER_PRICE());
			preparedStatement.setString(25, usedBike.getBIKE_DISCRIPTION());
			preparedStatement.setString(26, "ACTIVE");
			preparedStatement.setString(27, bid);
			preparedStatement.setString(28, usedBike.getPINCODE());
			preparedStatement.setString(29, usedBike.getKMS_DRIVEN());
			preparedStatement.setString(30, "Y");

			int i1 = preparedStatement.executeUpdate();
			if (i1 > 0 && i2 > 0) {
				message = "success";
			} else {
				message = "failure";
				conn.rollback();
			}
			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}

	public ArrayList<UsedBike> showDetails(String city, String brand, String model, String user_name, int offset,
			int noOfRecords) {

		ArrayList<UsedBike> al = new ArrayList<UsedBike>();
		System.out.println("hari"+city + brand + model + offset + noOfRecords);
		String query = null;
		conn = DBConnection.getConnection();
		Statement stmt = null;
		try {
			if(brand.equals("") && model.equals("") && city.equals(""))
			{
				query = "SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.PHOTO1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where USER_NAME='" + user_name + "' limit " + offset + ", " + noOfRecords;
			} else if (brand.equals("") && model.equals("") && !city.equals("")) {
				query = "SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.PHOTO1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where REGISTERED_CITY='"
						+ city + "' AND USER_NAME='" + user_name + "' limit " + offset + ", " + noOfRecords;
			} else if (!brand.equals("") && model.equals("") && city.equals("")) {
				query = "SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.PHOTO1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where  BIKE_BRAND='"
						+ brand + "' AND USER_NAME='" + user_name + "' limit " + offset + ", " + noOfRecords;
			} else if (!brand.equals("") && !model.equals("") && city.equals("")) {
				query = "SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.PHOTO1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where  BIKE_BRAND='"
						+ brand + "' AND BIKE_MODEL='" + model + "' AND USER_NAME='" + user_name + "' limit " + offset
						+ ", " + noOfRecords;
			} else if (!brand.equals("") && !model.equals("") && !city.equals("")) {
				query = "SELECT SQL_CALC_FOUND_ROWS used_bike.*,bike_photos.PHOTO1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER where CITY='"
						+ city + "' and BIKE_BRAND='" + brand + "' AND BIKE_MODEL='" + model + "' AND USER_NAME='"
						+ user_name + "' limit " + offset + ", " + noOfRecords;
			}
			System.out.println(query);
			stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				UsedBike ub = new UsedBike();
				ub.setSEQUENCE_NO(Integer.parseInt(rs.getString("SEQUENCE_NO")));
				ub.setBIKE_NUMBER(rs.getString("BIKE_NUMBER"));
				ub.setBIKE_BRAND(rs.getString("BIKE_BRAND"));
				ub.setBIKE_MODEL(rs.getString("BIKE_MODEL"));
				ub.setCURRENT_MILEAGE(rs.getString("CURRENT_MILEAGE"));
				ub.setSTARTING_SYSTEM(rs.getString("STARTING_SYSTEM"));
				ub.setFUELTANK_CAPACITY(rs.getString("FUELTANK_CAPACITY"));
				ub.setCOLOR(rs.getString("COLOR"));
				ub.setKMS_DRIVEN(rs.getString("KMS_DRIVEN"));
				ub.setINSURANCE_COMPANY_NAME(rs.getString("INSURANCE_COMPANY_NAME"));
				ub.setHYPOTHECATION(rs.getString("HYPOTHECATION"));
				ub.setREGISTERED_YEAR(rs.getString("REGISTERED_YEAR"));
				ub.setREGISTERED_STATE(rs.getString("REGISTERED_STATE"));
				ub.setREGISTERED_CITY(rs.getString("REGISTERED_CITY"));
				ub.setBIKE_OWNER_NAME(rs.getString("BIKE_OWNER_NAME"));
				ub.setUSED_BY(rs.getString("USED_BY"));
				ub.setNO_OF_OWNERS(Integer.parseInt(rs.getString("NO_OF_OWNERS")));
				ub.setEMAIL_ID(rs.getString("EMAIL_ID"));
				ub.setMOBILE_NO(rs.getString("MOBILE_NO"));
				ub.setADDRESS(rs.getString("ADDRESS"));
				ub.setCITY(rs.getString("CITY"));
				ub.setSTATE(rs.getString("STATE"));
				ub.setDISTRICT(rs.getString("DISTRICT"));
				ub.setPINCODE(rs.getString("PINCODE"));
				ub.setOFFER_PRICE(rs.getString("OFFER_PRICE"));
				ub.setGEN_BIKE_ID(rs.getString("GEN_BIKE_ID"));
				ub.setUPDATED_DATE(new SQLDate().getInDate(rs.getString("UPDATED_DATE")));
				ub.setSTATUS(rs.getString("STATUS"));

				java.sql.Blob blob1 = rs.getBlob("PHOTO1");
				byte[] photo1 = blob1.getBytes(1, (int) blob1.length());
				String photo10 = Base64.encode(photo1);
				ub.setPHOTO1(photo10);
				al.add(ub);

			}

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
		return al;
	}

	public UsedBike getUsedBikeDetails(String id) {

		UsedBike ub = new UsedBike();
		try {
			String sql = "Select * from used_bike where BIKE_NUMBER='" + id + "'";
			Connection conn = DBConnection.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				ub.setSEQUENCE_NO(Integer.parseInt(rs.getString("SEQUENCE_NO")));
				ub.setBIKE_NUMBER(rs.getString("BIKE_NUMBER"));
				ub.setBIKE_BRAND(rs.getString("BIKE_BRAND"));
				ub.setBIKE_MODEL(rs.getString("BIKE_MODEL"));
				ub.setCURRENT_MILEAGE(rs.getString("CURRENT_MILEAGE"));
				ub.setSTARTING_SYSTEM(rs.getString("STARTING_SYSTEM"));
				ub.setFUELTANK_CAPACITY(rs.getString("FUELTANK_CAPACITY"));
				ub.setCOLOR(rs.getString("COLOR"));
				ub.setINSURANCE_COMPANY_NAME(rs.getString("INSURANCE_COMPANY_NAME"));
				// ub.setPHOTO(rs.getBlob("PHOTO"));
				ub.setHYPOTHECATION(rs.getString("HYPOTHECATION"));
				ub.setREGISTERED_YEAR(rs.getString("REGISTERED_YEAR"));
				ub.setREGISTERED_STATE(rs.getString("REGISTERED_STATE"));
				ub.setREGISTERED_CITY(rs.getString("REGISTERED_CITY"));
				ub.setBIKE_OWNER_NAME(rs.getString("BIKE_OWNER_NAME"));
				ub.setUSED_BY(rs.getString("USED_BY"));
				ub.setNO_OF_OWNERS(Integer.parseInt(rs.getString("NO_OF_OWNERS")));
				ub.setEMAIL_ID(rs.getString("EMAIL_ID"));
				ub.setMOBILE_NO(rs.getString("MOBILE_NO"));
				ub.setADDRESS(rs.getString("ADDRESS"));
				ub.setCITY(rs.getString("CITY"));
				ub.setSTATE(rs.getString("STATE"));
				ub.setDISTRICT(rs.getString("DISTRICT"));
				ub.setOFFER_PRICE(rs.getString("OFFER_PRICE"));
				ub.setUPDATED_DATE(new SQLDate().getInDate(rs.getString("UPDATED_DATE")));
				ub.setBIKE_DISCRIPTION(rs.getString("BIKE_DISCRIPTION"));
				// java.sql.Blob blob = rs.getBlob("PHOTO");
				// byte[] photo = blob.getBytes(1, (int) blob.length());
				// String photo1 = Base64.encode(photo);
				// uc.setPHOTO(photo1);
//				System.out.println(ub);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				
				conn.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return ub;
	}

	public String updateUsedBike(UsedBike usedBike,String bikeId, String bikeNumber, String user_name) {
		conn = DBConnection.getConnection();
		String message = "";
		try {
			String sql = "UPDATE used_bike SET BIKE_BRAND=?, BIKE_MODEL=?, CURRENT_MILEAGE = ?, STARTING_SYSTEM = ?, FUELTANK_CAPACITY = ?, COLOR = ?, KMS_DRIVEN=?, REGISTERED_YEAR=?, REGISTERED_STATE=?, REGISTERED_CITY=?, BIKE_OWNER_NAME=?, USED_BY=?, NO_OF_OWNERS=?, MOBILE_NO=?, ADDRESS=?, CITY=?, STATE=?, DISTRICT=?, PINCODE=?, OFFER_PRICE=?,UPDATED_DATE=CURDATE() WHERE BIKE_NUMBER ='"+bikeNumber+"'";
			conn = DBConnection.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, usedBike.getBIKE_BRAND());
			preparedStatement.setString(2, usedBike.getBIKE_MODEL());
			preparedStatement.setString(3, usedBike.getCURRENT_MILEAGE());
			preparedStatement.setString(4, usedBike.getSTARTING_SYSTEM());
			preparedStatement.setString(5, usedBike.getFUELTANK_CAPACITY());
			preparedStatement.setString(6, usedBike.getCOLOR());
			preparedStatement.setString(7, usedBike.getKMS_DRIVEN());
			preparedStatement.setString(8, usedBike.getREGISTERED_YEAR());
			preparedStatement.setString(9, usedBike.getREGISTERED_STATE());
			preparedStatement.setString(10, usedBike.getREGISTERED_CITY());
			preparedStatement.setString(11, usedBike.getBIKE_OWNER_NAME());
			preparedStatement.setString(12, usedBike.getUSED_BY());
			preparedStatement.setInt(13, usedBike.getNO_OF_OWNERS());
			preparedStatement.setString(14, usedBike.getMOBILE_NO());
			preparedStatement.setString(15, usedBike.getADDRESS());
			preparedStatement.setString(16, usedBike.getCITY());
			preparedStatement.setString(17, usedBike.getSTATE());
			preparedStatement.setString(18, usedBike.getDISTRICT());
			preparedStatement.setString(19, usedBike.getPINCODE());
			preparedStatement.setString(20, usedBike.getOFFER_PRICE());
			int i1 = preparedStatement.executeUpdate();
			if (i1 > 0) {
				message = "success";
			} else {
				message = "failure";
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
	
	@Override
	public String showStatus(String bikeId, String status, String user_name) {

		conn = DBConnection.getConnection();
		String message = "";
		int j = 0;
		try {
			String sql = null;
			if (status.equals("ACTIVE")) {
				sql = "UPDATE used_bike SET STATUS='INACTIVE' WHERE USER_NAME ='" + user_name + "' and  GEN_BIKE_ID ='"
						+ bikeId + "'";
			} else {
				sql = "UPDATE used_bike SET STATUS='ACTIVE' WHERE USER_NAME ='" + user_name + "' and  GEN_BIKE_ID ='"
						+ bikeId + "'";
			}
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			j = preparedStatement.executeUpdate();
			if (j > 0) {
				message = "success";
			} else {
				message = "failure";
			}
		} catch (Exception e) {
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
	public Boolean getBikeNumber(String bikeNumber) {
		conn = DBConnection.getConnection();
		String existNumber = "";
		boolean success = false;
		try {
			String query = "select * from used_bike where BIKE_NUMBER='" + bikeNumber + "'";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				existNumber = rs.getString("BIKE_NUMBER");
			}
			if (existNumber.equals(bikeNumber)) {
				success = true;
			} else {
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
	public ArrayList<UsedBike> getBikeBrand() {
		ArrayList<UsedBike> bikeAl = new ArrayList<UsedBike>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select bike_brand from used_bike where bike_brand is not null group by bike_brand";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				UsedBike usedBike = new UsedBike();
				usedBike.setBIKE_BRAND(rs.getString("BIKE_BRAND"));
				bikeAl.add(usedBike);
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
		return bikeAl;
	}

	@Override
	public ArrayList<UsedBike> getBikeModel(String bikeModel,String email) {
		ArrayList<UsedBike> bikeAl = new ArrayList<UsedBike>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select bike_model from used_bike where bike_brand='" + bikeModel + "' and user_name='"+email+"' and BIKE_MODEL is not null group by bike_model";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				UsedBike usedBike = new UsedBike();
				usedBike.setBIKE_MODEL(rs.getString("BIKE_MODEL"));
				bikeAl.add(usedBike);
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
		return bikeAl;
	}

	@Override
	public ArrayList<String> getUsedBikeCity(String brand, String model, String email) {
		ArrayList<String> al = new ArrayList<String>();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT CITY FROM used_bike where BIKE_BRAND ='" + brand + "' and BIKE_MODEL = '"
	     + model + "' and USER_NAME='"+email+"' and CITY is not null group by CITY";
//			System.out.println(query);
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				al.add(rs.getString("CITY"));
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
	public UsedBike getBikeImages(String bike_number) {
		UsedBike ub = new UsedBike();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select * from bike_photos where bike_number='" + bike_number + "'";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				java.sql.Blob blob1 = rs.getBlob("PHOTO1");
				byte[] photo1 = blob1.getBytes(1, (int) blob1.length());
				String photo10 = Base64.encode(photo1);
				ub.setPHOTO1(photo10);

				java.sql.Blob blob2 = rs.getBlob("PHOTO2");
				byte[] photo2 = blob2.getBytes(1, (int) blob2.length());
				String photo20 = Base64.encode(photo2);
				ub.setPHOTO2(photo20);

				java.sql.Blob blob3 = rs.getBlob("PHOTO3");
				byte[] photo3 = blob3.getBytes(1, (int) blob3.length());
				String photo30 = Base64.encode(photo3);
				ub.setPHOTO3(photo30);

				java.sql.Blob blob4 = rs.getBlob("PHOTO4");
				byte[] photo4 = blob4.getBytes(1, (int) blob4.length());
				String photo40 = Base64.encode(photo4);
				ub.setPHOTO4(photo40);

				java.sql.Blob blob5 = rs.getBlob("PHOTO5");
				byte[] photo5 = blob5.getBytes(1, (int) blob5.length());
				String photo50 = Base64.encode(photo5);
				ub.setPHOTO5(photo50);

				java.sql.Blob blob6 = rs.getBlob("PHOTO6");
				byte[] photo6 = blob6.getBytes(1, (int) blob6.length());
				String photo60 = Base64.encode(photo6);
				ub.setPHOTO6(photo60);

				java.sql.Blob blob7 = rs.getBlob("PHOTO7");
				byte[] photo7 = blob7.getBytes(1, (int) blob7.length());
				String photo70 = Base64.encode(photo7);
				ub.setPHOTO7(photo70);

				java.sql.Blob blob8 = rs.getBlob("PHOTO8");
				byte[] photo8 = blob8.getBytes(1, (int) blob8.length());
				String photo80 = Base64.encode(photo8);
				ub.setPHOTO8(photo80);

				java.sql.Blob blob9 = rs.getBlob("PHOTO9");
				byte[] photo9 = blob9.getBytes(1, (int) blob9.length());
				String photo90 = Base64.encode(photo9);
				ub.setPHOTO9(photo90);

				java.sql.Blob blob10 = rs.getBlob("PHOTO10");
				byte[] photo101 = blob10.getBytes(1, (int) blob10.length());
				String photo100 = Base64.encode(photo101);
				ub.setPHOTO10(photo100);

				java.sql.Blob blob11 = rs.getBlob("PHOTO11");
				byte[] photo102 = blob11.getBytes(1, (int) blob11.length());
				String photo110 = Base64.encode(photo102);
				ub.setPHOTO11(photo110);

				java.sql.Blob blob12 = rs.getBlob("PHOTO12");
				byte[] photo103 = blob12.getBytes(1, (int) blob12.length());
				String photo120 = Base64.encode(photo103);
				ub.setPHOTO12(photo120);
			}
		} catch (Exception e) {
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();

			} catch (Exception e) {
			}
		}
		return ub;
	}
	@Override
	 public UsedBike getBikeDetails(String bikeId) {
	  UsedBike ub = new UsedBike();
	  try {
	   String sql = "SELECT used_bike.*,bike_photos.PHOTO1 from used_bike left join bike_photos on used_bike.BIKE_NUMBER=bike_photos.BIKE_NUMBER left join end_user_details on used_bike.GEN_BIKE_ID=end_user_details.VEHICLE_ID where used_bike.GEN_BIKE_ID='"
	     + bikeId + "'";

	   conn = DBConnection.getConnection();
	   PreparedStatement preparedStatement = conn.prepareStatement(sql);
//	   System.out.println(sql);
	   ResultSet rs = preparedStatement.executeQuery();
	   while (rs.next()) {
	    ub.setGEN_BIKE_ID(rs.getString("GEN_BIKE_ID"));
	    ub.setBIKE_NUMBER(rs.getString("BIKE_NUMBER"));
	    ub.setBIKE_BRAND(rs.getString("BIKE_BRAND"));
	    ub.setBIKE_MODEL(rs.getString("BIKE_MODEL"));
	    ub.setCURRENT_MILEAGE(rs.getString("CURRENT_MILEAGE"));
	    ub.setSTARTING_SYSTEM(rs.getString("STARTING_SYSTEM"));
	    ub.setFUELTANK_CAPACITY(rs.getString("FUELTANK_CAPACITY"));
	    ub.setKMS_DRIVEN(rs.getString("KMS_DRIVEN"));
	    ub.setCOLOR(rs.getString("COLOR"));
	    ub.setREGISTERED_YEAR(rs.getString("REGISTERED_YEAR"));
	    ub.setREGISTERED_STATE(rs.getString("REGISTERED_STATE"));
	    ub.setREGISTERED_CITY(rs.getString("REGISTERED_CITY"));
	    ub.setBIKE_OWNER_NAME(rs.getString("BIKE_OWNER_NAME"));
	    ub.setUSED_BY(rs.getString("USED_BY"));
	    ub.setNO_OF_OWNERS(Integer.parseInt(rs.getString("NO_OF_OWNERS")));
	    ub.setEMAIL_ID(rs.getString("EMAIL_ID"));
	    ub.setMOBILE_NO(rs.getString("MOBILE_NO"));
	    ub.setADDRESS(rs.getString("ADDRESS"));
	    ub.setCITY(rs.getString("CITY"));
	    ub.setSTATE(rs.getString("STATE"));
	    ub.setDISTRICT(rs.getString("DISTRICT"));
	    ub.setPINCODE(rs.getString("PINCODE"));
	    ub.setOFFER_PRICE(rs.getString("OFFER_PRICE"));
	    ub.setUPDATED_DATE(new SQLDate().getInDate(rs.getString("UPDATED_DATE")));
	    java.sql.Blob blob1 = rs.getBlob("PHOTO1");
	    byte[] photo1 = blob1.getBytes(1, (int) blob1.length());
	    String photo10 = Base64.encode(photo1);
	    ub.setPHOTO1(photo10);
	   }
	   conn.close();
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	  return ub;
	 }
	@Override
	public UsedBike getBikeOwnerDetails(String bikeId) {
		UsedBike ub = new UsedBike();
		try {
			String sql = "Select * from used_bike where GEN_BIKE_ID='" + bikeId + "'";
			conn = DBConnection.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				ub.setSEQUENCE_NO(Integer.parseInt(rs.getString("SEQUENCE_NO")));
				ub.setBIKE_NUMBER(rs.getString("BIKE_NUMBER"));
				ub.setBIKE_BRAND(rs.getString("BIKE_BRAND"));
				ub.setBIKE_MODEL(rs.getString("BIKE_MODEL"));
				ub.setCURRENT_MILEAGE(rs.getString("CURRENT_MILEAGE"));
				ub.setCOLOR(rs.getString("COLOR"));
				ub.setINSURANCE_COMPANY_NAME(rs.getString("INSURANCE_COMPANY_NAME"));
				ub.setREGISTERED_YEAR(rs.getString("REGISTERED_YEAR"));
				ub.setREGISTERED_STATE(rs.getString("REGISTERED_STATE"));
				ub.setREGISTERED_CITY(rs.getString("REGISTERED_CITY"));
				ub.setBIKE_OWNER_NAME(rs.getString("BIKE_OWNER_NAME"));
				ub.setUSED_BY(rs.getString("USED_BY"));
				ub.setNO_OF_OWNERS(Integer.parseInt(rs.getString("NO_OF_OWNERS")));
				ub.setEMAIL_ID(rs.getString("EMAIL_ID"));
				ub.setMOBILE_NO(rs.getString("MOBILE_NO"));
				ub.setADDRESS(rs.getString("ADDRESS"));
				ub.setCITY(rs.getString("CITY"));
				ub.setSTATE(rs.getString("STATE"));
				ub.setDISTRICT(rs.getString("DISTRICT"));
				ub.setOFFER_PRICE(rs.getString("OFFER_PRICE"));
				ub.setUPDATED_DATE(new SQLDate().getInDate(rs.getString("UPDATED_DATE")));

//				java.sql.Blob blob = rs.getBlob("PHOTO1");
//				byte[] photo = blob.getBytes(1, (int) blob.length());
//				String photo1 = Base64.encode(photo);
//				ub.setPHOTO1(photo1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();

			} catch (Exception e) {
			}
		}
		return ub;
	}
	public ArrayList<UsedBike> getBikeId(String email) {
		Connection conn = null;
		ArrayList<UsedBike> bikeAl = new ArrayList<UsedBike>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT GEN_BIKE_ID from used_bike where USER_NAME='" + email
					+ "' and status='ACTIVE' AND AVAILABLE='Y'";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				UsedBike usedBike = new UsedBike();
				usedBike.setGEN_BIKE_ID(rs.getString("GEN_BIKE_ID"));
				bikeAl.add(usedBike);
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
		return bikeAl;
	}
	
	public int getNoOfRecords() {
		return noOfRecords;
	}

	@Override
	public ArrayList<UsedBike> getBikeBrands(String email) {
		ArrayList<UsedBike> bikeAl = new ArrayList<UsedBike>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select bike_brand from used_bike where user_name='"+email+"' and bike_brand is not null group by bike_brand";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				UsedBike bike = new UsedBike();
				bike.setBIKE_BRAND(rs.getString("BIKE_BRAND"));
				bikeAl.add(bike);
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
		return bikeAl;
	}

	@Override
	public ArrayList<UsedBike> getBikeModel(String bikeModel) {
		ArrayList<UsedBike> bikeAl = new ArrayList<UsedBike>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select bike_model from used_bike where bike_brand='" + bikeModel + "' and BIKE_MODEL is not null group by bike_model";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				UsedBike usedBike = new UsedBike();
				usedBike.setBIKE_MODEL(rs.getString("BIKE_MODEL"));
				bikeAl.add(usedBike);
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
		return bikeAl;
	}

	@Override
	public HashMap<String, String> addDelaerUsedBike(UsedBike usedBike, InputStream is, ArrayList<InputStream> al,
			String user_name) {
		HashMap<String, String> msgBikeId = new HashMap<String, String>();
		try {
			conn = DBConnection.getConnection();
			BikeIdGenerator carId = new BikeIdGenerator();
			String id = new IdGen().getId("USED_BIKE_ID");
			String bid = carId.generateBikeId(usedBike.getSTATE(), id);
			String query = "insert into used_bike values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CURDATE(),CURDATE())";

			String query2 = "insert into bike_photos values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			PreparedStatement pstmt = conn.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);

			for (int i = 0; i < al.size(); i++) {
				if (i == 0) {
					photo1 = al.get(i);
				} else if (i == 1) {
					photo2 = al.get(i);
				} else if (i == 2) {
					photo3 = al.get(i);
				} else if (i == 3) {
					photo4 = al.get(i);
				} else if (i == 4) {
					photo5 = al.get(i);
				} else if (i == 5) {
					photo6 = al.get(i);
				} else if (i == 6) {
					photo7 = al.get(i);
				} else if (i == 7) {
					photo8 = al.get(i);
				} else if (i == 8) {
					photo9 = al.get(i);
				} else if (i == 9) {
					photo10 = al.get(i);
				} else if (i == 10) {
					photo11 = al.get(i);
				} else if (i == 11) {
					photo12 = al.get(i);
				}
			}
			pstmt.setInt(1, usedBike.getSEQUENCE_NO());
			pstmt.setString(2, usedBike.getBIKE_NUMBER());
			pstmt.setBinaryStream(3, photo1);
			pstmt.setBinaryStream(4, photo2);
			pstmt.setBinaryStream(5, photo3);
			pstmt.setBinaryStream(6, photo4);
			pstmt.setBinaryStream(7, photo5);
			pstmt.setBinaryStream(8, photo6);
			pstmt.setBinaryStream(9, photo7);
			pstmt.setBinaryStream(10, photo8);
			pstmt.setBinaryStream(11, photo9);
			pstmt.setBinaryStream(12, photo10);
			pstmt.setBinaryStream(13, photo11);
			pstmt.setBinaryStream(14, photo12);

			int i2 = pstmt.executeUpdate();

			preparedStatement.setInt(1, usedBike.getSEQUENCE_NO());
			preparedStatement.setString(2, usedBike.getBIKE_NUMBER());
			preparedStatement.setString(3, user_name);
			preparedStatement.setString(4, usedBike.getBIKE_BRAND());
			preparedStatement.setString(5, usedBike.getBIKE_MODEL());
			preparedStatement.setString(6, usedBike.getCURRENT_MILEAGE());
			preparedStatement.setString(7, usedBike.getSTARTING_SYSTEM());
			preparedStatement.setString(8, usedBike.getFUELTANK_CAPACITY());
			preparedStatement.setString(9, usedBike.getCOLOR());
			preparedStatement.setString(10, usedBike.getINSURANCE_COMPANY_NAME());
			preparedStatement.setString(11, usedBike.getHYPOTHECATION());
			preparedStatement.setString(12, usedBike.getREGISTERED_YEAR());
			preparedStatement.setString(13, usedBike.getREGISTERED_STATE());
			preparedStatement.setString(14, usedBike.getREGISTERED_CITY());
			preparedStatement.setString(15, usedBike.getBIKE_OWNER_NAME());
			preparedStatement.setString(16, usedBike.getUSED_BY());
			preparedStatement.setInt(17, usedBike.getNO_OF_OWNERS());
			preparedStatement.setString(18, usedBike.getEMAIL_ID());
			preparedStatement.setString(19, usedBike.getMOBILE_NO());
			preparedStatement.setString(20, usedBike.getADDRESS());
			preparedStatement.setString(21, usedBike.getCITY());
			preparedStatement.setString(22, usedBike.getSTATE());
			preparedStatement.setString(23, usedBike.getDISTRICT());
			preparedStatement.setString(24, usedBike.getOFFER_PRICE());
			preparedStatement.setString(25, usedBike.getBIKE_DISCRIPTION());
			preparedStatement.setString(26, "ACTIVE");
			preparedStatement.setString(27, bid);
			preparedStatement.setString(28, usedBike.getPINCODE());
			preparedStatement.setString(29, usedBike.getKMS_DRIVEN());
			preparedStatement.setString(30, "Y");
			preparedStatement.setString(31, usedBike.getVARIANT_NAME());
			
			int i1 = preparedStatement.executeUpdate();
			if (i1 > 0 && i2 > 0) {
				msgBikeId.put("message", "success");
				msgBikeId.put("bikeId", bid);
			} else {
				msgBikeId.put("message", "failure");
				msgBikeId.put("bikeId", bid);
				conn.rollback();
			}
			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return msgBikeId;
	}

	@Override
	public ArrayList<UsedBike> getBikeNo(String email) {
		Connection conn = null;
		ArrayList<UsedBike> bikeAl = new ArrayList<UsedBike>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT BIKE_NUMBER from used_bike where USER_NAME='"+email+"'";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				UsedBike usedBike = new UsedBike();
				usedBike.setBIKE_NUMBER(rs.getString("BIKE_NUMBER"));
				bikeAl.add(usedBike);
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
		return bikeAl;
	}

	@Override
	public String updateBikePhotos(String bikeNo, InputStream is, ArrayList<InputStream> al) {
		String message = null;
		try {
			conn = DBConnection.getConnection();
			String query = "UPDATE bike_photos SET PHOTO1=?,PHOTO2=?,PHOTO3=?,PHOTO4=?,PHOTO5=?,PHOTO6=?,PHOTO7=?,PHOTO8=?,PHOTO9=?,PHOTO10=? WHERE BIKE_NUMBER ='"+bikeNo+"'";
			PreparedStatement pstmt = conn.prepareStatement(query);
			for (int i = 0; i < al.size(); i++) {
				if (i == 0) {
					photo1 = al.get(i);
				} else if (i == 1) {
					photo2 = al.get(i);
				} else if (i == 2) {
					photo3 = al.get(i);
				} else if (i == 3) {
					photo4 = al.get(i);
				} else if (i == 4) {
					photo5 = al.get(i);
				} else if (i == 5) {
					photo6 = al.get(i);
				} else if (i == 6) {
					photo7 = al.get(i);
				} else if (i == 7) {
					photo8 = al.get(i);
				} else if (i == 8) {
					photo9 = al.get(i);
				} else if (i == 9) {
					photo10 = al.get(i);
				} else if (i == 10) {
					photo11 = al.get(i);
				} else if (i == 11) {
					photo12 = al.get(i);
				}
			}
			pstmt.setBinaryStream(1, photo1);
			pstmt.setBinaryStream(2, photo2);
			pstmt.setBinaryStream(3, photo3);
			pstmt.setBinaryStream(4, photo4);
			pstmt.setBinaryStream(5, photo5);
			pstmt.setBinaryStream(6, photo6);
			pstmt.setBinaryStream(7, photo7);
			pstmt.setBinaryStream(8, photo8);
			pstmt.setBinaryStream(9, photo9);
			pstmt.setBinaryStream(10, photo10);

			System.out.println(query);
			int i = pstmt.executeUpdate();
			if (i > 0 ) {
				message = "success";
			} else {
				message = "failure";
			}
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}
}
