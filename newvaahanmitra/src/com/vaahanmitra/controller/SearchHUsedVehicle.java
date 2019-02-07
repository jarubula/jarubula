package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.model.UsedCar;

/**
 * Servlet implementation class SearchHUsedVehicle
 */
public class SearchHUsedVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchHUsedVehicle() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String vType = request.getParameter("vType");
		String vehicleBrand=request.getParameter("vehicleBrand");
		String city=request.getParameter("city");
		String budget=request.getParameter("carBudget");
		String vehcileModel=request.getParameter("vehicleModel");
		budget = "SELECT";
		
		RequestDispatcher rd = null;
		if(vType.equals("2,")){
			rd=request.getRequestDispatcher("./SearchHUsedBike");
			request.setAttribute("bikeBrand", vehicleBrand);
			request.setAttribute("bikeModel", vehcileModel);
			request.setAttribute("bikeBudget", budget);
			request.setAttribute("city", city);
			rd.forward(request, response);
		}else{
			rd=request.getRequestDispatcher("./SearchUsedCar");
			request.setAttribute("carBrand", vehicleBrand);
			request.setAttribute("carModel", vehcileModel);
			request.setAttribute("carBudget", budget);
			request.setAttribute("city", city);
			rd.forward(request, response);
		}
//		./SearchUsedCar ./SearchHUsedBike
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
