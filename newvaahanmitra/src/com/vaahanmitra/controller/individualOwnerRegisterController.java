package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.IndividualOwnerRegisterDao;
import com.vaahanmitra.daoImpl.IndividualOwnerRegisterDaoImpl;
import com.vaahanmitra.model.IndividualOwnerRegister;
import com.vaahanmitra.model.UserLogin;
import com.vaahanmitra.service.SendMail;

public class individualOwnerRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public individualOwnerRegisterController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ownertype = request.getParameter("type");
		if (ownertype.equals("individual"))
		{
			String page=null;
			IndividualOwnerRegister registration = new IndividualOwnerRegister();

			registration.setUSER_TYPE("IO");
			registration.setPANCARD_NO(request.getParameter("panno"));
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
			registration.setPASSWORD(request.getParameter("password"));
			registration.setSTATUS("INACTIVE");
			registration.toString();
			UserLogin login = new UserLogin();
			login.setEMAIL_ID(request.getParameter("email"));
			login.setPASSWORD(request.getParameter("password"));
			login.setUSER_TYPE("IO");
			login.setSTATUS("INACTIVE");
			
			IndividualOwnerRegisterDao dao = new IndividualOwnerRegisterDaoImpl();
			String email = request.getParameter("email");
			
			String message = dao.getEmail(email);
			if (message.equals("no"))
			{
				String url = "http://vaahanmitra.com/VerifyIORegister?eid="+email+"&ut=IO";
				String textMsg = "Thank you for registering  Please <a href='"+url+"'> verify your EMAIL ID</a>";
				message = dao.addOwner(registration, login);
				SendMail.send(email, textMsg);
				page ="./register.jsp";
				request.setAttribute("existemail", message);
			} else {
				page ="./register.jsp";
				request.setAttribute("existemail", message);
			}
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			}
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
