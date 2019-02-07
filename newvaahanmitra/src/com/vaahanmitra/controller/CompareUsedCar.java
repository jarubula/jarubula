package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.CarDAO;
import com.vaahanmitra.daoImpl.CarDAOImpl;
import com.vaahanmitra.model.UsedCar;

/**
 * Servlet implementation class CompareUsedCar
 */
public class CompareUsedCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompareUsedCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String[] carId1=request.getParameterValues("compare");	
		String compare=null;
		ArrayList list=new ArrayList();
		for(String var:carId1){
			compare=var;
		}
		System.out.println(compare);
		
		String[] carId2=compare.split(",");
		for(String var1:carId2){
			list.add(var1);
		}
		CarDAO cdao=new CarDAOImpl();
		ArrayList<UsedCar> compareCar=cdao.compareUsedCar(list);
		RequestDispatcher rd=request.getRequestDispatcher("./compareUsedCar.jsp");
		request.setAttribute("compareCarDetails", compareCar);
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
