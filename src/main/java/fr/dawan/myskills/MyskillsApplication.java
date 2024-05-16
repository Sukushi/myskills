package fr.dawan.myskills;

import fr.dawan.myskills.entities.Answer;
import fr.dawan.myskills.entities.Category;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class MyskillsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MyskillsApplication.class, args);
	}
	
}
