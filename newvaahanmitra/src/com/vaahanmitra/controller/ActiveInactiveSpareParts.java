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
 * Servlet implementation class ActiveInactiveSpareParts
 */
public class ActiveInactiveSpareParts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActiveInactiveSpareParts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sku = request.getParameter("sku");
		String skuId = request.getParameter("skuId");
		String status = request.getParameter("status");
		
		HttpSession session = request.getSession(false);
		String user_name = (String) session.getAttribute("user");

		SparePartsDao dao = new SparePartsDaoImpl();

		String message = dao.setStatus(sku, status, user_name);

		if(message.equals("success") && status.equals("ACTIVE")){
			message = "SPARE PART INACTIVATED";
		}else{
			message = "SPARE PART ACTIVATED";
		}
		
		String vehicleType = request.getParameter("vehicleType");
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		String spName = request.getParameter("spName");

		SpareParts sp = new SpareParts();
		sp.setVEHICLE_TYPE(vehicleType);
		sp.setVEHICLE_BRAND(brand);
		sp.setVEHICLE_MODEL(model);
		sp.setSKU(skuId);
		sp.setSP_NAME(spName);
		
		int page = 1;
		int maxrowsperpage = 5;
		int noofRecords = 0, numofpages = 0;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		ArrayList<SpareParts> spdetails = dao.searchSPDetails(sp,user_name,(page - 1) * maxrowsperpage, maxrowsperpage);
		noofRecords = dao.getNoOfRecords();
		if (noofRecords % maxrowsperpage > 0) {
			numofpages = (noofRecords / maxrowsperpage) + 1;
		} else {
			numofpages = noofRecords / maxrowsperpage;
		}
		if (spdetails.size() > 0) {
			RequestDispatcher rd=request.getRequestDispatcher("./searchSpareParts.jsp");
			request.setAttribute("spdetails", spdetails);
			request.setAttribute("noOfPages", numofpages);
			request.setAttribute("noofrecords", noofRecords);
			request.setAttribute("currentPage", page);
			request.setAttribute("maxrowsperpage", maxrowsperpage);
			request.setAttribute("vehicleType", vehicleType);
			request.setAttribute("vehicleBrand", brand);
			request.setAttribute("vehicleModel", model);
			request.setAttribute("page", page);
			request.setAttribute("sku", skuId);
			request.setAttribute("partName", spName);
			request.setAttribute("message", message);
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
