package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.DriverDAO;
import com.vaahanmitra.daoImpl.DriverDAOImpl;

/**
 * Servlet implementation class UpdateDriverAvailability
 */
public class UpdateDriverAvailability extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDriverAvailability() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] str=request.getParameterValues("availability");
		HttpSession driverAvalSession=request.getSession(false);
		String userId=(String)driverAvalSession.getAttribute("userId");
		String state=request.getParameter("state");
		String dist=request.getParameter("dist");
		String permitType=request.getParameter("permitType");
		String range=request.getParameter("range");
		
		DriverDAO sdao=new DriverDAOImpl();
//		String message=sdao.updateDriverAvailability(str, userId);
		
		RequestDispatcher rd=request.getRequestDispatcher("./DriverAvailability");
//		request.setAttribute("message", message);
		request.setAttribute("state", state);
		request.setAttribute("dist", dist);
		request.setAttribute("permitType",permitType);
		request.setAttribute("range", range);
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
