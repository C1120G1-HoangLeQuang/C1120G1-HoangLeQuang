package common;

import java.util.regex.Pattern;

public class TelephoneNumberRegex {
    public static boolean checkTelephoneNumber(int telephoneNumber)  {
        String phoneNumberConvert = Integer.toString(telephoneNumber);
        try {
            if (!Pattern.matches("^((090|091)([\\d]{7}))|((\\(\\+84\\))(90([\\d]{7})))|((\\(\\+84\\))(91([\\d]{7})))$", phoneNumberConvert)) {
                throw new CustomerException("Information is not correct by format(XXXXXXXXX)");
            }
        }catch (CustomerException e) {
            System.out.println(e.getMessage());
        }
        return Pattern.matches("^[\\d]{9}$", phoneNumberConvert);
    }
}
