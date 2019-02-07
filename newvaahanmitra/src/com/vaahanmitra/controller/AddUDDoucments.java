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

import com.vaahanmitra.dao.SearchHUsedVehicleDealerDAO;
import com.vaahanmitra.daoImpl.SearchHUsedVehicleDealerDAOImpl;
import com.vaahanmitra.service.SendMail;

/**
 * Servlet implementation class AddUDDoucments
 */

@javax.servlet.annotation.MultipartConfig
public class AddUDDoucments extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String v_type=request.getParameter("v_type");
		String brand="";
		if(v_type.equals("4,")){
		 brand = request.getParameter("brandid");
		}
		else{
			brand = request.getParameter("bikeBrand");
		}
		String documentName = request.getParameter("documetName");
		Part photo1 = request.getPart("file1");
		
		String page="";

		HttpSession session = request.getSession(false);
		String user_name = (String)session.getAttribute("user");
		String to="vaahanmitra@gmail.com";
		String msg="Documets submitted by the "+user_name+". Please verify!";
		
		InputStream is = null;
		if(photo1!=null)
		{
	    	is = photo1.getInputStream();
		}
		
		SearchHUsedVehicleDealerDAO dao = new SearchHUsedVehicleDealerDAOImpl();
		String message="";
		boolean flag=dao.checkbranddoc(user_name, brand, v_type);
		if(flag==false){
		 message = dao.addDocument(user_name,brand,documentName,v_type,is);
		if(message.equals("success")){
			message = "Documets added success";
			SendMail.send(to, msg);
		}else{
			message = "Documents not submitted! Please try again!";
		}
		}
		else{
			message="Document Already Available For This Brand ";
		}
		
		if(v_type.equals("2,")){
			page="./addUDNewBike.jsp";
		}
		else{
			page="./addUDNewCar.jsp";
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(page);
		request.setAttribute("success", message);
		rd.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
