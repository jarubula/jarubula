package com.vaahanmitra.dao;

import java.util.ArrayList;

import com.vaahanmitra.model.MechanicProfile;

public interface MechanicProfileDao {

	String addMechanic(MechanicProfile addMechanic, String user_name);
	
	public boolean getEmail(String email);

	MechanicProfile getMechanicDetails(String email);

	String updateMechanicProfile(String user_name, MechanicProfile mechanic);

	ArrayList<MechanicProfile> searchMechanic(String email);

	MechanicProfile getMechanicProfile(String email);

}
