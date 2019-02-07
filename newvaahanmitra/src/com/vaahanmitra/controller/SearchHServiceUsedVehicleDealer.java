package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.SearchHUsedVehicleDealerDAO;
import com.vaahanmitra.daoImpl.SearchHUsedVehicleDealerDAOImpl;
import com.vaahanmitra.model.BusinessOwnerRegister;

/**
 * Servlet implementation class SearchHServiceUsedVehicleDealer
 */
public class SearchHServiceUsedVehicleDealer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchHServiceUsedVehicleDealer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BusinessOwnerRegister mbean=new BusinessOwnerRegister();
		String city=request.getParameter("city");
		String vehicleType=request.getParameter("vehicleType");
		String dealerName=request.getParameter("dealerName");
		mbean.setB_CITY(city);
		mbean.setVEHICLE_TYPE(vehicleType);
		mbean.setNAME(dealerName);
		
		int page = 1;		
		int maxrowsperpage=5;
		int noofRecords =0,numofpages=0;
			
		 if(request.getParameter("page") != null){
				page = Integer.parseInt(request.getParameter("page"));	
			}
		
		
		SearchHUsedVehicleDealerDAO ddao=new SearchHUsedVehicleDealerDAOImpl();
		ArrayList<BusinessOwnerRegister> dealerDetails=ddao.searchHUsedVehicleDealer(mbean,(page-1)*maxrowsperpage, maxrowsperpage);
		
		noofRecords=ddao.getNoOfRecords();
		
		if(noofRecords%maxrowsperpage>0){				
		numofpages=(noofRecords/maxrowsperpage)+1;
		}
		
		else{
			numofpages=noofRecords/maxrowsperpage;
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("./searchHServiceUsedVehicleDealer.jsp");
		request.setAttribute("dealerDetails", dealerDetails);
		request.setAttribute("city", city);
		request.setAttribute("vehicleType", vehicleType);
		request.setAttribute("dealerName", dealerName);
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
