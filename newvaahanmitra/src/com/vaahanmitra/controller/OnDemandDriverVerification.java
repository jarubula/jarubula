package com.vaahanmitra.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.DriverDAO;
import com.vaahanmitra.daoImpl.DriverDAOImpl;
import com.vaahanmitra.model.DriverEndUser;

/**
 * Servlet implementation class OnDemandDriverVerification
 */
public class OnDemandDriverVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnDemandDriverVerification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String apptId=request.getParameter("email");

		DriverDAO ddao=new DriverDAOImpl();
		
		String message=ddao.driverEndUserVerification(apptId);
		
		List<DriverEndUser> endUserList=null;
		List<String> driverDetails=null;
		DriverEndUser email=null;
		if(message!=null){
		
		endUserList= ddao.getDriverEndUserById(apptId);
		Iterator it=endUserList.iterator();
		while(it.hasNext()){
			
			email=(DriverEndUser)it.next();
		}
		
		driverDetails= ddao.getDriverByEmail(email.getDRIVER_EMAIL());
		}
		
		if(message!=null){
			
			HttpSession sverifiedSession=request.getSession();
			
			sverifiedSession.setAttribute("user", email.getEMAIL());
			
		}else{
			message="because of some technical problem your email is not verified please try once again";
		}
		
		
		RequestDispatcher rd=request.getRequestDispatcher("./DriverEndUseremailVerifiedMsg.jsp");
		request.setAttribute("driverDetails", driverDetails);
		request.setAttribute("endUserList", endUserList);
		request.setAttribute("message", message);
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
