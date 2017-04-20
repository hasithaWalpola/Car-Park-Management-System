import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class WestminsterCarParkManager implements CarParkManager {

    //instance of westminster car park manager
    static WestminsterCarParkManager westminsterCarParkManager = new WestminsterCarParkManager();
    static List<Vehicle> park = new ArrayList<Vehicle>();//array list to store vehicle data
    //scanner to get the inputs
    Scanner sc = new Scanner(System.in);
    //free slot counter
    static int sCounter = 20;

    static int vehiCount = 0;
    static int carCount = 0;
    static int vanCount = 0;
    static int bikeCount = 0;


    public static void main(String[] args) {

        WestminsterCarParkManager w = new WestminsterCarParkManager();
        w.menu();

    }

    //Method to display the menu
    public void menu() {

        //String to hold the menu option
        int option = 0;


        try {
            do {

                System.out.println("");
                System.out.println("                  ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,    ");
                System.out.println("------------------$ W E S T M I N S T E R     C A R     P A R K    M A N A G E R $-------------------");
                System.out.println("                  ''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''    ");
                System.out.println("");

                System.out.println("                                            !! WELCOME !!   \n  ");
                System.out.println("---------------------------------------- # Car Parking Options # ------------------------------------ \n");
                System.out.println("   Press 1 to Add a new vehicle");
                System.out.println("   Press 2 to Delete a vehicle ");
                System.out.println("   Press 3 to Print the list of vehicle parked");
                System.out.println("   Press 4 to Print the percentage of curently parked vehicle");
                System.out.println("   Press 5 to Print the last vehicle");
                System.out.println("   Press 6 to Print the info");
                System.out.println("   Press 7 to Charges");
                System.out.println("   Press 8 to Exit...");

                System.out.print("\n");
                System.out.print("Your Option : ");


                option = sc.nextInt();

                switch (option) {
                    case 1:
                        westminsterCarParkManager.addVehicle();
                        //System.out.println(Arrays.toString(slots));
                        break;
                    case 2:
                        westminsterCarParkManager.deleteVehicle();
                        break;
                    case 3:
                        westminsterCarParkManager.printList();
                    case 4:
                        westminsterCarParkManager.carParkPercentage();
                        break;
                    case 5:
                        westminsterCarParkManager.displayLastVehicle();
                        break;
                    case 6:
                        westminsterCarParkManager.getInfo();
                        break;
                    case 7:
                        westminsterCarParkManager.carparkCharges();
                        break;
                    case 8:
                        System.out.print("Thank You !"); // exit the program
                        System.exit(1);
                        break;
                    default:
                        System.out.println("Invalid input");
                        System.out.println("Please Try Again !\n");
                }
            } while (option > 8);

        } catch (Exception e) {
            System.out.println("Invalid input");
            westminsterCarParkManager.menu();

        }
    }

    @Override
    //Method for adding a new Vehicle
    public void addVehicle() {
        char type;
        try {
            do {

                System.out.println();
                System.out.println("-------------------------------------------# Add a new vehicle #-------------------------------------- ");
                System.out.println("------------------------------------------------------------------------------------------------------");

                //displays the number of free slots
                getFreeSlots();

                if (sCounter > 0) {

                    System.out.println("Please select the type of the Vehicle");
                    System.out.println("\t C - Car");
                    System.out.println("\t V - Van");
                    System.out.println("\t M - Motorbike");

                    type = sc.next().toLowerCase().charAt(0);

                    DateTime dateTime = new DateTime();
                    StoreData sd = new StoreData();

                    switch (type) {
                        case 'c':
                            //Adding a Car
                            Car car = new Car();

                            car.setVehicleType("Car");

                            System.out.println("Please enter the ID Plate number of the Car");
                            car.setIdPlate(sc.next());

                            System.out.println("Please enter the Brand of the Car");
                            car.setVehicleBrand(sc.next());

                            //setting the entrance time
                            timeValidator(dateTime);
                            //setting the entrance date
                            dateValidator(dateTime);

                            System.out.println("Please enter the number of Doors of the Car");
                            car.setNumDoors(sc.nextInt());

                            System.out.println("Please enter the Color of the Car");
                            car.setColor(sc.next());

                            //set the datetime object to the car
                            car.setDateTime(dateTime);
                            sd.writeFile(car, dateTime, type);

                            carCount++;
                            vehiCount++;

                            park.add(car);
                            System.out.println(park.toString());
                            //slots.remove(emptySlot); //remove one slot
                            sCounter--;
                            menu();
                            break;

                        case 'v':
                            if (sCounter > 2) {
                                //Adding a Van
                                Van van = new Van();
                                van.setVehicleType("Van");

                                System.out.println("Please enter the ID Plate number of the Van");
                                van.setIdPlate(sc.next());

                                System.out.println("Please enter the Brand of the van");
                                van.setVehicleBrand(sc.next());

                                //setting the entrance time
                                timeValidator(dateTime);
                                //setting the entrance date
                                dateValidator(dateTime);

                                System.out.println("Please enter the cargo volume of the van in Cubic Feet");
                                van.setCargoVolume(sc.nextDouble());

                                //set the datetime object to the Van
                                van.setDateTime(dateTime);
                                sd.writeFile(van, dateTime, type);

                                vanCount++;
                                vehiCount++;

                                park.add(van);
                                System.out.println(park.toString());
                                //slots.remove(emptySlot); slots.remove(emptySlot);//remove two slots
                                sCounter--;
                                sCounter--;
                                menu();
                            } else {
                                System.out.println("Sorry! There's no space available for a Van right now.");
                                menu();
                            }
                            break;

                        case 'm':
                            //Adding a Bike
                            MotorBike motorbike = new MotorBike();
                            motorbike.setVehicleType("Motorbike");

                            System.out.println("Please enter the ID Plate number of the Motorbike");
                            motorbike.setIdPlate(sc.next());

                            System.out.println("Please enter the Brand of the Motorbike");
                            motorbike.setVehicleBrand(sc.next());

                            //setting the entrance time
                            timeValidator(dateTime);
                            //setting the entrance date
                            dateValidator(dateTime);

                            System.out.println("Please enter the engine capacity of the Motorbike");
                            motorbike.setEngineCapacity(sc.next());

                            //set the datetime object to the bike
                            motorbike.setDateTime(dateTime);
                            sd.writeFile(motorbike, dateTime, type);


                            bikeCount++;
                            vehiCount++;

                            park.add(motorbike);
                            System.out.println(park.toString());
                            //slots.remove(emptySlot); //remove one slot
                            sCounter--;
                            menu();
                            break;

                        default:
                            System.out.println("Invalid input. Please try again!");
                            break;
                    }
                } else {
                    return;
                }
            }while (type!='c' || type!='v' || type!='m');
        } catch (Exception e) {
            System.out.println("\nInvalid Entry. Please try again.");
            westminsterCarParkManager.addVehicle();
        }
    }

    @Override
    //Method to delete a vehicle
    public void deleteVehicle() {
        try {
            System.out.println();
            System.out.println("-------------------------------------------# Delete a  vehicle #-------------------------------------- ");
            System.out.println("------------------------------------------------------------------------------------------------------");

            System.out.println("List of Vehicles in the parking \n");
            for (Vehicle vehicle : park) {
                String ID = vehicle.getIdPlate();
                if (ID != null)
                    System.out.println(ID);
            }
            System.out.println("\nPlease select the vehicle you wish to delete");

            String deleteVehicle = sc.next();
            //getIndexProperty method will return an integer
            System.out.println("A " + park.get(getIndexByProperty(deleteVehicle)).getVehicleType() + " is leaving the park.");
            park.remove(getIndexByProperty(deleteVehicle));
            if (park.get(getIndexByProperty(deleteVehicle)).getVehicleType().equals("car")) {
                carCount--;
                vehiCount--;
            } else if (park.get(getIndexByProperty(deleteVehicle)).getVehicleType().equals("van")) {
                vanCount--;
                vehiCount--;
            } else if (park.get(getIndexByProperty(deleteVehicle)).getVehicleType().equals("moterbike")) {
                bikeCount--;
                vehiCount--;
            }

            System.out.println(park.toString());
            menu();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    //returns the index of the desired vehicle
    private int getIndexByProperty(String yourString) {
        for (int i = 0; i < park.size(); i++) {
            if (park.get(i).getIdPlate() != null && park.get(i).getIdPlate().equals(yourString)) {
                System.out.println(i);
                return i;
            }
        }
        return -1;// not there is list
    }

    @Override
    public void printList() {
        //print list method
        System.out.println("------------------------------------# Currently parked vehicle list #--------------------------------- ");
        System.out.println("------------------------------------------------------------------------------------------------------");

        for (Vehicle vehicle : park) {
            System.out.println("ID Plate - " + vehicle.getIdPlate() + " " + "Entrance Time - " +
                    vehicle.getDateTime().getHour() + ":" + vehicle.getDateTime().getMinute() + ":" +
                    vehicle.getDateTime().getSecond() + " The type of the vehicle - " + vehicle.getVehicleType());
        }
        menu();

    }

    @Override
    public void carParkPercentage() {
        try {
            double carP;
            double vanP;
            double bikeP;
            System.out.println("-----------------------------------------# Percentage of vehicles #------------------------------------ ");
            System.out.println("------------------------------------------------------------------------------------------------------");
            System.out.println("");

            System.out.println(carCount);
            System.out.println(vanCount);
            System.out.println(bikeCount);
            System.out.println(vehiCount);

            carP = ((double) carCount / (double) vehiCount) * 100;
            System.out.println("Car percentage is " + carP + "%");

            vanP = ((double) vanCount / (double) vehiCount) * 100;
            System.out.println("Car percentage is " + vanP + "%");

            bikeP = ((double) bikeCount / (double) vehiCount) * 100;
            System.out.println("Car percentage is " + bikeP + "%");
        } catch (Exception e) {
            System.out.println("");
            System.out.println("Car Park Is Empty");
            System.out.println("");
        }
        menu();
    }

    @Override
    public void displayLastVehicle() {

        System.out.println("-----------------------------------# Last Parked & Logest time parked #------------------------------- ");
        System.out.println("------------------------------------------------------------------------------------------------------");

        System.out.println("");

        if (park != null && !park.isEmpty()) {
            System.out.println(park.get(park.size() - 1));
        }
        System.out.println("-----------------------------------# Last Parked & Logest time parked #------------------------------- ");
        System.out.println("------------------------------------------------------------------------------------------------------");

        System.out.println("");
        if (park != null && !park.isEmpty()) {
            System.out.println(park.get(0));
        }
        menu();
    }

    @Override
    public void carparkCharges() {
        DateTime dateTime = new DateTime();
        try {
            System.out.println("-----------------------------------------# Car park charges #----------------------------------------- ");
            System.out.println("------------------------------------------------------------------------------------------------------");


            System.out.println("");
            System.out.println("");
            System.out.println("===================================================");
            System.out.println("=*       For the first 3 Hours: 3�               *=");
            System.out.println("=* The Car Park Charges Additionl 1� per 1hour   *=");
            System.out.println("=*       Max Charges for 24 Hours: 30�           *=");
            System.out.println("===================================================");
            System.out.println("");
            //System.out.println("Please Enter Valid Vehicle ID Plate No:");
            //String vehId = sc.next();

            System.out.println("Please Enter Valid Entry Date: [Format: dd/mm/yyyy**]");
            String vehDate = sc.next();
            System.out.println("Please Enter Valid Entry Time: [Format: hh:mm**]");
            String vehTime = sc.next();

            String[] dateSeperator2 = (vehDate.split("\\/"));
            int Day2 = Integer.parseInt(dateSeperator2[0]);
            int Month2 = Integer.parseInt(dateSeperator2[1]);
            int Year2 = Integer.parseInt(dateSeperator2[2]);

            String[] timeSeperator2 = (vehTime.split("\\:"));
            int Hour2 = Integer.parseInt(timeSeperator2[0]);
            int Minute2 = Integer.parseInt(timeSeperator2[1]);


            if (park.size() == 0) {

                System.out.println("No vehicles parked in");
            } else {

                for (Vehicle vehicle : park) {
                    // for (int i = 0; i < slots.size(); i++) {
                    int hourCalc = (Hour2 - vehicle.getDateTime().getHour());
                    System.out.println(hourCalc);
                    int dayCalc = (Day2 - vehicle.getDateTime().getDay());


                    if (0 <= hourCalc && hourCalc <= 3 && dayCalc == 0) {
                        System.out.println("");
                        System.out.println("======================================");
                        System.out.println("Vehicle Id = " + vehicle.getIdPlate());
                        System.out.println("         YOUR FINAL PRICE: 3�");
                        System.out.println("======================================");
                        System.out.println("");
                    } else if (3 < hourCalc && hourCalc < 24 && dayCalc == 0) {
                        hourCalc = hourCalc - 3;
                        int newHourCalc = (hourCalc * 1) + 3;
                        System.out.println("");
                        System.out.println("======================================");
                        System.out.println("Vehicle Id = " + vehicle.getIdPlate());
                        System.out.println("YOUR FINAL PRICE : " + newHourCalc + "�");
                        System.out.println("======================================");
                        System.out.println("");
                    } else if (dayCalc == 1) {
                        System.out.println("");
                        System.out.println("======================================");
                        System.out.println("Vehicle Id = " + vehicle.getIdPlate());
                        System.out.println("        YOUR FINAL PRICE: 30�");
                        System.out.println("======================================");
                        System.out.println("");
                    }

                    //}
                }

            }
        } catch (Exception e) {
            System.out.println("");
            System.out.println("Invalid Input!");
            System.out.println("");
        }
        menu();
    }

    @Override
    public void getFreeSlots() {

        if (sCounter > 0) {
            System.out.println(" \n There are " + sCounter + " free slots left. \n");
        } else {
            System.out.println("\n Sorry! There are no free slots left. \n");
        }
    }

    @Override
    public void timeValidator(DateTime dateTime) {

        String timeString;
        String[] time;

        //loop until the time is valid
        do {
            System.out.println("Please enter the entrance Time in the format of " +
                    "HH:MM:SS");
            timeString = sc.next();
            time = timeString.split(":");

            //display an error if the time is invalid
            if (Integer.parseInt(time[0]) >= 24 || Integer.parseInt(time[1]) >= 60 || Integer.parseInt(time[2]) >= 60) {
                System.out.println("\n Invalid time. Please try again.\n ");
                continue;
            }
        }
        while (Integer.parseInt(time[0]) >= 24 || Integer.parseInt(time[1]) >= 60 || Integer.parseInt(time[2]) >= 60);

        //setting the time
        dateTime.setHour(Integer.parseInt(time[0]));
        dateTime.setMinute(Integer.parseInt(time[1]));
        dateTime.setSecond(Integer.parseInt(time[2]));

    }

    @Override
    public void dateValidator(DateTime dateTime) {
        String dateString;
        String[] date;

        //loop until the date is valid
        do {
            System.out.println("Please enter the entrance Date in the format of " +
                    "YYYY-MM-DD");

            dateString = sc.next();

            date = dateString.split("-");

            //display an error if the date is invalid
            if (Integer.parseInt(date[1]) > 12 || Integer.parseInt(date[2]) > 31) {
                System.out.println("\n Invalid date. Please try again.\n ");
                continue;

                //checks if the year is a 4 digit number or not
            } else if ((int) Math.log10(Integer.parseInt(date[0])) + 1 < 4) {
                System.out.println("\n The year you entered appears to be invalid. Please try again.\n ");
                continue;
            }

        }
        while ((int) Math.log10(Integer.parseInt(date[0])) + 1 < 4 || Integer.parseInt(date[1]) > 12 || Integer.parseInt(date[2]) > 31);

        //sets the date
        dateTime.setYear(Integer.parseInt(date[0]));
        dateTime.setMonth(Integer.parseInt(date[1]));
        dateTime.setDay(Integer.parseInt(date[2]));
    }


    @Override
    public void getInfo() {
        String dateString;
        String[] date;
        System.out.println("----------------------------------------# List of specified day #------------------------------------- ");
        System.out.println("------------------------------------------------------------------------------------------------------");


        do {
            System.out.println("Please enter the entrance Date in the format of " +
                    "YYYY-MM-DD");

            dateString = sc.next();
            date = dateString.split("-");

            //display an error if the date is invalid
            if (Integer.parseInt(date[1]) > 12 || Integer.parseInt(date[2]) > 31) {
                System.out.println("\n Invalid date. Please try again.\n ");
                continue;

                //checks if the year is a 4 digit number or not
            } else if ((int) Math.log10(Integer.parseInt(date[0])) + 1 < 4) {
                System.out.println("\n The year you entered appears to be invalid. Please try again.\n ");
                continue;
            }

        }
        while ((int) Math.log10(Integer.parseInt(date[0])) + 1 < 4 || Integer.parseInt(date[1]) > 12 || Integer.parseInt(date[2]) > 31);

        String checkDate = Integer.parseInt(date[0]) + ":" + Integer.parseInt(date[1]) + ":" + Integer.parseInt(date[2]);

        String path = System.getProperty("user.dir") + "\\files\\park.txt";
        String type, id, brand, date1, time;
        String line, _line;

        try {
            File file = new File(path);

            if (!file.exists()) {
                file.createNewFile();
            }
            //read from the file
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            boolean found = false;


            while ((line = br.readLine()) != null) {

                type = line.substring(0, line.indexOf(";"));

                _line = line.substring(line.indexOf(";") + 1, line.length());

                id = _line.substring(0, _line.indexOf(";"));

                _line = _line.substring(_line.indexOf(";") + 1, _line.length());

                brand = _line.substring(0, _line.indexOf(";"));

                _line = _line.substring(_line.indexOf(";") + 1, _line.length());

                date1 = _line.substring(0, _line.indexOf(";"));

                _line = _line.substring(_line.indexOf(";") + 1, _line.length());

                //time = _line.substring(0,_line.indexOf(";"));

                if (checkDate.equals(date1)) {
                    found = true;
                    System.out.println("Vehile Type : " + type);
                    System.out.println("Vehile Id : " + id);
                    System.out.println("Vehile Brand : " + brand);
                    //System.out.println("Time : " + time);
                    System.out.println("");
                }

            }

            if (!found) {
                System.out.println("No vehicles parked in that day");
            }


        } catch (IOException e) {

            e.printStackTrace();
        }
        menu();
    }
}
