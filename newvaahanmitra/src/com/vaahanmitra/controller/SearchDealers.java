package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.AssignBrandsToDealerDao;
import com.vaahanmitra.daoImpl.AssignBrandsToDealerDaoImpl;
import com.vaahanmitra.model.BusinessOwnerRegister;

public class SearchDealers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchDealers() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String city = request.getParameter("city");
		String model = request.getParameter("model");
		String brand = request.getParameter("brand");
		String vType = request.getParameter("vType");
		
		AssignBrandsToDealerDao dao =new AssignBrandsToDealerDaoImpl();
		ArrayList<BusinessOwnerRegister> bol = dao.getDealerList(city,brand,model,vType);
		RequestDispatcher rd=request.getRequestDispatcher("./searchDealers.jsp");
		request.setAttribute("bol", bol);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
