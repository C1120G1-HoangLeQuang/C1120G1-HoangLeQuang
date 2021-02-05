package Library;

import Common.ReadAndWriteBrand;
import Common.ReadAndWriteCar;
import Common.ReadAndWriteMotorbike;
import Common.ReadAndWriteTruck;
import Model.Brand;
import Model.Car;
import Model.Motorbike;
import Model.Truck;
import Regex.LicensePlateRegex;
import Regex.OwnerRegex;
import Regex.YearRegex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TruckManager {
    Scanner scanner = new Scanner(System.in);
    BrandManager brandManager = new BrandManager();
    Truck truck = new Truck();
    public void addTruck() {
        List<Truck> listTruck = new ArrayList<>();
        List<Brand> listBrand = ReadAndWriteBrand.readBrand();
        String licensePlate;
        do {
            System.out.print("Enter License Plate: ");
            licensePlate = scanner.nextLine();
        } while (!LicensePlateRegex.TruckLicenseRegex(licensePlate));
        brandManager.showBrand();
        System.out.print("Enter stt of Customer: ");
        int choiceBrand = Integer.parseInt(scanner.nextLine());
        String brand = listBrand.get(choiceBrand - 1).getNameBrand();
        truck.setBrand(brand);
        System.out.print("Enter year MFG: ");
        String yearMFG = scanner.nextLine();
        System.out.print("Enter name of owner: ");
        String owner = scanner.nextLine();
        int arbitration = 0;
        try {
            System.out.print("Enter arbitration: ");
            arbitration = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Arbitration have to be integer number");
        }
        Truck truck = new Truck(licensePlate, brand, yearMFG, owner, arbitration);
        listTruck.add(truck);
        ReadAndWriteTruck.writeTruck(listTruck, true);
    }
    public void showTruck() {
        List<Truck> listTruck = ReadAndWriteTruck.readTruck();
        for (int i = 0; i < listTruck.size(); i++) {
            System.out.println((i+1) + ". " + listTruck.get(i).showInformation());
        }
    }
    public void editTruck() {
        List<Truck> truckList = ReadAndWriteTruck.readTruck();
        List<Brand> brandList = ReadAndWriteBrand.readBrand();
        showTruck();
        boolean check  = true;
        System.out.println("Enter stt of motorbike to change");
        int idChoice = Integer.parseInt(scanner.nextLine());
        while (check) {
            try {
                while (check) {
                    System.out.println("Enter information that you need to change: " + "\n"
                            + "1. License Plate" + "\n"
                            + "2. Brand" + "\n"
                            + "3. Year MFG" + "\n"
                            + "4. Owner" + "\n"
                            + "5. Arbitration" + "\n"
                            + "6. Exit");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            String licenseChange = "";
                            do {
                                System.out.print("Enter License Plate: ");
                                licenseChange = scanner.nextLine();
                            } while (!LicensePlateRegex.CarLicenseRegex(licenseChange));
                            truckList.get(idChoice - 1).setLicensePlate(licenseChange);
                            break;
                        case 2:
                            brandManager.showBrand();
                            System.out.println("Enter brand that you need to change");
                            int choiceBrand = Integer.parseInt(scanner.nextLine());
                            String brand = brandList.get(choiceBrand - 1).getNameBrand();
                            truckList.get(idChoice - 1).setBrand(brand);
                            break;
                        case 3:
                            String yearChange;
                            do {
                                System.out.print("Enter year MFG: ");
                                yearChange = scanner.nextLine();
                            } while (!YearRegex.yearRegex(yearChange));
                            truckList.get(idChoice - 1).setYearMFG(yearChange);
                            break;
                        case 4:
                            String ownerChange;
                            do {
                                System.out.print("Enter name of owner: ");
                                ownerChange = scanner.nextLine();
                            } while (!OwnerRegex.checkOwner(ownerChange));
                            truckList.get(idChoice - 1).setOwner(ownerChange);
                            break;
                        case 5:
                            int arbitrationChange = 0;
                            try {
                                System.out.print("Enter horsepower: ");
                                arbitrationChange = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Horsepower have to be integer number");
                            }
                            truckList.get(idChoice - 1).setArbitration(arbitrationChange);
                            break;
                        case 6:
                            check = false;
                            break;
                        default:
                            System.out.println("You wrong choice, please enter again");
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("You have to enter integer number");
            }
        }
        ReadAndWriteTruck.writeTruck(truckList, false);
    }
    public void searchTruck() {
        List<Truck> truckList = ReadAndWriteTruck.readTruck();
        System.out.print("Enter license plate that you want to find: ");
        String licenseSearch = scanner.nextLine();
        for (Truck truck : truckList) {
            if (truck.getLicensePlate().contains(licenseSearch)) {
                System.out.println(truck);
            }
        }
    }
}
