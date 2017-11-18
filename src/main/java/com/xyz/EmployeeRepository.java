package com.xyz;

import com.xyz.pojo.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2017-11-18.
 */

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{
    
}
