package ngay_11_collection_framework.thuc_hanh;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Erwin", 30);
        hashMap.put("Levi", 29);
        hashMap.put("Mike", 28);
        hashMap.put("Thomas", 25);
        System.out.println("Display hashMap: ");
        System.out.println(hashMap);
        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("Display treeMap: ");
        System.out.println(treeMap);
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Erwin", 30);
        linkedHashMap.put("Levi", 29);
        linkedHashMap.put("Mike", 28);
        linkedHashMap.put("Thomas", 25);
        System.out.println("The age for Mike is: " + linkedHashMap.get("Mike"));
    }
}
