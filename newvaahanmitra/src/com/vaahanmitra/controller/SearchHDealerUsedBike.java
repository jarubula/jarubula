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
 * Servlet implementation class SearchHDealerUsedBike
 */
public class SearchHDealerUsedBike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchHDealerUsedBike() {
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
		SearchHUsedBikeDAO dao = new SearchHUsedBikeDAOImpl();
		ArrayList<String> ceu =null;
		if(uemail!=null)
		{
			ceu = dao.getRequesters(uemail);
		}
		
		UsedBike bean=new UsedBike();
		String bikeBrand=request.getParameter("bikeBrand");
		String city=request.getParameter("city");
		String budget=request.getParameter("bikeBudget");
		String bikeAge=request.getParameter("bikeAge");
		String color=request.getParameter("colors");
		String kms=request.getParameter("kms");
		String owners=request.getParameter("owners");
		String vehicleType=request.getParameter("vehicleType");
		String range=request.getParameter("lHPrice");

		bean.setPRICE(range);
		bean.setBIKE_BRAND(bikeBrand);
		bean.setOFFER_PRICE(budget);
		bean.setCITY(city);
		bean.setCOLOR(color);
		bean.setCURRENT_MILEAGE(kms);
		String email=null;
		String name=request.getParameter("name");
		email=(String)request.getAttribute("email");
		String dname=(String)request.getAttribute("name");
		if(city==null){
		city=(String)request.getAttribute("city");
		}
		System.out.println("sssssss"+city);
		if(owners!=null){
			bean.setNO_OF_OWNERS(Integer.parseInt(owners));
			}
		if(email!=null){	
		bean.setEMAIL_ID(email);
		}else{
			
			email=request.getParameter("email");
			bean.setEMAIL_ID(email);
		}
		int page = 1;  
		  int maxrowsperpage=30;
		  int noofRecords =0,numofpages=0;
		   
		   if(request.getParameter("page") != null){
		    page = Integer.parseInt(request.getParameter("page")); 
		   }
		  
		  
		  SearchHUsedBikeDAO cdao=new SearchHUsedBikeDAOImpl();
		  ArrayList<UsedBike> bikeDetails=cdao.searchHDealerUsedBike(bean,(page-1)*maxrowsperpage, maxrowsperpage);
		  
		  noofRecords=cdao.getNoOfRecords();
		  
		  if(noofRecords%maxrowsperpage>0){    
		  numofpages=(noofRecords/maxrowsperpage)+1;
		  }
		  
		  else{
		   numofpages=noofRecords/maxrowsperpage;
		  }
		RequestDispatcher rd=request.getRequestDispatcher("./searchHDealerUsedBike.jsp");
		request.setAttribute("bikeDetails", bikeDetails);
		request.setAttribute("city", city);
		request.setAttribute("bikerequest", ceu);
		request.setAttribute("bikeBrand", bikeBrand);
		request.setAttribute("budget", budget);
		request.setAttribute("bikeAge", bikeAge);
		request.setAttribute("color", color);
		request.setAttribute("kms", kms);
		request.setAttribute("owners", owners);
		request.setAttribute("email", email);
		request.setAttribute("vehicleType", vehicleType);
		request.setAttribute("name", name);
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
