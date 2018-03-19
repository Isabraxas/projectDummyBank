package com.viridian.dummybank;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.viridian.dummybank.rest.repository")
public class DummybankApplication {

	public static void main(String[] args) {
		SpringApplication.run(DummybankApplication.class, args);
	}
}
