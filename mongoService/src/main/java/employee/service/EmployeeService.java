package employee.service;

import employee.model.Employee;
import employee.model.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2017/11/18.
 */
@Service
public class EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    public void addEmployee(Employee employee)
    {
        employeeRepository.save(employee);
    }
}
