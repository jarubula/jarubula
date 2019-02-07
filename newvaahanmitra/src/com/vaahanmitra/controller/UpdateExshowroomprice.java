package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.AddCarDao;
import com.vaahanmitra.daoImpl.AddCarDaoImpl;
import com.vaahanmitra.model.AddCar;

/**
 * Servlet implementation class UpdateExshowroomprice
 */
public class UpdateExshowroomprice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateExshowroomprice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	String exshowroomprice = request.getParameter("exshowroomprice");
	String car_id          = request.getParameter("car_id");
	String place           = request.getParameter("place");  
	
	AddCarDao  dao = new AddCarDaoImpl();

  String message= dao.aupdateExShowroomPrice(car_id, place, exshowroomprice);
  int page = 1;  
  int maxrowsperpage=8;
  int noofRecords =0,numofpages=0;
   
if (request.getParameter("page") != null) {
	page = Integer.parseInt(request.getParameter("page"));
}
 

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


  
  RequestDispatcher requestDispatcher=request.getRequestDispatcher("./aAddExshowroomPriceView.jsp");
  request.setAttribute("carDetails", carDetails);
  request.setAttribute("car_id", car_id);
  request.setAttribute("success", message);
	request.setAttribute("noOfPages", numofpages);
	request.setAttribute("noofrecords", noofRecords);
	request.setAttribute("currentPage", page);
	request.setAttribute("maxrowsperpage", maxrowsperpage);
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
