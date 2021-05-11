package Common;

import Model.Brand;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteBrand {
    static final String PATH_BRAND = "src/Data/ManufactureBrand.csv";
    static File file = new File(PATH_BRAND);
    public static void writeBrand(List<Brand> list, boolean option) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, option);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Brand brand : list) {
                bufferedWriter.write(brand.toString());
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
    public static List<Brand> readBrand() {
        List<Brand> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arr;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                Brand brand = new Brand(arr[0], arr[1], arr[2]);
                list.add(brand);
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
