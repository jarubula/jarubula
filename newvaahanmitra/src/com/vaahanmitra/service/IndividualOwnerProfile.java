package com.vaahanmitra.service;

import com.vaahanmitra.dao.IndividualOwnerRegisterDao;
import com.vaahanmitra.daoImpl.IndividualOwnerRegisterDaoImpl;
import com.vaahanmitra.exception.IndividualOwnerException;
import com.vaahanmitra.model.IndividualOwnerRegister;

public class IndividualOwnerProfile {
	
	public IndividualOwnerRegister getProfileDeatils(String email){
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
}
