package com.vaahanmitra.daoImpl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.owtelse.codec.Base64;

import com.vaahanmitra.dao.AddCarDao;
import com.vaahanmitra.dbutil.DBConnection;
import com.vaahanmitra.dbutil.IdGen;
import com.vaahanmitra.model.AddCar;
import com.vaahanmitra.model.BikePrice;
import com.vaahanmitra.model.NewCar;
import com.vaahanmitra.model.VehicleOffer;
import com.vaahanmitra.service.CarAge;
import com.vaahanmitra.utilities.NewVehicleIds;
import com.vaahanmitra.utilities.SQLDate;

public class AddCarDaoImpl implements AddCarDao{

	private int noOfRecords = 0;
	private Connection conn = DBConnection.getConnection();

	public String addCar(AddCar addCar, String user_name, InputStream is) {
		  String message = null;
		  Statement st = null;
		  ResultSet rs = null;
		  int count=0;
		  try {
			  
			    st = conn.createStatement();
			    
			    rs = st.executeQuery("Select count(*) from add_car where CAR_MODEL='"+addCar.getCAR_MODEL()+"' and VARIANT_NAME='"+addCar.getVARIANT_NAME()+"' and CAR_MAKE_YEAR='"+addCar.getCAR_MAKE_YEAR()+"'");
			    while (rs.next()) {
			     count=rs.getInt("count(*)");
			    }
		    
		    
		    if(count==0){
		     
		       conn.setAutoCommit(false);
		       
		     String id = new IdGen().getId("NEW_CAR_ID");
		     NewVehicleIds newCarId = new NewVehicleIds();
		     String carId = newCarId.newCarId(id);
		     String query2 = "insert into new_car_photos values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		     String query = "insert into add_car values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		     String sql = "insert into new_car_specifications values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		     String sql2 = "insert into new_car_specifications_2 values (?,?,?,?,?,?,?,?,?)";
		     
		     PreparedStatement pstmt = conn.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);
		     PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		     PreparedStatement sqlPstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		     PreparedStatement sql2Pstmt =conn.prepareStatement(sql2,Statement.RETURN_GENERATED_KEYS);
		     
		     preparedStatement.setInt(1, addCar.getSEQUENCE_NO());
		     preparedStatement.setString(2, user_name);
		     preparedStatement.setString(3, addCar.getCAR_BRAND());
		     preparedStatement.setString(4, addCar.getCAR_MODEL());
		     preparedStatement.setString(5, addCar.getVARIANT_NAME());
		     preparedStatement.setString(6, addCar.getNO_OF_GEARS());
		     preparedStatement.setString(7, addCar.getCAR_MAKE_YEAR());
		     preparedStatement.setString(8, addCar.getENGINE_TYPE());
		     preparedStatement.setString(9, addCar.getENGINE_DISPLACEMENT());
		     
		     preparedStatement.setString(10, addCar.getNO_OF_CYLINDERS());
		     preparedStatement.setString(11, addCar.getVALVES_PER_CYLINDERS());
		     preparedStatement.setString(12, addCar.getMAX_POWER());
		     preparedStatement.setString(13, addCar.getMAX_TORQUE());
		     preparedStatement.setString(14, addCar.getFUEL_SUPPLY_SYSTEM());
		     preparedStatement.setString(15, addCar.getTRANSMISSION_TYPE());
		     preparedStatement.setString(16, addCar.getGEAR_BOX());
		     preparedStatement.setString(17, addCar.getWHEEL_DRIVE());
		     preparedStatement.setString(18, addCar.getFRONT_SUSPENSION());
		     preparedStatement.setString(19, addCar.getREAR_SUSPENSION());
		     
		     preparedStatement.setString(20, addCar.getSTEERING_TYPE());
		     preparedStatement.setString(21, addCar.getTURNING_RADIONS());
		     preparedStatement.setString(22, addCar.getMILEAGE());
		     preparedStatement.setString(23, addCar.getFUEL_TYPE());
		     preparedStatement.setString(24, addCar.getFUELTANK_CAPACITY());
		     preparedStatement.setString(25, addCar.getTOP_SPEED());
		     preparedStatement.setString(26, addCar.getACCELERATION());
		     preparedStatement.setString(27, addCar.getFRONT_BRAKE_TYPE());
		     preparedStatement.setString(28, addCar.getRARE_BRAKE_TYPE());
		     preparedStatement.setString(29, addCar.getANTI_LOCK_BRAKING_SYSTEM());
		     
		     preparedStatement.setString(30, addCar.getTYRE_SIZE());
		     preparedStatement.setString(31, addCar.getWHEEL_SIZE());
		     preparedStatement.setString(32, addCar.getPOWER_STEERING());
		     preparedStatement.setString(33, addCar.getAIR_CONDITIONER());
		     preparedStatement.setString(34, addCar.getREAR_AC());
		     preparedStatement.setString(35, addCar.getSTEERING_ADJUSTMENT());
		     preparedStatement.setString(36, addCar.getKEYLESS_START());
		     preparedStatement.setString(37, addCar.getPARKING_SENSORS());
		     preparedStatement.setString(38, addCar.getPARKING_ASSIST());
		     preparedStatement.setString(39, addCar.getAIR_BAGS());
		     
		     preparedStatement.setString(40, addCar.getSEAT_BELT_WARNING());
		     preparedStatement.setString(41, carId);
		     preparedStatement.setString(42, addCar.getCOLOR());
		     
		     pstmt.setInt(1, addCar.getSEQUENCE_NO());
		     pstmt.setString(2, carId);
		     pstmt.setBinaryStream(3, is);
		     pstmt.setBinaryStream(4, is);
		     pstmt.setBinaryStream(5, is);
		     pstmt.setBinaryStream(6, is);
		     pstmt.setBinaryStream(7, is);
		     pstmt.setBinaryStream(8, is);
		     pstmt.setBinaryStream(9, is);
		     pstmt.setBinaryStream(10, is);
		     pstmt.setBinaryStream(11, is);
		     pstmt.setBinaryStream(12, is);
		     pstmt.setBinaryStream(13, is);
		     pstmt.setBinaryStream(14, is);
		     
		     sqlPstmt.setInt(1, addCar.getSEQUENCE_NO());   sqlPstmt.setString(2, carId);
		     sqlPstmt.setString(3, "");    sqlPstmt.setString(4, "");
		     sqlPstmt.setString(5, "");      sqlPstmt.setString(6, "");
		     sqlPstmt.setString(7, "");  sqlPstmt.setString(8, "");
		     sqlPstmt.setString(9, "");  sqlPstmt.setString(10, "");
		     sqlPstmt.setString(11, "");  sqlPstmt.setString(12, "");
		     sqlPstmt.setString(13, "");  sqlPstmt.setString(14, "");
		     sqlPstmt.setString(15, "");  sqlPstmt.setString(16, "");
		     sqlPstmt.setString(17, "");  sqlPstmt.setString(18, "");
		     sqlPstmt.setString(19, "");  sqlPstmt.setString(20, "");
		     sqlPstmt.setString(21, "");  sqlPstmt.setString(22, "");
		     sqlPstmt.setString(23, "");  sqlPstmt.setString(24, "");
		     sqlPstmt.setString(25, "");  sqlPstmt.setString(26, "");
		     sqlPstmt.setString(27, "");  sqlPstmt.setString(28, "");
		     sqlPstmt.setString(29, "");  sqlPstmt.setString(30, "");
		     sqlPstmt.setString(31, "");  sqlPstmt.setString(32, "");
		     sqlPstmt.setString(33, "");  sqlPstmt.setString(34, "");
		     sqlPstmt.setString(35, "");  sqlPstmt.setString(36, "");
		     sqlPstmt.setString(37, "");  sqlPstmt.setString(38, "");
		     sqlPstmt.setString(39, "");  
		     
		     
		     sql2Pstmt.setInt(1, addCar.getSEQUENCE_NO());    sql2Pstmt.setString(2, carId );    
		     sql2Pstmt.setString(3, addCar.getBODY_TYPE());   sql2Pstmt.setString(4, addCar.getTYRE_TYPE());   
		     sql2Pstmt.setString(5, "");  sql2Pstmt.setString(6, ""); 
		     sql2Pstmt.setString(7, "");   sql2Pstmt.setString(8, "");  
		     sql2Pstmt.setString(9, ""); 
		     
		     int i1 = preparedStatement.executeUpdate();
		     int i2 = pstmt.executeUpdate();
		     int i3 = sqlPstmt.executeUpdate();
		     int i4 = sql2Pstmt.executeUpdate();
		     
		     if(i1==0||i2==0||i3==0||i4==0){
		    	 
		    	 conn.rollback();
		    	 
		     }
		     else{
		    	 conn.commit();
		     }
		     
		     
		     if (i1 > 0 && i2 > 0 && i3 > 0 && i4 > 0) {
		      message = "success";
		     } else {
		      message = "failure";
		     } 
		     preparedStatement.close();
		     }
		     else{
		    message="Alerdy Exits";
		    }
		    st.close();
		    rs.close();
		    
		    } catch (SQLException e) {
		     e.printStackTrace();
		    }
		  finally {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}}
		    return message;
		 }

	public ArrayList<AddCar> getCarBrands(String carBrand) {

		ArrayList<AddCar> carAl = new ArrayList<AddCar>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT CAR_MODEL from add_car where CAR_BRAND='" + carBrand + "' group by car_model";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				AddCar car = new AddCar();
				car.setCAR_MODEL(rs.getString("CAR_MODEL"));
				carAl.add(car);
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
	public ArrayList<AddCar> getCarBrand() {
		ArrayList<AddCar> carAl = new ArrayList<AddCar>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select car_brand from add_car where car_brand is not null group by car_brand";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				AddCar car = new AddCar();
				car.setCAR_BRAND(rs.getString("CAR_BRAND"));
				carAl.add(car);
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
	public ArrayList<AddCar> getCarBrandDetails(String brand, String user_name) {
		ArrayList<AddCar> carAl = new ArrayList<AddCar>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * from add_car where CAR_BRAND='" + brand +"'";
			System.out.println(query);
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				AddCar car = new AddCar();
				car.setCAR_BRAND(rs.getString("CAR_BRAND"));
				car.setCAR_MODEL(rs.getString("CAR_MODEL"));
			/*	car.setENGINE_CC(rs.getString("ENGINE_CC"));
				car.setFUELTYPE(rs.getString("FUELTYPE"));
				car.setTRANSMISSION_TYPE("TRANSMISSION_TYPE");
				car.setCITY_MPG(rs.getString("CITY_MPG"));*/
				
				java.sql.Blob blob = rs.getBlob("PHOTO");
				byte[] photo = blob.getBytes(1, (int) blob.length());
				String photo1 = Base64.encode(photo);
				car.setPHOTO(photo1);
				carAl.add(car);
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
	public ArrayList<AddCar> getCarModel(String carModel) {
		ArrayList<AddCar> carAl = new ArrayList<AddCar>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select car_model from add_car where car_brand='" + carModel + "' and CAR_MODEL is not null group by car_model";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				AddCar newCar = new AddCar();
				newCar.setCAR_MODEL(rs.getString("CAR_MODEL"));
				carAl.add(newCar);
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
	public ArrayList<AddCar> getNewCar(String brand,String vModel,String vVariant,String madeyear, int offset, int noOfRecords) {
		String query = null;
		

			if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				
				
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID limit " + offset + ", " + noOfRecords;
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' limit " + offset + ", " + noOfRecords;
			}
          
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_BRAND= '"+brand+"'  limit " + offset + ", " + noOfRecords;
			}
          
           else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  limit " + offset + ", " + noOfRecords;
			}
			
           else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"'  limit " + offset + ", " + noOfRecords;
			}
			
           else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' limit " + offset + ", " + noOfRecords;
			}
           
           
           
           else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  and CAR_MAKE_YEAR='"+madeyear+"' limit " + offset + ", " + noOfRecords;
			}
			
			
			
			
			
			
           else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where  CAR_MAKE_YEAR='"+madeyear+"' limit " + offset + ", " + noOfRecords;
			}
			
			
            else {
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID limit " + offset + ", " + noOfRecords;
			}
			
			
			
		/*	else if(!brand.equals("SELECT") && vModel.equals("SELECT")){
				
				
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_BRAND= '"+brand+"' limit " + offset + ", " + noOfRecords;
			} else if(!brand.equals("SELECT") && !vModel.equals("SELECT")){
				
				
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' limit " + offset + ", " + noOfRecords;
			} */
			ArrayList<AddCar> al = getNewCarDetails(query);
			
			return al;
		}

	public ArrayList<AddCar> getNewCarDetails(String query) {
		ArrayList<AddCar> al = new ArrayList<AddCar>();
		Statement stmt = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				AddCar ad = new AddCar();
				ad.setSEQUENCE_NO(Integer.parseInt(rs.getString("SEQUENCE_NO")));
				/* ad.setCAR_NUMBER(rs.getString("CAR_NUMBER")); */
				ad.setCAR_BRAND(rs.getString("CAR_BRAND"));
				ad.setCAR_MODEL(rs.getString("CAR_MODEL"));
				ad.setVARIANT_NAME(rs.getString("VARIANT_NAME"));
				ad.setNO_OF_GEARS(rs.getString("NO_OF_GEARS"));
				ad.setCAR_MAKE_YEAR(rs.getString("CAR_MAKE_YEAR"));
				ad.setENGINE_TYPE(rs.getString("ENGINE_TYPE"));
				ad.setENGINE_DISPLACEMENT(rs.getString("ENGINE_DISPLACEMENT"));
				ad.setNO_OF_CYLINDERS(rs.getString("NO_OF_CYLINDERS"));
				ad.setVALVES_PER_CYLINDERS(rs.getString("VALVES_PER_CYLINDERS"));
				ad.setMAX_POWER(rs.getString("MAX_POWER"));
				ad.setMAX_TORQUE(rs.getString("MAX_TORQUE"));
				ad.setFUEL_SUPPLY_SYSTEM(rs.getString("FUEL_SUPPLY_SYSTEM"));
				ad.setTRANSMISSION_TYPE(rs.getString("TRANSMISSION_TYPE"));
				ad.setGEAR_BOX(rs.getString("GEAR_BOX"));
				ad.setWHEEL_DRIVE(rs.getString("WHEEL_DRIVE"));
				ad.setFRONT_SUSPENSION(rs.getString("FRONT_SUSPENSION"));
				ad.setREAR_SUSPENSION(rs.getString("REAR_SUSPENSION"));
				ad.setSTEERING_TYPE(rs.getString("STEERING_TYPE"));
				ad.setTURNING_RADIONS(rs.getString("TURNING_RADIONS"));
				ad.setMILEAGE(rs.getString("MILEAGE"));
				ad.setFUEL_TYPE(rs.getString("FUEL_TYPE"));
				ad.setFUELTANK_CAPACITY(rs.getString("FUELTANK_CAPACITY"));
				ad.setTOP_SPEED(rs.getString("TOP_SPEED"));
				ad.setACCELERATION(rs.getString("ACCELERATION"));
				ad.setFRONT_BRAKE_TYPE(rs.getString("FRONT_BRAKE_TYPE"));
				ad.setRARE_BRAKE_TYPE(rs.getString("RARE_BRAKE_TYPE"));
				ad.setANTI_LOCK_BRAKING_SYSTEM(rs.getString("ANTI_LOCK_BRAKING_SYSTEM"));
				ad.setTYRE_SIZE(rs.getString("TYRE_SIZE"));
				ad.setWHEEL_SIZE(rs.getString("WHEEL_SIZE"));
				ad.setPOWER_STEERING(rs.getString("POWER_STEERING"));
				ad.setAIR_CONDITIONER(rs.getString("AIR_CONDITIONER"));
				ad.setREAR_AC(rs.getString("REAR_AC"));
				ad.setSTEERING_ADJUSTMENT(rs.getString("STEERING_ADJUSTMENT"));
				ad.setKEYLESS_START(rs.getString("KEYLESS_START"));
				ad.setPARKING_SENSORS(rs.getString("PARKING_SENSORS"));
				ad.setPARKING_ASSIST(rs.getString("PARKING_ASSIST"));
				ad.setAIR_BAGS(rs.getString("AIR_BAGS"));
				ad.setSEAT_BELT_WARNING(rs.getString("SEAT_BELT_WARNING"));
				ad.setBODY_TYPE(rs.getString("BODY_TYPE"));
				ad.setTYRE_TYPE(rs.getString("TYRE_TYPE"));
				ad.setNEW_CAR_ID(rs.getString("NEW_CAR_ID"));
				ad.setCOLOR(rs.getString("COLOR"));
				
				ad.setENGINE_IMMOBILIZER(rs.getString("ENGINE_IMMOBILIZER"));
				ad.setCENTRAL_LOCKING_SYSTEM(rs.getString("CENTRAL_LOCKING_SYSTEM"));
				ad.setCHILD_LOCKING_SYSTEM(rs.getString("CHILD_LOCKING_SYSTEM"));
				ad.setAUTOMATIC_HEAD_LAMPS(rs.getString("AUTOMATIC_HEAD_LAMPS"));
				ad.setFOR_LAMPS(rs.getString("FOR_LAMPS"));
				ad.setTAIL_LAMPS(rs.getString("TAIL_LAMPS"));
				ad.setHEAD_LIGHT(rs.getString("HEAD_LIGHT"));
				ad.setHEIGHT_ADJUSTER(rs.getString("HEIGHT_ADJUSTER"));
				ad.setMUSIC_SYSTEM(rs.getString("MUSIC_SYSTEM"));
				ad.setDISPLAY(rs.getString("DISPLAY"));
				ad.setDISPLAY_SCREEN_REAR_PASSENGERS(rs.getString("DISPLAY_SCREEN_REAR_PASSENGERS"));
				ad.setGPS_NAVIGATION_SYSTEM(rs.getString("GPS_NAVIGATION_SYSTEM"));
				ad.setGPS_NAVIGATION_SYSTEM(rs.getString("GPS_NAVIGATION_SYSTEM"));
				ad.setSPEAKERS(rs.getString("SPEAKERS"));
				ad.setUSB_COMPATIBILITY(rs.getString("USB_COMPATIBILITY"));
				ad.setMP3_PLAYER(rs.getString("MP3_PLAYER"));
				ad.setCD_PLAYER(rs.getString("CD_PLAYER"));
				ad.setDVD_PLAYER(rs.getString("DVD_PLAYER"));
				ad.setFM_RADIO(rs.getString("FM_RADIO"));
				ad.setKRAB_WEIGHT(rs.getString("KRAB_WEIGHT"));
				ad.setBLUETOOTH(rs.getString("BLUETOOTH"));
				ad.setBOOT_SPACE(rs.getString("BOOT_SPACE"));
				ad.setTRIP_METER(rs.getString("TRIP_METER"));
				ad.setGEAR_SHIFT_INDICATOR(rs.getString("GEAR_SHIFT_INDICATOR"));
				ad.setWARRANTY_YEAR(rs.getString("WARRANTY_YEAR"));
				ad.setWARRANTY_KMS(rs.getString("WARRANTY_KMS"));
				ad.setCLOCK(rs.getString("CLOCK"));
				ad.setLOW_FUEL_LEVEL_WARNING(rs.getString("LOW_FUEL_LEVEL_WARNING"));
				ad.setDOOR_CLOSE_WARNING(rs.getString("DOOR_CLOSE_WARNING"));
				ad.setPOWER_WINDOWS(rs.getString("POWER_WINDOWS"));
				ad.setREAR_DETOGGER(rs.getString("REAR_DETOGGER"));
				ad.setREAR_WIPER(rs.getString("REAR_WIPER"));
				ad.setRAIN_SENSING_WIPER(rs.getString("RAIN_SENSING_WIPER"));
				ad.setNO_OF_DOORS(rs.getString("NO_OF_DOORS"));
				ad.setSEATING_CAPACITY(rs.getString("SEATING_CAPACITY"));
				ad.setADJUST_PASSENGER_SEAT(rs.getString("ADJUST_PASSENGER_SEAT"));
				ad.setFOLDING_REAR_SEAT(rs.getString("FOLDING_REAR_SEAT"));
				ad.setSPLIT_RARE_SEAT(rs.getString("SPLIT_RARE_SEAT"));
				ad.setLENGTH(rs.getString("LENGTH"));
				ad.setWIDTH(rs.getString("WIDTH"));
				ad.setHEIGHT(rs.getString("HEIGHT"));
				ad.setWHEEL_BASE(rs.getString("WHEEL_BASE"));
				ad.setGROUND_CLEARANCE(rs.getString("GROUND_CLEARANCE"));
				
				/*exshowroompricetab*/
/*				
				ad.setEXPRICE_SEQ_ID(rs.getInt("EXPRICE_SEQ_ID"));
				ad.setEX_SHOW_ROOM_PRICE(rs.getString("EX_SHOW_ROOM_PRICE"));
				ad.setEX_SHOW_ROOM_PRICE_PLACE(rs.getString("EX_SHOW_ROOM_PRICE_PLACE"));
				ad.setUPDATED_DATE_TIME(rs.getString("UPDATED_DATE_TIME"));*/

				
					java.sql.Blob blob1 = rs.getBlob("PHOTO1");
					byte[] photo1 = blob1.getBytes(1, (int) blob1.length());
					String photo11 = Base64.encode(photo1);
					ad.setPHOTO1(photo11);
					
					java.sql.Blob blob2 = rs.getBlob("PHOTO2");
					byte[] photo2 = blob2.getBytes(1, (int) blob2.length());
					String photo12 = Base64.encode(photo2);
					ad.setPHOTO2(photo12);
					
					java.sql.Blob blob3 = rs.getBlob("PHOTO3");
					byte[] photo3 = blob3.getBytes(1, (int) blob3.length());
					String photo13 = Base64.encode(photo3);
					ad.setPHOTO3(photo13);
					
					java.sql.Blob blob4 = rs.getBlob("PHOTO4");
					byte[] photo4 = blob4.getBytes(1, (int) blob4.length());
					String photo14 = Base64.encode(photo4);
					ad.setPHOTO4(photo14);
					
					java.sql.Blob blob5 = rs.getBlob("PHOTO5");
					byte[] photo5 = blob5.getBytes(1, (int) blob5.length());
					String photo15 = Base64.encode(photo5);
					ad.setPHOTO5(photo15);
					
					java.sql.Blob blob6 = rs.getBlob("PHOTO6");
					byte[] photo6 = blob6.getBytes(1, (int) blob6.length());
					String photo16 = Base64.encode(photo6);
					ad.setPHOTO6(photo16);
					
					java.sql.Blob blob7 = rs.getBlob("PHOTO7");
					byte[] photo7 = blob7.getBytes(1, (int) blob7.length());
					String photo17 = Base64.encode(photo7);
					ad.setPHOTO7(photo17);
					
					java.sql.Blob blob8 = rs.getBlob("PHOTO8");
					byte[] photo8 = blob8.getBytes(1, (int) blob8.length());
					String photo18 = Base64.encode(photo8);
					ad.setPHOTO8(photo18);
					
					java.sql.Blob blob9 = rs.getBlob("PHOTO9");
					byte[] photo9 = blob9.getBytes(1, (int) blob9.length());
					String photo19 = Base64.encode(photo9);
					ad.setPHOTO9(photo19);
					
					java.sql.Blob blob10 = rs.getBlob("PHOTO10");
					byte[] photo10 = blob10.getBytes(1, (int) blob10.length());
					String photo20 = Base64.encode(photo10);
					ad.setPHOTO10(photo20);
				
				
				al.add(ad);
				
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
				e.printStackTrace();
				// TODO Auto-generated catch block
			}
		}
		return al;
	}

	@Override
	public int getNoOfRecords() {
		
		return noOfRecords;
	}

	@Override
	public ArrayList<AddCar> getCarId(String email) {
		Connection conn = null;
		System.out.println(email);
		ArrayList<AddCar> carAl = new ArrayList<AddCar>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT NEW_CAR_ID from add_car where USER_NAME='"+email+"' and NEW_CAR_ID is not null";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				AddCar car = new AddCar();
				car.setNEW_CAR_ID(rs.getString("NEW_CAR_ID"));
				carAl.add(car);
			}
			System.out.println(query);
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
		InputStream photo1 = null, photo2 = null, photo3 = null, photo4 = null, photo5 = null, photo6 = null, photo7 = null,
				photo8 = null, photo9 = null, photo10 = null, photo11 = null, photo12 = null;
		try {
			conn = DBConnection.getConnection();
			String query = "UPDATE new_car_photos SET PHOTO1=?,PHOTO2=?,PHOTO3=?,PHOTO4=?,PHOTO5=?,PHOTO6=?,PHOTO7=?,PHOTO8=?,PHOTO9=?,PHOTO10=? WHERE NEW_CAR_ID ='"+carNo+"'";
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 finally {
				try {

					conn.close();

				} catch (Exception e) {
					e.printStackTrace();
				}}
		return message;
	}

	@Override
	public ArrayList<AddCar> getCarDetails(String carId) {
		String query = null;
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where add_car.NEW_CAR_ID= '"+carId+"'";
		ArrayList<AddCar> al = getNewCarDetails(query);
	
		return al;
		
	}

	@Override
	public Set<AddCar> getNewCarVariantName(String brand, String model) {
		Set<AddCar> carAl = new HashSet<AddCar>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select VARIANT_NAME from add_car where car_brand='"+brand+"' and car_model='"+model+"' and VARIANT_NAME is not null group by VARIANT_NAME";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				AddCar newCar = new AddCar();
				newCar.setVARIANT_NAME(rs.getString("VARIANT_NAME"));
				carAl.add(newCar);
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
	public String addCarSpecifications(AddCar addCar) {
		String message= null;
		Connection conn= null;
		try {
			String sql = "UPDATE new_car_specifications, new_car_specifications_2 SET ENGINE_IMMOBILIZER=?, CENTRAL_LOCKING_SYSTEM=?, CHILD_LOCKING_SYSTEM=?, AUTOMATIC_HEAD_LAMPS=?, FOR_LAMPS=?, TAIL_LAMPS=?, HEAD_LIGHT=?, HEIGHT_ADJUSTER=?, MUSIC_SYSTEM=?, DISPLAY=?, DISPLAY_SCREEN_REAR_PASSENGERS=?, GPS_NAVIGATION_SYSTEM=?,SPEAKERS=?,USB_COMPATIBILITY=?,"
					+ "MP3_PLAYER=?,CD_PLAYER=?,DVD_PLAYER=?,FM_RADIO=?,WARRANTY_YEAR=?,WARRANTY_KMS=?,CLOCK=?, LOW_FUEL_LEVEL_WARNING=?,DOOR_CLOSE_WARNING=?,POWER_WINDOWS=?,REAR_DETOGGER=?,REAR_WIPER=?, RAIN_SENSING_WIPER=?, NO_OF_DOORS=?,SEATING_CAPACITY=?,ADJUST_PASSENGER_SEAT=?,FOLDING_REAR_SEAT=?,SPLIT_RARE_SEAT=?,"
					+ "LENGTH=?,WIDTH=?,HEIGHT=?, WHEEL_BASE=?,GROUND_CLEARANCE=?,BOOT_SPACE=?, KRAB_WEIGHT=?, BLUETOOTH=?, TRIP_METER=?, GEAR_SHIFT_INDICATOR=?  WHERE new_car_specifications.NEW_CAR_ID = new_car_specifications_2.NEW_CAR_ID and new_car_specifications.NEW_CAR_ID ='"+addCar.getNEW_CAR_ID()+"'";
			conn = DBConnection.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, addCar.getENGINE_IMMOBILIZER());
			preparedStatement.setString(2, addCar.getCENTRAL_LOCKING_SYSTEM());
			preparedStatement.setString(3, addCar.getCHILD_LOCKING_SYSTEM());
			preparedStatement.setString(4, addCar.getAUTOMATIC_HEAD_LAMPS());
			preparedStatement.setString(5, addCar.getFOR_LAMPS());
			preparedStatement.setString(6, addCar.getTAIL_LAMPS());
			preparedStatement.setString(7, addCar.getHEAD_LIGHT());
			preparedStatement.setString(8, addCar.getHEIGHT_ADJUSTER());
			preparedStatement.setString(9, addCar.getMUSIC_SYSTEM());
			
			preparedStatement.setString(10, addCar.getDISPLAY());
			preparedStatement.setString(11, addCar.getDISPLAY_SCREEN_REAR_PASSENGERS());
			preparedStatement.setString(12, addCar.getGPS_NAVIGATION_SYSTEM());
			preparedStatement.setString(13, addCar.getSPEAKERS());
			preparedStatement.setString(14, addCar.getUSB_COMPATIBILITY());
			preparedStatement.setString(15, addCar.getMP3_PLAYER());
			preparedStatement.setString(16, addCar.getCD_PLAYER());
			preparedStatement.setString(17, addCar.getDVD_PLAYER());
			preparedStatement.setString(18, addCar.getFM_RADIO());
			preparedStatement.setString(19, addCar.getWARRANTY_YEAR());
			
			preparedStatement.setString(20, addCar.getWARRANTY_KMS());
			preparedStatement.setString(21, addCar.getCLOCK());
			preparedStatement.setString(22, addCar.getLOW_FUEL_LEVEL_WARNING());
			preparedStatement.setString(23, addCar.getDOOR_CLOSE_WARNING());
			preparedStatement.setString(24, addCar.getPOWER_WINDOWS());
			preparedStatement.setString(25, addCar.getREAR_DETOGGER());
			preparedStatement.setString(26, addCar.getREAR_WIPER());
			preparedStatement.setString(27, addCar.getRAIN_SENSING_WIPER());
			preparedStatement.setString(28, addCar.getNO_OF_DOORS());
			preparedStatement.setString(29, addCar.getSEATING_CAPACITY());
			
			preparedStatement.setString(30, addCar.getADJUST_PASSENGER_SEAT());
			preparedStatement.setString(31, addCar.getFOLDING_REAR_SEAT());
			preparedStatement.setString(32, addCar.getSPLIT_RARE_SEAT());
			preparedStatement.setString(33, addCar.getLENGTH());
			preparedStatement.setString(34, addCar.getWIDTH());
			preparedStatement.setString(35, addCar.getHEIGHT());
			preparedStatement.setString(36, addCar.getWHEEL_BASE());
			preparedStatement.setString(37, addCar.getGROUND_CLEARANCE());
			preparedStatement.setString(38, addCar.getBOOT_SPACE());
			preparedStatement.setString(39, addCar.getKRAB_WEIGHT());
			preparedStatement.setString(40, addCar.getBLUETOOTH());
			preparedStatement.setString(41, addCar.getTRIP_METER());
			preparedStatement.setString(42, addCar.getGEAR_SHIFT_INDICATOR());
	
			int i = preparedStatement.executeUpdate();

			if (i > 0) {
				message = "success";
			} else {
				message = "failure";
			}
			preparedStatement.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {

				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}}
		return message;
	}

	@Override
	public ArrayList<AddCar> getNewCarId() {

		Connection conn = null;
		ArrayList<AddCar> carAl = new ArrayList<AddCar>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT NEW_CAR_ID from add_car";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				AddCar newCar = new AddCar();
				newCar.setNEW_CAR_ID(rs.getString("NEW_CAR_ID"));
				carAl.add(newCar);
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
	public Map<String,String> getNewVehicleBrand(String carId) {
		Map<String,String> models = new HashMap<String,String>();
		Statement st = null;
		ResultSet rs = null;
		String query = null;
		try {
			query = "select CAR_BRAND,CAR_MODEL,VARIANT_NAME from add_car where NEW_CAR_ID='"+carId+"' and CAR_BRAND!='' and CAR_BRAND is not null";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				models.put("brand", rs.getString("CAR_BRAND"));
				models.put("model",rs.getString("CAR_MODEL"));
				models.put("variant",rs.getString("VARIANT_NAME"));
			}
		}
		catch (Exception e) {
			// e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
		return models;
	}
	@Override
	 public ArrayList<AddCar> getNewCarVariantNameForUpdate(String model,String brand) {
	  // TODO Auto-generated method stub
	  ArrayList<AddCar> carAl = new ArrayList<AddCar>();
	  Statement st = null;
	  ResultSet rs = null;
	  try {
	   String query = "select VARIANT_NAME,NEW_CAR_ID,CAR_MAKE_YEAR from add_car where car_model='"+model+"' and car_brand='"+brand+"' and NEW_CAR_ID is not null group by NEW_CAR_ID order by CAR_MAKE_YEAR desc";
	   conn = DBConnection.getConnection();
	   st = conn.createStatement();
	   rs = st.executeQuery(query);
	   while (rs.next()) {
	    AddCar newCar = new AddCar();
	    newCar.setVARIANT_NAME(rs.getString("VARIANT_NAME"));
	    newCar.setNEW_CAR_ID(rs.getString("NEW_CAR_ID"));
	    newCar.setCAR_MAKE_YEAR(rs.getString("CAR_MAKE_YEAR"));
	    carAl.add(newCar);
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
	 public ArrayList<AddCar> getCarDetailsByVariantName(String variant_name) {
	  // TODO Auto-generated method stub
	  String query = null;
	  query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID   where add_car.NEW_CAR_ID='"+variant_name+"'";
	
	System.out.println("QUREY"+query);
	  
	  ArrayList<AddCar> al = getNewCarDetails(query);
	  return al;
	 }
	
	
	@Override
	 public ArrayList<AddCar> getCarDetailswithoutimageVariantName(String variant_name) {
	  // TODO Auto-generated method stub
	  String query = null;
	  query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID   where add_car.NEW_CAR_ID='"+variant_name+"'";
	  ArrayList<AddCar> al = getNewCarDetailswithoutimage(query);
	  return al;
	 }
	public ArrayList<AddCar> getNewCarDetailswithoutimage(String query) {
		ArrayList<AddCar> al = new ArrayList<AddCar>();
		Statement stmt = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				AddCar ad = new AddCar();
				ad.setSEQUENCE_NO(Integer.parseInt(rs.getString("SEQUENCE_NO")));
				/* ad.setCAR_NUMBER(rs.getString("CAR_NUMBER")); */
				ad.setCAR_BRAND(rs.getString("CAR_BRAND"));
				ad.setCAR_MODEL(rs.getString("CAR_MODEL"));
				ad.setVARIANT_NAME(rs.getString("VARIANT_NAME"));
				ad.setNO_OF_GEARS(rs.getString("NO_OF_GEARS"));
				ad.setCAR_MAKE_YEAR(rs.getString("CAR_MAKE_YEAR"));
				ad.setENGINE_TYPE(rs.getString("ENGINE_TYPE"));
				ad.setENGINE_DISPLACEMENT(rs.getString("ENGINE_DISPLACEMENT"));
				ad.setNO_OF_CYLINDERS(rs.getString("NO_OF_CYLINDERS"));
				ad.setVALVES_PER_CYLINDERS(rs.getString("VALVES_PER_CYLINDERS"));
				ad.setMAX_POWER(rs.getString("MAX_POWER"));
				ad.setMAX_TORQUE(rs.getString("MAX_TORQUE"));
				ad.setFUEL_SUPPLY_SYSTEM(rs.getString("FUEL_SUPPLY_SYSTEM"));
				ad.setTRANSMISSION_TYPE(rs.getString("TRANSMISSION_TYPE"));
				ad.setGEAR_BOX(rs.getString("GEAR_BOX"));
				ad.setWHEEL_DRIVE(rs.getString("WHEEL_DRIVE"));
				ad.setFRONT_SUSPENSION(rs.getString("FRONT_SUSPENSION"));
				ad.setREAR_SUSPENSION(rs.getString("REAR_SUSPENSION"));
				ad.setSTEERING_TYPE(rs.getString("STEERING_TYPE"));
				ad.setTURNING_RADIONS(rs.getString("TURNING_RADIONS"));
				ad.setMILEAGE(rs.getString("MILEAGE"));
				ad.setFUEL_TYPE(rs.getString("FUEL_TYPE"));
				ad.setFUELTANK_CAPACITY(rs.getString("FUELTANK_CAPACITY"));
				ad.setTOP_SPEED(rs.getString("TOP_SPEED"));
				ad.setACCELERATION(rs.getString("ACCELERATION"));
				ad.setFRONT_BRAKE_TYPE(rs.getString("FRONT_BRAKE_TYPE"));
				ad.setRARE_BRAKE_TYPE(rs.getString("RARE_BRAKE_TYPE"));
				ad.setANTI_LOCK_BRAKING_SYSTEM(rs.getString("ANTI_LOCK_BRAKING_SYSTEM"));
				ad.setTYRE_SIZE(rs.getString("TYRE_SIZE"));
				ad.setWHEEL_SIZE(rs.getString("WHEEL_SIZE"));
				ad.setPOWER_STEERING(rs.getString("POWER_STEERING"));
				ad.setAIR_CONDITIONER(rs.getString("AIR_CONDITIONER"));
				ad.setREAR_AC(rs.getString("REAR_AC"));
				ad.setSTEERING_ADJUSTMENT(rs.getString("STEERING_ADJUSTMENT"));
				ad.setKEYLESS_START(rs.getString("KEYLESS_START"));
				ad.setPARKING_SENSORS(rs.getString("PARKING_SENSORS"));
				ad.setPARKING_ASSIST(rs.getString("PARKING_ASSIST"));
				ad.setAIR_BAGS(rs.getString("AIR_BAGS"));
				ad.setSEAT_BELT_WARNING(rs.getString("SEAT_BELT_WARNING"));
				ad.setBODY_TYPE(rs.getString("BODY_TYPE"));
				ad.setTYRE_TYPE(rs.getString("TYRE_TYPE"));
				ad.setNEW_CAR_ID(rs.getString("NEW_CAR_ID"));
				ad.setCOLOR(rs.getString("COLOR"));
				
				ad.setENGINE_IMMOBILIZER(rs.getString("ENGINE_IMMOBILIZER"));
				ad.setCENTRAL_LOCKING_SYSTEM(rs.getString("CENTRAL_LOCKING_SYSTEM"));
				ad.setCHILD_LOCKING_SYSTEM(rs.getString("CHILD_LOCKING_SYSTEM"));
				ad.setAUTOMATIC_HEAD_LAMPS(rs.getString("AUTOMATIC_HEAD_LAMPS"));
				ad.setFOR_LAMPS(rs.getString("FOR_LAMPS"));
				ad.setTAIL_LAMPS(rs.getString("TAIL_LAMPS"));
				ad.setHEAD_LIGHT(rs.getString("HEAD_LIGHT"));
				ad.setHEIGHT_ADJUSTER(rs.getString("HEIGHT_ADJUSTER"));
				ad.setMUSIC_SYSTEM(rs.getString("MUSIC_SYSTEM"));
				ad.setDISPLAY(rs.getString("DISPLAY"));
				ad.setDISPLAY_SCREEN_REAR_PASSENGERS(rs.getString("DISPLAY_SCREEN_REAR_PASSENGERS"));
				ad.setGPS_NAVIGATION_SYSTEM(rs.getString("GPS_NAVIGATION_SYSTEM"));
				ad.setGPS_NAVIGATION_SYSTEM(rs.getString("GPS_NAVIGATION_SYSTEM"));
				ad.setSPEAKERS(rs.getString("SPEAKERS"));
				ad.setUSB_COMPATIBILITY(rs.getString("USB_COMPATIBILITY"));
				ad.setMP3_PLAYER(rs.getString("MP3_PLAYER"));
				ad.setCD_PLAYER(rs.getString("CD_PLAYER"));
				ad.setDVD_PLAYER(rs.getString("DVD_PLAYER"));
				ad.setFM_RADIO(rs.getString("FM_RADIO"));
				ad.setKRAB_WEIGHT(rs.getString("KRAB_WEIGHT"));
				ad.setBLUETOOTH(rs.getString("BLUETOOTH"));
				ad.setBOOT_SPACE(rs.getString("BOOT_SPACE"));
				ad.setTRIP_METER(rs.getString("TRIP_METER"));
				ad.setGEAR_SHIFT_INDICATOR(rs.getString("GEAR_SHIFT_INDICATOR"));
				ad.setWARRANTY_YEAR(rs.getString("WARRANTY_YEAR"));
				ad.setWARRANTY_KMS(rs.getString("WARRANTY_KMS"));
				ad.setCLOCK(rs.getString("CLOCK"));
				ad.setLOW_FUEL_LEVEL_WARNING(rs.getString("LOW_FUEL_LEVEL_WARNING"));
				ad.setDOOR_CLOSE_WARNING(rs.getString("DOOR_CLOSE_WARNING"));
				ad.setPOWER_WINDOWS(rs.getString("POWER_WINDOWS"));
				ad.setREAR_DETOGGER(rs.getString("REAR_DETOGGER"));
				ad.setREAR_WIPER(rs.getString("REAR_WIPER"));
				ad.setRAIN_SENSING_WIPER(rs.getString("RAIN_SENSING_WIPER"));
				ad.setNO_OF_DOORS(rs.getString("NO_OF_DOORS"));
				ad.setSEATING_CAPACITY(rs.getString("SEATING_CAPACITY"));
				ad.setADJUST_PASSENGER_SEAT(rs.getString("ADJUST_PASSENGER_SEAT"));
				ad.setFOLDING_REAR_SEAT(rs.getString("FOLDING_REAR_SEAT"));
				ad.setSPLIT_RARE_SEAT(rs.getString("SPLIT_RARE_SEAT"));
				ad.setLENGTH(rs.getString("LENGTH"));
				ad.setWIDTH(rs.getString("WIDTH"));
				ad.setHEIGHT(rs.getString("HEIGHT"));
				ad.setWHEEL_BASE(rs.getString("WHEEL_BASE"));
				ad.setGROUND_CLEARANCE(rs.getString("GROUND_CLEARANCE"));
				
				/*exshowroompricetab*/
/*				
				ad.setEXPRICE_SEQ_ID(rs.getInt("EXPRICE_SEQ_ID"));
				ad.setEX_SHOW_ROOM_PRICE(rs.getString("EX_SHOW_ROOM_PRICE"));
				ad.setEX_SHOW_ROOM_PRICE_PLACE(rs.getString("EX_SHOW_ROOM_PRICE_PLACE"));
				ad.setUPDATED_DATE_TIME(rs.getString("UPDATED_DATE_TIME"));*/

				try {
					java.sql.Blob blob1 = rs.getBlob("PHOTO1");
					byte[] photo1 = blob1.getBytes(1, (int) blob1.length());
					String photo11 = Base64.encode(photo1);
					ad.setPHOTO1(photo11);
					
					java.sql.Blob blob2 = rs.getBlob("PHOTO2");
					byte[] photo2 = blob2.getBytes(1, (int) blob2.length());
					String photo12 = Base64.encode(photo2);
					ad.setPHOTO2(photo12);
					
					java.sql.Blob blob3 = rs.getBlob("PHOTO3");
					byte[] photo3 = blob3.getBytes(1, (int) blob3.length());
					String photo13 = Base64.encode(photo3);
					ad.setPHOTO3(photo13);
					
					java.sql.Blob blob4 = rs.getBlob("PHOTO4");
					byte[] photo4 = blob4.getBytes(1, (int) blob4.length());
					String photo14 = Base64.encode(photo4);
					ad.setPHOTO4(photo14);
					
					java.sql.Blob blob5 = rs.getBlob("PHOTO5");
					byte[] photo5 = blob5.getBytes(1, (int) blob5.length());
					String photo15 = Base64.encode(photo5);
					ad.setPHOTO5(photo15);
					
					java.sql.Blob blob6 = rs.getBlob("PHOTO6");
					byte[] photo6 = blob6.getBytes(1, (int) blob6.length());
					String photo16 = Base64.encode(photo6);
					ad.setPHOTO6(photo16);
					
					java.sql.Blob blob7 = rs.getBlob("PHOTO7");
					byte[] photo7 = blob7.getBytes(1, (int) blob7.length());
					String photo17 = Base64.encode(photo7);
					ad.setPHOTO7(photo17);
					
					java.sql.Blob blob8 = rs.getBlob("PHOTO8");
					byte[] photo8 = blob8.getBytes(1, (int) blob8.length());
					String photo18 = Base64.encode(photo8);
					ad.setPHOTO8(photo18);
					
					java.sql.Blob blob9 = rs.getBlob("PHOTO9");
					byte[] photo9 = blob9.getBytes(1, (int) blob9.length());
					String photo19 = Base64.encode(photo9);
					ad.setPHOTO9(photo19);
					
					java.sql.Blob blob10 = rs.getBlob("PHOTO10");
					byte[] photo10 = blob10.getBytes(1, (int) blob10.length());
					String photo20 = Base64.encode(photo10);
					ad.setPHOTO10(photo20);
				} catch (NullPointerException s) {
					// TODO Auto-generated catch block
					s.printStackTrace();
				}
				
				al.add(ad);
				
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
				e.printStackTrace();
				// TODO Auto-generated catch block
			}
		}
		return al;
	}
	
	
	
	
	@Override
	public String updateNewCarbasicdetails(AddCar addCar, String user_name) {
		// TODO Auto-generated method stub
		Statement st = null;
		ResultSet rs = null;
		String message = null;
		int count = 0;
		try {
			   st = conn.createStatement();
			   rs = st.executeQuery("Select count(*) from add_car where CAR_MODEL='"+addCar.getCAR_MODEL()+"' and VARIANT_NAME='"+addCar.getVARIANT_NAME()+"' and NEW_CAR_ID!='"+addCar.getNEW_CAR_ID()+"'");
			   while (rs.next()) {
			    count=rs.getInt("count(*)");
			   }

			if (count == 0) {
				
				String query = "UPDATE add_car,new_car_specifications_2 SET CAR_BRAND=?,CAR_MODEL=?,VARIANT_NAME=?,NO_OF_GEARS=?,CAR_MAKE_YEAR=?,"

						+ "ENGINE_TYPE=?,ENGINE_DISPLACEMENT=?,NO_OF_CYLINDERS=?,VALVES_PER_CYLINDERS=?,MAX_POWER=?,"

						+ "MAX_TORQUE=?,FUEL_SUPPLY_SYSTEM=?,TRANSMISSION_TYPE=?,GEAR_BOX=?,WHEEL_DRIVE=?,"

						+ "FRONT_SUSPENSION=?,REAR_SUSPENSION=?,STEERING_TYPE=?,TURNING_RADIONS=?,MILEAGE=?,"

						+ "FUEL_TYPE=?,FUELTANK_CAPACITY=?,TOP_SPEED=?,ACCELERATION=?,"

						+ "FRONT_BRAKE_TYPE=?,RARE_BRAKE_TYPE=?,ANTI_LOCK_BRAKING_SYSTEM=?,TYRE_SIZE=?,WHEEL_SIZE=?,"

						+ "POWER_STEERING=?,AIR_CONDITIONER=?,REAR_AC=?,STEERING_ADJUSTMENT=?,KEYLESS_START=?,"

						+ "PARKING_SENSORS=?,PARKING_ASSIST=?,AIR_BAGS=?,SEAT_BELT_WARNING=?,BODY_TYPE=?,TYRE_TYPE=? ,COLOR=?"
						
						+ " where add_car.NEW_CAR_ID = new_car_specifications_2.NEW_CAR_ID and add_car.NEW_CAR_ID='"+addCar.getNEW_CAR_ID() + "'";
				
		
				PreparedStatement preparedStatement = conn.prepareStatement(query);

				preparedStatement.setString(1, addCar.getCAR_BRAND());
				preparedStatement.setString(2, addCar.getCAR_MODEL());
				preparedStatement.setString(3, addCar.getVARIANT_NAME());
				preparedStatement.setString(4, addCar.getNO_OF_GEARS());
				preparedStatement.setString(5, addCar.getCAR_MAKE_YEAR());
				preparedStatement.setString(6, addCar.getENGINE_TYPE());
				preparedStatement.setString(7, addCar.getENGINE_DISPLACEMENT());

				preparedStatement.setString(8, addCar.getNO_OF_CYLINDERS());
				preparedStatement.setString(9, addCar.getVALVES_PER_CYLINDERS());
				preparedStatement.setString(10, addCar.getMAX_POWER());
				preparedStatement.setString(11, addCar.getMAX_TORQUE());
				preparedStatement.setString(12, addCar.getFUEL_SUPPLY_SYSTEM());
				preparedStatement.setString(13, addCar.getTRANSMISSION_TYPE());
				preparedStatement.setString(14, addCar.getGEAR_BOX());
				preparedStatement.setString(15, addCar.getWHEEL_DRIVE());
				preparedStatement.setString(16, addCar.getFRONT_SUSPENSION());
				preparedStatement.setString(17, addCar.getREAR_SUSPENSION());

				preparedStatement.setString(18, addCar.getSTEERING_TYPE());
				preparedStatement.setString(19, addCar.getTURNING_RADIONS());

				preparedStatement.setString(20, addCar.getMILEAGE());
				preparedStatement.setString(21, addCar.getFUEL_TYPE());
				preparedStatement.setString(22, addCar.getFUELTANK_CAPACITY());
				preparedStatement.setString(23, addCar.getTOP_SPEED());
				preparedStatement.setString(24, addCar.getACCELERATION());

				preparedStatement.setString(25, addCar.getFRONT_BRAKE_TYPE());
				preparedStatement.setString(26, addCar.getRARE_BRAKE_TYPE());
				preparedStatement.setString(27, addCar.getANTI_LOCK_BRAKING_SYSTEM());
				preparedStatement.setString(28, addCar.getTYRE_SIZE());
				preparedStatement.setString(29, addCar.getWHEEL_SIZE());

				preparedStatement.setString(30, addCar.getPOWER_STEERING());
				preparedStatement.setString(31, addCar.getAIR_CONDITIONER());
				preparedStatement.setString(32, addCar.getREAR_AC());
				preparedStatement.setString(33, addCar.getSTEERING_ADJUSTMENT());
				preparedStatement.setString(34, addCar.getKEYLESS_START());

				preparedStatement.setString(35, addCar.getPARKING_SENSORS());
				preparedStatement.setString(36, addCar.getPARKING_ASSIST());
				preparedStatement.setString(37, addCar.getAIR_BAGS());
				preparedStatement.setString(38, addCar.getSEAT_BELT_WARNING());
				preparedStatement.setString(39, addCar.getBODY_TYPE());
                preparedStatement.setString(40, addCar.getTYRE_TYPE());
                preparedStatement.setString(41, addCar.getCOLOR());
                
   				int i1 = preparedStatement.executeUpdate();
				
			
				
				if (i1 > 0) {
					message = "success";
				} else {
					message = "failure";
				}
				preparedStatement.close();
			} else {
				message = "Already Exits";
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {

				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}}
		return message;
	}
	
	
	public boolean addNewCarPrice(ArrayList<BikePrice> al)
	{
		boolean flag=false;
		PreparedStatement st = null;
		try {
			
			
			
			conn = DBConnection.getConnection();
			st=conn.prepareStatement("INSERT INTO `vehicle_price_table` (`SEQ_NO`, `ITEM_NAME`, `PRICE`, `NEW_VEHICLE_ID`, `USER_ID`) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			for(int i=0;i<al.size();i++)
			{
				BikePrice bikeprice=al.get(i);
				st.setInt(1, bikeprice.getSEQ_NO());
				st.setString(2, bikeprice.getITEM_NAME());
				st.setString(3, bikeprice.getPRICE());
				st.setString(4, bikeprice.getNEW_VEHICLE_ID());
				st.setString(5, bikeprice.getUSER_ID());
				st.addBatch();
			}
			
			
			int i[]=st.executeBatch();
			
			if(i.length>0)
			{
				flag=true;
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public ArrayList<BikePrice> checkNewCarPrice(ArrayList<BikePrice> al)
	{
		Statement pst=null;
		conn = DBConnection.getConnection();
		try {
			pst=conn.createStatement();
			for(int i=0;i<al.size();i++)
			{
				BikePrice bp=al.get(i);
			String query="SELECT * FROM vehicle_price_table where ITEM_NAME = '"+bp.getITEM_NAME()+"' and NEW_VEHICLE_ID = '"+bp.getNEW_VEHICLE_ID()+"'  and USER_ID = '"+bp.getUSER_ID()+"'";
			
			Statement st = null;
			ResultSet rs = null;
			st=conn.createStatement();
			rs=st.executeQuery(query);
			if(rs.next())
			{
				pst.addBatch("delete from vehicle_price_table where SEQ_NO = '"+rs.getString("SEQ_NO")+"'");
			
			}
			
			rs.close();
			st.close();
			
			}
		int a[]=	pst.executeBatch();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return al;
		
	}
	
	public String getNewCarId(String brand, String model,String variant,String makeYear)
	{
		String newcarid=null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select NEW_CAR_ID from add_car where car_brand = '"+brand+"' and CAR_MODEL = '"+model+"' and VARIANT_NAME = '"+variant+"' and CAR_MAKE_YEAR = '"+makeYear+"'";
			
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			if (rs.next()) {
				newcarid=rs.getString("NEW_CAR_ID");
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
		return newcarid;
	}
	@Override
	public boolean addNewCarOffer(ArrayList<VehicleOffer> al)
	{
		boolean flag=false;
		PreparedStatement st = null;
		try {
			
			conn = DBConnection.getConnection();
			st=conn.prepareStatement("INSERT INTO `vehicle_offers_table` (`SEQ_ID`, `OFFER_NAME`, `DESCRIPTION`, `PRICE`, `NEW_VEHICLE_ID`, `USER_ID`, `STATUS`) VALUES (?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			for(int i=0;i<al.size();i++)
			{
				VehicleOffer vo=al.get(i);
				st.setInt(1, vo.getSEQ_ID());
				st.setString(2, vo.getOFFER_NAME());
				st.setString(3, vo.getDESCRIPTION());
				st.setString(4, vo.getPRICE());
				st.setString(5, vo.getNEW_VEHICLE_ID());
				st.setString(6, vo.getUSER_ID());
				st.setString(7, "1");
				st.addBatch();
			}
			int[] a=st.executeBatch();
			
			if(a.length>0)
			{
				flag=true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	@Override
	public ArrayList<VehicleOffer> checkNewCarOffer(ArrayList<VehicleOffer> al)
	{
			Statement pst=null;
			conn = DBConnection.getConnection();
			try {
				pst=conn.createStatement();
				for(int i=0;i<al.size();i++)
				{
					VehicleOffer vo=al.get(i);
					String query="SELECT * FROM vehicle_offers_table where NEW_VEHICLE_ID = '"+vo.getNEW_VEHICLE_ID()+"'  and OFFER_NAME = '"+vo.getOFFER_NAME()+"' and USER_ID = '"+vo.getUSER_ID()+"'  and STATUS ='1'";
				Statement st = null;
				ResultSet rs = null;
				st=conn.createStatement();
				rs=st.executeQuery(query);
				if(rs.next())
				{
					pst.addBatch("delete from vehicle_offers_table where SEQ_ID = '"+rs.getString("SEQ_ID")+"'");
				}
				
				rs.close();
				st.close();
				
				}
				pst.executeBatch();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					pst.close();
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return al;
	}
	
	@Override
	public ArrayList<AddCar> getDealerAuthorisedCarBrand(String userid) {
		ArrayList<AddCar> carAl = new ArrayList<AddCar>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select * from dealer_authentication where DEALER_NAME = '"+userid+"' and STATUS = 'A' and DEALER_AUTHENTICATION = 'Yes' and VEHICLE_TYPE = '4,'";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				AddCar car = new AddCar();
				car.setCAR_BRAND(rs.getString("BRAND_NAME"));
				carAl.add(car);
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
	 public String updateNewCarMoredetails(AddCar addCar, String user_name) {
	  // TODO Auto-generated method stub
	  Statement st = null;
	  ResultSet rs = null;
	  String message = null;
	  int count=0;
	  try {
	   st = conn.createStatement();
	   rs = st.executeQuery("Select count(*) from add_car where CAR_MODEL='"+addCar.getCAR_MODEL()+"' and VARIANT_NAME='"+addCar.getVARIANT_NAME()+"' and NEW_CAR_ID!='"+addCar.getNEW_CAR_ID()+"'");
	   while (rs.next()) {
	    count=rs.getInt("count(*)");
	   }
	   
	   if(count==0){
	   
	   String query = "UPDATE add_car SET CAR_BRAND=?,CAR_MODEL=?,VARIANT_NAME=?,NO_OF_GEARS=?,CAR_MAKE_YEAR=?,"
	     
	                                   + "ENGINE_TYPE=?,ENGINE_DISPLACEMENT=?,NO_OF_CYLINDERS=?,VALVES_PER_CYLINDERS=?,MAX_POWER=?,"
	                                   
	                                   + "MAX_TORQUE=?,FUEL_SUPPLY_SYSTEM=?,TRANSMISSION_TYPE=?,GEAR_BOX=?,WHEEL_DRIVE=?,"
	                                   
	                                   + "FRONT_SUSPENSION=?,REAR_SUSPENSION=?,STEERING_TYPE=?,TURNING_RADIONS=?,MILEAGE=?,"
	                                   
	                                   + "FUEL_TYPE=?,FUELTANK_CAPACITY=?,TOP_SPEED=?,ACCELERATION=?,"
	                                   
	                                   + "FRONT_BRAKE_TYPE=?,RARE_BRAKE_TYPE=?,ANTI_LOCK_BRAKING_SYSTEM=?,TYRE_SIZE=?,WHEEL_SIZE=?,"
	                                   
	                                   + "POWER_STEERING=?,AIR_CONDITIONER=?,REAR_AC=?,STEERING_ADJUSTMENT=?,KEYLESS_START=?,"
	                                   
	                                   + "PARKING_SENSORS=?,PARKING_ASSIST=?,AIR_BAGS=?,SEAT_BELT_WARNING=? where NEW_CAR_ID='"+addCar.getNEW_CAR_ID()+"'";
	   
	   PreparedStatement preparedStatement = conn.prepareStatement(query);
	   
	   
	      preparedStatement.setString(1, addCar.getCAR_BRAND());
	      preparedStatement.setString(2, addCar.getCAR_MODEL());
	      preparedStatement.setString(3, addCar.getVARIANT_NAME());
	      preparedStatement.setString(4, addCar.getNO_OF_GEARS());
	      preparedStatement.setString(5, addCar.getCAR_MAKE_YEAR());
	      preparedStatement.setString(6, addCar.getENGINE_TYPE());
	      preparedStatement.setString(7, addCar.getENGINE_DISPLACEMENT());
	      
	      preparedStatement.setString(8, addCar.getNO_OF_CYLINDERS());
	      preparedStatement.setString(9, addCar.getVALVES_PER_CYLINDERS());
	      preparedStatement.setString(10, addCar.getMAX_POWER());
	      preparedStatement.setString(11, addCar.getMAX_TORQUE());
	      preparedStatement.setString(12, addCar.getFUEL_SUPPLY_SYSTEM());
	      preparedStatement.setString(13, addCar.getTRANSMISSION_TYPE());
	      preparedStatement.setString(14, addCar.getGEAR_BOX());
	      preparedStatement.setString(15, addCar.getWHEEL_DRIVE());
	      preparedStatement.setString(16, addCar.getFRONT_SUSPENSION());
	      preparedStatement.setString(17, addCar.getREAR_SUSPENSION());
	      
	      preparedStatement.setString(18, addCar.getSTEERING_TYPE());
	      preparedStatement.setString(19, addCar.getTURNING_RADIONS());
	      
	      preparedStatement.setString(20, addCar.getMILEAGE());
	      preparedStatement.setString(21, addCar.getFUEL_TYPE());
	      preparedStatement.setString(22, addCar.getFUELTANK_CAPACITY());
	      preparedStatement.setString(23, addCar.getTOP_SPEED());
	      preparedStatement.setString(24, addCar.getACCELERATION());
	      
	      preparedStatement.setString(25, addCar.getFRONT_BRAKE_TYPE());
	      preparedStatement.setString(26, addCar.getRARE_BRAKE_TYPE());
	      preparedStatement.setString(27, addCar.getANTI_LOCK_BRAKING_SYSTEM());
	      preparedStatement.setString(28, addCar.getTYRE_SIZE());
	      preparedStatement.setString(29, addCar.getWHEEL_SIZE());
	      
	      preparedStatement.setString(30, addCar.getPOWER_STEERING());
	      preparedStatement.setString(31, addCar.getAIR_CONDITIONER());
	      preparedStatement.setString(32, addCar.getREAR_AC());
	      preparedStatement.setString(33, addCar.getSTEERING_ADJUSTMENT());
	      preparedStatement.setString(34, addCar.getKEYLESS_START());
	      
	      preparedStatement.setString(35, addCar.getPARKING_SENSORS());
	      preparedStatement.setString(36, addCar.getPARKING_ASSIST());
	      preparedStatement.setString(37, addCar.getAIR_BAGS());
	      preparedStatement.setString(38, addCar.getSEAT_BELT_WARNING());
	   
	   int i1 = preparedStatement.executeUpdate();
	   if (i1 > 0  ) {
	    message = "success";
	   } else {
	    message = "failure";
	   }
	   preparedStatement.close();
	  }
	   else{
	  message="Already Exits";
	   }
	  
	  
	  }
	  
	  catch (SQLException e) {
	   e.printStackTrace();
	  }
	  finally {
			try {

				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}}
	  return message;
	 }

	@Override
	public ArrayList<AddCar> getExshowRoomPriceList(String varient_id, int offset, int noOfRecords) {
		// TODO Auto-generated method stub
		String query = null;
		query = "SELECT SQL_CALC_FOUND_ROWS * from exshowroom_price_table  where NEW_CAR_ID='"+varient_id+"' limit " + offset + ", " + noOfRecords;
		ArrayList<AddCar> al = getNewCarDetailsExShowdetails(query);
		return al;
	}
	public ArrayList<AddCar> getNewCarDetailsExShowdetails(String query) {
		ArrayList<AddCar> al = new ArrayList<AddCar>();
		Statement stmt = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				AddCar ad = new AddCar();
				/*exshowroompricetab*/
				ad.setEXPRICE_SEQ_ID(rs.getInt("EXPRICE_SEQ_ID"));
				ad.setEX_SHOW_ROOM_PRICE(rs.getString("EX_SHOW_ROOM_PRICE"));
				ad.setEX_SHOW_ROOM_PRICE_PLACE(rs.getString("EX_SHOW_ROOM_PRICE_PLACE"));
				ad.setUPDATED_DATE_TIME(new SQLDate().getInDate(rs.getString("UPDATED_DATE_TIME")));
				ad.setNEW_CAR_ID(rs.getString("NEW_CAR_ID"));
				al.add(ad);
			}
			rs = stmt.executeQuery("SELECT FOUND_ROWS()");
			if (rs.next())
				this.noOfRecords = rs.getInt(1);
		} catch (Exception e) {
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
		}
		return al;
	}

	@Override
	public String aInsertExShowroomPrice(String car_id, String place, String price) {
		  String message = null;
		  Statement st = null;
		  ResultSet rs = null;
		  int count=0;
		  try {
			  
			    st = conn.createStatement();
			    
			    rs = st.executeQuery("select count(*) from exshowroom_price_table where NEW_CAR_ID='"+car_id+"' and EX_SHOW_ROOM_PRICE_PLACE='"+place+"'");
			    while (rs.next()) {
			     count=rs.getInt("count(*)");
			    }
		    
		    
		    if(count==0){
		     
		
		     String query = "insert into exshowroom_price_table values (?,?,?,?,CURDATE())";
		     
		     PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		     
		     preparedStatement.setInt(1, 0);
		     preparedStatement.setString(2, car_id);
		     preparedStatement.setString(3, price);
		     preparedStatement.setString(4, place);
		    
		     
		     int i1 = preparedStatement.executeUpdate();
		     
		     if(i1>0){
		    	 message="Price Successfully Added";
		    	 
		     }
		     else{
		    	 message="ERROR";
		     }
		    	 
		    }else{
		    message="Price for this State Already Exits";
		    }
		    st.close();
		    rs.close();
		    
		    } catch (SQLException e) {
		     e.printStackTrace();
		    }
		  finally {
				try {

					conn.close();

				} catch (Exception e) {
					e.printStackTrace();
				}}
		    return message;
	}

	@Override
	public AddCar getBrandModelVarientBycarId(String car_id) {
    AddCar car=new AddCar();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select CAR_BRAND,CAR_MODEL,VARIANT_NAME,CAR_MAKE_YEAR from add_car where NEW_CAR_ID='"+car_id+"'";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				car.setCAR_BRAND(rs.getString("CAR_BRAND"));
				car.setCAR_MODEL(rs.getString("CAR_MODEL"));
				car.setVARIANT_NAME(rs.getString("VARIANT_NAME"));
				car.setCAR_MAKE_YEAR(rs.getString("CAR_MAKE_YEAR"));
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
		return car;
	}

	@Override
	public String getExshowroomprice(String car_id, String place) {
		// TODO Auto-generated method stub
		AddCar car=new AddCar();
		Statement st = null;
		ResultSet rs = null;
		String price="";
		try {
			String query = "select EX_SHOW_ROOM_PRICE from exshowroom_price_table where NEW_CAR_ID='"+car_id+"' and EX_SHOW_ROOM_PRICE_PLACE like '%"+place+"%' group by '%"+place+"%'";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			
		
			while (rs.next()) {
				price=rs.getString("EX_SHOW_ROOM_PRICE");
				
				
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
		return price;
	}

	@Override
	public String aupdateExShowroomPrice(String car_id, String place, String price) {
		// TODO Auto-generated method stub
		String message= null;
		Connection conn= null;
		try {
			String sql = "update exshowroom_price_table set EX_SHOW_ROOM_PRICE='"+price+"' where NEW_CAR_ID='"+car_id+"' and EX_SHOW_ROOM_PRICE_PLACE='"+place+"'";
			conn = DBConnection.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			
	
			int i = preparedStatement.executeUpdate();

			if (i > 0) {
				message = "Price Successfully Updated";
			} else {
				message = "failure";
			}
			preparedStatement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {

				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}}
		return message;
	}

	@Override
	public boolean addNewCars(List<NewCar> cardetails) {
		// TODO Auto-generated method stub
boolean b=false;
		
		int id = new IdGen().getNewIds("NEW_CAR_ID");

		String carId = null;
		String addcarquery="INSERT INTO `add_car` (`SEQUENCE_NO`, `USER_NAME`, `CAR_BRAND`, `CAR_MODEL`, `VARIANT_NAME`, `NO_OF_GEARS`, `CAR_MAKE_YEAR`, `ENGINE_TYPE`, `ENGINE_DISPLACEMENT`, `NO_OF_CYLINDERS`, `VALVES_PER_CYLINDERS`, `MAX_POWER`, `MAX_TORQUE`, `FUEL_SUPPLY_SYSTEM`, `TRANSMISSION_TYPE`, `GEAR_BOX`, `WHEEL_DRIVE`, `FRONT_SUSPENSION`, `REAR_SUSPENSION`, `STEERING_TYPE`, `TURNING_RADIONS`, `MILEAGE`, `FUEL_TYPE`, `FUELTANK_CAPACITY`, `TOP_SPEED`, `ACCELERATION`, `FRONT_BRAKE_TYPE`, `RARE_BRAKE_TYPE`, `ANTI_LOCK_BRAKING_SYSTEM`, `TYRE_SIZE`, `WHEEL_SIZE`, `POWER_STEERING`, `AIR_CONDITIONER`, `REAR_AC`, `STEERING_ADJUSTMENT`, `KEYLESS_START`, `PARKING_SENSORS`, `PARKING_ASSIST`, `AIR_BAGS`, `SEAT_BELT_WARNING`, `NEW_CAR_ID` ,`COLOR`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String specifquery="INSERT INTO `new_car_specifications` (`SEQUENCE_NO`, `NEW_CAR_ID`, `ENGINE_IMMOBILIZER`, `CENTRAL_LOCKING_SYSTEM`, `CHILD_LOCKING_SYSTEM`, `AUTOMATIC_HEAD_LAMPS`, `FOR_LAMPS`, `TAIL_LAMPS`, `HEAD_LIGHT`, `HEIGHT_ADJUSTER`, `MUSIC_SYSTEM`, `DISPLAY`, `DISPLAY_SCREEN_REAR_PASSENGERS`, `GPS_NAVIGATION_SYSTEM`, `SPEAKERS`, `USB_COMPATIBILITY`, `MP3_PLAYER`, `CD_PLAYER`, `DVD_PLAYER`, `FM_RADIO`, `WARRANTY_YEAR`, `WARRANTY_KMS`, `CLOCK`, `LOW_FUEL_LEVEL_WARNING`, `DOOR_CLOSE_WARNING`, `POWER_WINDOWS`, `REAR_DETOGGER`, `REAR_WIPER`, `RAIN_SENSING_WIPER`, `NO_OF_DOORS`, `SEATING_CAPACITY`, `ADJUST_PASSENGER_SEAT`, `FOLDING_REAR_SEAT`, `SPLIT_RARE_SEAT`, `LENGTH`, `WIDTH`, `HEIGHT`, `WHEEL_BASE`, `GROUND_CLEARANCE`) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String specif2query="INSERT INTO `new_car_specifications_2` (`SEQUENCE_NO`, `NEW_CAR_ID`, `BODY_TYPE`, `TYRE_TYPE`, `BOOT_SPACE`, `KRAB_WEIGHT`, `BLUETOOTH`, `TRIP_METER`, `GEAR_SHIFT_INDICATOR`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//		String imagesquery = "insert into new_car_photos values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		String updcarquery="UPDATE `add_car` SET `NO_OF_GEARS`=?, `ENGINE_TYPE`=?, `ENGINE_DISPLACEMENT`=?, `NO_OF_CYLINDERS`=?, `VALVES_PER_CYLINDERS`=?,"
				+ " `MAX_POWER`=?, `MAX_TORQUE`=?, `FUEL_SUPPLY_SYSTEM`=?, `TRANSMISSION_TYPE`=?, `GEAR_BOX`=?, `WHEEL_DRIVE`=?, `FRONT_SUSPENSION`=?, "
				+ "`REAR_SUSPENSION`=?, `STEERING_TYPE`=?, `TURNING_RADIONS`=?, `MILEAGE`=?, `FUEL_TYPE`=?, `FUELTANK_CAPACITY`=?, `TOP_SPEED`=?, "
				+ "`ACCELERATION`=?, `FRONT_BRAKE_TYPE`=?, `RARE_BRAKE_TYPE`=?, `ANTI_LOCK_BRAKING_SYSTEM`=?, `TYRE_SIZE`=?, `WHEEL_SIZE`=?, "
				+ "`POWER_STEERING`=?, `AIR_CONDITIONER`=?, `REAR_AC`=?, `STEERING_ADJUSTMENT`=?, `KEYLESS_START`=?, `PARKING_SENSORS`=?, "
				+ "`PARKING_ASSIST`=?, `AIR_BAGS`=?, `SEAT_BELT_WARNING`=?,`COLOR`=? WHERE `SEQUENCE_NO`=?";
		String updspecifquery="UPDATE `new_car_specifications` SET `ENGINE_IMMOBILIZER`=?, `CENTRAL_LOCKING_SYSTEM`=?, `CHILD_LOCKING_SYSTEM`=?, `AUTOMATIC_HEAD_LAMPS`=?,"
				+ " `FOR_LAMPS`=?, `TAIL_LAMPS`=?, `HEAD_LIGHT`=?, `HEIGHT_ADJUSTER`=?, `MUSIC_SYSTEM`=?, `DISPLAY`=?, `DISPLAY_SCREEN_REAR_PASSENGERS`=?, "
				+ "`GPS_NAVIGATION_SYSTEM`=?, `SPEAKERS`=?, `USB_COMPATIBILITY`=?, `MP3_PLAYER`=?, `CD_PLAYER`=?, `DVD_PLAYER`=?, `FM_RADIO`=?, "
				+ "`WARRANTY_YEAR`=?, `WARRANTY_KMS`=?, `CLOCK`=?, `LOW_FUEL_LEVEL_WARNING`=?, `DOOR_CLOSE_WARNING`=?, `POWER_WINDOWS`=?, `REAR_DETOGGER`=?,"
				+ " `REAR_WIPER`=?, `RAIN_SENSING_WIPER`=?, `NO_OF_DOORS`=?, `SEATING_CAPACITY`=?, `ADJUST_PASSENGER_SEAT`=?, `FOLDING_REAR_SEAT`=?, "
				+ "`SPLIT_RARE_SEAT`=?, `LENGTH`=?, `WIDTH`=?, `HEIGHT`=?, `WHEEL_BASE`=?, `GROUND_CLEARANCE`=? WHERE `NEW_CAR_ID`=?";
		String updspecif2query="UPDATE `new_car_specifications_2` SET `BODY_TYPE`=?, `TYRE_TYPE`=?, `BOOT_SPACE`=?, `KRAB_WEIGHT`=?, `BLUETOOTH`=?, `TRIP_METER`=?,"
				+ " `GEAR_SHIFT_INDICATOR`=? WHERE `NEW_CAR_ID`=?";
		
		
		PreparedStatement addcarpst=null;
		PreparedStatement specificationspst=null;
		PreparedStatement specifications2pst=null;
//		PreparedStatement pstmt =null;
		
		PreparedStatement updcarpst=null;
		PreparedStatement updspecificationspst=null;
		PreparedStatement updspecifications2pst=null;
		
		ArrayList<AddCar> carsdetails=new ArrayList<AddCar>();
		
		int carsequenceno=0;
		InputStream is = null;
		
		try {
			//conn.setAutoCommit(false);
			addcarpst=conn.prepareStatement(addcarquery, Statement.RETURN_GENERATED_KEYS);
			specificationspst=conn.prepareStatement(specifquery, Statement.RETURN_GENERATED_KEYS);
			specifications2pst=conn.prepareStatement(specif2query, Statement.RETURN_GENERATED_KEYS);
//			pstmt = conn.prepareStatement(imagesquery, Statement.RETURN_GENERATED_KEYS);
			
			updcarpst=conn.prepareStatement(updcarquery);
			updspecificationspst=conn.prepareStatement(updspecifquery);
			updspecifications2pst=conn.prepareStatement(updspecif2query);
			
			for(int i=0;i<cardetails.size();i++)
			{
				NewCar car=cardetails.get(i);
				carsdetails=getNewCarsDetails("SELECT * from add_car where car_brand = '"+car.getCAR_BRAND()+"' and car_model = '"+car.getCAR_MODEL()+"' and variant_name = '"+car.getVARIANT_NAME()+"' and car_make_year = '"+car.getCAR_MAKE_YEAR()+"'");
			
				if(carsdetails.size()<=0)
				{
				carId = new NewVehicleIds().newCarId(Integer.valueOf(id).toString());
				id++;
				addcarpst.setString(1, car.getSEQUENCE_ID());
				addcarpst.setString(2, "vmadmin@kosurisoft.com");
				addcarpst.setString(3, car.getCAR_BRAND());
				addcarpst.setString(4, car.getCAR_MODEL());
				addcarpst.setString(5, car.getVARIANT_NAME());
				addcarpst.setString(6, car.getNO_OF_GEARS());
				addcarpst.setString(7, car.getCAR_MAKE_YEAR());
				addcarpst.setString(8, car.getENGINE_TYPE());
				addcarpst.setString(9, car.getENGINE_DISPLACEMENT());
				addcarpst.setString(10, car.getNO_OF_CYLINDERS());
				addcarpst.setString(11, car.getVALVES_PER_CYLINDERS());
				addcarpst.setString(12, car.getMAX_POWER());
				addcarpst.setString(13, car.getMAX_TORQUE());
				addcarpst.setString(14, car.getFUEL_SUPPLY_SYSTEM());
				addcarpst.setString(15, car.getTRANSMISSION_TYPE());
				addcarpst.setString(16, car.getGEAR_BOX());
				addcarpst.setString(17, car.getWHEEL_DRIVE());
				addcarpst.setString(18, car.getFRONT_SUSPENSION());
				addcarpst.setString(19, car.getREAR_SUSPENSION());
				addcarpst.setString(20, car.getSTEERING_TYPE());
				addcarpst.setString(21, car.getTURNING_RADIONS());
				addcarpst.setString(22, car.getMILEAGE());
				addcarpst.setString(23, car.getFUEL_TYPE());
				addcarpst.setString(24, car.getFUEL_TANK_CAPACITY() );
				addcarpst.setString(25, car.getTOP_SPEED()	);
				addcarpst.setString(26, car.getACCELERATION());
				addcarpst.setString(27, car.getFRONT_BRAKE_TYPE());
				addcarpst.setString(28, car.getRARE_BRAKE_TYPE());
				addcarpst.setString(29, car.getANTI_LOCK_BRAKING_SYSTEM());
				addcarpst.setString(30, car.getTYRE_SIZE());
				addcarpst.setString(31, car.getWHEEL_SIZE());
				addcarpst.setString(32, car.getPOWER_STEERING());
				addcarpst.setString(33, car.getAIR_CONDITIONER());
				addcarpst.setString(34, car.getREAR_AC());
				addcarpst.setString(35, car.getSTEERING_ADJUSTMENT());
				addcarpst.setString(36, car.getKEYLESS_START());
				addcarpst.setString(37, car.getPARKING_SENSORS());
				addcarpst.setString(38, car.getPARKING_ASSIST());
				addcarpst.setString(39, car.getAIR_BAGS());
				addcarpst.setString(40, car.getSEAT_BELT_WARNING());
				addcarpst.setString(41, carId);
				addcarpst.setString(42, car.getCOLOR());
				
				specificationspst.setString(1, car.getSEQUENCE_ID());
				specificationspst.setString(2, carId);
				specificationspst.setString(3, car.getENGINE_IMMOBILIZER());
				specificationspst.setString(4, car.getCENTRAL_LOCKING_SYSTEM());
				specificationspst.setString(5, car.getCHILD_LOCKING_SYSTEM());
				specificationspst.setString(6, car.getAUTOMATIC_HEAD_LAMPS());
				specificationspst.setString(7, car.getFOR_LAMPS());
				specificationspst.setString(8, car.getTAIL_LAMPS());
				specificationspst.setString(9, car.getHEAD_LIGHT());
				specificationspst.setString(10, car.getHEIGHT_ADJUSTER());
				specificationspst.setString(11, car.getMUSIC_SYSTEM());
				specificationspst.setString(12, car.getDISPLAY());
				specificationspst.setString(13, car.getDISPLAY_SCREEN_REAR_PASSENGERS());
				specificationspst.setString(14, car.getGPS_NAVIGATION_SYSTEM());
				specificationspst.setString(15, car.getSPEAKERS());
				specificationspst.setString(16, car.getUSB_COMPATIBILITY());
				specificationspst.setString(17, car.getMP3_PLAYER());
				specificationspst.setString(18, car.getCD_PLAYER());
				specificationspst.setString(19, car.getDVD_PLAYER());
				specificationspst.setString(20, car.getFM_RADIO());
				specificationspst.setString(21, car.getWARRANTY_YEAR());
				specificationspst.setString(22, car.getWARRANTY_KMS());
				specificationspst.setString(23, car.getCLOCK());
				specificationspst.setString(24, car.getLOW_FUEL_LEVEL_WARNING());
				specificationspst.setString(25, car.getDOOR_CLOSE_WARNING());
				specificationspst.setString(26, car.getPOWER_WINDOWS());
				specificationspst.setString(27, car.getREAR_DETOGGER());
				specificationspst.setString(28, car.getREAR_WIPER());
				specificationspst.setString(29, car.getRAIN_SENSING_WIPER());
				specificationspst.setString(30, car.getNO_OF_DOORS());
				specificationspst.setString(31, car.getSEATING_CAPACITY());
				specificationspst.setString(32, car.getADJUST_PASSENGER_SEAT());
				specificationspst.setString(33, car.getFOLDING_REAR_SEAT());
				specificationspst.setString(34, car.getSPLIT_RARE_SEAT());
				specificationspst.setString(35, car.getLENGTH());
				specificationspst.setString(36, car.getWIDTH());
				specificationspst.setString(37, car.getHEIGHT());
				specificationspst.setString(38, car.getWHEEL_BASE());
				specificationspst.setString(39, car.getGROUND_CLEARANCE());
				
				specifications2pst.setString(1, car.getSEQUENCE_ID());
				specifications2pst.setString(2, carId);
				specifications2pst.setString(3, car.getBODY_TYPE());
				specifications2pst.setString(4, car.getTYRE_TYPE());
				specifications2pst.setString(5, car.getBOOT_SPACE());
				specifications2pst.setString(6, car.getKRAB_WEIGHT());
				specifications2pst.setString(7, car.getBLUETOOTH());
				specifications2pst.setString(8, car.getTRIP_METER());
				specifications2pst.setString(9, car.getGEAR_SHIFT_INDICATOR());
				
				/*pstmt.setString(1, car.getSEQUENCE_ID());
			     pstmt.setString(2, carId);
			     pstmt.setBinaryStream(3, car.getImage());
			     pstmt.setBinaryStream(4, car.getImage());
			     pstmt.setBinaryStream(5, car.getImage());
			     pstmt.setBinaryStream(6, car.getImage());
			     pstmt.setBinaryStream(7, car.getImage());
			     pstmt.setBinaryStream(8, car.getImage());
			     pstmt.setBinaryStream(9, car.getImage());
			     pstmt.setBinaryStream(10, car.getImage());
			     pstmt.setBinaryStream(11, car.getImage());
			     pstmt.setBinaryStream(12, car.getImage());
			     pstmt.setBinaryStream(13, car.getImage());
			     pstmt.setBinaryStream(14, car.getImage());*/
			     
				addcarpst.addBatch();
				specificationspst.addBatch();
				specifications2pst.addBatch();
//				pstmt.addBatch();
				}
				else
				{
					carsequenceno = carsdetails.get(0).getSEQUENCE_NO();
					
					updcarpst.setString(1, car.getNO_OF_GEARS());
					updcarpst.setString(2, car.getENGINE_TYPE());
					updcarpst.setString(3, car.getENGINE_DISPLACEMENT());
					updcarpst.setString(4, car.getNO_OF_CYLINDERS());
					updcarpst.setString(5, car.getVALVES_PER_CYLINDERS());
					updcarpst.setString(6, car.getMAX_POWER());
					updcarpst.setString(7, car.getMAX_TORQUE());
					updcarpst.setString(8, car.getFUEL_SUPPLY_SYSTEM());
					updcarpst.setString(9, car.getTRANSMISSION_TYPE());
					updcarpst.setString(10, car.getGEAR_BOX());
					updcarpst.setString(11, car.getWHEEL_DRIVE());
					updcarpst.setString(12, car.getFRONT_SUSPENSION());
					updcarpst.setString(13, car.getREAR_SUSPENSION());
					updcarpst.setString(14, car.getSTEERING_TYPE());
					updcarpst.setString(15, car.getTURNING_RADIONS());
					updcarpst.setString(16, car.getMILEAGE());
					updcarpst.setString(17, car.getFUEL_TYPE());
					updcarpst.setString(18, car.getFUEL_TANK_CAPACITY() );
					updcarpst.setString(19, car.getTOP_SPEED()	);
					updcarpst.setString(20, car.getACCELERATION());
					updcarpst.setString(21, car.getFRONT_BRAKE_TYPE());
					updcarpst.setString(22, car.getRARE_BRAKE_TYPE());
					updcarpst.setString(23, car.getANTI_LOCK_BRAKING_SYSTEM());
					updcarpst.setString(24, car.getTYRE_SIZE());
					updcarpst.setString(25, car.getWHEEL_SIZE());
					updcarpst.setString(26, car.getPOWER_STEERING());
					updcarpst.setString(27, car.getAIR_CONDITIONER());
					updcarpst.setString(28, car.getREAR_AC());
					updcarpst.setString(29, car.getSTEERING_ADJUSTMENT());
					updcarpst.setString(30, car.getKEYLESS_START());
					updcarpst.setString(31, car.getPARKING_SENSORS());
					updcarpst.setString(32, car.getPARKING_ASSIST());
					updcarpst.setString(33, car.getAIR_BAGS());
					updcarpst.setString(34, car.getSEAT_BELT_WARNING());
					updcarpst.setString(35, car.getCOLOR());
					updcarpst.setInt(36, carsequenceno);
					
					updspecificationspst.setString(1, car.getENGINE_IMMOBILIZER());
					updspecificationspst.setString(2, car.getCENTRAL_LOCKING_SYSTEM());
					updspecificationspst.setString(3, car.getCHILD_LOCKING_SYSTEM());
					updspecificationspst.setString(4, car.getAUTOMATIC_HEAD_LAMPS());
					updspecificationspst.setString(5, car.getFOR_LAMPS());
					updspecificationspst.setString(6, car.getTAIL_LAMPS());
					updspecificationspst.setString(7, car.getHEAD_LIGHT());
					updspecificationspst.setString(8, car.getHEIGHT_ADJUSTER());
					updspecificationspst.setString(9, car.getMUSIC_SYSTEM());
					updspecificationspst.setString(10, car.getDISPLAY());
					updspecificationspst.setString(11, car.getDISPLAY_SCREEN_REAR_PASSENGERS());
					updspecificationspst.setString(12, car.getGPS_NAVIGATION_SYSTEM());
					updspecificationspst.setString(13, car.getSPEAKERS());
					updspecificationspst.setString(14, car.getUSB_COMPATIBILITY());
					updspecificationspst.setString(15, car.getMP3_PLAYER());
					updspecificationspst.setString(16, car.getCD_PLAYER());
					updspecificationspst.setString(17, car.getDVD_PLAYER());
					updspecificationspst.setString(18, car.getFM_RADIO());
					updspecificationspst.setString(19, car.getWARRANTY_YEAR());
					updspecificationspst.setString(20, car.getWARRANTY_KMS());
					updspecificationspst.setString(21, car.getCLOCK());
					updspecificationspst.setString(22, car.getLOW_FUEL_LEVEL_WARNING());
					updspecificationspst.setString(23, car.getDOOR_CLOSE_WARNING());
					updspecificationspst.setString(24, car.getPOWER_WINDOWS());
					updspecificationspst.setString(25, car.getREAR_DETOGGER());
					updspecificationspst.setString(26, car.getREAR_WIPER());
					updspecificationspst.setString(27, car.getRAIN_SENSING_WIPER());
					updspecificationspst.setString(28, car.getNO_OF_DOORS());
					updspecificationspst.setString(29, car.getSEATING_CAPACITY());
					updspecificationspst.setString(30, car.getADJUST_PASSENGER_SEAT());
					updspecificationspst.setString(31, car.getFOLDING_REAR_SEAT());
					updspecificationspst.setString(32, car.getSPLIT_RARE_SEAT());
					updspecificationspst.setString(33, car.getLENGTH());
					updspecificationspst.setString(34, car.getWIDTH());
					updspecificationspst.setString(35, car.getHEIGHT());
					updspecificationspst.setString(36, car.getWHEEL_BASE());
					updspecificationspst.setString(37, car.getGROUND_CLEARANCE());
					updspecificationspst.setString(38, carsdetails.get(0).getNEW_CAR_ID());
					
					updspecifications2pst.setString(1, car.getBODY_TYPE());
					updspecifications2pst.setString(2, car.getTYRE_TYPE());
					updspecifications2pst.setString(3, car.getBOOT_SPACE());
					updspecifications2pst.setString(4, car.getKRAB_WEIGHT());
					updspecifications2pst.setString(5, car.getBLUETOOTH());
					updspecifications2pst.setString(6, car.getTRIP_METER());
					updspecifications2pst.setString(7, car.getGEAR_SHIFT_INDICATOR());
					updspecifications2pst.setString(8, carsdetails.get(0).getNEW_CAR_ID());
					
					updcarpst.addBatch();
					updspecificationspst.addBatch();
					updspecifications2pst.addBatch();
				}
			}
			int[] car=addcarpst.executeBatch();
			int[] spec1=specificationspst.executeBatch();
			int[] spec2=specifications2pst.executeBatch();
//			int[] pstm=pstmt.executeBatch();
			
			int[] updcar=updcarpst.executeBatch();
			int[] updspec1=updspecificationspst.executeBatch();
			int[] updspec2=updspecifications2pst.executeBatch();
			
				b=true;
				new IdGen().updateNewId("NEW_CAR_ID", id);
				//conn.commit();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return b;
	}
	
	
	public ArrayList<BikePrice> getNewVehiclePriceDetails(String query) {
		ArrayList<BikePrice> al = new ArrayList<BikePrice>();
		Statement stmt = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				BikePrice price=new BikePrice();
			price.setSEQ_NO(rs.getInt("SEQ_NO"));
			price.setITEM_NAME(rs.getString("ITEM_NAME"));
			price.setPRICE(rs.getString("PRICE"));
			price.setNEW_VEHICLE_ID(rs.getString("NEW_VEHICLE_ID"));
		    price.setUSER_ID(rs.getString("USER_ID"));
		    al.add(price);
				
			}
			rs = stmt.executeQuery("SELECT FOUND_ROWS()");
			if (rs.next())
				this.noOfRecords = rs.getInt(1);
		} catch (Exception e) {
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
		}
		return al;
	}

	@Override
	public ArrayList<BikePrice> getVehiclePricedetails(String vehicle_id,String email) {
		// TODO Auto-generated method stub
		String query = null;
		query = "SELECT  * from vehicle_price_table  where NEW_VEHICLE_ID='"+vehicle_id+"' and USER_ID='"+email+"'";
		ArrayList<BikePrice> al = getNewVehiclePriceDetails(query);
	
		return al;
	}

	@Override
	public String updatePrice(String seq_id,String price,String item,String vch_id) {
		// TODO Auto-generated method stub
		  String message = null;
		  Statement st = null;
		  ResultSet rs = null;
		  int count=0;
		Connection conn= null;
		try {
			conn = DBConnection.getConnection();

			   st = conn.createStatement();
			    
			    rs = st.executeQuery("SELECT count(*)  from vehicle_price_table where NEW_VEHICLE_ID='"+vch_id+"' and ITEM_NAME='"+item+"' and PRICE='"+price+"' and SEQ_NO!='"+seq_id+"'");
			    while (rs.next()) {
			     count=rs.getInt("count(*)");
			    }
		    
		    
		    if(count==0){
			String sql = "update vehicle_price_table set ITEM_NAME='"+item+"',PRICE='"+price+"' where SEQ_NO='"+seq_id+"'";
			
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
		
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				message = "Data Successfully Updated";
			} else {
				message = "failure";
			}
			preparedStatement.close();
			conn.close();
		    }
			else
			{
				message = "This Data Already Exist";
			}	
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
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
	public ArrayList<BikePrice> getVehiclePricedetailsValues(String seq_id) {
		// TODO Auto-generated method stub
		String query = null;
		query = "SELECT  * from vehicle_price_table  where SEQ_NO='"+seq_id+"'";
		ArrayList<BikePrice> al = getNewVehiclePriceDetails(query);
		return al;
	}

	@Override
	public HashMap<String, String> getPriceitem(String vch_id, String e_id) {
		HashMap<String, String> chm=new HashMap<String, String>();
		Statement st=null;
		ResultSet rs=null;
		try
		{
			   conn = DBConnection.getConnection();
			   st = conn.createStatement();
			rs=st.executeQuery("select ITEM_NAME,PRICE from vehicle_price_table where NEW_VEHICLE_ID='"+vch_id+"' and USER_ID='"+e_id+"'");
			while(rs.next())
			{
				chm.put(rs.getString("ITEM_NAME"), rs.getString("PRICE"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
				st.close();
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return chm;
	}

	@Override
	public Set<AddCar> getNewCarYearByVariantName(String brand,String model, String variant) {
		// TODO Auto-generated method stub
		Set<AddCar> carAl = new HashSet<AddCar>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select CAR_MAKE_YEAR from add_car where car_brand='"+brand+"' and car_model='"+model+"' and VARIANT_NAME='"+variant+"' group by VARIANT_NAME";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				AddCar newCar = new AddCar();
				newCar.setCAR_MAKE_YEAR(rs.getString("CAR_MAKE_YEAR"));
				carAl.add(newCar);
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
	public boolean checkexshowroomprice(String id){
		  Statement st = null;
		  ResultSet rs = null;
		  
		 boolean flag=false;
		  int count=0;
		  try {
			  conn = DBConnection.getConnection();
			   st = conn.createStatement();
			   rs = st.executeQuery("select count(*) from exshowroom_price_table where NEW_CAR_ID='"+id+"'");
			 
			   while (rs.next()) {
			    count=rs.getInt("count(*)");
			   }
			if (count > 0) {
				flag=true;
			}
			else{
				flag=false;
			}
		  
		
			rs.close();
			  st.close();
		  
		  } 
		  catch (SQLException e) {
			e.printStackTrace();
		}
		  finally
			{
				try {
					conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return flag;
		
	}

	@Override
	public ArrayList<AddCar> getNewCarwithAdvanceFilter(String brand, String vModel, String vVariant, String madeyear,
			String bodytype, String fueltype, String transmission, String color,String budget, int offset, int noOfRecords) {
		String query = null;
		String price1=null;
		String price2=null;
		String mainqurey="SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where";
		String conditionqurey="";
		if (budget!= null) {
			if (budget.equals("SELECT") ) {

			} else {
				CarAge carAge = new CarAge();
				ArrayList carAl1 = carAge.getPrice(budget);
				price1 = (String) carAl1.get(0);
				price2 = (String) carAl1.get(1);
			}
		}
		

		if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT") && bodytype.equals("SELECT") && fueltype.equals("SELECT") && transmission.equals("SELECT") && color.equals("SELECT")&& budget.equals("SELECT")){
			
			query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID limit " + offset + ", " + noOfRecords;
		}
		
		
		else if(bodytype.equals("SELECT") && fueltype.equals("SELECT") && transmission.equals("SELECT") && color.equals("SELECT")&& budget.equals("SELECT") && color.equals("SELECT")){
		
		
              if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
            	  query = mainqurey+" CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' limit " + offset + ", " + noOfRecords;
				           
			     }
              else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
            	  query = mainqurey+" CAR_BRAND= '"+brand+"'  limit " + offset + ", " + noOfRecords;
  				            
  		      	}
              else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
  				
  				query = mainqurey+" CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  limit " + offset + ", " + noOfRecords;
  		     	
              }
              else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
  				
  				query = mainqurey+" CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"'  limit " + offset + ", " + noOfRecords;
  		      
              }
              else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
  				
  				query = mainqurey+" CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' limit " + offset + ", " + noOfRecords;
  			    
              }
              else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
  				
  				query = mainqurey+" CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  and CAR_MAKE_YEAR='"+madeyear+"' limit " + offset + ", " + noOfRecords;
  			   
              }
          	
              else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
   				
   				query = mainqurey+" CAR_MAKE_YEAR='"+madeyear+"' limit " + offset + ", " + noOfRecords;
   			   
              }
             
		
		   }
		
		else if(!bodytype.equals("SELECT") && fueltype.equals("SELECT") && transmission.equals("SELECT") && budget.equals("SELECT") && color.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		     	query = mainqurey+" CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = mainqurey+" CAR_BRAND= '"+brand+"' and  BODY_TYPE='"+bodytype+"' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = mainqurey+" CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and BODY_TYPE='"+bodytype+"' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = mainqurey+" CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"'  and BODY_TYPE='"+bodytype+"' limit " + offset + ", " + noOfRecords;
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = mainqurey+" CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' limit " + offset + ", " + noOfRecords;
			}
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = mainqurey+" BODY_TYPE='"+bodytype+"' limit " + offset + ", " + noOfRecords;
			}
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		     	query = mainqurey+" CAR_MAKE_YEAR='"+madeyear+"' and  BODY_TYPE='"+bodytype+"' limit " + offset + ", " + noOfRecords;
			}
		
		
		}
		
		
		
		else if(!fueltype.equals("SELECT") && bodytype.equals("SELECT") && transmission.equals("SELECT") && budget.equals("SELECT") && color.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and  FUEL_TYPE='"+fueltype+"' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and FUEL_TYPE='"+fueltype+"' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"'  and FUEL_TYPE='"+fueltype+"' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  and CAR_MAKE_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"' limit " + offset + ", " + noOfRecords;
			}
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where FUEL_TYPE='"+fueltype+"' limit " + offset + ", " + noOfRecords;
			}
			
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_MAKE_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"' limit " + offset + ", " + noOfRecords;
			}
		}
		
		else if(!transmission.equals("SELECT") && bodytype.equals("SELECT") && fueltype.equals("SELECT") && budget.equals("SELECT") && color.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and  TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"'  and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  and CAR_MAKE_YEAR='"+madeyear+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;
			}
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;
			}
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where  CAR_MAKE_YEAR='"+madeyear+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;
			}
		}
		
		
		/*budget filter*/
		
		
		else if(!budget.equals("SELECT") && bodytype.equals("SELECT") && fueltype.equals("SELECT") && transmission.equals("SELECT") && color.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where  CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%'  and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%'  and  CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%'  and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%'   and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  and CAR_MAKE_YEAR='"+madeyear+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%'   and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;
			}
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;
			}
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where  CAR_MAKE_YEAR='"+madeyear+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%'  CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;
			}
		}
		
       /*color*/
		else if(!color.equals("SELECT") && bodytype.equals("SELECT") && fueltype.equals("SELECT") && transmission.equals("SELECT") && budget.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and  COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"'  and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  and CAR_MAKE_YEAR='"+madeyear+"' and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;
			}
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;
			}
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where  CAR_MAKE_YEAR='"+madeyear+"' and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;
			}
		}
		
		
		
		
		
		
		
		
		/*brand+model+variant+madeyear+bodytype+fueltype+transmission*/
		
		else if(!bodytype.equals("SELECT")&&!fueltype.equals("SELECT") &&!transmission.equals("SELECT") && budget.equals("SELECT")){
		
		if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
		}
		
		else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
		}
		
		else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
		}
		
		else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
		}
		else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
		}
		else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where  BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
		}
		
		else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
		}
		
		}
		
		/*brand+model+variant+madeyear+bodytype+fueltype+transmission+budget*/
		
		else if(!bodytype.equals("SELECT")&&!fueltype.equals("SELECT") &&!transmission.equals("SELECT") &&!budget.equals("SELECT")){
			
		if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
		}
		
		else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
		}
		
		else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
		}
		
		else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
		}
		else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
		}
		else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where  EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and  BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
		}
		
		else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
		}
		
		}
		
		
		
	/*brand+model+variant+madeyear+bodytype+fueltype+transmission+budget+color*/
		
		else if(!bodytype.equals("SELECT")&&!fueltype.equals("SELECT") &&!transmission.equals("SELECT") &&!budget.equals("SELECT")){
			
		if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
		}
		
		else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
		}
		
		else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
		}
		
		else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
		}
		else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
		}
		else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where  EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and  BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
		}
		
		else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
		}
		
		}
		
		
		
		
		
		
		/*bodytype+fueltype*/
		
		else if(!bodytype.equals("SELECT") && !fueltype.equals("SELECT") && transmission.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"'  limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where  BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"'  limit " + offset + ", " + noOfRecords;	
			}
		
		
		}
		
	/*	bodytype+fueltype+transmission*/
		
		else if(!bodytype.equals("SELECT") && !fueltype.equals("SELECT") && !transmission.equals("SELECT") && budget.equals("SELECT")){
			
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"'  limit " + offset + ", " + noOfRecords;	
			
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
			}
           else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"'  limit " + offset + ", " + noOfRecords;	
			
			}
		
		}
		
		/*bodytypr+fuel+transmission+budget-----*/
	else if(!bodytype.equals("SELECT") && !fueltype.equals("SELECT") && !transmission.equals("SELECT") && !budget.equals("SELECT")&& color.equals("SELECT")){
			
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"'  limit " + offset + ", " + noOfRecords;	
			
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
			}
           else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where  EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"'  limit " + offset + ", " + noOfRecords;	
			
			}
		
		}
		
		
		
		
		
		
		
		
		
		
		
		/*bodytype+transmission*/
		else if(!bodytype.equals("SELECT") && fueltype.equals("SELECT") && !transmission.equals("SELECT")&&budget.equals("SELECT")&& color.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'   and TRANSMISSION_TYPE='"+transmission+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and BODY_TYPE='"+bodytype+"'   and TRANSMISSION_TYPE='"+transmission+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  and BODY_TYPE='"+bodytype+"'   and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BODY_TYPE='"+bodytype+"'  and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'   and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
			}
			else if( brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where  BODY_TYPE='"+bodytype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
			}
		
		}
		
		/*fuel+transmission*/
		else if(bodytype.equals("SELECT") && !fueltype.equals("SELECT") && !transmission.equals("SELECT") && budget.equals("SELECT")&& color.equals("SELECT")){
			
			
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"'   and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and FUEL_TYPE='"+fueltype+"'   and TRANSMISSION_TYPE='"+transmission+"'   limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  and FUEL_TYPE='"+fueltype+"'   and TRANSMISSION_TYPE='"+transmission+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"'  limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"'   and TRANSMISSION_TYPE='"+transmission+"'  limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"'  limit " + offset + ", " + noOfRecords;	
			}
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where  FUEL_TYPE='"+fueltype+"'   and TRANSMISSION_TYPE='"+transmission+"'   limit " + offset + ", " + noOfRecords;	
			}
		
		}
		
		/*bodytype+budget*/
		
		else if(!bodytype.equals("SELECT") && fueltype.equals("SELECT") && transmission.equals("SELECT") && !budget.equals("SELECT") &&color.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and BODY_TYPE='"+bodytype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  and BODY_TYPE='"+bodytype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BODY_TYPE='"+bodytype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where  BODY_TYPE='"+bodytype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
		
		}
		
		/*fuel+budget*/
		else if(bodytype.equals("SELECT") && !fueltype.equals("SELECT") && transmission.equals("SELECT") && !budget.equals("SELECT")&& color.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where  FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
		
		}
		
		/*transmission+budget*/
		else if(bodytype.equals("SELECT") && fueltype.equals("SELECT") && !transmission.equals("SELECT") && !budget.equals("SELECT")&& color.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"'  and TRANSMISSION_TYPE='"+transmission+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"'  and TRANSMISSION_TYPE='"+transmission+"'    and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'   and TRANSMISSION_TYPE='"+transmission+"'    and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"'  and TRANSMISSION_TYPE='"+transmission+"'    and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"'  and TRANSMISSION_TYPE='"+transmission+"'    and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"'  and TRANSMISSION_TYPE='"+transmission+"'    and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and TRANSMISSION_TYPE='"+transmission+"'  limit " + offset + ", " + noOfRecords;	
			}
		
		}
		
		/*body+fuel+budget*/
		
		else if(!bodytype.equals("SELECT") && !fueltype.equals("SELECT") && transmission.equals("SELECT") && !budget.equals("SELECT")&& color.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and BODY_TYPE='"+bodytype+"' and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BODY_TYPE='"+bodytype+"' and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
		
		}
		
		/*body+transmission+budget*/
		

		else if(!bodytype.equals("SELECT") && fueltype.equals("SELECT") && !transmission.equals("SELECT") && !budget.equals("SELECT")&& color.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and TRANSMISSION_TYPE='"+transmission+"'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and BODY_TYPE='"+bodytype+"' and TRANSMISSION_TYPE='"+transmission+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and BODY_TYPE='"+bodytype+"'  and TRANSMISSION_TYPE='"+transmission+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BODY_TYPE='"+bodytype+"' and TRANSMISSION_TYPE='"+transmission+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' and TRANSMISSION_TYPE='"+transmission+"'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' and TRANSMISSION_TYPE='"+transmission+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where BODY_TYPE='"+bodytype+"' and TRANSMISSION_TYPE='"+transmission+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			
		
		}
		
		
		/*fuel+transmission+budget*/
		
		
		else if(bodytype.equals("SELECT") && !fueltype.equals("SELECT") && !transmission.equals("SELECT") && !budget.equals("SELECT") && color.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"'  and TRANSMISSION_TYPE='"+transmission+"'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and FUEL_TYPE='"+fueltype+"'  and TRANSMISSION_TYPE='"+transmission+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where  FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
		
		}
//		 bodytype+color

		else if(!color.equals("SELECT")&&!bodytype.equals("SELECT") && fueltype.equals("SELECT") && transmission.equals("SELECT")&& budget.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'   and COLOR like '%"+color+"%'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and BODY_TYPE='"+bodytype+"'   and COLOR like '%"+color+"%'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  and BODY_TYPE='"+bodytype+"'   and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BODY_TYPE='"+bodytype+"'  and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'   and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
			}
			else if( brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where  BODY_TYPE='"+bodytype+"' and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
			}
		
		}
		
		/*fueltype+color*/
		
else if(!color.equals("SELECT")&& !fueltype.equals("SELECT")  &&bodytype.equals("SELECT") && transmission.equals("SELECT") && budget.equals("SELECT")){
			
			
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"'   and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and FUEL_TYPE='"+fueltype+"'   and COLOR like '%"+color+"%'   limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  and FUEL_TYPE='"+fueltype+"'   and COLOR like '%"+color+"%'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'  limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"'   and COLOR like '%"+color+"%'  limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'  limit " + offset + ", " + noOfRecords;	
			}
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where  FUEL_TYPE='"+fueltype+"'   and COLOR like '%"+color+"%'   limit " + offset + ", " + noOfRecords;	
			}
		
		}
		
		/*transmission+color*/
else if(bodytype.equals("SELECT") && !fueltype.equals("SELECT") && !transmission.equals("SELECT") && budget.equals("SELECT") &&!color.equals("SELECT")){
	
	
	if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and COLOR like '%"+color+"%'   and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and COLOR like '%"+color+"%'   and TRANSMISSION_TYPE='"+transmission+"'   limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  and COLOR like '%"+color+"%'   and TRANSMISSION_TYPE='"+transmission+"'  limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and COLOR like '%"+color+"%' and TRANSMISSION_TYPE='"+transmission+"'  limit " + offset + ", " + noOfRecords;	
	}
	else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and COLOR like '%"+color+"%'   and TRANSMISSION_TYPE='"+transmission+"'  limit " + offset + ", " + noOfRecords;	
	}
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and COLOR like '%"+color+"%' and TRANSMISSION_TYPE='"+transmission+"'  limit " + offset + ", " + noOfRecords;	
	}
	else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where   COLOR like '%"+color+"%'   and TRANSMISSION_TYPE='"+transmission+"'   limit " + offset + ", " + noOfRecords;	
	}

}
		/*budget+color*/
else if(bodytype.equals("SELECT") && fueltype.equals("SELECT") && transmission.equals("SELECT") && !budget.equals("SELECT")&&!color.equals("SELECT")){
	if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"'  and COLOR like '%"+color+"%'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"'  and COLOR like '%"+color+"%'    and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'   and COLOR like '%"+color+"%'    and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"'  and COLOR like '%"+color+"%'    and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
	}
	else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"'  and COLOR like '%"+color+"%'    and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"'  and COLOR like '%"+color+"%'    and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and COLOR like '%"+color+"%'  limit " + offset + ", " + noOfRecords;	
	}

}
	
		/*body+fuel+color*/
		
else if(!bodytype.equals("SELECT") && !fueltype.equals("SELECT") && transmission.equals("SELECT")&& budget.equals("SELECT")&&!color.equals("SELECT")){
	if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'  limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'  limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
	}
	else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'  limit " + offset + ", " + noOfRecords;	
	}
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'  limit " + offset + ", " + noOfRecords;	
	}
	
	else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID  where  BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'  limit " + offset + ", " + noOfRecords;	
	}


}
		
		/*body+fuel+budject+color*/
		
		
else if(!bodytype.equals("SELECT") && !fueltype.equals("SELECT") && transmission.equals("SELECT") && !budget.equals("SELECT") &&!color.equals("SELECT")){
	if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and BODY_TYPE='"+bodytype+"' and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  and BODY_TYPE='"+bodytype+"' and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BODY_TYPE='"+bodytype+"' and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
	}
	else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}

}
		
		/*body+transmission+budget+color*/
		
else if(!bodytype.equals("SELECT") && fueltype.equals("SELECT") &&! transmission.equals("SELECT") && !budget.equals("SELECT") &&!color.equals("SELECT")){
	
	
	
	
	if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and BODY_TYPE='"+bodytype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  and BODY_TYPE='"+bodytype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BODY_TYPE='"+bodytype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
	}
	else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where BODY_TYPE='"+bodytype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}

}
		
		/*fuel+tramission+budget+color*/
		
else if(bodytype.equals("SELECT") && !fueltype.equals("SELECT") && transmission.equals("SELECT") && !budget.equals("SELECT") &&!color.equals("SELECT")){
	if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
	}
	else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}

}
		
		/*fuel+transmission+color*/
		
		
else if(bodytype.equals("SELECT") && !fueltype.equals("SELECT") && !transmission.equals("SELECT") && budget.equals("SELECT") &&!color.equals("SELECT")){
	if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%'   limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%'   limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%'  limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%'   limit " + offset + ", " + noOfRecords;	
	}
	else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%'    limit " + offset + ", " + noOfRecords;	
	}
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%'    limit " + offset + ", " + noOfRecords;	
	}

}
	
		/*transmission+body+color*/
		
else if(!bodytype.equals("SELECT") && fueltype.equals("SELECT") && !transmission.equals("SELECT") && budget.equals("SELECT") &&!color.equals("SELECT")){
	if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%'   limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and BODY_TYPE='"+bodytype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%'   limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"'  and BODY_TYPE='"+bodytype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%'  limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BODY_TYPE='"+bodytype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%'   limit " + offset + ", " + noOfRecords;	
	}
	else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%'    limit " + offset + ", " + noOfRecords;	
	}
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' and TRANSMISSION_TYPE='"+transmission+"' and COLOR like '%"+color+"%'  limit " + offset + ", " + noOfRecords;	
	}

}	
		
		/*transmission+buget+color*/

else if(bodytype.equals("SELECT") && fueltype.equals("SELECT") && !transmission.equals("SELECT") && !budget.equals("SELECT")&&!color.equals("SELECT")){
	if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and COLOR like '%"+color+"%'   and TRANSMISSION_TYPE='"+transmission+"'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and COLOR like '%"+color+"%'  and TRANSMISSION_TYPE='"+transmission+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and COLOR like '%"+color+"%'   and TRANSMISSION_TYPE='"+transmission+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and COLOR like '%"+color+"%'  and TRANSMISSION_TYPE='"+transmission+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
	}
	else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and COLOR like '%"+color+"%'  and TRANSMISSION_TYPE='"+transmission+"'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and COLOR like '%"+color+"%'  and TRANSMISSION_TYPE='"+transmission+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	
	else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where COLOR like '%"+color+"%'  and TRANSMISSION_TYPE='"+transmission+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}

}
		
//		bodytype+budject+col
		

else if(!bodytype.equals("SELECT") && fueltype.equals("SELECT") && transmission.equals("SELECT") && !budget.equals("SELECT") &&!color.equals("SELECT")){
	

	if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and COLOR like '%"+color+"%'   and BODY_TYPE='"+bodytype+"'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and COLOR like '%"+color+"%'  and BODY_TYPE='"+bodytype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and COLOR like '%"+color+"%'   and BODY_TYPE='"+bodytype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and COLOR like '%"+color+"%'  and BODY_TYPE='"+bodytype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
	}
	else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and COLOR like '%"+color+"%'  and BODY_TYPE='"+bodytype+"'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and COLOR like '%"+color+"%'  and BODY_TYPE='"+bodytype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	
	else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where COLOR like '%"+color+"%'  and BODY_TYPE='"+bodytype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where  BODY_TYPE='"+bodytype+"' and COLOR like '%"+color+"%'    and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}

}
		
		/*fuel+budget+color*/

else if(bodytype.equals("SELECT") && !fueltype.equals("SELECT") && transmission.equals("SELECT") && !budget.equals("SELECT") &&!color.equals("SELECT")){
	

	if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and CAR_MAKE_YEAR='"+madeyear+"' and COLOR like '%"+color+"%'   and FUEL_TYPE='"+fueltype+"'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and COLOR like '%"+color+"%'  and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and COLOR like '%"+color+"%'   and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID  where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and COLOR like '%"+color+"%'  and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
	}
	else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"'  and CAR_MAKE_YEAR='"+madeyear+"' and COLOR like '%"+color+"%'  and FUEL_TYPE='"+fueltype+"'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where CAR_BRAND= '"+brand+"' and CAR_MODEL='"+vModel+"' and CAR_MAKE_YEAR='"+madeyear+"' and COLOR like '%"+color+"%'  and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	
	else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where COLOR like '%"+color+"%'  and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}
	else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID left join exshowroom_price_table   on add_car.NEW_CAR_ID=exshowroom_price_table.NEW_CAR_ID where  FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'    and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
	}

}
		
		
		
		
		
		else{
			query = "SELECT SQL_CALC_FOUND_ROWS add_car.*,new_car_photos.*,new_car_specifications.*,new_car_specifications_2.* from add_car left join new_car_photos on add_car.NEW_CAR_ID=new_car_photos.NEW_CAR_ID left join new_car_specifications on add_car.NEW_CAR_ID=new_car_specifications.NEW_CAR_ID left join new_car_specifications_2 on add_car.NEW_CAR_ID=new_car_specifications_2.NEW_CAR_ID limit " + offset + ", " + noOfRecords;
		}
		

		ArrayList<AddCar> al = getNewCarDetails(query);
		
		return al;
	
	}

	@Override
	public ArrayList<String> getcolors() {
		
		 Statement st = null;
		  ResultSet rs = null;
		  ArrayList<String> color=new ArrayList<String>();
		  try {
			  conn = DBConnection.getConnection();
			   st = conn.createStatement();
			   
			   
			   rs = st.executeQuery("select COLOR  from add_car order by COLOR ASC");
			 
			   while (rs.next()) {
				   color.add(rs.getString("COLOR"));
			   }
		
		  
		
			rs.close();
			  st.close();
		  
		  } 
		  catch (SQLException e) {
			e.printStackTrace();
		}
		  finally
			{
				try {
					conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return color;
	}
	public ArrayList<AddCar> getNewCarImages(String query) {
		ArrayList<AddCar> al = new ArrayList<AddCar>();
		Statement stmt = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				AddCar ad = new AddCar();
				
			

				java.sql.Blob blob1 = rs.getBlob("PHOTO1");
				byte[] photo1 = blob1.getBytes(1, (int) blob1.length());
				String photo11 = Base64.encode(photo1);
				ad.setPHOTO1(photo11);
				
				java.sql.Blob blob2 = rs.getBlob("PHOTO2");
				byte[] photo2 = blob2.getBytes(1, (int) blob2.length());
				String photo12 = Base64.encode(photo2);
				ad.setPHOTO2(photo12);
				
				java.sql.Blob blob3 = rs.getBlob("PHOTO3");
				byte[] photo3 = blob3.getBytes(1, (int) blob3.length());
				String photo13 = Base64.encode(photo3);
				ad.setPHOTO3(photo13);
				
				java.sql.Blob blob4 = rs.getBlob("PHOTO4");
				byte[] photo4 = blob4.getBytes(1, (int) blob4.length());
				String photo14 = Base64.encode(photo4);
				ad.setPHOTO4(photo14);
				
				java.sql.Blob blob5 = rs.getBlob("PHOTO5");
				byte[] photo5 = blob5.getBytes(1, (int) blob5.length());
				String photo15 = Base64.encode(photo5);
				ad.setPHOTO5(photo15);
				
				java.sql.Blob blob6 = rs.getBlob("PHOTO6");
				byte[] photo6 = blob6.getBytes(1, (int) blob6.length());
				String photo16 = Base64.encode(photo6);
				ad.setPHOTO6(photo16);
				
				java.sql.Blob blob7 = rs.getBlob("PHOTO7");
				byte[] photo7 = blob7.getBytes(1, (int) blob7.length());
				String photo17 = Base64.encode(photo7);
				ad.setPHOTO7(photo17);
				
				java.sql.Blob blob8 = rs.getBlob("PHOTO8");
				byte[] photo8 = blob8.getBytes(1, (int) blob8.length());
				String photo18 = Base64.encode(photo8);
				ad.setPHOTO8(photo18);
				
				java.sql.Blob blob9 = rs.getBlob("PHOTO9");
				byte[] photo9 = blob9.getBytes(1, (int) blob9.length());
				String photo19 = Base64.encode(photo9);
				ad.setPHOTO9(photo19);
				
				java.sql.Blob blob10 = rs.getBlob("PHOTO10");
				byte[] photo10 = blob10.getBytes(1, (int) blob10.length());
				String photo20 = Base64.encode(photo10);
				ad.setPHOTO10(photo20);
				
				al.add(ad);
			}
			rs = stmt.executeQuery("SELECT FOUND_ROWS()");
			if (rs.next())
				this.noOfRecords = rs.getInt(1);
		} catch (Exception e) {
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
		}
		return al;
	}

	@Override
	public String addNewCarPhotos(String carNo, InputStream is, ArrayList<InputStream> al) {
		// TODO Auto-generated method stub
		String message = null;
		InputStream photo1 = null, photo2 = null, photo3 = null, photo4 = null, photo5 = null, photo6 = null, photo7 = null,
				photo8 = null, photo9 = null, photo10 = null, photo11 = null, photo12 = null;
		try {
			conn = DBConnection.getConnection();
			String query = "insert into new_car_photos values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";			
			 PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
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
			int id=0;
			pstmt.setInt(1, id);
		    pstmt.setString(2, carNo);
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
			pstmt.setBinaryStream(13, is);
			pstmt.setBinaryStream(14, is);

			
			int i = pstmt.executeUpdate();
			if (i > 0 ) {
				message = "success";
			} else {
				message = "failure";
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return message;
	}
	private ArrayList<AddCar> getNewCarsDetails(String query) {
		ArrayList<AddCar> al = new ArrayList<AddCar>();
		Statement stmt = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				AddCar ad = new AddCar();
				ad.setSEQUENCE_NO(Integer.parseInt(rs.getString("SEQUENCE_NO")));
				/* ad.setCAR_NUMBER(rs.getString("CAR_NUMBER")); */
				ad.setCAR_BRAND(rs.getString("CAR_BRAND"));
				ad.setCAR_MODEL(rs.getString("CAR_MODEL"));
				ad.setVARIANT_NAME(rs.getString("VARIANT_NAME"));
				ad.setNO_OF_GEARS(rs.getString("NO_OF_GEARS"));
				ad.setCAR_MAKE_YEAR(rs.getString("CAR_MAKE_YEAR"));
				ad.setENGINE_TYPE(rs.getString("ENGINE_TYPE"));
				ad.setENGINE_DISPLACEMENT(rs.getString("ENGINE_DISPLACEMENT"));
				ad.setNO_OF_CYLINDERS(rs.getString("NO_OF_CYLINDERS"));
				ad.setVALVES_PER_CYLINDERS(rs.getString("VALVES_PER_CYLINDERS"));
				ad.setMAX_POWER(rs.getString("MAX_POWER"));
				ad.setMAX_TORQUE(rs.getString("MAX_TORQUE"));
				ad.setFUEL_SUPPLY_SYSTEM(rs.getString("FUEL_SUPPLY_SYSTEM"));
				ad.setTRANSMISSION_TYPE(rs.getString("TRANSMISSION_TYPE"));
				ad.setGEAR_BOX(rs.getString("GEAR_BOX"));
				ad.setWHEEL_DRIVE(rs.getString("WHEEL_DRIVE"));
				ad.setFRONT_SUSPENSION(rs.getString("FRONT_SUSPENSION"));
				ad.setREAR_SUSPENSION(rs.getString("REAR_SUSPENSION"));
				ad.setSTEERING_TYPE(rs.getString("STEERING_TYPE"));
				ad.setTURNING_RADIONS(rs.getString("TURNING_RADIONS"));
				ad.setMILEAGE(rs.getString("MILEAGE"));
				ad.setFUEL_TYPE(rs.getString("FUEL_TYPE"));
				ad.setFUELTANK_CAPACITY(rs.getString("FUELTANK_CAPACITY"));
				ad.setTOP_SPEED(rs.getString("TOP_SPEED"));
				ad.setACCELERATION(rs.getString("ACCELERATION"));
				ad.setFRONT_BRAKE_TYPE(rs.getString("FRONT_BRAKE_TYPE"));
				ad.setRARE_BRAKE_TYPE(rs.getString("RARE_BRAKE_TYPE"));
				ad.setANTI_LOCK_BRAKING_SYSTEM(rs.getString("ANTI_LOCK_BRAKING_SYSTEM"));
				ad.setTYRE_SIZE(rs.getString("TYRE_SIZE"));
				ad.setWHEEL_SIZE(rs.getString("WHEEL_SIZE"));
				ad.setPOWER_STEERING(rs.getString("POWER_STEERING"));
				ad.setAIR_CONDITIONER(rs.getString("AIR_CONDITIONER"));
				ad.setREAR_AC(rs.getString("REAR_AC"));
				ad.setSTEERING_ADJUSTMENT(rs.getString("STEERING_ADJUSTMENT"));
				ad.setKEYLESS_START(rs.getString("KEYLESS_START"));
				ad.setPARKING_SENSORS(rs.getString("PARKING_SENSORS"));
				ad.setPARKING_ASSIST(rs.getString("PARKING_ASSIST"));
				ad.setAIR_BAGS(rs.getString("AIR_BAGS"));
				ad.setSEAT_BELT_WARNING(rs.getString("SEAT_BELT_WARNING"));
//				ad.setBODY_TYPE(rs.getString("BODY_TYPE"));
//				ad.setTYRE_TYPE(rs.getString("TYRE_TYPE"));
				ad.setNEW_CAR_ID(rs.getString("NEW_CAR_ID"));
				ad.setCOLOR(rs.getString("COLOR"));
				
				
				al.add(ad);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
		}
		return al;
	}
	@Override
	public Set<String> getbodytypeforCars(){
		
		 Statement st = null;
		  ResultSet rs = null;
		  Set<String> bodytype= new HashSet<String>();
		  try {
			  conn = DBConnection.getConnection();
			   st = conn.createStatement();
			   rs = st.executeQuery("select BODY_TYPE from new_car_specifications_2 where BODY_TYPE is not null and BODY_TYPE!='' group by BODY_TYPE");
			 
			   while (rs.next()) {
				   bodytype.add(rs.getString("BODY_TYPE"));
			   }
		
		  
		
			rs.close();
			  st.close();
		  
		  } 
		  catch (SQLException e) {
			e.printStackTrace();
		}
		  finally
			{
				try {
					conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return bodytype;
	
}
	
}