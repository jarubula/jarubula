package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.SparePartsDao;
import com.vaahanmitra.daoImpl.SparePartsDaoImpl;
import com.vaahanmitra.model.SpareParts;

/**
 * Servlet implementation class SearchHSpareParts
 */
public class SearchHSpareParts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchHSpareParts() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SpareParts sp = new SpareParts();
		String vehicleType = request.getParameter("vehicleType");
		String vehicleBrand = request.getParameter("vehicleBrand");
		String vehicleModel = request.getParameter("vehicleModel");
		String category = request.getParameter("category");
		String subCategory = request.getParameter("subCategory");
		String city = request.getParameter("city");
		String spName = request.getParameter("spName");
		String partNo = request.getParameter("partNo");
		String companyName = request.getParameter("companyName");
		String modelYear = request.getParameter("modelYear");
		
		sp.setVEHICLE_BRAND(vehicleBrand);
		sp.setVEHICLE_TYPE(vehicleType);
		sp.setVEHICLE_MODEL(vehicleModel);
		sp.setCATEGORY(category);
		sp.setSUB_CATEGORY(subCategory);
		if(city.equals("") || city==null)
		{
			city="All";
		}
		sp.setCITY(city);
		sp.setSP_NAME(spName);
		sp.setPARTNO(partNo);
		sp.setMANUFACTURE_COMPANY_NAME(companyName);
		sp.setMODEL_YEAR(modelYear);
		
		
		SparePartsDao dao = new SparePartsDaoImpl();
		ArrayList<SpareParts> spDetails = dao.searchSpareParts(sp);
//		RequestDispatcher rd = request.getRequestDispatcher("./searchHSpareParts.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("./Sparetools.jsp");
		request.setAttribute("spDetails", spDetails);
		request.setAttribute("vehicleBrand", vehicleBrand);
		request.setAttribute("vehicleType", vehicleType);
		request.setAttribute("vehicleModel", vehicleModel);
		request.setAttribute("category", category);
		request.setAttribute("subCategory", subCategory);
		request.setAttribute("city", city);
		request.setAttribute("spName", spName);
		request.setAttribute("partNo", partNo);
		request.setAttribute("companyName", companyName);
		request.setAttribute("modelYear", modelYear);
		//System.out.println("hari"+spDetails);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
