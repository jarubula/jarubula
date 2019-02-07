package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class UpdateSparePartPrice2
 */
public class UpdateSparePartPrice2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateSparePartPrice2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String jspPage= null;
		String fPrice[] = request.getParameterValues("selling");
		String sku[] = request.getParameterValues("sku");
		String discount[] = request.getParameterValues("discount");
		
		List<SpareParts> list=new ArrayList<SpareParts>();
		
		System.out.println(discount.length);
		for(int i=0,j=0,k=0;i<fPrice.length || j<sku.length ||  k<discount.length;i++,j++,k++){
			SpareParts sp = new SpareParts();
			if(k<discount.length || discount[k].equals("") || discount[k].equals("0")){
				sp.setSKU(sku[j]);
				sp.setPRICE(fPrice[i]);
				sp.setDISCOUNT(discount[k]);
				list.add(sp);
			}
		}
		HttpSession session = request.getSession(false);
		String user_name = (String)session.getAttribute("user");
		
		String vehicleType = request.getParameter("vehicleType");
		String brandid = request.getParameter("vehicleBrand");
		String carModels = request.getParameter("vehicleModel");
		String skuId = request.getParameter("skuId");
		String partName = request.getParameter("partName");
		String category = request.getParameter("category");
		
		SpareParts sp = new SpareParts();
		sp.setVEHICLE_TYPE(vehicleType);
		sp.setVEHICLE_BRAND(brandid);
		sp.setVEHICLE_MODEL(carModels);
		sp.setSKU(skuId);
		sp.setSP_NAME(partName);
		sp.setCATEGORY(category);

		int page = 1;
		int maxrowsperpage = 5;
		int noofRecords = 0, numofpages = 0;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		SparePartsDao dao = new SparePartsDaoImpl();
		String message = dao.updateSPPrice(list,user_name);
		ArrayList<SpareParts> spdetails = dao.searchSPDetails(sp,user_name,(page - 1) * maxrowsperpage, maxrowsperpage);
		noofRecords = dao.getNoOfRecords();
		if (noofRecords % maxrowsperpage > 0) {
			numofpages = (noofRecords / maxrowsperpage) + 1;
		} else {
			numofpages = noofRecords / maxrowsperpage;
		}
		
		if(spdetails.size()>0)
		{
			message = "SPARE PARTS DETAILS";
			jspPage = "./updateSparePartPrice.jsp";  
			request.setAttribute("spdetails", spdetails);
			request.setAttribute("noOfPages", numofpages);
			request.setAttribute("noofrecords", noofRecords);
			request.setAttribute("currentPage", page);
			request.setAttribute("maxrowsperpage", maxrowsperpage);
			request.setAttribute("vehicleBrand", brandid);
			request.setAttribute("vehicleType", vehicleType);
			request.setAttribute("vehicleModel", carModels);
			request.setAttribute("category", category);
			request.setAttribute("sku", skuId);
			request.setAttribute("partName", partName);
			request.setAttribute("user_name", user_name);
			request.setAttribute("message", message);
		}
		else
		{
			message = " SPARE PARTS NOT FOUND ";
			jspPage = "./updateSparePartPrice.jsp";
			request.setAttribute("message", message);
			
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(jspPage);
		rd.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
