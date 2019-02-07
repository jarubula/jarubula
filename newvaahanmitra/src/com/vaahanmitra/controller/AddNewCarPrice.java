package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.AddCarDao;
import com.vaahanmitra.daoImpl.AddCarDaoImpl;
import com.vaahanmitra.model.BikePrice;

/**
 * Servlet implementation class AddNewCarPrice
 */
public class AddNewCarPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewCarPrice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bikeBrand=request.getParameter("brandid");
		String bikeModel=request.getParameter("carModel");
		String makeYear=request.getParameter("makeYear");
		String variant=request.getParameter("variantName");
		
		HttpSession hs=request.getSession();
		String userid=hs.getAttribute("user").toString();
		
		String price[]=request.getParameterValues("price");
		String itemType[]=request.getParameterValues("itemType");
		ArrayList<BikePrice> al=new ArrayList<BikePrice>();
		
		
		
		
		
		String newbikeid=null;
		String message=null;
		AddCarDao adao=new AddCarDaoImpl();
		boolean flag=false;
		try
		{
			newbikeid=adao.getNewCarId(bikeBrand,bikeModel,variant,makeYear);
			
			
			if(newbikeid==null)
			{
				message="Car Brand, Model Related Info not found.";
			}
			else
			{
				
			   flag=adao.checkexshowroomprice(newbikeid);
				if(flag==true){
				
				for(int i=0;i<price.length;i++)
				{
					BikePrice bp=new BikePrice();
					bp.setPRICE(price[i]);
					bp.setITEM_NAME(itemType[i]);
					bp.setUSER_ID(userid);
					bp.setNEW_VEHICLE_ID(newbikeid);
					al.add(bp);
				}
				al=adao.checkNewCarPrice(al);
				
				
					flag=adao.addNewCarPrice(al);
					if(flag)
					{
						message="Car Price Added Successfully";
					}
					else
					{
						message="Car Price Add failed. Please try Again..";
					}
				}
				
			
				else{
					message="EXSHOWROOM PRICE IS NOT AVALIBLE FOR THIS VARIANT PLEASE CONTACT ADMIN";
				}
			
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/addNewCarPrice.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
