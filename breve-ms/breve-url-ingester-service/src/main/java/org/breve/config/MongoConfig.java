package org.breve.config;

import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Bean
    public MongoTemplate mongoTemplate() {
        String connectionString = "mongodb://brevemongodb:27017";
        return new MongoTemplate(MongoClients.create(connectionString), "breve-db");
    }
}