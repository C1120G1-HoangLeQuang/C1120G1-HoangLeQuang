package Models;

public class Employee {
    private int idEmp;
    private String nameEmployee;
    private int age;
    private String addressEmployee;

    public Employee() {
    }

    public Employee(int idEmp, String nameEmployee, int age, String addressEmployee) {
        this.idEmp = idEmp;
        this.nameEmployee = nameEmployee;
        this.age = age;
        this.addressEmployee = addressEmployee;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddressEmployee() {
        return addressEmployee;
    }

    public void setAddressEmployee(String addressEmployee) {
        this.addressEmployee = addressEmployee;
    }

    @Override
    public String toString() {
        return  idEmp+","+
                nameEmployee + "," +
                age + "," +
                addressEmployee;
    }
    public String showInformation() {
        return "Customer {" + "Id: "+ getIdEmp()+ "\n"
                            + "Name: " + getNameEmployee() + "\n"
                            + "Age: " + getAge() + "\n"
                            + "Address: " + getAddressEmployee() + "}";
    }
 }
