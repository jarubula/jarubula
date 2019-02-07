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
import com.vaahanmitra.service.SendMail;

/**
 * Servlet implementation class AdDealerFeedback
 */
public class AdDealerFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AdDealerFeedback() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String jspPage = null;
		String acceptance = request.getParameter("acceptance");
		String feedback = request.getParameter("feedback");
		
		String dEmail = request.getParameter("demail");
		AdminDao dao = new AdminDaoImpl();
		
		String msg = dao.dealerFeedback(acceptance, dEmail);
		SendMail.send(dEmail, feedback);
		ArrayList<DealerAuthentication> ddocumets = dao.getDealerDocumets(dEmail);
		if (ddocumets.size() > 0) {
			msg = "Your feedback successfully sent to dealer.";
			jspPage = "./dealerAuthentication.jsp";
			request.setAttribute("ddocumets", ddocumets);
		} else {
			msg = "Dealers not found! Enter correct emailId";
			jspPage = "./dealerAuthentication.jsp";
		}
		request.setAttribute("message", msg);
		RequestDispatcher rd=request.getRequestDispatcher(jspPage);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
