package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.DriverDAO;
import com.vaahanmitra.daoImpl.DriverDAOImpl;
import com.vaahanmitra.model.DriverBean;

/**
 * Servlet implementation class ViewDriverProfile
 */
public class ViewDriverProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDriverProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession(false);
		String userId=(String)session.getAttribute("user");
		
		DriverDAO sdao=new DriverDAOImpl();
		ArrayList<DriverBean> driverDetails=sdao.viewDriverProfile(userId);
		RequestDispatcher rd=request.getRequestDispatcher("./viewDriverProfile.jsp");
		request.setAttribute("driverDetails", driverDetails);
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
