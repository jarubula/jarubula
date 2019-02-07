package com.vaahanmitra.daoImpl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.owtelse.codec.Base64;
import com.vaahanmitra.dao.AddBikeDao;
import com.vaahanmitra.dbutil.DBConnection;
import com.vaahanmitra.dbutil.IdGen;
import com.vaahanmitra.model.AddBike;
import com.vaahanmitra.model.BikePrice;
import com.vaahanmitra.model.NewBike;
import com.vaahanmitra.model.VehicleOffer;
import com.vaahanmitra.service.CarAge;
import com.vaahanmitra.utilities.NewVehicleIds;
import com.vaahanmitra.utilities.SQLDate;

public class AddBikeDaoImpl implements AddBikeDao{
	
	private int noOfRecords = 0;
	private Connection conn = DBConnection.getConnection();
	public String addBike(AddBike addBike, String user_name, InputStream is) {
		  Statement st = null;
		  ResultSet rs = null;
		  String message = null;
		  int count=0;
		  try {
			   st = conn.createStatement();
			   rs = st.executeQuery("Select count(*) from add_bike where BIKE_MODEL='"+addBike.getBIKE_MODEL()+"' and VARIANT_NAME='"+addBike.getVARIANT_NAME()+"' and BIKE_PRODUCTION_YEAR='"+addBike.getBIKE_PRODUCTION_YEAR()+"'");
			   while (rs.next()) {
			    count=rs.getInt("count(*)");
			   }
		   
			if (count == 0) {

				String id = new IdGen().getId("NEW_BIKE_ID");
				NewVehicleIds newBikeId = new NewVehicleIds();
				String bikeId = newBikeId.newBikeId(id);
				String query1 = "insert into add_bike values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				String query2 = "insert into bike_specifications values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				String query3 = "insert into new_bike_photos values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

				PreparedStatement pstmt1 = conn.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
				PreparedStatement pstmt2 = conn.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);
				PreparedStatement pstmt3 = conn.prepareStatement(query3, Statement.RETURN_GENERATED_KEYS);

				pstmt1.setInt(1, addBike.getSEQUENCE_NO());
				pstmt1.setString(2, user_name);
				pstmt1.setString(3, addBike.getBIKE_BRAND());
				pstmt1.setString(4, addBike.getBIKE_MODEL());
				pstmt1.setString(5, addBike.getVARIANT_NAME());
				pstmt1.setString(6, addBike.getCOLOR());
				pstmt1.setString(7, addBike.getBIKE_PRODUCTION_YEAR());
				pstmt1.setString(8, addBike.getENGINE_TYPE());
				pstmt1.setString(9, addBike.getDISPLACEMENT_CC());
				pstmt1.setString(10, addBike.getMAX_POWER());
				pstmt1.setString(11, addBike.getMAX_TORQUE());
				pstmt1.setString(12, addBike.getBORE());
				pstmt1.setString(13, addBike.getSTROKE());
				pstmt1.setString(14, addBike.getFUEL_SYSTEM());
				pstmt1.setString(15, addBike.getFUEL_TYPE());
				pstmt1.setString(16, addBike.getIGNITION());
				pstmt1.setString(17, addBike.getDIGITAL_FUEL_INDICATOR());
				pstmt1.setString(18, addBike.getENGINE_STARTING());
				pstmt1.setString(19, addBike.getNO_OF_GEARS());
				pstmt1.setString(20, addBike.getFRONT_BRAKE());
				pstmt1.setString(21, addBike.getREAR_BRAKE());
				pstmt1.setString(22, bikeId);

				/*
				 * pstmt1.setString(22, addBike.getTYRE_TYPE());
				 * pstmt1.setString(23, addBike.getLENGTH());
				 * pstmt1.setString(24, addBike.getWIDTH());
				 * pstmt1.setString(25, addBike.getHEIGHT());
				 * pstmt1.setString(26, addBike.getKERBWEIGHT());
				 * pstmt1.setString(27, addBike.getGROUND_CLEARANCE());
				 * pstmt1.setString(28, addBike.getFUEL_CAPACITY());
				 * pstmt1.setString(29, addBike.getBIKE_DISCRIPTION());
				 * pstmt1.setString(30, bikeId); pstmt1.setString(31,
				 * addBike.getVARIANT_NAME()); pstmt1.setString(32,
				 * addBike.getPRICE());
				 */

				pstmt2.setInt(1, addBike.getSEQUENCE_NO());
				pstmt2.setString(2, bikeId);
				pstmt2.setString(3, addBike.getMILEAGE());
				pstmt2.setString(4, addBike.getTOP_SPEED());
				pstmt2.setString(5, addBike.getCHASSIS_TYPE());
				pstmt2.setString(6, addBike.getFRONT_SUSPENSION());
				pstmt2.setString(7, addBike.getREAR_SUSPENSION());
				pstmt2.setString(8, addBike.getTYRE_TYPE());
				pstmt2.setString(9, addBike.getFRONT_TYRE());
				pstmt2.setString(10, addBike.getREAR_TYRE());
				pstmt2.setString(11, addBike.getWHEEL_SIZE());

				pstmt2.setString(12, addBike.getWHEEL_TYPE());
				pstmt2.setString(13, addBike.getLENGTH());
				pstmt2.setString(14, addBike.getWIDTH());
				pstmt2.setString(15, addBike.getHEIGHT());
				pstmt2.setString(16, addBike.getWHEEL_BASE());
				pstmt2.setString(17, addBike.getGROUND_CLEARANCE());
				pstmt2.setString(18, addBike.getFUEL_CAPACITY());
				pstmt2.setString(19, addBike.getKERBWEIGHT());
				pstmt2.setString(20, addBike.getBATTERY_CAPACITY());
				pstmt2.setString(21, addBike.getHEAD_LAMP());
				pstmt2.setString(22, addBike.getSTANDARD_WARRANTY_YEARS());
				pstmt2.setString(23, addBike.getSTANDARD_WARRANTY_KMS());

				pstmt3.setInt(1, addBike.getSEQUENCE_NO());
				pstmt3.setString(2, bikeId);
				pstmt3.setBinaryStream(3, is);
				pstmt3.setBinaryStream(4, is);
				pstmt3.setBinaryStream(5, is);
				pstmt3.setBinaryStream(6, is);
				pstmt3.setBinaryStream(7, is);
				pstmt3.setBinaryStream(8, is);
				pstmt3.setBinaryStream(9, is);
				pstmt3.setBinaryStream(10, is);
				pstmt3.setBinaryStream(11, is);
				pstmt3.setBinaryStream(12, is);
				pstmt3.setBinaryStream(13, is);
				pstmt3.setBinaryStream(14, is);

				int i1 = pstmt1.executeUpdate();
				int i2 = pstmt2.executeUpdate();
				int i3 = pstmt3.executeUpdate();

				if (i1 > 0 && i2 > 0 && i3 > 0) {
					message = "success";
				} else {
					message = "failure";
				}
				pstmt1.close();
				pstmt2.close();
				pstmt3.close();
			} else {
				message = "Alerdy Exits";
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		  finally {
				try {

					rs.close();
					st.close();
					conn.close();

				} catch (Exception e) {
					e.printStackTrace();
				}}
		return message;
	} 
	
	public ArrayList<AddBike> getBikeBrand(String email) {

		ArrayList<AddBike> bikeAl = new ArrayList<AddBike>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select bike_brand from used_bike where user_name='"+email+"' and bike_brand is not null group by bike_brand";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				AddBike bike = new AddBike();
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
	public ArrayList<AddBike> getBikeModel(String bikeModel) {
		ArrayList<AddBike> bikeAl = new ArrayList<AddBike>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select bike_model from add_bike where bike_brand='" + bikeModel + "' and BIKE_MODEL is not null group by bike_model";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				AddBike newBike = new AddBike();
				newBike.setBIKE_MODEL(rs.getString("BIKE_MODEL"));
				bikeAl.add(newBike);
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
	public ArrayList<AddBike> getBikeBrand() {

		ArrayList<AddBike> bikeAl = new ArrayList<AddBike>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select bike_brand from add_bike where bike_brand is not null group by bike_brand";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				AddBike bike = new AddBike();
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
	public ArrayList<AddBike> getBikeBrands(String bikeBrand) {
		ArrayList<AddBike> bikeAl = new ArrayList<AddBike>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select bike_brand from add_bike where bike_brand is not null group by bike_brand";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				AddBike bike = new AddBike();
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
	public ArrayList<AddBike> getNewBike(String brand,String vModel,String vVariant,String madeyear, int offset, int noOfRecords) {
		String query = null;
		if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
			
			
			query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.* from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  limit " + offset + ", " + noOfRecords;
		}
		
		else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
			
			query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.* from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' limit " + offset + ", " + noOfRecords;
		}
      
		else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
			
			query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.* from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"'  limit " + offset + ", " + noOfRecords;
		}
      
       else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
			
			query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.* from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"'  limit " + offset + ", " + noOfRecords;
		
       }
       else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
			
			query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.* from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"'  limit " + offset + ", " + noOfRecords;
		}
		
       else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
			
			query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.* from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"'  and BIKE_PRODUCTION_YEAR='"+madeyear+"' limit " + offset + ", " + noOfRecords;
		}
		
		ArrayList<AddBike> al = getNewBikeDetails(query);
	
		
		return al;
	}
	public ArrayList<AddBike> getNewBikeDetails(String query) {
		ArrayList<AddBike> al = new ArrayList<AddBike>();
		
		Statement stmt = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				AddBike ab = new AddBike();
				ab.setSEQUENCE_NO(Integer.parseInt(rs.getString("SEQUENCE_NO")));
				
				/* ad.setBIKE_NUMBER(rs.getString("BIKE_NUMBER")); */
				   ab.setBIKE_BRAND(rs.getString("BIKE_BRAND"));
				ab.setBIKE_MODEL(rs.getString("BIKE_MODEL"));
				ab.setVARIANT_NAME(rs.getString("VARIANT_NAME"));
				ab.setCOLOR(rs.getString("COLOR"));
				ab.setBIKE_PRODUCTION_YEAR(rs.getString("BIKE_PRODUCTION_YEAR"));
				ab.setENGINE_TYPE(rs.getString("ENGINE_TYPE"));
				ab.setDISPLACEMENT_CC(rs.getString("DISPLACEMENT_CC"));
				ab.setMAX_POWER(rs.getString("MAX_POWER"));
				ab.setMAX_TORQUE(rs.getString("MAX_TORQUE"));
				ab.setBORE(rs.getString("BORE"));
				ab.setSTROKE(rs.getString("STROKE"));
				ab.setFUEL_SYSTEM(rs.getString("FUEL_SYSTEM"));
				ab.setFUEL_TYPE(rs.getString("FUEL_TYPE"));
				ab.setIGNITION(rs.getString("IGNITION"));
				ab.setDIGITAL_FUEL_INDICATOR(rs.getString("DIGITAL_FUEL_INDICATOR"));
				ab.setENGINE_STARTING(rs.getString("ENGINE_STARTING")); 
				ab.setNO_OF_GEARS(rs.getString("NO_OF_GEARS"));
				ab.setFRONT_BRAKE(rs.getString("FRONT_BRAKE"));
				ab.setREAR_BRAKE(rs.getString("REAR_BRAKE"));

				/* bike specificartions */

				ab.setMILEAGE(rs.getString("MILEAGE"));
				ab.setTOP_SPEED(rs.getString("TOP_SPEED"));
				ab.setCHASSIS_TYPE(rs.getString("CHASSIS_TYPE"));
				ab.setFRONT_SUSPENSION(rs.getString("FRONT_SUSPENSION"));
				ab.setREAR_SUSPENSION(rs.getString("REAR_SUSPENSION"));
				ab.setTYRE_TYPE(rs.getString("TYRE_TYPE"));
				ab.setFRONT_TYRE(rs.getString("FRONT_TYRE"));
				ab.setREAR_TYRE(rs.getString("REAR_TYRE"));
				ab.setWHEEL_SIZE(rs.getString("WHEEL_SIZE"));
				ab.setWHEEL_TYPE(rs.getString("WHEEL_TYPE"));
				ab.setLENGTH(rs.getString("LENGTH"));
				ab.setWIDTH(rs.getString("WIDTH"));
				ab.setHEIGHT(rs.getString("HEIGHT"));
				ab.setWHEEL_BASE(rs.getString("WHEEL_BASE"));
				ab.setGROUND_CLEARANCE(rs.getString("GROUND_CLEARANCE"));
				ab.setFUEL_CAPACITY(rs.getString("FUEL_CAPACITY"));
				ab.setKERBWEIGHT(rs.getString("KERBWEIGHT"));
				ab.setBATTERY_CAPACITY(rs.getString("BATTERY_CAPACITY"));
				ab.setHEAD_LAMP(rs.getString("HEAD_LAMP"));
				ab.setSTANDARD_WARRANTY_YEARS(rs.getString("STANDARD_WARRANTY_YEARS"));
				ab.setSTANDARD_WARRANTY_KMS(rs.getString("STANDARD_WARRANTY_KMS"));
				ab.setNEW_BIKE_ID(rs.getString("NEW_BIKE_ID"));

				java.sql.Blob blob1 = rs.getBlob("PHOTO1");
				byte[] photo1 = blob1.getBytes(1, (int) blob1.length());
				String photo11 = Base64.encode(photo1);
				ab.setPHOTO1(photo11);

				java.sql.Blob blob2 = rs.getBlob("PHOTO2");
				byte[] photo2 = blob2.getBytes(1, (int) blob2.length());
				String photo12 = Base64.encode(photo2);
				ab.setPHOTO2(photo12);

				java.sql.Blob blob3 = rs.getBlob("PHOTO3");
				byte[] photo3 = blob3.getBytes(1, (int) blob3.length());
				String photo13 = Base64.encode(photo3);
				ab.setPHOTO3(photo13);

				java.sql.Blob blob4 = rs.getBlob("PHOTO4");
				byte[] photo4 = blob4.getBytes(1, (int) blob4.length());
				String photo14 = Base64.encode(photo4);
				ab.setPHOTO4(photo14);
		   
				java.sql.Blob blob5 = rs.getBlob("PHOTO5");
				byte[] photo5 = blob5.getBytes(1, (int) blob5.length());
				String photo15 = Base64.encode(photo5);
				ab.setPHOTO5(photo15);

				java.sql.Blob blob6 = rs.getBlob("PHOTO6");
				byte[] photo6 = blob6.getBytes(1, (int) blob6.length());
				String photo16 = Base64.encode(photo6);
				ab.setPHOTO6(photo16);

				java.sql.Blob blob7 = rs.getBlob("PHOTO7");
				byte[] photo7 = blob7.getBytes(1, (int) blob7.length());
				String photo17 = Base64.encode(photo7);
				ab.setPHOTO7(photo17);

				java.sql.Blob blob8 = rs.getBlob("PHOTO8");
				byte[] photo8 = blob8.getBytes(1, (int) blob8.length());
				String photo18 = Base64.encode(photo8);
				ab.setPHOTO8(photo18);

				java.sql.Blob blob9 = rs.getBlob("PHOTO9");
				byte[] photo9 = blob9.getBytes(1, (int) blob9.length());
				String photo19 = Base64.encode(photo9);
				ab.setPHOTO9(photo19);

				java.sql.Blob blob10 = rs.getBlob("PHOTO10");
				byte[] photo10 = blob10.getBytes(1, (int) blob10.length());
				String photo20 = Base64.encode(photo10);
				ab.setPHOTO10(photo20);
				
				

				al.add(ab);
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
	public int getNoOfRecords() {
		return noOfRecords;
	}

	@Override
	 public ArrayList<AddBike> getBikeId(String model,String brand) {
	  Connection conn = null;

	  ArrayList<AddBike> bikeAl = new ArrayList<AddBike>();
	  Statement st = null;
	  ResultSet rs = null;
	  try {
	   String query = "SELECT NEW_BIKE_ID,VARIANT_NAME,BIKE_PRODUCTION_YEAR from add_bike where BIKE_MODEL='"+model+"' and BIKE_BRAND='"+brand+"' and NEW_BIKE_ID is not null group by NEW_BIKE_ID  order by BIKE_PRODUCTION_YEAR desc";
	   conn = DBConnection.getConnection();
	   st = conn.createStatement();
	   rs = st.executeQuery(query);
	   while (rs.next()) {
	    AddBike bike = new AddBike();
	    bike.setNEW_BIKE_ID(rs.getString("NEW_BIKE_ID"));
	    bike.setVARIANT_NAME(rs.getString("VARIANT_NAME"));
	    bike.setBIKE_PRODUCTION_YEAR(rs.getString("BIKE_PRODUCTION_YEAR"));
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
	public String updateBikePhotos(String bikeNo, InputStream is, ArrayList<InputStream> al) {
		String message = null;
		InputStream photo1 = null, photo2 = null, photo3 = null, photo4 = null, photo5 = null, photo6 = null, photo7 = null,
				photo8 = null, photo9 = null, photo10 = null, photo11 = null, photo12 = null;
		try {
			conn = DBConnection.getConnection();
			String query = "UPDATE new_bike_photos SET PHOTO1=?,PHOTO2=?,PHOTO3=?,PHOTO4=?,PHOTO5=?,PHOTO6=?,PHOTO7=?,PHOTO8=?,PHOTO9=?,PHOTO10=? WHERE NEW_BIKE_ID ='"+bikeNo+"'";
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
	public ArrayList<AddBike> getBikeDetails(String bikeId) {
		String query = null;
		query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.* from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID where add_bike.NEW_BIKE_ID= '"+bikeId+"'";
		ArrayList<AddBike> al = getNewBikeDetails(query);
	
		return al;
	}

	@Override
	public Set<AddBike> getNewBikeVariantName(String brand, String model) {
		Set<AddBike> bikeAl = new HashSet<AddBike>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select VARIANT_NAME from add_bike where bike_brand='"+brand+"' and bike_model='"+model+"' and VARIANT_NAME is not null group by VARIANT_NAME";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			
			while (rs.next()) {
				AddBike newBike = new AddBike();
				newBike.setVARIANT_NAME(rs.getString("VARIANT_NAME"));
				bikeAl.add(newBike);
			}
			
			
			System.out.println("VAriant"+bikeAl.size());
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
	public String updateNewBike(AddBike addBike, String user_name) {
		// TODO Auto-generated method stub
		Statement st = null;
		ResultSet rs = null;
		String message = null;
		int count = 0;
		try {
			   st = conn.createStatement();
			   rs = st.executeQuery("Select count(*) from add_bike where BIKE_MODEL='"+addBike.getBIKE_MODEL()+"' and VARIANT_NAME='"+addBike.getVARIANT_NAME()+"' and NEW_BIKE_ID!='"+addBike.getNEW_BIKE_ID()+"'");
			   while (rs.next()) {
			    count=rs.getInt("count(*)");
			   }
			

			if (count == 0) {

				String query = "UPDATE add_bike a JOIN bike_specifications b ON a.NEW_BIKE_ID = b.NEW_BIKE_ID SET a.BIKE_BRAND=?,a.BIKE_MODEL=?,a.VARIANT_NAME=?,a.COLOR=?,a.BIKE_PRODUCTION_YEAR=?,a.ENGINE_TYPE=?,a.DISPLACEMENT_CC=?,a.MAX_POWER=?,a.MAX_TORQUE=?,a.BORE=?,a.STROKE=?,a.FUEL_SYSTEM=?,a.FUEL_TYPE=?,a.IGNITION=?,a.DIGITAL_FUEL_INDICATOR=?,a.ENGINE_STARTING=?,a.NO_OF_GEARS=?,a.FRONT_BRAKE=?,a.REAR_BRAKE=?,b.MILEAGE=?,b.TOP_SPEED=?,b.CHASSIS_TYPE=?,b.FRONT_SUSPENSION=?,b.REAR_SUSPENSION=?,b.TYRE_TYPE=?,b.FRONT_TYRE=?,b.REAR_TYRE=?,b.WHEEL_SIZE=?,b.WHEEL_TYPE=?,b.LENGTH=?,b.WIDTH=?,b.HEIGHT=?,b.WHEEL_BASE=?,b.GROUND_CLEARANCE=?,b.FUEL_CAPACITY=?,b.KERBWEIGHT=?,b.BATTERY_CAPACITY=?,b.HEAD_LAMP=?,b.STANDARD_WARRANTY_YEARS=?,b.STANDARD_WARRANTY_KMS=? where a.NEW_BIKE_ID='"+addBike.getNEW_BIKE_ID()+"'";

				PreparedStatement pstmt1 = conn.prepareStatement(query);
				pstmt1.setString(1, addBike.getBIKE_BRAND());
				pstmt1.setString(2, addBike.getBIKE_MODEL());
				pstmt1.setString(3, addBike.getVARIANT_NAME());
				pstmt1.setString(4, addBike.getCOLOR());
				pstmt1.setString(5, addBike.getBIKE_PRODUCTION_YEAR());
				pstmt1.setString(6, addBike.getENGINE_TYPE());
				pstmt1.setString(7, addBike.getDISPLACEMENT_CC());
				pstmt1.setString(8, addBike.getMAX_POWER());
				pstmt1.setString(9, addBike.getMAX_TORQUE());
				pstmt1.setString(10, addBike.getBORE());
				pstmt1.setString(11, addBike.getSTROKE());
				pstmt1.setString(12, addBike.getFUEL_SYSTEM());
				pstmt1.setString(13, addBike.getFUEL_TYPE());
				pstmt1.setString(14, addBike.getIGNITION());
				pstmt1.setString(15, addBike.getDIGITAL_FUEL_INDICATOR());
				pstmt1.setString(16, addBike.getENGINE_STARTING());
				pstmt1.setString(17, addBike.getNO_OF_GEARS());
				pstmt1.setString(18, addBike.getFRONT_BRAKE());
				pstmt1.setString(19, addBike.getREAR_BRAKE());
				pstmt1.setString(20, addBike.getMILEAGE());
				pstmt1.setString(21, addBike.getTOP_SPEED());
				pstmt1.setString(22, addBike.getCHASSIS_TYPE());
				pstmt1.setString(23, addBike.getFRONT_SUSPENSION());
				pstmt1.setString(24, addBike.getREAR_SUSPENSION());
				pstmt1.setString(25, addBike.getTYRE_TYPE());
				pstmt1.setString(26, addBike.getFRONT_TYRE());
				pstmt1.setString(27, addBike.getREAR_TYRE());
				pstmt1.setString(28, addBike.getWHEEL_SIZE());
				pstmt1.setString(29, addBike.getWHEEL_TYPE());
				pstmt1.setString(30, addBike.getLENGTH());
				pstmt1.setString(31, addBike.getWIDTH());
				pstmt1.setString(32, addBike.getHEIGHT());
				pstmt1.setString(33, addBike.getWHEEL_BASE());
				pstmt1.setString(34, addBike.getGROUND_CLEARANCE());
				pstmt1.setString(35, addBike.getFUEL_CAPACITY());
				pstmt1.setString(36, addBike.getKERBWEIGHT());
				pstmt1.setString(37, addBike.getBATTERY_CAPACITY());
				pstmt1.setString(38, addBike.getHEAD_LAMP());
				pstmt1.setString(39, addBike.getSTANDARD_WARRANTY_YEARS());
				pstmt1.setString(40, addBike.getSTANDARD_WARRANTY_KMS());

				int i1 = pstmt1.executeUpdate();

				if (i1 > 0) {
					message = "success";
				} else {
					message = "failure";
				}
				pstmt1.close();
			} else {
				message = "Already Exits";
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		 finally {
				try {

					rs.close();
					st.close();
					conn.close();

				} catch (Exception e) {
					e.printStackTrace();
				}}
		return message;
	}

	@Override
	public ArrayList<AddBike> getBikeDetailsByVariantName(String variant_name) {
		// TODO Auto-generated method stub
		String query = null;
		query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.* from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID where add_bike.NEW_BIKE_ID= '"+variant_name+"'";
		ArrayList<AddBike> al = getNewBikeDetails(query);
		
		return al;
	}
	
	@Override
	public ArrayList<AddBike> getBikeDetailsByVariantNamewithoutimage(String variant_name) {
		// TODO Auto-generated method stub
		String query = null;
		query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.* from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID where add_bike.NEW_BIKE_ID= '"+variant_name+"'";
		ArrayList<AddBike> al = getNewBikeDetailswithoutimage(query);
		
		return al;
	}
	public ArrayList<AddBike> getNewBikeDetailswithoutimage(String query) {
		ArrayList<AddBike> al = new ArrayList<AddBike>();
		
		Statement stmt = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				AddBike ab = new AddBike();
				ab.setSEQUENCE_NO(Integer.parseInt(rs.getString("SEQUENCE_NO")));
				
				/* ad.setBIKE_NUMBER(rs.getString("BIKE_NUMBER")); */
				   ab.setBIKE_BRAND(rs.getString("BIKE_BRAND"));
				ab.setBIKE_MODEL(rs.getString("BIKE_MODEL"));
				ab.setVARIANT_NAME(rs.getString("VARIANT_NAME"));
				ab.setCOLOR(rs.getString("COLOR"));
				ab.setBIKE_PRODUCTION_YEAR(rs.getString("BIKE_PRODUCTION_YEAR"));
				ab.setENGINE_TYPE(rs.getString("ENGINE_TYPE"));
				ab.setDISPLACEMENT_CC(rs.getString("DISPLACEMENT_CC"));
				ab.setMAX_POWER(rs.getString("MAX_POWER"));
				ab.setMAX_TORQUE(rs.getString("MAX_TORQUE"));
				ab.setBORE(rs.getString("BORE"));
				ab.setSTROKE(rs.getString("STROKE"));
				ab.setFUEL_SYSTEM(rs.getString("FUEL_SYSTEM"));
				ab.setFUEL_TYPE(rs.getString("FUEL_TYPE"));
				ab.setIGNITION(rs.getString("IGNITION"));
				ab.setDIGITAL_FUEL_INDICATOR(rs.getString("DIGITAL_FUEL_INDICATOR"));
				ab.setENGINE_STARTING(rs.getString("ENGINE_STARTING")); 
				ab.setNO_OF_GEARS(rs.getString("NO_OF_GEARS"));
				ab.setFRONT_BRAKE(rs.getString("FRONT_BRAKE"));
				ab.setREAR_BRAKE(rs.getString("REAR_BRAKE"));

				/* bike specificartions */

				ab.setMILEAGE(rs.getString("MILEAGE"));
				ab.setTOP_SPEED(rs.getString("TOP_SPEED"));
				ab.setCHASSIS_TYPE(rs.getString("CHASSIS_TYPE"));
				ab.setFRONT_SUSPENSION(rs.getString("FRONT_SUSPENSION"));
				ab.setREAR_SUSPENSION(rs.getString("REAR_SUSPENSION"));
				ab.setTYRE_TYPE(rs.getString("TYRE_TYPE"));
				ab.setFRONT_TYRE(rs.getString("FRONT_TYRE"));
				ab.setREAR_TYRE(rs.getString("REAR_TYRE"));
				ab.setWHEEL_SIZE(rs.getString("WHEEL_SIZE"));
				ab.setWHEEL_TYPE(rs.getString("WHEEL_TYPE"));
				ab.setLENGTH(rs.getString("LENGTH"));
				ab.setWIDTH(rs.getString("WIDTH"));
				ab.setHEIGHT(rs.getString("HEIGHT"));
				ab.setWHEEL_BASE(rs.getString("WHEEL_BASE"));
				ab.setGROUND_CLEARANCE(rs.getString("GROUND_CLEARANCE"));
				ab.setFUEL_CAPACITY(rs.getString("FUEL_CAPACITY"));
				ab.setKERBWEIGHT(rs.getString("KERBWEIGHT"));
				ab.setBATTERY_CAPACITY(rs.getString("BATTERY_CAPACITY"));
				ab.setHEAD_LAMP(rs.getString("HEAD_LAMP"));
				ab.setSTANDARD_WARRANTY_YEARS(rs.getString("STANDARD_WARRANTY_YEARS"));
				ab.setSTANDARD_WARRANTY_KMS(rs.getString("STANDARD_WARRANTY_KMS"));
				ab.setNEW_BIKE_ID(rs.getString("NEW_BIKE_ID"));

				try {
					java.sql.Blob blob1 = rs.getBlob("PHOTO1");
					byte[] photo1 = blob1.getBytes(1, (int) blob1.length());
					String photo11 = Base64.encode(photo1);
					ab.setPHOTO1(photo11);

					java.sql.Blob blob2 = rs.getBlob("PHOTO2");
					byte[] photo2 = blob2.getBytes(1, (int) blob2.length());
					String photo12 = Base64.encode(photo2);
					ab.setPHOTO2(photo12);

					java.sql.Blob blob3 = rs.getBlob("PHOTO3");
					byte[] photo3 = blob3.getBytes(1, (int) blob3.length());
					String photo13 = Base64.encode(photo3);
					ab.setPHOTO3(photo13);

					java.sql.Blob blob4 = rs.getBlob("PHOTO4");
					byte[] photo4 = blob4.getBytes(1, (int) blob4.length());
					String photo14 = Base64.encode(photo4);
					ab.setPHOTO4(photo14);
   
					java.sql.Blob blob5 = rs.getBlob("PHOTO5");
					byte[] photo5 = blob5.getBytes(1, (int) blob5.length());
					String photo15 = Base64.encode(photo5);
					ab.setPHOTO5(photo15);

					java.sql.Blob blob6 = rs.getBlob("PHOTO6");
					byte[] photo6 = blob6.getBytes(1, (int) blob6.length());
					String photo16 = Base64.encode(photo6);
					ab.setPHOTO6(photo16);

					java.sql.Blob blob7 = rs.getBlob("PHOTO7");
					byte[] photo7 = blob7.getBytes(1, (int) blob7.length());
					String photo17 = Base64.encode(photo7);
					ab.setPHOTO7(photo17);

					java.sql.Blob blob8 = rs.getBlob("PHOTO8");
					byte[] photo8 = blob8.getBytes(1, (int) blob8.length());
					String photo18 = Base64.encode(photo8);
					ab.setPHOTO8(photo18);

					java.sql.Blob blob9 = rs.getBlob("PHOTO9");
					byte[] photo9 = blob9.getBytes(1, (int) blob9.length());
					String photo19 = Base64.encode(photo9);
					ab.setPHOTO9(photo19);

					java.sql.Blob blob10 = rs.getBlob("PHOTO10");
					byte[] photo10 = blob10.getBytes(1, (int) blob10.length());
					String photo20 = Base64.encode(photo10);
					ab.setPHOTO10(photo20);
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				al.add(ab);
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
	
	public boolean addNewBikePrice(ArrayList<BikePrice> al)
	{
		boolean flag=false;
		ArrayList<BikePrice> all=new ArrayList<BikePrice>();
		
		PreparedStatement st = null;
		ResultSet rs = null;
		 int count=0;
		try {
			all=checkNewBikePrice(al);
			conn = DBConnection.getConnection();
			st=conn.prepareStatement("INSERT INTO `vehicle_price_table` (`SEQ_NO`, `ITEM_NAME`, `PRICE`, `NEW_VEHICLE_ID`, `USER_ID`) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			for(int i=0;i<all.size();i++)
			{
				BikePrice bikeprice=all.get(i);
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
	
	public ArrayList<BikePrice> checkNewBikePrice(ArrayList<BikePrice> al)
	{
		Statement pst=null;
		conn = DBConnection.getConnection();
		try {
			pst=conn.createStatement();
			for(int i=0;i<al.size();i++)
			{
				BikePrice bp=al.get(i);
			String query="SELECT * FROM vehicle_price_table where ITEM_NAME = '"+bp.getITEM_NAME()+"' and NEW_VEHICLE_ID = '"+bp.getNEW_VEHICLE_ID()+"' and USER_ID = '"+bp.getUSER_ID()+"'";
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
	
	public String getNewBikeId(String brand, String model,String variant,String makeYear)
	{
		String newbikeid=null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM add_bike where BIKE_BRAND = '"+brand+"' and BIKE_MODEL = '"+model+"' and VARIANT_NAME = '"+variant+"' and BIKE_PRODUCTION_YEAR ='"+makeYear+"'";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			if (rs.next()) {
				newbikeid=rs.getString("NEW_BIKE_ID");
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
		return newbikeid;
	}
	
	public boolean addNewBikeOffer(ArrayList<VehicleOffer> al)
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
	public ArrayList<VehicleOffer> checkNewBikeOffer(ArrayList<VehicleOffer> al)
	{
		Statement pst=null;
		conn = DBConnection.getConnection();
		try {
			pst=conn.createStatement();
			for(int i=0;i<al.size();i++)
			{
				VehicleOffer vo=al.get(i);
				String query="SELECT * FROM vehicle_offers_table where NEW_VEHICLE_ID = '"+vo.getNEW_VEHICLE_ID()+"'  and OFFER_NAME = '"+vo.getOFFER_NAME()+"' and USER_ID = '"+vo.getUSER_ID()+"' and STATUS ='1'";
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
	public ArrayList<AddBike> getDealerAuthorisedBikeBrand(String userid) {

		ArrayList<AddBike> bikeAl = new ArrayList<AddBike>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select BRAND_NAME from dealer_authentication where DEALER_NAME = '"+userid+"' and STATUS = 'A' and DEALER_AUTHENTICATION = 'Yes' and VEHICLE_TYPE = '2,'";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				AddBike bike = new AddBike();
				bike.setBIKE_BRAND(rs.getString("BRAND_NAME"));
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
	public ArrayList<AddBike> getBikeExshowRoomPriceList(String varient_id, int offset, int noOfRecords) {
		// TODO Auto-generated method stub
		String query = null;
		query = "SELECT SQL_CALC_FOUND_ROWS * from bike_exshowroom_price_table  where NEW_BIKE_ID='"+varient_id+"' limit " + offset + ", " + noOfRecords;
		ArrayList<AddBike> al = getNewBikeDetailsExShowdetails(query);
		return al;
	}
	public ArrayList<AddBike> getNewBikeDetailsExShowdetails(String query) {
		ArrayList<AddBike> al = new ArrayList<AddBike>();
		Statement stmt = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				AddBike ad = new AddBike();
				/*exshowroompricetab*/
				ad.setEXPRICE_SEQ_ID(rs.getInt("EXPRICE_SEQ_ID"));
				ad.setEX_SHOW_ROOM_PRICE(rs.getString("EX_SHOW_ROOM_PRICE"));
				ad.setEX_SHOW_ROOM_PRICE_PLACE(rs.getString("EX_SHOW_ROOM_PRICE_PLACE"));
				ad.setUPDATED_DATE_TIME(new SQLDate().getInDate(rs.getString("UPDATED_DATE_TIME")));
				ad.setNEW_BIKE_ID(rs.getString("NEW_BIKE_ID"));
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
	public String aInsertBikeExShowroomPrice(String car_id, String place, String price) {
		  String message = null;
		  Statement st = null;
		  ResultSet rs = null;
		  int count=0;
		  try {
			  
			    st = conn.createStatement();
			    
			    rs = st.executeQuery("select count(*) from bike_exshowroom_price_table where NEW_BIKE_ID='"+car_id+"' and EX_SHOW_ROOM_PRICE_PLACE='"+place+"'");
			    while (rs.next()) {
			     count=rs.getInt("count(*)");
			    }
		    
		    
		    if(count==0){
		     
		
		     String query = "insert into bike_exshowroom_price_table values (?,?,?,?,CURDATE())";
		     
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
	public AddBike getBrandModelVarientBybikeId(String bike_id) {
    AddBike bike=new AddBike();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select BIKE_BRAND,BIKE_MODEL,VARIANT_NAME,BIKE_PRODUCTION_YEAR from add_bike where NEW_BIKE_ID='"+bike_id+"'";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				bike.setBIKE_BRAND(rs.getString("BIKE_BRAND"));
				bike.setBIKE_MODEL(rs.getString("BIKE_MODEL"));
				bike.setVARIANT_NAME(rs.getString("VARIANT_NAME"));
				bike.setBIKE_PRODUCTION_YEAR(rs.getString("BIKE_PRODUCTION_YEAR"));
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
		return bike;
	}
	@Override
	public String aupdateNBikeExShowroomPrice(String bike_id, String place, String price) {
		// TODO Auto-generated method stub
		String message= null;
		Connection conn= null;
		try {
			String sql = "update bike_exshowroom_price_table set EX_SHOW_ROOM_PRICE='"+price+"' where NEW_BIKE_ID='"+bike_id+"' and EX_SHOW_ROOM_PRICE_PLACE='"+place+"'";
			conn = DBConnection.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			
	
			int i = preparedStatement.executeUpdate();

			if (i > 0) {
				message = "Price Successfully Updated";
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
	public String getBikeExshowroomprice(String car_id, String place) {
		// TODO Auto-generated method stub
		Statement st = null;
		ResultSet rs = null;
		String price="";
		try {
			String query = "select EX_SHOW_ROOM_PRICE from bike_exshowroom_price_table where NEW_BIKE_ID='"+car_id+"' and EX_SHOW_ROOM_PRICE_PLACE like '%"+place+"%' group by '%"+place+"%'";
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
	public boolean addNewBikes(List<NewBike> bikesdetails)
	{
		// TODO Auto-generated method stub
		boolean b=false;
		
		int id = new IdGen().getNewIds("NEW_BIKE_ID");

		String bikeId = null;
		String addbikequery="INSERT INTO `add_bike` (`SEQUENCE_NO`, `USER_NAME`, `BIKE_BRAND`, `BIKE_MODEL`, `VARIANT_NAME`, `COLOR`, `BIKE_PRODUCTION_YEAR`, `ENGINE_TYPE`, `DISPLACEMENT_CC`, `MAX_POWER`, `MAX_TORQUE`, `BORE`, `STROKE`, `FUEL_SYSTEM`, `FUEL_TYPE`, `IGNITION`, `DIGITAL_FUEL_INDICATOR`, `ENGINE_STARTING`, `NO_OF_GEARS`, `FRONT_BRAKE`, `REAR_BRAKE`, `NEW_BIKE_ID`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String specifquery="INSERT INTO `bike_specifications` (`SEQUENCE_NO`, `NEW_BIKE_ID`, `MILEAGE`, `TOP_SPEED`, `CHASSIS_TYPE`, `FRONT_SUSPENSION`, `REAR_SUSPENSION`, `TYRE_TYPE`, `FRONT_TYRE`, `REAR_TYRE`, `WHEEL_SIZE`, `WHEEL_TYPE`, `LENGTH`, `WIDTH`, `HEIGHT`, `WHEEL_BASE`, `GROUND_CLEARANCE`, `FUEL_CAPACITY`, `KERBWEIGHT`, `BATTERY_CAPACITY`, `HEAD_LAMP`, `STANDARD_WARRANTY_YEARS`, `STANDARD_WARRANTY_KMS`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//		String imagesquery = "insert into new_bike_photos values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		String updbikequery="UPDATE `add_bike` SET `COLOR`=?, `ENGINE_TYPE`=?, `DISPLACEMENT_CC`=?, `MAX_POWER`=?, `MAX_TORQUE`=?, `BORE`=?, `STROKE`=?, `FUEL_SYSTEM`=?, `FUEL_TYPE`=?, `IGNITION`=?, `DIGITAL_FUEL_INDICATOR`=?, `ENGINE_STARTING`=?, `NO_OF_GEARS`=?, `FRONT_BRAKE`=?, `REAR_BRAKE`=? WHERE `SEQUENCE_NO` = ?";
						  	/*"UPDATE `bike_specifications` SET `MILEAGE`=?, `TOP_SPEED`=?, `CHASSIS_TYPE`=?, `FRONT_SUSPENSION`=?, `REAR_SUSPENSION`=?, `TYRE_TYPE`=?, `FRONT_TYRE`=?, `REAR_TYRE`=?, `WHEEL_SIZE`=?, `WHEEL_TYPE`=?, `LENGTH`=?, `WIDTH`=?, `HEIGHT`=?, `WHEEL_BASE`=?, `GROUND_CLEARANCE`=?, `FUEL_CAPACITY`=?, `KERBWEIGHT`=?, `BATTERY_CAPACITY`=?, `HEAD_LAMP`=?, `STANDARD_WARRANTY_YEARS`=?, `STANDARD_WARRANTY_KMS`=? WHERE `NEW_BIKE_ID` = ?"*/
		String updspecifquery="UPDATE `bike_specifications` SET `MILEAGE`=?, `TOP_SPEED`=?, `CHASSIS_TYPE`=?, `FRONT_SUSPENSION`=?, `REAR_SUSPENSION`=?, `TYRE_TYPE`=?, `FRONT_TYRE`=?, `REAR_TYRE`=?, `WHEEL_SIZE`=?, `WHEEL_TYPE`=?, `LENGTH`=?, `WIDTH`=?, `HEIGHT`=?, `WHEEL_BASE`=?, `GROUND_CLEARANCE`=?, `FUEL_CAPACITY`=?, `KERBWEIGHT`=?, `BATTERY_CAPACITY`=?, `HEAD_LAMP`=?, `STANDARD_WARRANTY_YEARS`=?, `STANDARD_WARRANTY_KMS`=? WHERE `NEW_BIKE_ID` = ?";
		
		PreparedStatement addbikepst=null;
		PreparedStatement specificationspst=null;
//		PreparedStatement pstmt =null;
		
		PreparedStatement updbikepst=null;
		PreparedStatement updspecificationspst=null;
		
		ArrayList<AddBike> bikedetails=new ArrayList<AddBike>();
		
		int bikesequenceno=0;
		String newbikeid=null;
		InputStream is = null;

		try {
			//conn.setAutoCommit(false);
			addbikepst=conn.prepareStatement(addbikequery, Statement.RETURN_GENERATED_KEYS);
			specificationspst=conn.prepareStatement(specifquery, Statement.RETURN_GENERATED_KEYS);
//			pstmt = conn.prepareStatement(imagesquery, Statement.RETURN_GENERATED_KEYS);
			
			updbikepst=conn.prepareStatement(updbikequery);
			updspecificationspst=conn.prepareStatement(updspecifquery);
			
			for(int i=0;i<bikesdetails.size();i++)
			{
				NewBike bike=bikesdetails.get(i);
				
				bikedetails=getNewBikesDetails("SELECT * from add_bike where BIKE_BRAND = '"+bike.getBIKE_BRAND()+"' and BIKE_MODEL = '"+bike.getBIKE_MODEL()+"' and VARIANT_NAME = '"+bike.getVARIANT_NAME()+"' and BIKE_PRODUCTION_YEAR ='"+bike.getBIKE_PRODUCTION_YEAR()+"'");
			
				if(bikedetails.size()<=0)
				{
				bikeId = new NewVehicleIds().newBikeId(Integer.valueOf(id).toString());
				id++;
				addbikepst.setString(1, bike.getADD_BIKE_SEQUENCE_NO());
				addbikepst.setString(2, "vmadmin@kosurisoft.com");
				addbikepst.setString(3, bike.getBIKE_BRAND());
				addbikepst.setString(4, bike.getBIKE_MODEL());
				addbikepst.setString(5, bike.getVARIANT_NAME());
				addbikepst.setString(6, bike.getCOLOR());
				addbikepst.setString(7, bike.getBIKE_PRODUCTION_YEAR());
				addbikepst.setString(8, bike.getENGINE_TYPE());
				addbikepst.setString(9, bike.getDISPLACEMENT_CC());
				addbikepst.setString(10, bike.getMAX_POWER());
				addbikepst.setString(11, bike.getMAX_TORQUE());
				addbikepst.setString(12, bike.getBORE());
				addbikepst.setString(13, bike.getSTROKE());
				addbikepst.setString(14, bike.getFUEL_SYSTEM());
				addbikepst.setString(15, bike.getFUEL_TYPE());
				addbikepst.setString(16, bike.getIGNITION());
				addbikepst.setString(17, bike.getDIGITAL_FUEL_INDICATOR());
				addbikepst.setString(18, bike.getENGINE_STARTING());
				addbikepst.setString(19, bike.getNO_OF_GEARS());
				addbikepst.setString(20, bike.getFRONT_BRAKE());
				addbikepst.setString(21, bike.getREAR_BRAKE());
				addbikepst.setString(22, bikeId);
				
				specificationspst.setString(1, bike.getBIKE_SPEC_SEQUENCE_NO());
				specificationspst.setString(2, bikeId);
				specificationspst.setString(3, bike.getMILEAGE());
				specificationspst.setString(4, bike.getTOP_SPEED());
				specificationspst.setString(5, bike.getCHASSIS_TYPE());
				specificationspst.setString(6, bike.getFRONT_SUSPENSION());
				specificationspst.setString(7, bike.getREAR_SUSPENSION());
				specificationspst.setString(8, bike.getTYRE_TYPE());
				specificationspst.setString(9, bike.getFRONT_TYRE());
				specificationspst.setString(10, bike.getREAR_TYRE());
				specificationspst.setString(11, bike.getWHEEL_SIZE());
				specificationspst.setString(12, bike.getWHEEL_TYPE());
				specificationspst.setString(13, bike.getLENGTH());
				specificationspst.setString(14, bike.getWIDTH());
				specificationspst.setString(15, bike.getHEIGHT());
				specificationspst.setString(16, bike.getWHEEL_BASE());
				specificationspst.setString(17, bike.getGROUND_CLEARANCE());
				specificationspst.setString(18, bike.getFUEL_CAPACITY());
				specificationspst.setString(19, bike.getKERBWEIGHT());
				specificationspst.setString(20, bike.getBATTERY_CAPACITY());
				specificationspst.setString(21, bike.getHEAD_LAMP());
				specificationspst.setString(22, bike.getSTANDARD_WARRANTY_YEARS());
				specificationspst.setString(23, bike.getSTANDARD_WARRANTY_KMS());

				/* pstmt.setString(1, bike.getADD_BIKE_SEQUENCE_NO());
			     pstmt.setString(2, bikeId);
			     pstmt.setBinaryStream(3, bike.getImage());
			     pstmt.setBinaryStream(4, bike.getImage());
			     pstmt.setBinaryStream(5, bike.getImage());
			     pstmt.setBinaryStream(6, bike.getImage());
			     pstmt.setBinaryStream(7, bike.getImage());
			     pstmt.setBinaryStream(8, bike.getImage());
			     pstmt.setBinaryStream(9, bike.getImage());
			     pstmt.setBinaryStream(10, bike.getImage());
			     pstmt.setBinaryStream(11, bike.getImage());
			     pstmt.setBinaryStream(12, bike.getImage());
			     pstmt.setBinaryStream(13, bike.getImage());
			     pstmt.setBinaryStream(14, bike.getImage());*/
			     
				addbikepst.addBatch();
				specificationspst.addBatch();
//				pstmt.addBatch();
				}
				else
				{
					bikesequenceno = bikedetails.get(0).getSEQUENCE_NO();
					newbikeid = bikedetails.get(0).getNEW_BIKE_ID();
					/*System.out.println("UPDATE `add_bike` SET `COLOR`='"+bike.getCOLOR()+"', `ENGINE_TYPE`='"+bike.getENGINE_TYPE()
					+"', `DISPLACEMENT_CC`='"+bike.getDISPLACEMENT_CC()+"', `MAX_POWER`='"+bike.getMAX_POWER()+"', `MAX_TORQUE`='"+bike.getMAX_TORQUE()
					+"', `BORE`='"+bike.getBORE()+"', `STROKE`='"+bike.getSTROKE()+"', `FUEL_SYSTEM`='"+bike.getFUEL_SYSTEM()
					+"', `FUEL_TYPE`='"+bike.getFUEL_TYPE()+"', `IGNITION`='"+bike.getIGNITION()+"', `DIGITAL_FUEL_INDICATOR`='"+bike.getDIGITAL_FUEL_INDICATOR()
					+"', `ENGINE_STARTING`='"+bike.getENGINE_STARTING()+"', `NO_OF_GEARS`='"+bike.getNO_OF_GEARS()+"', `FRONT_BRAKE`='"+bike.getFRONT_BRAKE()
					+"', `REAR_BRAKE`='"+bike.getREAR_BRAKE()+"' WHERE `SEQUENCE_NO` = '"+bikedetails.get(0).getSEQUENCE_NO()+"'");*/
					updbikepst.setString(1, bike.getCOLOR());
					updbikepst.setString(2, bike.getENGINE_TYPE());
					updbikepst.setString(3, bike.getDISPLACEMENT_CC());
					updbikepst.setString(4, bike.getMAX_POWER());
					updbikepst.setString(5, bike.getMAX_TORQUE());
					updbikepst.setString(6, bike.getBORE());
					updbikepst.setString(7, bike.getSTROKE());
					updbikepst.setString(8, bike.getFUEL_SYSTEM());
					updbikepst.setString(9, bike.getFUEL_TYPE());
					updbikepst.setString(10, bike.getIGNITION());
					updbikepst.setString(11, bike.getDIGITAL_FUEL_INDICATOR());
					updbikepst.setString(12, bike.getENGINE_STARTING());
					updbikepst.setString(13, bike.getNO_OF_GEARS());
					updbikepst.setString(14, bike.getFRONT_BRAKE());
					updbikepst.setString(15, bike.getREAR_BRAKE());
					updbikepst.setInt(16, bikesequenceno);
					
					
					/*System.out.println("UPDATE `bike_specifications` SET `MILEAGE`='"+bike.getMILEAGE()
							+"', `TOP_SPEED`='"+bike.getTOP_SPEED()+"', `CHASSIS_TYPE`='"+bike.getCHASSIS_TYPE()
							+"', `FRONT_SUSPENSION`='"+bike.getFRONT_SUSPENSION()+"', `REAR_SUSPENSION`='"+bike.getREAR_SUSPENSION()
							+"', `TYRE_TYPE`='"+bike.getTYRE_TYPE()+"', `FRONT_TYRE`='"+bike.getFRONT_TYRE()
							+"', `REAR_TYRE`='"+bike.getREAR_TYRE()+"', `WHEEL_SIZE`='"+bike.getWHEEL_SIZE()
							+"', `WHEEL_TYPE`='"+bike.getWHEEL_TYPE()+"', `LENGTH`='"+bike.getLENGTH()
							+"', `WIDTH`='"+bike.getWIDTH()+"', `HEIGHT`='"+bike.getHEIGHT()
							+"', `WHEEL_BASE`='"+bike.getWHEEL_BASE()+"', `GROUND_CLEARANCE`='"+bike.getGROUND_CLEARANCE()
							+"', `FUEL_CAPACITY`='"+bike.getFUEL_CAPACITY()+"', `KERBWEIGHT`='"+bike.getKERBWEIGHT()
							+"', `BATTERY_CAPACITY`='"+bike.getBATTERY_CAPACITY()+"', `HEAD_LAMP`='"+bike.getHEAD_LAMP()
							+"', `STANDARD_WARRANTY_YEARS`='"+bike.getSTANDARD_WARRANTY_YEARS()
							+"', `STANDARD_WARRANTY_KMS`='"+bike.getSTANDARD_WARRANTY_KMS()+"' WHERE `NEW_BIKE_ID` = '"+newbikeid+"'");*/
					updspecificationspst.setString(1, bike.getMILEAGE());
					updspecificationspst.setString(2, bike.getTOP_SPEED());
					updspecificationspst.setString(3, bike.getCHASSIS_TYPE());
					updspecificationspst.setString(4, bike.getFRONT_SUSPENSION());
					updspecificationspst.setString(5, bike.getREAR_SUSPENSION());
					updspecificationspst.setString(6, bike.getTYRE_TYPE());
					updspecificationspst.setString(7, bike.getFRONT_TYRE());
					updspecificationspst.setString(8, bike.getREAR_TYRE());
					updspecificationspst.setString(9, bike.getWHEEL_SIZE());
					updspecificationspst.setString(10, bike.getWHEEL_TYPE());
					updspecificationspst.setString(11, bike.getLENGTH());
					updspecificationspst.setString(12, bike.getWIDTH());
					updspecificationspst.setString(13, bike.getHEIGHT());
					updspecificationspst.setString(14, bike.getWHEEL_BASE());
					updspecificationspst.setString(15, bike.getGROUND_CLEARANCE());
					updspecificationspst.setString(16, bike.getFUEL_CAPACITY());
					updspecificationspst.setString(17, bike.getKERBWEIGHT());
					updspecificationspst.setString(18, bike.getBATTERY_CAPACITY());
					updspecificationspst.setString(19, bike.getHEAD_LAMP());
					updspecificationspst.setString(20, bike.getSTANDARD_WARRANTY_YEARS());
					updspecificationspst.setString(21, bike.getSTANDARD_WARRANTY_KMS());
					updspecificationspst.setString(22, newbikeid);
					
					updbikepst.addBatch();
					updspecificationspst.addBatch();
				}
			}
			int[] bike=addbikepst.executeBatch();
			int[] spec1=specificationspst.executeBatch();
//			int[] pstm=pstmt.executeBatch();
			
			int[] updbike=updbikepst.executeBatch();
			int[] updspec1=updspecificationspst.executeBatch();
//			System.out.println("value"+pstmt);
				b=true;
				new IdGen().updateNewId("NEW_BIKE_ID", id);
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
	private ArrayList<AddBike> getNewBikesDetails(String query) {
		ArrayList<AddBike> al = new ArrayList<AddBike>();
		
		Statement stmt = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				AddBike ab = new AddBike();
				ab.setSEQUENCE_NO(Integer.parseInt(rs.getString("SEQUENCE_NO")));
				
				/* ad.setBIKE_NUMBER(rs.getString("BIKE_NUMBER")); */
				ab.setBIKE_BRAND(rs.getString("BIKE_BRAND"));
				ab.setBIKE_MODEL(rs.getString("BIKE_MODEL"));
				ab.setVARIANT_NAME(rs.getString("VARIANT_NAME"));
				ab.setCOLOR(rs.getString("COLOR"));
				ab.setBIKE_PRODUCTION_YEAR(rs.getString("BIKE_PRODUCTION_YEAR"));
				ab.setENGINE_TYPE(rs.getString("ENGINE_TYPE"));
				ab.setDISPLACEMENT_CC(rs.getString("DISPLACEMENT_CC"));
				ab.setMAX_POWER(rs.getString("MAX_POWER"));
				ab.setMAX_TORQUE(rs.getString("MAX_TORQUE"));
				ab.setBORE(rs.getString("BORE"));
				ab.setSTROKE(rs.getString("STROKE"));
				ab.setFUEL_SYSTEM(rs.getString("FUEL_SYSTEM"));
				ab.setFUEL_TYPE(rs.getString("FUEL_TYPE"));
				ab.setIGNITION(rs.getString("IGNITION"));
				ab.setDIGITAL_FUEL_INDICATOR(rs.getString("DIGITAL_FUEL_INDICATOR"));
				ab.setENGINE_STARTING(rs.getString("ENGINE_STARTING")); 
				ab.setNO_OF_GEARS(rs.getString("NO_OF_GEARS"));
				ab.setFRONT_BRAKE(rs.getString("FRONT_BRAKE"));
				ab.setREAR_BRAKE(rs.getString("REAR_BRAKE"));
				ab.setNEW_BIKE_ID(rs.getString("NEW_BIKE_ID"));

				al.add(ab);
			}
			/*rs = stmt.executeQuery("SELECT FOUND_ROWS()");
			if (rs.next())
				this.noOfRecords = rs.getInt(1);*/
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
	public Set<AddBike> getNewBikeYearByVariantName(String brand,String model, String variant) {
		// TODO Auto-generated method stub
		Set<AddBike> bikeAl = new HashSet<AddBike>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select BIKE_PRODUCTION_YEAR from add_bike where BIKE_BRAND='"+brand+"' and BIKE_MODEL='"+model+"' and VARIANT_NAME='"+variant+"' group by VARIANT_NAME";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				AddBike newBike = new AddBike();
				newBike.setBIKE_PRODUCTION_YEAR((rs.getString("BIKE_PRODUCTION_YEAR")));
				bikeAl.add(newBike);
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
	public String getNewBikeIdView(String brand, String model,String variant,String makeYear)
	{
		String newbikeid=null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select NEW_BIKE_ID from add_car where BIKE_BRAND = '"+brand+"' and BIKE_MODEL = '"+model+"' and VARIANT_NAME = '"+variant+"' and BIKE_PRODUCTION_YEAR = '"+makeYear+"'";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			if (rs.next()) {
				newbikeid=rs.getString("NEW_BIKE_ID");
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
		return newbikeid;
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
			  String qurey="select count(*) from bike_exshowroom_price_table where NEW_BIKE_ID='"+id+"'";
			   rs = st.executeQuery(qurey);
			   while (rs.next()) {
			    count=rs.getInt("count(*)");
			   }
			   
			   
		   
			if (count > 0) {
				flag=true;
			}
			else{
				flag=false;
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
		return flag;
		
	}

	@Override
	public ArrayList<AddBike> getNewBikewithAdvanceFilter(String brand, String vModel, String vVariant, String madeyear,
			String bodytype, String fueltype, String transmission, String color, String budget, int offset,
			int noOfRecords) {
		String query = null;
		String price1=null;
		String price2=null;
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
			
			query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.* from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  limit " + offset + ", " + noOfRecords;
		}
    
    else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT") && bodytype.equals("SELECT") && fueltype.equals("SELECT") && transmission.equals("SELECT") && color.equals("SELECT")&& !budget.equals("SELECT")){
		
		query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;
	}
		
		
		else if(bodytype.equals("SELECT") && fueltype.equals("SELECT") && transmission.equals("SELECT") && color.equals("SELECT")&& budget.equals("SELECT")){
		
		
              if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				
				      query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.* from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' limit " + offset + ", " + noOfRecords;
			     }
              else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
  				
  				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"'  limit " + offset + ", " + noOfRecords;
  		      	}
              else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
  				
  				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"'  limit " + offset + ", " + noOfRecords;
  		     	}
              else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
  				
  				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"'  limit " + offset + ", " + noOfRecords;
  		      	}
              else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
  				
  				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"'  and BIKE_PRODUCTION_YEAR='"+madeyear+"' limit " + offset + ", " + noOfRecords;
  			    }
              else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
  				
  				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"'  and BIKE_PRODUCTION_YEAR='"+madeyear+"' limit " + offset + ", " + noOfRecords;
  			    }
          	
              else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
   				
   				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where  BIKE_PRODUCTION_YEAR='"+madeyear+"' limit " + offset + ", " + noOfRecords;
   			    }
             
		
		   }
		
    /*bodytype*/
		else if(!bodytype.equals("SELECT") && fueltype.equals("SELECT") && transmission.equals("SELECT") && budget.equals("SELECT") &&color.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and  BODY_TYPE='"+bodytype+"' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and BODY_TYPE='"+bodytype+"' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"'  and BODY_TYPE='"+bodytype+"' limit " + offset + ", " + noOfRecords;
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"'  and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' limit " + offset + ", " + noOfRecords;
			}
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where  BODY_TYPE='"+bodytype+"' limit " + offset + ", " + noOfRecords;
			}
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_PRODUCTION_YEAR='"+madeyear+"' and  BODY_TYPE='"+bodytype+"' limit " + offset + ", " + noOfRecords;
			}
		
		
		}
		
		
		/*fueltype*/
		else if(!fueltype.equals("SELECT") && bodytype.equals("SELECT") && transmission.equals("SELECT") && budget.equals("SELECT") && color.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and  FUEL_TYPE='"+fueltype+"' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and FUEL_TYPE='"+fueltype+"' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"'  and FUEL_TYPE='"+fueltype+"' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"'  and BIKE_PRODUCTION_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"' limit " + offset + ", " + noOfRecords;
			}
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where FUEL_TYPE='"+fueltype+"' limit " + offset + ", " + noOfRecords;
			}
			
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_PRODUCTION_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"' limit " + offset + ", " + noOfRecords;
			}
		}
    /*color*/
		else if(fueltype.equals("SELECT") && bodytype.equals("SELECT") && transmission.equals("SELECT") && budget.equals("SELECT") && !color.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"'  and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"'  and BIKE_PRODUCTION_YEAR='"+madeyear+"' and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;
			}
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where  COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;
			}
			
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  where BIKE_PRODUCTION_YEAR='"+madeyear+"' and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;
			}
		}
		
    
	
    
    /*budget filter*/
	
	
		else if(!budget.equals("SELECT") && bodytype.equals("SELECT") && fueltype.equals("SELECT") && transmission.equals("SELECT") && color.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,bike_exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where  BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%'  and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,bike_exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%'  and  CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,bike_exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%'  and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,bike_exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%'   and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,bike_exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"'  and BIKE_PRODUCTION_YEAR='"+madeyear+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%'   and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;
			}
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
		     	query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,bike_exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;
			}
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,bike_exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where  BIKE_PRODUCTION_YEAR='"+madeyear+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%'  CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;
			}
		}
		
		
    
		
		
		
		
		
		
		
		/*brand+model+variant+madeyear+bodytype+fueltype+color*/
		
		else if(!bodytype.equals("SELECT")&&!fueltype.equals("SELECT") && !color.equals("SELECT") &&transmission.equals("SELECT") && budget.equals("SELECT")){
		if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;	
		}
		
		else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;	
		}
		
		else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"'  and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;	
		}
		
		else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;	
		}
		else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"'  and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;	
		}
		else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where  BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;	
		}
		
		else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;	
		}
		
		}
		
		/*brand+model+variant+madeyear+bodytype+fueltype+color+budget*/
		
		else if(!bodytype.equals("SELECT")&&!fueltype.equals("SELECT") && color.equals("SELECT") && transmission.equals("SELECT") &&!budget.equals("SELECT")){
		if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,bike_exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;	
		}
		
		else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,bike_exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;	
		}
		
		else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,bike_exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and TRANSMISSION_TYPE='"+transmission+"' limit " + offset + ", " + noOfRecords;	
		}
		
		else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,bike_exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;	
		}
		else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,bike_exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"'  and BIKE_PRODUCTION_YEAR='"+madeyear+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;	
		}
		else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,bike_exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where  EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and  BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;	
		}
		
		else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
			query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,bike_exshowroom_price_table.*,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;	
		}
		
		}
		
		
		
		
		
		
		/*bodytype+fueltype*/
		
		else if(!bodytype.equals("SELECT") && !fueltype.equals("SELECT") && transmission.equals("SELECT") && color.equals("SELECT") && budget.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"'  and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"'  and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"'  limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where  BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"'  limit " + offset + ", " + noOfRecords;	
			}
		
		
		}
		
	
		
		

		
	
		
		/*bodytype+budget*/
		
		else if(!bodytype.equals("SELECT") && fueltype.equals("SELECT") && transmission.equals("SELECT") && !budget.equals("SELECT") && color.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BODY_TYPE='"+bodytype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"'  and BODY_TYPE='"+bodytype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BODY_TYPE='"+bodytype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"'  and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
		
		}
		
		/*fuel+budget*/
		else if(bodytype.equals("SELECT") && !fueltype.equals("SELECT") && transmission.equals("SELECT") && !budget.equals("SELECT") && color.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"'  and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"'  and BIKE_PRODUCTION_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
		
		}
		
	
		
		/*body+fuel+budget*/
		
		else if(!bodytype.equals("SELECT") && !fueltype.equals("SELECT") && transmission.equals("SELECT") && !budget.equals("SELECT")&&color.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BODY_TYPE='"+bodytype+"' and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BODY_TYPE='"+bodytype+"' and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"'  and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' and FUEL_TYPE='"+fueltype+"'   and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
		
		}
    
    /*bodytype+color*/
	
		else if(!bodytype.equals("SELECT") && fueltype.equals("SELECT") && transmission.equals("SELECT") && !color.equals("SELECT") && budget.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and BODY_TYPE='"+bodytype+"' and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"'  and BODY_TYPE='"+bodytype+"'  and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BODY_TYPE='"+bodytype+"'  and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"'  and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where  BODY_TYPE='"+bodytype+"'  and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
			}
		
		
		}
    
    /*color+budget*/
	
		else if(!budget.equals("SELECT") && !color.equals("SELECT") && bodytype.equals("SELECT") && fueltype.equals("SELECT") && transmission.equals("SELECT") ){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and COLOR like '%"+color+"%' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"'   and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"'  and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"'  and BIKE_PRODUCTION_YEAR='"+madeyear+"'  and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
		
		}
    
    /*fuel+color*/
	
		else if(bodytype.equals("SELECT") && !fueltype.equals("SELECT") && transmission.equals("SELECT") && budget.equals("SELECT") && !color.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"'  and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and FUEL_TYPE='"+fueltype+"'  and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and FUEL_TYPE='"+fueltype+"'  and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"'  and BIKE_PRODUCTION_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"'  and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"'  and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where FUEL_TYPE='"+fueltype+"'  and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
			}
		
		}

    
	
    /*body+fuel+color*/
		
		else if(!bodytype.equals("SELECT") && !fueltype.equals("SELECT") && transmission.equals("SELECT") && budget.equals("SELECT") && !color.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' and FUEL_TYPE='"+fueltype+"'  and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and BODY_TYPE='"+bodytype+"' and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and FUEL_TYPE='"+fueltype+"' and BODY_TYPE='"+bodytype+"'  and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BODY_TYPE='"+bodytype+"' and FUEL_TYPE='"+fueltype+"'  and COLOR like '%"+color+"%'limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"'  and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' and FUEL_TYPE='"+fueltype+"'  and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' and FUEL_TYPE='"+fueltype+"'  and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID   where  BODY_TYPE='"+bodytype+"' and FUEL_TYPE='"+fueltype+"'  and COLOR like '%"+color+"%' limit " + offset + ", " + noOfRecords;	
			}
    
    
    
    
    
		}
    
    
    /*body+color+budget*/
	
		else if(!bodytype.equals("SELECT") && fueltype.equals("SELECT") && transmission.equals("SELECT") && !budget.equals("SELECT") && !color.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and COLOR like '%"+color+"%' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BODY_TYPE='"+bodytype+"'   and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and BODY_TYPE='"+bodytype+"'   and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BODY_TYPE='"+bodytype+"'  and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"'  and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'   and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
		
		}
    
    /*fuel+color+budget*/
	
		else if(!fueltype.equals("SELECT")&& !budget.equals("SELECT") && !color.equals("SELECT") && bodytype.equals("SELECT")  && transmission.equals("SELECT") ){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"'  and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and FUEL_TYPE='"+fueltype+"'  and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"'   and FUEL_TYPE='"+fueltype+"'  and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"'  and FUEL_TYPE='"+fueltype+"'  and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"'  and BIKE_PRODUCTION_YEAR='"+madeyear+"'  and FUEL_TYPE='"+fueltype+"'  and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and FUEL_TYPE='"+fueltype+"'  and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			else if(brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where FUEL_TYPE='"+fueltype+" and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
		
		}
    
    
    
    
    
		
    /*body+fuel+color+budget*/
		
		else if(!bodytype.equals("SELECT") && !fueltype.equals("SELECT") && transmission.equals("SELECT") && !budget.equals("SELECT") && !color.equals("SELECT")){
			if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"' and COLOR like '%"+color+"%' and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BODY_TYPE='"+bodytype+"' and FUEL_TYPE='"+fueltype+"'  and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and BODY_TYPE='"+bodytype+"'  and FUEL_TYPE='"+fueltype+"'  and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && !vVariant.equals("SELECT") && madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID  where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and VARIANT_NAME='"+vVariant+"' and BODY_TYPE='"+bodytype+"' and FUEL_TYPE='"+fueltype+"'  and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"' limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"'  and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' and FUEL_TYPE='"+fueltype+"'  and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
			else if(!brand.equals("SELECT") && !vModel.equals("SELECT") && vVariant.equals("SELECT") && !madeyear.equals("SELECT")){
				query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*  ,CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) ) AS EX_SHOW_ROOM_PRICE from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  left join bike_exshowroom_price_table   on add_bike.NEW_BIKE_ID=bike_exshowroom_price_table.NEW_BIKE_ID where BIKE_BRAND= '"+brand+"' and BIKE_MODEL='"+vModel+"' and BIKE_PRODUCTION_YEAR='"+madeyear+"' and BODY_TYPE='"+bodytype+"' and FUEL_TYPE='"+fueltype+"'  and COLOR like '%"+color+"%'  and EX_SHOW_ROOM_PRICE_PLACE like '%HYDERABAD%' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )>='"+price1+"' and CAST( EX_SHOW_ROOM_PRICE AS DECIMAL( 9, 2 ) )<='"+price2+"'  limit " + offset + ", " + noOfRecords;	
			}
		
		}
		
	
		
		
		
		
		
		
		
		else{
			query = "SELECT SQL_CALC_FOUND_ROWS add_bike.*,new_bike_photos.*,bike_specifications.*   from add_bike left join new_bike_photos on add_bike.NEW_BIKE_ID=new_bike_photos.NEW_BIKE_ID left join bike_specifications on add_bike.NEW_BIKE_ID=bike_specifications.NEW_BIKE_ID  limit " + offset + ", " + noOfRecords;
		}
    
    
 ArrayList<AddBike> ab=getNewBikeDetails(query);
    
     
		return ab;
	}
	@Override
	public ArrayList<String> getcolors() {
		

		 Statement st = null;
		  ResultSet rs = null;
		  ArrayList<String> color=new ArrayList<String>();
		  try {
			  conn = DBConnection.getConnection();
			   st = conn.createStatement();
			   
			   
			   rs = st.executeQuery("select COLOR  from add_bike order by COLOR ASC");
			 
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

	@Override
	public String addNewBikePhotos(String bikeNo, InputStream is, ArrayList<InputStream> al) {
		// TODO Auto-generated method stub
		String message = null;
		InputStream photo1 = null, photo2 = null, photo3 = null, photo4 = null, photo5 = null, photo6 = null, photo7 = null,
				photo8 = null, photo9 = null, photo10 = null, photo11 = null, photo12 = null;
		try {
			conn = DBConnection.getConnection();
			String query = "insert into new_bike_photos values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";			
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
		    pstmt.setString(2, bikeNo);
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
	
	
	public AddBike getNewBikeCompleteDetails(String sequenceno)
	{
		String query="SELECT * FROM add_bike ab join new_bike_photos nbp on ab.new_bike_id = nbp.new_bike_id join bike_specifications bs on ab.new_bike_id = bs.new_bike_id left join bike_exshowroom_price_table espt on ab.new_bike_id = espt.new_bike_id where ab.sequence_no = '"+sequenceno+"'";
		AddBike ab=new AddBike();
		ArrayList<AddBike> al=new ArrayList<AddBike>();
		al=	getNewBikeDetails(query);
		if(al.size()>0)
		{
			String exshowroomprice=getBikeExshowroomprice(al.get(0).getNEW_BIKE_ID(), "Hyderabad");
			ab=al.get(0);
			ab.setEX_SHOW_ROOM_PRICE(exshowroomprice);
		}
		return ab;
	}
}
