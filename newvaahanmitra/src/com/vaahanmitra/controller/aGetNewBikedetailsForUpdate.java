package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.AddBikeDao;
import com.vaahanmitra.daoImpl.AddBikeDaoImpl;
import com.vaahanmitra.model.AddBike;

/**
 * Servlet implementation class aGetNewBikedetailsForUpdate
 */
public class aGetNewBikedetailsForUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public aGetNewBikedetailsForUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
        }	
		ArrayList<AddBike> b_details=new ArrayList<AddBike>();
		     AddBikeDao dao=new AddBikeDaoImpl();
              
		b_details=dao.getBikeDetailsByVariantNamewithoutimage(var_name);
		request.setAttribute("list_details", b_details);
		request.setAttribute("var_name", var_name);
		request.setAttribute("success", message);
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 RequestDispatcher rd=request.getRequestDispatcher("./aUpdateNewBikeDetailsView.jsp");
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
