package com.devsuperior.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.demo.entities.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //resolvendo o problema consulta N+1
    @Query(value = "SELECT obj FROM Product obj JOIN FETCH obj.categories") // categories - atributo da classe
    List<Product> searchAll();


}
