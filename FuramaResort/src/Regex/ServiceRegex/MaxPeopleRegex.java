package Regex.ServiceRegex;

import java.util.regex.Pattern;

public class MaxPeopleRegex {
    public static boolean checkMaxPeople(int maxPeople) {
        String maxPeopleConvert = Integer.toString(maxPeople);
        if (!Pattern.matches("^([1-9]{1}|[1][0-9])$", maxPeopleConvert)) {
            System.out.println("Error! Enter again!");
        }
        return Pattern.matches("^([1-9]{1}|[1][0-9])$", maxPeopleConvert);
    }
}
