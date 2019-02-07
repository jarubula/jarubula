package com.vaahanmitra.daoImpl;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.owtelse.codec.Base64;
import com.vaahanmitra.dao.SparePartsDao;
import com.vaahanmitra.dbutil.DBConnection;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.SpareParts;

public class SparePartsDaoImpl implements SparePartsDao {

	private int noOfRecords = 0;
	private Connection conn = null;
	@Override
	public String addSpareParts(SpareParts spareParts, String user_name, InputStream is) {
		conn = DBConnection.getConnection();
		String message = null;
		try {
			String query = "insert into spareparts_details values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, spareParts.getID());
			preparedStatement.setString(2, user_name);
			preparedStatement.setString(3, spareParts.getVEHICLE_BRAND());
			preparedStatement.setString(4, spareParts.getVEHICLE_MODEL());
			preparedStatement.setString(5, spareParts.getMANUFACTURE_COMPANY_NAME());
			preparedStatement.setString(6, spareParts.getPARTNO());
			preparedStatement.setString(7, spareParts.getSKU());
			preparedStatement.setString(8, spareParts.getSP_NAME());
			preparedStatement.setString(9, spareParts.getCATEGORY());
			preparedStatement.setString(10, spareParts.getSUB_CATEGORY());
			preparedStatement.setString(11, spareParts.getSPECIFICATIONS());
			preparedStatement.setString(12, spareParts.getDESCRIPTION());
			preparedStatement.setString(13, spareParts.getWARRANTY());
			preparedStatement.setString(14, spareParts.getPRICE());
			preparedStatement.setBinaryStream(15, is);
			preparedStatement.setString(16, spareParts.getDELEVERY_METHOD());
			preparedStatement.setString(17, spareParts.getVEHICLE_TYPE());
			preparedStatement.setString(18, spareParts.getMODEL_YEAR());
			preparedStatement.setString(19, spareParts.getSTATUS());
			preparedStatement.setString(20, spareParts.getDISCOUNT());
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				message = "Spare Parts added successfully...";
			} else {
				message = "Spare Parts not Added! Please try again";
			}
			preparedStatement.close();
			conn.close();
			System.out.println(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public String checkSKU(String sku) {
		String existSKU = null, message = "no";
		try {
			conn = DBConnection.getConnection();
			String query = "select sku from spareparts_details where SKU='"+sku+"'";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				existSKU = rs.getString("SKU");
			}
			if (sku.equalsIgnoreCase(existSKU)) {
				message = "success";
			} else {
				message = "no";
			}
			System.out.println(query);
			preparedStatement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public ArrayList<SpareParts> getSparePartSKU(String email) {
		ArrayList<SpareParts> spareParts = new ArrayList<SpareParts>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT SKU FROM spareparts_details where USER_NAME='" + email
					+ "' and SKU is not null group by SKU";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				SpareParts sp = new SpareParts();
				sp.setSKU(rs.getString("SKU"));
				spareParts.add(sp);
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
		return spareParts;
	}

	@Override
	public ArrayList<SpareParts> getSPDetails(String sku, String user_name) {
		ArrayList<SpareParts> al = new ArrayList<SpareParts>();
		Statement st = null;
		ResultSet rs = null;
		String query = null;
		conn = DBConnection.getConnection();
		try {
			if (sku.equals("ALL")) {
				query = "SELECT * from spareparts_details where USER_NAME='" + user_name + "'";
			} else {
				query = "SELECT * from spareparts_details where USER_NAME='" + user_name + "' and sku='" + sku + "'";
			}
			st = conn.createStatement();
			System.out.println(query);
			rs = st.executeQuery(query);
			while (rs.next()) {
				SpareParts sp = new SpareParts();
				java.sql.Blob blob1 = rs.getBlob("IMAGE");
				byte[] photo1 = blob1.getBytes(1, (int) blob1.length());
				String photo2 = Base64.encode(photo1);
				sp.setIMAGE(photo2);
				sp.setSKU(rs.getString("SKU"));
				sp.setSP_NAME(rs.getString("SP_NAME"));
				sp.setVEHICLE_BRAND(rs.getString("VEHICLE_BRAND"));
				sp.setVEHICLE_MODEL(rs.getString("VEHICLE_MODEL"));
				sp.setPARTNO(rs.getString("PARTNO"));
				sp.setMANUFACTURE_COMPANY_NAME(rs.getString("COMPANY_NAME"));
				sp.setPRICE(rs.getString("PRICE"));
				sp.setCATEGORY(rs.getString("CATEGORY"));
				sp.setSUB_CATEGORY(rs.getString("SUB_CATEGORY"));
				sp.setDELEVERY_METHOD(rs.getString("DELEVERY_METHOD"));
				sp.setDESCRIPTION(rs.getString("DESCRIPTION"));
				sp.setSPECIFICATIONS(rs.getString("SPECIFICATIONS"));
				sp.setWARRANTY(rs.getString("WARRANTY"));
				al.add(sp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
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
	public String updateSPPrice(List<SpareParts> list, String user_name) {
		String message = null;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		int i = 0;
		try {
			String sql = "UPDATE spareparts_details SET PRICE=?, DISCOUNT=? WHERE USER_NAME ='" + user_name + "' and sku=?";
			conn = DBConnection.getConnection();

			Iterator it = list.iterator();
			while (it.hasNext()) {
				SpareParts sku = (SpareParts) it.next();
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setString(1, sku.getPRICE());
				preparedStatement.setString(2, sku.getDISCOUNT());
				preparedStatement.setString(3, sku.getSKU());
				i = preparedStatement.executeUpdate();
			}

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

	@Override
	public SpareParts getSparePartDetails(String sku) {
		SpareParts sp = new SpareParts();
		try {
			String sql = "SELECT * from spareparts_details where sku='" + sku + "'";
			conn = DBConnection.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {

				java.sql.Blob blob1 = rs.getBlob("IMAGE");
				byte[] photo1 = blob1.getBytes(1, (int) blob1.length());
				String photo2 = Base64.encode(photo1);
				sp.setIMAGE(photo2);

				sp.setSKU(rs.getString("SKU"));
				sp.setSP_NAME(rs.getString("SP_NAME"));
				sp.setVEHICLE_BRAND(rs.getString("VEHICLE_BRAND"));
				sp.setVEHICLE_MODEL(rs.getString("VEHICLE_MODEL"));
				sp.setPARTNO(rs.getString("PARTNO"));
				sp.setMANUFACTURE_COMPANY_NAME(rs.getString("COMPANY_NAME"));
				sp.setPRICE(rs.getString("PRICE"));
				sp.setCATEGORY(rs.getString("CATEGORY"));
				sp.setSUB_CATEGORY(rs.getString("SUB_CATEGORY"));
				sp.setDELEVERY_METHOD(rs.getString("DELEVERY_METHOD"));
				sp.setDESCRIPTION(rs.getString("DESCRIPTION"));
				sp.setSPECIFICATIONS(rs.getString("SPECIFICATIONS"));
				sp.setSPECIFICATIONS(rs.getString("SPECIFICATIONS"));
				sp.setWARRANTY(rs.getString("WARRANTY"));
				sp.setMODEL_YEAR(rs.getString("MODEL_YEAR"));
				sp.setVEHICLE_TYPE(rs.getString("VEHICLE_TYPE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sp;
	}

	public ArrayList<SpareParts> getCarBrand(String email) {
		ArrayList<SpareParts> sp = new ArrayList<SpareParts>();
		Statement st = null;
		ResultSet rs = null;
		conn = DBConnection.getConnection();
		try {
			String query = "SELECT VEHICLE_BRAND FROM spareparts_details where USER_NAME='" + email
					+ "' and VEHICLE_BRAND is not null group by VEHICLE_BRAND";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				SpareParts sps = new SpareParts();
				sps.setVEHICLE_BRAND(rs.getString("VEHICLE_BRAND"));
				sp.add(sps);
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
		return sp;
	}

	/*@Override
	public ArrayList<SpareParts> getCarModel(String carModel) {
		ArrayList<SpareParts> sp = new ArrayList<SpareParts>();
		Statement st = null;
		ResultSet rs = null;
		conn = DBConnection.getConnection();
		try {
			String query = "select VEHICLE_MODEL from spareparts_details where VEHICLE_BRAND='" + carModel
					+ "' and VEHICLE_MODEL is not null group by VEHICLE_MODEL";
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				SpareParts sps = new SpareParts();
				sps.setVEHICLE_MODEL(rs.getString("VEHICLE_MODEL"));
				sp.add(sps);
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
		return sp;
	}*/


	@Override
	public ArrayList<SpareParts> getSparePartsNames(String email) {
		ArrayList<SpareParts> spareParts = new ArrayList<SpareParts>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "SELECT SP_NAME FROM spareparts_details where USER_NAME='" + email
					+ "' and SP_NAME is not null group by SP_NAME";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				SpareParts sp = new SpareParts();
				sp.setSP_NAME(rs.getString("SP_NAME"));
				spareParts.add(sp);
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
		return spareParts;
	}

	@Override
	public ArrayList<BusinessOwnerRegister> getCity() {
		ArrayList<BusinessOwnerRegister> dealerAl=new ArrayList<BusinessOwnerRegister>();
		Statement st=null;
		ResultSet rs=null;
		try{
			String query="select b_city from business_owner_register where user_type='SP' and b_city is not null group by b_city";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs=st.executeQuery(query);
			while(rs.next()){
				BusinessOwnerRegister usedCar=new BusinessOwnerRegister();
				usedCar.setB_CITY(rs.getString("B_CITY"));
				dealerAl.add(usedCar);
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			
			rs.close();
			st.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	return dealerAl;
	}

	@Override
	public ArrayList<SpareParts> getVehicleBrand(String vehicleType) {
				ArrayList<SpareParts> spal = new ArrayList<SpareParts>();
				Statement st = null;
				ResultSet rs = null;
				String query = null;
				try {
					if (vehicleType.equals("2,") || vehicleType.equals("4,")) {
						query = "select VEHICLE_BRAND from spareparts_details where VEHICLE_TYPE='" + vehicleType
								+ "' and VEHICLE_BRAND is not null group by VEHICLE_BRAND";
					} else if (vehicleType.equals("4,2,")) {
						query = "select VEHICLE_BRAND from spareparts_details where VEHICLE_BRAND is not null group by VEHICLE_BRAND";
					}
					System.out.println(query);
					conn = DBConnection.getConnection();
					st = conn.createStatement();
					rs = st.executeQuery(query);
					while (rs.next()) {
						SpareParts spBean = new SpareParts();
						spBean.setVEHICLE_BRAND(rs.getString("VEHICLE_BRAND"));
						spal.add(spBean);
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
				return spal;
	}

	@Override
	public ArrayList<SpareParts> getVehicleModel(String carModel) {
		ArrayList<SpareParts> carAl = new ArrayList<SpareParts>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select vehicle_model from spareparts_details where vehicle_brand='" + carModel
					+ "' and vehicle_model is not null group by vehicle_model";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				SpareParts sp = new SpareParts();
				sp.setVEHICLE_MODEL(rs.getString("vehicle_model"));
				carAl.add(sp);
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
	public ArrayList<SpareParts> getSpCategory() {
		ArrayList<SpareParts> carAl = new ArrayList<SpareParts>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select category from spareparts_details where CATEGORY is not null group by category";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				SpareParts sp = new SpareParts();
				sp.setCATEGORY(rs.getString("CATEGORY"));
				carAl.add(sp);
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
	public ArrayList<SpareParts> getSpBrand(String vehicleType,String user_name) {
		ArrayList<SpareParts> spal = new ArrayList<SpareParts>();
		Statement st = null;
		ResultSet rs = null;
		String query = null;
		try {
			if (vehicleType.equals("2,") || vehicleType.equals("4,")) {
				query = "select VEHICLE_BRAND from spareparts_details where VEHICLE_TYPE='" + vehicleType
						+ "' and USER_NAME='"+user_name+"' and VEHICLE_BRAND is not null group by VEHICLE_BRAND";
			} else if (vehicleType.equals("4,2,")) {
				query = "select VEHICLE_BRAND from spareparts_details where USER_NAME='"+user_name+"' and VEHICLE_BRAND is not null group by VEHICLE_BRAND";
			}
			System.out.println(query);
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				SpareParts spBean = new SpareParts();
				spBean.setVEHICLE_BRAND(rs.getString("VEHICLE_BRAND"));
				spal.add(spBean);
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
		return spal;
	}

	@Override
	public ArrayList<SpareParts> getSpModel(String carModel, String user_name) {
		ArrayList<SpareParts> carAl = new ArrayList<SpareParts>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select vehicle_model from spareparts_details where vehicle_brand='" + carModel
					+ "' and user_name = '"+user_name+"' and vehicle_model is not null group by vehicle_model";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				SpareParts sp = new SpareParts();
				sp.setVEHICLE_MODEL(rs.getString("vehicle_model"));
				carAl.add(sp);
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
	public ArrayList<SpareParts> searchSpareParts(SpareParts sp) {
		ArrayList<SpareParts> spAl = new ArrayList<SpareParts>();
//		System.out.println("harish"+ sp.getVEHICLE_TYPE() + sp.getVEHICLE_BRAND() + sp.getVEHICLE_MODEL() + sp.getCATEGORY() + sp.getSUB_CATEGORY() + sp.getCITY());
		String query = null;
		Statement st = null;
		ResultSet rs = null;
//		System.out.println(sp.getMANUFACTURE_COMPANY_NAME() + sp.getPARTNO() + sp.getSP_NAME() + sp.getMODEL_YEAR());

		ArrayList<SpareParts> spd = new ArrayList<SpareParts>();
		if((sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) ||(sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("SELECT") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("SELECT") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("1 all");
		}else if((sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All") || ((sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || ((sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || ((sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || ((sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("2 brand");
		}else if((sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and VEHICLE_MODEL='"+sp.getVEHICLE_MODEL()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("3 brand,model");
		}else if((sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where CATEGORY='"+sp.getCATEGORY()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("22 category");
		}else if((sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and CATEGORY='"+sp.getCATEGORY()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("23 brand,category");
		}else if((sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where B_CITY='"+sp.getCITY()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("24 city");
		}else if((sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where CATEGORY='"+sp.getCATEGORY()+"' and B_CITY='"+sp.getCITY()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("28 category,city");
		}else if((sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and B_CITY='"+sp.getCITY()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("27 brand,city");
		}else if((sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and CATEGORY='"+sp.getCATEGORY()+"' and B_CITY='"+sp.getCITY()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("25 brand,category,city");
		}else if((sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where CATEGORY='"+sp.getCATEGORY()+"' and SUB_CATEGORY='"+sp.getSUB_CATEGORY()+"' and B_CITY='"+sp.getCITY()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("29 category,subcategory,city");
		}else if((sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and CATEGORY='"+sp.getCATEGORY()+"' and SUB_CATEGORY='"+sp.getSUB_CATEGORY()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("26 brand,category,subcategory");
		}else if((sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and VEHICLE_MODEL='"+sp.getVEHICLE_MODEL()+"' and CATEGORY='"+sp.getCATEGORY()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("4 brand,model,category");
		}else if((sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and VEHICLE_MODEL='"+sp.getVEHICLE_MODEL()+"' and CATEGORY='"+sp.getCATEGORY()+"' and B_CITY='"+sp.getCITY()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("5 brand,model,category,city");
		}else if((sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and VEHICLE_MODEL='"+sp.getVEHICLE_MODEL()+"' and CATEGORY='"+sp.getCATEGORY()+"' and SUB_CATEGORY='"+sp.getSUB_CATEGORY()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("6 brand,model,category,subcategory");
		}else if((sp.getVEHICLE_TYPE().equals("4,2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and VEHICLE_MODEL='"+sp.getVEHICLE_MODEL()+"' and CATEGORY='"+sp.getCATEGORY()+"' and B_CITY='"+sp.getCITY()+"' and SUB_CATEGORY='"+sp.getSUB_CATEGORY()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("7 brand,model,category,city,subcategory");
		}else if((sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='2,' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("8 2,");
		}else if((sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='2,' and VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("9 2,brand");
		}else if((sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='2,' and CATEGORY='"+sp.getCATEGORY()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("30 2,category");
		}else if((sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='2,' and B_CITY='"+sp.getCITY()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("31 2,city");
		}else if((sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All"))) {
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='2,' and VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and CATEGORY='"+sp.getCATEGORY()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("32 2,brand,category");
		}else if((sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='2,' and VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and B_CITY='"+sp.getCITY()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("33 2,brand,city");
		}else if((sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='2,' and CATEGORY='"+sp.getCATEGORY()+"' and B_CITY='"+sp.getCITY()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("34 2,Category,city");
		}else if((sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='2,' and VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and CATEGORY='"+sp.getCATEGORY()+"' and B_CITY='"+sp.getCITY()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("35 2,brand,category,city");
		}else if((sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='2,' and VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and CATEGORY='"+sp.getCATEGORY()+"' and SUB_CATEGORY='"+sp.getSUB_CATEGORY()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("36 2,brand,category,subcategory");
		}else if((sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='2,' and CATEGORY='"+sp.getCATEGORY()+"' and SUB_CATEGORY='"+sp.getSUB_CATEGORY()+"' and B_CITY='"+sp.getCITY()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("37 2,category,subcategory,city");
		}else if((sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='4,' and CATEGORY='"+sp.getCATEGORY()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("38 4,category");
		}else if((sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='4,' and B_CITY='"+sp.getCITY()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("39 4,city");
		}else if((sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All"))) {
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='4,' and VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and CATEGORY='"+sp.getCATEGORY()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("40 4,brand,category");
		}else if((sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='4,' and VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and B_CITY='"+sp.getCITY()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("41 4,brand,city");
		}else if((sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='4,' and CATEGORY='"+sp.getCATEGORY()+"' and B_CITY='"+sp.getCITY()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("42 4,Category,city");
		}else if((sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='4,' and VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and CATEGORY='"+sp.getCATEGORY()+"' and B_CITY='"+sp.getCITY()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("43 4,brand,category,city");
		}else if((sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='4,' and VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and CATEGORY='"+sp.getCATEGORY()+"' and SUB_CATEGORY='"+sp.getSUB_CATEGORY()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("44 4,brand,category,subcategory");
		}else if((sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='4,' and CATEGORY='"+sp.getCATEGORY()+"' and SUB_CATEGORY='"+sp.getSUB_CATEGORY()+"' and B_CITY='"+sp.getCITY()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("45 4,category,subcategory,city");
		}else if((sp.getVEHICLE_TYPE().equals("SELECT") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("SELECT") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("SELECT") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("SELECT") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where CATEGORY='"+sp.getCATEGORY()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("46 all,category");
		}else if((sp.getVEHICLE_TYPE().equals("SELECT") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("SELECT") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("SELECT") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where B_CITY='"+sp.getCITY()+"'  and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("47 all,city");
		}else if((sp.getVEHICLE_TYPE().equals("SELECT") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("SELECT") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where CATEGORY='"+sp.getCATEGORY()+"' and B_CITY='"+sp.getCITY()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("48 Category,city");
		}else if((sp.getVEHICLE_TYPE().equals("SELECT") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("SELECT") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where CATEGORY='"+sp.getCATEGORY()+"' and SUB_CATEGORY='"+sp.getSUB_CATEGORY()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("49 Category,city");
		}else if((sp.getVEHICLE_TYPE().equals("SELECT") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where CATEGORY='"+sp.getCATEGORY()+"' and SUB_CATEGORY='"+sp.getSUB_CATEGORY()+"' and B_CITY='"+sp.getCITY()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("50 Category,subcategory,city");
		}else if((sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='2,' and VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and VEHICLE_MODEL='"+sp.getVEHICLE_MODEL()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("10 2,brand.model");
		}else if((sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='2,' and VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and VEHICLE_MODEL='"+sp.getVEHICLE_MODEL()+"' and  CATEGORY='"+sp.getCATEGORY()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("11 2,brand,model,category");
		}else if((sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='2,' and VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and VEHICLE_MODEL='"+sp.getVEHICLE_MODEL()+"' and CATEGORY='"+sp.getCATEGORY()+"' and B_CITY='"+sp.getCITY()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("12 brand,model,category,city");
		}else if((sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='2,' and VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and VEHICLE_MODEL='"+sp.getVEHICLE_MODEL()+"' and CATEGORY='"+sp.getCATEGORY()+"' and SUB_CATEGORY='"+sp.getSUB_CATEGORY()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("13 2,brand,model,category,subcategory");
		}else if((sp.getVEHICLE_TYPE().equals("2,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='2,' and VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and VEHICLE_MODEL='"+sp.getVEHICLE_MODEL()+"' and CATEGORY='"+sp.getCATEGORY()+"' and SUB_CATEGORY='"+sp.getSUB_CATEGORY()+"' and B_CITY='"+sp.getCITY()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("14 2,brand,model,category,subcategory,city");
		}else if((sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,") && sp.getVEHICLE_BRAND().equals("All") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='4,' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("15 4,");
		}else if((sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("All") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='4,' and VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("16 4,brand");
		}else if((sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("All") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='4,' and VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and VEHICLE_MODEL='"+sp.getVEHICLE_MODEL()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("17 4,brand.model");
		}else if((sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && sp.getCITY().equals("All")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='4,' and VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and VEHICLE_MODEL='"+sp.getVEHICLE_MODEL()+"' and  CATEGORY='"+sp.getCATEGORY()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("18 4,brand,model,category");
		}else if((sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && sp.getSUB_CATEGORY().equals("All") && !sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='4,' and VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and VEHICLE_MODEL='"+sp.getVEHICLE_MODEL()+"' and CATEGORY='"+sp.getCATEGORY()+"' and B_CITY='"+sp.getCITY()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("19 4,brand,model,category,city");
		}else if((sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("SELECT")) || (sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && sp.getCITY().equals("All"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='4,' and VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and VEHICLE_MODEL='"+sp.getVEHICLE_MODEL()+"' and CATEGORY='"+sp.getCATEGORY()+"' and SUB_CATEGORY='"+sp.getSUB_CATEGORY()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("20 4,brand,model,category,subcategory");
		}else if((sp.getVEHICLE_TYPE().equals("4,") && !sp.getVEHICLE_BRAND().equals("SELECT") && !sp.getVEHICLE_MODEL().equals("SELECT") && !sp.getCATEGORY().equals("SELECT") && !sp.getSUB_CATEGORY().equals("SELECT") && !sp.getCITY().equals("SELECT"))){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where spareparts_details.VEHICLE_TYPE='4,' and VEHICLE_BRAND='"+sp.getVEHICLE_BRAND()+"' and VEHICLE_MODEL='"+sp.getVEHICLE_MODEL()+"' and CATEGORY='"+sp.getCATEGORY()+"' and SUB_CATEGORY='"+sp.getSUB_CATEGORY()+"' and B_CITY='"+sp.getCITY()+"' and spareparts_details.SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("21 4,brand,model,category,subcategory,city");
		}
		
//		Advanced Search
		
		else if(sp.getMANUFACTURE_COMPANY_NAME()!=null && !sp.getMANUFACTURE_COMPANY_NAME().equals("null")){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where COMPANY_NAME='"+sp.getMANUFACTURE_COMPANY_NAME()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("22 mcn");
		}else if(sp.getSP_NAME()!=null && !sp.getSP_NAME().equals("null")){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where SP_NAME='"+sp.getSP_NAME()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("23 name");
		}else if(sp.getPARTNO()!=null && !sp.getPARTNO().equals("null")){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where PARTNO='"+sp.getPARTNO()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("24 PN");
		}else if(sp.getMODEL_YEAR()!=null && !sp.getMODEL_YEAR().equals("null")){
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where MODEL_YEAR='"+sp.getMODEL_YEAR()+"' and SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("25 MY");
		}
		else{
			query="SELECT spareparts_details.*,business_owner_register.* from spareparts_details left join business_owner_register on spareparts_details.USER_NAME=business_owner_register.EMAIL_ID where SP_STATUS='ACTIVE' group by SKU";
//			System.out.println("not selected");
		}
//		System.out.println(query);    
			try {
			conn = DBConnection.getConnection();  
			st = conn.createStatement();                    
			if (query != null) {
				rs = st.executeQuery(query);
			}
			byte photo1[];
			Blob blob1;
			while (rs.next()) {
				SpareParts bean = new SpareParts();
				bean.setVEHICLE_BRAND(rs.getString("VEHICLE_BRAND"));
				bean.setVEHICLE_MODEL(rs.getString("VEHICLE_MODEL"));
				bean.setMODEL_YEAR(rs.getString("MODEL_YEAR"));
				bean.setMANUFACTURE_COMPANY_NAME(rs.getString("COMPANY_NAME"));
				bean.setPARTNO(rs.getString("PARTNO"));
				bean.setVEHICLE_TYPE(rs.getString("VEHICLE_TYPE"));
				bean.setSKU(rs.getString("SKU"));
				bean.setSP_NAME(rs.getString("SP_NAME"));
				bean.setCATEGORY(rs.getString("CATEGORY"));
				bean.setSUB_CATEGORY(rs.getString("SUB_CATEGORY"));
				bean.setSPECIFICATIONS(rs.getString("SPECIFICATIONS"));
				bean.setDESCRIPTION(rs.getString("DESCRIPTION"));
				bean.setWARRANTY(rs.getString("WARRANTY"));
				bean.setPRICE(rs.getString("PRICE"));
				bean.setDELEVERY_METHOD(rs.getString("DELEVERY_METHOD"));
				bean.setVEHICLE_TYPE(rs.getString("VEHICLE_TYPE"));
				bean.setBUSINESS_NAME(rs.getString("BUSINESS_NAME"));
				bean.setCITY(rs.getString("CITY"));
				bean.setUSER_NAME(rs.getString("USER_NAME"));
				blob1 = rs.getBlob("IMAGE");
				if (blob1 != null) {
					photo1 = blob1.getBytes(1, (int) blob1.length());
					String fphoto = Base64.encode(photo1);
					bean.setIMAGE(fphoto);
				}
				spAl.add(bean);
			}
			 rs.close();
			   /*rs = st.executeQuery("SELECT FOUND_ROWS()");
			   if(rs.next()){
			    this.noOfRecords = rs.getInt(1);
			 }*/
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
//		System.out.println(spAl);
		return spAl;
	}

	@Override
	public ArrayList<SpareParts> getSpPartNo() {
		ArrayList<SpareParts> carAl = new ArrayList<SpareParts>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select PARTNO from spareparts_details where SP_STATUS='ACTIVE' AND PARTNO is not null group by PARTNO";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				SpareParts sp = new SpareParts();
				sp.setPARTNO(rs.getString("PARTNO"));
				carAl.add(sp);
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
	public ArrayList<SpareParts> getCompanyName() {
		ArrayList<SpareParts> carAl = new ArrayList<SpareParts>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select COMPANY_NAME from spareparts_details where SP_STATUS='ACTIVE' AND COMPANY_NAME is not null group by COMPANY_NAME";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				SpareParts sp = new SpareParts();
				sp.setMANUFACTURE_COMPANY_NAME(rs.getString("COMPANY_NAME"));
				carAl.add(sp);
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
	public ArrayList<SpareParts> getModelYear() {
		ArrayList<SpareParts> carAl = new ArrayList<SpareParts>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select MODEL_YEAR from spareparts_details where SP_STATUS='ACTIVE' AND MODEL_YEAR is not null group by MODEL_YEAR";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				SpareParts sp = new SpareParts();
				sp.setMODEL_YEAR(rs.getString("MODEL_YEAR"));
				carAl.add(sp);
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
	public ArrayList<SpareParts> getSparePartName() {
		ArrayList<SpareParts> carAl = new ArrayList<SpareParts>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select SP_NAME from spareparts_details where SP_STATUS='ACTIVE' AND SP_NAME is not null group by SP_NAME";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				SpareParts sp = new SpareParts();
				sp.setSP_NAME(rs.getString("SP_NAME"));
				carAl.add(sp);
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
	public ArrayList<SpareParts> getSubCategory(String subCategory) {
		ArrayList<SpareParts> carAl = new ArrayList<SpareParts>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String query = "select sub_category from spareparts_details where category='" + subCategory
					+ "' and sub_category is not null group by sub_category";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				SpareParts sp = new SpareParts();
				sp.setSUB_CATEGORY(rs.getString("sub_category"));
				carAl.add(sp);
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
	public ArrayList<SpareParts> searchSPDetails(SpareParts sps, String email,int offset,int noOfRecords) {
		ArrayList<SpareParts> al = new ArrayList<SpareParts>();
		System.out.println(
				"hari" +sps.getVEHICLE_TYPE() + sps.getVEHICLE_BRAND() + sps.getVEHICLE_MODEL() + sps.getSKU() + sps.getSP_NAME());
		Statement st = null;
		String query = null;
		ResultSet rs = null;
		conn = DBConnection.getConnection();
		try {
			if ((sps.getVEHICLE_TYPE().equals("SELECT") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT"))|| (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("SELECT") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("SELECT") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("SELECT") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("SELECT") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT"))|| (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("SELECT") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("SELECT") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("SELECT") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("All"))) {
				query = "SELECT SQL_CALC_FOUND_ROWS * from spareparts_details where USER_NAME='" + email + "' limit " + offset + ", " + noOfRecords;
//				System.out.println("1");
			}else if ((sps.getVEHICLE_TYPE().equals("4,2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All"))) {
				query = "SELECT SQL_CALC_FOUND_ROWS * from spareparts_details where VEHICLE_BRAND='" + sps.getVEHICLE_BRAND() + "' AND USER_NAME='"
					+ email + "'limit " + offset + ", " + noOfRecords;
//				System.out.println("2");
			}else if ((sps.getVEHICLE_TYPE().equals("4,2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && !sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && !sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && !sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && !sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All"))) {
				query = "SELECT SQL_CALC_FOUND_ROWS * from spareparts_details where VEHICLE_BRAND='" + sps.getVEHICLE_BRAND() + "' AND VEHICLE_MODEL='"+sps.getVEHICLE_MODEL()+"' AND USER_NAME='"
						+ email + "'limit " + offset + ", " + noOfRecords;
//				System.out.println("3");
			}else if (sps.getVEHICLE_TYPE().equals("4,2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && !sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) {
				query = "SELECT SQL_CALC_FOUND_ROWS * from spareparts_details where VEHICLE_BRAND='" + sps.getVEHICLE_BRAND() + "' AND VEHICLE_MODEL='"+sps.getVEHICLE_MODEL()+"' AND USER_NAME='"
						+ email + "'limit " + offset + ", " + noOfRecords;
//				System.out.println("4");
			}else if ((sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("SELECT") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("SELECT") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT"))) {
				query = "SELECT SQL_CALC_FOUND_ROWS * from spareparts_details where  SKU='"+sps.getSKU()+"' AND USER_NAME='"
						+ email + "'limit " + offset + ", " + noOfRecords;
//				System.out.println("7");
			}else if ((sps.getVEHICLE_TYPE().equals("4,2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("All") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("All") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT"))) {
				query = "SELECT SQL_CALC_FOUND_ROWS * from spareparts_details where VEHICLE_BRAND='" + sps.getVEHICLE_BRAND() + "' AND SKU='"+sps.getSKU()+"' AND USER_NAME='"
						+ email + "'limit " + offset + ", " + noOfRecords;
//				System.out.println("5");
			}else if ((sps.getVEHICLE_TYPE().equals("4,2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && !sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && !sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All"))) {
				query = "SELECT SQL_CALC_FOUND_ROWS * from spareparts_details where VEHICLE_BRAND='" + sps.getVEHICLE_BRAND() + "' AND VEHICLE_MODEL='"+sps.getVEHICLE_MODEL()+"'AND SKU='"+sps.getSKU()+"' AND USER_NAME='"
						+ email + "'limit " + offset + ", " + noOfRecords;
//				System.out.println("6");
			}else if ((sps.getVEHICLE_TYPE().equals("SELECT") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("SELECT") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("All") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT"))) {
				query = "SELECT SQL_CALC_FOUND_ROWS * from spareparts_details where  SP_NAME='"+sps.getSP_NAME()+"' AND USER_NAME='" + email + "'limit " + offset + ", " + noOfRecords;
//				System.out.println("8");
			}else if ((sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All"))) {
				query = "SELECT SQL_CALC_FOUND_ROWS * from spareparts_details where VEHICLE_TYPE='" + sps.getVEHICLE_TYPE() + "' AND USER_NAME='" + email + "'limit " + offset + ", " + noOfRecords;
//				System.out.println("9");
			}else if ((sps.getVEHICLE_TYPE().equals("2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All"))) {
				query = "SELECT SQL_CALC_FOUND_ROWS * from spareparts_details where VEHICLE_TYPE='" + sps.getVEHICLE_TYPE() + "' AND VEHICLE_BRAND='" + sps.getVEHICLE_BRAND() + "' AND USER_NAME='"
						+ email + "'limit " + offset + ", " + noOfRecords;
//				System.out.println("10");
			}else if ((sps.getVEHICLE_TYPE().equals("2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && !sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && !sps.getVEHICLE_BRAND().equals("SELECT") && !sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && !sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && !sps.getVEHICLE_BRAND().equals("SELECT") && !sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && !sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,") && !sps.getVEHICLE_BRAND().equals("SELECT") && !sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && sps.getSP_NAME().equals("All"))) {
				query = "SELECT SQL_CALC_FOUND_ROWS * from spareparts_details where VEHICLE_TYPE='" + sps.getVEHICLE_TYPE() + "' AND VEHICLE_BRAND='" + sps.getVEHICLE_BRAND() + "' AND VEHICLE_MODEL='" + sps.getVEHICLE_MODEL() + "' AND USER_NAME='"
						+ email + "'limit " + offset + ", " + noOfRecords;
//				System.out.println("11");
			}else if ((sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All"))) {
				query = "SELECT SQL_CALC_FOUND_ROWS * from spareparts_details where VEHICLE_TYPE='" + sps.getVEHICLE_TYPE() + "' AND SKU='"+sps.getSKU()+"' AND USER_NAME='"
						+ email + "'limit " + offset + ", " + noOfRecords;
//				System.out.println("18");
			}else if ((sps.getVEHICLE_TYPE().equals("2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("All") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("All") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("All") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("All") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All"))) {
				query = "SELECT SQL_CALC_FOUND_ROWS * from spareparts_details where VEHICLE_TYPE='" + sps.getVEHICLE_TYPE() + "' AND VEHICLE_BRAND='" + sps.getVEHICLE_BRAND() + "' AND SKU='"+sps.getSKU()+"' AND USER_NAME='"
						+ email + "'limit " + offset + ", " + noOfRecords;
//				System.out.println("14");
			}else if ((sps.getVEHICLE_TYPE().equals("2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && !sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && !sps.getVEHICLE_BRAND().equals("SELECT") && !sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && !sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All")) || (sps.getVEHICLE_TYPE().equals("4,") && !sps.getVEHICLE_BRAND().equals("SELECT") && !sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && sps.getSP_NAME().equals("All"))) {
				query = "SELECT SQL_CALC_FOUND_ROWS * from spareparts_details where VEHICLE_TYPE='" + sps.getVEHICLE_TYPE() + "' AND VEHICLE_BRAND='" + sps.getVEHICLE_BRAND() + "' AND VEHICLE_MODEL='" + sps.getVEHICLE_MODEL() + "' AND SKU='"+sps.getSKU()+"' AND  USER_NAME='"
						+ email + "'limit " + offset + ", " + noOfRecords;
//				System.out.println("12");
			}else if ((sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("All") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("All") && !sps.getSP_NAME().equals("SELECT"))) {
				query = "SELECT SQL_CALC_FOUND_ROWS * from spareparts_details where VEHICLE_TYPE='" + sps.getVEHICLE_TYPE() + "' AND SP_NAME='"+sps.getSP_NAME()+"' AND USER_NAME='"
						+ email + "'limit " + offset + ", " + noOfRecords;
//				System.out.println("16");
			}else if ((sps.getVEHICLE_TYPE().equals("2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("All") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && !sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("All") && sps.getSKU().equals("All") && !sps.getSP_NAME().equals("SELECT"))) {
				query = "SELECT SQL_CALC_FOUND_ROWS * from spareparts_details where VEHICLE_TYPE='" + sps.getVEHICLE_TYPE() + "' AND VEHICLE_BRAND='" + sps.getVEHICLE_BRAND() + "' AND SP_NAME='"+sps.getSP_NAME()+"' AND USER_NAME='"
						+ email + "'limit " + offset + ", " + noOfRecords;
//				System.out.println("15");
			}else if ((sps.getVEHICLE_TYPE().equals("2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && !sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && !sps.getVEHICLE_BRAND().equals("SELECT") && !sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && !sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && !sps.getVEHICLE_BRAND().equals("SELECT") && !sps.getVEHICLE_MODEL().equals("SELECT") && sps.getSKU().equals("All") && !sps.getSP_NAME().equals("SELECT"))) {
				query = "SELECT SQL_CALC_FOUND_ROWS * from spareparts_details where VEHICLE_TYPE='" + sps.getVEHICLE_TYPE() + "' AND VEHICLE_BRAND='" + sps.getVEHICLE_BRAND() + "' AND VEHICLE_MODEL='" + sps.getVEHICLE_MODEL() + "' AND SP_NAME='"+sps.getSP_NAME()+"' AND  USER_NAME='"
						+ email + "'limit " + offset + ", " + noOfRecords;
//				System.out.println("17");
			}else if ((sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && !sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && !sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT"))) {
				query = "SELECT SQL_CALC_FOUND_ROWS * from spareparts_details where VEHICLE_TYPE='" + sps.getVEHICLE_TYPE() + "' AND sku='"+sps.getSKU()+"' AND SP_NAME='"+sps.getSP_NAME()+"' AND  USER_NAME='"
						+ email + "'limit " + offset + ", " + noOfRecords;
//				System.out.println("19");
			}else if ((sps.getVEHICLE_TYPE().equals("2,") && !sps.getVEHICLE_BRAND().equals("SELECT") && !sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,") && !sps.getVEHICLE_BRAND().equals("SELECT") && !sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT"))) {
				query = "SELECT SQL_CALC_FOUND_ROWS * from spareparts_details where VEHICLE_TYPE='" + sps.getVEHICLE_TYPE() + "' AND VEHICLE_BRAND='" + sps.getVEHICLE_BRAND() + "' AND VEHICLE_MODEL='" + sps.getVEHICLE_MODEL() + "' AND SKU='"+sps.getSKU()+"' AND SP_NAME='"+sps.getSP_NAME()+"' AND USER_NAME='"
						+ email + "'limit " + offset + ", " + noOfRecords;
//				System.out.println("13");
			}else if ((sps.getVEHICLE_TYPE().equals("SELECT") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("SELECT") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("SELECT") && !sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT")) || (sps.getVEHICLE_TYPE().equals("4,2,") && sps.getVEHICLE_BRAND().equals("All") && sps.getVEHICLE_MODEL().equals("All") && !sps.getSKU().equals("SELECT") && !sps.getSP_NAME().equals("SELECT"))) {
				query = "SELECT SQL_CALC_FOUND_ROWS * from spareparts_details where sku='"+sps.getSKU()+"' AND SP_NAME='"+sps.getSP_NAME()+"' AND  USER_NAME='"
						+ email + "'limit " + offset + ", " + noOfRecords;
//				System.out.println("20");
			}conn = DBConnection.getConnection();
			
			st = conn.createStatement();
//			System.out.println(query);
			rs = st.executeQuery(query);
			while (rs.next()) {
				SpareParts sp = new SpareParts();
				java.sql.Blob blob1 = rs.getBlob("IMAGE");
				byte[] photo1 = blob1.getBytes(1, (int) blob1.length());
				String photo2 = Base64.encode(photo1);
				sp.setIMAGE(photo2);
				sp.setSKU(rs.getString("SKU"));
				sp.setSP_NAME(rs.getString("SP_NAME"));
				sp.setVEHICLE_TYPE(rs.getString("VEHICLE_TYPE"));
				sp.setVEHICLE_BRAND(rs.getString("VEHICLE_BRAND"));
				sp.setVEHICLE_MODEL(rs.getString("VEHICLE_MODEL"));
				sp.setPARTNO(rs.getString("PARTNO"));
				sp.setMANUFACTURE_COMPANY_NAME(rs.getString("COMPANY_NAME"));
				sp.setPRICE(rs.getString("PRICE"));
				sp.setCATEGORY(rs.getString("CATEGORY"));
				sp.setSUB_CATEGORY(rs.getString("SUB_CATEGORY"));
				sp.setDELEVERY_METHOD(rs.getString("DELEVERY_METHOD"));
				sp.setDESCRIPTION(rs.getString("DESCRIPTION"));
				sp.setSPECIFICATIONS(rs.getString("SPECIFICATIONS"));
				sp.setWARRANTY(rs.getString("WARRANTY"));
				sp.setSTATUS(rs.getString("SP_STATUS"));
				sp.setDISCOUNT(rs.getString("DISCOUNT"));
				al.add(sp);
			}
			rs = st.executeQuery("SELECT FOUND_ROWS()");
			if (rs.next())
				this.noOfRecords = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
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
	public String updateSpareParts(SpareParts spareParts, String user_name, InputStream is) {
		String message= null;
		Connection conn= null;
		try {
			String sql = "UPDATE spareparts_details SET VEHICLE_BRAND=?, VEHICLE_MODEL=?, MODEL_YEAR=?, COMPANY_NAME=?, PARTNO=?, SP_NAME=?, CATEGORY=?, SUB_CATEGORY=?, SPECIFICATIONS=?, DESCRIPTION=?, WARRANTY=?, PRICE=?, IMAGE=?, DELEVERY_METHOD=? WHERE SKU ='"+spareParts.getSKU()+ "'";
			conn = DBConnection.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, spareParts.getVEHICLE_BRAND());
			preparedStatement.setString(2, spareParts.getVEHICLE_MODEL());
			preparedStatement.setString(3, spareParts.getMODEL_YEAR());
			preparedStatement.setString(4, spareParts.getMANUFACTURE_COMPANY_NAME());
			preparedStatement.setString(5, spareParts.getPARTNO());
			preparedStatement.setString(6, spareParts.getSP_NAME());
			preparedStatement.setString(7, spareParts.getCATEGORY());
			preparedStatement.setString(8, spareParts.getSUB_CATEGORY());
			preparedStatement.setString(9, spareParts.getSPECIFICATIONS());
			preparedStatement.setString(10, spareParts.getDESCRIPTION());
			preparedStatement.setString(11, spareParts.getWARRANTY());
			preparedStatement.setString(12, spareParts.getPRICE());
			preparedStatement.setBinaryStream(13, is);
			preparedStatement.setString(14, spareParts.getDELEVERY_METHOD());
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				message = "success";
			} else {
				message = "failure";
			}
			preparedStatement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public String setStatus(String sku, String status, String user_name) {
		conn = DBConnection.getConnection();
		String message = "";
		int j = 0;
		try {
			String sql = null;
			if (status.equals("ACTIVE")) {
				sql = "UPDATE spareparts_details SET SP_STATUS='INACTIVE' WHERE USER_NAME ='" + user_name + "' and  SKU ='"
						+ sku + "'";
				
			} else {
				sql = "UPDATE spareparts_details SET SP_STATUS='ACTIVE' WHERE USER_NAME ='" + user_name + "' and  SKU ='"
						+ sku + "'";
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
}