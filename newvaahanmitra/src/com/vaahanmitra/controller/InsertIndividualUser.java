package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.CarDAO;
import com.vaahanmitra.dao.IndividualOwnerRegisterDao;
import com.vaahanmitra.daoImpl.CarDAOImpl;
import com.vaahanmitra.daoImpl.IndividualOwnerRegisterDaoImpl;
import com.vaahanmitra.model.CarEndUser;
import com.vaahanmitra.model.IndividualOwnerRegister;
import com.vaahanmitra.model.UserLogin;
import com.vaahanmitra.service.SendMail;

/**
 * Servlet implementation class InsertIndividualUser
 */
public class InsertIndividualUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertIndividualUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jsppage = null,message=null;
		CarEndUser endUser = new CarEndUser();
		endUser.setNAME(request.getParameter("name"));
		endUser.setEMAIL(request.getParameter("email"));
		endUser.setMOBILE_NO(request.getParameter("mobileNo"));
		endUser.setVEHICLE_TYPE(request.getParameter("vehicleType"));
		endUser.setPASSWORD(request.getParameter("password"));
		
		String carNumber = request.getParameter("carNumber");
		String carId = request.getParameter("carId");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobileNo = request.getParameter("mobileNo");
		String demail = request.getParameter("demail");
		
		IndividualOwnerRegister registration = new IndividualOwnerRegister();
		registration.setUSER_TYPE("IO");
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
		
		CarDAO cdao = new CarDAOImpl();
		

		IndividualOwnerRegisterDao dao = new IndividualOwnerRegisterDaoImpl();
		if (demail == null) {
			message = dao.checkEmailStatus(email, carId, mobileNo, name);
			if (message.equals("no")) {
				String url = "http://vaahanmitra.com/VerifyIndividualUserCar?cid=" + carId + "&eid=" + email+ "&mno=" + mobileNo + "&nm=" + name + "";
//				message = dao.addOwner(registration, login);
				message = cdao.insertEndUserDetails(endUser, carId);
				message = "Your request has been sent on CAR (" + carId + ")! Please verify your Email Id";
				String textMsg = "Thank you for Registring with Vaahanmitra! Please " + " <a href='" +url+ "'> verify your Email</a>";
				SendMail.send(email, textMsg);
			}
		}else{
			message = dao.checkDEmailStatus(email,demail,carId, mobileNo, name);
			if (message.equals("no")) {
				String url = "http://vaahanmitra.com/VerifyIndividualUserCar?cid=" + carId + "&eid=" + email+ "&mno=" + mobileNo + "&nm=" + name + "";
//				message = dao.addOwner(registration, login);
				message = cdao.insertEndUserDetails(endUser, carId);
				message = "Your request has been sent on CAR (" + carId + ")! Please verify your Email Id";
				String textMsg = "Thank you for Registering with Vaahanmitra! Please " + " <a href='" + url
						+ "'> verify your Email</a>";
				SendMail.send(email, textMsg);
			}
		}
		if (demail == null) {
			jsppage = "./DisplayCarImage.jsp";
		}else{
			jsppage = "./dealerCarImage.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(jsppage);
		request.setAttribute("message", message);
		request.setAttribute("carNumber", carNumber);
		request.setAttribute("demail", demail);
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
