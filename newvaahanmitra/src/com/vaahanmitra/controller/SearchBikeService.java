package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.ServiceCenterDAO;
import com.vaahanmitra.daoImpl.ServiceCenterDAOImpl;
import com.vaahanmitra.model.ServiceEndUser;

/**
 * Servlet implementation class SearchBikeService
 */
public class SearchBikeService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBikeService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String apptId=request.getParameter("apptId");
		String bikeNo=request.getParameter("bikeNo");
		
		HttpSession userSession=request.getSession(false);
		String email=(String)userSession.getAttribute("user");
		
		ServiceCenterDAO sdao=new ServiceCenterDAOImpl();
		
		int page = 1;		
		int maxrowsperpage=30;
		int noofRecords =0,numofpages=0;
			
		 if(request.getParameter("page") != null){
				page = Integer.parseInt(request.getParameter("page"));	
			}
		
		List<ServiceEndUser> serviceEndUser=sdao.searchBikeService(apptId, bikeNo, email,(page-1)*maxrowsperpage, maxrowsperpage);
		
		noofRecords=sdao.getNoOfRecords();
		if(noofRecords%maxrowsperpage>0){				
		numofpages=(noofRecords/maxrowsperpage)+1;
		}
		
		else{
			numofpages=noofRecords/maxrowsperpage;
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("./searchBikeService.jsp");
		request.setAttribute("serviceEndUser", serviceEndUser);
		request.setAttribute("apptId", apptId);
		request.setAttribute("bikeNo", bikeNo);
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
