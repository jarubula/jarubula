package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.BusinessOwnerRegisterDao;
import com.vaahanmitra.daoImpl.BusinessOwnerRegisterDaoImpl;
import com.vaahanmitra.exception.BusinessOwnerException;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.UserLogin;
import com.vaahanmitra.service.SendMail;

/**
 * Servlet implementation class BusinessOwnerRegisterController
 */

public class BusinessOwnerRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String page=null;
		BusinessOwnerRegister bregistration = new BusinessOwnerRegister();
		UserLogin login = new UserLogin();
		BusinessOwnerRegisterDao dao = new BusinessOwnerRegisterDaoImpl();
		
		bregistration.setSTATUS("ACTIVE");
		bregistration.setUSER_TYPE(request.getParameter("userType"));
		bregistration.setBUSINESS_NAME(request.getParameter("businessName"));
		bregistration.setPANCARD_NO("NA");
		bregistration.setGSTNO(request.getParameter("GSTNo"));
		bregistration.setCITY(request.getParameter("city"));
		bregistration.setPINCODE_NO(Integer.parseInt(request.getParameter("pinNo")));
		
		String vehicles="";
		String vehicleType[]=request.getParameterValues("vehicleType");
		if(vehicleType!=null){
			for(int i=0;i<vehicleType.length;i++){
				vehicles+=vehicleType[i]+",";
				bregistration.setVEHICLE_TYPE(vehicles);
			}	
		}else{
			bregistration.setVEHICLE_TYPE(vehicles);
		}
		bregistration.setVEHICLE_TYPE(vehicles);
		bregistration.setADDRESS(request.getParameter("address"));
		bregistration.setLOCATION(request.getParameter("location1"));
		bregistration.setB_CITY(request.getParameter("bcity"));
		bregistration.setSTATE(request.getParameter("state"));
		bregistration.setDISTRICT(request.getParameter("district"));
		bregistration.setOFFICE_PHONE_NO(request.getParameter("phoneNo"));
		bregistration.setOFFICE_PINCODE_NO(Integer.parseInt(request.getParameter("bpinNo")));

		bregistration.setNAME(request.getParameter("name"));
		bregistration.setMOBILE_NO(request.getParameter("mobileNo"));
		bregistration.setEMAIL_ID(request.getParameter("email"));
		bregistration.setPASSWORD(request.getParameter("password"));
		bregistration.setSTATUS("INACTIVE");
		bregistration.toString();

		login.setEMAIL_ID(request.getParameter("email"));
		login.setPASSWORD(request.getParameter("password"));
		login.setUSER_TYPE(request.getParameter("userType"));
		login.setSTATUS("INACTIVE");		
		
		String email = request.getParameter("email");
		System.out.println("email"+email);
		
		String message=null;;
		try {
			message = dao.getBusinessEmail(email);
		} catch (BusinessOwnerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (message.equals("no")) {
			
			String url = "http://vaahanmitra.com/VerifyIORegister?eid="+email+"&ut=UD";
			String textMsg = "Thank you for registering.  Please <a href='"+url+"'> verify your EMAIL ID</a>";
			try {
				message = dao.addBusinessOwner(bregistration, login);
			} catch (BusinessOwnerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SendMail.send(email, textMsg);
			page ="./userType.jsp";
			request.setAttribute("existemail", message);
		} else {
			page ="./userType.jsp";
			request.setAttribute("existemail", message);
		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		
		request.setAttribute("existemail", message);
		rd.forward(request, response);
		
	}
	
}
