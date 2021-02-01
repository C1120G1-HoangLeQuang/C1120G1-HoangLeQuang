package Commons;

import Models.Booking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteBooking {
    static final String PATH_BOOKING = "src/Data/Booking.csv";
    static File file = new File(PATH_BOOKING);
    public static void writeBooking(List<Booking> list, boolean option) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file,option);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Booking booking : list) {
                bufferedWriter.write(booking.toString());
                bufferedWriter.newLine();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static List<Booking> readBooking() {
        List<Booking> listBooking = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arr;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                Booking booking = new Booking(Integer.parseInt(arr[0]), arr[1]);
                listBooking.add(booking);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listBooking;
    }
}
