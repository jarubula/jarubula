package com.vaahanmitra.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.MechanicDao;
import com.vaahanmitra.daoImpl.MechanicDaoImpl;
import com.vaahanmitra.model.ServiceEndUser;

/**
 * Servlet implementation class BookAppointmentEmailVerification
 */
public class BookAppointmentEmailVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAppointmentEmailVerification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("email");
		String apptId=request.getParameter("id");

		MechanicDao mdao=new MechanicDaoImpl();
		String message=mdao.verifyBookApptEmail(email);
		if(message!=null){
			
			HttpSession sverifiedSession=request.getSession();
			
			sverifiedSession.setAttribute("user", email);
			
		}
		
		ArrayList<ServiceEndUser> serviceCenter=mdao.getVerifiedDetails(apptId);
		
		RequestDispatcher rd=request.getRequestDispatcher("./emailVerifiedMsg.jsp");
		request.setAttribute("verifiedDetails", serviceCenter);
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
