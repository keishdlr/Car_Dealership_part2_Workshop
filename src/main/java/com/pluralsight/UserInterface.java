package com.pluralsight;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    // responsible for all output to the screen
    // reading of user input
    // "dispatching" of the commands to the Dealership

    //variables
    private Dealership dealership;

    //constructor
    public UserInterface() {
    }

    // helper method to be used above
    private static void  displayVehicles(List<Vehicle> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("No list found");
            return;
        }
        System.out.println("~~~~~~ Vehicle List ~~~~~~");
        for (Vehicle v : list) {
            System.out.println(v); //output will be in the format seen in the vehicle class
        }
    }

    //Methods
    private void init(){
        //create dealership object
        //assign the dealership that it returns to the userinterface this.dealership attribute
        DealershipFileManager fileManager = new DealershipFileManager();
        try {
            this.dealership = fileManager.getDealership();
        } catch (IOException e) {
            System.out.println("Error loading dealership: " + e.getMessage());
        }
    }

    public void display(){
        //call a private init() that loads the dealership
        init();
        System.out.println("Welcome to D & B Used Cars Dealerships");

        //loop with menu display, read user command, switch statement
        while (true) { // execute loop as long as condition is true

            // art
            System.out.println("                                                                                         \n" +
                    "                                                          ##***********#:::::-                      \n" +
                    "                                             ****###********##%@@@%***=:#**%%%%#%#*=                \n" +
                    "                                         **#**++==****+*#%%%@@@%####**.***###*%###%##*-             \n" +
                    "                                     %#***==--+****#%%%%%%%%%*++++*+#.-####*##%##*===*=+=           \n" +
                    "                                  @%##*+=--=+###*+*#%%%%%%#%%%%%@@##+.#%%**+==+#*+===+*==#:         \n" +
                    "                                @#***===+*++***#+*%%%@%@%%%#%%%%*%%+.-%=:..:----+*++++++=+-.:       \n" +
                    "                            .=%***+=+++*******++==+++++=====--:::-:::#%#@**####++====---::.....:    \n" +
                    "                        -=----:-=:.::::::::::::----:.......:.:::::::::::-++=:::::-::::::.:-+::::.=  \n" +
                    "               ...:--:::::::::::::::::::--::.........:::::::::::::::::::::-**+=--+*--::::::-:::::+  \n" +
                    "          ::::::::::::::::::::::::::.............::::::::::::::::#%%%*::::::=+-:::::::::::::::::::- \n" +
                    "       ::::::::-------.:::-----:...........*%#**#%#-:::::::::----:#@%+:::::--=+-----:-------:-%@=:- \n" +
                    "    ++:::::::::::=::::::::........-++==++=+=#%%#-%%#++:::.=*@@@%=----------=====-----=====---%###=- \n" +
                    "  =-=#:*@@@@@@@%-*@@%@#@#%%#@=::-+#%%*%#=+#+%##**=+::::::=@%###*@*---=================------+#@#%*- \n" +
                    "  =-*#-%%%@@%%@@+@%@%@%%@%@%@=:--+-+#%#*-**+-:....::::::=*%%%%@##%*--=======-============-=-#%#@@%= \n" +
                    " :....-*%@@@%@@%=%%@%@%@@%@@+--......:::::::---------::=*%#@@%%%%#%--===============------=-%%#%@%# \n" +
                    " -------=%%%%%%#-=%####%@%---------------------------:-@*%@%@%#%@%#========-------:::::::*+-#%#@@%# \n" +
                    "--:----=-----------------------------::::::::---------=#%%#@###@%##+=-----------::==+*=-::-=%%%%%## \n" +
                    "-----------------------------------::--::::::---------@#@%@#%@%#%%%==-------+*+*=-:::::--++#%@#%@%= \n" +
                    " #%@@@@+-++**+++=====----::.:=*####@@@@@@%@%=--------=##@%@@##+%%#%==++=++==-:::-+++##%@@@@@%@%*#*  \n" +
                    " *#%@@%-+*@@%@@%@%@%%@%%@%%@*::::-+*@@@@@%@%@=-------+%#%%%@%#%@@##=+=---=+##%@@        @@@%%%%%#=  \n" +
                    " *#@@%%=-%%%%%%%@%@%%@%%%@%%@=-:---:+#####%%%--------=%#%%%@#@#@%%*+%@@                             \n" +
                    " *###%%*:::::-==+++******+++===+###%#####%%%%+------=*%%%@%@#@@%%#%                                 \n" +
                    " *#%#%@@%%%%%%%%%%####%%%%%%@@@@@@@****+*#%%%%%%%%%#%%@%%%%%%%@%%%@                                 \n" +
                    "          @@@@@@@@@%%%%%%%%%%%%%%#%%%%%%@@@@@@@@     @@@%%@@%%#%%%%                                 \n" +
                    "                                                       @@@@@%%%#                                    \n" +
                    "                                                                                                    \n" +
                    "                                                                                                    "
            );

            System.out.println("-----Home Screen-----");
            System.out.println("    A) Filter by Price              ");
            System.out.println("    B) Filter by Make and Model     ");
            System.out.println("    C) Filter by Year               ");
            System.out.println("    D) Filter by Color              ");
            System.out.println("    E) Filter by Mileage            ");
            System.out.println("    F) Filter by Vehicle Type       ");
            System.out.println("    G) All Vehicle                  ");
            System.out.println("    H) Add Vehicle                  ");
            System.out.println("    I) Remove Vehicle               ");
            System.out.println("    X) Exit                         ");

            Scanner Myscanner = new Scanner(System.in); //user input
            String selection = Myscanner.nextLine().toUpperCase(); // turns user input to uppercase
            Myscanner.nextLine();
            switch (selection) {
                case "A":
                   processGetByPriceRequest(Myscanner);
                    break;
                case "B":
                    processGetByMakeModelRequest(Myscanner);
                    break;
                case "C":
                    processGetByYearRequest(Myscanner);
                    break;
                case "D":
                    processGetByColorRequest(Myscanner);
                    break;
                case "E":
                    processGetByMileage(Myscanner);
                    break;
                case "F":
                    processGetByVehicleType(Myscanner);
                    break;
                case "G":
                   processGetAllVehicleRequest();
                    break;
                case "H":
                   processAddVehicleRequest(Myscanner);
                    break;
                case "I":
                    processRemoveVehicleRequest(Myscanner);
                    break;
                case "X":
                    System.exit(0);  // if X is selected then it will exit the program
                default:
                    System.out.println("Invalid input. Try again");
            }
        }
        }

    //processes methods
    public void processGetByPriceRequest(Scanner scanner) {
        System.out.print("Enter minimum price: ");
        double minPrice = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter maximum price: ");
        double maxPrice = Double.parseDouble(scanner.nextLine());
        List<Vehicle> priceMatches = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(priceMatches);
        processGetByPriceRequest(scanner);
    }

    public void processGetByMakeModelRequest(Scanner scanner) {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        List<Vehicle> matches = dealership.getvehiclesByMakeModel(make, model);
        displayVehicles(matches);

    }

    public void processGetByYearRequest(Scanner scanner){
        System.out.println("Enter the year: ");
        int year = Integer.parseInt(scanner.nextLine());
        List<Vehicle> yearMatches = dealership.getvehiclesByYear(year);
        displayVehicles(yearMatches);
    }

    public void processGetByColorRequest(Scanner scanner){
        System.out.println("Enter the color: ");
        String color = scanner.nextLine();
        List<Vehicle> colorMatches = dealership.getvehiclesByColor(color);
        displayVehicles(colorMatches);
    }

    public void processGetByMileage(Scanner scanner) {
        System.out.println("Enter Mileage: ");
        int mileage = Integer.parseInt(scanner.nextLine());
        List<Vehicle> mileageMatches = dealership.getvehiclesByMilage(mileage);
        displayVehicles(mileageMatches);
    }

    public void processGetByVehicleType(Scanner scanner) {
        System.out.print("Enter vehicle type: ");
        String type = scanner.nextLine();
        List<Vehicle> matches = dealership.getvehiclesByType(type);
        displayVehicles(matches);

    }

    public void processGetAllVehicleRequest() {
        System.out.println("All Vehicles:");
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }

    public void processAddVehicleRequest(Scanner scanner){
        System.out.println("Enter VIN:"); //optional check: add checks to 1) ensure vin doesn't already exist
        // 2) ensure a valid input
        int vin = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Year:");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Make:");
        String make = scanner.nextLine();

        System.out.println("Enter Model:");
        String model = scanner.nextLine();

        System.out.println("Enter Vehicle Type:");
        String type = scanner.nextLine();

        System.out.println("Enter Color:");
        String color = scanner.nextLine();

        System.out.println("Enter Odometer Reading:");
        int odometer = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Price:");
        double price = Double.parseDouble(scanner.nextLine());

        Vehicle newVehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(newVehicle);

        //method to save vehicle to CSV file
        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);

        System.out.println("✅🚘Vehicle added successfully!");
    return;
    }

    public void processRemoveVehicleRequest(Scanner scanner){
        System.out.println("Enter the VIN of the vehicle to remove:");
        int vinToRemove = Integer.parseInt(scanner.nextLine());

        // Finds the vehicle in inventory
        Vehicle toRemove = null;
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVin() == vinToRemove) {
                toRemove = v;
                break;
            }
        }
        if (toRemove != null) {
            dealership.removeVehicle(toRemove);
            DealershipFileManager fileManager = new DealershipFileManager();
            fileManager.saveDealership(dealership);
            System.out.println("🚗 Vehicle removed successfully.");
        } else {
            System.out.println("❌ Vehicle with VIN " + vinToRemove + " not found.");
        }
    }
}