package com.vaahanmitra.controller;

import java.io.IOException;
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
import com.vaahanmitra.model.DriverBean;
import com.vaahanmitra.model.DriverEndUser;
import com.vaahanmitra.model.DriverFeedBack;
import com.vaahanmitra.service.SendEmailToUser;

/**
 * Servlet implementation class DriverBillToUser
 */
public class DriverBillToUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverBillToUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String apptId=request.getParameter("apptId");
		String tripId=request.getParameter("tripId");
		String userEmail=request.getParameter("userId");

		HttpSession session=request.getSession();
		String driverEmail=(String)session.getAttribute("user");
		
		SendEmailToUser userMail=new SendEmailToUser();
		String message=userMail.driverBillToUser(apptId, tripId, driverEmail, userEmail);
		
		DriverDAO ddo=new DriverDAOImpl();
		List<DriverBean> driverBean=ddo.getDriverName(driverEmail);
		
		List<DriverEndUser> driverEndUser=ddo.getDriverEndUserById(apptId);
		
		List<DriverFeedBack> driverBill=ddo.getDriverBill(apptId, tripId);
		
		Iterator driverBeanIt=driverBean.iterator();
		Iterator driverEndUserIt=driverEndUser.iterator();
		Iterator driverBillIt=driverBill.iterator();
		
		DriverBean driverDetails=null;
		DriverEndUser driverEndUserDetails=null;
		DriverFeedBack driverBillDetails=null;
		while(driverBeanIt.hasNext()){
			
			driverDetails=(DriverBean)driverBeanIt.next();
			
		}while(driverEndUserIt.hasNext()){
			
			driverEndUserDetails=(DriverEndUser)driverEndUserIt.next();
			
		}while(driverBillIt.hasNext()){
			
			driverBillDetails=(DriverFeedBack)driverBillIt.next();
		}
		
		
		RequestDispatcher rd=request.getRequestDispatcher("./driverBill.jsp");
		request.setAttribute("driverDetails", driverDetails);
		request.setAttribute("driverEndUserDetails", driverEndUserDetails);
		request.setAttribute("driverBillDetails", driverBillDetails);
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
