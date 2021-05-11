package Common;


import Model.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteCar {
    static final String PATH_CAR = "src/Data/Car.csv";
    static File file = new File(PATH_CAR);
    public static void writeCar(List<Car> list, boolean option) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, option);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Car car : list) {
                bufferedWriter.write(car.toString());
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
    public static List<Car> readCar() {
        List<Car> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arr;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                Car car = new Car(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4]), arr[5]);
                list.add(car);
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
