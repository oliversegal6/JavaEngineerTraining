package application.employee.api;

import application.employee.model.Employee;
import jdk.nashorn.internal.objects.annotations.Getter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by admin on 2017/11/25.
 */
@Path("/employee")
public interface EmployeeServiceInterface
{
    @GET
    @Path("/employees")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Employee> getEmployees();

    @POST
    @Path("/addEmployee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addEmployee(Employee employee);
}
