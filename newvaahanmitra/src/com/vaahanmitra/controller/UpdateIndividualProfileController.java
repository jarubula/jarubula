package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.IndividualOwnerRegisterDao;
import com.vaahanmitra.daoImpl.IndividualOwnerRegisterDaoImpl;
import com.vaahanmitra.exception.IndividualOwnerException;
import com.vaahanmitra.model.IndividualOwnerRegister;

/**
 * Servlet implementation class UpdateIndividualProfileController
 */
public class UpdateIndividualProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateIndividualProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = null;
		IndividualOwnerRegister registration = new IndividualOwnerRegister();

		registration.setNAME(request.getParameter("name"));
		registration.setPANCARD_NO(request.getParameter("pancardNo").toUpperCase());
		registration.setMOBILE_NO(request.getParameter("phoneNo"));
		registration.setCITY(request.getParameter("city"));
		registration.setPINCODE_NO(request.getParameter("pinNo"));
		
//		String vehicles="";
//		String vehicleType[]=request.getParameterValues("vehicleType");
//		for(int i=0;i<vehicleType.length;i++){
//			vehicles+=vehicleType[i]+" , ";
//		}
//		registration.setVEHICAL_TYPE(vehicles);
		registration.setEMAIL_ID(request.getParameter("email"));
		
		HttpSession session = request.getSession(false);
		String user_name = (String) session.getAttribute("user");
		
		IndividualOwnerRegisterDao dao = new IndividualOwnerRegisterDaoImpl();
		String message=null;
		try {
			message = dao.updateProfile(user_name,registration);
		} catch (IndividualOwnerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(message.equals("success"))
		{
			message = "YOUR PROFILE UPDATED SUCCESSFULLY...";
			page = "./updateIndividualProfile.jsp";
		} else {
			message = "PROFILE NOT UPDATED! PLEASE TRY AGAIN!";
			page="./updateIndividualProfile.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		request.setAttribute("success", message);
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
