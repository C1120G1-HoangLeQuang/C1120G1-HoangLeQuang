package session_15_IOText.bai_tap_ngoai;

import session_15_IOText.bai_tap_ngoai.Class;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static List getStudent(String line) {
        List<String> result = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == '\"') {
                if (string.length() > 0 && stack.size() % 2 == 0) {
                    string.append(ch);
                    stack.push(ch);
                }
            } else if (ch ==',' && stack.size() % 2 == 0) {
                result.add(string.toString());
                stack.clear();
                string = new StringBuilder();
            } else if (ch == ',' && stack.size() % 2 != 0) {
                string.append(ch);
            } else {
                string.append(ch);
            }
        }
        result.add(string.toString());
        return result;
    }
    public static void main(String[] args) {
        String path = "src/session_15_IOText/bai_tap/bai_2_CSV/Student.csv";
//        Class student = new Class("1", "Levi", "Ackerman", "Japan");
        List<Class> classes = new ArrayList<>();
        try {
            BufferedReader bir = new BufferedReader(new FileReader(path));
            String line = bir.readLine();
            while (line != null) {
                List<String> result = getStudent(line);
                classes.add(new
                        Class(result.get(0).trim(), result.get(1).trim(),
                        result.get(2).trim(), result.get(3).trim(), result.get(4).trim()));
                line = bir.readLine();
            }
            System.out.println("SHOW ALL");
            System.out.println("-----------------------------------------");
            classes.forEach(aClass -> System.out.println("LastName: " + aClass.getLastName() + "\n"
                    + "First Name: " + aClass.getFirstName() + "\n"
                    + "Street: " + aClass.getStreet() + "\n"
                    + "District: " + aClass.getDistrict() + "\n"
                    + "City" + aClass.getCity()));
            System.out.println("-----------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
