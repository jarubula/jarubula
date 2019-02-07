package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.VehicleTypeDao;
import com.vaahanmitra.daoImpl.VehicleTypeDaoImpl;
import com.vaahanmitra.model.VehicleType;

/**
 * Servlet implementation class BikeTypeController
 */
public class BikeTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BikeTypeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VehicleType type = new VehicleType();
		type.setBRAND(request.getParameter("brandid"));
		type.setSELECTED_VEHICLE_TYPE("2,");
		
		String vehicles="";
		String vehicleType[]=request.getParameterValues("models");
		for(int i=0;i<vehicleType.length;i++){
			vehicles+=vehicleType[i]+",";
		}
		type.setMODEL(vehicles);
		HttpSession session = request.getSession(false);
		String user_name = (String)session.getAttribute("user");
		
		VehicleTypeDao dao = new VehicleTypeDaoImpl();
		String message = dao.vehicleDetails(type, user_name);
		if(message.equals("success"))
		{
			String msge = "Bike Models Added Successfully...";
			RequestDispatcher rd = request.getRequestDispatcher("./bikeType.jsp");
			request.setAttribute("true", msge);
			rd.forward(request, response);
		}
		else{
			String msge = "Bike Models Not Added...";
			RequestDispatcher rd = request.getRequestDispatcher("./bikeType.jsp");
			request.setAttribute("false", message);
			rd.forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
