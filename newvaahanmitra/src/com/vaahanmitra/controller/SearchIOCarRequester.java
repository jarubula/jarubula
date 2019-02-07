package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.UsedVehicleGetRequesterDao;
import com.vaahanmitra.daoImpl.UsedVehicleGetRequesterDaoImpl;
import com.vaahanmitra.model.UsedCar;

/**
 * Servlet implementation class SearchIOCarRequester
 */
public class SearchIOCarRequester extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIOCarRequester() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cr = request.getParameter("carRequester");
		String fdate = request.getParameter("fdate");
		String tdate = request.getParameter("tdate");
		String carId = request.getParameter("carId");
		
		HttpSession session = request.getSession(false);
		String user_name = (String) session.getAttribute("user");
		
		UsedVehicleGetRequesterDao dao = new UsedVehicleGetRequesterDaoImpl();
		ArrayList<UsedCar> uvgr= dao.searchCarRequester(fdate,tdate,carId,user_name);
		String page= null;

		if (cr != null && cr.equals("csc")) {
			page = "./searchSCCarRequester.jsp";
		}else if (cr != null && cr.equals("cio")) {
			page = "./searchIOCarRequester.jsp";
		}else if (cr !=null && cr.equals("cud")){
			page = "./searchUDCarRequester.jsp";
		}else if (cr !=null && cr.equals("csp")){
			page = "./searchSPCarRequester.jsp";
		}else if (cr !=null && cr.equals("cdr")){
			page = "./searchDRCarRequester.jsp";
		}
		request.setAttribute("carDetails", uvgr);
		RequestDispatcher rd=request.getRequestDispatcher(page);
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
