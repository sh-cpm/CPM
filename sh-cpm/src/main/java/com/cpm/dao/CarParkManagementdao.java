package com.cpm.dao;

import com.cpm.model.CarPark;

public interface CarParkManagementdao {
	int generateTicketNo();
	void saveCarParkDetails(CarPark[] CarParks);
	CarPark[] getCarPark();

}
