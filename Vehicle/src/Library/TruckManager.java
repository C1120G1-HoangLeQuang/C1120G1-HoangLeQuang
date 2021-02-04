package Library;

import Common.ReadAndWriteBrand;
import Common.ReadAndWriteMotorbike;
import Common.ReadAndWriteTruck;
import Model.Brand;
import Model.Motorbike;
import Model.Truck;
import Regex.LicensePlateRegex;

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
        System.out.print("Enter arbitration: ");
        int arbitration = Integer.parseInt(scanner.nextLine());
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
}
