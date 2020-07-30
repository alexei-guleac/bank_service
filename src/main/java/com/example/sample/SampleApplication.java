package com.example.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication()
@ComponentScan(basePackages = {"com.example.sample.*"})
@EnableJpaRepositories
@PropertySources({@PropertySource("classpath:application.properties"),
        // database configuration file
        @PropertySource("classpath:mssql-config-db.properties"),
        // documentation
        @PropertySource("classpath:documentation.properties")})
public class SampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }

}
