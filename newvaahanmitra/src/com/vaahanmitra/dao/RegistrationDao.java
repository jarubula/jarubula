package com.vaahanmitra.dao;

import com.vaahanmitra.model.Registration;

public interface RegistrationDao {
	public String addUser( Registration registration );
	public boolean retriveEmail(String email);
	public Registration getAddressDetails(String emailId);
}
