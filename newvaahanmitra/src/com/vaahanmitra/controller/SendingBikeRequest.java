package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.BusinessOwnerRegisterDao;
import com.vaahanmitra.dao.IndividualOwnerRegisterDao;
import com.vaahanmitra.dao.LoginDao;
import com.vaahanmitra.dao.SearchHUsedBikeDAO;
import com.vaahanmitra.dao.UsedBikeDao;
import com.vaahanmitra.daoImpl.BusinessOwnerRegisterDaoImpl;
import com.vaahanmitra.daoImpl.IndividualOwnerRegisterDaoImpl;
import com.vaahanmitra.daoImpl.LoginDaoImpl;
import com.vaahanmitra.daoImpl.SearchHUsedBikeDAOImpl;
import com.vaahanmitra.daoImpl.UsedBikeDaoImpl;
import com.vaahanmitra.exception.BusinessOwnerException;
import com.vaahanmitra.exception.IndividualOwnerException;
import com.vaahanmitra.model.BikeEndUser;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.CarEndUser;
import com.vaahanmitra.model.IndividualOwnerRegister;
import com.vaahanmitra.model.UsedBike;
import com.vaahanmitra.service.SendMail;

/**
 * Servlet implementation class SendingBikeRequest
 */
public class SendingBikeRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SendingBikeRequest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = null, mobileNo=null,emailId=null,jspPage=null;
		String bikeNumber = request.getParameter("bikeNumber");
		String bikeId = request.getParameter("bikeId");
		
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
		BikeEndUser endUser = new BikeEndUser();
		endUser.setNAME(name);
		endUser.setEMAIL(email);
		endUser.setMOBILE_NO(mobileNo);
		endUser.setVEHICLE_TYPE("2");
		
		UsedBikeDao bdao = new UsedBikeDaoImpl();
		UsedBike bike = bdao.getBikeOwnerDetails(bikeId);
		String url = "http://vaahanmitra.com/showBikeDetails.jsp?bid="+bikeId+"";

		String toMsg = "Buyer requested for this BIKE ID<a href='" + url + "'> (" + bikeId + ")</a> <br>"
				+ "Buyer Name :" + name + " <br>" + "Mobile No  :" + mobileNo + " <br>" + "Email Id   :" + emailId
				+ " ";
		String fromMsg = "You Requsted to this BIKE  <a href='" + url + "'> (" + bikeId + ") </a> <br>"
				+ "Seller Name :" + bike.getBIKE_OWNER_NAME() + " <br>" + "Mobile No   :" + bike.getMOBILE_NO()
				+ " <br>" + "Email Id    :" + bike.getEMAIL_ID() + "";
		
		SearchHUsedBikeDAO dao = new SearchHUsedBikeDAOImpl();
		String message = dao.insertUserRequest(endUser, bikeId);
		SendMail.sendMail(bike.getEMAIL_ID(), email, toMsg, fromMsg);
		if(demail!=null){
			jspPage = "./dealerBikeImage.jsp";
		}else{
			jspPage ="./displayBikeImage.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(jspPage);
		request.setAttribute("message", message);
		request.setAttribute("carNumber", bikeNumber);
		request.setAttribute("demail", demail);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
