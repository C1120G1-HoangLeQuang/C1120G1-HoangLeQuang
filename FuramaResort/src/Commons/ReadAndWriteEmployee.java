package Commons;

import Models.Booking;
import Models.Customer;
import Models.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteEmployee {
    static final String PATH_EMPLOYEE = "src/Data/Employee.csv";
    static File file = new File(PATH_EMPLOYEE);
    public static void writeEmployee(List<Employee> list, boolean option) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file,option);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee employee : list) {
                bufferedWriter.write(employee.toString());
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
    public static List<Employee> readEmployee() {
        List<Employee> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arr;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                Employee employee = new Employee(Integer.parseInt(arr[0]),arr[1], Integer.parseInt(arr[2]), arr[3]);
                list.add(employee);
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
