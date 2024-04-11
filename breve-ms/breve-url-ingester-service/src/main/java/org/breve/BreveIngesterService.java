package org.breve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@ComponentScan("org.breve")
@EnableRedisRepositories(basePackages = "org.breve.repositories")

public class BreveIngesterService {

	public static void main(String[] args) {
		SpringApplication.run(BreveIngesterService.class, args);
	}

}
