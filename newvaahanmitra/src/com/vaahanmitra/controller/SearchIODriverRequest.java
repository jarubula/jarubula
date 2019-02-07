package com.vaahanmitra.controller;

import java.io.IOException;
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
 * Servlet implementation class SearchIODriverRequest
 */
public class SearchIODriverRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIODriverRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String date=request.getParameter("date");
		String apptId=request.getParameter("apptId");
		String status=request.getParameter("status");
		String userType=request.getParameter("userType");
		
		HttpSession session=request.getSession(false);
		String email=(String)session.getAttribute("user");
		
		DriverDAO ddo=new DriverDAOImpl();
		
		String message=null;
		if(apptId!=null){
		message=ddo.updateDriverRequester(apptId,status);
		}
		
		int page = 1;		
		int maxrowsperpage=30;
		int noofRecords =0,numofpages=0;
			
		 if(request.getParameter("page") != null){
				page = Integer.parseInt(request.getParameter("page"));	
			}
		
		List<DriverEndUser> driverEndUser=ddo.showDriverEndUserToAllDsb(date, email,(page-1)*maxrowsperpage, maxrowsperpage);
		
		noofRecords=ddo.getNoOfRecords();
		if(noofRecords%maxrowsperpage>0){				
		numofpages=(noofRecords/maxrowsperpage)+1;
		}
		
		else{
			numofpages=noofRecords/maxrowsperpage;
		}
		String pages="";
		
		if(userType!=null && userType.equals("IO")){
			
			pages="./searchIODriverRequest.jsp";
			
		}else if(userType!=null && userType.equals("SC")){
			
			pages="./searchSCDriverRequest.jsp";
			
		}else if(userType!=null && userType.equals("DR")){
			
			pages="./searchDRDriverRequest.jsp";
			
		}else if(userType!=null && userType.equals("UD")){
			
			pages="./searchUDDriverRequest.jsp";
			
		}else if(userType!=null && userType.equals("SP")){
			
			pages="./searchSPDriverRequest.jsp";
			
		}
		RequestDispatcher rd=request.getRequestDispatcher(pages);
		
		request.setAttribute("endUser", driverEndUser);
		request.setAttribute("date", date);
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
