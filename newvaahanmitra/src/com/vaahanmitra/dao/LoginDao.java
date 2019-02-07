package com.vaahanmitra.dao;

import java.util.HashMap;

public interface LoginDao {
	public HashMap<String,String> userLogin(String emailId,String password);
	public boolean changePassword(String oldPassword, String newPassword, String user_name);
	public String getEmail(String emailId);
	public String checkUserPwd(String emailId, String password);
	public String getUserEmail(String emailId);
	public String forgotPassword(String email,String Password);
	public String checkUserAndPwd(String emailId, String password);
	public String getUserType(String email);
}
