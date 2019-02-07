package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.AddCarDao;
import com.vaahanmitra.daoImpl.AddCarDaoImpl;
import com.vaahanmitra.model.AddCar;

/**
 * Servlet implementation class aGetNewCardetailsForUpdate
 */
public class aGetNewCardetailsForUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public aGetNewCardetailsForUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String var_name="";
		String message="";
		
        try {
			var_name=request.getParameter("vehicleVariant");
	
        if(var_name==null||var_name==""){
        	 var_name=request.getAttribute("vehicleVariant").toString();
        	 message=request.getAttribute("success").toString();
        	 
        }	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<AddCar> b_details=new ArrayList<AddCar>();
		     AddCarDao dao=new AddCarDaoImpl();
              
		b_details=dao.getCarDetailswithoutimageVariantName(var_name);
		request.setAttribute("list_details", b_details);
		request.setAttribute("var_name", var_name);
		request.setAttribute("success", message);
		 RequestDispatcher rd=request.getRequestDispatcher("./aUpdateNewCarDetailsView.jsp");
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