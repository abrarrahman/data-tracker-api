package com.abrarrahman.dataTrackerApi.config;

import com.abrarrahman.dataTrackerApi.model.Task;
import com.abrarrahman.dataTrackerApi.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TaskRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Task("Call someone i don't want to call", "This is a part of life that you must go through.")));
            log.info("Preloading " + repository.save(new Task("Fix something", "Something always needs fixing and you are the one who needs to do it.")));
        };
    }
}