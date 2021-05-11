package Common;

import java.util.regex.Pattern;

public class MaBARegex {
    public static boolean maBA(String maBA) {
        if (!Pattern.matches("^BA-[0-9]{3}$", maBA)) {
            System.out.println("ID is not correct format(BA-XXX)");
        }
        return Pattern.matches("^BA-[0-9]{3}$", maBA);
    }
}
