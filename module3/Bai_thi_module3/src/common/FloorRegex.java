package common;

import java.util.regex.Pattern;

public class FloorRegex {
    public static boolean checkFloor(int floor) {
        String floorConvert = Integer.toString(floor);
        try {
            if (!Pattern.matches("^([1-9]{1,}|[1-9][0-9])$", floorConvert)) {
                throw new CustomerException("Floor have to be Interger number!");
            }
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        }
        return Pattern.matches("^([1-9]{1,}|[1-9][0-9])$", floorConvert);
    }
}
