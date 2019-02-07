package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.AddCarDao;
import com.vaahanmitra.daoImpl.AddCarDaoImpl;
import com.vaahanmitra.model.AddCar;

public class SearchHNewCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchHNewCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String vBrand       = (String)request.getAttribute("vBrand");
		String vehicleModel = (String)request.getAttribute("vehicleModel");
		String vType        = (String)request.getAttribute("vType");
		String vvariant     = (String)request.getAttribute("vvariant");
		String makeYear     = (String)request.getAttribute("makeYear");
		String spage        = (String)request.getAttribute("spage");
		String bodytype     = (String)request.getAttribute("bodytype");
		String fueltype     = (String)request.getAttribute("fueltype");
		String transmission = (String)request.getAttribute("transmission");
		String color        = (String)request.getAttribute("color");
		String budget       = (String)request.getAttribute("budget");
		
		int page = 1;  
		  int maxrowsperpage=3;
		  int noofRecords =0,numofpages=0;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		 
		AddCarDao dao = new AddCarDaoImpl();
		ArrayList<AddCar> carDetails= new ArrayList<AddCar>();
		if(spage.equals("home")){
		
			carDetails = dao.getNewCar(vBrand,vehicleModel,vvariant,makeYear,(page-1)*maxrowsperpage, maxrowsperpage);
		}
		else{
			
			carDetails = dao.getNewCarwithAdvanceFilter(vBrand, vehicleModel, vvariant, makeYear, bodytype, fueltype, transmission, color,budget, (page-1)*maxrowsperpage, maxrowsperpage);
		}
		noofRecords=dao.getNoOfRecords();
		if (noofRecords % maxrowsperpage > 0) {
			numofpages = (noofRecords / maxrowsperpage) + 1;
		} else {
			numofpages = noofRecords / maxrowsperpage;
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
		RequestDispatcher rd=request.getRequestDispatcher("./searchHNewCar.jsp");
		if(spage.equals("home")){
		request.setAttribute("carDetails", carDetails);
		request.setAttribute("vModel", vehicleModel);
		request.setAttribute("vBrand", vBrand);
		request.setAttribute("vType", vType);
		request.setAttribute("vvariant", vvariant);
		request.setAttribute("makeyear", makeYear);
		request.setAttribute("spage", spage);
		request.setAttribute("noOfPages", numofpages);
		request.setAttribute("noofrecords", noofRecords);
		request.setAttribute("currentPage", page);
		request.setAttribute("maxrowsperpage", maxrowsperpage);
		}
		else{
			
			request.setAttribute("carDetails", carDetails);
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
