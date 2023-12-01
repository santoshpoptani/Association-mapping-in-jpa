package com.example.datajpa.repository;

import com.example.datajpa.Entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

}
