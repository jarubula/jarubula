package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.IndividualOwnerRegisterDao;
import com.vaahanmitra.dao.SearchHUsedBikeDAO;
import com.vaahanmitra.daoImpl.IndividualOwnerRegisterDaoImpl;
import com.vaahanmitra.daoImpl.SearchHUsedBikeDAOImpl;
import com.vaahanmitra.model.BikeEndUser;
import com.vaahanmitra.model.IndividualOwnerRegister;
import com.vaahanmitra.model.UsedBike;
import com.vaahanmitra.model.UserLogin;
import com.vaahanmitra.service.SendMail;

/**
 * Servlet implementation class InsertBikeRequester
 */
public class InsertBikeRequester extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBikeRequester() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String jsppage = null,message=null;
		BikeEndUser endUser = new BikeEndUser();
		IndividualOwnerRegister registration = new IndividualOwnerRegister();
		
		UserLogin login = new UserLogin();
		String vehicleType=request.getParameter("vehicleType");
		endUser.setNAME(request.getParameter("name"));
		endUser.setEMAIL(request.getParameter("email"));
		endUser.setMOBILE_NO(request.getParameter("mobileNo"));
		endUser.setVEHICLE_TYPE(vehicleType);
		
		String demail = request.getParameter("demail");
		String bikeId = request.getParameter("bikeId");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobileNo = request.getParameter("mobileNo");

		registration.setNAME(request.getParameter("name"));
		registration.setMOBILE_NO(request.getParameter("mobileNo"));
		registration.setEMAIL_ID(request.getParameter("email"));
		registration.setPASSWORD(request.getParameter("password"));
		registration.setSTATUS("INACTIVE");
		registration.toString();
		login.setEMAIL_ID(request.getParameter("email"));
		login.setPASSWORD(request.getParameter("password"));
		login.setUSER_TYPE("IO");
		login.setSTATUS("INACTIVE");

		UsedBike bean = new UsedBike();
		String bikeBrand = request.getParameter("bikeBrand");
		String bikeVariant = request.getParameter("bikeVariant");
		String city = request.getParameter("city");
		String budget = request.getParameter("bikeBudget");
		String bikeModel = request.getParameter("bikeModel");
		// String sellerType = request.getParameter("sellerType");
		String bikeAge = request.getParameter("bikeAge");
		String color=request.getParameter("colors");
		String kms=request.getParameter("kms");
		String owners = request.getParameter("owners");
		String dname=request.getParameter("dealerName");
		String range=request.getParameter("lHPrice");
		bean.setPRICE(range);
		if (bikeAge == null) {
			bikeAge = "";
		}
		SearchHUsedBikeDAO bdao = new SearchHUsedBikeDAOImpl();
		IndividualOwnerRegisterDao dao = new IndividualOwnerRegisterDaoImpl();

		if (demail == null) {
			message = dao.getEmailStatus(email, bikeId, mobileNo, name);
			String url = "http://vaahanmitra.com/VerifyEmail?bid=" + bikeId + "&eid=" + email + "&mno="+ mobileNo + "&nm=" + name + "";
			if (message.equals("no")) {
				message = dao.addOwner(registration, login);
				message = bdao.insertEndUserDetails(endUser, bikeId);
				message = "Your request has been sent on BIKE (" + bikeId + ")! Please verify your Email Id";
				String textMsg = "Thank you for Registring... Please " + " <a href='" + url	+ "'> verify your EMAIL ID</a>";
				SendMail.send(email, textMsg);
			}
		} else {
			message = dao.checkDBEmailStatus(email,demail,bikeId, mobileNo, name);
			if (message.equals("no")) {
				String url = "http://vaahanmitra.com/VerifyDBEmail?bid=" + bikeId + "&eid=" + email+ "&mno=" + mobileNo + "&nm=" + name + "&de="+demail+"";
				message = dao.addOwner(registration, login);
				message = bdao.insertEndUserDetails(endUser, bikeId);
				message = "Your request has been sent on BIKE (" + bikeId + ")! Please verify your Email Id";
				String textMsg = "Thank you for Registering with Vaahanmitra! Please " + " <a href='" + url	+ "'> verify your Email</a>";
				SendMail.send(email, textMsg);
			}
		}
		
		bean.setEMAIL_ID(demail);
		bean.setREGISTERED_YEAR(bikeAge);
		// bean.setSELLER_TYPE(sellerType);
		bean.setBIKE_BRAND(bikeBrand);
		bean.setBIKE_MODEL(bikeModel);
		bean.setOFFER_PRICE(budget);
		bean.setVARIANT_NAME(bikeVariant);
		bean.setCITY(city);
		bean.setCOLOR(color);
		bean.setCURRENT_MILEAGE(kms);
		ArrayList<UsedBike> bikeDetails = null;
		if (owners != null && !owners.equals("null")) {
			bean.setNO_OF_OWNERS(Integer.parseInt(owners));
		}
		int page = 1;  
		  int maxrowsperpage=5;
		  int noofRecords =0,numofpages=0;
		   
		   if(request.getParameter("page") != null){
		    page = Integer.parseInt(request.getParameter("page")); 
		   }
		if (demail == null) {
			
			bikeDetails = bdao.searchHUsedBike(bean,(page-1)*maxrowsperpage, maxrowsperpage);
	  noofRecords=bdao.getNoOfRecords();
			  
			  if(noofRecords%maxrowsperpage>0){    
			  numofpages=(noofRecords/maxrowsperpage)+1;
			  }
			  
			  else{
			   numofpages=noofRecords/maxrowsperpage;
			  }
			jsppage = "./searchHUsedBike.jsp";
			request.setAttribute("bikeDetails", bikeDetails);
			request.setAttribute("message", message);
		} else {
			bikeDetails = bdao.searchHDealerUsedBike(bean,(page-1)*maxrowsperpage, maxrowsperpage);
			noofRecords=bdao.getNoOfRecords();
			  
			  if(noofRecords%maxrowsperpage>0){    
			  numofpages=(noofRecords/maxrowsperpage)+1;
			  }
			  
			  else{
			   numofpages=noofRecords/maxrowsperpage;
			  }
			jsppage = "./searchHDealerUsedBike.jsp";
			request.setAttribute("bikeDetails", bikeDetails);
			request.setAttribute("message", message);
		}
		RequestDispatcher rd = request.getRequestDispatcher(jsppage);
		request.setAttribute("bikeDetails", bikeDetails);
		request.setAttribute("city", city);
		request.setAttribute("bikeBrand", bikeBrand);
		request.setAttribute("budget", budget);
		request.setAttribute("bikeModel", bikeModel);
		request.setAttribute("bikeVariant", bikeVariant);
		request.setAttribute("bikeAge", bikeAge);
		request.setAttribute("color", color);
		request.setAttribute("kms", kms);
		request.setAttribute("owners", owners);
		request.setAttribute("email", demail);
		request.setAttribute("vehicleType", vehicleType);
		request.setAttribute("name", dname);
		request.setAttribute("range", range);
		request.setAttribute("noOfPages", numofpages);
		request.setAttribute("noofrecords", noofRecords);
		request.setAttribute("currentPage", page);
		request.setAttribute("maxrowsperpage", maxrowsperpage);
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
