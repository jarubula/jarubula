package com.vaahanmitra.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.UsedCarDao;
import com.vaahanmitra.daoImpl.UsedCarDaoImpl;
import com.vaahanmitra.model.UsedCar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowUsedCarListController
 */
public class ShowUsedCarListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUsedCarListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String brandid = request.getParameter("brandid");
		String carModel = request.getParameter("carModel");
		String city = request.getParameter("city");
		
		int page = 1;
		int maxrowsperpage = 5;
		int noofRecords = 0, numofpages = 0;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		HttpSession session = request.getSession(false);
		String user_name = (String)session.getAttribute("user");
		UsedCarDao dao = new UsedCarDaoImpl();
		ArrayList<UsedCar> caral = dao.showDetails(city, brandid, carModel, user_name,(page - 1) * maxrowsperpage, maxrowsperpage);
		noofRecords = dao.getNoOfRecords();
		if (noofRecords % maxrowsperpage > 0) {
			numofpages = (noofRecords / maxrowsperpage) + 1;
		} else {
			numofpages = noofRecords / maxrowsperpage;
		}
		String message = null;
		if(caral.size()>0)
		{ 
			message = "CAR DETAILS";
			RequestDispatcher rd=request.getRequestDispatcher("./showUsedCarsList1.jsp");  
			request.setAttribute("success", caral);
			request.setAttribute("noOfPages", numofpages);
			request.setAttribute("noofrecords", noofRecords);
			request.setAttribute("currentPage", page);
			request.setAttribute("maxrowsperpage", maxrowsperpage);
			request.setAttribute("brandid", brandid);
			request.setAttribute("carModel", carModel);
			request.setAttribute("city", city);
			request.setAttribute("message", message);
			request.setAttribute("user_name", user_name);
			rd.forward(request, response);
		}
		else
		{
			message = "*** No cars found <a href='./addSCUsedCar.jsp'>add your CAR </a> for sale***";
			RequestDispatcher rd=request.getRequestDispatcher("./showUsedCarsList.jsp");
			request.setAttribute("success", message);
			request.setAttribute("brandid", brandid);
			request.setAttribute("carModel", carModel);
			request.setAttribute("city", city);
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
