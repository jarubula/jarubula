package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.CarDAO;
import com.vaahanmitra.dao.LoginDao;
import com.vaahanmitra.daoImpl.CarDAOImpl;
import com.vaahanmitra.daoImpl.LoginDaoImpl;
import com.vaahanmitra.model.UsedCar;

/**
 * Servlet implementation class IndividualUser
 */
public class IndividualUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndividualUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String jsppage = null, message = null;
		ArrayList<String> ceu =null;

		String emailId = request.getParameter("email");
		String password = request.getParameter("password");
		
//		String carId = request.getParameter("cid");
		UsedCar bean=new UsedCar();
		String carBrand=request.getParameter("carBrand");
		String city=request.getParameter("city1");
		String budget=request.getParameter("carBudget");
		String carModel=request.getParameter("carModel");
		String carVariant =request.getParameter("carVariant");
//		String sellerType=request.getParameter("sellerType");
		String carAge=request.getParameter("carAge");
		String color=request.getParameter("colors");
		String fuelType=request.getParameter("fuelType");
		String kms=request.getParameter("kms");
		String transmission=request.getParameter("transmission");
		String owners=request.getParameter("owners");
		String range=request.getParameter("lHPrice");
		String bodyType=request.getParameter("bodyType");

		bean.setREGISTERED_YEAR(carAge);
//		bean.setSELLER_TYPE(sellerType);
		bean.setCAR_BRAND(carBrand);
		bean.setCAR_MODEL(carModel);
		bean.setVARIANT_NAME(carVariant);
		bean.setOFFER_PRICE(budget);
		bean.setCITY(city);
		bean.setCOLOR(color);
		bean.setFUEL_TYPE(fuelType);
		bean.setKMS_DRIVEN(kms);
		bean.setPRICE(range);
		bean.setBODY_TYPE(bodyType);

		if(owners!=null){
		bean.setNO_OF_OWNERS(Integer.parseInt(owners));
		}
		bean.setTRANSIMISSION(transmission);
		CarDAO cdao=new CarDAOImpl();
		if(emailId!=null){
			ceu = cdao.getRequesters(emailId);
		}
//		ArrayList<UsedCar> carDetails = cdao.searchUsedCar(brand);
		
		LoginDao dao = new LoginDaoImpl();
		message = dao.checkUserPwd(emailId, password);
		HttpSession session = request.getSession();
		if (message.equals("no")){
			message ="Email Id Not registerd! Please Register...";
		} else if(message.equals("PI")){
			message = "EMAIL ID not at verified! Please verify your Email for Login";
		} else if(message.equals("yes")){
			message = "WELCOME TO VAAHANMITRA";
			session.setAttribute("user", emailId);
		} else if (message.equals("I")){
			message = "EMAIL ID Already Registered with US! Please verify your Email for Login";
		} else if(message.equals("P")){
			message ="Password not correct! Please enter Correct...";
		}
		int page = 1;  
		  int maxrowsperpage=30;
		  int noofRecords =0,numofpages=0;
		   
		   if(request.getParameter("page") != null){
		    page = Integer.parseInt(request.getParameter("page")); 
		   }
		   
		  ArrayList<UsedCar> carDetails=cdao.searchHUsedCar(bean,(page-1)*maxrowsperpage, maxrowsperpage);
		  
		  noofRecords=cdao.getNoOfRecords();
		  
		  if(noofRecords%maxrowsperpage>0){    
		  numofpages=(noofRecords/maxrowsperpage)+1;
		  }
		  
		  else{
		   numofpages=noofRecords/maxrowsperpage;
		  }
		
		jsppage = "./searchHUsedCar.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(jsppage);
		request.setAttribute("message", message);
		request.setAttribute("carrequest", ceu);
		request.setAttribute("carDetails", carDetails);
		request.setAttribute("city", city);
		request.setAttribute("carBrand", carBrand);
		request.setAttribute("budget", budget);
		request.setAttribute("carModel", carModel);
		request.setAttribute("carVariant",carVariant);
		request.setAttribute("carAge", carAge);
		request.setAttribute("color", color);
		request.setAttribute("fuelType", fuelType);
		request.setAttribute("kms", kms);
		request.setAttribute("bodyType", bodyType);
		request.setAttribute("transmission", transmission);
		request.setAttribute("range", range);
		request.setAttribute("noOfPages", numofpages);
		request.setAttribute("noofrecords", noofRecords);
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
