package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.DriverDAO;
import com.vaahanmitra.daoImpl.DriverDAOImpl;
import com.vaahanmitra.model.OnDemandDriverRoutes;

/**
 * Servlet implementation class UpdateOnDemandDriverRoutes
 */
public class UpdateOnDemandDriverRoutes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOnDemandDriverRoutes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String status=request.getParameter("status");
		String id=request.getParameter("id");
		
		HttpSession driverSession=request.getSession();
		String userId=(String)driverSession.getAttribute("user");
		
		DriverDAO ddo=new DriverDAOImpl();
		String message=null;
		if(status!=null){
		message=ddo.updateOnDemandDriverRoutes(userId, status,id);
		}
		ArrayList<OnDemandDriverRoutes> driverDetails=ddo.getOnDemandDriverRoutes(userId);
		
		RequestDispatcher rd=request.getRequestDispatcher("./updateOnDemandDriverRoutes.jsp");
		request.setAttribute("driverRts", driverDetails);
		request.setAttribute("message", message);
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
