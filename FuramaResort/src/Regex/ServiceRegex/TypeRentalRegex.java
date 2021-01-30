package Regex.ServiceRegex;

import java.util.regex.Pattern;

public class TypeRentalRegex {
    public static boolean checkTypeRental(String typeRental) {
        if (!Pattern.matches("^[A-Z]{1}[a-z]+$", typeRental)) {
            System.out.println("Error! Enter again!");
        }
        return Pattern.matches("^[A-Z]{1}[a-z]+$", typeRental);
    }
}
