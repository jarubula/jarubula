package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.MechanicDao;
import com.vaahanmitra.daoImpl.MechanicDaoImpl;
import com.vaahanmitra.model.ServiceMechanic;

/**
 * Servlet implementation class SearchHMechanic
 */
public class SearchHMechanic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchHMechanic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServiceMechanic mbean=new ServiceMechanic();
		String city=request.getParameter("city");
		String vehicleType=request.getParameter("vehicleType");
		String vehicleBrand=request.getParameter("vehicleBrand");
		String street=request.getParameter("street");
		
		if(street==null){
		street="SELECT";	
		}
		
		mbean.setSELECTED_VEHICLE_TYPE(vehicleType);
		mbean.setBRAND(vehicleBrand);
		mbean.setADDRESS(street);
		
		int page = 1;		
		int maxrowsperpage=30;
		int noofRecords =0,numofpages=0;
			
		 if(request.getParameter("page") != null){
				page = Integer.parseInt(request.getParameter("page"));	
			}
		
		MechanicDao mdao=new MechanicDaoImpl();
		ArrayList mechanicDetails=mdao.searchHMechanic(mbean,city,(page-1)*maxrowsperpage, maxrowsperpage);
		noofRecords=mdao.getNoOfRecords();
		if(noofRecords%maxrowsperpage>0){				
		numofpages=(noofRecords/maxrowsperpage)+1;
		}
		
		else{
			numofpages=noofRecords/maxrowsperpage;
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("./searchHMechanic.jsp");
		request.setAttribute("mechanicDetails", mechanicDetails);
		request.setAttribute("city", city);
		request.setAttribute("vehicleType", vehicleType);
		request.setAttribute("vehicleBrand", vehicleBrand);
		request.setAttribute("street", street);
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
