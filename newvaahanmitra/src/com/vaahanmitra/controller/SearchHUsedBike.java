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
 * Servlet implementation class SearchHUsedBike
 */
public class SearchHUsedBike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchHUsedBike() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UsedBike bean = new UsedBike();
		String bikeBrand   = request.getParameter("bikeBrand");
		String bikeVariant = request.getParameter("bikeVariant");
		String city = request.getParameter("city");
		String budget = request.getParameter("bikeBudget");
		String bikeModel = request.getParameter("bikeModel");
		// String sellerType=request.getParameter("sellerType");
		String bikeAge = request.getParameter("bikeAge");
		String color = request.getParameter("colors");
		String kms = request.getParameter("kms");
		String owners = request.getParameter("owners");
		String range=request.getParameter("lHPrice");
		bean.setPRICE(range);
		
		
		
		String bBrand    = (String)request.getAttribute("bikeBrand");
		String bModel    = (String)request.getAttribute("bikeModel");
		String bVariant  = (String)request.getAttribute("bikeVariant");
		String bBudget = (String)request.getAttribute("bikeBudget");
		String bCity = (String)request.getAttribute("city");
		
		System.out.println("HARI"+bBrand + bModel + bBudget + bCity);

		if(bBrand!=null){
			bean.setBIKE_BRAND(bBrand);
			bean.setBIKE_MODEL(bModel);
			bean.setVARIANT_NAME(bVariant);
			bean.setOFFER_PRICE(bBudget);
			bean.setCITY(bCity);
		}else{
				bean.setBIKE_BRAND(bikeBrand);
				bean.setBIKE_MODEL(bikeModel);
				bean.setVARIANT_NAME(bikeVariant);
				bean.setOFFER_PRICE(budget);
				bean.setCITY(city);
		}
		if (bikeAge == null) {
			bikeAge = "";
		}
		bean.setREGISTERED_YEAR(bikeAge);
		// bean.setSELLER_TYPE(sellerType);
		
		bean.setCOLOR(color);
		bean.setCURRENT_MILEAGE(kms);

		if (owners != null) {
			bean.setNO_OF_OWNERS(Integer.parseInt(owners));
		}
		
		ArrayList<String> ceu = null;
		SearchHUsedBikeDAO cdao = new SearchHUsedBikeDAOImpl();
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("user");
		if (email != null) {
			ceu = cdao.getRequesters(email);
		}
		int page = 1;  
		  int maxrowsperpage=30;
		  int noofRecords =0,numofpages=0;
		   
		   if(request.getParameter("page") != null){
		    page = Integer.parseInt(request.getParameter("page")); 
		   }
		ArrayList<UsedBike> bikeDetails = cdao.searchHUsedBike(bean,(page-1)*maxrowsperpage, maxrowsperpage);
		System.out.println("harishhh");
		noofRecords=cdao.getNoOfRecords();
		  
		if (noofRecords % maxrowsperpage > 0) {
			numofpages = (noofRecords / maxrowsperpage) + 1;
		} else {
			numofpages = noofRecords / maxrowsperpage;
		}
		RequestDispatcher rd = request.getRequestDispatcher("./searchHUsedBike.jsp");
		request.setAttribute("bikeDetails", bikeDetails);
		request.setAttribute("bikerequest", ceu);
		if(bBrand!=null){
			request.setAttribute("bikeBrand", bBrand);
			request.setAttribute("bikeModel", bModel);
			request.setAttribute("bikeVariant", bVariant);
			request.setAttribute("budget", bBudget);
			request.setAttribute("city", bCity);
		}else{
			request.setAttribute("bikeBrand", bikeBrand);
			request.setAttribute("bikeModel", bikeModel);
			request.setAttribute("bikeVariant", bikeVariant);
			request.setAttribute("budget", budget);
			request.setAttribute("city", city);
			request.setAttribute("bikeAge", bikeAge);
			request.setAttribute("color", color);
			request.setAttribute("kms", kms);
			request.setAttribute("owners", owners);
			request.setAttribute("range", range);
		}
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
