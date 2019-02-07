package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.SearchHUsedBikeDAO;
import com.vaahanmitra.daoImpl.SearchHUsedBikeDAOImpl;
import com.vaahanmitra.model.UsedBike;

/**
 * Servlet implementation class CompareUsedBike
 */
public class CompareUsedBike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompareUsedBike() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] bikeId1=request.getParameterValues("compare");	
		String compare=null;
		ArrayList list=new ArrayList();
		for(String var:bikeId1){
			compare=var;
		}
		String[] bikeId2=compare.split(",");
		for(String var1:bikeId2){
			list.add(var1);
		}
		SearchHUsedBikeDAO bdao=new SearchHUsedBikeDAOImpl();
		ArrayList<UsedBike> compareBike=bdao.compareUsedBike(list);
		RequestDispatcher rd=request.getRequestDispatcher("./compareUsedBike.jsp");
		request.setAttribute("compareBikeDetails", compareBike);
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
