package com.updo.excelfile.repository;

import org.springframework.data.repository.CrudRepository;

import com.updo.excelfile.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
}
