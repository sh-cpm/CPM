package com.cpm.main;

import java.util.Scanner;

import com.cpm.service.CarParkManagementService;
import com.cpm.service.impl.CarParkManagementServiceImpl;


public class CpmMain {
	private static final String REGEX = "((([p])[^\\s,]+)(,?)|(([u])[\\d]+)(,?)|([c](,?)))*";
	private static CarParkManagementService carParkManagementService = new CarParkManagementServiceImpl();

	public static void main(String[] args){
        System.out.println("Please Enter license plate:");
        Scanner sc = new Scanner(System.in);
        while (true) {
        	String input = sc.nextLine();
            System.out.println(validationInput(input));
        }
	}
	
	private  static String validationInput(String input){
		if(input.isEmpty()){
			return "Input is Empty.Please enter input:";
		}
		else if (input.endsWith(",")) {
			return "Please remove ',' from the end.";
		}
		else if (!input.matches(REGEX)) {
            return "Please enter valid input:";
        } 
		else{
		String[] inputArray = input.split(",");
			for (String s : inputArray) {
				switch (s.charAt(0)) {
                case 'p':
                	carParkManagementService.carPark(s.split("p")[1]);
                	break;
                case 'u':
                	carParkManagementService.carUnpark(Integer.valueOf(s.split("u")[1]));
                	break;
                case 'c':
                	carParkManagementService.carCompact();
				
			}
			
		}
			return carParkManagementService.getParkingDetails();
		
		
	}
}
}
	

