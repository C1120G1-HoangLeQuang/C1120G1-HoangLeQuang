package Common;

import Model.ForeignCustomer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteForeign {
    static final String PATH_CUSTOMER = "src/Data/Customer.csv";
    static File file = new File(PATH_CUSTOMER);
    public static void writeForeign(List<ForeignCustomer> list, boolean option) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, option);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (ForeignCustomer foreign : list) {
                bufferedWriter.write(foreign.toString());
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
    public static List<ForeignCustomer> readForeign() {
        List<ForeignCustomer> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arr;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                ForeignCustomer foreign = new ForeignCustomer(arr[0], arr[1], arr[2]);
                list.add(foreign);
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
