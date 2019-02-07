package com.vaahanmitra.controller;

import java.io.ByteArrayInputStream;
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

import Decoder.BASE64Decoder;

/**
 * Servlet implementation class UpdateServiceSpareParts
 */
@javax.servlet.annotation.MultipartConfig
public class UpdateServiceSpareParts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateServiceSpareParts() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = null, page = null;
		SpareParts spareParts = new SpareParts();
		String vehicleType = request.getParameter("vehicleType");
		if(vehicleType.equals("4,")){
			spareParts.setVEHICLE_BRAND(request.getParameter("brandid").toUpperCase());
			spareParts.setVEHICLE_MODEL(request.getParameter("carModel").toUpperCase());
		}else{
			spareParts.setVEHICLE_BRAND(request.getParameter("bikeBrand").toUpperCase());
			spareParts.setVEHICLE_MODEL(request.getParameter("bikeModel").toUpperCase());
		}
		spareParts.setSKU(request.getParameter("csku").toUpperCase());
		String sku = request.getParameter("csku");
		spareParts.setMODEL_YEAR(request.getParameter("year1"));
		spareParts.setMANUFACTURE_COMPANY_NAME(request.getParameter("companyName"));
		spareParts.setPARTNO(request.getParameter("partNo"));
		spareParts.setSP_NAME(request.getParameter("name").toUpperCase());
		spareParts.setCATEGORY(request.getParameter("category"));
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
		if (price == null || price == "") {
			spareParts.setPRICE("N/A");
		} else {
			spareParts.setPRICE(request.getParameter("price"));
		}
		String dMethod = "";
		String dmethod[] = request.getParameterValues("dmethod");
		if (dmethod != null) {
			for (int i = 0; i < dmethod.length; i++) {
				dMethod += dmethod[i] + ",";
				spareParts.setDELEVERY_METHOD(dMethod);
			}
		} else {
			spareParts.setDELEVERY_METHOD(dMethod);
		}

		InputStream is = null;
		String pic = request.getParameter("image");
		Part pic1 = request.getPart("photo");
		if (pic1.getSize() > 0) {
			is = pic1.getInputStream();
		} else {
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] decodedBytes = decoder.decodeBuffer(pic);
			is = new ByteArrayInputStream(decodedBytes);
		}

		HttpSession session = request.getSession(false);
		String user_name = (String) session.getAttribute("user");

		SparePartsDao dao = new SparePartsDaoImpl();

		message = dao.updateSpareParts(spareParts, user_name, is);
		if (message.equals("success")) {
			message = "SPARE PARTS UPDATED SUCCESSFULLY...";
			if (vehicleType.equals("4,")) {
				page = "./updateServiceSP4.jsp";
			} else {
				page = "./updateServiceSP2.jsp";
			}
		} else {
			message = "SPARE PART NOT UPDATED! PLEASE TRY AGAIN!";
			if (vehicleType.equals("4,")) {
				page = "./updateServiceSP4.jsp";
			} else {
				page = "./updateServiceSP2.jsp";
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		request.setAttribute("ssku", sku);
		request.setAttribute("svt", vehicleType);
		request.setAttribute("success", message);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
