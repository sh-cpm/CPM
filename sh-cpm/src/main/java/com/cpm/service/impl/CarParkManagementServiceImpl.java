package com.cpm.service.impl;

import com.cpm.dao.CarParkManagementdao;
import com.cpm.dao.impl.CarParkManagementDaoImpl;
import com.cpm.model.CarPark;
import com.cpm.service.CarParkManagementService;


public class CarParkManagementServiceImpl implements CarParkManagementService {
	
	private CarParkManagementdao carParkManagementdao;
	private CarPark[] CarParks;
	
	public CarParkManagementServiceImpl (){
		carParkManagementdao = new CarParkManagementDaoImpl();
		CarParks = carParkManagementdao.getCarPark();
		
	}
	
	@Override
    public Integer carPark(String licencePlate){
        Integer ticketNo = null;
        boolean parkSuccessful = false;
        for(int i = 0;i<10 && !parkSuccessful;i++){
            if(CarParks[i] == null){
            	ticketNo = carParkManagementdao.generateTicketNo();
            	CarParks[i] = new CarPark(licencePlate, ticketNo);
            	carParkManagementdao.saveCarParkDetails(CarParks);
                parkSuccessful = true;
            }
        }
        if(!parkSuccessful){
            System.err.println("Car park space is not available!");
        }
        return ticketNo;
    }
	@Override
    public void carUnpark(int ticketNumber){
        boolean unparkSuccessful = false;
        for(int i = 0; i<10 && !unparkSuccessful; i++){
            if(CarParks[i] != null && CarParks[i].getTicketNo() == ticketNumber){
            	CarParks[i] = null;
            	carParkManagementdao.saveCarParkDetails(CarParks);
                unparkSuccessful = true;
            }
        }
        if(!unparkSuccessful){
            System.err.println("This ticket number is not present!");
        }
    }
	
	@Override
    public String getParkingDetails() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<10;i++){
            if(CarParks[i] != null){
                result.append(CarParks[i].getLicencePlate());
            }
            if(i != 9) {
                result.append(",");
            }
        }
        return result.toString();
    }

}
