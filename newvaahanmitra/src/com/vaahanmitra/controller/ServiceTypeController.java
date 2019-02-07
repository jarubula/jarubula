package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.ServiceTypeDao;
import com.vaahanmitra.daoImpl.ServiceTypeDaoImpl;
import com.vaahanmitra.model.ServiceType;
import com.vaahanmitra.model.UpdateServicePrice;

/**
 * Servlet implementation class ServiceTypeController
 */
public class ServiceTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceTypeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServiceType serviceType = new ServiceType();
		String serviceId = null, message = null,jspPage = null;
		String vehicleType = request.getParameter("vehicleType");
		System.out.println("ve"+vehicleType);
		if (vehicleType.equals("carServiceType.jsp")) {
			serviceType.setVEHICLE_TYPE("4,");
		} else {
			serviceType.setVEHICLE_TYPE("2,");
		}
		serviceId = request.getParameter("serviceId");
		serviceType.setSERVICE_ID(serviceId);
		serviceType.setSERVICE_TYPE(request.getParameter("serviceType"));
		serviceType.setSERVICE_DESCRIPTION(request.getParameter("serviceDescription"));
		serviceType.setVEHICLE_BRAND(request.getParameter("make"));

		HttpSession session = request.getSession();
		String emailId = (String) session.getAttribute("user");
		
		ServiceTypeDao dao = new ServiceTypeDaoImpl();
		message =  dao.verifyServiceId(serviceId,emailId,vehicleType);
		if(message.equals("no")){
			message = dao.addServicetype(serviceType,emailId);
		}
		if(vehicleType.equals("carServiceType.jsp")){
			jspPage = "./carServiceType.jsp";
		}else{
			jspPage = "./bikeServiceType.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(jspPage);
		request.setAttribute("message", message);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
