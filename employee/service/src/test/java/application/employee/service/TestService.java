package application.employee.service;

import application.employee.config.EmployeeConfigContext;
import application.employee.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collection;

/**
 * Created by admin on 2017/11/18.
 */
public class TestService
{
    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(EmployeeConfigContext.class);
        EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
        /*Employee employee = new Employee();
        employee.setCode("E01");
        employee.setName("Jim");*/
        Collection<Employee> employees = employeeService.getEmployees();
        for(Employee employee : employees)
        {
            System.out.println(employee.getId());
            System.out.println(employee.getCode());
            System.out.println(employee.getName());
        }
    }
}
