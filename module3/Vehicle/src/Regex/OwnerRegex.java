package Regex;

import java.util.regex.Pattern;

public class OwnerRegex {
    public static boolean checkOwner(String owner) {
        if (!Pattern.matches("^[A-Z][a-z]{0,}[\\s|-]?[A-Z][a-z]{0,}[\\s|-]?([A-Z][a-z]{0,})?([\\s|-]?([A-Z][a-z]{0,})?)([\\s|-]?([A-Z][a-z]{0,})?)$", owner)) {
            System.out.println("The first letter of the last name, middle name and first name is not capitalized");
        }
        return Pattern.matches("^[A-Z][a-z]{0,}[\\s|-]?[A-Z][a-z]{0,}[\\s|-]?([A-Z][a-z]{0,})?([\\s|-]?([A-Z][a-z]{0,})?)([\\s|-]?([A-Z][a-z]{0,})?)$", owner);
    }
}
