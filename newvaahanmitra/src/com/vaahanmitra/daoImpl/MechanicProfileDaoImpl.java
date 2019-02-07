package com.vaahanmitra.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vaahanmitra.dao.MechanicProfileDao;
import com.vaahanmitra.dbutil.DBConnection;
import com.vaahanmitra.model.MechanicProfile;

public class MechanicProfileDaoImpl implements MechanicProfileDao {

	Connection conn = DBConnection.getConnection();

	@Override
	public String addMechanic(MechanicProfile addMechanic, String user_name) {

		String message = null;
		PreparedStatement preparedStatement = null;
		Statement st = null;
		try {
			String query = "insert into mechanic_details values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			System.out.println("Mahesh 1 pst");
			st=conn.createStatement();
			int i=st.executeUpdate("INSERT INTO `mechanic_details` (`NAME`, `EMAIL`, `MOBILE_NO`, `QUALIFICATION`, `ADDRESS`, `CITY`, `STATE`, `DISTRICT`, `PINCODE`, `EXPERIENCE`, `SPECIALIZED_IN`, `BRAND_NAME`, `EXPERIENCE_WITH_COMPANIES`, `WORKED_IN_COMPANIES`, `STATUS`, `VERIFIED`, `REFERENCE_ID`) VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1')");
			/*preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			System.out.println("Mahesh 1 af pst");
			preparedStatement.setString(1, addMechanic.getMECHANIC_SEQ_ID());
			preparedStatement.setString(2, addMechanic.getNAME());
			preparedStatement.setString(3, addMechanic.getEMAIL());
			preparedStatement.setString(4, addMechanic.getMOBILE_NO());
			preparedStatement.setString(5, addMechanic.getQUALIFICATION());
			preparedStatement.setString(6, addMechanic.getADDRESS());
			preparedStatement.setString(7, addMechanic.getCITY());
			preparedStatement.setString(8, addMechanic.getSTATE());
			preparedStatement.setString(9, addMechanic.getDISTRICT());
			preparedStatement.setString(10, addMechanic.getPINCODE());
			preparedStatement.setString(11, addMechanic.getEXPERIENCE());
			preparedStatement.setString(12, addMechanic.getSPECIALIZED_IN());
			preparedStatement.setString(13, addMechanic.getBRAND_NAME());
			preparedStatement.setString(14, addMechanic.getEXPERIENCE_WITH_COMPANIES());
			preparedStatement.setString(15, addMechanic.getWORKED_IN_COMPANIES());
			preparedStatement.setString(16, "ACTIVE");
			preparedStatement.setString(17, "NO");
			preparedStatement.setString(18, user_name);
			int i = preparedStatement.executeUpdate();*/
			if (i > 0) {
				message = "success";
			} else {
				message = "failure";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}/*finally
		{
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}*/
		return message;
	}

	@Override
	public boolean getEmail(String email) {
		String existEmail = "";
		boolean success = false;
		try {
			String query = "select * from mechanic_details where EMAIL='" + email + "'";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				existEmail = rs.getString("EMAIL");
			}
			if (email.equals(existEmail)) {
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

	@Override
	public MechanicProfile getMechanicDetails(String email) {
		MechanicProfile mechanic = new MechanicProfile();
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		try {
			String query = "select * from mechanic_details where REFERENCE_ID='" + email + "'";
			preparedStatement = conn.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				mechanic.setNAME(rs.getString("NAME"));
				mechanic.setEMAIL(rs.getString("EMAIL"));
				mechanic.setMOBILE_NO(rs.getString("MOBILE_NO"));
				mechanic.setQUALIFICATION(rs.getString("QUALIFICATION"));
				mechanic.setCITY(rs.getString("CITY"));
				mechanic.setADDRESS(rs.getString("ADDRESS"));
				mechanic.setCITY(rs.getString("CITY"));
				mechanic.setSTATE(rs.getString("STATE"));
				mechanic.setDISTRICT(rs.getString("DISTRICT"));
				mechanic.setPINCODE(rs.getString("PINCODE"));
				mechanic.setEXPERIENCE(rs.getString("EXPERIENCE"));
				mechanic.setSPECIALIZED_IN(rs.getString("SPECIALIZED_IN"));
				mechanic.setBRAND_NAME(rs.getString("BRAND_NAME"));
				mechanic.setEXPERIENCE_WITH_COMPANIES(rs.getString("EXPERIENCE_WITH_COMPANIES"));
				mechanic.setWORKED_IN_COMPANIES(rs.getString("WORKED_IN_COMPANIES"));
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
		return mechanic;
	}

	@Override
	public String updateMechanicProfile(String user_name, MechanicProfile mechanic) {

		String message = "";
		try {
			String sql = "UPDATE mechanic_details SET NAME=?, MOBILE_NO=?, QUALIFICATION=?, ADDRESS = ?, CITY = ?, STATE = ?, DISTRICT=?, PINCODE=?, EXPERIENCE=?, SPECIALIZED_IN=?, BRAND_NAME=?, EXPERIENCE_WITH_COMPANIES=?, WORKED_IN_COMPANIES=? WHERE REFERENCE_ID ='"
					+ user_name + "' and EMAIL='"+mechanic.getEMAIL()+"'";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, mechanic.getNAME());
			preparedStatement.setString(2, mechanic.getMOBILE_NO());
			preparedStatement.setString(3, mechanic.getQUALIFICATION());
			preparedStatement.setString(4, mechanic.getADDRESS());
			preparedStatement.setString(5, mechanic.getCITY());
			preparedStatement.setString(6, mechanic.getSTATE());
			preparedStatement.setString(7, mechanic.getDISTRICT());
			preparedStatement.setString(8, mechanic.getPINCODE());
			preparedStatement.setString(9, mechanic.getEXPERIENCE());
			preparedStatement.setString(10, mechanic.getSPECIALIZED_IN());
			preparedStatement.setString(11, mechanic.getBRAND_NAME());
			preparedStatement.setString(12, mechanic.getEXPERIENCE_WITH_COMPANIES());
			preparedStatement.setString(13, mechanic.getWORKED_IN_COMPANIES());

			int i = preparedStatement.executeUpdate();
			System.out.println(i);
			if (i > 0) {
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
	public ArrayList<MechanicProfile> searchMechanic(String email) {
		ArrayList<MechanicProfile> alMechanic = new ArrayList<MechanicProfile>();
		Statement stmt = null;
		conn = DBConnection.getConnection();
		try {
			String query = "select * from mechanic_details where REFERENCE_ID='" + email + "'";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				MechanicProfile mechanic = new MechanicProfile();
				mechanic.setNAME(rs.getString("NAME"));
				mechanic.setEMAIL(rs.getString("EMAIL"));
				mechanic.setMOBILE_NO(rs.getString("MOBILE_NO"));
				mechanic.setQUALIFICATION(rs.getString("QUALIFICATION"));
				mechanic.setCITY(rs.getString("CITY"));
				mechanic.setADDRESS(rs.getString("ADDRESS"));
				mechanic.setSTATE(rs.getString("STATE"));
				mechanic.setDISTRICT(rs.getString("DISTRICT"));
				mechanic.setPINCODE(rs.getString("PINCODE"));
				mechanic.setEXPERIENCE(rs.getString("EXPERIENCE"));
				mechanic.setSPECIALIZED_IN(rs.getString("SPECIALIZED_IN"));
				mechanic.setBRAND_NAME(rs.getString("BRAND_NAME"));
				mechanic.setEXPERIENCE_WITH_COMPANIES(rs.getString("EXPERIENCE_WITH_COMPANIES"));
				mechanic.setWORKED_IN_COMPANIES(rs.getString("WORKED_IN_COMPANIES"));
				alMechanic.add(mechanic);
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
		return alMechanic;
	}

	@Override
	public MechanicProfile getMechanicProfile(String email) {
		MechanicProfile mechanic = new MechanicProfile();
		Statement stmt = null;
		conn = DBConnection.getConnection();
		try {
			String query = "select * from mechanic_details where email='" + email + "'";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				mechanic.setNAME(rs.getString("NAME"));
				mechanic.setEMAIL(rs.getString("EMAIL"));
				mechanic.setMOBILE_NO(rs.getString("MOBILE_NO"));
				mechanic.setQUALIFICATION(rs.getString("QUALIFICATION"));
				mechanic.setCITY(rs.getString("CITY"));
				mechanic.setADDRESS(rs.getString("ADDRESS"));
				mechanic.setSTATE(rs.getString("STATE"));
				mechanic.setDISTRICT(rs.getString("DISTRICT"));
				mechanic.setPINCODE(rs.getString("PINCODE"));
				mechanic.setEXPERIENCE(rs.getString("EXPERIENCE"));
				mechanic.setSPECIALIZED_IN(rs.getString("SPECIALIZED_IN"));
				mechanic.setBRAND_NAME(rs.getString("BRAND_NAME"));
				mechanic.setEXPERIENCE_WITH_COMPANIES(rs.getString("EXPERIENCE_WITH_COMPANIES"));
				mechanic.setWORKED_IN_COMPANIES(rs.getString("WORKED_IN_COMPANIES"));
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
		return mechanic;
	}
	
	public String addMechanic1(MechanicProfile addMechanic, String user_name) {
		String message = null;
		PreparedStatement preparedStatement=null;
		Statement st = null;
		try {
			String query = "insert into mechanic_details values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			st=conn.createStatement();
			/*int i=st.executeUpdate("INSERT INTO `mechanic_details` (`NAME`, `EMAIL`, `MOBILE_NO`, "
					+ "`QUALIFICATION`, `ADDRESS`, `CITY`, `STATE`, `DISTRICT`, `PINCODE`, "
					+ "`EXPERIENCE`, `SPECIALIZED_IN`, `BRAND_NAME`, "
					+ "`EXPERIENCE_WITH_COMPANIES`, "
					+ "`WORKED_IN_COMPANIES`, `STATUS`, `VERIFIED`, `REFERENCE_ID`) VALUES "
					+ "('"+addMechanic.getNAME()+"', '"+addMechanic.getEMAIL()+"', '"+addMechanic.getMOBILE_NO()
					+"', '"+addMechanic.getQUALIFICATION()+"', '"+addMechanic.getADDRESS()
					+"', '"+addMechanic.getCITY()+"', '"+addMechanic.getCITY()+"', '"+addMechanic.getDISTRICT()
					+"', '"+addMechanic.getPINCODE()+"', '"+addMechanic.getEXPERIENCE()
					+"', '"+addMechanic.getSPECIALIZED_IN()+"', '"+addMechanic.getBRAND_NAME()
					+"', '"+addMechanic.getEXPERIENCE_WITH_COMPANIES()+"', '"+addMechanic.getWORKED_IN_COMPANIES()
					+"', 'ACTIVE', 'NO', '"+user_name+"')", Statement.RETURN_GENERATED_KEYS);*/
			
			preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			System.out.println("Mahesh 1 af pst");
			preparedStatement.setString(1, addMechanic.getMECHANIC_SEQ_ID());
			preparedStatement.setString(2, addMechanic.getNAME());
			preparedStatement.setString(3, addMechanic.getEMAIL());
			preparedStatement.setString(4, addMechanic.getMOBILE_NO());
			preparedStatement.setString(5, addMechanic.getQUALIFICATION());
			preparedStatement.setString(6, addMechanic.getADDRESS());
			preparedStatement.setString(7, addMechanic.getCITY());
			preparedStatement.setString(8, addMechanic.getSTATE());
			preparedStatement.setString(9, addMechanic.getDISTRICT());
			preparedStatement.setString(10, addMechanic.getPINCODE());
			preparedStatement.setString(11, addMechanic.getEXPERIENCE());
			preparedStatement.setString(12, addMechanic.getSPECIALIZED_IN());
			preparedStatement.setString(13, addMechanic.getBRAND_NAME());
			preparedStatement.setString(14, addMechanic.getEXPERIENCE_WITH_COMPANIES());
			preparedStatement.setString(15, addMechanic.getWORKED_IN_COMPANIES());
			preparedStatement.setString(16, "ACTIVE");
			preparedStatement.setString(17, "NO");
			preparedStatement.setString(18, user_name);
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				message = "success";
			} else {
				message = "failure";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}
}
