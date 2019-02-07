package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.UsedBikeDao;
import com.vaahanmitra.daoImpl.UsedBikeDaoImpl;
import com.vaahanmitra.model.UsedBike;

/**
 * Servlet implementation class InactiveUsedBike
 */
public class InactiveUsedBike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InactiveUsedBike() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bikeId = request.getParameter("vehicle");
		String status = request.getParameter("status");
		String brandid = request.getParameter("brandid");
		String bikeModel = request.getParameter("bikeModel");
		String city = request.getParameter("city");
		String ioBike = request.getParameter("inactive");
		
		HttpSession session = request.getSession(false);
		String user_name = (String)session.getAttribute("user");
		
		UsedBikeDao dao = new UsedBikeDaoImpl();
		
		String message = dao.showStatus(bikeId,status,user_name);
		if(message.equals("success") && status.equals("ACTIVE")){
			message = "BIKE INACTIVATED";
		}else{
			message = "BIKE ACTIVATED";
		}
		String jspPage=null;
		int page = 1;
		int maxrowsperpage = 5;
		int noofRecords = 0, numofpages = 0;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		ArrayList<UsedBike> bikeal = dao.showDetails(city, brandid, bikeModel, user_name,(page - 1) * maxrowsperpage, maxrowsperpage);
		noofRecords = dao.getNoOfRecords();
		if (noofRecords % maxrowsperpage > 0) {
			numofpages = (noofRecords / maxrowsperpage) + 1;
		} else {
			numofpages = noofRecords / maxrowsperpage;
		}
		System.out.println(brandid+bikeModel+city);
		if(bikeal.size()>0)
		{
			if(ioBike.equals("IO")){
				jspPage = "./showIndividualUsedBike.jsp";
			} else if(ioBike.equals("UD")){
				jspPage = "./showDashboard2UsedBikesList1.jsp";
			}else if(ioBike.equals("SC")){
				jspPage = "./showUsedBikesList1.jsp";
			}
			RequestDispatcher rd=request.getRequestDispatcher(jspPage);
			request.setAttribute("success", bikeal);
			request.setAttribute("noOfPages", numofpages);
			request.setAttribute("noofrecords", noofRecords);
			request.setAttribute("currentPage", page);
			request.setAttribute("maxrowsperpage", maxrowsperpage);
			request.setAttribute("brandid", brandid);
			request.setAttribute("page", page);
			request.setAttribute("bikeModel", bikeModel);
			request.setAttribute("city", city);
			request.setAttribute("message", message);
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
