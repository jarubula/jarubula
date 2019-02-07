package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.SparePartsDao;
import com.vaahanmitra.daoImpl.SparePartsDaoImpl;
import com.vaahanmitra.model.SpareParts;

/**
 * Servlet implementation class UpdateSCSpareParts
 */
public class UpdateSCSpareParts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSCSpareParts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jspPage = null;
		
		String vehicleType = request.getParameter("vehicleType");
		String brandid = request.getParameter("vehicleBrand");
		String carModels = request.getParameter("vehicleModel");
		String sku = request.getParameter("sku");
		String partName = request.getParameter("partName");
		String category = request.getParameter("category");
		
		SpareParts sp = new SpareParts();
		sp.setVEHICLE_TYPE(vehicleType);
		sp.setVEHICLE_BRAND(brandid);
		sp.setVEHICLE_MODEL(carModels);
		sp.setSKU(sku);
		sp.setSP_NAME(partName);
		sp.setCATEGORY(category);

		int page = 1;
		int maxrowsperpage = 5;
		int noofRecords = 0, numofpages = 0;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		HttpSession session = request.getSession(false);
		String user_name = (String)session.getAttribute("user");
		
		
		SparePartsDao dao = new SparePartsDaoImpl();
		ArrayList<SpareParts> spdetails = dao.searchSPDetails(sp,user_name,(page - 1) * maxrowsperpage, maxrowsperpage);
		noofRecords = dao.getNoOfRecords();
		if (noofRecords % maxrowsperpage > 0) {
			numofpages = (noofRecords / maxrowsperpage) + 1;
		} else {
			numofpages = noofRecords / maxrowsperpage;
		}
		System.out.println(spdetails);
		if(spdetails.size()>0)
		{
			String message = "SPARE PARTS DETAILS";
			jspPage = "./updateSCSparePartPrice.jsp";  
			request.setAttribute("spdetails", spdetails);
			request.setAttribute("noOfPages", numofpages);
			request.setAttribute("noofrecords", noofRecords);
			request.setAttribute("currentPage", page);
			request.setAttribute("maxrowsperpage", maxrowsperpage);
			request.setAttribute("vehicleBrand", brandid);
			request.setAttribute("vehicleType", vehicleType);
			request.setAttribute("vehicleModel", carModels);
			request.setAttribute("sku", sku);
			request.setAttribute("partName", partName);
			request.setAttribute("user_name", user_name);
			request.setAttribute("message", message);
		}
		else
		{
			String message = " SPARE PARTS NOT FOUND ";
			jspPage = "./updateSCSparePartPrice.jsp";
			request.setAttribute("message", message);
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(jspPage);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
