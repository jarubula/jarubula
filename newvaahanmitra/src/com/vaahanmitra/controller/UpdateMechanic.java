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
 * Servlet implementation class UpdateMechanic
 */
public class UpdateMechanic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateMechanic() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		MechanicProfileDao dao = new MechanicProfileDaoImpl();
		String message = dao.updateMechanicProfile(user_name, mechanic);
		if (message.equals("success")) {
			message = "Mechanic profile updated";
		} else {
			message ="PROFILE NOT UPDATED! PLEASE TRY AGAIN!";
		}
		RequestDispatcher rd = request.getRequestDispatcher("./updateMechanic.jsp");
		request.setAttribute("message", message);
		request.setAttribute("eid", mechanic.getEMAIL());
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
