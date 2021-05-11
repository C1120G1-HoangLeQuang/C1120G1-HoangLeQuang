package Commons;

import java.util.regex.Pattern;

public class IdForeignRegex {
    public static boolean idForeign(String id) {
        if (!Pattern.matches("^KHNN-[0-9]{5}$", id)) {
            System.out.println("ID is not correct format(KHNN-XXXXX)");
        }
        return Pattern.matches("^KHNN-[0-9]{5}$", id);
    }
}
