package com.vaahanmitra.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vaahanmitra.dao.EmployeeDao;
import com.vaahanmitra.dbutil.DBConnection;
import com.vaahanmitra.dbutil.IdGen;
import com.vaahanmitra.model.CarService;
import com.vaahanmitra.model.EmployeeBean;
import com.vaahanmitra.model.UsedCar;
import com.vaahanmitra.model.UserLogin;
import com.vaahanmitra.utilities.EmployeeId;
import com.vaahanmitra.utilities.SQLDate;

public class EmployeeDaoImpl implements EmployeeDao {

	private Connection con = null;

	@Override
	public String addEmployee(EmployeeBean bean, UserLogin login) {
		PreparedStatement pst = null;
		String message = null;
		try {
			String query = "insert into add_employee values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CURDATE(),?,?,?,?,?)";
			String query1 = "insert into user_login values (?,?,?,?,?,?)";

			String id1 = new IdGen().getId("EMPLOYEE_ID");
			EmployeeId sci = new EmployeeId();
			String emId = sci.employeeId(id1);

			con = DBConnection.getConnection();
			pst = con.prepareStatement(query, pst.RETURN_GENERATED_KEYS);
			PreparedStatement preparedStatement1 = con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, bean.getSEQUENCE_NO());
			pst.setString(2, bean.getFIRST_NAME());
			pst.setString(3, bean.getLAST_NAME());
			pst.setString(4, bean.getDOB());
			pst.setString(5, bean.getGENDER());
			pst.setString(6, bean.getEMAIL_ID());
			pst.setString(7, bean.getMOBILE_NO());
			pst.setString(8, bean.getADHAR_NO());
			pst.setString(9, bean.getPANCARD_NO());
			pst.setString(10, bean.getADDRESS());
			pst.setString(11, bean.getCITY());
			pst.setString(12, bean.getSTATE());
			pst.setString(13, bean.getDISTRICT());
			pst.setString(14, bean.getPINCODE());
			pst.setString(15, bean.getDIVISION());
			pst.setString(16, bean.getDSTATE());
			pst.setString(17, emId);
			pst.setString(18, bean.getASSIGN_ROLE());
			pst.setString(19, bean.getPROFILE_VIEW());
			pst.setString(20, bean.getSTATUS());
			pst.setString(21, bean.getREPORTS());

			preparedStatement1.setInt(1, login.getSEQUENCE_NO());
			preparedStatement1.setString(2, login.getEMAIL_ID());
			preparedStatement1.setString(3, login.getPASSWORD());
			preparedStatement1.setString(4, login.getUSER_TYPE());
			preparedStatement1.setString(5, "0");
			preparedStatement1.setString(6, login.getSTATUS());

			int i = pst.executeUpdate();
			int j = preparedStatement1.executeUpdate();
			if (i > 0 && j > 0) {
				message = "Employee added...";
			} else {
				message = "Employee not added! try again!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return message;
	}

	@Override
	public String checkEmployee(String email) {
		con = DBConnection.getConnection();
		String existEmail = null;
		String message = null;
		try {
			String query = "select EMAIL_ID from add_employee where EMAIL_ID='" + email + "'";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				existEmail = rs.getString("EMAIL_ID");
			}
			if (email.equals(existEmail)) {
				message = "true";
			} else {
				message = "false";
			}
			preparedStatement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public ArrayList<EmployeeBean> viewAllServices() {
		ArrayList<EmployeeBean> eBean = new ArrayList<EmployeeBean>();
		ResultSet rs = null;
		Statement stmt = null;
		String sqlQuery = "SELECT * from add_employee";
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlQuery);
			while (rs.next()) {
				EmployeeBean bean = new EmployeeBean();
				bean.setFIRST_NAME(rs.getString("FIRST_NAME"));
				bean.setLAST_NAME(rs.getString("LAST_NAME"));
				bean.setGENDER(rs.getString("GENDER"));
				bean.setEMAIL_ID(rs.getString("EMAIL_ID"));
				bean.setMOBILE_NO(rs.getString("MOBILE_NO"));
				bean.setADHAR_NO(rs.getString("ADHAR_NO"));
				bean.setPANCARD_NO(rs.getString("PANCARD_NO"));
				bean.setADDRESS(rs.getString("ADDRESS"));
				bean.setCITY(rs.getString("CITY"));
				bean.setSTATE(rs.getString("STATE"));
				bean.setDISTRICT(rs.getString("DISTRICT"));
				bean.setPINCODE(rs.getString("PINCODE"));
				bean.setDIVISION(rs.getString("DIVISION"));
				bean.setDSTATE(rs.getString("D_STATE"));
				bean.setEMPLOYEE_ID(rs.getString("EMPLOYEE_ID"));
				eBean.add(bean);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return eBean;
	}

	@Override
	public String assignRole(EmployeeBean bean) {
		PreparedStatement pstmt = null;
		String message = null;
		try {
			String query = "UPDATE add_employee SET ASSIGN_ROLE=?,PROFILE_VIEW=?,STATUS=?,REPORTS=? WHERE EMPLOYEE_ID ='"
					+ bean.getEMAIL_ID() + "'";
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bean.getASSIGN_ROLE());
			pstmt.setString(2, bean.getPROFILE_VIEW());
			pstmt.setString(3, bean.getSTATUS());
			pstmt.setString(4, bean.getREPORTS());
			int i1 = pstmt.executeUpdate();
			if (i1 > 0) {
				message = "success";
			} else {
				message = "failure";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return message;
	}

	@Override
	public String getAssignRole(String email) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String roles = null;
		try {
			String query = "SELECT ASSIGN_ROLE from add_employee where EMAIL_ID='" + email + "'";
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				roles = rs.getString("ASSIGN_ROLE");
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
		return roles;
	}

	@Override
	public EmployeeBean getEmployeeProfile(String email) {
		Statement st = null;
		ResultSet rs = null;
		EmployeeBean emp = new EmployeeBean();
		try {
			String query = "select * from add_employee where email_id='" + email + "'";
			con = DBConnection.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				emp.setSTATE(rs.getString("STATE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return emp;
	}

	@Override
	public String addService(String user_name, String email, String userType) {
		String message = null;
		EmployeeBean bean = new EmployeeBean();
		try {
			String query = "insert into employee_reg_services values (?,?,?,?)";
			con = DBConnection.getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, bean.getSEQUENCE_NO());
			preparedStatement.setString(2, user_name);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, userType);
			int i = preparedStatement.executeUpdate();
			
			if (i > 0) {
				message = "Registration Successfull! Please Verfiy your Email";
			} else {
				message = "Registration not completed! Please try again.";
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return message;
	}

}