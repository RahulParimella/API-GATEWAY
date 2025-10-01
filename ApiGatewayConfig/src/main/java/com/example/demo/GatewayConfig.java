package com.example.demo;

import org.springframework.cloud.gateway.route.RouteLocator;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                // Route for Customer Microservice
                .route("Customer-Microservice", r -> r
                        .path("/api1/**")   // ✅ singular to match controller
                        .uri("http://localhost:8080"))

                // Route for GasBooking Microservice
                .route("GASBOOKING-MICROSERVICE", r -> r
                        .path("/api/**")   // still plural because you updated controller
                        .uri("http://localhost:8081"))

                .build();
    }

}
