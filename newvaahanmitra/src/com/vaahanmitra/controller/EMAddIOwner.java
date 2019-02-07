package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.EmployeeDao;
import com.vaahanmitra.dao.IndividualOwnerRegisterDao;
import com.vaahanmitra.daoImpl.EmployeeDaoImpl;
import com.vaahanmitra.daoImpl.IndividualOwnerRegisterDaoImpl;
import com.vaahanmitra.model.IndividualOwnerRegister;
import com.vaahanmitra.model.UserLogin;
import com.vaahanmitra.service.SendMail;

public class EMAddIOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page=null;
		IndividualOwnerRegister registration = new IndividualOwnerRegister();
		String userType = request.getParameter("usertype");
		registration.setUSER_TYPE(userType);
		registration.setPANCARD_NO(request.getParameter("pancard"));
		registration.setCITY(request.getParameter("city"));
		registration.setPINCODE_NO(request.getParameter("pincode"));
		
		String vehicles="";
		String vehicleType[]=request.getParameterValues("vehicleType");
		if(vehicleType!=null){
			for(int i=0;i<vehicleType.length;i++){
				vehicles+=vehicleType[i]+",";
				registration.setVEHICAL_TYPE(vehicles);
			}
		}else{
			registration.setVEHICAL_TYPE(vehicles);
		}
		
		registration.setNAME(request.getParameter("name"));
		registration.setMOBILE_NO(request.getParameter("mobileNo"));
		registration.setEMAIL_ID(request.getParameter("email"));
		/*registration.setPASSWORD(request.getParameter("password"));*/
		registration.setSTATUS("INACTIVE");
		UserLogin login = new UserLogin();
		login.setEMAIL_ID(request.getParameter("email"));
		/*login.setPASSWORD(request.getParameter("password"));*/
		login.setUSER_TYPE(userType);
		login.setSTATUS("INACTIVE");
		
		IndividualOwnerRegisterDao dao = new IndividualOwnerRegisterDaoImpl();
		String email = request.getParameter("email");
		HttpSession session = request.getSession(false);
		String user_name = (String) session.getAttribute("user");
		
		String message = dao.getEmail(email);
		if (message.equals("no"))
		{
			String url = "http://localhost:8080/Vaahanmitra1.0/resetPassword.jsp?eid="+email+"";/* status also update */
			String textMsg = "Thank you for registering  Please <a href='" + url + "'> verify your EMAIL ID</a>";
			message = dao.addOwner(registration, login);
			EmployeeDao edao = new EmployeeDaoImpl();
			String msg = edao.addService(user_name, email, userType);
			SendMail.send(email, textMsg);
			request.setAttribute("message", message);
		} else {
			request.setAttribute("message", message);
		}
		page ="./emAddIOwner.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
