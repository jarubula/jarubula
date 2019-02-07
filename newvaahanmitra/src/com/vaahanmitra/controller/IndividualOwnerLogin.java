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

import com.vaahanmitra.dao.CarDAO;
import com.vaahanmitra.dao.LoginDao;
import com.vaahanmitra.daoImpl.CarDAOImpl;
import com.vaahanmitra.daoImpl.LoginDaoImpl;
import com.vaahanmitra.model.UsedCar;
import com.vaahanmitra.service.GetUsedCarDetails;

/**
 * Servlet implementation class IndividualOwnerLogin
 */
public class IndividualOwnerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndividualOwnerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String  message = null, jspPage = null;
		
		String emailId = request.getParameter("email");
		String password = request.getParameter("password");
		
		String carNumber = request.getParameter("carNumber");
		String vehicleType = request.getParameter("vehicleType");
		String demail = request.getParameter("demail");
		
		System.out.println(carNumber + vehicleType + demail);
		
		LoginDao dao = new LoginDaoImpl();
		message = dao.checkUserPwd(emailId, password);
		HttpSession session = request.getSession();
		if (message.equals("no")){
			message ="Email Id Not registerd! Please Register...";
		} else if(message.equals("PI")){
			message = "EMAIL ID not at verified! Please verify your Email for Login";
		} else if(message.equals("yes")){
			message = "WELCOME TO VAAHANMITRA";
			session.setAttribute("user", emailId);
		} else if (message.equals("I")){
			message = "EMAIL ID Already Registered with US! Please verify your Email for Login";
		} else if(message.equals("P")){
			message ="Password not correct! Please enter Correct...";
		}
		if(vehicleType.equals("4") && demail == null){
			jspPage = "./DisplayCarImage.jsp";
		}else if(vehicleType.equals("2") && demail == null){
			jspPage = "./displayBikeImage.jsp";
		}else if(vehicleType.equals("4") && demail!=null){
			jspPage = "./dealerCarImage.jsp";
		}else if(vehicleType.equals("2") && demail!=null){
			jspPage = "./dealerBikeImage.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(jspPage);
		request.setAttribute("carNumber",carNumber);
		request.setAttribute("message", message);
		request.setAttribute("demail", demail);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
