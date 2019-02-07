package com.vaahanmitra.service;

import com.vaahanmitra.dao.EmployeeDao;
import com.vaahanmitra.daoImpl.EmployeeDaoImpl;
import com.vaahanmitra.model.EmployeeBean;

public class EmployeeService {
	
	public EmployeeBean getEmployeeDetails(String email) {

		EmployeeDao dao = new EmployeeDaoImpl();
		EmployeeBean emp = dao.getEmployeeProfile(email);
		return emp;
	}
}
