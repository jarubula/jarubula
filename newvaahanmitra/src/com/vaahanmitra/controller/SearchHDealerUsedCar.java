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
import com.vaahanmitra.daoImpl.CarDAOImpl;
import com.vaahanmitra.model.UsedCar;

/**
 * Servlet implementation class SearchHDealerUsedCar
 */
public class SearchHDealerUsedCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchHDealerUsedCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		String uemail = (String) session.getAttribute("user");
		CarDAO cdao=new CarDAOImpl();
		ArrayList<String> ceu =null;
		if(uemail!=null)
		{
			ceu = cdao.getRequesters(uemail);
		}
		
		UsedCar bean=new UsedCar();
		String carBrand=request.getParameter("carBrand");
		String city=request.getParameter("city");
		String budget=request.getParameter("carBudget");
		String carAge=request.getParameter("carAge");
		String color=request.getParameter("colors");
		String fuelType=request.getParameter("fuelType");
		String kms=request.getParameter("kms");
		String transmission=request.getParameter("transmission");
		String bodyType=request.getParameter("bodyType");
		String range=request.getParameter("lHPrice");
		String email=null;
		String name=null;
		
		String vehicleType=request.getParameter("vehicleType");
		
		name=(String)request.getAttribute("name");
		email=(String)request.getAttribute("email");
		if(email!=null){	
		bean.setEMAIL_ID(email);
		}else{
			name=request.getParameter("name");
			email=request.getParameter("email");
			bean.setEMAIL_ID(email);
		}
		
		bean.setREGISTERED_YEAR(carAge);
		bean.setCAR_BRAND(carBrand);
		bean.setOFFER_PRICE(budget);
		bean.setCITY(city);
		bean.setCOLOR(color);
		bean.setFUEL_TYPE(fuelType);
		bean.setCURRENT_MILEAGE(kms);
		bean.setTRANSIMISSION(transmission);
		bean.setPRICE(range);
		bean.setBODY_TYPE(bodyType);
		
		String owners=request.getParameter("owners");
		if(owners!=null){
		bean.setNO_OF_OWNERS(Integer.parseInt(owners));
		}
		int page = 1;  
		  int maxrowsperpage=30;
		  int noofRecords =0,numofpages=0;
		   
		   if(request.getParameter("page") != null){
		    page = Integer.parseInt(request.getParameter("page")); 
		   }
		  
		  ArrayList<UsedCar> carDetails=cdao.searchHDealerUsedCar(bean,(page-1)*maxrowsperpage, maxrowsperpage);
		  
		  noofRecords=cdao.getNoOfRecords();
		  
		  if(noofRecords%maxrowsperpage>0){    
		  numofpages=(noofRecords/maxrowsperpage)+1;
		  }
		  
		  else{
		   numofpages=noofRecords/maxrowsperpage;
		  }
		RequestDispatcher rd=request.getRequestDispatcher("./searchHDealerUsedCar.jsp");
		request.setAttribute("carDetails", carDetails);
		request.setAttribute("city", city);
		request.setAttribute("carBrand", carBrand);
		request.setAttribute("budget", budget);
		request.setAttribute("carAge", carAge);
		request.setAttribute("color", color);
		request.setAttribute("carrequest", ceu);
		request.setAttribute("fuelType", fuelType);
		request.setAttribute("kms", kms);
		request.setAttribute("transmission", transmission);
		request.setAttribute("email", email);
		request.setAttribute("vehicleType", vehicleType);
		request.setAttribute("name", name);
		request.setAttribute("range", range);
		request.setAttribute("noOfPages", numofpages);
		  request.setAttribute("noofrecords", noofRecords);
		  request.setAttribute("currentPage", page);
		  request.setAttribute("maxrowsperpage", maxrowsperpage);
		  request.setAttribute("bodyType", bodyType);
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
