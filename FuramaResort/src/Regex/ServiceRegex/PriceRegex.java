package Regex.ServiceRegex;

import java.util.regex.Pattern;

public class PriceRegex {
    public static boolean checkPrice(float price) {
        String priceConvert = Float.toString(price);
        if (!Pattern.matches("^[0-9]{1,}.[0-9]{1,}$", priceConvert)) {
            System.out.println("Error! Enter again!");
        }
        return Pattern.matches("^[0-9]{1,}.[0-9]{1,}$", priceConvert);
    }
}
