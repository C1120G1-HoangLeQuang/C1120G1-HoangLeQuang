package Commons;

import Models.House;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteHouse {
    static final String PATH_HOUSE = "src/Data/House.csv";
    static File file = new File(PATH_HOUSE);
    public static void writeHouse(List<House> list, boolean option) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, option);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (House house : list) {
                bufferedWriter.write(house.toString());
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
    public static List<House> readHouse() {
        List<House> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arr;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                House house = new House(arr[0], arr[1], Float.parseFloat(arr[2]), Float.parseFloat(arr[3]), Integer.parseInt(arr[4]), arr[5], arr[6], arr[7], Integer.parseInt(arr[8]));
                list.add(house);
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
