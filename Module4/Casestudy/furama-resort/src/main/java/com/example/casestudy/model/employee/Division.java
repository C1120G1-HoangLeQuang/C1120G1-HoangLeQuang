package com.example.casestudy.model.employee;

import javax.persistence.*;
import java.util.List;

@Entity(name = "division")
@Table
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id", nullable = false)
    private Integer divisionId;
    @Column(name = "division_name", nullable = false)
    private String divisionName;

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Division() {
    }

    public Division(String divisionName, List<Employee> employees) {
        this.divisionName = divisionName;
        this.employees = employees;
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
