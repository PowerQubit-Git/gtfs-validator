package tml.centralapi.validatormain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tml.centralapi.validatormain.services.FileStorageService;

import javax.annotation.Resource;

@SpringBootApplication
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


