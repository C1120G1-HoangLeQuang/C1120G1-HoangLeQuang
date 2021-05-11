package Regex;

import java.util.regex.Pattern;

public class YearRegex {
    public static boolean yearRegex(String year) {
        if (!Pattern.matches("^[\\d]{4}$", year)) {
            System.out.println("Year have to follow to the format(XXXX)");
        }
        return Pattern.matches("^[\\d]{4}$", year);
    }
}
