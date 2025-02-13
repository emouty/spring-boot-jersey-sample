package com.example.demo;

import io.micrometer.observation.ObservationRegistry;
import org.glassfish.jersey.micrometer.server.ObservationRequestEventListener;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(UserResource.class);
//        register(new ObservationRequestEventListener(observationRegistry(),"my-metric"));
    }
//
//    @Bean
//    ObservationRegistry observationRegistry() {
//        return ObservationRegistry.create();
//    }
}