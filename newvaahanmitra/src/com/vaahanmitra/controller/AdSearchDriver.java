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

public class AdSearchDriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String message = null;
		String fdate = request.getParameter("fdate");
		String tdate = request.getParameter("tdate");
		
	/*	int page = 1;
		int maxrowsperpage = 3;
		int noofRecords = 0, numofpages = 0;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}*/
		
		AdminDao dao = new AdminDaoImpl();
//		ArrayList<DriverBean> drDetails = dao.getDriverDetails(fdate,tdate,(page - 1) * maxrowsperpage, maxrowsperpage);
		ArrayList<DriverBean> drDetails = dao.getDriverDetails(fdate,tdate);

/*		noofRecords = dao.getNoOfRecords();
		if (noofRecords % maxrowsperpage > 0) {
			numofpages = (noofRecords / maxrowsperpage) + 1;
		} else {
			numofpages = noofRecords / maxrowsperpage;
		}*/
		if (drDetails.size() > 0) {
			message = "Driver Details";
		} else {
			message = "Drivers not found";
		}
		RequestDispatcher rd=request.getRequestDispatcher("./adSearchDriver.jsp");
		request.setAttribute("drDetails", drDetails);
		request.setAttribute("fdate", fdate);
		request.setAttribute("tdate", tdate);
		request.setAttribute("message", message);
		/*request.setAttribute("noOfPages", numofpages);
		request.setAttribute("noofrecords", noofRecords);
		request.setAttribute("currentPage", page);
		request.setAttribute("maxrowsperpage", maxrowsperpage);*/
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
