
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
 * Servlet implementation class SearchUsedCar
 */
public class SearchUsedCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUsedCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UsedCar bean=new UsedCar();
		String carBrand=request.getParameter("carBrand");
		String carVariant=request.getParameter("carVariant");
	
		String city=request.getParameter("city");
		String budget=request.getParameter("carBudget");
		String carModel=request.getParameter("carModel");
		String bodyType=request.getParameter("bodyType");
		String carAge=request.getParameter("carAge");
		String color=request.getParameter("colors");
		String fuelType=request.getParameter("fuelType");
		String kms=request.getParameter("kms");
		String transmission=request.getParameter("transmission");
		String owners=request.getParameter("owners");
		String range=request.getParameter("lHPrice");

		String cBrand   = (String)request.getAttribute("carBrand");
		String cModel   = (String)request.getAttribute("carModel");
		String vVariant = (String)request.getAttribute("carVariant");
		String cBudget = (String)request.getAttribute("carBudget");
		String cCity = (String)request.getAttribute("city");
		if(cCity!=null){
			bean.setCAR_BRAND(cBrand);
			bean.setCAR_MODEL(cModel);
			bean.setVARIANT_NAME(vVariant);
			bean.setOFFER_PRICE(cBudget);
			bean.setCITY(cCity);
		}else{
			bean.setCAR_BRAND(carBrand);
			bean.setCAR_MODEL(carModel);
			bean.setVARIANT_NAME(carVariant);
			bean.setOFFER_PRICE(budget);
			bean.setCITY(city);
		}
		
		bean.setREGISTERED_YEAR(carAge);
		bean.setBODY_TYPE(bodyType);
//		bean.setSELLER_TYPE(sellerType);
		
		bean.setCOLOR(color);
		bean.setFUEL_TYPE(fuelType);
		bean.setKMS_DRIVEN(kms);
		bean.setPRICE(range);

		if(owners!=null){
		bean.setNO_OF_OWNERS(Integer.parseInt(owners));
		}
		bean.setTRANSIMISSION(transmission);
		
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("user");
		ArrayList<String> ceu = null;
		
		CarDAO cdao=new CarDAOImpl();
		if(email!=null){
			ceu = cdao.getRequesters(email);
		}
		int page = 1;  
		  int maxrowsperpage=30;
		  int noofRecords =0,numofpages=0;
		   
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		ArrayList<UsedCar> carDetails=cdao.searchHUsedCar(bean,(page-1)*maxrowsperpage, maxrowsperpage);
		  noofRecords=cdao.getNoOfRecords();
		if (noofRecords % maxrowsperpage > 0) {
			numofpages = (noofRecords / maxrowsperpage) + 1;
		} else {
			numofpages = noofRecords / maxrowsperpage;
		}
		RequestDispatcher rd=request.getRequestDispatcher("./searchHUsedCar.jsp");
		request.setAttribute("carDetails", carDetails);
		request.setAttribute("carrequest", ceu);
		if(cCity!=null){
			request.setAttribute("city", cCity);
			request.setAttribute("carBrand", cBrand);
			request.setAttribute("budget", cBudget);
			request.setAttribute("carModel", cModel);
			request.setAttribute("carVariant", vVariant);
		}else{
			request.setAttribute("city", city);
			request.setAttribute("carBrand", carBrand);
			request.setAttribute("carVariant", carVariant);
			request.setAttribute("budget", budget);
			request.setAttribute("carModel", carModel);
			request.setAttribute("carAge", carAge);
			request.setAttribute("color", color);
			request.setAttribute("fuelType", fuelType);
			request.setAttribute("kms", kms);
			request.setAttribute("transmission", transmission);
			request.setAttribute("range", range);
			request.setAttribute("bodyType", bodyType);
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
