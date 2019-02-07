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
import com.vaahanmitra.model.DriverEndUser;
import com.vaahanmitra.model.UserLogin;

/**
 * Servlet implementation class InsertDriverEndUser
 */
public class InsertDriverEndUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDriverEndUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		

		DriverEndUser driverEndUser=new DriverEndUser();
		driverEndUser.setNAME(request.getParameter("name"));
		driverEndUser.setMOBILE_NO(request.getParameter("mobileNo"));
		driverEndUser.setAPPOINTMENT_DATE(request.getParameter("apptDate"));
		driverEndUser.setAPPOINTMENT_TIME(request.getParameter("apptTime"));
		driverEndUser.setDRIVER_EMAIL(request.getParameter("driverMail"));
		driverEndUser.setADDRESS(request.getParameter("address"));
		driverEndUser.setDESTINATION(request.getParameter("destination"));
		driverEndUser.setDRIVER_CHARGES(request.getParameter("expCharges"));
		driverEndUser.setDRIVER_WAITING_CHARGES(request.getParameter("waitingCharges"));
		String email=request.getParameter("email");
		HttpSession userSession=request.getSession();
		String userEmail=(String)userSession.getAttribute("user");
		
		if(userEmail!=null){
			driverEndUser.setEMAIL(userEmail);
		}else{
			driverEndUser.setEMAIL(email);
		}
		
		
		UserLogin login=new UserLogin();
		login.setEMAIL_ID(email);
		login.setPASSWORD(request.getParameter("psw"));
//		login.setREFERENCE_ID(request.getParameter("avlId"));
		
		String message=null;
		DriverDAO ddo=new DriverDAOImpl();
		
		List<String> loginDetails=ddo.getLoginDetails(email);
		
		if(userEmail==null && loginDetails.size()!=0 && !loginDetails.get(1).equals(request.getParameter("psw"))){
			
			message="Please enter correct password";
		}
		
		
		if(userEmail==null && message==null && loginDetails.size()!=0 && loginDetails.get(2).equals("ACTIVE")){
			
			userSession.setAttribute("user", email);
			
		}
		
		
		if(message==null){
		message=ddo.InsertDriverEndUser(driverEndUser,login);
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
