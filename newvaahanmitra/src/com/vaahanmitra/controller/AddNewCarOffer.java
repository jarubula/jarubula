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
import com.vaahanmitra.model.VehicleOffer;

/**
 * Servlet implementation class AddNewCarOffer
 */
public class AddNewCarOffer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewCarOffer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
ArrayList<VehicleOffer> al=new ArrayList<VehicleOffer>();
		
		String carBrand=request.getParameter("brandid");
		String carModel=request.getParameter("carModel");
		String makeYear=request.getParameter("makeYear");
		String variant=request.getParameter("variantName");
		
		HttpSession hs=request.getSession();
		String userid=hs.getAttribute("user").toString();
		
		String[] offerName=request.getParameterValues("offerName");
		String[] offerPrice=request.getParameterValues("offerPrice");
		String[] description=request.getParameterValues("description");
		
		String newbikeid=null;
		String message=null;
		AddCarDao adao=new AddCarDaoImpl();
		
		boolean flag=false;
		try
		{
			newbikeid=adao.getNewCarId(carBrand,carModel,variant,makeYear);
			if(newbikeid==null)
			{
				message="Car Brand, Model Related Info not found.";
			}
			else
			{
				for(int i=0;i<offerPrice.length;i++)
				{
					VehicleOffer vo=new VehicleOffer();
					vo.setNEW_VEHICLE_ID(newbikeid);
					vo.setPRICE(offerPrice[i]);
					vo.setOFFER_NAME(offerName[i]);
					vo.setDESCRIPTION(description[i]);
					vo.setUSER_ID(userid);
					al.add(vo);
				}
				al=adao.checkNewCarOffer(al);
				if(flag)
				{
					message="Offer already added. Want to Update?";
				}
				else
				{
					flag=adao.addNewCarOffer(al);
					if(flag)
					{
						message="Car Offer(s) Added Successfully";
					}
					else
					{
						message="Car Offer(s) Add failed. Please try Again..";
					}
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/newCarOffers.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
