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
import com.vaahanmitra.dao.UsedCarDao;
import com.vaahanmitra.dbutil.DBConnection;
import com.vaahanmitra.dbutil.IdGen;
import com.vaahanmitra.model.UsedCar;
import com.vaahanmitra.service.CarIdGenerator;

public class UsedCarDaoImpl implements UsedCarDao {

	private Connection conn = DBConnection.getConnection();
	InputStream photo1 = null, photo2 = null, photo3 = null, photo4 = null, photo5 = null, photo6 = null, photo7 = null,
			photo8 = null, photo9 = null, photo10 = null, photo11 = null, photo12 = null;

	private int noOfRecords = 0;

	@Override
	public ArrayList<UsedCar> showDetails(String city, String brand, String model, String user_name, int offset,int noOfRecords) {
		ArrayList<UsedCar> al = new ArrayList<UsedCar>();
		Statement stmt = null;
		String query = null;
		conn = DBConnection.getConnection();
		try {
			if(brand.equals("") && model.equals("") && city.equals(""))
			{
				query = "SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.PHOTO1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where USER_NAME='" + user_name + "' limit " + offset + ", " + noOfRecords;
			} else if (brand.equals("") && model.equals("") && !city.equals("")) {
				query = "SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.PHOTO1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where REGISTERED_CITY='"
						+ city + "' AND USER_NAME='" + user_name + "' limit " + offset + ", " + noOfRecords;
			} else if (!brand.equals("") && model.equals("") && city.equals("")) {
				query = "SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.PHOTO1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  CAR_BRAND='"
						+ brand + "' AND USER_NAME='" + user_name + "' limit " + offset + ", " + noOfRecords;
			} else if (!brand.equals("") && !model.equals("") && city.equals("")) {
				query = "SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.PHOTO1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where  CAR_BRAND='"
						+ brand + "' AND CAR_MODEL='" + model + "' AND USER_NAME='" + user_name + "' limit " + offset
						+ ", " + noOfRecords;
			} else if (!brand.equals("") && !model.equals("") && !city.equals("")) {
				query = "SELECT SQL_CALC_FOUND_ROWS used_car.*,car_photos.PHOTO1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER where CITY='"
						+ city + "' and CAR_BRAND='" + brand + "' AND CAR_MODEL='" + model + "' AND USER_NAME='"
						+ user_name + "' limit " + offset + ", " + noOfRecords;
			}
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				UsedCar uc = new UsedCar();
				uc.setSEQUENCE_NO(Integer.parseInt(rs.getString("SEQUENCE_NO")));
				uc.setCAR_NUMBER(rs.getString("CAR_NUMBER"));
				uc.setCAR_BRAND(rs.getString("CAR_BRAND"));
				uc.setCAR_MODEL(rs.getString("CAR_MODEL"));
				uc.setCURRENT_MILEAGE(rs.getString("CURRENT_MILEAGE"));
				uc.setFUEL_TYPE(rs.getString("FUEL_TYPE"));
				uc.setKMS_DRIVEN(rs.getString("KMS_DRIVEN"));
				uc.setTRANSIMISSION(rs.getString("TRANSMISSION"));
				uc.setCOLOR(rs.getString("COLOR"));
				uc.setINSURANCE(rs.getString("INSURANCE"));
				uc.setREGISTERED_YEAR(rs.getString("REGISTERED_YEAR"));
				uc.setREGISTERED_STATE(rs.getString("REGISTERED_STATE"));
				uc.setREGISTERED_CITY(rs.getString("REGISTERED_CITY"));
				uc.setCAR_OWNER_NAME(rs.getString("CAR_OWNER_NAME"));
				uc.setUSED_BY(rs.getString("USED_BY"));
				uc.setNO_OF_OWNERS(Integer.parseInt(rs.getString("NO_OF_OWNERS")));
				uc.setEMAIL_ID(rs.getString("EMAIL_ID"));
				uc.setMOBILE_NO(rs.getString("MOBILE_NO"));
				uc.setADDRESS(rs.getString("ADDRESS"));
				uc.setMODEL_YEAR(rs.getString("MODEL_YEAR"));
				uc.setCITY(rs.getString("CITY"));
				uc.setSTATE(rs.getString("STATE"));
				uc.setDISTRICT(rs.getString("DISTRICT"));
				uc.setOFFER_PRICE(rs.getString("OFFER_PRICE"));
				uc.setUPDATED_DATE(rs.getString("UPDATED_DATE"));
				uc.setGEN_CAR_ID(rs.getString("GEN_CAR_ID"));
				uc.setSTATUS(rs.getString("STATUS"));

				java.sql.Blob blob1 = rs.getBlob("PHOTO1");
				byte[] photo1 = blob1.getBytes(1, (int) blob1.length());
				String photo10 = Base64.encode(photo1);
				uc.setPHOTO1(photo10);
				al.add(uc);
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
			
	public UsedCar getUsedCarDetails(String id) {
		
		UsedCar uc = new UsedCar();
		try {
		String sql="Select * from used_car where SEQUENCE_NO='"+id+"'";
	        Connection conn = DBConnection.getConnection();
	        PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				uc.setSEQUENCE_NO(Integer.parseInt(rs.getString("SEQUENCE_NO")));
				uc.setCAR_NUMBER(rs.getString("CAR_NUMBER"));
				uc.setCAR_BRAND(rs.getString("CAR_BRAND"));
				uc.setCAR_MODEL(rs.getString("CAR_MODEL"));
				uc.setCURRENT_MILEAGE(rs.getString("CURRENT_MILEAGE"));
				uc.setFUEL_TYPE(rs.getString("FUEL_TYPE"));
				uc.setTRANSIMISSION(rs.getString("TRANSMISSION"));
				uc.setCOLOR(rs.getString("COLOR"));
				uc.setINSURANCE(rs.getString("INSURANCE"));
				uc.setREGISTERED_YEAR(rs.getString("REGISTERED_YEAR"));
				uc.setREGISTERED_STATE(rs.getString("REGISTERED_STATE"));
				uc.setREGISTERED_CITY(rs.getString("REGISTERED_CITY"));
				uc.setCAR_OWNER_NAME(rs.getString("CAR_OWNER_NAME"));
				uc.setUSED_BY(rs.getString("USED_BY"));
				uc.setNO_OF_OWNERS(Integer.parseInt(rs.getString("NO_OF_OWNERS")));
				uc.setEMAIL_ID(rs.getString("EMAIL_ID"));
				uc.setMOBILE_NO(rs.getString("MOBILE_NO"));
				uc.setADDRESS(rs.getString("ADDRESS"));
				uc.setCITY(rs.getString("CITY"));
				uc.setSTATE(rs.getString("STATE"));
				uc.setDISTRICT(rs.getString("DISTRICT"));
				uc.setOFFER_PRICE(rs.getString("OFFER_PRICE"));

//				java.sql.Blob blob = rs.getBlob("PHOTO");
//				byte[] photo = blob.getBytes(1, (int) blob.length());
//				String photo1 = Base64.encode(photo);
//				uc.setPHOTO(photo1);
				
			}	
			} catch (Exception e) {
				e.printStackTrace();
			}	
			return uc;
	}

	public String updateUsedCar(UsedCar usedCar,/* InputStream is, ArrayList<InputStream> al,*/ String carId,
			String carNumber, String user_name) {

		conn = DBConnection.getConnection();
		String message = "";
		try {
			String sql = "UPDATE used_car SET CAR_BRAND=?, CAR_MODEL=?, CURRENT_MILEAGE = ?, FUEL_TYPE = ?, TRANSMISSION = ?, KMS_DRIVEN=?,COLOR = ?, INSURANCE=?,CERTIFIED_COMPANY_NAME=?, MODEL_YEAR=?, REGISTERED_YEAR=?, REGISTERED_STATE=?, REGISTERED_CITY=?,BODY_TYPE=?, CAR_OWNER_NAME=?, USED_BY=?, NO_OF_OWNERS=?, EMAIL_ID=?,MOBILE_NO=?,ADDRESS=?,CITY=?,STATE=?,DISTRICT=?,OFFER_PRICE=?,PINCODE=?,UPDATED_DATE=CURDATE() WHERE CAR_NUMBER='"
					+ carNumber + "' and user_name='" + user_name + "'";

			conn = DBConnection.getConnection();
			/*String query2 = "update car_photos set PHOTO1=?,PHOTO2=?,PHOTO3=?,PHOTO4=?,PHOTO5=?,PHOTO6=?,PHOTO7=?,PHOTO8=?,PHOTO9=?,PHOTO10=?,PHOTO11=?,PHOTO12=? WHERE CAR_NUMBER='"
					+ usedCar.getCAR_NUMBER() + "'";*/

			/*PreparedStatement pstmt = conn.prepareStatement(sql);
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
			pstmt.setBinaryStream(11, photo11);
			pstmt.setBinaryStream(12, photo12);

			int i2 = pstmt.executeUpdate();*/
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, usedCar.getCAR_BRAND());
			preparedStatement.setString(2, usedCar.getCAR_MODEL());
			preparedStatement.setString(3, usedCar.getCURRENT_MILEAGE());
			preparedStatement.setString(4, usedCar.getFUEL_TYPE());
			preparedStatement.setString(5, usedCar.getTRANSIMISSION());
			preparedStatement.setString(6, usedCar.getKMS_DRIVEN());
			preparedStatement.setString(7, usedCar.getCOLOR());
			preparedStatement.setString(8, usedCar.getINSURANCE());
			preparedStatement.setString(9, usedCar.getCERTIFIED_COMPANY_NAME());
			preparedStatement.setString(10, usedCar.getMODEL_YEAR());
			preparedStatement.setString(11, usedCar.getREGISTERED_YEAR());
			preparedStatement.setString(12, usedCar.getREGISTERED_STATE());
			preparedStatement.setString(13, usedCar.getREGISTERED_CITY());
			preparedStatement.setString(14, usedCar.getBODY_TYPE());
			preparedStatement.setString(15, usedCar.getCAR_OWNER_NAME());
			preparedStatement.setString(16, usedCar.getUSED_BY());
			preparedStatement.setInt(17, usedCar.getNO_OF_OWNERS());
			preparedStatement.setString(18, usedCar.getEMAIL_ID());
			preparedStatement.setString(19, usedCar.getMOBILE_NO());
			preparedStatement.setString(20, usedCar.getADDRESS());
			preparedStatement.setString(21, usedCar.getCITY());
			preparedStatement.setString(22, usedCar.getSTATE());
			preparedStatement.setString(23, usedCar.getDISTRICT());
			preparedStatement.setString(24, usedCar.getOFFER_PRICE());
			preparedStatement.setString(25, usedCar.getPINCODE());
			// preparedStatement.setString(28, usedCar.getSELLER_TYPE());
			int i1 = preparedStatement.executeUpdate();
			if (i1 > 0) {
				message = "success";
			} else {
				message = "failure";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	public String showStatus(String carId, String status, String user_name) {

		conn = DBConnection.getConnection();
		String message = "";
		int j = 0;
		try {
			String sql = null;
			if (status.equals("ACTIVE")) {
				sql = "UPDATE used_car SET STATUS='INACTIVE' WHERE USER_NAME ='" + user_name + "' and  GEN_CAR_ID ='"
						+ carId + "'";
			} else {
				sql = "UPDATE used_car SET STATUS='ACTIVE' WHERE USER_NAME ='" + user_name + "' and  GEN_CAR_ID ='"
						+ carId + "'";
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
		}
		return message;
	}

	public HashMap<String,String> addUsedCar(UsedCar usedCar, InputStream is, ArrayList<InputStream> al, String user_name) {
		
		HashMap<String, String> msgCarId = new HashMap<String, String>();
		try {
			conn = DBConnection.getConnection();
			/*
			 * String query1 =
			 * "select GEN_CAR_ID from used_car order by SEQUENCE_NO DESC LIMIT 1"
			 * ; String id = null; PreparedStatement prest =
			 * conn.prepareStatement(query1);
			 * 
			 * System.out.println(al); ResultSet rs = prest.executeQuery();
			 * while (rs.next()) { id = rs.getString("GEN_CAR_ID"); }
			 * if(id==null) { id="1"; }
			 */
			CarIdGenerator carId = new CarIdGenerator();
			String id = new IdGen().getId("USED_CAR_ID");
			String cid = carId.generateCarId(usedCar.getSTATE(), id);
			String query = "insert into used_car values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CURDATE(),CURDATE())";

			String query2 = "insert into car_photos values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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

			pstmt.setInt(1, usedCar.getSEQUENCE_NO());
			pstmt.setString(2, usedCar.getCAR_NUMBER());
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
			preparedStatement.setInt(1, usedCar.getSEQUENCE_NO());
			preparedStatement.setString(2, usedCar.getCAR_NUMBER());
			preparedStatement.setString(3, user_name);
			preparedStatement.setString(4, usedCar.getCAR_BRAND());
			preparedStatement.setString(5, usedCar.getCAR_MODEL());
			preparedStatement.setString(6, usedCar.getCURRENT_MILEAGE());
			preparedStatement.setString(7, usedCar.getFUEL_TYPE());
			preparedStatement.setString(8, usedCar.getTRANSIMISSION());
			preparedStatement.setString(9, usedCar.getKMS_DRIVEN());
			preparedStatement.setString(10, usedCar.getCOLOR());
			preparedStatement.setString(11, usedCar.getINSURANCE());
			preparedStatement.setString(12, usedCar.getCERTIFIED_COMPANY_NAME());
			preparedStatement.setString(13, usedCar.getREGISTERED_YEAR());
			preparedStatement.setString(14, usedCar.getREGISTERED_STATE());
			preparedStatement.setString(15, usedCar.getREGISTERED_CITY());
			preparedStatement.setString(16, usedCar.getCAR_OWNER_NAME());
			preparedStatement.setString(17, usedCar.getUSED_BY());
			preparedStatement.setInt(18, usedCar.getNO_OF_OWNERS());
			preparedStatement.setString(19, usedCar.getEMAIL_ID());
			preparedStatement.setString(20, usedCar.getMOBILE_NO());
			preparedStatement.setString(21, usedCar.getADDRESS());
			preparedStatement.setString(22, usedCar.getCITY());
			preparedStatement.setString(23, usedCar.getSTATE());
			preparedStatement.setString(24, usedCar.getDISTRICT());
			preparedStatement.setString(25, usedCar.getOFFER_PRICE());
			preparedStatement.setString(26, "ACTIVE");
			preparedStatement.setString(27, cid);
			preparedStatement.setString(28, usedCar.getPINCODE());
			preparedStatement.setString(29, "Y");
			preparedStatement.setString(30, usedCar.getMODEL_YEAR());
			preparedStatement.setString(31, usedCar.getBODY_TYPE());
			// preparedStatement.setString(28, usedCar.getSELLER_TYPE());
			int i1 = preparedStatement.executeUpdate();
			if (i1 > 0 && i2 > 0) {
				msgCarId.put("message", "success");
				msgCarId.put("carId", cid);
			} else {
				msgCarId.put("message", "failure");
				msgCarId.put("carId", cid);
				conn.rollback();
			}
			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return msgCarId;
	}
	
	public String addUsedCar(UsedCar usedCar, ArrayList<InputStream> al,String user_name)
	{
		String message=null;
		InputStream is=null;
		try {
			String query = "insert into used_car values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CURDATE(),CURDATE())";
			PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, usedCar.getSEQUENCE_NO());
			preparedStatement.setString(2, usedCar.getCAR_NUMBER());
			preparedStatement.setString(3, user_name);
			preparedStatement.setString(4, usedCar.getCAR_BRAND());
			preparedStatement.setString(5, usedCar.getCAR_MODEL());
			preparedStatement.setString(6, usedCar.getCURRENT_MILEAGE());
			preparedStatement.setString(7, usedCar.getFUEL_TYPE());
			preparedStatement.setString(8, usedCar.getTRANSIMISSION());
			preparedStatement.setString(9, usedCar.getCOLOR());
			preparedStatement.setBinaryStream(10, is);
			preparedStatement.setString(11, usedCar.getINSURANCE());
			preparedStatement.setString(12, usedCar.getREGISTERED_YEAR());
			preparedStatement.setString(13, usedCar.getREGISTERED_STATE());
			preparedStatement.setString(14, usedCar.getREGISTERED_CITY());
			preparedStatement.setString(15, usedCar.getCAR_OWNER_NAME());
			preparedStatement.setString(16, usedCar.getUSED_BY());
			preparedStatement.setInt(17, usedCar.getNO_OF_OWNERS());
			preparedStatement.setString(18, usedCar.getEMAIL_ID());
			preparedStatement.setString(19, usedCar.getMOBILE_NO());
			preparedStatement.setString(20, usedCar.getADDRESS());
			preparedStatement.setString(21, usedCar.getCITY());
			preparedStatement.setString(22, usedCar.getSTATE());
			preparedStatement.setString(23, usedCar.getDISTRICT());
			preparedStatement.setString(24, usedCar.getOFFER_PRICE());
			preparedStatement.setString(25, "ACTIVE");
			String query1="INSERT INTO `vehicletracking`.`car_photos` VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement1 = conn.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
			preparedStatement1.setInt(1, usedCar.getSEQUENCE_NO());
			preparedStatement1.setString(2, usedCar.getCAR_NUMBER());
			int i=0;
			for(;i<al.size();i++)
			{
				if(al.get(i)!=null)
				{
					preparedStatement1.setBinaryStream(i+3, al.get(i));
				}
				System.out.println(i+3);
			}
			for(int j=i+3;j<15;j++)
			{
				System.out.println(j);
				preparedStatement1.setBinaryStream(j, null);
			}
			
			// File imgfile[] = new File[4];
			// for(int i=0;i<imgfile.length;i++){
			// imgfile[i]=new File(image[i]);
			// FileInputStream fin = new FileInputStream(imgfile[i]);
			// preparedStatement.setBinaryStream(9,fin,(int)imgfile[i].length());

			int i1 = preparedStatement1.executeUpdate();
			if (i1 > 0) {
				message = "Used Car added successfully...";
			} else {

			}

			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}
	
	public Boolean getCarNumber(String carNumber) {

		conn = DBConnection.getConnection();
		String existNumber = "";
		boolean success = false;
		try {
			String query = "select * from used_car where CAR_NUMBER='" +carNumber+ "'";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				existNumber = rs.getString("CAR_NUMBER");
			}
			if (existNumber.equalsIgnoreCase(carNumber)) {
				success = true;
			} else {
				success = false;
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
	
	@Override
	public UsedCar getCarImages(String car_number) {
		UsedCar uc = new UsedCar();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select * from car_photos where car_number='" + car_number + "'";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				java.sql.Blob blob1 = rs.getBlob("PHOTO1");
				byte[] photo1 = blob1.getBytes(1, (int) blob1.length());
				String photo10 = Base64.encode(photo1);
				uc.setPHOTO1(photo10);

				java.sql.Blob blob2 = rs.getBlob("PHOTO2");
				byte[] photo2 = blob2.getBytes(1, (int) blob2.length());
				String photo20 = Base64.encode(photo2);
				uc.setPHOTO2(photo20);

				java.sql.Blob blob3 = rs.getBlob("PHOTO3");
				byte[] photo3 = blob3.getBytes(1, (int) blob3.length());
				String photo30 = Base64.encode(photo3);
				uc.setPHOTO3(photo30);

				java.sql.Blob blob4 = rs.getBlob("PHOTO4");
				byte[] photo4 = blob4.getBytes(1, (int) blob4.length());
				String photo40 = Base64.encode(photo4);
				uc.setPHOTO4(photo40);

				java.sql.Blob blob5 = rs.getBlob("PHOTO5");
				byte[] photo5 = blob5.getBytes(1, (int) blob5.length());
				String photo50 = Base64.encode(photo5);
				uc.setPHOTO5(photo50);

				java.sql.Blob blob6 = rs.getBlob("PHOTO6");
				byte[] photo6 = blob6.getBytes(1, (int) blob6.length());
				String photo60 = Base64.encode(photo6);
				uc.setPHOTO6(photo60);

				java.sql.Blob blob7 = rs.getBlob("PHOTO7");
				byte[] photo7 = blob7.getBytes(1, (int) blob7.length());
				String photo70 = Base64.encode(photo7);
				uc.setPHOTO7(photo70);

				java.sql.Blob blob8 = rs.getBlob("PHOTO8");
				byte[] photo8 = blob8.getBytes(1, (int) blob8.length());
				String photo80 = Base64.encode(photo8);
				uc.setPHOTO8(photo80);

				java.sql.Blob blob9 = rs.getBlob("PHOTO9");
				byte[] photo9 = blob9.getBytes(1, (int) blob9.length());
				String photo90 = Base64.encode(photo9);
				uc.setPHOTO9(photo90);

				java.sql.Blob blob10 = rs.getBlob("PHOTO10");
				byte[] photo101 = blob10.getBytes(1, (int) blob10.length());
				String photo100 = Base64.encode(photo101);
				uc.setPHOTO10(photo100);

				java.sql.Blob blob11 = rs.getBlob("PHOTO11");
				byte[] photo102 = blob11.getBytes(1, (int) blob11.length());
				String photo110 = Base64.encode(photo102);
				uc.setPHOTO11(photo110);

				java.sql.Blob blob12 = rs.getBlob("PHOTO12");
				byte[] photo103 = blob12.getBytes(1, (int) blob12.length());
				String photo120 = Base64.encode(photo103);
				uc.setPHOTO12(photo120);
			}
		} catch (Exception e) {
			
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return uc;
	}
	public ArrayList<UsedCar> getCarBrand(String email) {
		ArrayList<UsedCar> carAl = new ArrayList<UsedCar>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT CAR_BRAND FROM used_car where USER_NAME='"+email+"' and CAR_BRAND is not null group by CAR_BRAND";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				UsedCar usedCar = new UsedCar();
				usedCar.setCAR_BRAND(rs.getString("CAR_BRAND"));
				carAl.add(usedCar);
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
		return carAl;
	}

	@Override
	public ArrayList<UsedCar> getCarModel(String carModel,String email) {
		ArrayList<UsedCar> carAl = new ArrayList<UsedCar>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select car_model from used_car where car_brand='" + carModel+ "' and USER_NAME='"+email+"' and CAR_MODEL is not null group by car_model";
			System.out.println(query);
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				UsedCar usedCar = new UsedCar();
				usedCar.setCAR_MODEL(rs.getString("CAR_MODEL"));
				carAl.add(usedCar);
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
		return carAl;
	}
	public ArrayList<UsedCar> getUsedCarCity() {
		Connection conn = null;
		ArrayList<UsedCar> carAl = new ArrayList<UsedCar>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select REGISTERED_CITY from used_car where REGISTERED_CITY IS NOT NULL group by REGISTERED_CITY";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				UsedCar usedCar = new UsedCar();
				usedCar.setREGISTERED_CITY(rs.getString("REGISTERED_CITY"));
				carAl.add(usedCar);
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
		return carAl;
	}
	@Override
	 public ArrayList<String> getUsedCarCity(String brand, String model, String email) {
	  ArrayList<String> al = new ArrayList<String>();
	  Connection conn = null;
	  Statement st = null;
	  ResultSet rs = null;
	  try {
	   String query = "SELECT CITY FROM used_car where CAR_BRAND ='" + brand + "' and CAR_MODEL = '"
	     + model + "' and USER_NAME='"+email+"' and CITY is not null group by CITY";
	   System.out.println(query);
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
	public ArrayList<UsedCar> getCarId(String email) {
		Connection conn = null;
		ArrayList<UsedCar> carAl = new ArrayList<UsedCar>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT GEN_CAR_ID from used_car where USER_NAME='"+email+"' and status='ACTIVE' AND AVAILABLE='Y'";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				UsedCar usedCar = new UsedCar();
				usedCar.setGEN_CAR_ID(rs.getString("GEN_CAR_ID"));
				carAl.add(usedCar);
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
		return carAl;
	}

	@Override
	public UsedCar getCarDetails(String carId) {
		UsedCar uc = new UsedCar();
		try {
			String sql = "SELECT used_car.*,car_photos.PHOTO1 from used_car left join car_photos on used_car.CAR_NUMBER=car_photos.CAR_NUMBER left join end_user_details on used_car.GEN_CAR_ID=end_user_details.VEHICLE_ID where used_car.GEN_CAR_ID='"
					+ carId + "'";
			conn = DBConnection.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				uc.setGEN_CAR_ID(rs.getString("GEN_CAR_ID"));
				uc.setCAR_NUMBER(rs.getString("CAR_NUMBER"));
				uc.setCAR_BRAND(rs.getString("CAR_BRAND"));
				uc.setCAR_MODEL(rs.getString("CAR_MODEL"));
				uc.setBODY_TYPE(rs.getString("BODY_TYPE"));
				uc.setCURRENT_MILEAGE(rs.getString("CURRENT_MILEAGE"));
				uc.setFUEL_TYPE(rs.getString("FUEL_TYPE"));
				uc.setKMS_DRIVEN(rs.getString("KMS_DRIVEN"));
				uc.setTRANSIMISSION(rs.getString("TRANSMISSION"));
				uc.setCOLOR(rs.getString("COLOR"));
				uc.setREGISTERED_YEAR(rs.getString("REGISTERED_YEAR"));
				uc.setREGISTERED_STATE(rs.getString("REGISTERED_STATE"));
				uc.setREGISTERED_CITY(rs.getString("REGISTERED_CITY"));
				uc.setCITY(rs.getString("CITY"));
				uc.setOFFER_PRICE(rs.getString("OFFER_PRICE"));
				uc.setCAR_OWNER_NAME(rs.getString("CAR_OWNER_NAME"));
				uc.setUSED_BY(rs.getString("USED_BY"));
				uc.setNO_OF_OWNERS(Integer.parseInt(rs.getString("NO_OF_OWNERS")));
				uc.setEMAIL_ID(rs.getString("EMAIL_ID"));
				uc.setMOBILE_NO(rs.getString("MOBILE_NO"));
				uc.setADDRESS(rs.getString("ADDRESS"));
				uc.setCITY(rs.getString("CITY"));
				uc.setSTATE(rs.getString("STATE"));
				uc.setDISTRICT(rs.getString("DISTRICT"));
				uc.setPINCODE(rs.getString("PINCODE"));
				uc.setOFFER_PRICE(rs.getString("OFFER_PRICE"));
				uc.setKMS_DRIVEN(rs.getString("KMS_DRIVEN"));
				uc.setINSURANCE(rs.getString("INSURANCE"));
				uc.setMODEL_YEAR(rs.getString("MODEL_YEAR"));

				java.sql.Blob blob1 = rs.getBlob("PHOTO1");
				byte[] photo1 = blob1.getBytes(1, (int) blob1.length());
				String photo10 = Base64.encode(photo1);
				uc.setPHOTO1(photo10);
			}
			System.out.println(sql);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uc;
	}
	@Override
	public UsedCar getCarOwnerDetails(String carId) {
		UsedCar uc = new UsedCar();
		conn = DBConnection.getConnection();
		try {
			String sql = "Select * from used_car where GEN_CAR_ID='" + carId + "'";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				uc.setSEQUENCE_NO(Integer.parseInt(rs.getString("SEQUENCE_NO")));
				uc.setCAR_NUMBER(rs.getString("CAR_NUMBER"));
				uc.setCAR_BRAND(rs.getString("CAR_BRAND"));
				uc.setCAR_MODEL(rs.getString("CAR_MODEL"));
				uc.setCURRENT_MILEAGE(rs.getString("CURRENT_MILEAGE"));
				uc.setFUEL_TYPE(rs.getString("FUEL_TYPE"));
				uc.setTRANSIMISSION(rs.getString("TRANSMISSION"));
				uc.setCOLOR(rs.getString("COLOR"));
				uc.setINSURANCE(rs.getString("INSURANCE"));
				uc.setREGISTERED_YEAR(rs.getString("REGISTERED_YEAR"));
				uc.setREGISTERED_STATE(rs.getString("REGISTERED_STATE"));
				uc.setREGISTERED_CITY(rs.getString("REGISTERED_CITY"));
				uc.setCAR_OWNER_NAME(rs.getString("CAR_OWNER_NAME"));
				uc.setUSED_BY(rs.getString("USED_BY"));
				uc.setNO_OF_OWNERS(Integer.parseInt(rs.getString("NO_OF_OWNERS")));
				uc.setEMAIL_ID(rs.getString("EMAIL_ID"));
				uc.setMOBILE_NO(rs.getString("MOBILE_NO"));
				uc.setADDRESS(rs.getString("ADDRESS"));
				uc.setCITY(rs.getString("CITY"));
				uc.setSTATE(rs.getString("STATE"));
				uc.setDISTRICT(rs.getString("DISTRICT"));
				uc.setOFFER_PRICE(rs.getString("OFFER_PRICE"));

				// java.sql.Blob blob = rs.getBlob("PHOTO");
				// byte[] photo = blob.getBytes(1, (int) blob.length());
				// String photo1 = Base64.encode(photo);
				// uc.setPHOTO(photo1);
			}
		} catch (Exception e) {
			try {
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return uc;
	}
	@Override
	public int getNoOfRecords() {
		return noOfRecords;
	}

	@Override
	public ArrayList<UsedCar> getCarModel(String carModel) {
		ArrayList<UsedCar> carAl = new ArrayList<UsedCar>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select car_model from used_car where car_brand='" + carModel+ "' and CAR_MODEL is not null group by car_model";
		
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				UsedCar usedCar = new UsedCar();
				usedCar.setCAR_MODEL(rs.getString("CAR_MODEL"));
				carAl.add(usedCar);
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
		return carAl;
	}
	
	@Override
	public ArrayList<UsedCar> getusedCarVariant(String brand,String model) {
		ArrayList<UsedCar> carAl = new ArrayList<UsedCar>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select VARIANT_NAME from used_car where car_brand='" + brand+ "' and CAR_MODEL='"+model+"' and VARIANT_NAME is not null group by VARIANT_NAME";
		
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				UsedCar usedCar = new UsedCar();
				usedCar.setVARIANT_NAME(rs.getString("VARIANT_NAME"));
				carAl.add(usedCar);
			}
			System.out.println("QUREY"+query);

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
		return carAl;
	}

	@Override
	public int[] getCarCountValue(String emailId, String vehicleType) {
		int count = 0;
		int[] value = new int[2];
		
		String query = null;
		conn = DBConnection.getConnection();
		try {
			if(vehicleType.equals("4,2,")){
					value = findCarBikeCount(emailId, vehicleType);
			}else{
				if(vehicleType.equals("4,")){
					query="SELECT COUNT(*) from used_car where user_name ='"+emailId+"'";
				}else if(vehicleType.equals("2,")){
					query="SELECT COUNT(*) from used_bike where user_name ='"+emailId+"'";
				}
				PreparedStatement preparedStatement = conn.prepareStatement(query);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					count = rs.getInt("COUNT(*)");
					value[0] = count;
				}
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	public int[] findCarBikeCount(String emailId, String vehicleType) {

		int count1 = 0,count2 = 0;
		int[] value = new int[2];
		
		String query1 = null;
		String query2 = null;
		conn = DBConnection.getConnection();
		try {
			query1 = "SELECT COUNT(*) from used_car where user_name ='"+emailId+"'";
			query2 = "SELECT COUNT(*) from used_bike where user_name ='"+emailId+"'";
			PreparedStatement pstmt1 = conn.prepareStatement(query1);
			PreparedStatement pstmt2 = conn.prepareStatement(query2);
			ResultSet rs1 = pstmt1.executeQuery();
			while (rs1.next()) {
				count1 = rs1.getInt("COUNT(*)");
			}
			ResultSet rs2 = pstmt2.executeQuery();
			while (rs2.next()) {
				count2 = rs2.getInt("COUNT(*)");
			}
			value[0] = count1;
			value[1] = count2;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	@Override
	public String getVehicleEmailId(String carId,String vehicleType) {
		conn = DBConnection.getConnection();
		String emailId = null;
		String sql = null;
		try {
			if(vehicleType.equals("4")){
				sql = "select user_name from used_car WHERE car_number ='"+carId+"'";
			}else{
				sql = "select user_name from used_bike WHERE bike_number ='"+carId+"'";
			}
			conn = DBConnection.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				emailId = rs.getString("user_name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emailId;
	}

	@Override
	public HashMap<String,String> addDelaerUsedCar(UsedCar usedCar, InputStream is, ArrayList<InputStream> al, String user_name) {
		HashMap<String, String> msgCarId = new HashMap<String, String>();
		try {
			conn = DBConnection.getConnection();
			/*
			 * String query1 =
			 * "select GEN_CAR_ID from used_car order by SEQUENCE_NO DESC LIMIT 1"
			 * ; String id = null; PreparedStatement prest =
			 * conn.prepareStatement(query1);
			 * 
			 * System.out.println(al); ResultSet rs = prest.executeQuery();
			 * while (rs.next()) { id = rs.getString("GEN_CAR_ID"); }
			 * if(id==null) { id="1"; }
			 */
			CarIdGenerator carId = new CarIdGenerator();
			String id = new IdGen().getId("USED_CAR_ID");
			String cid = carId.generateCarId(usedCar.getSTATE(), id);
			String query = "insert into used_car values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CURDATE(),CURDATE())";

			String query2 = "insert into car_photos values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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

			pstmt.setInt(1, usedCar.getSEQUENCE_NO());
			pstmt.setString(2, usedCar.getCAR_NUMBER());
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
			preparedStatement.setInt(1, usedCar.getSEQUENCE_NO());
			preparedStatement.setString(2, usedCar.getCAR_NUMBER());
			preparedStatement.setString(3, user_name);
			preparedStatement.setString(4, usedCar.getCAR_BRAND());
			preparedStatement.setString(5, usedCar.getCAR_MODEL());
			preparedStatement.setString(6, usedCar.getCURRENT_MILEAGE());
			preparedStatement.setString(7, usedCar.getFUEL_TYPE());
			preparedStatement.setString(8, usedCar.getTRANSIMISSION());
			preparedStatement.setString(9, usedCar.getKMS_DRIVEN());
			preparedStatement.setString(10, usedCar.getCOLOR());
			preparedStatement.setString(11, usedCar.getINSURANCE());
			preparedStatement.setString(12, usedCar.getCERTIFIED_COMPANY_NAME());
			preparedStatement.setString(13, usedCar.getREGISTERED_YEAR());
			preparedStatement.setString(14, usedCar.getREGISTERED_STATE());
			preparedStatement.setString(15, usedCar.getREGISTERED_CITY());
			preparedStatement.setString(16, usedCar.getCAR_OWNER_NAME());
			preparedStatement.setString(17, usedCar.getUSED_BY());
			preparedStatement.setInt(18, usedCar.getNO_OF_OWNERS());
			preparedStatement.setString(19, usedCar.getEMAIL_ID());
			preparedStatement.setString(20, usedCar.getMOBILE_NO());
			preparedStatement.setString(21, usedCar.getADDRESS());
			preparedStatement.setString(22, usedCar.getCITY());
			preparedStatement.setString(23, usedCar.getSTATE());
			preparedStatement.setString(24, usedCar.getDISTRICT());
			preparedStatement.setString(25, usedCar.getOFFER_PRICE());
			preparedStatement.setString(26, "ACTIVE");
			preparedStatement.setString(27, cid);
			preparedStatement.setString(28, usedCar.getPINCODE());
			preparedStatement.setString(29, "Y");
			preparedStatement.setString(30, usedCar.getMODEL_YEAR());
			preparedStatement.setString(31, usedCar.getBODY_TYPE());
			preparedStatement.setString(32, usedCar.getVARIANT_NAME());
		
			// preparedStatement.setString(28, usedCar.getSELLER_TYPE());
			int i1 = preparedStatement.executeUpdate();
			if (i1 > 0 && i2 > 0) {
				msgCarId.put("message", "success");
				msgCarId.put("carId", cid);
			} else {
				msgCarId.put("message", "failure");
				msgCarId.put("carId", cid);
				conn.rollback();
			}
			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return msgCarId;
	}

	@Override
	public ArrayList<UsedCar> getCarNo(String email) {
		Connection conn = null;
		ArrayList<UsedCar> carAl = new ArrayList<UsedCar>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT CAR_NUMBER from used_car where USER_NAME='"+email+"'";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				UsedCar usedCar = new UsedCar();
				usedCar.setCAR_NUMBER(rs.getString("CAR_NUMBER"));
				carAl.add(usedCar);
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
		return carAl;
	}

	@Override
	public String updateCarPhotos(String carNo, InputStream is, ArrayList<InputStream> al) {
		String message = null;
		try {
			conn = DBConnection.getConnection();
			String query = "UPDATE car_photos SET PHOTO1=?,PHOTO2=?,PHOTO3=?,PHOTO4=?,PHOTO5=?,PHOTO6=?,PHOTO7=?,PHOTO8=?,PHOTO9=?,PHOTO10=? WHERE CAR_NUMBER ='"+carNo+"'";
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