package ngay_10_stack_queue.baif_tap;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class CountElementInMap {
    public static void checkTree(String str){
        TreeMap<String, Integer> tree = new TreeMap<String, Integer>();
        String[] array = str.split(" ");
        for (String word: array) {
            if (!tree.containsKey(word)) {
                tree.put(word, 1);
            } else {
                tree.put(word, tree.get(word) + 1);
            }
        }
        show(tree);
    }
    public static void show(TreeMap tree) {
        Set<String> keySet = tree.keySet();
        for (String key : keySet) {
            System.out.println(key + " appear " + tree.get(key) + " time");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string: ");
        String input;
        input = scanner.nextLine();
        checkTree(input);
    }
}
