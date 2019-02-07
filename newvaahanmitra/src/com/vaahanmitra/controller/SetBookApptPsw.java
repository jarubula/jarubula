package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.MechanicDao;
import com.vaahanmitra.daoImpl.MechanicDaoImpl;

/**
 * Servlet implementation class SetBookApptPsw
 */
public class SetBookApptPsw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetBookApptPsw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String psw1=request.getParameter("password");
		String psw2=request.getParameter("repassword");
		
		MechanicDao mdao=new MechanicDaoImpl();
		String message=mdao.getAndSetBookApptPsw(email, psw1);
		
		RequestDispatcher rd=null;
		
		if(message!=null){
			rd=request.getRequestDispatcher("./setBookAppointmentPSW.jsp");
			request.setAttribute("message", message);
			rd.forward(request, response);
		}else{
			System.out.println("ssss");
			String message1="your password is added successfully,please login here...";
			rd=request.getRequestDispatcher("./login3.jsp");
			request.setAttribute("existemail", message1);
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
