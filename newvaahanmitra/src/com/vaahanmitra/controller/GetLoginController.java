package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetLoginController
 */
public class GetLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setHeader("Cache-Control", "private,no-store,no-cache");
		String page = null, message = null;

		/*String emailId = request.getParameter("email");
		String password = request.getParameter("password");*/
		
		/*LoginDao dao = new LoginDaoImpl();
		message = dao.checkUserAndPwd(emailId, password);*/
		
		String emailId = request.getParameter("emailId");
		message = request.getParameter("message");
		
		HttpSession session = request.getSession();
		if (message.equals("no")){
			message ="Email Id Not registerd! Please Register...";
			page = "/login3.jsp";
		} else if(message.equals("PI")){
			message = "EMAIL ID not at verified! Please verify your Email for Login";
			page = "/login3.jsp";
		} else if(message.equals("yes")){
			message = "WELCOME TO VAAHANMITRA";
			session.setAttribute("user", emailId);
			page ="/index.jsp";
		} else if (message.equals("I")){
			message = "EMAIL ID Already Registered with US! Please verify your Email for Login";
			page = "/login3.jsp";
		} else if(message.equals("P")){
			message ="Password not correct! Please enter Correct...";
			page = "/login3.jsp";
		}else{
			page = "/login3.jsp";
		}
//		RequestDispatcher rd = request.getRequestDispatcher(page);
//		request.setAttribute("existemail", message);
//		rd.forward(request, response);
		
		response.sendRedirect(request.getContextPath()+page+"?existemail="+message);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
