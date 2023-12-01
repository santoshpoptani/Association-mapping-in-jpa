package com.example.datajpa.repository;

import com.example.datajpa.Entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store,Integer> {
}
