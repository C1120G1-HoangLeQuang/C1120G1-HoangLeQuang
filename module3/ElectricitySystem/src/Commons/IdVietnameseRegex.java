package Commons;

import java.util.regex.Pattern;

public class IdVietnameseRegex {
    public static boolean idVietnamese(String id) {
        if (!Pattern.matches("^KHVN-[0-9]{5}$", id)) {
            System.out.println("ID is not correct format(KHVN-XXXXX)");
        }
        return Pattern.matches("^KHVN-[0-9]{5}$", id);
    }
}
