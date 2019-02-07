package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.MechanicDao;
import com.vaahanmitra.daoImpl.MechanicDaoImpl;
import com.vaahanmitra.model.ServiceEndUser;

/**
 * Servlet implementation class UpdateServiceRating
 */
public class UpdateServiceRating extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServiceRating() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String vehicleNo=request.getParameter("vNo");
		String apptId=request.getParameter("apptId");
		String rate=request.getParameter("rate");
		
		ServiceEndUser serviceEndUser=new ServiceEndUser();
		serviceEndUser.setCAR_NO(vehicleNo);
		serviceEndUser.setAPPOINTMENT_ID(apptId);
		serviceEndUser.setRATING(rate);
		
		MechanicDao mdao=new MechanicDaoImpl();
		String message=mdao.updateServiceEndUserRate(serviceEndUser);
		String serviceCenter=mdao.getServiceCenterName(serviceEndUser);
		
		RequestDispatcher rd=request.getRequestDispatcher("./emailVerifiedMsg1.jsp");
		request.setAttribute("serviceCenter", serviceCenter);
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
