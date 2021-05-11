package Common;

import java.util.regex.Pattern;

public class GoiVIPRegex {
    public static boolean goiVIP(String vip) {
        if (!Pattern.matches("^(VIP1|VIP2|VIP3)$", vip)) {
            System.out.println("Goi VIP is not correct format(VIP1/VIP2/VIP3)");
        }
        return Pattern.matches("^(VIP1|VIP2|VIP3)$", vip);
    }
}
