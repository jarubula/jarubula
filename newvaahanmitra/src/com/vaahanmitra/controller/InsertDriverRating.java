package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.DriverDAO;
import com.vaahanmitra.daoImpl.DriverDAOImpl;
import com.vaahanmitra.model.DriverBean;
import com.vaahanmitra.service.SendEmailToUser;

/**
 * Servlet implementation class InsertDriverRating
 */
public class InsertDriverRating extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDriverRating() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String psw=request.getParameter("psw");
		String apptId=request.getParameter("apptId");
		String rate=request.getParameter("rate");
		
		HttpSession userSesson=request.getSession();
		String email1=(String)userSesson.getAttribute("user");
		if(email1!=null){
			email=email1;
		}
		
		String message=null;
		DriverDAO ddo=new DriverDAOImpl();
		List<String> loginDetails=ddo.getLoginDetails(email);
		
		if(email1==null && loginDetails.size()!=0 && !loginDetails.get(1).equals(request.getParameter("psw"))){
			
			message="Please enter correct password";
		}
		if(email1==null && loginDetails.size()!=0 && loginDetails.get(2).equals("INACTIVE")){
			
			message="only verified users are allowed to rate driver";
		}
		if(message==null){
			
		message=ddo.insertDriverRating(apptId, rate);
		}if(message==null){
			
			message="please enter correct appointment id";
			
		}else{
		
		SendEmailToUser sendEmail=new SendEmailToUser();
		sendEmail.driverRatingMail(email);
		}
		String fromCity=request.getParameter("fromCity");
		String toCity=request.getParameter("toCity");
		String date=request.getParameter("date");
		String time=request.getParameter("time");
		
		int page = 1;		
		int maxrowsperpage=10;
		int noofRecords =0,numofpages=0;
			
		 if(request.getParameter("page") != null){
				page = Integer.parseInt(request.getParameter("page"));	
			}
		
		ArrayList driverAl=ddo.searchHOnDemandDriver(fromCity, toCity, date,time,(page-1)*maxrowsperpage, maxrowsperpage);
		
		noofRecords=ddo.getNoOfRecords();
		if(noofRecords%maxrowsperpage>0){				
		numofpages=(noofRecords/maxrowsperpage)+1;
		}
		
		else{
			numofpages=noofRecords/maxrowsperpage;
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("./searchHOnDemandDriver.jsp");
		request.setAttribute("driverAl", driverAl);
		request.setAttribute("fromCity", fromCity);
		request.setAttribute("toCity", toCity);
		request.setAttribute("date", date);
		request.setAttribute("time", time);
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
