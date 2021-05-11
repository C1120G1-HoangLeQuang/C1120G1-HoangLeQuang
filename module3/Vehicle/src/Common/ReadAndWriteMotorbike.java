package Common;

import Model.Motorbike;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteMotorbike {
    static final String PATH_MOTORBIKE = "src/Data/Motorbike.csv";
    static File file = new File(PATH_MOTORBIKE);
    public static void writeMotorbike(List<Motorbike> list, boolean option) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, option);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Motorbike motorbike : list) {
                bufferedWriter.write(motorbike.toString());
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
    public static List<Motorbike> readMotorbike() {
        List<Motorbike> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arr;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                Motorbike motorbike = new Motorbike(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4]));
                list.add(motorbike);
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
