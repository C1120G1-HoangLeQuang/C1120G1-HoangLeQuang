package ngay_5_access_modifier.thuc_hanh;

public class TestStaticMethod {
    public static void main(String[] args) {
        StaticMethod.change();
        StaticMethod student1 = new StaticMethod(123, "Levi - ");
        StaticMethod student2 = new StaticMethod(456, "Jean - ");
        StaticMethod student3 = new StaticMethod(789, "Sasha - ");
        student1.display();
        student2.display();
        student3.display();
    }
}
