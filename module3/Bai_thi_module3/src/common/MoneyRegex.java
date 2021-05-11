package common;

import java.util.regex.Pattern;

public class MoneyRegex {
    public static boolean checkMoney(float money) {
        String moneyConvert = Float.toString(money);
        try {
            if (!Pattern.matches("^[0-9]{1,}.[0-9]{1,}$", moneyConvert)) {
                throw new CustomerException("Money have to be bigger than 0");
            }
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        }
        return Pattern.matches("^[0-9]{1,}.[0-9]{1,}$", moneyConvert);
    }
}
