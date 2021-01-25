package ngay_0_luyen_tap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCSV {
    private static final String PATH = "src/ngay_0_luyen_tap/Test.csv";
    private static final String COMMA = ",";
    private static void printList(List<String> country1) {
        System.out.println("Country [id: "
                + country1.get(0)
                + ", code: "
                + country1.get(1)
                + ", name: "
                + country1.get(2) + "]");
    }
    public static List<String> parseCSV(String cvsLine) {
        List<String> result1 = new ArrayList<>();
        if (cvsLine != null) {
            String[] splitData1 = cvsLine.split(COMMA);
            for (int i = 0; i < splitData1.length; i++) {
                result1.add(splitData1[i]);
            }
        }
        return result1;
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        String line1;
        try {
            bufferedReader = new BufferedReader(new FileReader(PATH));
            while ((line1 = bufferedReader.readLine()) != null) {
                printList(parseCSV(line1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
