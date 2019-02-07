package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.model.UsedBike;
import com.vaahanmitra.service.GetBikeBrands;

/**
 * Servlet implementation class ShowBikeDetails
 */
public class ShowBikeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBikeDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bikeId = request.getParameter("bid");
		GetBikeBrands bikeDetails = new GetBikeBrands();
		UsedBike bike = bikeDetails.getUsedBikeDetails(bikeId);
		
		RequestDispatcher rd = request.getRequestDispatcher("./showBikeDetails.jsp");
		request.setAttribute("bike", bike);
		request.setAttribute("bikeId", bikeId);
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
