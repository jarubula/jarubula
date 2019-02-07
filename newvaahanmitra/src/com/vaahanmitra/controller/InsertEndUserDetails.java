package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaahanmitra.dao.CarDAO;
import com.vaahanmitra.dao.IndividualOwnerRegisterDao;
import com.vaahanmitra.daoImpl.CarDAOImpl;
import com.vaahanmitra.daoImpl.IndividualOwnerRegisterDaoImpl;
import com.vaahanmitra.model.CarEndUser;
import com.vaahanmitra.model.IndividualOwnerRegister;
import com.vaahanmitra.model.UsedCar;
import com.vaahanmitra.model.UserLogin;
import com.vaahanmitra.service.SendMail;

/**
 * Servlet implementation class InsertEndUserDetails
 */
public class InsertEndUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertEndUserDetails() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsppage = null,message=null;
		IndividualOwnerRegister registration = new IndividualOwnerRegister();
		response.setContentType("text/html");

		CarEndUser endUser = new CarEndUser();
		
		endUser.setNAME(request.getParameter("name"));
		endUser.setEMAIL(request.getParameter("email"));
		endUser.setMOBILE_NO(request.getParameter("mobileNo"));
		endUser.setVEHICLE_TYPE(request.getParameter("vehicleType"));
		endUser.setPASSWORD(request.getParameter("password"));

		String carId = request.getParameter("carId");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobileNo = request.getParameter("mobileNo");
		String password = request.getParameter("password");
		CarDAO cdao = new CarDAOImpl();

		registration.setUSER_TYPE("IO");
		registration.setNAME(request.getParameter("name"));
		registration.setMOBILE_NO(request.getParameter("mobileNo"));
		registration.setEMAIL_ID(request.getParameter("email"));
		registration.setPASSWORD(request.getParameter("password"));
		registration.setSTATUS("INACTIVE");
		registration.toString();
		UserLogin login = new UserLogin();
		login.setEMAIL_ID(request.getParameter("email"));
		login.setPASSWORD(request.getParameter("password"));
		login.setUSER_TYPE("IO");
		login.setSTATUS("INACTIVE");
		String demail = request.getParameter("demail");

		IndividualOwnerRegisterDao dao = new IndividualOwnerRegisterDaoImpl();
		if (demail == null) {
			message = dao.checkEmailStatus(email, carId, mobileNo, name);
			if (message.equals("no")) {
				String url = "http://vaahanmitra.com/VerifyEmailController?cid=" + carId + "&eid=" + email
						+ "&mno=" + mobileNo + "&nm=" + name + "";
//				message = dao.addOwner(registration, login);
				message = cdao.insertEndUserDetails(endUser, carId);
				message = "Your request has been sent on CAR (" + carId + ")! Please verify your Email Id";
				String textMsg = "Thank you for Registring with Vaahanmitra! Please " + " <a href='" +url+ "'> verify your Email</a>";
				SendMail.send(email, textMsg);
			}
		}else{
			message = dao.checkDEmailStatus(email,demail,carId, mobileNo, name);
			if (message.equals("no")) {
				String url = "http://vaahanmitra.com/VerifyDCEmail?cid=" + carId + "&eid=" + email
						+ "&mno=" + mobileNo + "&nm=" + name + "&de="+demail+"";
				message = dao.addOwner(registration, login);
				message = cdao.insertEndUserDetails(endUser, carId);
				message = "Your request has been sent on CAR (" + carId + ")! Please verify your Email Id";
				String textMsg = "Thank you for Registering with Vaahanmitra! Please " + " <a href='" + url
						+ "'> verify your Email</a>";
				SendMail.send(email, textMsg);
			}
		}
		UsedCar bean = new UsedCar();
		
		
		String city=request.getParameter("city");
		String budget=request.getParameter("carBudget");
//		String sellerType=request.getParameter("sellerType");
		String carAge=request.getParameter("carAge");
		String color=request.getParameter("colors");
		String fuelType=request.getParameter("fuelType");
		String kms=request.getParameter("kms");
		String transmission=request.getParameter("transmission");
		String owners=request.getParameter("owners");
		String range=request.getParameter("lHPrice");
		String carBrand = request.getParameter("carBrand");
		String carModel = request.getParameter("carModel");
		String carVariant = request.getParameter("carVariant");
		bean.setTRANSIMISSION(request.getParameter("transmission"));
		String bodyType=request.getParameter("bodyType");

		String vehicleType = request.getParameter("vehicleType");
		String dname = request.getParameter("dname");
		
		bean.setPRICE(range);
		bean.setEMAIL_ID(demail);
		bean.setCAR_BRAND(carBrand);
		bean.setCAR_MODEL(carModel);
		bean.setVARIANT_NAME(carVariant);
		bean.setOFFER_PRICE(budget);
		bean.setCITY(city);
		bean.setREGISTERED_YEAR(carAge);
		bean.setCOLOR(color);
		bean.setFUEL_TYPE(fuelType);
		bean.setCURRENT_MILEAGE(kms);
		bean.setBODY_TYPE(bodyType);
		
		if (owners != null) {
			bean.setNO_OF_OWNERS(Integer.parseInt(owners));
		}
		int page = 1;
		int maxrowsperpage = 30;
		int noofRecords = 0, numofpages = 0;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if (demail == null) {
			ArrayList<UsedCar> carDetails=cdao.searchHUsedCar(bean,(page-1)*maxrowsperpage, maxrowsperpage);
//			ArrayList<UsedCar> carDetails = cdao.searchHUsedCar(bean);
			noofRecords = cdao.getNoOfRecords();
			if (noofRecords % maxrowsperpage > 0) {
				numofpages = (noofRecords / maxrowsperpage) + 1;
			}
			else {
				numofpages = noofRecords / maxrowsperpage;
			}
			jsppage = "./searchHUsedCar.jsp";
			// request.setAttribute("message", msg);
			request.setAttribute("name", name);
			request.setAttribute("carId", carId);
			request.setAttribute("carDetails", carDetails);
			request.setAttribute("city", city);
			request.setAttribute("carBrand", carBrand);
			request.setAttribute("budget", budget);
			request.setAttribute("carModel", carModel);
			request.setAttribute("carVariant", carVariant);
			request.setAttribute("range", range);
			request.setAttribute("noOfPages", numofpages);
			request.setAttribute("noofrecords", noofRecords);
			request.setAttribute("currentPage", page);
			request.setAttribute("maxrowsperpage", maxrowsperpage);
			request.setAttribute("bodyType", bodyType);
		} else {
			
			ArrayList<UsedCar> carDetails = cdao.searchHDealerUsedCar(bean,(page-1)*maxrowsperpage, maxrowsperpage);
			noofRecords = cdao.getNoOfRecords();
			if (noofRecords % maxrowsperpage > 0) {
				numofpages = (noofRecords / maxrowsperpage) + 1;
			}
			else {
				numofpages = noofRecords / maxrowsperpage;
			}
			jsppage = "./searchHDealerUsedCar.jsp";
			request.setAttribute("carDetails", carDetails);
			request.setAttribute("city", city);
			request.setAttribute("demail", demail);
			request.setAttribute("carBrand", carBrand);
			request.setAttribute("budget", budget);
			request.setAttribute("carModel", carModel);
			request.setAttribute("carVariant", carVariant);
			request.setAttribute("email", demail);
			request.setAttribute("name", dname);
			request.setAttribute("vehicleType", vehicleType);
			request.setAttribute("noOfPages", numofpages);
			request.setAttribute("noofrecords", noofRecords);
			request.setAttribute("currentPage", page);
			request.setAttribute("maxrowsperpage", maxrowsperpage);
			request.setAttribute("bodyType", bodyType);
		}
		RequestDispatcher rd = request.getRequestDispatcher(jsppage);
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
