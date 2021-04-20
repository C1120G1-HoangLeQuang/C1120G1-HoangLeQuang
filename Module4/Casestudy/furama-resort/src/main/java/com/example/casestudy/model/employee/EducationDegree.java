package com.example.casestudy.model.employee;

import javax.persistence.*;
import java.util.List;

@Entity(name = "education_degree")
@Table
public class EducationDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_degree_id", nullable = false)
    private Integer EduDegreeId;
    @Column(name = "education_degree_name", nullable = false)
    private String EduDegreeName;

    @OneToMany(mappedBy = "educationDegree", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public EducationDegree() {
    }

    public EducationDegree(String eduDegreeName, List<Employee> employees) {
        EduDegreeName = eduDegreeName;
        this.employees = employees;
    }

    public Integer getEduDegreeId() {
        return EduDegreeId;
    }

    public void setEduDegreeId(Integer eduDegreeId) {
        EduDegreeId = eduDegreeId;
    }

    public String getEduDegreeName() {
        return EduDegreeName;
    }

    public void setEduDegreeName(String eduDegreeName) {
        EduDegreeName = eduDegreeName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
