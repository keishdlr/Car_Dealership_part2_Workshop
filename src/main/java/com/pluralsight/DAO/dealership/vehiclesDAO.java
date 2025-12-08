package com.pluralsight.DAO.dealership;

import com.pluralsight.dealership.Vehicle;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class vehiclesDAO {

    //DAO to connect to the DB and get connections from the pool
    private final DataSource ds;

    //constructor
    public vehiclesDAO(DataSource ds) {
        this.ds = ds;
    }

    //Phase 1
    // should be to create the VehicleDao and to create the methods required
    //to allow a user to search the database for vehicles:

    //this method gets all products from the db
    public ArrayList<Vehicles> getAllVehicles() {

        //create an empty array list
        // "ArrayList" made of "actors" called "actorArrayList
        ArrayList<Vehicles> vehiclesArrayListList = new ArrayList<>();

        //run query to get the results using a prepared statement
        try (
                //get a connection from the pool
                Connection connection = this.ds.getConnection();

                //prepared statement with the passed in connection we created above
                PreparedStatement query = connection.prepareStatement("""
                        SELECT
                            year
                            make
                            model
                            vehicle_type
                            color
                            odometer
                            price
                        FROM
                            vehicles
                        ORDER BY
                            year
                        """
                )
        ) {
            //get the result set go through it and create java objects to add to the list
            try (ResultSet results = query.executeQuery()) {
                while (results.next()) {
                    //create the object from the results
                    Vehicle newVehicle = new Vehicle(
                            results.getString("year"),
                            results.getString("make"),
                            results.getString("model"),
                            results.getString("vehicle_type"),
                            results.getString("color"),
                            results.getInt("odometer"),
                            results.getInt("price")
                    );
                    // add the created object above to the list
                    vehiclesArrayListList.add(newVehicle);
                }
            } catch (SQLException e) {
                System.out.println("ERROR: " + e);
            }

        } catch (SQLException e) {
            System.out.println("Could not get all actors");
            System.exit(1);
        }
        //return the list
        return vehiclesArrayListList;
    }


    //Phase 2
    // should be the to add and remove vehicles from the database



    //Phase 3
    // involves creating the SalesDao and LeaseDao classes and update your
    //dealership logic to save the sales/lease information to the database.
    //Delete all .csv files from this project and verify that the project still works as
    //expected.

}
