package com.vaahanmitra.controller;

import java.io.IOException;
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

/**
 * Servlet implementation class InactiveUsedCar
 */
public class InactiveUsedCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InactiveUsedCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String carId = request.getParameter("vehicle");
		String status = request.getParameter("status");
		String brandid = request.getParameter("brandid");
		String carModel = request.getParameter("carModel");
		String city = request.getParameter("city");
		String ioCar = request.getParameter("inactive");
		
		HttpSession session = request.getSession(false);
		String user_name = (String)session.getAttribute("user");
		
		UsedCarDao dao = new UsedCarDaoImpl();
		
		String message = dao.showStatus(carId,status,user_name);
		if(message.equals("success") && status.equals("ACTIVE")){
			message = "Your Car ("+carId+") inactivated.";
		}else{
			message = "Your Car ("+carId+") activated";
		}
		
		String jspPage=null;
		int page = 1;
		int maxrowsperpage = 5;
		int noofRecords = 0, numofpages = 0;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		ArrayList<UsedCar> caral = dao.showDetails(city, brandid, carModel, user_name,(page - 1) * maxrowsperpage, maxrowsperpage);
		noofRecords = dao.getNoOfRecords();
		if (noofRecords % maxrowsperpage > 0) {
			numofpages = (noofRecords / maxrowsperpage) + 1;
		} else {
			numofpages = noofRecords / maxrowsperpage;
		}
		if(caral.size()>0)
		{
			if(ioCar.equals("IO")){
				jspPage = "./showIndividualUsedCar.jsp";
			} else if(ioCar.equals("SC")){
				jspPage = "./showUsedCarsList1.jsp";
			} else if(ioCar.equals("UD")){
				jspPage = "./showDashboard2UsedCarsList1.jsp";
			}
			RequestDispatcher rd=request.getRequestDispatcher(jspPage);
			request.setAttribute("success", caral);
			request.setAttribute("noOfPages", numofpages);
			request.setAttribute("noofrecords", noofRecords);
			request.setAttribute("currentPage", page);
			request.setAttribute("maxrowsperpage", maxrowsperpage);
			request.setAttribute("brandid", brandid);
			request.setAttribute("page", page);
			request.setAttribute("carModel", carModel);
			request.setAttribute("city", city);
			request.setAttribute("popUpMessage", message);
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
