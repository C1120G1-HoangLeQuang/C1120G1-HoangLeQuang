package Regex.CustomerRegex;

import Exception.CustomerException.CustomerException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class DOBRegex {
    public static boolean checkDOB(String dateOfBirth) {
        try {
            if (!Pattern.matches("^((0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/(190[1-9]|19[1-9]\\d|2\\d{3}))$", dateOfBirth)) {
                throw new CustomerException("Information is not correct by format(dd/mm/yyyy)");
            } else {
                String[] date = dateOfBirth.split("/");
                int year = Integer.parseInt(date[2]);
                String string = date[0] + "/" + date[1] + "/" + (year + 18);
                Date dateCheck = new SimpleDateFormat("dd/MM/yyyy").parse(string);
                if (dateCheck.compareTo(new Date()) <= 0) {
                    return Pattern.matches("^((0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/(190[1-9]|19[1-9]\\d|2\\d{3}))$", dateOfBirth);
                }
                throw new CustomerException("Birthday must be at least 18 years before the current date");
            }
        } catch (CustomerException | ParseException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
