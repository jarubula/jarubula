package com.vaahanmitra.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaahanmitra.dao.AddBikeDao;
import com.vaahanmitra.daoImpl.AddBikeDaoImpl;
import com.vaahanmitra.model.BikePrice;

/**
 * Servlet implementation class AddNewBikePrice
 */
public class AddNewBikePrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewBikePrice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<BikePrice> al=new ArrayList<BikePrice>();
		String bikeBrand=request.getParameter("bikeBrand");
		String bikeModel=request.getParameter("bikeModel");
		String makeYear=request.getParameter("makeYear");
		String variant=request.getParameter("variantName");
		
		String[] price=request.getParameterValues("price");
		String[] itemType=request.getParameterValues("itemType");
		
		HttpSession hs=request.getSession();
		String userid=hs.getAttribute("user").toString();
		
		
		
		String newbikeid=null;
		String message=null;
		AddBikeDao adao=new AddBikeDaoImpl();
		boolean flag=false;
		try
		{
			newbikeid=adao.getNewBikeId(bikeBrand,bikeModel,variant,makeYear);
			if(newbikeid==null)
			{
				message="Bike Brand, Model Related Info not found.";
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
				
					flag=adao.addNewBikePrice(al);
					if(flag)
					{
						message="Bike Price Added Successfully";
					}
					else
					{
						message="Bike Price Add failed. Please try Again..";
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
		getServletContext().getRequestDispatcher("/addNewBikePrice.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
