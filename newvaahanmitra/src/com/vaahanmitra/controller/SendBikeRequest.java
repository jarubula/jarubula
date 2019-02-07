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
import com.vaahanmitra.dao.IndividualOwnerRegisterDao;
import com.vaahanmitra.dao.LoginDao;
import com.vaahanmitra.dao.SearchHUsedBikeDAO;
import com.vaahanmitra.dao.UsedBikeDao;
import com.vaahanmitra.daoImpl.BusinessOwnerRegisterDaoImpl;
import com.vaahanmitra.daoImpl.IndividualOwnerRegisterDaoImpl;
import com.vaahanmitra.daoImpl.LoginDaoImpl;
import com.vaahanmitra.daoImpl.SearchHUsedBikeDAOImpl;
import com.vaahanmitra.daoImpl.UsedBikeDaoImpl;
import com.vaahanmitra.exception.BusinessOwnerException;
import com.vaahanmitra.exception.IndividualOwnerException;
import com.vaahanmitra.model.BikeEndUser;
import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.IndividualOwnerRegister;
import com.vaahanmitra.model.UsedBike;
import com.vaahanmitra.service.SendMail;

/**
 * Servlet implementation class SendBikeRequest
 */
public class SendBikeRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendBikeRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = null, mobileNo=null,emailId=null;
		ArrayList<UsedBike> bikeDetails = null;
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
		
		String bikeId = request.getParameter("bikeId");
		String demail = request.getParameter("demail");
		String vehicleType = request.getParameter("vehicleType");
		String dealerName = request.getParameter("dealerName");

		UsedBike bean = new UsedBike();
		String bikeBrand   = request.getParameter("bikeBrand");
		String bikeVariant = request.getParameter("bikeVariant");
		String city = request.getParameter("city");
		String budget = request.getParameter("bikeBudget");
		String bikeModel = request.getParameter("bikeModel");
		// String sellerType=request.getParameter("sellerType");
		String bikeAge = request.getParameter("bikeAge");
		String color = request.getParameter("colors");
		String kms = request.getParameter("kms");
		String owners = request.getParameter("owners");
		String range=request.getParameter("lHPrice");
		bean.setPRICE(range);

		if (bikeAge == null) {
			bikeAge = "";
		}
		bean.setEMAIL_ID(demail);
		bean.setREGISTERED_YEAR(bikeAge);
		// bean.setSELLER_TYPE(sellerType);
		bean.setBIKE_BRAND(bikeBrand);
		bean.setBIKE_MODEL(bikeModel);
		bean.setVARIANT_NAME(bikeVariant);
		bean.setOFFER_PRICE(budget);
		bean.setCITY(city);
		bean.setCOLOR(color);
		bean.setCURRENT_MILEAGE(kms);

		if (owners != null && !owners.equals("null")) {
			bean.setNO_OF_OWNERS(Integer.parseInt(owners));
		}
		
		BikeEndUser endUser = new BikeEndUser();

		SearchHUsedBikeDAO dao = new SearchHUsedBikeDAOImpl();
//		ArrayList<UsedBike> bikeDetails = dao.searchUsedBike(brand);
		int page = 1;
		int maxrowsperpage = 30;
		int noofRecords = 0, numofpages = 0;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if (demail == null || demail.equals("null")) {
			bikeDetails = dao.searchHUsedBike(bean, (page - 1) * maxrowsperpage, maxrowsperpage);
			noofRecords = dao.getNoOfRecords();

			if (noofRecords % maxrowsperpage > 0) {
				numofpages = (noofRecords / maxrowsperpage) + 1;
			}

			else {
				numofpages = noofRecords / maxrowsperpage;
			}
		}

		UsedBikeDao bdao = new UsedBikeDaoImpl();
		UsedBike bike = bdao.getBikeOwnerDetails(bikeId);

		endUser.setNAME(name);
		endUser.setEMAIL(email);
		endUser.setMOBILE_NO(mobileNo);
		endUser.setVEHICLE_TYPE("2");
		/*String url = "http://localhost:8080/Vaahanmitra/showBikeDetails.jsp?bid="+bikeId+"";*/
		String url = "http://vaahanmitra.com/showBikeDetails.jsp?bid="+bikeId+"";

		String toMsg = "Buyer requested for this BIKE ID<a href='" + url + "'> (" + bikeId + ")</a> <br>"
				+ "Buyer Name :" + name + " <br>" + "Mobile No  :" + mobileNo + " <br>" + "Email Id   :" + emailId
				+ " ";
		String fromMsg = "You Requsted to this BIKE  <a href='" + url + "'> (" + bikeId + ") </a> <br>"
				+ "Seller Name :" + bike.getBIKE_OWNER_NAME() + " <br>" + "Mobile No   :" + bike.getMOBILE_NO()
				+ " <br>" + "Email Id    :" + bike.getEMAIL_ID() + "";
		String message = dao.insertUserRequest(endUser, bikeId);
		SendMail.sendMail(bike.getEMAIL_ID(), email, toMsg, fromMsg);
		ArrayList<String> ceu = dao.getRequesters(email);

		RequestDispatcher rd = null;
		if (vehicleType != null && demail != null) {
			bikeDetails = dao.searchHDealerUsedBike(bean, (page - 1) * maxrowsperpage, maxrowsperpage);
			noofRecords = dao.getNoOfRecords();

			if (noofRecords % maxrowsperpage > 0) {
				numofpages = (noofRecords / maxrowsperpage) + 1;
			}

			else {
				numofpages = noofRecords / maxrowsperpage;
			}
			rd = request.getRequestDispatcher("./searchHDealerUsedBike.jsp");
			request.setAttribute("bikerequest", ceu);
			request.setAttribute("email", demail);
			request.setAttribute("bikeDetails", bikeDetails);
			request.setAttribute("bikeVariant", bikeVariant);
			request.setAttribute("name", dealerName);
			request.setAttribute("vehicleType", vehicleType);
			request.setAttribute("message", message);
			request.setAttribute("bikeDetails", bikeDetails);
			request.setAttribute("city", city);
			request.setAttribute("bikeBrand", bikeBrand);
			request.setAttribute("budget", budget);
			request.setAttribute("bikeModel", bikeModel);
			request.setAttribute("bikeAge", bikeAge);
			request.setAttribute("color", color);
			request.setAttribute("kms", kms);
			request.setAttribute("owners", owners);
			request.setAttribute("range", range);
			request.setAttribute("noOfPages", numofpages);
			request.setAttribute("noofrecords", noofRecords);
			request.setAttribute("currentPage", page);
			request.setAttribute("maxrowsperpage", maxrowsperpage);
			rd.forward(request, response);
		} else {
			rd = request.getRequestDispatcher("./searchHUsedBike.jsp");
			request.setAttribute("message", message);
			request.setAttribute("bikerequest", ceu);
			request.setAttribute("bikeId", bikeId);
			request.setAttribute("bikeDetails", bikeDetails);
			request.setAttribute("city", city);
			request.setAttribute("bikeBrand", bikeBrand);
			request.setAttribute("bikeVariant", bikeVariant);
			request.setAttribute("budget", budget);
			request.setAttribute("bikeModel", bikeModel);
			request.setAttribute("bikeAge", bikeAge);
			request.setAttribute("color", color);
			request.setAttribute("kms", kms);
			request.setAttribute("owners", owners);
			request.setAttribute("range", range);
			request.setAttribute("noOfPages", numofpages);
			request.setAttribute("noofrecords", noofRecords);
			request.setAttribute("currentPage", page);
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
