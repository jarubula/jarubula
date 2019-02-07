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

/**
 * Servlet implementation class InsertServiceEndUserDetails
 */
public class InsertServiceEndUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServiceEndUserDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServiceMechanic serviceMechanic=new ServiceMechanic();
		ServiceEndUser serviceEndUser=new ServiceEndUser();
		serviceEndUser.setNAME(request.getParameter("name"));
		serviceEndUser.setMOBILE_NO(request.getParameter("mobileNo"));
		serviceEndUser.setVEHICLE_BRAND(request.getParameter("evehicleBrand"));
		serviceEndUser.setVEHICLE_TYPE(request.getParameter("vehicleType1"));
		serviceEndUser.setMODEL(request.getParameter("model"));
		serviceEndUser.setCAR_NO(request.getParameter("carNo"));
		serviceEndUser.setAPPOINTMENT_DATE(request.getParameter("date"));
		serviceEndUser.setSERVICE_CENTER(request.getParameter("emailId"));
		serviceEndUser.setPASSWORD(request.getParameter("psw"));
		
		String email=request.getParameter("email");
		HttpSession requesterSession=request.getSession();
		String userId=(String)requesterSession.getAttribute("user");
		
		if(userId!=null){
			email=userId;
		}
		serviceEndUser.setEMAIL(email);
		
		String vehicleType=request.getParameter("vehicleType");
		String vehicleBrand=request.getParameter("vehicleBrand");
		String city=request.getParameter("city");
		String street=request.getParameter("street");
		
		serviceMechanic.setSELECTED_VEHICLE_TYPE(vehicleType);
		serviceMechanic.setBRAND(vehicleBrand);
		serviceMechanic.setADDRESS(street);
		
		MechanicDao mdao=new MechanicDaoImpl();
		String message=null;
		if(userId==null){
			message=mdao.getLoginDetail(email, request.getParameter("psw"));
		}
		String status=mdao.getLoginDetails(email);

		if(status!=null && status.equals("ACTIVE") && message==null){
			requesterSession.setAttribute("user",email);
		}
		
		if(message==null || userId!=null){
			
		message=mdao.checkRegisteredDate(email, request.getParameter("carNo"),request.getParameter("emailId"));
		
		if(message==null){
			
			message=mdao.InsertServiceEndUser(serviceEndUser);
			
		}

		}

		int page = 1;		
		int maxrowsperpage=10;
		int noofRecords =0,numofpages=0;
			
		 if(request.getParameter("page") != null){
				page = Integer.parseInt(request.getParameter("page"));	
			}
		
		ArrayList mechanicDetails=mdao.searchHMechanic(serviceMechanic,city,(page-1)*maxrowsperpage, maxrowsperpage);
		
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
