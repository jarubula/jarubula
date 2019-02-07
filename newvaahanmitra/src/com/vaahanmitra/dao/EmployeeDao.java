package com.vaahanmitra.dao;

import java.util.ArrayList;

import com.vaahanmitra.model.EmployeeBean;
import com.vaahanmitra.model.UsedCar;
import com.vaahanmitra.model.UserLogin;

public interface EmployeeDao {

	String addEmployee(EmployeeBean bean, UserLogin login);

	String checkEmployee(String email);
	
	public ArrayList<EmployeeBean> viewAllServices();

	String assignRole(EmployeeBean bean);
	
	public String getAssignRole(String email);

	EmployeeBean getEmployeeProfile(String email);

	String addService(String user_name, String email, String userType);

}
