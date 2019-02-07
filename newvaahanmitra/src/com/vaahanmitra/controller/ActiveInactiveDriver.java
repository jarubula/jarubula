package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.AdminDao;
import com.vaahanmitra.daoImpl.AdminDaoImpl;
import com.vaahanmitra.model.DriverBean;

/**
 * Servlet implementation class ActiveInactiveDriver
 */
public class ActiveInactiveDriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ActiveInactiveDriver() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String driverId = request.getParameter("driverId");
		String status = request.getParameter("status");
		String fdate = request.getParameter("fdate");
		String tdate = request.getParameter("tdate");
		String drEmail = request.getParameter("drEmail");
	
		AdminDao dao = new AdminDaoImpl();
		
		String message = dao.activeIncative(driverId,status,drEmail);
		if(message.equals("success") && status.equals("ACTIVE")){
			message = "Driver Inactivated";
		}else{
			message = "Driver Activated";
		}
		ArrayList<DriverBean> drDetails = dao.getDriverDetails(fdate,tdate);
		RequestDispatcher rd=request.getRequestDispatcher("./adSearchDriver.jsp");
		request.setAttribute("drDetails", drDetails);
		request.setAttribute("fdate", fdate);
		request.setAttribute("tdate", tdate);
		request.setAttribute("message", message);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
