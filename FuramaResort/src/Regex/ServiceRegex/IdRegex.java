package Regex.ServiceRegex;

import java.util.regex.Pattern;

public class IdRegex {

    public static boolean checkIdVilla(String idService) {
        if (!Pattern.matches("^SVVL-[0-9]{4}$", idService)) {
            System.out.println("Error! Enter again!");
        }
        return Pattern.matches("^SVVL-[0-9]{4}$", idService);
    }

    public static boolean checkIdHouse(String idService) {
        if (!Pattern.matches("^SVHO-[0-9]{4}$", idService)) {
            System.out.println("Error! Enter again!");
        }
        return Pattern.matches("^SVHO-[0-9]{4}$", idService);
    }

    public static boolean checkIdRoom(String idService) {
        if (!Pattern.matches("^SVRO-[0-9]{4}$", idService)) {
            System.out.println("Error! Enter again!");
        }
        return Pattern.matches("^SVRO-[0-9]{4}$", idService);
    }
}
