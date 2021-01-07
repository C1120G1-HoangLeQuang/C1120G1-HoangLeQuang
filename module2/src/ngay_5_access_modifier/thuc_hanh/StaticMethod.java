package ngay_5_access_modifier.thuc_hanh;

public class StaticMethod {
    private int id;
    private String name;
    private static String college = "StJohn University";

    public StaticMethod(int id, String name) {
        this.id = id;
        this.name = name;
    }
    static void change() {
        college = "Erwin University";
    }
    void display() {
        System.out.println("id: " + this.id + " - " + " name: " + this.name + college);
    }
}
