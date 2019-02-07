package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.LoginDao;
import com.vaahanmitra.daoImpl.LoginDaoImpl;

/**
 * Servlet implementation class ResetPassword
 */
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = null;
		String email = request.getParameter("email");
		String password = request.getParameter("pwd1");
		LoginDao dao = new LoginDaoImpl();
		String message = dao.forgotPassword(email,password);
		if(message.equals("success"))
		{
			message = "Your Password Updated successfully!Login Here!";
			page = "./login3.jsp";
		}else{
			message = "Your Password not Updated! Try again!";
			page = "./resetPassword.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		request.setAttribute("existemail", message);
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
