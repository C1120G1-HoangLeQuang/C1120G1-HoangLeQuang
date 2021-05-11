package Commons;

import Models.CustomerType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteType {
    static final String PATH_TYPE = "src/Data/customerType.csv";
    static File file = new File(PATH_TYPE);
    public static void writeType(List<CustomerType> list, boolean option) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file,option);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (CustomerType typeCustomer : list) {
                bufferedWriter.write(typeCustomer.toString());
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
    public static List<CustomerType> readType() {
        List<CustomerType> typeCustomerList = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arr;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                CustomerType typeCustomer = new CustomerType(arr[0], arr[1]);
                typeCustomerList.add(typeCustomer);
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
        return typeCustomerList;
    }
}
