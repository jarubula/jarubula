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
 * Servlet implementation class SearchSparePartSKU
 */
public class SearchSparePartSKU extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchSparePartSKU() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sku = request.getParameter("sku");
		HttpSession session = request.getSession(false);
		String user_name = (String)session.getAttribute("user");
		
		SparePartsDao dao = new SparePartsDaoImpl();
		ArrayList<SpareParts> sp= dao.getSPDetails(sku.toUpperCase(),user_name);
		String page = null;
		String msg = null;
		if(sp.size()>0)
		{
			msg="Spare Parts Details";
			page = "./updateSparePartPrice.jsp";
			request.setAttribute("spdetails", sp);
			request.setAttribute("message", msg);
			request.setAttribute("skusp", sku);
		}
		else
		{	
			msg = "*** NO SPARE PARTS FOUND ***";
			page = "./updateSparePartPrice.jsp";
			request.setAttribute("message", msg);
		}
		RequestDispatcher rd=request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
