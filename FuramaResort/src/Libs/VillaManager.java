package Libs;

import Commons.ReadAndWriteVilla;
import Models.Villa;
import Regex.ServiceRegex.*;

import java.util.*;

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

        float area = 0;
        do {
            try {
                System.out.print("Enter area: ");
                area = Float.parseFloat(scanner.nextLine());
            }catch (NumberFormatException e) {
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
        float poolArea = 0;
        do {
            try {
                System.out.print("Enter area of pool: ");
                poolArea = Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Pool area have to be a float number");
            }
        }while (!AreaSvAndPoolRegex.checkAre(poolArea));
        int numFloor = 0;
        do {
            try {
                System.out.print("Enter number of floor: ");
                numFloor = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e) {
                System.out.println("Num of floor have to be a float number");
            }
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
    public void showVillaNotDuplicate() {
        List<Villa> listVilla = ReadAndWriteVilla.readVilla();
        TreeSet<Villa> treeSetVilla = new TreeSet<>(new Comparator<Villa>() {
            @Override
            public int compare(Villa o1, Villa o2) {
                if (o1.getNameService().compareTo(o2.getNameService()) > 0) {
                    return 1;
                } else if (o1.getNameService().compareTo(o2.getNameService()) < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        treeSetVilla.addAll(listVilla);
        System.out.println(treeSetVilla);
    }
}
