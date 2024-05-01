package ru.gb.homework.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;


@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customLocator(RouteLocatorBuilder builder) {
		return builder.routes()
		.route("book_info", r -> r.path("/books/**").uri("http://localhost:8001/"))
		.route("recipe_book", r->r.path("/recipe/**").uri("http://localhost:8002/"))
		.build();
	}

}
