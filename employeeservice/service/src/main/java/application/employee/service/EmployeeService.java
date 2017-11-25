package application.employee.service;

import application.employee.api.EmployeeServiceInterface;
import application.employee.model.Employee;
import application.employee.model.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by admin on 2017/11/18.
 */
@Service
public class EmployeeService implements EmployeeServiceInterface
{
    @Autowired
    private EmployeeRepository employeeRepository;

    public void addEmployee(Employee employee)
    {
        employeeRepository.save(employee);
    }

    public Collection<Employee> getEmployees()
    {
        return employeeRepository.findAll();
    }
}
