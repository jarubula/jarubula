package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.CarDAO;
import com.vaahanmitra.dao.LoginDao;
import com.vaahanmitra.dao.SearchHUsedBikeDAO;
import com.vaahanmitra.daoImpl.CarDAOImpl;
import com.vaahanmitra.daoImpl.LoginDaoImpl;
import com.vaahanmitra.daoImpl.SearchHUsedBikeDAOImpl;
import com.vaahanmitra.model.UsedBike;
import com.vaahanmitra.model.UsedCar;

public class DealerUsedBikeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DealerUsedBikeLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailId = request.getParameter("email");
		String password = request.getParameter("password");
		
		ArrayList<String> ceu =null;
		UsedBike bean = new UsedBike();
		String demail = request.getParameter("demail");
		String vehicleType = request.getParameter("vehicleType");
		String dealerName = request.getParameter("dealerName");
		
		String bikeBrand = request.getParameter("bikeBrand");
		String city = request.getParameter("city");
		String budget = request.getParameter("bikeBudget");
		String bikeModel = request.getParameter("bikeModel");
		// String sellerType=request.getParameter("sellerType");
		String bikeAge = request.getParameter("bikeAge");
		String color = request.getParameter("colors");
		String kms = request.getParameter("kms");
		String owners = request.getParameter("owners");
		String range = request.getParameter("lHPrice");

		if (bikeAge == null) {
			bikeAge = "";
		}
		bean.setPRICE(range);
		bean.setEMAIL_ID(demail);
		bean.setREGISTERED_YEAR(bikeAge);
		// bean.setSELLER_TYPE(sellerType);
		bean.setBIKE_BRAND(bikeBrand);
		bean.setBIKE_MODEL(bikeModel);
		bean.setOFFER_PRICE(budget);
		bean.setCITY(city);
		bean.setCOLOR(color);
		bean.setCURRENT_MILEAGE(kms);

		if (owners != null && !owners.equals("null")) {
			bean.setNO_OF_OWNERS(Integer.parseInt(owners));
		}

		SearchHUsedBikeDAO bdao = new SearchHUsedBikeDAOImpl();
		if (emailId != null) {
			ceu = bdao.getRequesters(emailId);
		}
		int page = 1;
		int maxrowsperpage = 5;
		int noofRecords = 0, numofpages = 0;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
//		ArrayList<String> ceu = dao.getRequesters(emailId);
//		ArrayList<UsedCar> carDetails = cdao.searchUsedCar(brand);
		String message = null;
		LoginDao ldao = new LoginDaoImpl();
		message = ldao.checkUserPwd(emailId, password);
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
		
		  ArrayList<UsedBike> bikeDetails = bdao.searchHDealerUsedBike(bean,(page-1)*maxrowsperpage, maxrowsperpage);
			noofRecords=bdao.getNoOfRecords();
			  
			  if(noofRecords%maxrowsperpage>0){    
			  numofpages=(noofRecords/maxrowsperpage)+1;
			  }
			  
			  else{
			   numofpages=noofRecords/maxrowsperpage;
			  }
		RequestDispatcher rd=request.getRequestDispatcher("./searchHDealerUsedBike.jsp");
		request.setAttribute("bikeDetails", bikeDetails);
		request.setAttribute("city", city);
		request.setAttribute("bikeBrand", bikeBrand);
		request.setAttribute("budget", budget);
		request.setAttribute("bikeModel", bikeModel);
		request.setAttribute("bikeAge", bikeAge);
		request.setAttribute("color", color);
		request.setAttribute("kms", kms);
		request.setAttribute("owners", owners);
		request.setAttribute("range", range);
		request.setAttribute("vehicleType", vehicleType);
		request.setAttribute("email", demail);
		request.setAttribute("name", dealerName);
		request.setAttribute("noOfPages", numofpages);
		request.setAttribute("noofrecords", noofRecords);
		request.setAttribute("currentPage", page);
		request.setAttribute("maxrowsperpage", maxrowsperpage);
		request.setAttribute("message", message);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
