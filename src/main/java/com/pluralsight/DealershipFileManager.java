package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {
    //reading the dealership file
    //parsing the data

    // This method loads and reads the inventory.csv file
    public Dealership getDealership() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"));
        String line = reader.readLine(); // First line = dealership info
        String[] dealershipInfo = line.split("\\|");
        Dealership dealership = new Dealership(dealershipInfo[0].trim(), dealershipInfo[1].trim(), dealershipInfo[2].trim());

        while ((line = reader.readLine()) != null) {
            String[] values = line.split("\\|");
            int vin = Integer.parseInt(values[0].trim());
            int year = Integer.parseInt(values[1].trim());
            String make = values[2].trim();
            String model = values[3].trim();
            String type = values[4].trim();
            String color = values[5].trim();
            int odometer = Integer.parseInt(values[6].trim());
            double price = Double.parseDouble(values[7].trim());

            Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
            dealership.addVehicle(vehicle);
        }

        reader.close();
        return dealership;
    }

    // This method will overwrite the inventory.csv file with the current dealership information and inventory list.
    public void saveDealership(Dealership dealership) {
        // TODO: implement writing dealership and vehicles to inventory.csv
    }
}
