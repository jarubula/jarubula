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
import com.vaahanmitra.utilities.VerifyFieldsUtil;

/**
 * Servlet implementation class AdSearchInOwner
 */
public class AdSearchInOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdSearchInOwner() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int page=1,noofRecords=0,numofpages=0,maxrowsperpage=5;
		ArrayList<IndividualOwnerRegister> al=new ArrayList<IndividualOwnerRegister>();
		IndividualOwnerRegister io=new IndividualOwnerRegister();
		io.setSTATUS(new VerifyFieldsUtil().verifyString(request.getParameter("tstate")));
		io.setCITY(new VerifyFieldsUtil().verifyString(request.getParameter("tcity")));
		io.setVEHICAL_TYPE(new VerifyFieldsUtil().verifyString(request.getParameter("mailid")));
		io.setMOBILE_NO(new VerifyFieldsUtil().verifyString(request.getParameter("mobile")));
		IndividualOwnerRegisterDao iodao=new IndividualOwnerRegisterDaoImpl();
		try
		{
			if(request.getParameter("page")!=null)
        	{
        		page=Integer.parseInt(request.getParameter("page"));
        	}
			al=iodao.searchIndividualOwner(io,((page-1)*maxrowsperpage), maxrowsperpage);
			noofRecords=iodao.getNoOfRecords();

			if(noofRecords%maxrowsperpage>0){				
			numofpages=(noofRecords/maxrowsperpage)+1;
			}
			else{
				numofpages=noofRecords/maxrowsperpage;
			}
			System.out.println(al);
		request.setAttribute("IndividualOwnerDetails", al);
		request.setAttribute("numofpages", numofpages);
		request.setAttribute("noofrecords", noofRecords);
		request.setAttribute("currentPage", page);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("./AdSearchInOwner.jsp");
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
