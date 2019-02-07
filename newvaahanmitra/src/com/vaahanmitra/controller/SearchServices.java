package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.ServiceTypeDao;
import com.vaahanmitra.daoImpl.ServiceTypeDaoImpl;
import com.vaahanmitra.model.ServiceType;

/**
 * Servlet implementation class SearchServices
 */
public class SearchServices extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchServices() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String jspPage = null;
		String serviceId = request.getParameter("serviceId");

		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("user");
		ServiceTypeDao dao = new ServiceTypeDaoImpl();
		ArrayList<ServiceType> services = dao.getServices(email, serviceId);
		String message = null;
		if (services.size() > 0) {
			message = "";
			jspPage = "./searchServices.jsp";
		} else {
			message = "No services found <a href='./serviceType.jsp'><u>add your Service </u></a>";
			jspPage = "./searchServices.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(jspPage);
		request.setAttribute("services", services);
		request.setAttribute("message", message);
		request.setAttribute("serviceId", serviceId);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
