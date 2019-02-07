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
 * Servlet implementation class GetIndividualOwnerActina
 */
public class GetIndividualOwnerActina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetIndividualOwnerActina() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page=1,noofRecords=0,numofpages=0,maxrowsperpage=5;
		String pagename=null,status=null,returnstring=null;
		boolean b=false;
		ArrayList<IndividualOwnerRegister> al=new ArrayList<IndividualOwnerRegister>();
		IndividualOwnerRegister io=new IndividualOwnerRegister();
		IndividualOwnerRegisterDao iodao=new IndividualOwnerRegisterDaoImpl();
		try
		{
			if(request.getParameter("page")!=null)
        	{
        		page=Integer.parseInt(request.getParameter("page"));
        	}
			if(request.getParameter("status")!=null)
        	{
        		status=request.getParameter("status");
        		io.setSTATUS(status);
        		io.setSEQUENTIAL_NO(Integer.parseInt(request.getParameter("sequenceid")));
        		b=iodao.individualOwnerActina(io);
        		if(b)
        		{
        			returnstring="Request Processed...";
        		}
        		else
        		{
        			returnstring="Request Process Failed. Please Try Again..";
        		}	
        	}
			
			al=iodao.getInactiveOwnerDetails(io,((page-1)*maxrowsperpage), maxrowsperpage);
			noofRecords=iodao.getNoOfRecords();
			if(noofRecords%maxrowsperpage>0){				
			numofpages=(noofRecords/maxrowsperpage)+1;
			}
			else{
				numofpages=noofRecords/maxrowsperpage;
			}
			pagename="./IndividualOwnerDetailsAct.jsp";
		request.setAttribute("individualOwnerDetails", al);
		request.setAttribute("numofpages", numofpages);
		request.setAttribute("noofrecords", noofRecords);
		request.setAttribute("currentPage", page);
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
