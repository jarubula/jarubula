package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.AddBikeDao;
import com.vaahanmitra.dao.AddCarDao;
import com.vaahanmitra.daoImpl.AddBikeDaoImpl;
import com.vaahanmitra.daoImpl.AddCarDaoImpl;
import com.vaahanmitra.model.AddBike;
import com.vaahanmitra.model.AddCar;

/**
 * Servlet implementation class AinsertBikeExshowroomPrice
 */
public class AinsertBikeExshowroomPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AinsertBikeExshowroomPrice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String v_page="servlet";
		String price=request.getParameter("ex_show_room_price");
		String place=request.getParameter("exshowroom_place");
		String 	bike_id=request.getParameter("bike_id");
		
		
		AddBikeDao dao=new AddBikeDaoImpl();
		
	    String message= dao.aInsertBikeExShowroomPrice(bike_id, place, price);
	    int page = 1;  
		  int maxrowsperpage=8;
		  int noofRecords =0,numofpages=0;
		   
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		 
		
		ArrayList<AddBike> bikeDetails =new ArrayList<AddBike>();
		try
		{
			bikeDetails = dao.getBikeExshowRoomPriceList(bike_id,(page-1)*maxrowsperpage, maxrowsperpage);
		noofRecords=dao.getNoOfRecords();
		if (noofRecords % maxrowsperpage > 0) {
			numofpages = (noofRecords / maxrowsperpage) + 1;
		} else {
			numofpages = noofRecords / maxrowsperpage;
		}
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	    
	    
	    
	    
	    
	    
		
	RequestDispatcher rd=request.getRequestDispatcher("./aAddbBikeExshowRoompriceView.jsp");
	request.setAttribute("bikeDetails", bikeDetails);
	request.setAttribute("bike_id", bike_id);
	 request.setAttribute("success", message);
		request.setAttribute("noOfPages", numofpages);
		request.setAttribute("noofrecords", noofRecords);
		request.setAttribute("currentPage", page);
		request.setAttribute("maxrowsperpage", maxrowsperpage);

	 request.setAttribute("v_page", v_page);
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
