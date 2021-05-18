package com.example.demo.repository;

import com.example.demo.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    @Query(value = "select * from project " +
            "where nameStudent like %?1% and nameTeacher like %?2%", nativeQuery = true)
    List<Project> searchByStudent(String student, String teacher);

    @Query(value = "select * from project " +
            "where nameTeacher like %?1%", nativeQuery = true)
    List<Project> searchByTeacher(String teacher);
}
