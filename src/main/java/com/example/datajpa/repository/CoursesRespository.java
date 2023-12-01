package com.example.datajpa.repository;

import com.example.datajpa.Entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRespository extends JpaRepository<Courses,Integer> {
}
