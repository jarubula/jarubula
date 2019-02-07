package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.MechanicDao;
import com.vaahanmitra.daoImpl.MechanicDaoImpl;
import com.vaahanmitra.model.AddMechanic;

/**
 * Servlet implementation class MechanicController
 */
public class MechanicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MechanicController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AddMechanic addMechanic = new AddMechanic(); 
		addMechanic.setFIRST_NAME(request.getParameter("fname"));
		addMechanic.setLAST_NAME(request.getParameter("lname"));
		addMechanic.setBUSINESS_NAME(request.getParameter("bName"));
		addMechanic.setPANCARD_NO(request.getParameter("panno"));
		addMechanic.setEMAIL_ID(request.getParameter("emailId"));
		addMechanic.setPHONE_NO(request.getParameter("phoneNo"));
		addMechanic.setADDRESS(request.getParameter("contactAddress"));
		addMechanic.setCITY(request.getParameter("city"));
		addMechanic.setSTATE(request.getParameter("state"));
		addMechanic.setDISTRICT(request.getParameter("district"));
		addMechanic.setPINCODE_NO(request.getParameter("pinNo"));
		addMechanic.setBUSI_ADDRESS(request.getParameter("businessAddress"));
		addMechanic.setBUSI_CITY(request.getParameter("bcity"));
		addMechanic.setBUSI_STATE(request.getParameter("state1"));
		addMechanic.setBUSI_DISTRICT(request.getParameter("district1"));
		addMechanic.setOFFICE_NO(request.getParameter("bPhoneNo"));
		addMechanic.setBPINCODE_NO(request.getParameter("bpincodeNo"));
		addMechanic.toString();
		
		MechanicDao dao = new MechanicDaoImpl();
		String message = dao.addMechanic(addMechanic);
		RequestDispatcher rd=request.getRequestDispatcher("./successServiceMechanicProfile.jsp");
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
