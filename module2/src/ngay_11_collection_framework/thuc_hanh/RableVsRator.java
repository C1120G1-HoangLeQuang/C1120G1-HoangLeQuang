package ngay_11_collection_framework.thuc_hanh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RableVsRator {
    public static void main(String[] args) {
        Student student1 = new Student("Brwin", 30, "Germany");
        Student student2 = new Student("Cevi", 28, "Germany");
        Student student3 = new Student("Aike", 25, "Germany");
        List<Student> students = new ArrayList<Student>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        Collections.sort(students);
        for (Student student: students) {
            System.out.println(student.toString());
        }
        System.out.println("=========");
        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(students, ageComparator);
        System.out.println("Comparator by age: ");
        for (Student student: students) {
            System.out.println(student.toString());
        }
    }
}
