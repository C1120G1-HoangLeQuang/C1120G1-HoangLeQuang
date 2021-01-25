package ngay_0_luyen_tap;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteFileCVS {
    private static final String COMMA = ",";
    private static final String DOWN = "\n";
    private static final String HEADER = "id, code, name";
    private static final String PATH = "src/ngay_0_luyen_tap";
    public static void Write(File path) {
        Country country1 = new Country(1, "US", "United States");
        Country country2 = new Country(2, "JPN", "Japan");
        Country country3 = new Country(3, "BRI", "Britain");
        List<Country> list = new ArrayList<>();
        list.add(country1);
        list.add(country2);
        list.add(country3);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
            fileWriter.append(HEADER);
            fileWriter.append(DOWN);
            for (Country country: list) {
                fileWriter.append(String.valueOf(country.getId()));
                fileWriter.append(COMMA);
                fileWriter.append(String.valueOf(country.getCode()));
                fileWriter.append(COMMA);
                fileWriter.append(String.valueOf(country.getName()));
                fileWriter.append(DOWN);
            }
            System.out.println("File CVS is created successfully!");
        } catch (IOException e) {
            System.out.println("Error in Writer !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name: ");
        String fileName = scanner.nextLine();
        File dir = new File(PATH);
        dir.mkdir();
        File file = new File(PATH, fileName);
        Write(file);
    }
}
