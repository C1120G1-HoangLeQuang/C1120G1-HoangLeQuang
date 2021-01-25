package session_15_IOText.bai_tap.bai_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadContentSources {
    static final String PATH1 = "src/session_15_IOText/bai_tap/bai_1/SourcesText.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileWriter fileWriter = null;
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileWriter = new FileWriter(PATH1);
            System.out.println("Enter content: ");
            String content = scanner.nextLine();
            fileWriter.write(content);
            fileReader = new FileReader(PATH1);
            bufferedReader = new BufferedReader(fileReader);
            StringBuffer result = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
            System.out.println(result);
            bufferedReader.close();
            fileReader.close();
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
