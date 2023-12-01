package com.example.datajpa;

import com.example.datajpa.Entities.*;
import com.example.datajpa.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataJpaApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository,
                                        IdCardRepository idCardRepository,
                                        TeacherRepository teacherRepository,
                                        CoursesRespository coursesRespository,
                                        StoreRepository storeRepository,
                                        ProductRepository productRepository) {

        return args -> {
            //OnetoOneMapping(idCardRepository);
            //One2manyMany2one(teacherRepository);
            //Many2Many(storeRepository, productRepository);




        };
    }


    public void OnetoOneMapping(IdCardRepository idCardRepository) {
        Student student = new Student();
        student.setName("Jack");

        IdCard id = new IdCard();
        id.setAddress("City3");
        id.setStudent(student);
        idCardRepository.save(id);
    }

    public void One2manyMany2one(TeacherRepository teacherRepository) {
        //This the better approach to save data for
        //One to many and many-to-one relationship
        Teacher teacher = new Teacher();
        teacher.setName("Oggy");
        teacher.addCourse(new Courses("Java"));
        teacher.addCourse(new Courses("c++"));
        teacher.addCourse(new Courses("C#"));
        teacherRepository.save(teacher);

        /*
         *
         * Another approach is
         * first find the teacher in DB get its id
         * create the course objects with different course value
         * then for each couses object set the teacher instance
         * and the save the courses using course repository
         *
         * Teacher teach = teacherRepository.findById(1);
         * Course course = new Course("Ruby");
         * couser.setTeacher(teach);
         * Course course2 = new Course("python");
         * course2.setTeacher("teach");
         * couserRepository.save(course);
         * couserRepository.save(course2);
         *
         * */
    }

    public void Many2Many(StoreRepository storeRepository,ProductRepository productRepository){
        Product p11 =  productRepository.findByName("np12").get();
        List<Product> products = new ArrayList<>();
        products.add(p11);
        Store st  = new Store();
        st.setName("new Store");
        st.setProduct(products);
        storeRepository.save(st);
    }
}
