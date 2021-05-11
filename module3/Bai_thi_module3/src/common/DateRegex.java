package common;

import java.util.regex.Pattern;

public class DateRegex {
    public static boolean checkDate(String date) {
        try{
            if (!Pattern.matches("^((0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/(190[1-9]|19[1-9]\\d|2\\d{3}))$", date)) {
                throw new CustomerException("Information is not correct by format(dd/mm/yyyy)");
            }
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        }
        return Pattern.matches("^((0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/(190[1-9]|19[1-9]\\d|2\\d{3}))$", date);
    }
}
