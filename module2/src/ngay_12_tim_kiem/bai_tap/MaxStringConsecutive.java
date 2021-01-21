package ngay_12_tim_kiem.bai_tap;

import java.util.LinkedList;
import java.util.Scanner;

public class MaxStringConsecutive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter String: ");
        String string = scanner.nextLine();
        LinkedList<Character> consecutive = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(j) > list.getLast()) {
                    list.add(string.charAt(j));
                } else {
                    break;
                }
            }
            if (list.size() > consecutive.size()) {
                consecutive.clear();
                consecutive.addAll(list);
            }
            list.clear();
        }
        for (Character character: consecutive) {
            System.out.print(character);
        }
    }
}
