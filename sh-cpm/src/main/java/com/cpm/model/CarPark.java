package com.cpm.model;

public class CarPark {
	private String licencePlate;
    private int ticketNo;
    
	public String getLicencePlate() {
		return licencePlate;
	}
	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
	}
	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	public CarPark(String licencePlate, int ticketNo) {
		super();
		this.licencePlate = licencePlate;
		this.ticketNo = ticketNo;
	}
	
    

}
