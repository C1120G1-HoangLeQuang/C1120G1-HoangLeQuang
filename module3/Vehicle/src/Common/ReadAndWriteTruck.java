package Common;

import Model.Truck;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteTruck {
    static final String PATH_TRUCK = "src/Data/Truck.csv";
    static File file = new File(PATH_TRUCK);
    public static void writeTruck(List<Truck> list, boolean option) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, option);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Truck truck : list) {
                bufferedWriter.write(truck.toString());
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
    public static List<Truck> readTruck() {
        List<Truck> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arr;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                Truck truck = new Truck(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4]));
                list.add(truck);
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
