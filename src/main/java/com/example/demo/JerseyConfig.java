package com.example.demo;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(UserResource.class);
//        register(new ObservationRequestEventListener(observationRegistry(),"my-metric"));
    }

//    @Bean
//    ObservationRegistry observationRegistry() {
//        return ObservationRegistry.create();
//    }
}