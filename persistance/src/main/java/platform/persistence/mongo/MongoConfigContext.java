package platform.persistence.mongo;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.net.UnknownHostException;

/**
 * Created by admin on 2017/11/18.
 */
@Configuration
public class MongoConfigContext
{
    @Value("${mongodb-server}")
    private String serverHost;

    @Value("${mongodb-dbname}")
    private String defaultDbName;

    @Bean
    public MongoDbFactory mongoDbFactory() throws UnknownHostException
    {
        return new SimpleMongoDbFactory(new MongoClient(serverHost), defaultDbName);
    }

    @Bean
    public StandardMongoTemplate mongoTemplate() throws UnknownHostException
    {
        return new StandardMongoTemplate(mongoDbFactory());
    }
}
