package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.LoginDao;
import com.vaahanmitra.daoImpl.LoginDaoImpl;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*String page = null, message = null;

		String emailId = request.getParameter("email");
		String password = request.getParameter("password");
		
		LoginDao dao = new LoginDaoImpl();
		message = dao.checkUserAndPwd(emailId, password);
		HttpSession session = request.getSession();
		if (message.equals("no")){
			message ="Email Id Not registerd! Please Register...";
			page = "./login3.jsp";
		} else if(message.equals("PI")){
			message = "EMAIL ID not at verified! Please verify your Email for Login";
			page = "./login3.jsp";
		} else if(message.equals("yes")){
			message = "WELCOME TO VAAHANMITRA";
			session.setAttribute("user", emailId);
			page ="./index.jsp";
		} else if (message.equals("I")){
			message = "EMAIL ID Already Registered with US! Please verify your Email for Login";
			page = "./login3.jsp";
		} else if(message.equals("P")){
			message ="Password not correct! Please enter Correct...";
			page = "./login3.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		request.setAttribute("existemail", message);
		rd.forward(request, response);*/
		String page = null, message = null;

		String emailId = request.getParameter("email");
		String password = request.getParameter("password");
		
		LoginDao dao = new LoginDaoImpl();
		message = dao.checkUserAndPwd(emailId, password);
		response.sendRedirect(request.getContextPath()+"/GetLoginController?message="+message+"&emailId="+emailId);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
