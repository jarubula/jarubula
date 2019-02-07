package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.EmployeeDao;
import com.vaahanmitra.daoImpl.EmployeeDaoImpl;
import com.vaahanmitra.model.EmployeeBean;


public class AdAssignRoleToEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdAssignRoleToEmployee() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EmployeeBean bean = new EmployeeBean();
		
		String employeeId = request.getParameter("employeeId");
		bean.setEMAIL_ID(employeeId);
		
		String division="";
		String divisions[] = request.getParameterValues("division");
		if(divisions!=null){
			for(int i=0;i<divisions.length;i++){
				division+=divisions[i]+",";
				bean.setASSIGN_ROLE(division);
			}	
		}else{
			bean.setDIVISION(division);
		}
		bean.setPROFILE_VIEW(request.getParameter("view"));
		bean.setSTATUS(request.getParameter("status"));
		
		String report="";
		String reports[] = request.getParameterValues("reports");
		if(reports!=null){
			for(int i=0;i<reports.length;i++){
				report+=reports[i]+",";
				bean.setREPORTS(report);
			}	
		}else{
			bean.setREPORTS(report);
		}
		EmployeeDao dao = new EmployeeDaoImpl();
		String message = dao.assignRole(bean);
		if(message.equals("success")){
			message = "Assigned role to employee";
		}else{
			message = "Not assigend try again";
		}
		RequestDispatcher rd = request.getRequestDispatcher("./updateAdEmployee.jsp");
		request.setAttribute("message", message);
		request.setAttribute("empId", employeeId);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}