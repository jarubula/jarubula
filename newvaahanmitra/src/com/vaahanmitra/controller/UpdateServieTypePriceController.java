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

import com.vaahanmitra.dao.ServiceTypeDao;
import com.vaahanmitra.dao.UpdateServieTypePriceDao;
import com.vaahanmitra.daoImpl.ServiceTypeDaoImpl;
import com.vaahanmitra.daoImpl.UpdateServiceTypeDaoImpl;
import com.vaahanmitra.model.ServiceType;
import com.vaahanmitra.model.UpdateServicePrice;

/**
 * Servlet implementation class UpdateServieTypePriceController
 */
public class UpdateServieTypePriceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServieTypePriceController() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String fPrice[] = request.getParameterValues("selling");
		String scId[] = request.getParameterValues("scId");
		String discount[] = request.getParameterValues("discount");
		
		List<UpdateServicePrice> list = new ArrayList<UpdateServicePrice>();
		List<ServiceType> list1 = new ArrayList<ServiceType>();
		
		for(int i=0,j=0,k=0;i<fPrice.length || j<scId.length || k<discount.length;  i++,j++,k++){
			if(k<discount.length || discount[k].equals("") || discount[k].equals("0")){
				UpdateServicePrice usp = new UpdateServicePrice();
				usp.setSERVICE_CENTER_ID(scId[j]);
				usp.setPRICE(fPrice[i]);
				usp.setDISCOUNT(discount[k]);
				list.add(usp);
			}
		}
		HttpSession session = request.getSession(false);
		String user_name = (String)session.getAttribute("user");
		
		int page = 1;
		int maxrowsperpage = 5;
		int noofRecords = 0, numofpages = 0;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		UpdateServieTypePriceDao dao = new UpdateServiceTypeDaoImpl();
		ServiceTypeDao stdao = new ServiceTypeDaoImpl();
		String message = dao.addServicetypePrice(list,user_name);
		list1 = stdao.viewAllServices((page - 1) * maxrowsperpage, maxrowsperpage,user_name);
		noofRecords = stdao.getNoOfRecords();
		if (noofRecords % maxrowsperpage > 0) {
			numofpages = (noofRecords / maxrowsperpage) + 1;
		} else {
			numofpages = noofRecords / maxrowsperpage;
		}
		if(list.size()>0)
		{
			message = "Service Details";
			RequestDispatcher rd = request.getRequestDispatcher("./updateServicePrice1.jsp");
			request.setAttribute("servicesList", list1);
			request.setAttribute("noOfPages", numofpages);
			request.setAttribute("noofrecords", noofRecords);
			request.setAttribute("currentPage", page);
			request.setAttribute("maxrowsperpage", maxrowsperpage);
			request.setAttribute("user_name", user_name);
			request.setAttribute("message", message);
			rd.forward(request, response);
		}else{
			message = "Services Not found add Services";
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
