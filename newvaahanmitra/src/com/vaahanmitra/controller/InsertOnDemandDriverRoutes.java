package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.DriverDAO;
import com.vaahanmitra.daoImpl.DriverDAOImpl;
import com.vaahanmitra.model.OnDemandDriverRoutes;

/**
 * Servlet implementation class InsertOnDemandDriverRoutes
 */
public class InsertOnDemandDriverRoutes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertOnDemandDriverRoutes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OnDemandDriverRoutes driverRoutes=new OnDemandDriverRoutes();
		driverRoutes.setFROM_STATE(request.getParameter("fromState"));
		driverRoutes.setTO_STATE(request.getParameter("toState"));
		driverRoutes.setFROM_CITY(request.getParameter("fromCity"));
		driverRoutes.setTO_CITY(request.getParameter("toCity"));
		driverRoutes.setDATE(request.getParameter("date"));
		driverRoutes.setTIME(request.getParameter("time"));
		
		HttpSession userSession=request.getSession();
		String email=(String)userSession.getAttribute("user");
		
		driverRoutes.setONDEMAND_ID(email);
		
		DriverDAO ddo=new DriverDAOImpl();
		String message=ddo.InsertOnDemandDriverRoutes(driverRoutes);
		
		RequestDispatcher rd=null;
		
		if(message!=null){
			
			rd=request.getRequestDispatcher("./onDemanddriverPreRtsMsg.jsp");
			request.setAttribute("message", message);
			rd.forward(request, response);
			
		}else{
			String message1="for some technical problem data has not inserted please try once again";
			rd=request.getRequestDispatcher("./OnDemandPreferredRoutes.jsp");
			request.setAttribute("message", message1);
			rd.forward(request, response);
			
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
