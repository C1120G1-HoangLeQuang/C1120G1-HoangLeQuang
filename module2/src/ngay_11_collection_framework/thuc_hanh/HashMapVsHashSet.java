package ngay_11_collection_framework.thuc_hanh;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapVsHashSet {
    public static void main(String[] args) {
        Student student1 = new Student("Erwin", 30, "Germany");
        Student student2 = new Student("Levi", 28, "Germany");
        Student student3 = new Student("Mike", 25, "Germany");
        HashMap<Integer, Student> studentMap = new HashMap<Integer, Student>();
        studentMap.put(1, student1);
        studentMap.put(2, student2);
        studentMap.put(3, student3);
        studentMap.put(4, student1);
        for (Map.Entry<Integer, Student> studentEntry : studentMap.entrySet()) {
            System.out.println(studentEntry.toString());
        }
        System.out.println("============");
        Set<Student> students = new HashSet<Student>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student1);
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}
