package com.vaahanmitra.dao;

import java.util.ArrayList;

import com.vaahanmitra.model.BusinessOwnerRegister;
import com.vaahanmitra.model.DealerAssignBrands;

public interface AssignBrandsToDealerDao {

	public String assignBrandsToDealer(DealerAssignBrands bean);

	public ArrayList<BusinessOwnerRegister> getDealerList(String city,String brand, String model, String vType);
}
