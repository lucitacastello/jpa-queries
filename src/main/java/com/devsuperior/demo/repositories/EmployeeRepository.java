package com.devsuperior.demo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.demo.entities.Employee;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //resolvendo o problema consulta N+1
    @Query(value = "SELECT obj FROM Employee obj JOIN FETCH obj.department")
    // department - atributo da classe
    List<Employee> searchAll();

    // com paginação
    @Query(value = "SELECT obj FROM Employee obj JOIN FETCH obj.department",
            countQuery = "SELECT COUNT(obj) FROM Employee obj JOIN obj.department")
    Page<Employee> searchAll(Pageable pageable);


}
