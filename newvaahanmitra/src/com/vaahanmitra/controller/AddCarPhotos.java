package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@javax.servlet.annotation.MultipartConfig
public class AddCarPhotos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddCarPhotos() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page=null;
		String carNo = request.getParameter("carNo");
		String userType = request.getParameter("userType");
		if(userType.equals("SC")){
			page="./updateSCCarPhotos.jsp";
		}else if(userType.equals("UD")){
			page="./updateUDCarPhotos.jsp";
		}else if(userType.equals("IO")){
			page="./updateIOCarPhotos.jsp";
		}else if(userType.equals("AD")){
			page="./updateNewCarPhotos.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		request.setAttribute("carNo", carNo);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
} 	
