package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.AssignBrandsToDealerDao;
import com.vaahanmitra.daoImpl.AssignBrandsToDealerDaoImpl;
import com.vaahanmitra.model.DealerAssignBrands;

/**
 * Servlet implementation class AdAssignBrandsToDealer
 */
public class AdAssignBrandsToDealer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdAssignBrandsToDealer() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DealerAssignBrands bean = new DealerAssignBrands();
		String email = request.getParameter("email");
		
		bean.setEmail(request.getParameter("email"));
		bean.setBrand(request.getParameter("vehicleBrand"));
		bean.setVehicleType(request.getParameter("vType"));
		bean.setModel(request.getParameter("vehicleModel"));
		bean.setCity(request.getParameter("city"));
		
		/*String model="";
		String models[] = request.getParameterValues("vehicleModel");
		if(models!=null){
			for(int i=0;i<models.length;i++){
				model+=models[i]+",";
				bean.setModel(model);
			}	
		}else{
			bean.setModel(model);
		}*/
		
		AssignBrandsToDealerDao dao = new AssignBrandsToDealerDaoImpl();
		String message = dao.assignBrandsToDealer(bean);
		RequestDispatcher rd = request.getRequestDispatcher("./adAssignBrandToDealer.jsp");
		request.setAttribute("message", message);
		request.setAttribute("email", email);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
