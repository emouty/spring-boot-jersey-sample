package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.util.stream.Collectors.joining;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        System.out.println("digma env = " + System.getenv("MANAGEMENT_OPENTELEMETRY_RESOURCE-ATTRIBUTES_digma_environment"));
        var env = System.getenv().entrySet()
                .stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(joining(",\n"));
        System.out.println("**********************************");
        System.out.println("**********************************");
        System.out.println("**********  ENV  *****************");
        System.out.println(env);
        SpringApplication.run(DemoApplication.class, args);
    }

}
