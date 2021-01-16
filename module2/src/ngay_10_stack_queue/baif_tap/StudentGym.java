package ngay_10_stack_queue.baif_tap;

import java.util.Date;

public class StudentGym implements Comparable<StudentGym>{
    private int id;
    private String name;
    private Date dateOfBirth;
    private boolean isMale = true;

    public StudentGym() {
    }

    public StudentGym(int id, String name, Date dateOfBirth, boolean isMale) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.isMale = isMale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    @Override
    public int compareTo(StudentGym student) {
        if (this.dateOfBirth.compareTo(student.dateOfBirth) > 0) {
            return 1;
        } else if (this.dateOfBirth.compareTo(student.dateOfBirth) < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "StudentGym{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", isMale=" + isMale +
                '}';
    }
}
