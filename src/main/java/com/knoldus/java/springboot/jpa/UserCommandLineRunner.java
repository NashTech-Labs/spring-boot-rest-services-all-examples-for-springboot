package com.knoldus.java.springboot.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserCommandLineRunner.class);

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) {

        repository.save(new User("Krishna", "Admin"));
        repository.save(new User("Deepak", "User"));
        repository.save(new User("Akshat", "Admin"));
        repository.save(new User("Uzairr", "User"));

        repository.findAll()
                .forEach(user -> LOGGER.info(user.toString()));

        LOGGER.info("Admin users are.....");
        LOGGER.info("____________________");
        repository.findByRole("Admin")
                .forEach(user -> LOGGER.info(user.toString()));

    }

}
