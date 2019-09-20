package com.cpm.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import com.cpm.dao.CarParkManagementdao;
import com.cpm.model.CarPark;



public class CarParkManagementDaoImpl implements CarParkManagementdao{
	private final String SAVE_TICKET_NO_PATH = "src/main/resources/Ticket";
    private final String SAVE_TICKETNO_LICENSE_PATH = "src/main/resources/CarPark";

	@Override
    public int generateTicketNo() {
        int result = 0;
        File file = new File(SAVE_TICKET_NO_PATH);
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String ticketString;
            if ((ticketString = br.readLine()) != null) {
                result = Integer.valueOf(ticketString)+1;
                writeFile(SAVE_TICKET_NO_PATH,new String[]{String.valueOf(result)});
            } else {
                result = 5000;
                writeFile(SAVE_TICKET_NO_PATH,new String[]{"5000"});
            }
        } catch (IOException e){
            System.err.println("Error while writing the Ticket file: " + e.getMessage());
        }
        return result;
    }
	@Override
    public void saveCarParkDetails(CarPark[] CarParks) {
        try {
            String[] content = new String[10];
            for(int i = 0; i<10; i++){
                content[i] = CarParks[i]==null?null:(CarParks[i].getTicketNo() + "," + CarParks[i].getLicencePlate());
            }
            writeFile(SAVE_TICKETNO_LICENSE_PATH,content);
        }catch (FileNotFoundException e) {
            try {
                Boolean fileCreated = new File(SAVE_TICKETNO_LICENSE_PATH).createNewFile();
                if(fileCreated) {
                    saveCarParkDetails(CarParks);
                }else{
                    System.err.println("Unknown error while creating a new CarPark file.");
                }
            } catch (IOException e1) {
                System.err.println("Error while creating a new CarPark file: " + e1.getMessage());
            }
        }catch (IOException e){
            System.err.println("Error while writing the CarPark file: " + e.getMessage());
        }
    }
	
	
	
	private void writeFile(String fileName, String[] content) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(fileName, "UTF-8");
        for(String line : content){
            writer.println(line==null?"":line);
        }
        writer.close();
    }

}
