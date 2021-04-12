package com.example.exercise.repository;

import com.example.exercise.model.MyCounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyCounterRepository extends JpaRepository<MyCounter, Integer> {
}
