package com.vaahanmitra.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.vaahanmitra.dao.LoginDao;
import com.vaahanmitra.dbutil.DBConnection;
import com.vaahanmitra.service.SendMail;

public class LoginDaoImpl implements LoginDao{

	private Connection conn = DBConnection.getConnection();
	public HashMap<String,String> userLogin(String emailId, String password) {
		
		HashMap<String, String> login = new HashMap<String, String>();
		
		try {
		//	System.out.println("SELECT * FROM user_login WHERE EMAIL_ID like BINARY '"+emailId+"' AND PASSWORD like BINARY '"+password+"' and STATUS='ACTIVE'");
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM user_login WHERE EMAIL_ID like BINARY '"+emailId+"' AND PASSWORD like BINARY '"+password+"' and STATUS='ACTIVE'");
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next())
	        {
	            login.put("UserType", rs.getString("USER_TYPE"));
	           // login.put("UserId", rs.getString("REFERENCE_ID"));
	            login.put("email", rs.getString("EMAIL_ID"));
	        }
	        else
	        {
	            login = null;
	        }
	        conn.close();  

		} 
	       catch (Exception err) {
	    	   err.printStackTrace();
	       }
		return login;                                                                     
	}
	@Override
	public boolean changePassword(String oldPassword, String newPassword, String user_name) {
		boolean check= false;
		String dbpwd = null;
		Connection conn = DBConnection.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM user_login WHERE EMAIL_ID like BINARY '"+user_name+"' AND PASSWORD like BINARY '"+oldPassword+"'");
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
	        {
				dbpwd = rs.getString("PASSWORD");
	        }
			if(dbpwd.equals(oldPassword))
			{
				String query = "UPDATE user_login SET PASSWORD='"+ newPassword +"' WHERE EMAIL_ID like BINARY'" + user_name + "'";
				int i = preparedStatement.executeUpdate(query);
				if(i>0)
				{
					 check = true;
				}else{
					check = false;
				}
			}else{
					 check = false;
				}
	      }catch(Exception err){
	      }finally {
				try {
					
					conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return check;
	}
	@Override
	public String getEmail(String emailId) {
		String existEmail = null, status = null, message = "no";
		try {
			String query = "select * from user_login where EMAIL_ID='" + emailId + "'";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				existEmail = rs.getString("EMAIL_ID");
				status = rs.getString("STATUS");
			}
			if (emailId.equals(existEmail) && status.equals("INACTIVE")) {
				message = "EMAIL ID Already Registered with US! Please verify your Email for Login";
				String url = "http://vaahanmitra.com/VerifyIORegister?eid=" + emailId + "&ut=BO";
				String textMsg = "Thank you for registering... Please <a href='" + url + "'> verify your EMAIL ID</a>";
				SendMail.send(emailId, textMsg);
			} else {
				System.out.println("email" + emailId);
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
	public String checkUserPwd(String emailId, String password) {

		String message = "no";
		String dbpwd = null, dbUserName = null, status = null;
		Connection conn = DBConnection.getConnection();
		try {
			String sql = "select * from user_login where EMAIL_ID='" + emailId + "'";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				dbUserName = rs.getString("EMAIL_ID");
				dbpwd = rs.getString("PASSWORD");
				status = rs.getString("STATUS");
				if (dbpwd!=password && dbUserName.equals(emailId) && status.equals("INACTIVE")) {
					message = "PI";
					String url = "http://vaahanmitra.com/VerifyIORegister?eid=" + emailId + "&ut=BO";
					String textMsg = "Thank you for registering... Please <a href='" + url
							+ "'> verify your EMAIL ID</a>";
					SendMail.send(emailId, textMsg);
				} else if (dbpwd.equals(password) && dbUserName.equals(emailId) && status.equals("ACTIVE")) {
					message = "yes";
				} else if (dbpwd.equals(password) && dbUserName.equals(emailId) && status.equals("INACTIVE")) {
					message ="I";
					String url = "http://vaahanmitra.com/VerifyIORegister?eid=" + emailId + "&ut=BO";
					String textMsg = "Thank you for registering... Please <a href='" + url
							+ "'> verify your EMAIL ID</a>";
					SendMail.send(emailId, textMsg);
				} else if(dbpwd!=password && dbUserName.equals(emailId) && status.equals("ACTIVE")){
					message = "P";
				}
			}
		} catch (Exception err) {
			err.printStackTrace();
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
	public String getUserEmail(String emailId) {
		String existEmail = null, message = "no";
		try {
			String query = "select * from user_login where EMAIL_ID='" + emailId + "'";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				existEmail = rs.getString("EMAIL_ID");
				if (emailId.equals(existEmail)) {
					message = "yes";
					String url = "http://vaahanmitra.com/resetPassword.jsp?eid="+emailId+"";
					String textMsg = "Please cilck the link for <a href='" + url	+ "'> Reset Password </a>";
					SendMail.send(emailId, textMsg);
				}
			}
			preparedStatement.close();
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
	public String forgotPassword(String email,String password) {
		String message = null;
		Connection conn = null;
		try {
			String sql = "UPDATE user_login SET PASSWORD=?,STATUS=? WHERE EMAIL_ID ='"+email+ "'";
			conn = DBConnection.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, "ACTIVE");
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
	public String checkUserAndPwd(String emailId, String password) {
		String message = "no";
		String dbpwd = null, dbUserName = null, status = null;
		Connection conn = DBConnection.getConnection();
		try {
			String sql = "select * from user_login where EMAIL_ID='" + emailId + "'";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				dbUserName = rs.getString("EMAIL_ID");
				dbpwd = rs.getString("PASSWORD");
				status = rs.getString("STATUS");
				if (dbpwd!=password && dbUserName.equals(emailId) && status.equals("INACTIVE")) {
					message = "PI";
					String url = "http://vaahanmitra.com/VerifyIORegister?eid=" + emailId + "&ut=BO";
					String textMsg = "Thank you for registering with VAAHANMITRA! Please <a href='" + url
							+ "'> verify your EMAIL ID</a>";
					SendMail.send(emailId, textMsg);
				} else if (dbpwd.equals(password) && dbUserName.equals(emailId) && status.equals("ACTIVE")) {
					message = "yes";
				} else if (dbpwd.equals(password) && dbUserName.equals(emailId) && status.equals("INACTIVE")) {
					message ="I";
					String url = "http://vaahanmitra.com/VerifyIORegister?eid=" + emailId + "&ut=BO";
					String textMsg = "Thank you for registering with VAAHANMITRA! Please <a href='" + url
							+ "'> verify your EMAIL ID</a>";
					SendMail.send(emailId, textMsg);
				} else if(dbpwd!=password && dbUserName.equals(emailId) && status.equals("ACTIVE")){
					message = "P";
				}
			}
		} catch (Exception err) {
			err.printStackTrace();
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
	public String getUserType(String email) {
		String userType = null;;
		try {
			String query = "select * from user_login where EMAIL_ID='" + email + "'";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				userType = rs.getString("USER_TYPE");
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
		return userType;
	}
}
