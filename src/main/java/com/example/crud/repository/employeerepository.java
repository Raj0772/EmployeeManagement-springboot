package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.model.employee;

@Repository
public interface employeerepository extends JpaRepository<employee,Long>{

}
