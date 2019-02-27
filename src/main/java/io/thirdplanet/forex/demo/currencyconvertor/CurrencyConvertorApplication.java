package io.thirdplanet.forex.demo.currencyconvertor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("io.thirdplanet.forex.demo.currencyconvertor")
@EnableDiscoveryClient
public class CurrencyConvertorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConvertorApplication.class, args);
	}

}
