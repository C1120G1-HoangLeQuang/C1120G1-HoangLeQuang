package Libs;

import Commons.ReadAndWriteRoom;
import Commons.ReadAndWriteVilla;
import Models.Room;
import Models.Villa;
import Regex.ServiceRegex.*;

import java.util.*;

public class RoomManager {
    Scanner scanner = new Scanner(System.in);

    public void addRoom() {
        List<Room> listRoom = new ArrayList<>();
        String id;
        do {
            System.out.print("Enter id: ");
            id = scanner.nextLine();
        } while(!IdRegex.checkIdRoom(id));
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
        System.out.print("Enter free service: ");
        String freeService = scanner.nextLine();
        Room room = new Room(id, nameService, area, price, maxPeople, typeRental, freeService);
        listRoom.add(room);
        ReadAndWriteRoom.writeRoom(listRoom, true);
    }
    public void showRoom() {
        List<Room> listRoom = ReadAndWriteRoom.readRoom();
        for (int i = 0; i < listRoom.size(); i++) {
            System.out.println((i+1) + ". " + listRoom.get(i).showInformation());
        }
    }
    public void showRoomNotDuplicate() {
        List<Room> listRoom = ReadAndWriteRoom.readRoom();
        TreeSet<Room> treeSetRoom = new TreeSet<>(new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                if (o1.getNameService().compareTo(o2.getNameService()) > 0) {
                    return 1;
                } else if (o1.getNameService().compareTo(o2.getNameService()) < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        treeSetRoom.addAll(listRoom);
        System.out.println(treeSetRoom);
    }
}
