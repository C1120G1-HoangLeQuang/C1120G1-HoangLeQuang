package Libs;

import Commons.ReadAndWriteVilla;
import Models.Villa;
import Regex.ServiceRegex.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class VillaManager {
    Scanner scanner = new Scanner(System.in);
    public void addVilla() {
        List<Villa> listVilla = new ArrayList<>();
        String id;
        do {
            System.out.print("Enter id: ");
            id = scanner.nextLine();
        } while(!IdRegex.checkIdVilla(id));
        String nameService;
        do {
            System.out.print("Enter name service: ");
            nameService = scanner.nextLine();
        } while (!NameSvRegex.checkNameService(nameService));

        float area;
        do {
            System.out.print("Enter area: ");
           area = Float.parseFloat(scanner.nextLine());
        } while (!AreaSvAndPoolRegex.checkAre(area));
        float price;
        do {
            System.out.print("Enter price: ");
            price = Float.parseFloat(scanner.nextLine());
        }while (!PriceRegex.checkPrice(price));
        int maxPeople;
        do {
            System.out.print("Enter max people: ");
            maxPeople = Integer.parseInt(scanner.nextLine());
        }while (!MaxPeopleRegex.checkMaxPeople(maxPeople));
        String typeRental;
        do {
            System.out.print("Enter type of rental: ");
            typeRental = scanner.nextLine();
        }while (!TypeRentalRegex.checkTypeRental(typeRental));
        System.out.print("Enter room standard: ");
        String roomStandard = scanner.nextLine();
        System.out.print("Enter others service: ");
        String otherService = scanner.nextLine();
        float poolArea;
        do {
            System.out.print("Enter area of pool: ");
            poolArea = Float.parseFloat(scanner.nextLine());
        }while (!AreaSvAndPoolRegex.checkAre(poolArea));
        int numFloor;
        do {
            System.out.print("Enter number of floor: ");
            numFloor = Integer.parseInt(scanner.nextLine());
        }while (!FloorRegex.checkFloor(numFloor));
        Villa villa = new Villa(id, nameService, area, price, maxPeople, typeRental, roomStandard, otherService, poolArea, numFloor);
        listVilla.add(villa);
        ReadAndWriteVilla.writeVilla(listVilla, true);
    }
    public void showVilla() {
        List<Villa> listVilla = ReadAndWriteVilla.readVilla();
        for (int i = 0; i < listVilla.size(); i++) {
            System.out.println((i+1) + ". " + listVilla.get(i).showInformation());
        }
    }
}
