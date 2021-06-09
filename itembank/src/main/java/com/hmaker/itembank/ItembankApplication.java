package com.hmaker.itembank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ItembankApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItembankApplication.class, args);
	}

}
