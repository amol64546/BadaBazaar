package com.BadaBazaar.BadaBazaar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
@EnableDiscoveryClient
@RefreshScope
public class BadaBazaarApplication {

	public static void main(String[] args) {
		SpringApplication.run(BadaBazaarApplication.class, args);
	}

}
