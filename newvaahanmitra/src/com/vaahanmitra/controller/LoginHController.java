package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.MechanicDao;
import com.vaahanmitra.daoImpl.MechanicDaoImpl;

/**
 * Servlet implementation class LoginHController
 */
public class LoginHController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginHController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String userType=null;
		
		HttpSession requesterSession=request.getSession();
		String email=(String)requesterSession.getAttribute("user");
		
		MechanicDao mdao=new MechanicDaoImpl();
		List<String> list=mdao.LoginDetails(email);
		
		userType=list.get(2);
		
		RequestDispatcher rd=null;
		
		if(userType!=null && userType.equals("IO")){
			
			rd=request.getRequestDispatcher("./IndividualOwnerHome.jsp");
			
			rd.forward(request, response);
			
		}else if(userType!=null && userType.equals("UD")){
			
			rd=request.getRequestDispatcher("./right-side.jsp");
			
			rd.forward(request, response);
			
		}else if(userType!=null && userType.equals("SC")){
			
			rd=request.getRequestDispatcher("./serviceCenterHome.jsp");
			
			rd.forward(request, response);
			
		}else if(userType!=null && userType.equals("SP")){
			
			rd=request.getRequestDispatcher("./sparePartsLeftSide.jsp");
			
			rd.forward(request, response);
			
		}else if(userType!=null && userType.equals("DR")){
			
			rd=request.getRequestDispatcher("./driverDashboard.jsp");
			
			rd.forward(request, response);
			
		}else if(userType!=null && userType.equals("AD")){
			   
			   rd=request.getRequestDispatcher("./AdminHome.jsp");
			   
			   rd.forward(request, response);
		}else if(userType!=null && userType.equals("EM")){
			   
			   rd=request.getRequestDispatcher("./employeeDashboard.jsp");
			   
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
