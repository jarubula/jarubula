package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.BusinessOwnerRegisterDao;
import com.vaahanmitra.dao.CarDAO;
import com.vaahanmitra.dao.IndividualOwnerRegisterDao;
import com.vaahanmitra.dao.LoginDao;
import com.vaahanmitra.dao.UsedCarDao;
import com.vaahanmitra.daoImpl.BusinessOwnerRegisterDaoImpl;
import com.vaahanmitra.daoImpl.CarDAOImpl;
import com.vaahanmitra.daoImpl.IndividualOwnerRegisterDaoImpl;
import com.vaahanmitra.daoImpl.LoginDaoImpl;
import com.vaahanmitra.daoImpl.UsedCarDaoImpl;
import com.vaahanmitra.exception.BusinessOwnerException;
import com.vaahanmitra.exception.IndividualOwnerException;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.CarEndUser;
import com.vaahanmitra.model.IndividualOwnerRegister;
import com.vaahanmitra.model.UsedCar;
import com.vaahanmitra.service.SendMail;

/**
 * Servlet implementation class SendCarRequest
 */
public class SendCarRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SendCarRequest() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = null, mobileNo=null,emailId=null,jspPage=null;
		String carNumber = request.getParameter("carNumber");
		String carId = request.getParameter("carId");
		
		String demail = request.getParameter("demail");
		
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("user");
		
		LoginDao login = new LoginDaoImpl();
		String userType = login.getUserType(email);
		if(userType.equals("IO")){
			IndividualOwnerRegisterDao ior = new IndividualOwnerRegisterDaoImpl();
			try {
				IndividualOwnerRegister ior1=new IndividualOwnerRegister();
				ior1 = ior.getDeatils(email);
				name = ior1.getNAME();
				mobileNo = ior1.getMOBILE_NO();
				emailId = ior1.getEMAIL_ID();
			} catch (IndividualOwnerException e) {
				e.printStackTrace();
			}
		}else if(userType.equals("SC") || userType.equals("UD")){
			BusinessOwnerRegisterDao bor = new BusinessOwnerRegisterDaoImpl();
			try {
				BusinessOwnerRegister bor1 = new BusinessOwnerRegister();
				bor1 = bor.getAddressDetails(email);
				name = bor1.getNAME();
				mobileNo = bor1.getMOBILE_NO();
				emailId = bor1.getEMAIL_ID();
			} catch (BusinessOwnerException e) {
				e.printStackTrace();
			}
		}
		
		CarEndUser endUser = new CarEndUser();
		endUser.setNAME(name);
		endUser.setEMAIL(email);
		endUser.setMOBILE_NO(mobileNo);
		endUser.setVEHICLE_TYPE("4");
		
		UsedCarDao dao = new UsedCarDaoImpl();
		UsedCar car = dao.getCarOwnerDetails(carId);
		
		String url = "http://vaahanmitra.com/showCarDetails.jsp?cid="+carId+"";

		String toMsg = "Buyer requested for this CAR ID<a href='" + url + "'> (" + carId + ")</a> <br>" + "Buyer Name :"
				+ name + " <br>" + "Mobile No  :" + mobileNo + " <br>" + "Email Id   :" + emailId + " ";
		String fromMsg = "You Requsted to this CAR  <a href='" + url + "'> (" + carId + ") </a> <br>" + "Seller Name :"
				+ car.getCAR_OWNER_NAME() + " <br>" + "Mobile No   :" + car.getMOBILE_NO() + " <br>" + "Email Id    :"
				+ car.getEMAIL_ID() + "";
		
		CarDAO cdao = new CarDAOImpl();
		String message = cdao.insertUserRequest(endUser, carId);
		SendMail.sendMail(car.getEMAIL_ID(), email, toMsg, fromMsg);
		if(demail!=null){
			jspPage = "./dealerCarImage.jsp";
		}else{
			jspPage ="./DisplayCarImage.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(jspPage);
		request.setAttribute("message", message);
		request.setAttribute("carNumber", carNumber);
		request.setAttribute("demail", demail);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
