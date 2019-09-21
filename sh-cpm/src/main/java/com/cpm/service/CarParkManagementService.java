package com.cpm.service;

public interface CarParkManagementService {
	
	Integer carPark(String licencePlate);
	String getParkingDetails();
	void carUnpark(int ticketNumber);
	void carCompact();

}
