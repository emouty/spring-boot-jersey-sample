package com.example.demo;

import jakarta.servlet.ServletContext;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import static java.util.Objects.requireNonNull;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(@Context ServletContext context) {
        registerResources(context);
//        register(new ObservationRequestEventListener(observationRegistry(),"my-metric"));
    }

    //
//    @Bean
//    ObservationRegistry observationRegistry() {
//        return ObservationRegistry.create();
//    }
    protected void registerResources(ServletContext context) {
        WebApplicationContext webAppContext = requireNonNull(WebApplicationContextUtils.getWebApplicationContext(context));
        webAppContext.getBeansWithAnnotation(Path.class).forEach((name, resource) -> register(resource.getClass()));
    }
}
