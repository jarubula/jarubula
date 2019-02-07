package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.BusinessOwnerRegisterDao;
import com.vaahanmitra.daoImpl.BusinessOwnerRegisterDaoImpl;
import com.vaahanmitra.model.BusinessOwnerRegister;

/**
 * Servlet implementation class UpdateSpProfile
 */
public class UpdateSpProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSpProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BusinessOwnerRegister bor = new BusinessOwnerRegister();
		String page = null;
		bor.setPANCARD_NO(request.getParameter("pancard").toUpperCase());
		bor.setBUSINESS_NAME(request.getParameter("bName"));
		bor.setNAME(request.getParameter("name"));
		bor.setMOBILE_NO(request.getParameter("phoneNo"));
		bor.setEMAIL_ID(request.getParameter("email"));
		bor.setCITY(request.getParameter("city"));
		bor.setPINCODE_NO(Integer.parseInt(request.getParameter("pinNo")));
		bor.setADDRESS(request.getParameter("address"));
		bor.setB_CITY(request.getParameter("bcity"));
		bor.setSTATE(request.getParameter("state"));
		bor.setDISTRICT(request.getParameter("district"));
		bor.setOFFICE_PHONE_NO(request.getParameter("bphoneNo"));
		bor.setOFFICE_PINCODE_NO(Integer.parseInt(request.getParameter("bpinNo")));

		HttpSession session = request.getSession(false);
		String user_name = (String) session.getAttribute("user");

		BusinessOwnerRegisterDao dao = new BusinessOwnerRegisterDaoImpl();
		String message = dao.updateProfile(bor, user_name);
		if (message.equals("success")) {
			message = "YOUR PROFILE UPDATED SUCCESSFULLY...";
			page = "./updateSpProfile.jsp";
		} else {
			message ="PROFILE NOT UPDATED! PLEASE TRY AGAIN!";
			page = "./updateSpProfile.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		request.setAttribute("message", message);
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
