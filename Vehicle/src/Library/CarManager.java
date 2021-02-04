package Library;

import Common.ReadAndWriteBrand;
import Common.ReadAndWriteCar;
import Model.Brand;
import Model.Car;
import Regex.LicensePlateRegex;

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
        System.out.print("Enter year MFG: ");
        String yearMFG = scanner.nextLine();
        System.out.print("Enter name of owner: ");
        String owner = scanner.nextLine();
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
}
