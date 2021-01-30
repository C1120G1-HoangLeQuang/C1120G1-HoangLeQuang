package Regex.ServiceRegex;

import java.util.regex.Pattern;

public class NameSvRegex {

    public static boolean checkNameService(String nameService) {
        if (!Pattern.matches("^[A-Z]{1}[a-z]+$", nameService)) {
            System.out.println("Error! Enter again!");
        }
        return Pattern.matches("^[A-Z]{1}[a-z]+$", nameService);
    }
}
