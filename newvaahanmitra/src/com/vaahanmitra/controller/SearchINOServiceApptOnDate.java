package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.MechanicDao;
import com.vaahanmitra.daoImpl.MechanicDaoImpl;
import com.vaahanmitra.model.ServiceEndUser;

/**
 * Servlet implementation class SearchINOServiceApptOnDate
 */
public class SearchINOServiceApptOnDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchINOServiceApptOnDate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String date1=request.getParameter("fdate");
		String date2=request.getParameter("sdate");
		String userType=request.getParameter("userType");
		
		HttpSession userSession=request.getSession(false);
		String email=(String)userSession.getAttribute("user");
		
		MechanicDao mdao=new MechanicDaoImpl();
		
		int page = 1;		
		int maxrowsperpage=30;
		int noofRecords =0,numofpages=0;
			
		 if(request.getParameter("page") != null){
				page = Integer.parseInt(request.getParameter("page"));	
			}
		
		ArrayList<ServiceEndUser> endUserDetails=mdao.showServiceEndUserToAllDsb(date1, date2,email,(page-1)*maxrowsperpage, maxrowsperpage);
		
		noofRecords=mdao.getNoOfRecords();
		if(noofRecords%maxrowsperpage>0){				
		numofpages=(noofRecords/maxrowsperpage)+1;
		}
		
		else{
			numofpages=noofRecords/maxrowsperpage;
		}
		
		String pages="";
		if(userType!=null && userType.equals("IO")){
			
			pages="./searchINOServiceApptOnDate.jsp";
			
		}else if(userType!=null && userType.equals("SC")){
			
			pages="./searchSCServiceApptOnDate.jsp";
			
		}else if(userType!=null && userType.equals("DR")){
			
			pages="./searchDriverServiceAppt.jsp";
			
		}else if(userType!=null && userType.equals("UD")){
			
			pages="./searchUDServiceApptOnDate.jsp";
			
		}else if(userType!=null && userType.equals("SP")){
			
			pages="./searchSPServiceApptOnDate.jsp";
			
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(pages);
		request.setAttribute("endUserDetails", endUserDetails);
		request.setAttribute("fdate", date1);
		request.setAttribute("sdate", date2);
		request.setAttribute("userType", userType);
		request.setAttribute("noOfPages", numofpages);
		request.setAttribute("noofrecords", noofRecords);
		request.setAttribute("currentPage", page);
		request.setAttribute("maxrowsperpage", maxrowsperpage);
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
