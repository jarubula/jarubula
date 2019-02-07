package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.print.DocFlavor.STRING;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.List;
import com.vaahanmitra.dao.AddCarDao;
import com.vaahanmitra.daoImpl.AddCarDaoImpl;
import com.vaahanmitra.model.AddCar;

/**
 * Servlet implementation class AdminGetExshowPriceByVarient
 */
public class AdminGetExshowPriceByVarient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminGetExshowPriceByVarient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String page_s="";
		String car_id="";
		String message="";
		page_s=request.getParameter("v_page");
		if(page_s.equals("jsp")){
		 car_id=request.getParameter("vehicleVariant");
		}
		else{
			 car_id=request.getAttribute("vehicleVariant").toString();	
		}
	  /*  String Arr=request.getParameter("vehicleModel");
	                String[] value= Arr.split("-");
	                String car_mobel=value[0];
	                String brand=value[1];*/
		
		
		int page = 1;  
		  int maxrowsperpage=8;
		  int noofRecords =0,numofpages=0;
		   
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		 
		
		AddCarDao dao = new AddCarDaoImpl();
		ArrayList<AddCar> carDetails =new ArrayList<AddCar>();
		try
		{
		 carDetails = dao.getExshowRoomPriceList(car_id,(page-1)*maxrowsperpage, maxrowsperpage);
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
		RequestDispatcher rd=request.getRequestDispatcher("./aAddExshowroomPriceView.jsp");
		request.setAttribute("carDetails", carDetails);
		request.setAttribute("car_id", car_id);
		request.setAttribute("noOfPages", numofpages);
		request.setAttribute("noofrecords", noofRecords);
		if(page_s.equals("servlet")){
			message=request.getAttribute("message").toString();
			 request.setAttribute("success", message);
			}
		request.setAttribute("currentPage", page);
		request.setAttribute("maxrowsperpage", maxrowsperpage);
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
