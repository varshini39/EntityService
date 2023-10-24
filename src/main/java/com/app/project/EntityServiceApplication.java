package com.app.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class EntityServiceApplication {
	
	// Need to add this project as local maven project for entity reference
	// mvn clean install
	// mvn install:install-file -Dfile=./target/entity-service-1.0.0.jar -DgroupId=com.app.project -DartifactId=entity-service -Dversion=1.0.0 -Dpackaging=jar
	public static void main(String[] args) {
		SpringApplication.run(EntityServiceApplication.class, args);
	}
	
}
