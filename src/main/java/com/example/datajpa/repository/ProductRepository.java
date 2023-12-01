package com.example.datajpa.repository;

import com.example.datajpa.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {


    Optional<Product> findByName(String name);
}
