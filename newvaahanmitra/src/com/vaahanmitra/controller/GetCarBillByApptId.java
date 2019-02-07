package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.ServiceCenterDAO;
import com.vaahanmitra.daoImpl.ServiceCenterDAOImpl;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.CarService;
import com.vaahanmitra.model.ServiceEndUser;

/**
 * Servlet implementation class GetCarBillByApptId
 */
public class GetCarBillByApptId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCarBillByApptId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String apptId=request.getParameter("id");
		
		ServiceCenterDAO sdao=new ServiceCenterDAOImpl();
		List<CarService> carService=sdao.getCarServiceDetailsById(apptId);
		
		String message=null;
		List<ServiceEndUser> serviceEndUser=null;
		List<BusinessOwnerRegister> serviceCenter=null;
		if(carService.size()==0){
			
			message="Bill Not Available!.....";
		}
		if(carService!=null && carService.size()>0){	
		CarService serviceCenterId=carService.get(0);
		serviceEndUser=sdao.getServiceEndUserById(apptId);
		serviceCenter=sdao.getServiceCenterByEmail(serviceCenterId.getSERVICE_CENTER_ID());
		}
		RequestDispatcher rd=request.getRequestDispatcher("./displayCarBillByApptId.jsp");
		request.setAttribute("carService", carService);
		request.setAttribute("serviceEndUser", serviceEndUser);
		request.setAttribute("serviceCenter", serviceCenter);
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
