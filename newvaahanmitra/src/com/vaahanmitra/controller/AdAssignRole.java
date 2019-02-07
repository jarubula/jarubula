package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.EmployeeDao;
import com.vaahanmitra.daoImpl.EmployeeDaoImpl;
import com.vaahanmitra.model.EmployeeBean;

/**
 * Servlet implementation class AdAssignRole
 */
public class AdAssignRole extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdAssignRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmployeeDao dao = new EmployeeDaoImpl();
		ArrayList<EmployeeBean> list = new ArrayList<EmployeeBean>();
		list = dao.viewAllServices();
		
		RequestDispatcher rd = request.getRequestDispatcher("./AdEmployeeList.jsp");
		request.setAttribute("employeeList", list);
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
