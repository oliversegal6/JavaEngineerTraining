package com.xyz.service;

import com.xyz.config.MongoConfigContext;
import com.xyz.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by admin on 2017-11-18.
 */
public class EmployeeServiceTest {
    public static void main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MongoConfigContext.class);
        EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
        Employee employee = new Employee();
        employee.setTitle("E01");
        employee.setName("Jacky");
        employeeService.addEmployee(employee);
    }
}
