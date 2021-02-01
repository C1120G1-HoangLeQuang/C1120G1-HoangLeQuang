package Regex.CustomerRegex;

import Exception.CustomerException.CustomerException;
import Exception.CustomerException.GenderException;

import java.util.regex.Pattern;

public class GenderRegex {
    public static boolean checkGender(String gender) {
        try {
            if (!Pattern.matches("^(([M][a][l][e])|([F][e][m][a][l][e])|([U][n][k][n][o][w][n]))$", gender)) {
                throw new CustomerException("Information is not correct by format('Male' or 'Female' or 'Unknown')");
            }
        }catch (CustomerException e) {
            System.out.println(e.getMessage());
        }
        return Pattern.matches("^(([M][a][l][e])|([F][e][m][a][l][e])|([U][n][k][n][o][w][n]))$", gender);
    }
}
