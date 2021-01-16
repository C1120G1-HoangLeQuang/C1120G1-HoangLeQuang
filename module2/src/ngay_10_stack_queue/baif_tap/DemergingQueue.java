package ngay_10_stack_queue.baif_tap;

import java.security.spec.NamedParameterSpec;
import java.util.*;

public class DemergingQueue {
    public static void main(String[] args) {
        StudentGym students1 = new StudentGym(1, "Hoang",new Date(95, Calendar.OCTOBER,17),true);
        StudentGym students2 = new StudentGym(2, "Quang",new Date(93, Calendar.NOVEMBER,18),true);
        StudentGym students3 = new StudentGym(3, "Van",new Date(96, Calendar.DECEMBER,1),false);
        StudentGym students4 = new StudentGym(4, "Vi",new Date(92, Calendar.AUGUST,20),false);
        StudentGym students5 = new StudentGym(5, "Thuan",new Date(97, Calendar.MARCH,30),true);
        Queue<StudentGym> NAM = new PriorityQueue<StudentGym>();
        Queue<StudentGym> NU = new PriorityQueue<StudentGym>();
        List<StudentGym> list = new ArrayList<>();
        list.add(students1);
        list.add(students2);
        list.add(students3);
        list.add(students4);
        list.add(students5);
        System.out.println("Pre - list: ");
        for (StudentGym studentGym : list) {
            if (!studentGym.isMale()) {
                NU.add(studentGym);
            } else {
                NAM.add(studentGym);
            }
            System.out.println(studentGym);
        }
        System.out.println("After - list: ");
        List<StudentGym> newStudents = new ArrayList<>();
        newStudents.addAll(NU);
        newStudents.addAll(NAM);
        for (StudentGym studentGym1: newStudents) {
            System.out.println(studentGym1);
        }
    }
}
