package com.vaahanmitra.service;

import java.util.ArrayList;

import com.vaahanmitra.dao.IndividualOwnerRegisterDao;
import com.vaahanmitra.dao.UsedBikeDao;
import com.vaahanmitra.daoImpl.IndividualOwnerRegisterDaoImpl;
import com.vaahanmitra.daoImpl.UsedBikeDaoImpl;
import com.vaahanmitra.exception.IndividualOwnerException;
import com.vaahanmitra.model.IndividualOwnerRegister;
import com.vaahanmitra.model.UsedBike;

public class IndividualOwnerService {
	
	public IndividualOwnerRegister getOwnerDetails(String seqid)
	{
		IndividualOwnerRegisterDao idao=new IndividualOwnerRegisterDaoImpl();
		IndividualOwnerRegister io=new IndividualOwnerRegister();
		try {
			io=idao.getOwnerDetails(seqid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return io;
	}
	
	public ArrayList<String> getIndivudualOwnerLocations()
	{
		IndividualOwnerRegisterDao bo=new IndividualOwnerRegisterDaoImpl();
		ArrayList<String> al=new ArrayList<String>();
		try
		{
			al=bo.getIndividualOwnerLocations();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
	
	public IndividualOwnerRegister getProfileDetails(String email){
		IndividualOwnerRegisterDao dao = new IndividualOwnerRegisterDaoImpl();
		IndividualOwnerRegister al=new IndividualOwnerRegister();
		try {
			al = dao.getDeatils(email);
		} catch (IndividualOwnerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;		
	}
	public UsedBike getBikePhotos(String bike_number){
		UsedBikeDao cdao=new UsedBikeDaoImpl();
		UsedBike imageAl = cdao.getBikeImages(bike_number);
		return imageAl;
	}
	public ArrayList<String> getIOCities(String email)
	{
		IndividualOwnerRegisterDao bo=new IndividualOwnerRegisterDaoImpl();
		ArrayList<String> al=new ArrayList<String>();
		try
		{
			al=bo.getIOCities(email);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}

}
