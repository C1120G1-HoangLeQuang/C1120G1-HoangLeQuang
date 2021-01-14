package ngay_9_danh_sach.bai_tap.ArrayList;

public class TestArrayListLibrary {
    public static class Student {
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

    public static void main(String[] args) {
        Student student1 = new Student(1, "Quang");
        Student student2 = new Student(2, "Le");
        Student student3 = new Student(3, "Hoang");
        Student student4 = new Student(4, "Tung");
        Student student5 = new Student(5, "Sang");
        Student student6 = new Student(6, "KHoa");
        ArrayListLibrary<Student> studentArrayList = new ArrayListLibrary<>();
        ArrayListLibrary<Student> newArraylist =new ArrayListLibrary<>();
        studentArrayList.add(student1);
        studentArrayList.add(student2);
        studentArrayList.add(student3);
        studentArrayList.add(student4);
        studentArrayList.add(student5);
     //   studentArrayList.add(student6, 2);
        studentArrayList.size();
        System.out.println(studentArrayList.size());
        System.out.println(studentArrayList.get(2).getName());
        newArraylist = studentArrayList.clone();
        for (int i = 0; i < newArraylist.size(); i++) {
            System.out.println(newArraylist.get(i).getName());
        }
        for (int i = 0; i < studentArrayList.size(); i++) {
            Student student = (Student) studentArrayList.elements[i]; // ep ve kieu Student
            System.out.print(student.getId());
            System.out.println(student.getName());
        }
    }
}
