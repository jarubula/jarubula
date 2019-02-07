package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.DriverDAO;
import com.vaahanmitra.daoImpl.DriverDAOImpl;

/**
 * Servlet implementation class SearchHOnDemandDriver
 */
public class SearchHOnDemandDriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchHOnDemandDriver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fromCity=request.getParameter("fromCity");
		String toCity=request.getParameter("toCity");
		String date=request.getParameter("date");
		String time=request.getParameter("time");
		
		int page = 1;		
		int maxrowsperpage=10;
		int noofRecords =0,numofpages=0;
			
		 if(request.getParameter("page") != null){
				page = Integer.parseInt(request.getParameter("page"));	
			}
		
		DriverDAO ddo=new DriverDAOImpl();
		ArrayList driverAl=ddo.searchHOnDemandDriver(fromCity, toCity, date,time,(page-1)*maxrowsperpage, maxrowsperpage);
		
		noofRecords=ddo.getNoOfRecords();
		if(noofRecords%maxrowsperpage>0){				
		numofpages=(noofRecords/maxrowsperpage)+1;
		}
		
		else{
			numofpages=noofRecords/maxrowsperpage;
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("./searchHOnDemandDriver.jsp");
		request.setAttribute("driverAl", driverAl);
		request.setAttribute("fromCity", fromCity);
		request.setAttribute("toCity", toCity);
		request.setAttribute("date", date);
		request.setAttribute("time", time);
		request.setAttribute("noOfPages", numofpages);
		request.setAttribute("noofrecords", noofRecords);
		request.setAttribute("currentPage", page);
		request.setAttribute("maxrowsperpage", maxrowsperpage);
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
