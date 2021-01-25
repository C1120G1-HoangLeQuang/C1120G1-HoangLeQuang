package session_15_IOText.bai_tap.bai_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteContentTarget {
    static final String PATH = "src/session_15_IOText/bai_tap/bai_1/TargetText.txt";
    static final String PATH1 = "src/session_15_IOText/bai_tap/bai_1/SourcesText.txt";

    public static void main(String[] args) {
        FileWriter fileWriter = null;  // copy vao Target
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(PATH1);
            bufferedReader = new BufferedReader(fileReader);
            StringBuffer result = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
//            System.out.println(result);
            bufferedReader.close();
            fileReader.close();
            fileWriter = new FileWriter(PATH);
            fileWriter.write(String.valueOf(result));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
