package com.xyz.model;

import com.xyz.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2017-11-18.
 */

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{
    
}
