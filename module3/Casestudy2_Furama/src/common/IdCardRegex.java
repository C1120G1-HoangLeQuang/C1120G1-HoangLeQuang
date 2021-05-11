package common;

import java.util.regex.Pattern;

public class IdCardRegex {

    public static boolean checkIdCard(String idCard)  {
        try {
            if (!Pattern.matches("^[\\d]{9}$", idCard)) {
                throw new CustomerException("Information is not correct by format(XXXXXXXXX)");
            }
        }catch (CustomerException e) {
            System.out.println(e.getMessage());
        }
        return Pattern.matches("^[\\d]{9}$", idCard);
    }
}
