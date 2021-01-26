package session_16_byteStream_Serialization.thuc_hanh;

import java.io.*;
import java.util.Scanner;

public class CopyFile {
    private static final String PATH = "src/session_16_byteStream_Serialization/thuc_hanh/Sources.dat";
    private static final String PATH1 = "src/session_16_byteStream_Serialization/thuc_hanh/Target.dat";

    private static void copyFileUsingStream(File source, File target) throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(target);
            byte[] buffer = new byte[1];
            int length;
            int count = 0;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
                count++;
            }
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            input.close();
            output.close();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter source path: ");
        String sourcePath = scanner.nextLine();
        System.out.println("Enter target path: ");
        String targetPath = scanner.nextLine();
        File sourceFile  = new File(sourcePath);
        File targetFile = new File(targetPath);
        try {
            copyFileUsingStream(sourceFile, targetFile);
            System.out.println("Copy complete!");
        } catch (IOException e) {
            System.out.println("Can't copy that file");
            System.out.println(e.getMessage());
        }
    }
}
