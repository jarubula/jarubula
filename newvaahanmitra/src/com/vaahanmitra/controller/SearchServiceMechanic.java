package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.MechanicProfileDao;
import com.vaahanmitra.daoImpl.MechanicProfileDaoImpl;
import com.vaahanmitra.model.MechanicProfile;

/**
 * Servlet implementation class SearchServiceMechanic
 */
public class SearchServiceMechanic extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SearchServiceMechanic() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String jspPage = null;
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("user");
		
		MechanicProfileDao dao = new MechanicProfileDaoImpl();
		ArrayList<MechanicProfile> allMechanics = dao.searchMechanic(email);
		String message = null;
		if (allMechanics.size() > 0) {
			message = "";
			jspPage = "./mechanicDetails.jsp";
		} else {
			message = "Mechanics not found <a href='./addMechanic.jsp'><u>add Mechanic </u></a>";
			jspPage = "./mechanicDetails.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(jspPage);
		request.setAttribute("allMechanics", allMechanics);
		request.setAttribute("message", message);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
