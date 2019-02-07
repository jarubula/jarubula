package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.LoginDao;
import com.vaahanmitra.dao.SearchHUsedBikeDAO;
import com.vaahanmitra.daoImpl.LoginDaoImpl;
import com.vaahanmitra.daoImpl.SearchHUsedBikeDAOImpl;
import com.vaahanmitra.model.UsedBike;

/**
 * Servlet implementation class IndividualBike
 */
public class IndividualBike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndividualBike() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String jsppage = null, message = null;

		String emailId = request.getParameter("email");
		String password = request.getParameter("password");

		UsedBike bean = new UsedBike();
		String bikeBrand = request.getParameter("bikeBrand");
		String city = request.getParameter("city");
		String budget = request.getParameter("bikeBudget");
		String bikeModel = request.getParameter("bikeModel");
		String bikeVarinat = request.getParameter("bike_Variant");
 		// String sellerType=request.getParameter("sellerType");
		String bikeAge = request.getParameter("bikeAge");
		String color = request.getParameter("colors");
		String kms = request.getParameter("kms");
		String owners = request.getParameter("owners");
		String range = request.getParameter("lHPrice");
		bean.setPRICE(range);

		if (bikeAge == null) {
			bikeAge = "";
		}
		bean.setREGISTERED_YEAR(bikeAge);
		// bean.setSELLER_TYPE(sellerType);
		bean.setBIKE_BRAND(bikeBrand);
		bean.setBIKE_MODEL(bikeModel);
		bean.setVARIANT_NAME(bikeVarinat);
		bean.setOFFER_PRICE(budget);
		bean.setCITY(city);
		bean.setCOLOR(color);
		bean.setCURRENT_MILEAGE(kms);

		if (owners != null) {
			bean.setNO_OF_OWNERS(Integer.parseInt(owners));
		}

		ArrayList<String> ceu = null;
		SearchHUsedBikeDAO bdao = new SearchHUsedBikeDAOImpl();
		if (emailId != null) {
			ceu = bdao.getRequesters(emailId);
		}
		int page = 1;
		int maxrowsperpage = 30;
		int noofRecords = 0, numofpages = 0;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		ArrayList<UsedBike> bikeDetails = bdao.searchHUsedBike(bean, (page - 1) * maxrowsperpage, maxrowsperpage);
		noofRecords = bdao.getNoOfRecords();

		if (noofRecords % maxrowsperpage > 0) {
			numofpages = (noofRecords / maxrowsperpage) + 1;
		}

		else {
			numofpages = noofRecords / maxrowsperpage;
		}

		LoginDao dao = new LoginDaoImpl();
		message = dao.checkUserPwd(emailId, password);
		HttpSession session = request.getSession();
		if (message.equals("no")) {
			message = "Email Id Not registerd! Please Register...";
		} else if (message.equals("PI")) {
			message = "EMAIL ID not at verified! Please verify your Email for Login";
		} else if (message.equals("yes")) {
			message = "WELCOME TO VAAHANMITRA";
			session.setAttribute("user", emailId);
		} else if (message.equals("I")) {
			message = "EMAIL ID Already Registered with US! Please verify your Email for Login";
		} else if (message.equals("P")) {
			message = "Password not correct! Please enter Correct...";
		}
		jsppage = "./searchHUsedBike.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(jsppage);
		request.setAttribute("message", message);
		request.setAttribute("bikeDetails", bikeDetails);
		request.setAttribute("bikerequest", ceu);
		request.setAttribute("noOfPages", numofpages);
		request.setAttribute("noofrecords", noofRecords);
		request.setAttribute("currentPage", page);
		request.setAttribute("maxrowsperpage", maxrowsperpage);
		request.setAttribute("city", city);
		request.setAttribute("bikeBrand", bikeBrand);
		request.setAttribute("bikeVariant", bikeVarinat);
		request.setAttribute("budget", budget);
		request.setAttribute("bikeModel", bikeModel);
		request.setAttribute("bikeAge", bikeAge);
		request.setAttribute("color", color);
		request.setAttribute("kms", kms);
		request.setAttribute("owners", owners);
		request.setAttribute("range", range);
		rd.forward(request, response);
	}

}
