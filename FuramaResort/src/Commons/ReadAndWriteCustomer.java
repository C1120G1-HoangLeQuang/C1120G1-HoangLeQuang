package Commons;

import Models.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteCustomer {
    static final String PATH_CUSTOMER = "src/Data/Customer.csv";
    static File file = new File(PATH_CUSTOMER);
    public static void writeCustomer(List<Customer> list, boolean option) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer : list) {
                bufferedWriter.write(customer.toString());
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
    public static List<Customer> readCustomer() {
        List<Customer> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arr;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                Customer customer = new Customer(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), arr[5], arr[6], arr[7]);
                list.add(customer);
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
