package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.AdminDao;
import com.vaahanmitra.daoImpl.AdminDaoImpl;
import com.vaahanmitra.model.DealerAuthentication;

/**
 * Servlet implementation class SearchDealerDocuments
 */
public class SearchDealerDocuments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = null,jspPage = null;
		String emailId= request.getParameter("emailId");
		AdminDao dao = new AdminDaoImpl();
		ArrayList<DealerAuthentication> ddocumets = dao.getDealerDocumets(emailId);
		if (ddocumets.size() > 0) {
			message = "Dealer documents...";
			jspPage = "./dealerAuthentication.jsp";
			request.setAttribute("ddocumets", ddocumets);
		} else {
			message = "Dealers not found! Enter correct emailId";
			jspPage = "./dealerAuthentication.jsp";
		}
		request.setAttribute("message", message);
		RequestDispatcher rd=request.getRequestDispatcher(jspPage);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
