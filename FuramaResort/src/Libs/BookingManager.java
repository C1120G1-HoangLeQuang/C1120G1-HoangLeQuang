package Libs;

import Commons.*;
import Models.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingManager {
    CustomerManager customerManager = new CustomerManager();
    VillaManager villaManager = new VillaManager();
    HouseManager houseManager = new HouseManager();
    RoomManager roomManager = new RoomManager();
    Booking booking = new Booking();
    Scanner scanner= new Scanner(System.in);
    public void addBooking() {
        List<Booking> listBooking = new ArrayList<>();
        List<Customer> listCustomer = ReadAndWriteCustomer.readCustomer();
        customerManager.showCustomer();
        System.out.print("Enter stt of Customer: ");
        int choiceCustomer = Integer.parseInt(scanner.nextLine());
        int idCustomerBooking = listCustomer.get(choiceCustomer - 1).getIdCustomer();
        booking.setIdCustomer(idCustomerBooking);
            System.out.println(" ---Enter function Add Booking from Service---\n" +
                    "1. Booking Villa\n" +
                    "2. Booking House\n" +
                    "3. Booking Room\n" +
                    "4. Exit");
            int choiceAddBooking = Integer.parseInt(scanner.nextLine());
            switch (choiceAddBooking) {
                case 1:
                    List<Villa> listVilla = ReadAndWriteVilla.readVilla();
                    villaManager.showVilla();
                    System.out.print("Enter stt of Villa: ");
                    int choiceVilla = Integer.parseInt(scanner.nextLine());
                    String idVillaBooking = listVilla.get(choiceVilla - 1).getId();
                    booking.setIdService(idVillaBooking);
                    break;
                case 2:
                    List<House> listHouse = ReadAndWriteHouse.readHouse();
                    houseManager.showHouse();
                    System.out.print("Enter stt of House: ");
                    int choiceHouse = Integer.parseInt(scanner.nextLine());
                    String idHouseBooking = listHouse.get(choiceHouse - 1).getId();
                    booking.setIdService(idHouseBooking);
                    break;
                case 3:
                    List<Room> listRoom = ReadAndWriteRoom.readRoom();
                    roomManager.showRoom();
                    System.out.print("Enter stt of Room: ");
                    int choiceRoom = Integer.parseInt(scanner.nextLine());
                    String idRoomBooking = listRoom.get(choiceRoom - 1).getId();
                    booking.setIdService(idRoomBooking);
                    break;
                case 4:
                    break;
            }
            listBooking.add(booking);
            ReadAndWriteBooking.writeBooking(listBooking, true);
        }
    public void showBooking() {
        List<Booking> list = ReadAndWriteBooking.readBooking();
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + ". " + list.get(i).showInformation());
        }
    }
}
