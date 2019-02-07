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
import com.vaahanmitra.model.VehicleOffer;

/**
 * Servlet implementation class AddNewBikeOffer
 */
public class AddNewBikeOffer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewBikeOffer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<VehicleOffer> al=new ArrayList<VehicleOffer>();
		
		String bikeBrand=request.getParameter("bikeBrand");
		String bikeModel=request.getParameter("bikeModel");
		String makeYear=request.getParameter("makeYear");
		String variant=request.getParameter("variantName");
		
		HttpSession hs=request.getSession();
		String userid=hs.getAttribute("user").toString();
		
		String[] offerName=request.getParameterValues("offerName");
		String[] offerPrice=request.getParameterValues("offerPrice");
		String[] description=request.getParameterValues("description");
		/*
		 * vo.setPRICE(request.getParameter("offerPrice"));
		 * vo.setOFFER_NAME(request.getParameter("offerName"));
		vo.setDESCRIPTION(request.getParameter("description"));*/
		
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
				al=adao.checkNewBikeOffer(al);
				if(flag)
				{
					message="Offer already added. Want to Update?";
				}
				else
				{
					flag=adao.addNewBikeOffer(al);
					if(flag)
					{
						message="Bike Offer Added Successfully";
					}
					else
					{
						message="Bike Offer Add failed. Please try Again..";
					}
				}
			}
		}catch(Exception e)	
		{
			e.printStackTrace();
		}
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/newBikeOffers.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
