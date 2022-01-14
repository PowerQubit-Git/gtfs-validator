package tml.centralapi.validatormain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.annotation.Resource;

@SpringBootApplication
@EnableMongoRepositories
public class ValidatorMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidatorMainApplication.class, args);
    }

}


