package breve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("breve")

public class BreveApplication {
	public static void main(String[] args) {
		SpringApplication.run(BreveApplication.class, args);
	}

}

