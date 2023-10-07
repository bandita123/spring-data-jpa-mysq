package com.mkyong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class StartApplication{

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

//    @Override
//    public void run(String... args) {
//
//        log.info("StartApplication...");
//
//        repository.save(new Book("Java234"));
//        repository.save(new Book("Node567"));
//        repository.save(new Book("Python789"));

//        System.out.println("\nfindAll()");
//        repository.findAll().forEach(x -> System.out.println(x));
//
//        System.out.println("\nfindById(1L)");
//        repository.findById(1l).ifPresent(x -> System.out.println(x));
//
//        System.out.println("\nfindByName('Node')");
//        repository.findByName("Node").forEach(x -> System.out.println(x));
//
//    }

}