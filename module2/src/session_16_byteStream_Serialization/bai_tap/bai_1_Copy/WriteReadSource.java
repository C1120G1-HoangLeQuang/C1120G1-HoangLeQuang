package session_16_byteStream_Serialization.bai_tap.bai_1_Copy;

import java.io.*;
import java.util.Scanner;

public class WriteReadSource {
    private static final String PATH = "src/session_16_byteStream_Serialization/bai_tap/bai_1_Copy/data.dat";
    private static final String PATH1 = "src/session_16_byteStream_Serialization/bai_tap/bai_1_Copy/Target.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputStream input = null;
        OutputStream output = null;
        try {
            File file = new File(PATH);
            File file1 = new File(PATH1);
            input = new FileInputStream(file);
            output = new FileOutputStream(file1);

            byte[] buffer = new byte[1];
            int length;
            int countBytes = 0;
            while ((length = input.read(buffer)) > 0){
                output.write(buffer, 0, length);
                countBytes++;
            }
            System.out.println("File have " + countBytes + " bytes");
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
