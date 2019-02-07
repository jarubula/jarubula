package com.vaahanmitra.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.IndividualOwnerRegisterDao;
import com.vaahanmitra.dao.LoginDao;
import com.vaahanmitra.daoImpl.IndividualOwnerRegisterDaoImpl;
import com.vaahanmitra.daoImpl.LoginDaoImpl;
import com.vaahanmitra.model.IndividualOwnerRegister;
import com.vaahanmitra.model.UserInterestedVehicles;

/**
 * Servlet implementation class SearchHSendEnquiries
 */
public class SearchHSendEnquiries extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchHSendEnquiries() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		String emailid=request.getParameter("emailid");
		String password=request.getParameter("password");
		
		String vType       =  request.getParameter("vType");
		String vBrand      =  request.getParameter("vehicleBrand");
		String vModel      =  request.getParameter("vehicleModel");
		String vvariant    =  request.getParameter("vvariant");
		String usertype    =  request.getParameter("usertype");
		String spage       =  request.getParameter("spage");
		String makeyear    =  request.getParameter("makeYear");
		String bodytype    =  request.getParameter("bodyType");
		String color       =  request.getParameter("color");
		String transmision = request.getParameter("transmission");
		String fuel        = request.getParameter("fuelType");
		String budget      = request.getParameter("budget");
		String checkedVehicless="";
		String pCity=null;
		if(request.getParameter("pCity2")==null)
		{
			pCity=request.getParameter("pCity4");
		}
		else
		{
			pCity=request.getParameter("pCity2");
		}
		/*String name=request.getParameter("name");
		String phoneno=request.getParameter("phoneno");
		String city=request.getParameter("city");
		//String checkedVehicles=request.getParameter("vehicleids");
		
		System.out.println("email id :"+emailid);
		System.out.println("Password "+password);
		System.out.println("vType "+vType);
		System.out.println("vBrand "+vBrand);
		System.out.println("vModel "+vModel);
		System.out.println("name "+name);
		System.out.println("phoneno "+phoneno);
		System.out.println("city "+city);
		//System.out.println("checkedVehicles "+checkedVehicles);
*/		
		UserInterestedVehicles uv=new UserInterestedVehicles();
		String checkedVehicles=request.getParameter("vehicleids");
		String checkedVehicles1=request.getParameter("vehicleids1");
		if(checkedVehicles==null || checkedVehicles=="")
		{
			checkedVehicless=checkedVehicles1;
		}
		else
		{
			checkedVehicless=checkedVehicles;
		}
		String userid=null,message=null,page=null;
		HttpSession hs=request.getSession();
		LoginDao dao = new LoginDaoImpl();
		IndividualOwnerRegisterDao rdao=new IndividualOwnerRegisterDaoImpl();
		IndividualOwnerRegister reg = new IndividualOwnerRegister();
		
		reg.setEMAIL_ID(emailid);
		reg.setSTATUS(password);
		reg.setVEHICAL_TYPE(vType);
		if(hs.getAttribute("user")!=null)
		{
			userid=hs.getAttribute("user").toString();
			rdao.sendMailToDealers(checkedVehicless, reg);
			message="Email Sent to Dealers.";
			page="/SearchNewVehicle";
			//System.out.println("Logged in user ");
		}
		else
		{
			message = dao.checkUserAndPwd(emailid, password);
			uv.setUSER_EMAIL_ID(emailid);
			uv.setVEHICLES_SEQ_ID(checkedVehicless);
			uv.setPREFERRED_CITY(pCity);
			uv.setVEHICLE_TYPE(vType);
			if (message.equals("no"))
			{
				if(usertype.equals("old"))
				{
					message="Email ID not found. Please Register to send Enquiry";
				}
				else
				{
				String name=request.getParameter("name");
				String phoneno=request.getParameter("phoneno");
				String city=request.getParameter("city");
				
				reg.setNAME(name);;
				reg.setCITY(city);
				reg.setMOBILE_NO(phoneno);
				message=rdao.addIndividualOwnerFromSearch(reg);
				if(message.equals("true"))
				{
					//rdao.insertUserInterestedVehicles(uv);
					rdao.sendMailToDealers(checkedVehicless,reg);
					message="Thanks For Registering with Vaahanmitra.com. Mail Sent to Dealers.";
				}
				else
				{
					message="Please try again....";
				}
				message="Registered Successfully. Email Sent to Dealers and Verification mail sent to your email id.";
				page="/SearchNewVehicle";
				rdao.sendMailToDealers(checkedVehicless,reg);
				System.out.println("New in user ");
				}
			} 
			else if(message.equals("PI"))
			{
				rdao.sendMailToDealers(checkedVehicless,reg);
				message = "Mail sent to Dealers.<br>EMAIL ID not yet verified! Please verify your Email for Login";
				page="/SearchNewVehicle";
				System.out.println("PI in user ");
				
			} 
			else if(message.equals("yes"))
			{
				message = "WELCOME TO VAAHANMITRA";
				hs.setAttribute("user", emailid);
				rdao.sendMailToDealers(checkedVehicless, reg);
				message="Email Sent to Dealers.";
				page="/SearchNewVehicle";
				System.out.println("Already Registered user ");
			} 
			else if (message.equals("I"))
			{
				message = "EMAIL ID Already Registered with US! Please verify your Email for Login";
				page="/SearchNewVehicle";
				System.out.println("email id verify ");
			} 
			else if(message.equals("P"))
			{
				message ="Password not correct! Please enter Correct...";
				page="/SearchNewVehicle";
				System.out.println("password incorrect");
			}
		}
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/SearchNewVehicle").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
