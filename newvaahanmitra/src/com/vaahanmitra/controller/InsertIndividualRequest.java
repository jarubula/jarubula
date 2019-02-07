package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.CarDAO;
import com.vaahanmitra.dao.IndividualOwnerRegisterDao;
import com.vaahanmitra.dao.SearchHUsedBikeDAO;
import com.vaahanmitra.daoImpl.CarDAOImpl;
import com.vaahanmitra.daoImpl.IndividualOwnerRegisterDaoImpl;
import com.vaahanmitra.daoImpl.SearchHUsedBikeDAOImpl;
import com.vaahanmitra.model.BikeEndUser;
import com.vaahanmitra.model.IndividualOwnerRegister;
import com.vaahanmitra.model.UserLogin;
import com.vaahanmitra.service.SendMail;

/**
 * Servlet implementation class InsertIndividualRequest
 */
public class InsertIndividualRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertIndividualRequest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jsppage = null,message=null;
		BikeEndUser endUser = new BikeEndUser();
		endUser.setNAME(request.getParameter("name"));
		endUser.setEMAIL(request.getParameter("email"));
		endUser.setMOBILE_NO(request.getParameter("mobileNo"));
		endUser.setVEHICLE_TYPE(request.getParameter("vehicleType"));
		
		String bikeNumber = request.getParameter("bikeNumber");
		String bikeId = request.getParameter("bikeId");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobileNo = request.getParameter("mobileNo");
		String demail = request.getParameter("demail");
		
		IndividualOwnerRegister registration = new IndividualOwnerRegister();
		registration.setUSER_TYPE("IO");
		registration.setNAME(request.getParameter("name"));
		registration.setMOBILE_NO(request.getParameter("mobileNo"));
		registration.setEMAIL_ID(request.getParameter("email"));
		registration.setSTATUS("INACTIVE");
		
		UserLogin login = new UserLogin();
		login.setEMAIL_ID(request.getParameter("email"));
		login.setPASSWORD(request.getParameter("password"));
		login.setUSER_TYPE("IO");
		login.setSTATUS("INACTIVE");
		
		SearchHUsedBikeDAO bdao = new SearchHUsedBikeDAOImpl();
		IndividualOwnerRegisterDao dao = new IndividualOwnerRegisterDaoImpl();
		
		if (demail == null) {
			message = dao.getEmailStatus(email, bikeId, mobileNo, name);
			String url = "http://vaahanmitra.com/VerifyIndividualUserBike?bid=" + bikeId + "&eid=" + email + "&mno="+ mobileNo + "&nm=" + name+"";
			if (message.equals("no")) {
				message = dao.addOwner(registration, login);
				message = bdao.insertEndUserDetails(endUser, bikeId);
				message = "Your request has been sent on BIKE (" + bikeId + ")! Please verify your Email Id";
				String textMsg = "Thank you for Registering with Vaahanmitra! Please " + " <a href='" + url	+ "'> verify your EMAIL ID</a>";
				SendMail.send(email, textMsg);
			}
		} else {
			message = dao.checkDBEmailStatus(email,demail,bikeId, mobileNo, name);
			if (message.equals("no")) {
				String url = "http://vaahanmitra.com/VerifyIndividualUserBike?bid=" + bikeId + "&eid=" + email+ "&mno=" + mobileNo + "&nm=" + name + "";
				message = dao.addOwner(registration, login);
				message = bdao.insertEndUserDetails(endUser, bikeId);
				message = "Your request has been sent on BIKE (" + bikeId + ")! Please verify your Email Id";
				String textMsg = "Thank you for Registering with Vaahanmitra! Please " + " <a href='" + url	+ "'> verify your Email</a>";
				SendMail.send(email, textMsg);
			}
		}
		if (demail == null) {
			jsppage = "./displayBikeImage.jsp";
		}else{
			jsppage = "./dealerBikeImage.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(jsppage);
		request.setAttribute("message", message);
		request.setAttribute("carNumber", bikeNumber);
		request.setAttribute("demail", demail);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
