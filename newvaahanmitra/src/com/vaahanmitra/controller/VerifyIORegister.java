package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.IndividualOwnerRegisterDao;
import com.vaahanmitra.daoImpl.IndividualOwnerRegisterDaoImpl;
import com.vaahanmitra.exception.IndividualOwnerException;

/**
 * Servlet implementation class VerifyIORegister
 */
public class VerifyIORegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyIORegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("eid");
		String userType = request.getParameter("ut");
		
		IndividualOwnerRegisterDao dao = new IndividualOwnerRegisterDaoImpl();	
		String message=null;
		try {
			message = dao.updateStatus(email,userType);
		} catch (IndividualOwnerException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("./login3.jsp");
		request.setAttribute("existemail", message);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
