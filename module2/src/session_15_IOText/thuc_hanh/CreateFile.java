package session_15_IOText.thuc_hanh;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreateFile {
    private static final String PATH = "src/session_15_IOText/thuc_hanh";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of file: ");
        String nameFile = scanner.nextLine();
        File dir = new File(PATH);
        dir.mkdir();
        File file = new File(PATH, nameFile);
        try {
            if (file.createNewFile()) {
                System.out.println("file created.");
            } else {
                System.out.println("file already exist.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (dir.isDirectory()) {
            String[] dirContent = dir.list();
            for (int i = 0; i < dirContent.length; i++) {
                System.out.println(dirContent[i]);
            }
        }
    }
}
