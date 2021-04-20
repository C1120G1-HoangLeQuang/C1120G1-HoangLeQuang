package com.example.casestudy.model.employee;

import javax.persistence.*;
import java.util.List;

@Entity(name = "positions")
@Table
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id", nullable = false)
    private Integer positionId;
    @Column(name = "position_name", nullable = false)
    private String positionName;

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Position() {
    }

    public Position(String positionName, List<Employee> employees) {
        this.positionName = positionName;
        this.employees = employees;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
