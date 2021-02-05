package Controller;

import Common.ReadAndWriteCar;
import Common.ReadAndWriteMotorbike;
import Common.ReadAndWriteTruck;
import Library.CarManager;
import Library.MotorbikeManager;
import Library.TruckManager;
import Model.Car;
import Model.Motorbike;
import Model.Truck;
import Exception.NotFoundVehicleException;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainController {
    static Scanner scanner = new Scanner(System.in);
    static CarManager carManager = new CarManager();
    static TruckManager truckManager = new TruckManager();
    static MotorbikeManager motorbikeManager = new MotorbikeManager();
    static List<Car> carList = ReadAndWriteCar.readCar();
    static List<Truck> truckList = ReadAndWriteTruck.readTruck();
    static List<Motorbike> motorbikeList = ReadAndWriteMotorbike.readMotorbike();

    public static void disPlayMainMenu() {
        while (true) {
            try {
                while (true) {
                    System.out.println(" -------Welcome to Transportation Management System------\n" +
                            "1. Add New Transportation\n" +
                            "2. Show Transportation\n" +
                            "3. Delete Transportation\n" +
                            "4. Edit Transportation\n" +
                            "5. Search Transportation\n" +
                            "6. Exit");
                    int choiceMain = Integer.parseInt(scanner.nextLine());
                    switch (choiceMain) {
                        case 1:
                            addNewTransportation();
                            break;
                        case 2:
                            showTransportation();
                            break;
                        case 3:
                            deleteTransportation();
                            break;
                        case 4:
                            editTransportation();
                            break;
                        case 5:
                            searchTransportation();
                            break;
                        case 6:
                            System.exit(6);
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("You have to enter integer number");
            }
        }
    }

    public static void addNewTransportation() {
        while (true) {
            try {
                while (true) {
                    System.out.println(" ---Enter function Add Transportation---\n" +
                            "1. Add New Car\n" +
                            "2. Add New Truck\n" +
                            "3. Add New Motorbike\n" +
                            "4. Back to Main Menu\n" +
                            "5. Exit");
                    int choiceAddTransport = Integer.parseInt(scanner.nextLine());
                    switch (choiceAddTransport) {
                        case 1:
                            carManager.addCar();
                            break;
                        case 2:
                            truckManager.addTruck();
                            break;
                        case 3:
                            motorbikeManager.addMotorbike();
                            break;
                        case 4:
                            disPlayMainMenu();
                            break;
                        case 5:
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("You have to enter integer number");
            }
        }
    }

    public static void showTransportation() {
        while (true) {
            try {
                while (true) {
                    System.out.println(" ---Enter function Show Transportation---\n" +
                            "1. Show all Car\n" +
                            "2. Show all Truck\n" +
                            "3. Show all Motorbike\n" +
                            "4. Back to Main Menu\n" +
                            "5. Exit");
                    int choiceShowTransport = Integer.parseInt(scanner.nextLine());
                    switch (choiceShowTransport) {
                        case 1:
                            carManager.showCar();
                            break;
                        case 2:
                            truckManager.showTruck();
                            break;
                        case 3:
                            motorbikeManager.showMotorbike();
                            break;
                        case 4:
                            disPlayMainMenu();
                            break;
                        case 5:
                            break;
                    }
                }
            }catch (NumberFormatException e) {
                System.out.println("You have to enter integer number");
            }
        }
    }

    public static String findLicense(String licensePlate) {
        for (Car car : carList) {
            if (licensePlate.equals(car.getLicensePlate())) {
                return licensePlate;
            }
        }
        for (Truck truck : truckList) {
            if (licensePlate.equals(truck.getLicensePlate())) {
                return licensePlate;
            }
        }
        for (Motorbike motorbike : motorbikeList) {
            if (licensePlate.equals(motorbike.getLicensePlate())) {
                return licensePlate;
            }
        }
        return null;
    }

    public static void deleteIfFound(String license) {
        for (Car car : carList) {
            if (license.equals(car.getLicensePlate())) {
                carList.remove(car);
                ReadAndWriteCar.writeCar(carList, false);
                break;
            }
        }
        for (Truck truck : truckList) {
            if (license.equals(truck.getLicensePlate())) {
                truckList.remove(truck);
                ReadAndWriteTruck.writeTruck(truckList, false);
                break;
            }
        }
        for (Motorbike motorbike : motorbikeList) {
            if (license.equals(motorbike.getLicensePlate())) {
                motorbikeList.remove(motorbike);
                ReadAndWriteMotorbike.writeMotorbike(motorbikeList, false);
                break;
            }
        }
    }

    public static void deleteTransportation() {
        System.out.print("Enter license plate that need to delete: ");
        String deleteLicense = scanner.nextLine();
        try {
            if (findLicense(deleteLicense) != null) {
                while (true) {
                    try {
                        while (true) {
                            System.out.println(" Please confirm weather you want to delete vehicle?\n" +
                                    "1. Yes\n" +
                                    "2. No\n" +
                                    "3. Exit");
                            int choiceDeleteTrans = Integer.parseInt(scanner.nextLine());
                            switch (choiceDeleteTrans) {
                                case 1:
                                    deleteIfFound(deleteLicense);
                                    System.out.println("Delete successfully!");
                                    disPlayMainMenu();
                                    break;
                                case 2:
                                    disPlayMainMenu();
                                    break;
                                case 3:
                                    break;
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("You have to enter integer number");
                    }
                }
            } else {
                throw new NotFoundVehicleException("License plate is not Exist");
            }
        } catch (NotFoundVehicleException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void editTransportation() {
        while (true) {
            try {
                while (true) {
                    System.out.println(" ---Enter function Edit Transportation---\n" +
                            "1. Edit Car\n" +
                            "2. Edit Truck\n" +
                            "3. Edit Motorbike\n" +
                            "4. Back to Main Menu\n" +
                            "5. Exit");
                    int choiceEditTransport = Integer.parseInt(scanner.nextLine());
                    switch (choiceEditTransport) {
                        case 1:
                            carManager.editCar();
                            break;
                        case 2:
                            truckManager.editTruck();
                            break;
                        case 3:
                            motorbikeManager.editMotorbike();
                            break;
                        case 4:
                            disPlayMainMenu();
                            break;
                        case 5:
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("You have to enter integer number");
            }
        }
    }
    public static void searchTransportation() {
        while (true) {
            try {
                while (true) {
                    System.out.println(" ---Enter function Search Transportation---\n" +
                            "1. Search Car\n" +
                            "2. Search Truck\n" +
                            "3. Search Motorbike\n" +
                            "4. Back to Main Menu\n" +
                            "5. Exit");
                    int choiceSearchTransport = Integer.parseInt(scanner.nextLine());
                    switch (choiceSearchTransport) {
                        case 1:
                            carManager.searchCar();
                            break;
                        case 2:
                            truckManager.searchTruck();
                            break;
                        case 3:
                            motorbikeManager.searchMotorbike();
                            break;
                        case 4:
                            disPlayMainMenu();
                            break;
                        case 5:
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("You have to enter integer number");
            }
        }
    }
}
