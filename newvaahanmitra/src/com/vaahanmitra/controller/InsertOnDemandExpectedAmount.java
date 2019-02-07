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
 * Servlet implementation class InsertOnDemandExpectedAmount
 */
public class InsertOnDemandExpectedAmount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertOnDemandExpectedAmount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		

		HttpSession userId=request.getSession(false);
		String userId1=(String)userId.getAttribute("user");
		
		String expCharges=request.getParameter("expCharges");
		String waitingCharges=request.getParameter("waitingCharges");
		
		DriverDAO sdao=new DriverDAOImpl();
		String message=sdao.insertOndemandAmount(expCharges, waitingCharges, userId1);
		RequestDispatcher rd=null;
		if(message!=null){
		rd=request.getRequestDispatcher("./driverExpSalMsg.jsp");
		request.setAttribute("message", message);
		rd.forward(request, response);
		}else{
			String message1="Amount is already existed,if you want to update Amount then please enter in Update Amount..";
			rd=request.getRequestDispatcher("./onDemandExpectedAmount.jsp");
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
