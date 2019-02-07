package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.SearchHUsedBikeDAO;
import com.vaahanmitra.daoImpl.SearchHUsedBikeDAOImpl;
import com.vaahanmitra.model.UsedBike;

/**
 * Servlet implementation class SearchBike
 */
public class SearchBike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBike() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String brand = request.getParameter("bb");
		String bikeId = request.getParameter("bid");
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("user");
		
		SearchHUsedBikeDAO dao=new SearchHUsedBikeDAOImpl();
		ArrayList<String> ceu = dao.getRequesters(email);
		
		ArrayList<UsedBike> bikeDetails = dao.searchUsedBike(brand);
		
		RequestDispatcher rd=request.getRequestDispatcher("./searchHUsedBike.jsp");
		request.setAttribute("bikeDetails", bikeDetails);
		request.setAttribute("bikerequest", ceu);
		request.setAttribute("bikeBrand", brand);
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
