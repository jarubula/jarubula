package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.model.UsedCar;
import com.vaahanmitra.service.GetUsedCarDetails;

/**
 * Servlet implementation class ShowCarDetails
 */
public class ShowCarDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCarDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String carId = request.getParameter("cid");
		
		GetUsedCarDetails carDetails = new GetUsedCarDetails();
		UsedCar car = carDetails.getUsedCarDetails(carId);
		
		RequestDispatcher rd = request.getRequestDispatcher("./showCarDetails.jsp");
		request.setAttribute("car", car);
		request.setAttribute("carId", carId);
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
