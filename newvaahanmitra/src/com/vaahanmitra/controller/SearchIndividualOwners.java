package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.IndividualOwnerRegisterDao;
import com.vaahanmitra.daoImpl.IndividualOwnerRegisterDaoImpl;
import com.vaahanmitra.model.IndividualOwnerRegister;

/**
 * Servlet implementation class SearchIndividualOwners
 */
public class SearchIndividualOwners extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIndividualOwners() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String key=request.getParameter("k");
		String status=null,returnstring=null;
		int page=1,noofRecords=0,numofpages=0,maxrowsperpage=5;
		String pagename="./SearchIndividualOwnerDetails.jsp",bcity=null,bname=null;
		ArrayList<IndividualOwnerRegister> al=new ArrayList<IndividualOwnerRegister>();
		IndividualOwnerRegister bo=new IndividualOwnerRegister();
		IndividualOwnerRegisterDao bodao=new IndividualOwnerRegisterDaoImpl();
		boolean b=false;
		System.out.println(key);
		try
		{
			if(request.getParameter("page")!=null)
        	{
        		page=Integer.parseInt(request.getParameter("page"));
        	}
			
			if(request.getParameter("bcity").equals("City") || request.getParameter("bcity").equals("All"))
			{}
			else
			{
				bo.setCITY(request.getParameter("bcity"));
			}
			if(request.getParameter("vehicletype").equals("Vehicle Type") || request.getParameter("vehicletype").equals("All"))
			{}
			else
			{
				bo.setVEHICAL_TYPE(request.getParameter("vehicletype"));
			}	
			
			al=bodao.searchIndividualOwner(bo,((page-1)*maxrowsperpage), maxrowsperpage);
			noofRecords=bodao.getNoOfRecords();
			System.out.println("No of Recordds :: "+noofRecords);
			if(noofRecords%maxrowsperpage>0){				
			numofpages=(noofRecords/maxrowsperpage)+1;
			}
			else{
				numofpages=noofRecords/maxrowsperpage;
			}
			System.out.println(al);
		request.setAttribute("individualOwnerDetails", al);
		request.setAttribute("numofpages", numofpages);
		request.setAttribute("noofrecords", noofRecords);
		request.setAttribute("currentPage", page);
		request.setAttribute("returnstring", returnstring);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher(pagename);
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
