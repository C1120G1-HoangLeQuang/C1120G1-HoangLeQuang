package Commons;

import Models.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteVilla {
    static final String PATH_VILLA = "src/Data/Villa.csv";
    static File file = new File(PATH_VILLA);
    public static void writeVilla(List<Villa> list, boolean option) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, option);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Villa villa : list) {
                bufferedWriter.write(villa.toString());
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
    public static List<Villa> readVilla() {
        List<Villa> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arr;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                Villa villa = new Villa(arr[0], arr[1], Float.parseFloat(arr[2]), Float.parseFloat(arr[3]), Integer.parseInt(arr[4]), arr[5], arr[6], arr[7], Float.parseFloat(arr[8]), Integer.parseInt(arr[9]));
                list.add(villa);
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
