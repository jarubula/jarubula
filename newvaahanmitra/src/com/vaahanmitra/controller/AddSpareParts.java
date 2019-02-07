package com.vaahanmitra.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.vaahanmitra.dao.SparePartsDao;
import com.vaahanmitra.daoImpl.SparePartsDaoImpl;
import com.vaahanmitra.model.SpareParts;

/**
 * Servlet implementation class AddSpareParts
 */
@javax.servlet.annotation.MultipartConfig
public class AddSpareParts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddSpareParts() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = null,sku = null,page=null;
		SpareParts spareParts = new SpareParts();
		String vehicleType = request.getParameter("vehicleType");
		if(vehicleType.equals("4,")){
			spareParts.setVEHICLE_BRAND(request.getParameter("brandid").toUpperCase());
			spareParts.setVEHICLE_MODEL(request.getParameter("carModel").toUpperCase());
			spareParts.setSKU(request.getParameter("csku").toUpperCase());
			spareParts.setVEHICLE_TYPE("4,");
			sku = request.getParameter("csku");
		}else{
			spareParts.setVEHICLE_BRAND(request.getParameter("bikeBrand").toUpperCase());
			spareParts.setVEHICLE_MODEL(request.getParameter("bikeModel").toUpperCase());
			spareParts.setSKU(request.getParameter("bsku").toUpperCase());
			spareParts.setVEHICLE_TYPE("2,");
			sku = request.getParameter("bsku");
		}
		spareParts.setMODEL_YEAR(request.getParameter("year1"));
		spareParts.setMANUFACTURE_COMPANY_NAME(request.getParameter("companyName"));
		spareParts.setPARTNO(request.getParameter("partNo"));
		spareParts.setSP_NAME(request.getParameter("name").toUpperCase());
		spareParts.setCATEGORY(request.getParameter("category"));
		spareParts.setDISCOUNT("0");
		String warrenty = request.getParameter("warranty");
		if (warrenty.equals("YES")) {
			warrenty = request.getParameter("war");
		}
		spareParts.setWARRANTY(warrenty);
		String scategory = request.getParameter("subcategory");
		if (scategory == null || scategory == "") {
			spareParts.setSUB_CATEGORY("N/A");
		}
		spareParts.setSUB_CATEGORY(request.getParameter("subcategory"));
		String specification = "";
		String specifications[] = request.getParameterValues("specification");
		if (specifications != null) {
			for (int i = 0; i < specifications.length; i++) {
				specification += specifications[i] + ",";
				spareParts.setSPECIFICATIONS(specification);
			}
		}
		String description = request.getParameter("description");
		if (description == null || description == "") {
			spareParts.setDESCRIPTION("N/A");
		} else {
			spareParts.setDESCRIPTION(request.getParameter("description"));
		}
		String price = request.getParameter("price");
		System.out.println(price);
		if (price == null || price == "" || price.equals("null")) {
			spareParts.setPRICE("N/A");
		} else {
			spareParts.setPRICE(request.getParameter("price"));
		}
		Part photo = request.getPart("photo");
		String dMethod = "";
		String dmethod[] = request.getParameterValues("dmethod");
		if (dmethod != null) {
			for (int i = 0; i < dmethod.length; i++) {
				dMethod += dmethod[i]+ ",";
				spareParts.setDELEVERY_METHOD(dMethod);
			}
		} else {
			spareParts.setDELEVERY_METHOD(dMethod);
		}
		spareParts.setSTATUS("ACTIVE");
		
		InputStream is = null;
		if (photo != null) {
			is = photo.getInputStream();
		}

		HttpSession session = request.getSession(false);
		String user_name = (String) session.getAttribute("user");

		SparePartsDao dao = new SparePartsDaoImpl();

		String check = dao.checkSKU(sku);
		if (check.equals("success")) {
			message = "Already SpareParts added on sku  " + sku;
			if(vehicleType.equals("4,")){
				page = "./spareParts.jsp";
			}else{
				page = "./bikeSpareParts.jsp";
			}
		} else {
			message = dao.addSpareParts(spareParts, user_name, is);
			if(vehicleType.equals("4,")){
				page = "./spareParts.jsp";
			}else{
				page = "./bikeSpareParts.jsp";
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		request.setAttribute("success", message);
		rd.forward(request, response);
	}
}
