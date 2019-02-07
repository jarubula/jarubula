package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.BusinessOwnerRegisterDao;
import com.vaahanmitra.daoImpl.BusinessOwnerRegisterDaoImpl;

/**
 * Servlet implementation class ServiceCenterVehicleTypeController
 */
public class ServiceCenterVehicleTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceCenterVehicleTypeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = null;
		BusinessOwnerRegisterDao register = new BusinessOwnerRegisterDaoImpl();
		
		HttpSession session = request.getSession(false);
		String user_name = (String)session.getAttribute("user");
		
		String vehicleType = register.getUserType(user_name);
		if (vehicleType.equals("4,")) {
			page = "./carType.jsp";
		} else {
			if(vehicleType.equals("2,")){
				page = "./bikeType.jsp";
			}
			else if (vehicleType.equals("4,2,")) {
				page = "./carType2.jsp";
			} 
		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		request.setAttribute("success", vehicleType);
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
