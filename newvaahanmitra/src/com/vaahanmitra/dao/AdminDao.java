package com.vaahanmitra.dao;

import java.util.ArrayList;

import com.vaahanmitra.model.DealerAuthentication;
import com.vaahanmitra.model.DriverBean;

public interface AdminDao {

//	ArrayList<DriverBean> getDriverDetails(String fdate, String tdate, int i, int maxrowsperpage);

	ArrayList<DriverBean> getDriverDetails(String fdate, String tdate);

	int getNoOfRecords();

	String activeIncative(String driverId, String status,String drEmail);

	ArrayList<DealerAuthentication> getDealerDocumets(String emailId);

	String dealerFeedback(String acceptance, String demail);

}
