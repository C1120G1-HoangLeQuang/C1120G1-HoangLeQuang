package Commons;

import Models.Room;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteRoom {
    static final String PATH_ROOM = "src/Data/Room.csv";
    static File  file = new File(PATH_ROOM);
    public static void writeRoom(List<Room> list, boolean option) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Room room : list) {
                bufferedWriter.write(room.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static List<Room> readRoom() {
        List<Room> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arr;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                Room room = new Room(arr[0], arr[1], Float.parseFloat(arr[2]), Float.parseFloat(arr[3]), Integer.parseInt(arr[4]), arr[5], arr[6]);
                list.add(room);
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
        return list;
    }
}
