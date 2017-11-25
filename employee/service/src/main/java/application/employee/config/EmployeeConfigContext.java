package application.employee.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import platform.persistence.mongo.MongoConfigContext;

/**
 * Created by admin on 2017/11/18.
 */
@Configuration
@EnableMongoRepositories({"application.employee.model"})
@ComponentScan({"application.employee"})
@Import({MongoConfigContext.class})
@PropertySource({"classpath:employee-service.properties"})
public class EmployeeConfigContext
{
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
    {
        PropertySourcesPlaceholderConfigurer propConfigurer = new PropertySourcesPlaceholderConfigurer();
        propConfigurer.setLocalOverride(true);
        return propConfigurer;
    }
}
