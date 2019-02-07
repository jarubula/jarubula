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

import com.vaahanmitra.dao.ServiceCenterDAO;
import com.vaahanmitra.daoImpl.ServiceCenterDAOImpl;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.CarService;
import com.vaahanmitra.model.ServiceEndUser;

/**
 * Servlet implementation class CarServiceBill
 */
public class CarServiceBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarServiceBill() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String serviceType[]=request.getParameterValues("serviceType");
		String amount[]=request.getParameterValues("amount");
		String apptId=request.getParameter("apptId");
		String desc[]=request.getParameterValues("desc");
		String discount[]=request.getParameterValues("discount");
		String finalPrice[]=request.getParameterValues("finalPrice");
		String spareParts[]=request.getParameterValues("spareParts");
		String tax[]=request.getParameterValues("tax");
		String compl=request.getParameter("checked");
		String mechanicName=request.getParameter("mechanicName");
		String vehicleType=request.getParameter("vehicleType");
		
		String buttonValue=request.getParameter("submit");
		
		
		HttpSession serviceEmail=request.getSession();
		String email=(String)serviceEmail.getAttribute("user");
		List<CarService> carService=new ArrayList<CarService>();
		
		CarService carService1=null;
		int i=0,j=0,k=0,l=0,m=0,n=0,p=0,q=0;
		for(i=0,j=0,k=0,l=0,m=0,n=0,p=0,q=0;i<serviceType.length || j<amount.length || l<desc.length || m<discount.length || n<finalPrice.length || p<spareParts.length || q<tax.length;i++,j++,k++,l++,m++,n++,p++,q++){
		
		carService1=new CarService();
		carService1.setSERVICE_TYPE(serviceType[i]);
		carService1.setAMOUNT(amount[j]);
		carService1.setDESCRIPTION(desc[l]);
		carService1.setDESCOUNT(discount[m]);
		carService1.setFINAL_PRICE(finalPrice[n]);
		carService1.setTAX(tax[q]);
		if(p<spareParts.length){
		carService1.setSPAREPARTS(spareParts[p]);
		}
		carService.add(carService1);
		
		carService1.setSERVICE_CENTER_ID(email);
		carService1.setAPPOINTMENT_ID(apptId);
		}

		
		String carBill=null;
		List<ServiceEndUser> serviceEndUser=null;
		List<BusinessOwnerRegister> serviceCenter=null;
		if(buttonValue!=null && buttonValue.equals("Submit")){
			
			
			ServiceCenterDAO scdo=new ServiceCenterDAOImpl();
			carBill=scdo.insertCarService(carService,mechanicName,vehicleType);
			serviceEndUser=scdo.getServiceEndUserById(apptId);
			serviceCenter=scdo.getServiceCenterByEmail(email);
			
		}
		RequestDispatcher rd=null;
		if(carBill==null){
		rd=request.getRequestDispatcher("./carServiceBill.jsp");
		request.setAttribute("carService", carService);
		request.setAttribute("apptId", apptId);
		rd.forward(request, response);
		}else{
			
			rd=request.getRequestDispatcher("./printCarBill.jsp");
			request.setAttribute("carService", carService);
			request.setAttribute("serviceEndUser", serviceEndUser);
			request.setAttribute("serviceCenter", serviceCenter);
			request.setAttribute("carBill", carBill);
			request.setAttribute("mechanicName", mechanicName);
			request.setAttribute("vehicleType", vehicleType);
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
