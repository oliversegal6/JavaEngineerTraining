package application.employee.api;

import application.employee.model.Employee;

import java.util.Collection;

/**
 * Created by admin on 2017/11/25.
 */
public interface EmployeeServiceInterface
{
    public Collection<Employee> getEmployees();

    public void addEmployee(Employee employee);
}
