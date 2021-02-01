package Regex.CustomerRegex;

import Exception.CustomerException.CustomerException;
import java.util.regex.Pattern;

public class DOBRegex {
    public static boolean checkDOB(String dateOfBirth) {
        try {
            if (!Pattern.matches("^((0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/[12]\\d{3})$", dateOfBirth)) {
                throw new CustomerException("Information is not correct by format(dd/mm/yyyy)");
            }
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        }
        return Pattern.matches("^((0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/[12]\\d{3})$", dateOfBirth);
    }
}
