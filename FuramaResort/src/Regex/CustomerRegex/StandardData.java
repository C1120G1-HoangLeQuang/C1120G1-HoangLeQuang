package Regex.CustomerRegex;

public class StandardData {
    public String standardized(String standard) {
        String tempString = standard.toLowerCase().trim().replaceAll("\\s+", " ");
        String[] arr = tempString.split("");
        tempString = arr[0].toUpperCase();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].equals(" ")) {
                tempString += arr[i].toUpperCase();
            } else {
                tempString += arr[i];
            }
        }
        return tempString;
    }
}
