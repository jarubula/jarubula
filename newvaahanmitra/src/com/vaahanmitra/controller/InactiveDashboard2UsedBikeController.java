package com.vaahanmitra.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.UsedBikeDao;
import com.vaahanmitra.daoImpl.UsedBikeDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InactiveDashboard2UsedBikeController
 */
public class InactiveDashboard2UsedBikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InactiveDashboard2UsedBikeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String[] active = request.getParameterValues("vehicle");
		System.out.println("controller"+active);
		
		HttpSession session = request.getSession(false);
		String user_name = (String)session.getAttribute("user");
		
		UsedBikeDao dao = new UsedBikeDaoImpl();
		/*String  message = dao.showStatus(bean, (page - 1) * maxrowsperpage, maxrowsperpage);
		if(message!=null)
		{
			System.out.println(message);
			RequestDispatcher rd=request.getRequestDispatcher("./showDashboard2UsedBikeList.jsp");
			request.setAttribute("success", message);
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("./showDashboard2UsedBikeList.jsp");
			request.setAttribute("success", message);
			rd.forward(request, response);
			out.println("No records found");
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
