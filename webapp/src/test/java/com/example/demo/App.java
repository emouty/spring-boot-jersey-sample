package com.example.demo;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.ext.QueryParamStyle;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URI;

import static java.util.Objects.requireNonNull;

public class App implements BeforeAllCallback, ParameterResolver {

    Integer port;

    @Override
    public void beforeAll(ExtensionContext context) {
        ApplicationContext springContext = SpringExtension.getApplicationContext(context);
        port = Integer.valueOf(requireNonNull(springContext.getEnvironment()
                .getProperty("local.server.port")));
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return App.class.isAssignableFrom(parameterContext.getParameter().getType());
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return this;
    }

    private RestClientBuilder clientBuilder() {
        return RestClientBuilder.newBuilder()
                .queryParamStyle(QueryParamStyle.COMMA_SEPARATED)
                .property("microprofile.rest.client.disable.default.mapper", true)
                .baseUri(URI.create("http://localhost:%s".formatted(port)));
    }

    public UserResource userResource() {
        return clientBuilder().build(UserResource.class);
    }
}
