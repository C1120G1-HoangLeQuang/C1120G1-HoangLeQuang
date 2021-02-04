package Library;

import Common.ReadAndWriteBrand;
import Common.ReadAndWriteMotorbike;
import Model.Brand;
import Model.Motorbike;
import Regex.LicensePlateRegex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotorbikeManager {
    Scanner scanner = new Scanner(System.in);
    BrandManager brandManager = new BrandManager();
    Motorbike motorbike = new Motorbike();
    public void addMotorbike() {
        List<Motorbike> listMotorbike = new ArrayList<>();
        List<Brand> listBrand = ReadAndWriteBrand.readBrand();
        String licensePlate;
        do {
            System.out.print("Enter License Plate: ");
            licensePlate = scanner.nextLine();
        } while (!LicensePlateRegex.MotorbikeLicenseRegex(licensePlate));
        brandManager.showBrand();
        System.out.print("Enter stt of brand: ");
        int choiceBrand = Integer.parseInt(scanner.nextLine());
        String brand = listBrand.get(choiceBrand - 1).getNameBrand();
        motorbike.setBrand(brand);
        System.out.print("Enter year MFG: ");
        String yearMFG = scanner.nextLine();
        System.out.print("Enter name of owner: ");
        String owner = scanner.nextLine();
        int horsePower = 0;
        try {
            System.out.print("Enter horsepower: ");
            horsePower = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Horsepower have to be integer number");
        }
        Motorbike motorbike = new Motorbike(licensePlate, brand, yearMFG, owner, horsePower);
        listMotorbike.add(motorbike);
        ReadAndWriteMotorbike.writeMotorbike(listMotorbike, true);
    }
    public void showMotorbike() {
        List<Motorbike> listMotorbike = ReadAndWriteMotorbike.readMotorbike();
        for (int i = 0; i < listMotorbike.size(); i++) {
            System.out.println((i+1) + ". " + listMotorbike.get(i).showInformation());
        }
    }
}
