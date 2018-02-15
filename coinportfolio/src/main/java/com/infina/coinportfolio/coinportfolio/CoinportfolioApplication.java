package com.infina.coinportfolio.coinportfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("file:conf/db.properties")
@SpringBootApplication
public class CoinportfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoinportfolioApplication.class, args);
	}
}
