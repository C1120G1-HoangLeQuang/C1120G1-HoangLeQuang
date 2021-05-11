package Common;

import java.util.regex.Pattern;

public class MaBNRegex {
    public static boolean maBN(String maBN) {
        if (!Pattern.matches("^BN-[0-9]{3}$", maBN)) {
            System.out.println("ID is not correct format(BN-XXX)");
        }
        return Pattern.matches("^BN-[0-9]{3}$", maBN);
    }
}
