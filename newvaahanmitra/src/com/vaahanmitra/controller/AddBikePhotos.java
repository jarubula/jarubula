package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@javax.servlet.annotation.MultipartConfig
public class AddBikePhotos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddBikePhotos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=null;
		String bikeNo = request.getParameter("bikeNo");
		String userType = request.getParameter("userType");
		if(userType.equals("SC")){
			page="./updateSCBikePhotos.jsp";
		}else if(userType.equals("UD")){
			page="./updateUDBikePhotos.jsp";
		}else if(userType.equals("IO")){
			page="./updateIOBikePhotos.jsp";
		}else if(userType.equals("AD")){
			page="./updateNewBikePhotos.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		request.setAttribute("bikeNo", bikeNo);
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
