package com.java.exchangeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExchangeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeServerApplication.class, args);
		System.out.println("Exchange GRPC Server is running...");
	}

}
