package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGateWayApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(ApiGateWayApplication.class,args);
    }

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(predicateSpec -> predicateSpec
                        .path("/api/v1/coupons/**")
                        .uri("lb://DISCOUNT"))
                .route(predicateSpec -> predicateSpec
                        .path("/api/v1/products/**")
                        .uri("lb://PRODUCT"))
                .route(predicateSpec -> predicateSpec
                        .path("/EUREKA/**")
                        .uri("http://localhost:8761"))
                .build();

    }
}
