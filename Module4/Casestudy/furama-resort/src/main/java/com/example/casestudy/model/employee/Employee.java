package com.example.casestudy.model.employee;

import com.example.casestudy.model.contract.Contract;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity(name = "employee")
@Table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private Integer emId;
    @Column(name = "employee_name", nullable = false)
    private String emName;
    @Column(name = "employee_birthday", nullable = false)
    private String emBirthday;
    @Column(name = "employee_id_card", nullable = false)
    @Pattern(regexp = "^([\\d]{9})|(^[\\d]{12}$)$", message = "Information is not correct by format (xxxxxxxxx) | (xxxxxxxxxxxx)")
    private String emIdCard;
    @Column(name = "employee_salary", nullable = false)
    @Pattern(regexp = "^[0-9]{1,}.[0-9]{1,}$", message = "Salary have to be bigger than 0")
    private String emSalary;
    @Column(name = "employee_phone", nullable = false)
    @Pattern(regexp = "^((090|091)([\\d]{7}))|((\\(\\+84\\))(90([\\d]{7})))|((\\(\\+84\\))(91([\\d]{7})))$",
            message = "Information is not correct by format (090xxxxxxx) or (091xxxxxxx) or ((+84)90xxxxxxx) or ((+84)91xxxxxxx)")
    private String emPhone;
    @Column(name = "employee_email", nullable = false)
    @Email(message = "Information is not correct by format(abc@abc.abc)")
    private String emEmail;
    @Column(name = "employee_address", nullable = false)
    private String emAddress;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false, referencedColumnName = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", nullable = false, referencedColumnName = "education_degree_id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false, referencedColumnName = "division_id")
    private Division division;

    @OneToOne
    @JoinColumn(name = "username", nullable = false, referencedColumnName = "username")
    private User user;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Contract> contracts;


    public Employee() {
    }

    public Employee(String emName, String emBirthday, String emIdCard, String emSalary, String emPhone, String emEmail, String emAddress, Position position, EducationDegree educationDegree, Division division, User user, List<Contract> contracts) {
        this.emName = emName;
        this.emBirthday = emBirthday;
        this.emIdCard = emIdCard;
        this.emSalary = emSalary;
        this.emPhone = emPhone;
        this.emEmail = emEmail;
        this.emAddress = emAddress;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.user = user;
        this.contracts = contracts;
    }

    public Integer getEmId() {
        return emId;
    }

    public void setEmId(Integer emId) {
        this.emId = emId;
    }

    public String getEmName() {
        return emName;
    }

    public void setEmName(String emName) {
        this.emName = emName;
    }

    public String getEmBirthday() {
        return emBirthday;
    }

    public void setEmBirthday(String emBirthday) {
        this.emBirthday = emBirthday;
    }

    public String getEmIdCard() {
        return emIdCard;
    }

    public void setEmIdCard(String emIdCard) {
        this.emIdCard = emIdCard;
    }

    public String getEmSalary() {
        return emSalary;
    }

    public void setEmSalary(String emSalary) {
        this.emSalary = emSalary;
    }

    public String getEmPhone() {
        return emPhone;
    }

    public void setEmPhone(String emPhone) {
        this.emPhone = emPhone;
    }

    public String getEmEmail() {
        return emEmail;
    }

    public void setEmEmail(String emEmail) {
        this.emEmail = emEmail;
    }

    public String getEmAddress() {
        return emAddress;
    }

    public void setEmAddress(String emAddress) {
        this.emAddress = emAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
