package com.cluo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableDiscoveryClient
@SpringBootApplication
public class HmilyAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmilyAccountApplication.class, args);
	}

}
