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
 * Servlet implementation class UpdateDriverJobType
 */
public class UpdateDriverJobType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDriverJobType() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
String jobType=request.getParameter("jobType");
		
		System.out.println(jobType);
		
		HttpSession session=request.getSession();
		String userId=(String)session.getAttribute("user");
		
		DriverDAO ddo=new DriverDAOImpl();
		String message=ddo.updateDriverJobType(jobType, userId);
		
		RequestDispatcher rd=null;
		if(message!=null){
			
			if(jobType!=null && jobType.equals("Full Time")){
			
		rd=request.getRequestDispatcher("./dExpectedSal.jsp");
		
			}else if(jobType!=null && jobType.equals("On Demand")){
				
				rd=request.getRequestDispatcher("./onDemandExpectedAmount.jsp");
				
					}
		request.setAttribute("message", message);
		rd.forward(request, response);
		
		}else{
			
			String message1="some technical problem is there,please try once again..";
			rd=request.getRequestDispatcher("./updateDriverJobType.jsp");
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
