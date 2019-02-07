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
 * Servlet implementation class ShowDashboard2UsedBikeListController
 */
public class SearchUDUsedBike extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String brandid = request.getParameter("brandid");
		String bikeModel = request.getParameter("bikeModel");
		String city = request.getParameter("city");
		
		String jspPage=null;
		int page = 1;
		int maxrowsperpage = 5;
		int noofRecords = 0, numofpages = 0;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		HttpSession session = request.getSession(false);
		String user_name = (String)session.getAttribute("user");
		UsedBikeDao dao = new UsedBikeDaoImpl();
		ArrayList<UsedBike> bikeal = dao.showDetails(city, brandid, bikeModel, user_name,(page - 1) * maxrowsperpage, maxrowsperpage);
		noofRecords = dao.getNoOfRecords();
		if (noofRecords % maxrowsperpage > 0) {
			numofpages = (noofRecords / maxrowsperpage) + 1;
		} else {
			numofpages = noofRecords / maxrowsperpage;
		}
		String message = null;
		if(bikeal.size()>0)
		{
			message= "BIKE DETAILS";
			jspPage="./showDashboard2UsedBikesList1.jsp";
			request.setAttribute("success", bikeal);
			request.setAttribute("noOfPages", numofpages);
			request.setAttribute("noofrecords", noofRecords);
			request.setAttribute("currentPage", page);
			request.setAttribute("maxrowsperpage", maxrowsperpage);
			request.setAttribute("brandid", brandid);
			request.setAttribute("bikeModel", bikeModel);
			request.setAttribute("city", city);
			request.setAttribute("message", message);
			request.setAttribute("user_name", user_name);
		}
		else
		{
			message = "*** No bikes found <a href='./addUDUsedBike.jsp'>add your BIKE </a> for sale***";
			jspPage = "./showDashboard2UsedBikeList.jsp";
			request.setAttribute("success", message);
			request.setAttribute("brandid", brandid);
			request.setAttribute("bikeModel", bikeModel);
			request.setAttribute("city", city);
		}
		RequestDispatcher rd=request.getRequestDispatcher(jspPage);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
