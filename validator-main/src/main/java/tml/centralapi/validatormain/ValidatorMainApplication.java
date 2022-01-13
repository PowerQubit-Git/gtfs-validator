package tml.centralapi.validatormain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import tml.centralapi.validatormain.services.FileStorageService;

import javax.annotation.Resource;

@SpringBootApplication
@EnableMongoRepositories
public class ValidatorMainApplication implements CommandLineRunner {
    @Resource
    FileStorageService storageService;

    public static void main(String[] args) {
        SpringApplication.run(ValidatorMainApplication.class, args);
    }

    @Override
    public void run(String... arg) throws Exception {
        storageService.deleteAll();
        storageService.init();
    }

}


