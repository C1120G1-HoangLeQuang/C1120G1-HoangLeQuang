package Regex.ServiceRegex;

import java.util.regex.Pattern;

public class FloorRegex {
    public static boolean checkFloor(int floor) {
        String floorConvert = Integer.toString(floor);
        if (!Pattern.matches("^([1-9]{1,}|[1-9][0-9])$", floorConvert)) {
            System.out.println("Error! Enter again!");
        }
        return Pattern.matches("^([1-9]{1,}|[1-9][0-9])$", floorConvert);
    }
}
