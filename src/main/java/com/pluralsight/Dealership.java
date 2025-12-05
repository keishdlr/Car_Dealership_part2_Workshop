package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    //  hold information about the dealership
    //  maintain a list of vehicles
    //  methods that search the list for matching vehicles
    //  add/remove vehicles

    //Dealership info
    private String name;
    private String address;
    private String phoneNumber;
    private List<Vehicle> inventory; // creates a new list called inventory to store vehicles

    //constructor
    public Dealership(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        //when a dealership (garage) is created, it also creates an empty list (parking lot) to hold vehicle objects
        this.inventory = inventory != null ? inventory : new ArrayList<>(); //instantiated object in constructor
    }

    //getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // methods
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getPrice() >= min && v.getPrice() <= max) {
                results.add(v);
            }
        }
        return results;
    }

    public List<Vehicle> getvehiclesByMakeModel(String make, String model){
        return new ArrayList<>();
    }

    public List<Vehicle> getvehiclesByYear(int year){
        return new ArrayList<>();
    }

    public List<Vehicle> getvehiclesByColor(String color){
        return new ArrayList<>();
    }

    public List<Vehicle> getvehiclesByMilage(int mileage){
        return new ArrayList<>();
    }

    public List<Vehicle> getvehiclesByType(String vehicleType){
        return new ArrayList<>();
    }

    public List<Vehicle> getAllVehicles(){
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }
}