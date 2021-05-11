package Common;

import Model.VietnameseCustomer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteVietnamese {
    static final String PATH_CUSTOMER = "src/Data/Customer.csv";
    static File file = new File(PATH_CUSTOMER);
    public static void writeVietnamese(List<VietnameseCustomer> list, boolean option) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, option);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (VietnameseCustomer vietnamese : list) {
                bufferedWriter.write(vietnamese.toString());
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
    public static List<VietnameseCustomer> readVietnamese() {
        List<VietnameseCustomer> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arr;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                VietnameseCustomer vietnamese = new VietnameseCustomer(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]));
                list.add(vietnamese);
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
