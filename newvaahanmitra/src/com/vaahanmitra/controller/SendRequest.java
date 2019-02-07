package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.BusinessOwnerRegisterDao;
import com.vaahanmitra.dao.CarDAO;
import com.vaahanmitra.dao.IndividualOwnerRegisterDao;
import com.vaahanmitra.dao.LoginDao;
import com.vaahanmitra.dao.UsedCarDao;
import com.vaahanmitra.daoImpl.BusinessOwnerRegisterDaoImpl;
import com.vaahanmitra.daoImpl.CarDAOImpl;
import com.vaahanmitra.daoImpl.IndividualOwnerRegisterDaoImpl;
import com.vaahanmitra.daoImpl.LoginDaoImpl;
import com.vaahanmitra.daoImpl.UsedCarDaoImpl;
import com.vaahanmitra.exception.BusinessOwnerException;
import com.vaahanmitra.exception.IndividualOwnerException;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.CarEndUser;
import com.vaahanmitra.model.IndividualOwnerRegister;
import com.vaahanmitra.model.UsedCar;
import com.vaahanmitra.service.SendMail;

/**
 * Servlet implementation class SendRequest
 */
public class SendRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = null, mobileNo=null,emailId=null;
		UsedCar bean=new UsedCar();
		ArrayList<UsedCar> carDetails = null;
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("user");

		LoginDao login = new LoginDaoImpl();
		String userType = login.getUserType(email);
		if(userType.equals("IO")){
			IndividualOwnerRegisterDao ior = new IndividualOwnerRegisterDaoImpl();
			try {
				IndividualOwnerRegister ior1=new IndividualOwnerRegister();
				ior1 = ior.getDeatils(email);
				name = ior1.getNAME();
				mobileNo = ior1.getMOBILE_NO();
				emailId = ior1.getEMAIL_ID();
			} catch (IndividualOwnerException e) {
				e.printStackTrace();
			}
		}else if(userType.equals("SC") || userType.equals("UD")){
			BusinessOwnerRegisterDao bor = new BusinessOwnerRegisterDaoImpl();
			try {
				BusinessOwnerRegister bor1 = new BusinessOwnerRegister();
				bor1 = bor.getAddressDetails(email);
				name = bor1.getNAME();
				mobileNo = bor1.getMOBILE_NO();
				emailId = bor1.getEMAIL_ID();
			} catch (BusinessOwnerException e) {
				e.printStackTrace();
			}
		}
		/* Dealer email and VehicleType */
		String carId = request.getParameter("carId");
		String carBrand=request.getParameter("carBrand");
		String carVariant=request.getParameter("carVariant");
	
		String city=request.getParameter("city");
		String budget=request.getParameter("carBudget");
		String carModel=request.getParameter("carModel");
//		String sellerType=request.getParameter("sellerType");
		String carAge=request.getParameter("carAge");
		String color=request.getParameter("colors");
		String fuelType=request.getParameter("fuelType");
		String kms=request.getParameter("kms");
		String transmission=request.getParameter("transmission");
		String owners=request.getParameter("owners");
		String range=request.getParameter("lHPrice");
		String bodyType=request.getParameter("bodyType");
		System.out.println("Send Resquest var :"+carBrand+carModel+ carVariant+budget+city);
		String demail = request.getParameter("demail");
		String vehicleType = request.getParameter("vehicleType");
		String dname = request.getParameter("dname");
		
		bean.setEMAIL_ID(demail);
		bean.setREGISTERED_YEAR(carAge);
//		bean.setSELLER_TYPE(sellerType);
		bean.setCAR_BRAND(carBrand);
		bean.setCAR_MODEL(carModel);
		bean.setVARIANT_NAME(carVariant);
		bean.setOFFER_PRICE(budget);
		bean.setCITY(city);
		bean.setCOLOR(color);
		bean.setFUEL_TYPE(fuelType);
		bean.setKMS_DRIVEN(kms);
		bean.setPRICE(range);
		bean.setBODY_TYPE(bodyType);

		if(owners!=null){
		bean.setNO_OF_OWNERS(Integer.parseInt(owners));
		}
		bean.setTRANSIMISSION(transmission);

		int page = 1;
		int maxrowsperpage = 30;
		int noofRecords = 0, numofpages = 0;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		CarDAO cdao = new CarDAOImpl();
		if (demail == null || demail.equals("null")) {
			carDetails = cdao.searchHUsedCar(bean, (page - 1) * maxrowsperpage, maxrowsperpage);
		}
		noofRecords = cdao.getNoOfRecords();
		if (noofRecords % maxrowsperpage > 0) {
			numofpages = (noofRecords / maxrowsperpage) + 1;
		}
		else {
			numofpages = noofRecords / maxrowsperpage;
		}
		
//		ArrayList<UsedCar> carDetails = cdao.searchHUsedCar(brand);

		UsedCarDao dao = new UsedCarDaoImpl();

		UsedCar car = dao.getCarOwnerDetails(carId);
		CarEndUser endUser = new CarEndUser();
		endUser.setNAME(name);
		endUser.setEMAIL(email);
		endUser.setMOBILE_NO(mobileNo);
		endUser.setVEHICLE_TYPE("4");
		String url = "http://vaahanmitra.com/ShowCarDetails?cid="+carId+"";

		String toMsg = "Buyer requested for this CAR ID<a href='" + url + "'> (" + carId + ")</a> <br>" + "Buyer Name :"
				+ name + " <br>" + "Mobile No  :" + mobileNo + " <br>" + "Email Id   :" + emailId + " ";
		String fromMsg = "You Requsted to this CAR  <a href='" + url + "'> (" + carId + ") </a> <br>" + "Seller Name :"
				+ car.getCAR_OWNER_NAME() + " <br>" + "Mobile No   :" + car.getMOBILE_NO() + " <br>" + "Email Id    :"
				+ car.getEMAIL_ID() + "";
		String message = cdao.insertUserRequest(endUser, carId);
		SendMail.sendMail(car.getEMAIL_ID(), email, toMsg, fromMsg);
		ArrayList<String> ceu = cdao.getRequesters(email);

		RequestDispatcher rd = null;
		if (vehicleType != null && demail != null) {
			carDetails=cdao.searchHDealerUsedCar(bean,(page-1)*maxrowsperpage, maxrowsperpage);
				rd = request.getRequestDispatcher("./SearchHDealerUsedCar");
				request.setAttribute("carrequest", ceu);
				request.setAttribute("email", demail);
				request.setAttribute("name", dname);
				request.setAttribute("carDetails", carDetails);
				request.setAttribute("message", message);
				request.setAttribute("carId", carId);
				request.setAttribute("city", city);
				request.setAttribute("carBrand", carBrand);
				request.setAttribute("budget", budget);
				request.setAttribute("carModel", carModel);
				request.setAttribute("carVariant", carVariant);
				request.setAttribute("carAge", carAge);
				request.setAttribute("color", color);
				request.setAttribute("fuelType", fuelType);
				request.setAttribute("kms", kms);
				request.setAttribute("transmission", transmission);
				request.setAttribute("range", range);
				request.setAttribute("noOfPages", numofpages);
				request.setAttribute("noofrecords", noofRecords);
				request.setAttribute("currentPage", page);
				request.setAttribute("vehicleType", vehicleType);
				request.setAttribute("bodyType", bodyType);
				request.setAttribute("maxrowsperpage", maxrowsperpage);
				rd.forward(request, response);
		} else {
			rd = request.getRequestDispatcher("./searchHUsedCar.jsp");
			request.setAttribute("message", message);
			request.setAttribute("carDetails", carDetails);
			request.setAttribute("carrequest", ceu);
			request.setAttribute("carId", carId);
			request.setAttribute("city", city);
			request.setAttribute("carBrand", carBrand);
			request.setAttribute("budget", budget);
			request.setAttribute("carModel", carModel);
			request.setAttribute("carVariant", carVariant);
			request.setAttribute("carAge", carAge);
			request.setAttribute("color", color);
			request.setAttribute("fuelType", fuelType);
			request.setAttribute("kms", kms);
			request.setAttribute("transmission", transmission);
			request.setAttribute("range", range);
			request.setAttribute("noOfPages", numofpages);
			request.setAttribute("noofrecords", noofRecords);
			request.setAttribute("currentPage", page);
			request.setAttribute("bodyType", bodyType);
			request.setAttribute("maxrowsperpage", maxrowsperpage);
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
