package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.vaahanmitra.model.UserLogin;


/**
 * Servlet implementation class SendMultiDriverRequest
 */
public class SendMultiDriverRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMultiDriverRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
DriverDAO ddo=new DriverDAOImpl();
		
		DriverEndUser driverEndUser=new DriverEndUser();
		driverEndUser.setNAME(request.getParameter("name"));
		driverEndUser.setMOBILE_NO(request.getParameter("mobileNo"));
		driverEndUser.setAPPOINTMENT_DATE(request.getParameter("apptDate"));
		driverEndUser.setAPPOINTMENT_TIME(request.getParameter("apptTime"));
		driverEndUser.setDRIVER_EMAIL(request.getParameter("driverMail"));
		driverEndUser.setADDRESS(request.getParameter("address"));
		driverEndUser.setDESTINATION(request.getParameter("destination"));
		String email=request.getParameter("email");
		
		String driverId=request.getParameter("driverId");
		
		List<String> list=new ArrayList<String>();
		
		String[] id=driverId.split(",");
		
		for(int i=0;i<id.length;i++){
			DriverBean dId=ddo.getDriverDetailsById(id[i]);
			
			list.add(dId.getEMAIL());
		}
		
		
		
		
		HttpSession userSession=request.getSession();
		String userEmail=(String)userSession.getAttribute("user");
		
		if(userEmail!=null){
			driverEndUser.setEMAIL(userEmail);
		}else{
			driverEndUser.setEMAIL(email);
		}
		
		
		UserLogin login=new UserLogin();
		login.setEMAIL_ID(email);
		login.setPASSWORD(request.getParameter("psw"));
//		login.setREFERENCE_ID(request.getParameter("avlId"));
		
		String message=null;
		
		List<String> loginDetails=ddo.getLoginDetails(email);
		
		if(userEmail==null && loginDetails.size()!=0 && !loginDetails.get(1).equals(request.getParameter("psw"))){
			
			message="Please enter correct password";
		}
		
		
		if(userEmail==null && message==null && loginDetails.size()!=0 && loginDetails.get(2).equals("ACTIVE")){
			
//			userSession.setAttribute("user", email);
			
		}
		
		
		if(message==null){
		message=ddo.insertMultiDriverRequest(driverEndUser,login,list);
		}
		
/*		
		String fromCity=request.getParameter("fromCity");
		String toCity=request.getParameter("toCity");
		String date=request.getParameter("date");
		String time=request.getParameter("time");*/
		
//		ArrayList<DriverBean> driverAl=ddo.searchHOnDemandDriver(fromCity, toCity, date,time);
		
		RequestDispatcher rd=request.getRequestDispatcher("./displayDriver.jsp");
		/*request.setAttribute("driverAl", driverAl);
		request.setAttribute("fromCity", fromCity);
		request.setAttribute("toCity", toCity);
		request.setAttribute("date", date);
		request.setAttribute("time", time);*/
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
