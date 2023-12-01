package com.example.datajpa.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String Name;

    @ManyToOne()
    @JoinColumn(name = "teacher_id_fk",referencedColumnName ="id" )
    private Teacher teacher;


    public Courses(String name) {
        Name = name;
    }
}
