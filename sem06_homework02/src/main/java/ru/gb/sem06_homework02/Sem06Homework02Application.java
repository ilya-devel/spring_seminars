package ru.gb.sem06_homework02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import ru.gb.sem06_homework02.configs.DefaultVariables;

@SpringBootApplication
public class Sem06Homework02Application {
	@Bean
	public RestTemplate template(){
		return new RestTemplate();
	};

	@Bean
	public HttpHeaders headers()
	{
		return new HttpHeaders();
	}

	@Autowired
	private DefaultVariables defaultVariables;


	public static void main(String[] args) {
		SpringApplication.run(Sem06Homework02Application.class, args);
	}

}
