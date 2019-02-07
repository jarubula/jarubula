package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.AddBikeDao;
import com.vaahanmitra.daoImpl.AddBikeDaoImpl;
import com.vaahanmitra.model.AddBike;

/**
 * Servlet implementation class SearchHNewBike
 */
public class SearchHNewBike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchHNewBike() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vBrand = (String)request.getAttribute("vBrand");
		String vehicleModel = (String)request.getAttribute("vehicleModel");
		String vType = (String)request.getAttribute("vType");
		String vvariant     = (String)request.getAttribute("vvariant");
		String makeYear     = (String)request.getAttribute("makeYear");
		String spage        = (String)request.getAttribute("spage");
		String bodytype     = (String)request.getAttribute("bodytype");
		String fueltype     = (String)request.getAttribute("fueltype");
		String transmission = (String)request.getAttribute("transmission");
		String color        = (String)request.getAttribute("color");
		String budget       = (String)request.getAttribute("budget");
		
		int page = 1;		
		int maxrowsperpage=5;
		int noofRecords =0,numofpages=0;
			
		 if(request.getParameter("page") != null){
				page = Integer.parseInt(request.getParameter("page"));	
			}
		AddBikeDao dao = new AddBikeDaoImpl();
		ArrayList<AddBike> bikeDetails=new ArrayList<AddBike>();
		if(spage.equals("home")){
	      bikeDetails = dao.getNewBike(vBrand,vehicleModel,vvariant,makeYear,(page-1)*maxrowsperpage, maxrowsperpage);
		}
		else{
			
			bikeDetails=dao.getNewBikewithAdvanceFilter(vBrand, vehicleModel, vvariant, makeYear, bodytype, fueltype, transmission, color, budget,(page-1)*maxrowsperpage, maxrowsperpage);
			
		}
		
		noofRecords=dao.getNoOfRecords();
		
		if(noofRecords%maxrowsperpage>0){				
		numofpages=(noofRecords/maxrowsperpage)+1;
		}
		else{
			numofpages=noofRecords/maxrowsperpage;
		}
		try
		{
			if(request.getAttribute("message")==null)
			{
				
			}
			else
			{
				request.setAttribute("message", request.getAttribute("message"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("./newbike.jsp");/*./searchHNewBike.jsp*/
		
		if(spage.equals("home")){
		request.setAttribute("bikeDetails", bikeDetails);
		request.setAttribute("vModel", vehicleModel);
		request.setAttribute("vType", vType);
		request.setAttribute("makeyear", makeYear);
		request.setAttribute("spage", spage);
		request.setAttribute("vBrand", vBrand);
		request.setAttribute("vType", vType);
		request.setAttribute("noOfPages", numofpages);
		request.setAttribute("noofrecords", noofRecords);
		request.setAttribute("currentPage", page);
		request.setAttribute("maxrowsperpage", maxrowsperpage);
		}
		
		else{
			request.setAttribute("bikeDetails", bikeDetails);
			request.setAttribute("vModel", vehicleModel);
			request.setAttribute("vBrand", vBrand);
			request.setAttribute("vType", vType);
			request.setAttribute("makeyear", makeYear);
			request.setAttribute("vvariant", vvariant);
			request.setAttribute("spage", spage);
			request.setAttribute("bodytype", bodytype);
			request.setAttribute("fueltype", fueltype);
			request.setAttribute("transmission", transmission);
			request.setAttribute("color", color);
			request.setAttribute("budget", budget);
			request.setAttribute("noOfPages", numofpages);
			request.setAttribute("noofrecords", noofRecords);
			request.setAttribute("currentPage", page);
			request.setAttribute("maxrowsperpage", maxrowsperpage);
			
		}
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
