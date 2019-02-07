package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.RegistrationDao;
import com.vaahanmitra.daoImpl.RegistrationDaoImpl;
import com.vaahanmitra.model.Registration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationController
 */
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Registration registration = new Registration();
		registration.setFIRST_NAME(request.getParameter("firstName"));
		registration.setLAST_NAME(request.getParameter("lastName"));
		registration.setGENDER(request.getParameter("gender"));
		registration.setEMAIL(request.getParameter("emailId"));
		registration.setPHONE_NO(request.getParameter("phoneNo"));
		registration.setPANCARD_NO(request.getParameter("panno"));
		registration.setADDRESS(request.getParameter("address"));
		registration.setCITY(request.getParameter("city"));
		registration.setSTATE(request.getParameter("country"));
		registration.setDISTRICT(request.getParameter("state"));
		registration.setPASSWORD(request.getParameter("password"));
		registration.toString();
		
		String gender =	request.getParameter("gender");
		System.out.println(gender+"Gender");
		
		RegistrationDao dao=new RegistrationDaoImpl();
		String email = request.getParameter("emailId");
	
		boolean existEmail  = dao.retriveEmail(email);
		
		if(existEmail==true)
		{
			String msg = " Emaild already registered "; 
			RequestDispatcher rd=request.getRequestDispatcher("./registration.jsp");
			request.setAttribute("existemail", msg);
			rd.forward(request, response);
		}else{
			String message = dao.addUser(registration); 
			RequestDispatcher rd=request.getRequestDispatcher("./login2.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
