package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.DriverDAO;
import com.vaahanmitra.daoImpl.DriverDAOImpl;

/**
 * Servlet implementation class DriverChangePassword
 */
public class DriverChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String psw1=request.getParameter("psw1");
		String psw2=request.getParameter("psw2");
		String psw3=request.getParameter("psw3");
		
		HttpSession session= request.getSession(false);
		String userId=(String)session.getAttribute("user");
		
		DriverDAO sdao=new DriverDAOImpl();
		String message=sdao.driverChangePassword(psw1, psw2, psw3, userId);
		RequestDispatcher rd=null;
		if(message!=null){
			rd=request.getRequestDispatcher("./driverChangePsw.jsp");
			request.setAttribute("message", message);
			rd.forward(request, response);
		}else{
			String message1="Please Enter correct password...";
			rd=request.getRequestDispatcher("./driverChangePsw.jsp");
			request.setAttribute("message1", message1);
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
