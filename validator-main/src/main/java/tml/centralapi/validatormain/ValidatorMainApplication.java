package tml.centralapi.validatormain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

@SpringBootApplication
@EnableMongoRepositories
public class ValidatorMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidatorMainApplication.class, args);
    }

}


