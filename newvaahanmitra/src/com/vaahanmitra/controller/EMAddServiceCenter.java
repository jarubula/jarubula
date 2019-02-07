package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.BusinessOwnerRegisterDao;
import com.vaahanmitra.dao.EmployeeDao;
import com.vaahanmitra.daoImpl.BusinessOwnerRegisterDaoImpl;
import com.vaahanmitra.daoImpl.EmployeeDaoImpl;
import com.vaahanmitra.exception.BusinessOwnerException;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.EmployeeBean;
import com.vaahanmitra.model.UserLogin;
import com.vaahanmitra.service.SendMail;

/**
 * Servlet implementation class EMAddServiceCenter
 */
public class EMAddServiceCenter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EMAddServiceCenter() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String page = null, key = null;
		BusinessOwnerRegister bregistration = new BusinessOwnerRegister();
		key = request.getParameter("usertype");
		bregistration.setSTATUS("ACTIVE");
		bregistration.setUSER_TYPE(request.getParameter("usertype"));
		bregistration.setBUSINESS_NAME(request.getParameter("businessName"));
		bregistration.setPANCARD_NO(request.getParameter("pancardNo"));
		bregistration.setGSTNO(request.getParameter("GSTNo"));
		bregistration.setCITY(request.getParameter("city"));
		bregistration.setPINCODE_NO(Integer.parseInt(request.getParameter("pinNo")));

		String vehicles = "";
		String vehicleType[] = request.getParameterValues("vehicleType");
		if (vehicleType != null) {
			for (int i = 0; i < vehicleType.length; i++) {
				vehicles += vehicleType[i] + ",";
				bregistration.setVEHICLE_TYPE(vehicles);
			}
		} else {
			bregistration.setVEHICLE_TYPE(vehicles);
		}
		bregistration.setVEHICLE_TYPE(vehicles);
		bregistration.setADDRESS(request.getParameter("address"));
		bregistration.setLOCATION(request.getParameter("location"));
		bregistration.setB_CITY(request.getParameter("bcity"));
		bregistration.setSTATE(request.getParameter("state"));
		bregistration.setDISTRICT(request.getParameter("district"));
		bregistration.setOFFICE_PHONE_NO(request.getParameter("phoneNo"));
		bregistration.setOFFICE_PINCODE_NO(Integer.parseInt(request.getParameter("bpinNo")));

		bregistration.setNAME(request.getParameter("name"));
		bregistration.setMOBILE_NO(request.getParameter("mobileNo"));
		bregistration.setEMAIL_ID(request.getParameter("email"));
		/* bregistration.setPASSWORD(request.getParameter("password")); */
		bregistration.setSTATUS("INACTIVE");
		bregistration.toString();

		UserLogin login = new UserLogin();
		login.setEMAIL_ID(request.getParameter("email"));
		/* login.setPASSWORD(request.getParameter("password")); */
		String userType = request.getParameter("usertype");
		login.setUSER_TYPE(request.getParameter("usertype"));
		login.setSTATUS("INACTIVE");

		String email = request.getParameter("email");
		HttpSession session = request.getSession(false);
		String user_name = (String) session.getAttribute("user");
		String message = null;
		
		BusinessOwnerRegisterDao dao = new BusinessOwnerRegisterDaoImpl();
		try {
			message = dao.getBusinessEmail(email);
		} catch (BusinessOwnerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (message.equals("no")) {
			String url = "http://localhost:8080/Vaahanmitra1.0/resetPassword.jsp?eid="+email+"";/* status also update */
			String textMsg = "Thank you for registering  Please <a href='" + url + "'> verify your EMAIL ID</a>";
			try {
				message = dao.addBusinessOwner(bregistration, login);
				EmployeeDao edao = new EmployeeDaoImpl();
				String msg = edao.addService(user_name, email, userType);
			} catch (BusinessOwnerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SendMail.send(email, textMsg);
			request.setAttribute("message", message);
		} else {
			request.setAttribute("message", message);
		}
		if (key.equals("SC")) {
			page = "./emAddServiceCenter.jsp";
		} else if (key.equals("SP")) {
			page = "./emAddSparePartsShop.jsp";
		} else if (key.equals("UD")) {
			page = "./emAddDealer.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
