package ngay_9_danh_sach.bai_tap.LinkedList;

public class TestLinkedList {
    public static void main(String[] args) {
        class Student {
            private int id;
            private String name;

            public Student() {
            }

            public Student(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
        LinkedList<Student> studentLinkedList = new LinkedList<>();
        Student student1 = new Student(1, "Quang");
        Student student2 = new Student(2, "Hoang");
        Student student3 = new Student(3, "Hang");
        Student student4 = new Student(4, "Tinh");
        Student student5 = new Student(5, "Trung");
        studentLinkedList.addFirst(student1);
        studentLinkedList.addFirst(student2);
        studentLinkedList.addLast(student5);
        studentLinkedList.add(3, student3);
        LinkedList<Student> cloneLinkedList = studentLinkedList.clone();
        for (int i = 0; i < cloneLinkedList.size1(); i++) {
            Student student = (Student) cloneLinkedList.get(i);
            System.out.println(student.getName());
        }
        for (int i = 0; i < studentLinkedList.size1(); i++) {
            Student student = (Student) studentLinkedList.get(i);
            System.out.println(student.getName());
        }
    }
}
