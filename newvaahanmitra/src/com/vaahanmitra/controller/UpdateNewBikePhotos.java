package com.vaahanmitra.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.vaahanmitra.dao.AddBikeDao;
import com.vaahanmitra.daoImpl.AddBikeDaoImpl;

import Decoder.BASE64Decoder;

@javax.servlet.annotation.MultipartConfig
public class UpdateNewBikePhotos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bikeNo = request.getParameter("bikeNo");
		String page = request.getParameter("page");
		Part photo1=null,photo2 = null, photo3 = null, photo4 = null, photo5 = null, photo6 = null, photo7= null,
				photo8 = null, photo9 = null, photo10 = null, photo11 = null, photo12 = null;
		
		photo1 = request.getPart("photo_1");
		String photo1_1=request.getParameter("photo_1.1");
		photo2 = request.getPart("photo_2");
		String photo2_1=request.getParameter("photo_2.1");
		photo3 = request.getPart("photo_3");
		String photo3_1=request.getParameter("photo_3.1");
		photo4 = request.getPart("photo_4");
		String photo4_1=request.getParameter("photo_4.1");
		photo5 = request.getPart("photo_5");
		String photo5_1=request.getParameter("photo_5.1");
		photo6 = request.getPart("photo_6");
		String photo6_1=request.getParameter("photo_6.1");
		photo7 = request.getPart("photo_7");
		String photo7_1=request.getParameter("photo_7.1");
		photo8 = request.getPart("photo_8");
		String photo8_1=request.getParameter("photo_8.1");
		photo9 = request.getPart("photo_9");
		String photo9_1=request.getParameter("photo_9.1");
		photo10 = request.getPart("photo_10");
		String photo10_1=request.getParameter("photo_10.1");
		
		/*
		 * photo11 = request.getPart("photo11"); photo12 =
		 * request.getPart("photo12");
		 */
		InputStream is = null;
		ArrayList<InputStream> al = new ArrayList<InputStream>();
		if (photo1 != null||photo1_1 !=null) {
		if(photo1.getSize()>0){
			is = photo1.getInputStream();
		}
			
		else{
			BASE64Decoder decoder = new BASE64Decoder();
            byte[] decodedBytes = decoder.decodeBuffer(photo1_1);
            is = new ByteArrayInputStream(decodedBytes);
		}
			
			al.add(is);
		
		}
		if (photo2 != null||photo2_1 !=null) {
			if(photo2.getSize()>0){
				is = photo2.getInputStream();
			}
				
			else{
				BASE64Decoder decoder = new BASE64Decoder();
	            byte[] decodedBytes = decoder.decodeBuffer(photo2_1);
	            is = new ByteArrayInputStream(decodedBytes);
			}
				
				al.add(is);
		}
		if (photo3 != null||photo3_1 !=null) {
			if(photo3.getSize()>0){
				is = photo3.getInputStream();
			}
				
			else{
				BASE64Decoder decoder = new BASE64Decoder();
	            byte[] decodedBytes = decoder.decodeBuffer(photo3_1);
	            is = new ByteArrayInputStream(decodedBytes);
			}
				
				al.add(is);
		}
		if (photo4 != null||photo4_1 !=null) {
			if(photo4.getSize()>0){
				is = photo4.getInputStream();
			}
				
			else{
				BASE64Decoder decoder = new BASE64Decoder();
	            byte[] decodedBytes = decoder.decodeBuffer(photo4_1);
	            is = new ByteArrayInputStream(decodedBytes);
			}
				
				al.add(is);
		}
		if (photo5 != null||photo5_1 !=null) {
			if(photo5.getSize()>0){
				is = photo5.getInputStream();
			}
				
			else{
				BASE64Decoder decoder = new BASE64Decoder();
	            byte[] decodedBytes = decoder.decodeBuffer(photo5_1);
	            is = new ByteArrayInputStream(decodedBytes);
			}
				
				al.add(is);
		}
		if (photo6 != null||photo6_1 !=null) {
			if(photo6.getSize()>0){
				is = photo6.getInputStream();
			}
				
			else{
				BASE64Decoder decoder = new BASE64Decoder();
	            byte[] decodedBytes = decoder.decodeBuffer(photo6_1);
	            is = new ByteArrayInputStream(decodedBytes);
			}
				
				al.add(is);
		}
		if (photo7 != null||photo7_1 !=null) {
			if(photo7.getSize()>0){
				is = photo7.getInputStream();
			}
				
			else{
				BASE64Decoder decoder = new BASE64Decoder();
	            byte[] decodedBytes = decoder.decodeBuffer(photo7_1);
	            is = new ByteArrayInputStream(decodedBytes);
			}
				
				al.add(is);
		}
		if (photo8 != null||photo8_1 !=null) {
			if(photo8.getSize()>0){
				is = photo8.getInputStream();
			}
				
			else{
				BASE64Decoder decoder = new BASE64Decoder();
	            byte[] decodedBytes = decoder.decodeBuffer(photo8_1);
	            is = new ByteArrayInputStream(decodedBytes);
			}
				
				al.add(is);
		}
		if (photo9 != null||photo9_1 !=null) {
			if(photo9.getSize()>0){
				is = photo9.getInputStream();
			}
				
			else{
				BASE64Decoder decoder = new BASE64Decoder();
	            byte[] decodedBytes = decoder.decodeBuffer(photo9_1);
	            is = new ByteArrayInputStream(decodedBytes);
			}
				
				al.add(is);
		}
		if (photo10 != null||photo10_1 !=null) {
			if(photo10.getSize()>0){
				is = photo10.getInputStream();
			}
				
			else{
				BASE64Decoder decoder = new BASE64Decoder();
	            byte[] decodedBytes = decoder.decodeBuffer(photo10_1);
	            is = new ByteArrayInputStream(decodedBytes);
			}
				
				al.add(is);
		}
		AddBikeDao dao = new AddBikeDaoImpl();
		String message = null;
		if(page.equals("UPDATE"))
		{
			message = dao.updateBikePhotos(bikeNo, is, al);
		}
		else
		{
			message = dao.addNewBikePhotos(bikeNo, is, al);
		}
		 
		if (message.equals("success")) {
				message = "Photos are updated on '"+bikeNo+"'";
		}
		RequestDispatcher rd = request.getRequestDispatcher("./updateNewBikePhotos.jsp");
		request.setAttribute("message", message);
		request.setAttribute("bikeNo", bikeNo);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
