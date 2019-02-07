package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.MechanicDao;
import com.vaahanmitra.daoImpl.MechanicDaoImpl;
import com.vaahanmitra.model.ServiceEndUser;
import com.vaahanmitra.model.ServiceMechanic;
import com.vaahanmitra.service.SendEmailToUser;

/**
 * Servlet implementation class InsertServiceRating
 */
public class InsertServiceRating extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServiceRating() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServiceEndUser serviceEndUser=new ServiceEndUser();
		serviceEndUser.setCAR_NO(request.getParameter("vehicleNo"));
		serviceEndUser.setRATING(request.getParameter("rate"));
		serviceEndUser.setSERVICE_CENTER(request.getParameter("remailId"));
		serviceEndUser.setAPPOINTMENT_ID(request.getParameter("appId"));
		String email=request.getParameter("email");
		HttpSession requesterSession=request.getSession();
		String user=(String)requesterSession.getAttribute("user");
		
		if(user!=null){
			email=user;
		}
		serviceEndUser.setEMAIL(email);
		
		String password=request.getParameter("psw");
		
		ServiceMechanic mbean=new ServiceMechanic();
		String city=request.getParameter("city");
		String vehicleType=request.getParameter("vehicleType");
		String vehicleBrand=request.getParameter("vehicleBrand");
		String street=request.getParameter("street");
		mbean.setSELECTED_VEHICLE_TYPE(vehicleType);
		mbean.setBRAND(vehicleBrand);
		mbean.setADDRESS(street);
		
		String message=null;
		MechanicDao mdao=new MechanicDaoImpl();
		
		 message=mdao.getServiceEndUserDetails(serviceEndUser);
		 String status=mdao.getLoginDetails(email);
		 
		 if(message==null && user==null){
		 message=mdao.getLoginDetail(email, password);
		 }
		 
		 if(status==null){
			 
			 message="You are not verified your email so you are not allowed to rate service center";
			 
		 }
		 
		if(message==null && status!=null && status.equals("ACTIVE")){
			message=mdao.updateServiceEndUserRate(serviceEndUser);
			SendEmailToUser sendMail=new SendEmailToUser();
			sendMail.ratingMail(serviceEndUser);
		}
		int page = 1;		
		int maxrowsperpage=10;
		int noofRecords =0,numofpages=0;
			
		 if(request.getParameter("page") != null){
				page = Integer.parseInt(request.getParameter("page"));	
			}
		ArrayList mechanicDetails=mdao.searchHMechanic(mbean,city,(page-1)*maxrowsperpage, maxrowsperpage);
		noofRecords=mdao.getNoOfRecords();
		if(noofRecords%maxrowsperpage>0){				
		numofpages=(noofRecords/maxrowsperpage)+1;
		}
		
		else{
			numofpages=noofRecords/maxrowsperpage;
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("./searchHMechanic.jsp");
		request.setAttribute("mechanicDetails", mechanicDetails);
		request.setAttribute("city", city);
		request.setAttribute("vehicleType", vehicleType);
		request.setAttribute("vehicleBrand", vehicleBrand);
		request.setAttribute("street", street);
		request.setAttribute("message", message);
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
