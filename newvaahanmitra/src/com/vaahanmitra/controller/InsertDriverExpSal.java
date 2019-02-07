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
import com.vaahanmitra.model.InsertDriverPreRtsAndSal;

/**
 * Servlet implementation class InsertDriverExpSal
 */
public class InsertDriverExpSal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDriverExpSal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InsertDriverPreRtsAndSal driverSal=new InsertDriverPreRtsAndSal();
		HttpSession userId=request.getSession(false);
		String userId1=(String)userId.getAttribute("user");
		
		driverSal.setDEXPECTED_SAL(request.getParameter("sal"));
		driverSal.setDR_USER_ID(userId1);
		
		DriverDAO sdao=new DriverDAOImpl();
		String message=sdao.InsertExpctedSal(driverSal);
		RequestDispatcher rd=null;
		if(message!=null){
		rd=request.getRequestDispatcher("./driverExpSalMsg.jsp");
		request.setAttribute("message", message);
		rd.forward(request, response);
		}else{
			String message1="Salary is already existed..";
			rd=request.getRequestDispatcher("./dExpectedSal.jsp");
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
