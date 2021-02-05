package Library;

import Common.ReadAndWriteBrand;
import Common.ReadAndWriteCar;
import Model.Brand;
import Model.Car;
import Regex.LicensePlateRegex;
import Regex.OwnerRegex;
import Regex.YearRegex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarManager {
    Scanner scanner = new Scanner(System.in);
    BrandManager brandManager = new BrandManager();
    Car car = new Car();
    public void addCar() {
        List<Car> listCar = new ArrayList<>();
        List<Brand> listBrand = ReadAndWriteBrand.readBrand();
        String licensePlate;
        do {
            System.out.print("Enter License Plate: ");
            licensePlate = scanner.nextLine();
        } while (!LicensePlateRegex.CarLicenseRegex(licensePlate));
        brandManager.showBrand();
        System.out.print("Enter stt of brand: ");
        int choiceBrand = Integer.parseInt(scanner.nextLine());
        String brand = listBrand.get(choiceBrand - 1).getNameBrand();
        car.setBrand(brand);
        String yearMFG;
        do {
            System.out.print("Enter year MFG: ");
            yearMFG = scanner.nextLine();
        } while (!YearRegex.yearRegex(yearMFG));
        String owner;
        do {
            System.out.print("Enter name of owner: ");
            owner = scanner.nextLine();
        } while (!OwnerRegex.checkOwner(owner));
        int numSeat = 0;
        try {
            System.out.print("Enter number seat: ");
            numSeat = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Number of seat have to be integer number");
        }
        String typeCar = "";
        if (licensePlate.contains("A")) {
            System.out.println("Type of car: " + (typeCar = "TouristCar"));
        } else if (licensePlate.contains("B")) {
            System.out.println("Type of Car: " + (typeCar = "FamilyCar"));
        }
        Car car = new Car(licensePlate, brand, yearMFG, owner, numSeat, typeCar);
        listCar.add(car);
        ReadAndWriteCar.writeCar(listCar, true);
    }
    public void showCar() {
        List<Car> listCar = ReadAndWriteCar.readCar();
        for (int i = 0; i < listCar.size(); i++) {
            System.out.println((i+1) + ". " + listCar.get(i).showInformation());
        }
    }
    public void editCar() {
        List<Car> carList = ReadAndWriteCar.readCar();
        List<Brand> brandList = ReadAndWriteBrand.readBrand();
        showCar();
        boolean check  = true;
        System.out.println("Enter stt of car to change");
        int idChoice = Integer.parseInt(scanner.nextLine());
        while (check) {
            try {
                while (check) {
                    System.out.println("Enter information that you need to change: " + "\n"
                            + "1. License Plate" + "\n"
                            + "2. Brand" + "\n"
                            + "3. Year MFG" + "\n"
                            + "4. Owner" + "\n"
                            + "5. Number of Seat" + "\n"
                            + "6. Exit");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            String licenseChange = "";
                            String typeCarChange = "";
                            do {
                                System.out.print("Enter License Plate: ");
                                licenseChange = scanner.nextLine();
                            } while (!LicensePlateRegex.CarLicenseRegex(licenseChange));
                            carList.get(idChoice - 1).setLicensePlate(licenseChange);
                            if (licenseChange.contains("A")) {
                                System.out.println("Type of car: " + (typeCarChange = "TouristCar"));
                            } else if (licenseChange.contains("B")) {
                                System.out.println("Type of Car: " + (typeCarChange = "FamilyCar"));
                            }
                            carList.get(idChoice - 1).setTypeCar(typeCarChange);
                            break;
                        case 2:
                            brandManager.showBrand();
                            System.out.println("Enter brand that you need to change");
                            int choiceBrand = Integer.parseInt(scanner.nextLine());
                            String brand = brandList.get(choiceBrand - 1).getNameBrand();
                            carList.get(idChoice - 1).setBrand(brand);
                            break;
                        case 3:
                            String yearChange;
                            do {
                                System.out.print("Enter year MFG: ");
                                yearChange = scanner.nextLine();
                            } while (!YearRegex.yearRegex(yearChange));
                            carList.get(idChoice - 1).setYearMFG(yearChange);
                            break;
                        case 4:
                            String ownerChange;
                            do {
                                System.out.print("Enter name of owner: ");
                                ownerChange = scanner.nextLine();
                            } while (!OwnerRegex.checkOwner(ownerChange));
                            carList.get(idChoice - 1).setOwner(ownerChange);
                            break;
                        case 5:
                            int numSeatChange = 0;
                            try {
                                System.out.print("Enter number seat: ");
                                numSeatChange = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Number of seat have to be integer number");
                            }
                            carList.get(idChoice - 1).setNumberSeat(numSeatChange);
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
        ReadAndWriteCar.writeCar(carList, false);
    }
    public void searchCar() {
        List<Car> carList = ReadAndWriteCar.readCar();
        System.out.print("Enter license plate that you want to find: ");
        String licenseSearch = scanner.nextLine();
        for (Car car : carList) {
            if (car.getLicensePlate().contains(licenseSearch)) {
                System.out.println(car);
            }
        }
    }
}
