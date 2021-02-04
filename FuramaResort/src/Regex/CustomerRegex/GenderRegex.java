package Regex.CustomerRegex;

import Exception.CustomerException.CustomerException;
import Exception.CustomerException.GenderException;

import java.util.regex.Pattern;

public class GenderRegex {
    public static boolean checkGender(String gender) {
        try {
            if (!Pattern.matches("^(male|female|unknown)$", gender.toLowerCase())) {
                throw new CustomerException("Information is not correct by format('Male' or 'Female' or 'Unknown')");
            }
        }catch (CustomerException e) {
            System.out.println(e.getMessage());
        }
        return Pattern.matches("^(male|female|unknown)$", gender.toLowerCase());
    }
}
