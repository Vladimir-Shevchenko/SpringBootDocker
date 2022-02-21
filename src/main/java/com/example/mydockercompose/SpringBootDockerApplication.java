package com.example.mydockercompose;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@Slf4j
@SpringBootApplication
public class SpringBootDockerApplication {

	public static void main(String[] args) {
		Map<String, String> n = System.getenv();
		n.forEach((k,v)->log.info("{} - {}",k,v));
		SpringApplication.run(SpringBootDockerApplication.class, args);
	}

}
