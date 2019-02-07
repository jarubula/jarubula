package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.message.EmptyMessageImpl;
import com.vaahanmitra.dao.EmployeeDao;
import com.vaahanmitra.daoImpl.EmployeeDaoImpl;
import com.vaahanmitra.model.EmployeeBean;
import com.vaahanmitra.model.UserLogin;
import com.vaahanmitra.service.SendMail;

/**
 * Servlet implementation class AdAddEmployee
 */
public class AdAddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdAddEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = null;
		EmployeeBean bean = new EmployeeBean();
		UserLogin login = new UserLogin();
		bean.setFIRST_NAME(request.getParameter("fname"));
		bean.setLAST_NAME(request.getParameter("lname"));
		bean.setDOB(request.getParameter("dob"));
		bean.setGENDER(request.getParameter("gender"));
		bean.setEMAIL_ID(request.getParameter("emailId"));
		bean.setMOBILE_NO(request.getParameter("mobileNo"));
		bean.setADHAR_NO(request.getParameter("adharNo"));
		bean.setPANCARD_NO(request.getParameter("pancardNo"));
		bean.setADDRESS(request.getParameter("address"));
		bean.setCITY(request.getParameter("city"));
		bean.setSTATE(request.getParameter("country"));
		bean.setDISTRICT(request.getParameter("state"));
		bean.setPINCODE(request.getParameter("pincode"));
//		bean.setDIVISION(request.getParameter("division"));
//		bean.setD_STATE(request.getParameter("dstate"));
		
		String division="";
		String divisions[] = request.getParameterValues("division");
		if(divisions!=null){
			for(int i=0;i<divisions.length;i++){
				division+=divisions[i]+",";
				bean.setDIVISION(division);
			}	
		}else{
			bean.setDIVISION(division);
		}
		String state="";
		String dstate[] = request.getParameterValues("dstate");
		if(dstate!=null){
			for(int i=0;i<dstate.length;i++){
				state+=dstate[i]+",";
				bean.setDSTATE(state);
			}
		}else{
			bean.setDSTATE(state);
		}
		String email = request.getParameter("emailId");
		
		login.setEMAIL_ID(request.getParameter("emailId"));
//		login.setPASSWORD(request.getParameter("password"));
		login.setUSER_TYPE("EM");
		login.setSTATUS("INACTIVE");
		
		EmployeeDao dao = new EmployeeDaoImpl();

		String checkEmail = dao.checkEmployee(email);
		if(checkEmail.equals("true")){
			message ="Email id alredy avilable with US!";
		}else{
			message = dao.addEmployee(bean,login);
			String url = "http://localhost:8080/Vaahanmitra1.0/resetPassword.jsp?eid="+email+"";
			String textMsg = "Thank you for registering with Us. Your Login Credentials Username : "+email+" .Please cilck the link for <a href='" + url+ "'> Password </a>";
			SendMail.send(email,textMsg);
		}
		RequestDispatcher rd = request.getRequestDispatcher("./adAddEmployee.jsp");
		request.setAttribute("message", message);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
