package session_15_IOText.bai_tap.bai_2_CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {
    static final String PATH = "src/session_15_IOText/bai_tap/bai_2_CSV/Student.csv";
    private static final String COMMA_DELIMITER = ",";
    private static void printCountry(List<String> country) {
        System.out.println("Country [id: "
                            + country.get(0)
                            + ", code: "
                            + country.get(1)
                            + ", name: "
                            + country.get(2) + "]");
    }
    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        String line;
        try {
            bufferedReader = new BufferedReader(new FileReader(PATH));
            while ((line = bufferedReader.readLine()) != null) {
                    printCountry(parseCsvLine(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
