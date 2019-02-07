package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchNewVehicle extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String vType        = request.getParameter("vType");
		String vBrand       = request.getParameter("vehicleBrand");
		String vehicleModel = request.getParameter("vehicleModel");
		String vvariant     = request.getParameter("vvariant");
		String makeYear     = request.getParameter("makeYear");
		String spage        = request.getParameter("spage");
		String bodytype     = request.getParameter("bodyType");
		String fueltype     = request.getParameter("fuelType");
		String transmission = request.getParameter("transmission");
		String color        = request.getParameter("color");
		String budget       = request.getParameter("budget");
		RequestDispatcher rd = null;
		if(vType.equals("2,")){
			rd=request.getRequestDispatcher("./SearchHNewBike");
		}else{
			rd=request.getRequestDispatcher("./SearchHNewCar");
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
		request.setAttribute("vBrand", vBrand);
		request.setAttribute("vType", vType);
		request.setAttribute("vehicleModel", vehicleModel);
		request.setAttribute("vvariant", vvariant);
		request.setAttribute("makeYear", makeYear);
		request.setAttribute("spage", spage);
		request.setAttribute("bodytype", bodytype);
		request.setAttribute("fueltype", fueltype);
		request.setAttribute("transmission", transmission);
		request.setAttribute("color", color);
		request.setAttribute("budget", budget);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
