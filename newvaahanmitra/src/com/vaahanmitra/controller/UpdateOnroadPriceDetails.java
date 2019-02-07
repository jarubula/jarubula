package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.AddCarDao;
import com.vaahanmitra.daoImpl.AddCarDaoImpl;

/**
 * Servlet implementation class UpdateOnroadPriceDetails
 */
public class UpdateOnroadPriceDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOnroadPriceDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String price = request.getParameter("price");
		String seq_id          = request.getParameter("seq_id");
		String item           = request.getParameter("item");
		String vch_id           = request.getParameter("vch_id");  
		
		AddCarDao  dao = new AddCarDaoImpl();

	  String message= dao.updatePrice(seq_id, price, item,vch_id);
	  RequestDispatcher requestDispatcher=request.getRequestDispatcher("./sucessmessagejsp.jsp");
	  request.setAttribute("seq_id", seq_id);
	  request.setAttribute("message", message);
	  requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
