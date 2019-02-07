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
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String emailId = request.getParameter("email");
		String password = request.getParameter("password");
		
		CarDAO cdao=new CarDAOImpl();
		ArrayList<String> ceu =null;
		System.out.println("user"+emailId);
		if(emailId!=null)
		{
			ceu = cdao.getRequesters(emailId);
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
		String range=request.getParameter("lHPrice");
		String bodyType=request.getParameter("bodyType");
		String email=null;
		String name=null;
		
		
		String vehicleType=request.getParameter("vehicleType");
		
		name= request.getParameter("dname");
		email=request.getParameter("demail");
		name = request.getParameter("dname");
		
		bean.setEMAIL_ID(email);
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
		
		CarDAO dao = new CarDAOImpl();
//		ArrayList<String> ceu = dao.getRequesters(emailId);
//		ArrayList<UsedCar> carDetails = cdao.searchUsedCar(brand);
		String message = null;
		LoginDao ldao = new LoginDaoImpl();
		message = ldao.checkUserPwd(emailId, password);
		HttpSession session = request.getSession();
		if (message.equals("no")) {
			message = "Email Id Not registerd! Please Register...";
		} else if (message.equals("PI")) {
			message = "EMAIL ID not at verified! Please verify your Email for Login";
		} else if (message.equals("yes")) {
			message = "WELCOME TO VAAHANMITRA";
			session.setAttribute("user", emailId);
		} else if (message.equals("I")) {
			message = "EMAIL ID Already Registered with US! Please verify your Email for Login";
		} else if (message.equals("P")) {
			message = "Password not correct! Please enter Correct...";
		}
		
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
		request.setAttribute("bodyType", bodyType);
		request.setAttribute("range", range);
		request.setAttribute("noOfPages", numofpages);
		request.setAttribute("noofrecords", noofRecords);
		request.setAttribute("currentPage", page);
		request.setAttribute("message", message);
		request.setAttribute("maxrowsperpage", maxrowsperpage);
		rd.forward(request, response);
	}

}
