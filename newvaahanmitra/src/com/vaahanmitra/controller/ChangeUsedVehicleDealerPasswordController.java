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
 * Servlet implementation class ChangeUsedVehicleDealerPasswordController
 */
public class ChangeUsedVehicleDealerPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeUsedVehicleDealerPasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String oldpwd = request.getParameter("cpwd");
		String newpwd = request.getParameter("password1");
		String repwd = request.getParameter("password2");

		HttpSession session = request.getSession(false);
		String user_name = (String) session.getAttribute("user");
		
		boolean change = false;
		if (newpwd.equals(repwd)) {
			LoginDao dao = new LoginDaoImpl();
			change = dao.changePassword(oldpwd, newpwd, user_name);
			if(change == false){
				String message = "Current Password doesn't match, Please Enter Correct";
				RequestDispatcher rd = request.getRequestDispatcher("./changeUsedVehicleDealerPassword.jsp");
				request.setAttribute("success", message);
				rd.forward(request, response);
			}
		}else {
			String message = "New Password and Re-enter Password not match";
			RequestDispatcher rd = request.getRequestDispatcher("./changeUsedVehicleDealerPassword.jsp");
			request.setAttribute("success", message);
			rd.forward(request, response);
		}
		if (change == true) {
			String message = "Your Password Successfully Changed";
			RequestDispatcher rd = request.getRequestDispatcher("./changeUsedVehicleDealerPassword.jsp");
			request.setAttribute("success", message);
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
