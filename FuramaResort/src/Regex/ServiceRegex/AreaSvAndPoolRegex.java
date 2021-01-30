package Regex.ServiceRegex;

import java.util.regex.Pattern;

public class AreaSvAndPoolRegex {

    public static boolean checkAre(float area) {
        String areaConvert = Float.toString(area);
        if (!Pattern.matches("^(([3-9][0-9]{1,}.[0-9]{1,})|([0-9][1-9]{1,}[0-9]{1}.[0-9]{1,}))$", areaConvert)) {
            System.out.println("Error! Enter again!");
        }
        return Pattern.matches("^(([3-9][0-9]{1,}.[0-9]{1,})|([0-9][1-9]{1,}[0-9]{1}.[0-9]{1,}))$", areaConvert);
    }
}
