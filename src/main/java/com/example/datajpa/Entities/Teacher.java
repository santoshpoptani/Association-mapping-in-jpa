package com.example.datajpa.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String Name;

    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
    private List<Courses> courses = new ArrayList<>();


    public void addCourse(Courses courses){
        if(!this.courses.contains(courses)){
            this.courses.add(courses);
            courses.setTeacher(this);
        }
    }
}
