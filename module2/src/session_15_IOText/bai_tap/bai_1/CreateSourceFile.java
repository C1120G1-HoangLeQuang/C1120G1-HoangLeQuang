package session_15_IOText.bai_tap.bai_1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreateSourceFile {
    private static final String PATH = "src/session_15_IOText/bai_tap/bai_1";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name of file: ");
        String inputName = scanner.nextLine();
        File dir = new File(PATH);                      // tao doi tuong File tro? toi duong dan
        File file = new File(PATH, inputName);   //Tạo đối tượng File trỏ tới đường dẫn
        try {
            //Tạo file
            if (file.createNewFile()){
                System.out.println("File created..");
            }else {
                System.out.println("File already exists..");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (dir.isDirectory()) {                       // liet ke noi dung thu muc
            String[] dirContent = dir.list();
            for (int i = 0; i < dirContent.length; i++) {
                System.out.println(dirContent[i]);
            }
        }
    }
}
