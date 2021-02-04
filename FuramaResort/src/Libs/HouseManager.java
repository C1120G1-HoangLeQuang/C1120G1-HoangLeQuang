package Libs;

import Commons.ReadAndWriteHouse;
import Commons.ReadAndWriteVilla;
import Models.House;
import Models.Villa;
import Regex.ServiceRegex.*;

import java.util.*;

public class HouseManager {
    Scanner scanner = new Scanner(System.in);
    public void addHouse() {
        List<House> listHouse = new ArrayList<>();
        String id;
        do {
            System.out.print("Enter id: ");
            id = scanner.nextLine();
        } while(!IdRegex.checkIdHouse(id));
        String nameService;
        do {
            System.out.print("Enter name service: ");
            nameService = scanner.nextLine();
        } while (!NameSvRegex.checkNameService(nameService));
        float area = 0;
        do {
            try {
                System.out.print("Enter area: ");
                area = Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Area have to be a float number");
            }
        } while (!AreaSvAndPoolRegex.checkAre(area));
        float price = 0;
        do {
            try {
                System.out.print("Enter price: ");
                price = Float.parseFloat(scanner.nextLine());
            }catch (NumberFormatException e) {
                System.out.println("Price have to be a float number");
            }
        }while (!PriceRegex.checkPrice(price));
        int maxPeople = 0;
        do {
            try {
                System.out.print("Enter max people: ");
                maxPeople = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e) {
                System.out.println("Num of people have to be a integer number");
            }
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
        int numFloor = 0;
        do {
            try {
                System.out.print("Enter number of floor: ");
                numFloor = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e) {
                System.out.println("Num of floor have to be a integer number");
            }
        }while (!FloorRegex.checkFloor(numFloor));
        House house = new House(id, nameService, area, price, maxPeople, typeRental, roomStandard, otherService, numFloor);
        listHouse.add(house);
        ReadAndWriteHouse.writeHouse(listHouse, true);
    }
    public void showHouse() {
        List<House> listHouse = ReadAndWriteHouse.readHouse();
        for (int i = 0; i < listHouse.size(); i++) {
            System.out.println((i+1) + ". " + listHouse.get(i).showInformation());
        }
    }
    public void showHouseNotDuplicate() {
        List<House> listHouse = ReadAndWriteHouse.readHouse();
        TreeSet<House> treeSetHouse = new TreeSet<>(new Comparator<House>() {
            @Override
            public int compare(House o1, House o2) {
                if (o1.getNameService().compareTo(o2.getNameService()) > 0) {
                    return 1;
                } else if (o1.getNameService().compareTo(o2.getNameService()) < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        treeSetHouse.addAll(listHouse);
        System.out.println(treeSetHouse);
    }
}
