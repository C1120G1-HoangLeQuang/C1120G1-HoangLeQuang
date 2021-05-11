package Regex;

import java.util.regex.Pattern;

public class LicensePlateRegex {

    public static boolean CarLicenseRegex(String carLicense) {
        if (!Pattern.matches("^[\\d]{2}[AB]-[\\d]{3}.[\\d]{2}$", carLicense)) {
            System.out.println("It is not match with format(XX'A|B'-XXX.XX)");
        }
        return Pattern.matches("^[\\d]{2}[AB]-[\\d]{3}.[\\d]{2}$", carLicense);
    }

    public static boolean TruckLicenseRegex(String truckLicense) {
        if (!Pattern.matches("^[\\d]{2}[C]-[\\d]{3}.[\\d]{2}$", truckLicense)) {
            System.out.println("It is not match with format(XXC-XXX.XX))");
        }
        return Pattern.matches("^[\\d]{2}[C]-[\\d]{3}.[\\d]{2}$", truckLicense);
    }

    public static boolean MotorbikeLicenseRegex(String motorLicense) {
        if (!Pattern.matches("^[\\d]{2}-[A-Z]([A-Z]|[0-9])-[\\d]{3}.[\\d]{2}$", motorLicense)) {
            System.out.println("It is not match with format(XX-YZ-XXX.XX)");
        }
        return Pattern.matches("^[\\d]{2}-[A-Z]([A-Z]|[0-9])-[\\d]{3}.[\\d]{2}$", motorLicense);
    }
}
