package com.vaahanmitra.controller;

import java.io.IOException;

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
 * Servlet implementation class AddMechanicController
 */
public class AddMechanicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddMechanicController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MechanicProfile mechanic = new MechanicProfile();
		mechanic.setNAME(request.getParameter("name"));
		mechanic.setEMAIL(request.getParameter("emailId"));
		mechanic.setMOBILE_NO(request.getParameter("phoneNo"));
		mechanic.setQUALIFICATION(request.getParameter("qualification"));
		mechanic.setADDRESS(request.getParameter("address"));
		mechanic.setCITY(request.getParameter("city"));
		mechanic.setSTATE(request.getParameter("state1"));
		mechanic.setDISTRICT(request.getParameter("district1"));
		mechanic.setPINCODE(request.getParameter("pincodeNo"));
		mechanic.setEXPERIENCE(request.getParameter("experience"));
		mechanic.setSPECIALIZED_IN(request.getParameter("specilzed"));
		mechanic.setBRAND_NAME(request.getParameter("brandName"));
		mechanic.setEXPERIENCE_WITH_COMPANIES(request.getParameter("expCompanies"));
		mechanic.setWORKED_IN_COMPANIES(request.getParameter("workedCompanies"));
		mechanic.toString();
		HttpSession session = request.getSession(false);
		String user_name = (String) session.getAttribute("user");
		String email = request.getParameter("emailId");
		MechanicProfileDao dao = new MechanicProfileDaoImpl();
		Boolean existEmail = dao.getEmail(email);
		if (existEmail == true) {
			String message = " Emailld already registered ";
			RequestDispatcher rd = request.getRequestDispatcher("./addMechanic.jsp");
			request.setAttribute("success", message);
			rd.forward(request, response);
		} else {
//			String message = dao.addMechanic(mechanic, user_name);
			String message = new MechanicProfileDaoImpl().addMechanic1(mechanic, user_name);
			if (message.equals("success")) {
				message = "Mechanic added successfully!";
				RequestDispatcher rd = request.getRequestDispatcher("./successServiceMechanicProfile.jsp");
				request.setAttribute("success", message);
				rd.forward(request, response);
			} else {
				message = "Mechanic Not added! Please try again!";
				RequestDispatcher rd = request.getRequestDispatcher("./addMechanic.jsp");
				request.setAttribute("success", message);
				rd.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
