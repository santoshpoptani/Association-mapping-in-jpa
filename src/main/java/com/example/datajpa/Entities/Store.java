package com.example.datajpa.Entities;


import com.example.datajpa.repository.ProductRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String Name;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "stor_product",
            joinColumns = @JoinColumn(name = "store_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id",referencedColumnName = "id")
    )
    private List<Product> product = new ArrayList<>();

    public void addProducts(List<Product> product){
        this.product.addAll(product);
    }


}
