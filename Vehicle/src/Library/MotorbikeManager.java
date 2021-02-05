package Library;

import Common.ReadAndWriteBrand;
import Common.ReadAndWriteCar;
import Common.ReadAndWriteMotorbike;
import Model.Brand;
import Model.Car;
import Model.Motorbike;
import Regex.LicensePlateRegex;
import Regex.OwnerRegex;
import Regex.YearRegex;

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
    public void editMotorbike() {
        List<Motorbike> motorbikeList = ReadAndWriteMotorbike.readMotorbike();
        List<Brand> brandList = ReadAndWriteBrand.readBrand();
        showMotorbike();
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
                            + "5. HorsePower" + "\n"
                            + "6. Exit");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            String licenseChange = "";
                            do {
                                System.out.print("Enter License Plate: ");
                                licenseChange = scanner.nextLine();
                            } while (!LicensePlateRegex.CarLicenseRegex(licenseChange));
                            motorbikeList.get(idChoice - 1).setLicensePlate(licenseChange);
                            break;
                        case 2:
                            brandManager.showBrand();
                            System.out.println("Enter brand that you need to change");
                            int choiceBrand = Integer.parseInt(scanner.nextLine());
                            String brand = brandList.get(choiceBrand - 1).getNameBrand();
                            motorbikeList.get(idChoice - 1).setBrand(brand);
                            break;
                        case 3:
                            String yearChange;
                            do {
                                System.out.print("Enter year MFG: ");
                                yearChange = scanner.nextLine();
                            } while (!YearRegex.yearRegex(yearChange));
                            motorbikeList.get(idChoice - 1).setYearMFG(yearChange);
                            break;
                        case 4:
                            String ownerChange;
                            do {
                                System.out.print("Enter name of owner: ");
                                ownerChange = scanner.nextLine();
                            } while (!OwnerRegex.checkOwner(ownerChange));
                            motorbikeList.get(idChoice - 1).setOwner(ownerChange);
                            break;
                        case 5:
                            int horsePowerChange = 0;
                            try {
                                System.out.print("Enter horsepower: ");
                                horsePowerChange = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Horsepower have to be integer number");
                            }
                            motorbikeList.get(idChoice - 1).setHorsePower(horsePowerChange);
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
        ReadAndWriteMotorbike.writeMotorbike(motorbikeList, false);
    }
    public void searchMotorbike() {
        List<Motorbike> motorbikeList = ReadAndWriteMotorbike.readMotorbike();
        String licenseSearch;
        System.out.print("Enter license plate that you want to find: ");
        licenseSearch = scanner.nextLine();
        for (Motorbike motorbike : motorbikeList) {
            if (motorbike.getLicensePlate().contains(licenseSearch)) {
                System.out.println(motorbike);
            }
        }
    }
}
